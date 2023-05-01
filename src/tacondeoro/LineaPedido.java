/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felis
 */
public class LineaPedido {
    private Articulo articuloLinea;
    private int cantidad;
    private int idPedido;

    public LineaPedido() {
    }

    public LineaPedido(int cantidad) {
        this.cantidad = cantidad;
    }

    public LineaPedido(Articulo articuloLinea, int cantidad) {
        this.articuloLinea = articuloLinea;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticuloLinea() {
        return articuloLinea;
    }

    public void setArticuloLinea(Articulo articuloLinea) {
        this.articuloLinea = articuloLinea;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "LineasPedido{" + "Nombre de articulo=" + articuloLinea.getNombre() + ", cantidad=" + cantidad + '}';
    }  

    public static ArrayList<LineaPedido> obtenerLineasPedido() {
        ResultSet rs = null;
        ResultSet rsArt = null;
        PreparedStatement ps = null;
        PreparedStatement psArt = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<LineaPedido> arrayLP = new ArrayList<>();

        try {
            ps = c.prepareStatement("SELECT * FROM lineaspedido");
            rs = ps.executeQuery();
            while (rs.next()) {
                LineaPedido lp = new LineaPedido();
                lp.setIdPedido(rs.getInt(1));
                lp.setCantidad(rs.getInt(3));
                psArt = c.prepareStatement("SELECT * FROM articulos inner join lineaspedido on articulos.idarticulo=lineaspedido.idarticulo where idarticulo=? LIMIT 1;");
                psArt.setInt(1, rs.getInt(2));
                rsArt = psArt.executeQuery();
                while (rsArt.next()) {
                    if (rsArt.getString(11) != null) {
                        Bolso bo = new Bolso();
                        bo.setIdArticulo(rsArt.getInt(1));
                        bo.setNombre(rsArt.getString(2));
                        bo.setDescripcion(rsArt.getString(4));
                        bo.setMaterial(rsArt.getString(5));
                        bo.setPrecio(rsArt.getFloat(3));
                        bo.setStock(rsArt.getInt(6));
                        bo.setFotografia(rsArt.getString(7));
                        bo.setTipo(rsArt.getString(11));
                        lp.setArticuloLinea(bo);
                    } else if (rsArt.getString(9) != null) {
                        Zapato za = new Zapato();
                        za.setIdArticulo(rsArt.getInt(1));
                        za.setNombre(rsArt.getString(2));
                        za.setDescripcion(rsArt.getString(4));
                        za.setMaterial(rsArt.getString(5));
                        za.setPrecio(rsArt.getFloat(3));
                        za.setStock(rsArt.getInt(6));
                        za.setFotografia(rsArt.getString(7));
                        za.setNumero(rsArt.getFloat(10));
                        za.setTipo(rsArt.getString(9));
                        lp.setArticuloLinea(za);
                    } else {
                        Complemento co = new Complemento();
                        co.setIdArticulo(rsArt.getInt(1));
                        co.setNombre(rsArt.getString(2));
                        co.setDescripcion(rsArt.getString(4));
                        co.setMaterial(rsArt.getString(5));
                        co.setPrecio(rsArt.getFloat(3));
                        co.setStock(rsArt.getInt(6));
                        co.setFotografia(rsArt.getString(7));
                        co.setTallaComplemento(rsArt.getInt(12));
                        lp.setArticuloLinea(co);
                    }
                }
                arrayLP.add(lp);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try {
                rsArt.close();
                psArt.close();
                rs.close();
                ps.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("" + ex.getMessage());
            }
        }
        return arrayLP;
    }

    public static void aniadirLineasDelPedido(Pedido pedido) {
        PreparedStatement ps =null;
        DatabaseConnection db = new DatabaseConnection();
        ArrayList<LineaPedido> lineas = new ArrayList<>();
        Connection c = null;
        try {c = db.getConexion();
            lineas.addAll(pedido.getnLineas());
            for (int i = 0; i < lineas.size(); i++) {
                LineaPedido linea = new LineaPedido();
                linea = lineas.get(i);
                ps = c.prepareStatement("INSERT INTO lineaspedido (idpedido, idarticulo, cantidad) VALUES (?,?,?);");
                ps.setInt(1, pedido.getIdPedido());
                ps.setInt(2, linea.getArticuloLinea().getIdArticulo());
                ps.setInt(3, linea.getCantidad());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println("" + ex.getMessage());
        }finally{
            try {
                ps.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("" + ex.getMessage());
            }
        }
    }

}

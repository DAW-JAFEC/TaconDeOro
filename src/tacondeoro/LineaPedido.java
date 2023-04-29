/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author felis
 */
public class LineaPedido {
    private Articulo articuloLinea;
    private int cantidad;
    private int idArticulo;
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

    @Override
    public String toString() {
        return "LineasPedido{" + "Nombre de articulo=" + articuloLinea.getNombre() + ", cantidad=" + cantidad + '}';
    }  
    
    public static ArrayList<Pedido> obtenerPedidos() {
        Statement s = null;
        Statement ss = null;
        ResultSet rs = null;
        ResultSet rss = null;
        PreparedStatement ps = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Pedido> r = new ArrayList<>();
        ArrayList<LineaPedido> arrayLP = new ArrayList<>();
        LineaPedido lp = new LineaPedido();
        
        try {
            s = c.createStatement();
            rs = s.executeQuery("select * from lineaspedido;");
            while (rs.next()) {
                Pedido pe = new Pedido();
                pe.setIdPedido(rs.getInt(1));
                pe.setFecha(rs.getDate(2));
                pe.setTotalPedido(rs.getFloat(3));
                pe.setIdSocio(rs.getInt(4));
                pe.setIdRuta(rs.getInt(5));
                ps =  c.prepareStatement("select * from lineaspedido where idpedido=?;");
                ps.setInt(1, pe.getIdPedido());
                rss = ps.executeQuery();
                while (rss.next()) {
                    //lp.setArticuloLinea(); //Como coño saco esto
                    lp.setCantidad(rss.getInt(3));
                    arrayLP.add(lp);
                }
                pe.setnLineas(arrayLP);
                r.add(pe);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return r;
    }
     
}

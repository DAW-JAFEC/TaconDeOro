/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author felis
 */
public class Articulo {
    private int idArticulo;
    private String nombre;
    private String descripcion;
    private String material;
    private float precio;
    private int stock;
    private String fotografia;
    private int idCampania;

    public Articulo() {
    }

    public Articulo(int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.material = material;
        this.precio = precio;
        this.stock = stock;
        this.fotografia = fotografia;
    }

    public Articulo(int idArticulo, String nombre, String descripcion, String material, int stock, String fotografia, int idCampania) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.material = material;
        this.stock = stock;
        this.fotografia = fotografia;
        this.idCampania = idCampania;
    }
    
    public Articulo(String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.material = material;
        this.precio = precio;
        this.stock = stock;
        this.fotografia = fotografia;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public int getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }
    

    @Override
    public String toString() {
        return "nombre= " + nombre + ", descripcion= " + descripcion + ", material= " + material + ", precio= " + precio + ", stock= " + stock + ", fotografia= " + fotografia;
    }
    
    public static ArrayList<Articulo> obtenerArticulos() {
        ArrayList<Articulo> r = new ArrayList<>();
        r.addAll(Bolso.obtenerBolsos());
        r.addAll(Complemento.obtenerComplementos());
        r.addAll(Zapato.obtenerZapatos());
        return r;
    }

    public static ArrayList<Articulo> obtenerArticulosDeCampaniaConcreta(int iddecampania) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Articulo> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from articulos inner join campanias on articulos.idcampania = campanias.idcampania where articulos.idcampania=?;");
            ps.setInt(1, iddecampania);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(11) != null) {
                    Bolso bo = new Bolso();
                    bo.setIdArticulo(rs.getInt(1));
                    bo.setNombre(rs.getString(2));
                    bo.setDescripcion(rs.getString(4));
                    bo.setMaterial(rs.getString(5));
                    bo.setPrecio(rs.getFloat(3));
                    bo.setStock(rs.getInt(6));
                    bo.setFotografia(rs.getString(7));
                    bo.setTipo(rs.getString(11));
                    r.add(bo);
                } else if (rs.getString(9) != null) {
                    Zapato za = new Zapato();
                    za.setIdArticulo(rs.getInt(1));
                    za.setNombre(rs.getString(2));
                    za.setDescripcion(rs.getString(4));
                    za.setMaterial(rs.getString(5));
                    za.setPrecio(rs.getFloat(3));
                    za.setStock(rs.getInt(6));
                    za.setFotografia(rs.getString(7));
                    za.setNumero(rs.getFloat(10));
                    za.setTipo(rs.getString(9));
                    r.add(za);
                } else {
                    Complemento co = new Complemento();
                    co.setIdArticulo(rs.getInt(1));
                    co.setNombre(rs.getString(2));
                    co.setDescripcion(rs.getString(4));
                    co.setMaterial(rs.getString(5));
                    co.setPrecio(rs.getFloat(3));
                    co.setStock(rs.getInt(6));
                    co.setFotografia(rs.getString(7));
                    co.setTallaComplemento(rs.getInt(12));
                    r.add(co);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }
    
    public static ArrayList<Articulo> obtenerArticuloDeLineaPedidoConcreta(int iddelarticulo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Articulo> r = new ArrayList<>();
        
        try {
            ps = c.prepareStatement("SELECT * FROM articulos inner join lineaspedido on articulos.idarticulo=lineaspedido.idarticulo where lineaspedido.idpedido=?;");
            ps.setInt(1, iddelarticulo);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(11) != null) {
                    Bolso bo = new Bolso();
                    bo.setIdArticulo(rs.getInt(1));
                    bo.setNombre(rs.getString(2));
                    bo.setDescripcion(rs.getString(4));
                    bo.setMaterial(rs.getString(5));
                    bo.setPrecio(rs.getFloat(3));
                    bo.setStock(rs.getInt(6));
                    bo.setFotografia(rs.getString(7));
                    bo.setTipo(rs.getString(11));
                    r.add(bo);
                } else if (rs.getString(9) != null) {
                    Zapato za = new Zapato();
                    za.setIdArticulo(rs.getInt(1));
                    za.setNombre(rs.getString(2));
                    za.setDescripcion(rs.getString(4));
                    za.setMaterial(rs.getString(5));
                    za.setPrecio(rs.getFloat(3));
                    za.setStock(rs.getInt(6));
                    za.setFotografia(rs.getString(7));
                    za.setNumero(rs.getFloat(10));
                    za.setTipo(rs.getString(9));
                    r.add(za);
                } else {
                    Complemento co = new Complemento();
                    co.setIdArticulo(rs.getInt(1));
                    co.setNombre(rs.getString(2));
                    co.setDescripcion(rs.getString(4));
                    co.setMaterial(rs.getString(5));
                    co.setPrecio(rs.getFloat(3));
                    co.setStock(rs.getInt(6));
                    co.setFotografia(rs.getString(7));
                    co.setTallaComplemento(rs.getInt(12));
                    r.add(co);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return r;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author felis
 */
public class Bolso extends Articulo {
    private String tipo;

    public Bolso() {
    }

    public Bolso(String tipo) {
        this.tipo = tipo;
    }

    public Bolso(String tipo, int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.tipo = tipo;
    }

    public Bolso(String tipo, int idArticulo, String nombre, String descripcion, String material, int stock, String fotografia, int idCampania) {
        super(idArticulo, nombre, descripcion, material, stock, fotografia, idCampania);
        this.tipo = tipo;
    }
    
    public Bolso(String tipo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static ArrayList<Bolso> obtenerBolsos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Bolso> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from articulos where tipo = ?;");
            ps.setString(1, "bolso");
            rs = ps.executeQuery();

            while (rs.next()) {
                Bolso bo = new Bolso();
                bo.setIdArticulo(rs.getInt(1));
                bo.setNombre(rs.getString(2));
                bo.setDescripcion(rs.getString(4));
                bo.setMaterial(rs.getString(5));
                bo.setPrecio(rs.getFloat(3));
                bo.setStock(rs.getInt(6));
                bo.setFotografia(rs.getString(7));
                bo.setTipo(rs.getString(11));
                bo.setIdCampania(rs.getInt(13));
                r.add(bo);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }

    @Override
    public String toString() {
        return "Bolso" + ", Nombre="+ super.getNombre()+", Descripcion="+ super.getDescripcion()+", Material="+ super.getMaterial()+", Precio="+ super.getPrecio()+", Stock="+ super.getStock()+", Fotografia="+ super.getFotografia()+", Tipo=" + tipo;
    }
    
}

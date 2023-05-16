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
public class Zapato extends Articulo {
    private float numero;
    private String tipo;

    public Zapato() {
    }

    public Zapato(float numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, int idArticulo, String nombre, String descripcion, String material, int stock, String fotografia, int idCampania) {
        super(idArticulo, nombre, descripcion, material, stock, fotografia, idCampania);
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.numero = numero;
        this.tipo = tipo;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static ArrayList<Zapato> obtenerZapatos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Zapato> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from articulos;");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(8) != null) {
                    Zapato za = new Zapato();
                    za.setIdArticulo(rs.getInt(1));
                    za.setNombre(rs.getString(2));
                    za.setDescripcion(rs.getString(4));
                    za.setMaterial(rs.getString(5));
                    za.setPrecio(rs.getFloat(3));
                    za.setStock(rs.getInt(6));
                    za.setFotografia(rs.getString(7));
                    za.setNumero(rs.getFloat(9));
                    za.setTipo(rs.getString(8));
                    r.add(za);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }

    @Override
    public String toString() {
        String r = "";
        if (super.getStock() <= 5) {
            r = "Zapato,  nombre= " + super.getNombre() + ", stock= " + super.getStock();
        } else {
            r = "Zapato,  nombre= " + super.getNombre() + ", descripcion= " + super.getDescripcion() + ", material= " + super.getMaterial() + ", precio= " + super.getPrecio() + ", stock= " + super.getStock() + ", fotografia= " + super.getFotografia() + ", tipo= " + tipo + ", numero= " + numero;
        }
        return r;
    }

}

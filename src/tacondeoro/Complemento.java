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
import java.util.logging.Logger;

/**
 *
 * @author felis
 */
public class Complemento extends Articulo {
    private int tallaComplemento;

    public Complemento() {
    }

    public Complemento(int tallaComplemento) {
        this.tallaComplemento = tallaComplemento;
    }

    public Complemento(int tallaComplemento, int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.tallaComplemento = tallaComplemento;
    }

    public Complemento(int tallaComplemento, int idArticulo, String nombre, String descripcion, String material, int stock, String fotografia, int idCampania) {
        super(idArticulo, nombre, descripcion, material, stock, fotografia, idCampania);
        this.tallaComplemento = tallaComplemento;
    }
    
    public Complemento(int tallaComplemento, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.tallaComplemento = tallaComplemento;
    }

    public int getTallaComplemento() {
        return tallaComplemento;
    }

    public void setTallaComplemento(int tallaComplemento) {
        this.tallaComplemento = tallaComplemento;
    }

    public static ArrayList<Complemento> obtenerComplementos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Complemento> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from articulos where tipo = ?;");
            ps.setString(1, "complemento");
            rs = ps.executeQuery();

            while (rs.next()) {
                Complemento co = new Complemento();
                co.setIdArticulo(rs.getInt(1));
                co.setNombre(rs.getString(2));
                co.setDescripcion(rs.getString(4));
                co.setMaterial(rs.getString(5));
                co.setPrecio(rs.getFloat(3));
                co.setStock(rs.getInt(6));
                co.setFotografia(rs.getString(7));
                co.setTallaComplemento(rs.getInt(12));
                co.setIdCampania(rs.getInt(13));
                r.add(co);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }

    @Override
    public String toString() {
        String r = "";
        if(super.getStock()<=5){
            r = "Complemento,  nombre= " + super.getNombre() + ", stock= " + super.getStock();
        }else{
            r = "Complemento,  nombre= " + super.getNombre()+ ", descripcion= " + super.getDescripcion()+ ", material= " + super.getMaterial()+ ", precio= " + super.getPrecio()+ ", stock= " + super.getStock() + ", fotografia= " + super.getFotografia() + ", tallaComplemento= " + tallaComplemento;
        }
        return r;
    }
 

}
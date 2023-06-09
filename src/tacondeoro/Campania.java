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
import javax.swing.JOptionPane;

/**
 *
 * @author felis
 */
public class Campania {
    private int idCampania;
    private int anio;
    private String temporada;
    private ArrayList<Articulo> articulosCampania;

    public Campania() {
    }

    public Campania(int idCampania, int anio, String temporada) {
        this.idCampania = idCampania;
        this.anio = anio;
        this.temporada = temporada;
    }

    public Campania(int anio, String temporada, ArrayList<Articulo> articulosCampania) {
        this.anio = anio;
        this.temporada = temporada;
        this.articulosCampania = articulosCampania;
    }

    public Campania(int anio, String temporada) {
        this.anio = anio;
        this.temporada = temporada;
    }

    public int getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public ArrayList<Articulo> getArticulosCampania() {
        return articulosCampania;
    }

    public void setArticulosCampania(ArrayList<Articulo> articulosCampania) {
        this.articulosCampania = articulosCampania;
    }

    @Override
    public String toString() {
        String r = "";
        if (articulosCampania == null) {
            r = "Año= " + anio + ", Temporada= " + temporada + ", Numero de Articulos= " + 0;
        } else {
            r = "Año= " + anio + ", Temporada= " + temporada + ", Numero de Articulos= " + articulosCampania.size();
        }
        return r;
    }

    public static ArrayList<Campania> obtenerCampanias() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Campania> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from campanias;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Campania cam = new Campania();
                cam.setIdCampania(rs.getInt(1));
                cam.setAnio(rs.getInt(2));
                cam.setTemporada(rs.getString(3));
                cam.setArticulosCampania(Articulo.obtenerArticulosDeCampaniaConcreta(cam.getIdCampania()));
                r.add(cam);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getSQLState());
        } finally {
            try {
                rs.close();
                ps.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return r;
    }

    public static ArrayList<Object> obtenerTemporada(String temporada) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Object> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from articulos inner join campanias on articulos.idcampania = campanias.idcampania where campanias.temporada = ?;");
            ps.setString(1, temporada);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString(10) != null) {
                    Bolso bo = new Bolso();
                    bo.setIdArticulo(rs.getInt(1));
                    bo.setNombre(rs.getString(2));
                    bo.setDescripcion(rs.getString(4));
                    bo.setMaterial(rs.getString(5));
                    bo.setPrecio(rs.getFloat(3));
                    bo.setStock(rs.getInt(6));
                    bo.setFotografia(rs.getString(7));
                    bo.setTipo(rs.getString(10));
                    r.add(bo);
                } else if (rs.getString(8) != null) {
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
                } else {
                    Complemento co = new Complemento();
                    co.setIdArticulo(rs.getInt(1));
                    co.setNombre(rs.getString(2));
                    co.setDescripcion(rs.getString(4));
                    co.setMaterial(rs.getString(5));
                    co.setPrecio(rs.getFloat(3));
                    co.setStock(rs.getInt(6));
                    co.setFotografia(rs.getString(7));
                    co.setTallaComplemento(rs.getInt(11));
                    r.add(co);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }

    public static ArrayList<Object> obtenerAnio(int anio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Object> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from articulos inner join campanias on articulos.idcampania = campanias.idcampania where campanias.anio = ?;");
            ps.setInt(1, anio);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString(10) != null) {
                    Bolso bo = new Bolso();
                    bo.setIdArticulo(rs.getInt(1));
                    bo.setNombre(rs.getString(2));
                    bo.setDescripcion(rs.getString(4));
                    bo.setMaterial(rs.getString(5));
                    bo.setPrecio(rs.getFloat(3));
                    bo.setStock(rs.getInt(6));
                    bo.setFotografia(rs.getString(7));
                    bo.setTipo(rs.getString(10));
                    r.add(bo);
                } else if (rs.getString(8) != null) {
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
                } else {
                    Complemento co = new Complemento();
                    co.setIdArticulo(rs.getInt(1));
                    co.setNombre(rs.getString(2));
                    co.setDescripcion(rs.getString(4));
                    co.setMaterial(rs.getString(5));
                    co.setPrecio(rs.getFloat(3));
                    co.setStock(rs.getInt(6));
                    co.setFotografia(rs.getString(7));
                    co.setTallaComplemento(rs.getInt(11));
                    r.add(co);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }

    public static void crearNuevaCampania(String temporada, int anio) {
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("INSERT INTO campanias (anio, temporada) VALUES (?,?);");
            ps.setInt(1, anio);
            ps.setString(2, temporada);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Campaña añadida correctamente.");
        } catch (SQLException ex) {
            System.err.println("Error al crear campaña: " + ex.getMessage());
        }
    }

    public static void borrarCampania(String temp, int anio) {
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("DELETE FROM campanias where anio=? and temporada=?;");
            ps.setInt(1, anio);
            ps.setString(2, temp);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Campaña borrada correctamente.");
        } catch (SQLException ex) {
            System.err.println("Error al borrar campaña: " + ex.getMessage());
        }
    }
}

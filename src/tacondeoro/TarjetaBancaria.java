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
import javax.swing.JOptionPane;

/**
 *
 * @author felis
 */
public class TarjetaBancaria {
    private String numero;
    private int idSocio;

    public TarjetaBancaria() {
    }

    public TarjetaBancaria(String numero, int idSocio) {
        this.numero = numero;
        this.idSocio = idSocio;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "TarjetaBancaria{" + "Número= " + numero + '}';
    }

    public static ArrayList<TarjetaBancaria> consultarTarjetasUsuario(Socio socio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<TarjetaBancaria> r = new ArrayList<>();
        
        try {
            ps = c.prepareStatement("select * from tarjetas where idsocio = ?;");
            ps.setInt(1, socio.getIdSocio());
            rs = ps.executeQuery();
            while (rs.next()) {
                TarjetaBancaria tb = new TarjetaBancaria();
                tb.setNumero(rs.getString("numero"));
                tb.setIdSocio(rs.getInt("idsocio"));
                r.add(tb);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }
    
    public static void aniadirTarjetaUsuario(TarjetaBancaria tarjeta, Socio socio) {
        PreparedStatement ps = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();

        try {
            ps = c.prepareStatement("insert into tarjetas (numero, idsocio) values (?,?);");
            ps.setString(1,tarjeta.getNumero());
            ps.setInt(2, socio.getIdSocio());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tarjeta añadida correctamente");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

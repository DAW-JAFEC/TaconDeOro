/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class DatabaseConnection implements IFunciones {
    private static final String URL = "jdbc:mysql://localhost:3306/TaconDeOro";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";
    private Connection conexion = null;

    public DatabaseConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        try {
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return conexion;
    }

    @Override
    public void registrarUsuario(Socio socio) {
        try {
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO SOCIOS (nombre, correo, direccion, poblacion, contrasenia, tipo) VALUES (?,?,?,?,?,?);");
            ps.setString(1, socio.getNombre());
            ps.setString(2, socio.getCorreoe());
            ps.setString(3, socio.getDireccion());
            ps.setString(4, socio.getPoblacion());
            ps.setString(5, socio.getContrasenia());
            ps.setString(6, socio.getTipo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Te has registrado correctamente");
        } catch (SQLException ex) {
            System.err.println("Fallo al registrarse: " + ex.getMessage());
        }
    }

    @Override
    public Socio iniciarSesion(String correo, String contrasenia) {
        Socio r = new Socio(0, "", "", "", "", "", null, null);
        try {
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM Socios WHERE correo = ? and contrasenia = ? LIMIT 1;");
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasenia);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                r.setIdSocio(rs.getInt("idsocio"));
                r.setNombre(rs.getString("nombre"));
                r.setCorreoe(rs.getString("correo"));
                r.setDireccion(rs.getString("direccion"));
                r.setPoblacion(rs.getString("poblacion"));
                r.setContrasenia(rs.getString("contrasenia"));
                r.setTipo(rs.getString("tipo"));
                JOptionPane.showMessageDialog(null, "Has iniciado sesion");
            }
        } catch (SQLException ex) {
            System.err.println("" + ex.getMessage());
        }
        return r;
    }

    @Override
    public boolean comprobarCorreoExistente(String correo) {
        boolean r = true;
        try {
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM SOCIOS;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).equals(correo)) {
                    r = false;
                }
            }
        } catch (SQLException ex) {
            System.err.println("Credenciales invalidas: " + ex.getMessage());
        }
        return r;
    }

    @Override
    public void aniadirPedidoBBDD(Pedido pedido) {
        try {
            DatabaseConnection db = new DatabaseConnection();
            Connection c = db.getConexion();
            PreparedStatement ps = c.prepareStatement("INSERT INTO PEDIDOS (fecha, total, idsocio, idruta, estado) VALUES (?,?,?,?,?);");
            ps.setDate(1, new java.sql.Date(pedido.getFecha().getTime()));
            ps.setFloat(2, pedido.getTotalPedido());
            ps.setInt(3, pedido.getIdSocio());
            ps.setInt(4, pedido.getIdRuta());
            ps.setString(5, "pendiente");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tu pedido se ha realizado correctamente");
        } catch (SQLException ex) {
            System.err.println("" + ex.getMessage());
        }
    }

}

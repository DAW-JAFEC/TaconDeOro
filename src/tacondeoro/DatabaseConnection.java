/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;



import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class DatabaseConnection implements IFunciones{
    private static final String URL="jdbc:mysql://localhost:3306/TaconDeOro";
    private static final String USERNAME="root";
    private static final String PASSWORD="toor";
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
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO SOCIOS (nombre, correo, direccion, poblacion, contrasenia, tipo) VALUES (?,?,?,?,?,?)");
            ps.setString(1, socio.getNombre());
            ps.setString(2, socio.getCorreoe());
            ps.setString(3, socio.getDireccion());
            ps.setString(4, socio.getPoblacion());
            ps.setString(5, socio.getContrasenia());
            ps.setString(6, socio.getTipo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Te has registrado correctamente");
        } catch (SQLException ex) {
            System.err.println("Fallo al registrarse: "+ex.getMessage());
        }
    }

    @Override
    public void iniciarSesion() {
        
    }

    @Override
    public void modificarUsuario(Socio socio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

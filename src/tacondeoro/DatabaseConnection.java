/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Arturo
 */
public class DatabaseConnection {
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

}

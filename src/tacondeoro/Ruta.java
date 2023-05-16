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
public class Ruta {
    private int idRuta;
    private ArrayList<String> areaInfluencia;
    private ArrayList<String> diasReparto;
    private ArrayList<Pedido> pedidosDeRuta;
    private int idEmpresa;

    public Ruta() {
    }

    public Ruta(ArrayList<String> areaInfluencia, ArrayList<String> diasReparto, ArrayList<Pedido> pedidosDeRuta) {
        this.areaInfluencia = areaInfluencia;
        this.diasReparto = diasReparto;
        this.pedidosDeRuta = pedidosDeRuta;
    }

    public Ruta(int idRuta, ArrayList<String> areaInfluencia, ArrayList<String> diasReparto, ArrayList<Pedido> pedidosDeRuta, int idEmpresa) {
        this.idRuta = idRuta;
        this.areaInfluencia = areaInfluencia;
        this.diasReparto = diasReparto;
        this.pedidosDeRuta = pedidosDeRuta;
        this.idEmpresa = idEmpresa;
    }

    public ArrayList<String> getAreaInfluencia() {
        return areaInfluencia;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setAreaInfluencia(ArrayList<String> areaInfluencia) {
        this.areaInfluencia = areaInfluencia;
    }

    public ArrayList<String> getDiasReparto() {
        return diasReparto;
    }

    public void setDiasReparto(ArrayList<String> diasReparto) {
        this.diasReparto = diasReparto;
    }

    public ArrayList<Pedido> getPedidosDeRuta() {
        return pedidosDeRuta;
    }

    public void setPedidosDeRuta(ArrayList<Pedido> pedidosDeRuta) {
        this.pedidosDeRuta = pedidosDeRuta;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public static int obtenerIdRutaSocio(ArrayList<Ruta> rutas, Socio usuario) {
        int r = 0;
        Ruta ru = new Ruta();
        String area = "";
        for (int i = 0; i < rutas.size(); i++) {
            ru = rutas.get(i);
            for (int j = 0; j < ru.getAreaInfluencia().size(); j++) {
                area = ru.getAreaInfluencia().get(j);
                if (area.equalsIgnoreCase(usuario.getPoblacion())) {
                    r = ru.getIdRuta();
                }
            }
        }
        return r;
    }

    public static ArrayList<Ruta> obtenerRutas() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Ruta> r = new ArrayList<>();

        try {
            ps = c.prepareStatement("select * from rutas;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Ruta bo = new Ruta();
                bo.setIdRuta(rs.getInt(1));
                bo.setAreaInfluencia(Ruta.formatoArea(rs.getString(2)));
                bo.setDiasReparto(Ruta.formatoDiasReparto(rs.getString(3)));
                bo.setIdEmpresa(rs.getInt(4));
                r.add(bo);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return r;
    }

    private static ArrayList<String> formatoArea(String string) {
        ArrayList<String> r = new ArrayList<>();
        String[] trozos = string.split(", ");
        for (int i = 0; i < trozos.length; i++) {
            r.add(i, trozos[i]);
        }
        return r;
    }

    private static ArrayList<String> formatoDiasReparto(String string) {
        ArrayList<String> r = new ArrayList<>();
        String[] trozos = string.split("-");
        for (int i = 0; i < trozos.length; i++) {
            r.add(i, trozos[i]);
        }
        return r;
    }

    @Override
    public String toString() {
        return "Ruta{" + "areaInfluencia=" + areaInfluencia + ", diasReparto=" + diasReparto + '}';
    }
}

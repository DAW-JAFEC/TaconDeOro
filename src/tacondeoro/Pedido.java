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
import java.util.Date;

/**
 *
 * @author felis
 */
public class Pedido {

    private int idPedido;
    private Date fecha;
    private float totalPedido;
    private ArrayList<LineaPedido> nLineas;
    private int idSocio;
    private int idRuta;
    private String estado;

    public Pedido() {
    }

    public Pedido(Date fecha, float totalPedido, ArrayList<LineaPedido> nLineas) {
        this.fecha = fecha;
        this.totalPedido = totalPedido;
        this.nLineas = nLineas;
    }

    public Pedido(int idPedido, Date fecha, float totalPedido, ArrayList<LineaPedido> nLineas) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.totalPedido = totalPedido;
        this.nLineas = nLineas;
    }

    public Pedido(Date fecha, float totalPedido, ArrayList<LineaPedido> nLineas, int idSocio, int idRuta) {
        this.fecha = fecha;
        this.totalPedido = totalPedido;
        this.nLineas = nLineas;
        this.idSocio = idSocio;
        this.idRuta = idRuta;
    }

    public Pedido(int idPedido, Date fecha, float totalPedido, ArrayList<LineaPedido> nLineas, int idSocio, int idRuta, String estado) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.totalPedido = totalPedido;
        this.nLineas = nLineas;
        this.idSocio = idSocio;
        this.idRuta = idRuta;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public ArrayList<LineaPedido> getnLineas() {
        return nLineas;
    }

    public void setnLineas(ArrayList<LineaPedido> nLineas) {
        this.nLineas = nLineas;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", totalPedido=" + totalPedido + ", nLineas=" + nLineas.toString() + '}';
    }

    public static int obtenerUltimoPedido() {
        ResultSet rs = null;
        PreparedStatement ps = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        int r = 0;
        try {
            ps = c.prepareStatement("select * from pedidos order by idpedido desc limit 1;");
            rs = ps.executeQuery();
            rs.next();
            r=rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return r;
    }

    public static ArrayList<Pedido> obtenerPedidosPendientes(){
        ResultSet rs = null;
        PreparedStatement ps = null;
        DatabaseConnection db = new DatabaseConnection();
        Connection c = db.getConexion();
        ArrayList<Pedido> r = new ArrayList<>();
        try {
            ps = c.prepareStatement("select * from pedidos where estado='pendiente';");
            rs = ps.executeQuery();
            while(rs.next()){
                Pedido pedios = new Pedido();
                pedios.setIdPedido(rs.getInt(1));
                pedios.setFecha(rs.getDate(2));
                pedios.setTotalPedido(rs.getFloat(3));
                pedios.setIdSocio(rs.getInt(4));
                pedios.setIdRuta(rs.getInt(5));
                pedios.setEstado(rs.getString(6));
                pedios.setnLineas(LineaPedido.obtenerLineasPedidoPendiente(rs.getInt(1)));
                r.add(pedios);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return r; 
    }
}

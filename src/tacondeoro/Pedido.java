/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author felis
 */
public class Pedido {
    private int idPedido;
    private Date fecha;
    private double totalPedido;
    private ArrayList<LineaPedido> nLineas;
    
    
    public Pedido() {
    }

    public Pedido( Date fecha, double totalPedido, ArrayList<LineaPedido> nLineas) {
        this.fecha = fecha;
        this.totalPedido = totalPedido;
        this.nLineas = nLineas;
    }

    public Pedido(int idPedido, Date fecha, double totalPedido, ArrayList<LineaPedido> nLineas) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.totalPedido = totalPedido;
        this.nLineas = nLineas;
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

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public ArrayList<LineaPedido> getnLineas() {
        return nLineas;
    }

    public void setnLineas(ArrayList<LineaPedido> nLineas) {
        this.nLineas = nLineas;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.util.Date;

/**
 *
 * @author felis
 */
public class Incidencia {
    private Pedido pedidoIncidente;
    private Ruta rutaIncidente;
    private String descripcion;
    private Date fecha;

    public Incidencia(Pedido pedidoIncidente, Ruta rutaIncidente, String descripcion, Date fecha) {
        this.pedidoIncidente = pedidoIncidente;
        this.rutaIncidente = rutaIncidente;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Incidencia(String descripcion, Date fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Pedido getPedidoIncidente() {
        return pedidoIncidente;
    }

    public void setPedidoIncidente(Pedido pedidoIncidente) {
        this.pedidoIncidente = pedidoIncidente;
    }

    public Ruta getRutaIncidente() {
        return rutaIncidente;
    }

    public void setRutaIncidente(Ruta rutaIncidente) {
        this.rutaIncidente = rutaIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Incidencia{" + "pedidoIncidente=" + pedidoIncidente.getIdPedido() + ", rutaIncidente=" + rutaIncidente.getIdRuta() + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class LineasPedido {
    private Articulos articuloLinea;
    private int cantidad;

    public LineasPedido() {
    }

    public LineasPedido(int cantidad) {
        this.cantidad = cantidad;
    }

    public LineasPedido(Articulos articuloLinea, int cantidad) {
        this.articuloLinea = articuloLinea;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineasPedido{" + "articuloLinea=" + articuloLinea + ", cantidad=" + cantidad + '}';
    }
    
     
    
    
}

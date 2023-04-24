/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class Bolso extends Articulo{
    private String tipo;
     
    //Esto esta incompleto

    public Bolso(String tipo) {
        this.tipo = tipo;
    }

    public Bolso(String tipo, int idArticulo, String nombre, String descripcion, String material, double precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.tipo = tipo;
    }

    public Bolso(String tipo, String nombre, String descripcion, String material, double precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bolso{" + "tipo=" + tipo + '}';
    }
    
}

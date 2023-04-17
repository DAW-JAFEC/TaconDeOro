/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class Zapato extends Articulos{
    private float numero;
    private String tipo;

    public Zapato(float numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, int idArticulo, String nombre, String descripcion, String material, double precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, String nombre, String descripcion, String material, double precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.numero = numero;
        this.tipo = tipo;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Zapato{" + "numero=" + numero + ", tipo=" + tipo + '}';
    }
    
    
}

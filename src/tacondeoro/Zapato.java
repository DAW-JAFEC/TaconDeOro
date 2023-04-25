/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class Zapato extends Articulo {
    private float numero;
    private String tipo;

    public Zapato() {
    }

    public Zapato(float numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.numero = numero;
        this.tipo = tipo;
    }

    public Zapato(float numero, String tipo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
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
        return "Zapato" + ", Nombre="+ super.getNombre()+", Descripcion="+ super.getDescripcion()+", Material="+ super.getMaterial()+", Precio="+ super.getPrecio()+", Stock="+ super.getStock()+", Fotografia="+ super.getFotografia()+", Numero=" + numero + ", Tipo=" + tipo;
    }
    
    
}

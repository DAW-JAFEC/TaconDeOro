/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class Articulo {
    private int idArticulo;
    private String nombre;
    private String descripcion;
    private String material;
    private float precio;
    private int stock;
    private String fotografia;

    public Articulo() {
    }

    public Articulo(int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.material = material;
        this.precio = precio;
        this.stock = stock;
        this.fotografia = fotografia;
    }

    public Articulo(String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.material = material;
        this.precio = precio;
        this.stock = stock;
        this.fotografia = fotografia;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + ", descripcion= " + descripcion + ", material= " + material + ", precio= " + precio + ", stock= " + stock + ", fotografia= " + fotografia;
    }
    
    
}

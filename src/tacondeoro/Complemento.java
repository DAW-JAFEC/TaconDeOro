/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class Complemento extends Articulo {
    private int tallaComplemento;

    public Complemento() {
    }

    public Complemento(int tallaComplemento) {
        this.tallaComplemento = tallaComplemento;
    }

    public Complemento(int tallaComplemento, int idArticulo, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.tallaComplemento = tallaComplemento;
    }

    public Complemento(int tallaComplemento, String nombre, String descripcion, String material, float precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.tallaComplemento = tallaComplemento;
    }

    public int getTallaComplemento() {
        return tallaComplemento;
    }

    public void setTallaComplemento(int tallaComplemento) {
        this.tallaComplemento = tallaComplemento;
    }

    @Override
    public String toString() {
        return "Complemento" + ", Nombre="+ super.getNombre()+", Descripcion="+ super.getDescripcion()+", Material="+ super.getMaterial()+", Precio="+ super.getPrecio()+", Stock="+ super.getStock()+", Fotografia="+ super.getFotografia()+", Talla=" + tallaComplemento;
    }
    
}

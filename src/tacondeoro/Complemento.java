/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class Complemento extends Articulos{
    private String tallaComplemento;

    public Complemento(String tallaComplemento) {
        this.tallaComplemento = tallaComplemento;
    }

    public Complemento(String tallaComplemento, int idArticulo, String nombre, String descripcion, String material, double precio, int stock, String fotografia) {
        super(idArticulo, nombre, descripcion, material, precio, stock, fotografia);
        this.tallaComplemento = tallaComplemento;
    }

    public Complemento(String tallaComplemento, String nombre, String descripcion, String material, double precio, int stock, String fotografia) {
        super(nombre, descripcion, material, precio, stock, fotografia);
        this.tallaComplemento = tallaComplemento;
    }

    public String getTallaComplemento() {
        return tallaComplemento;
    }

    public void setTallaComplemento(String tallaComplemento) {
        this.tallaComplemento = tallaComplemento;
    }

    @Override
    public String toString() {
        return "Complemento{" + "tallaComplemento=" + tallaComplemento + '}';
    }
    
}

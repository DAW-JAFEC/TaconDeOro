/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public class TarjetaBancaria {
    private int idTarjeta;
    private String numero;
    

    public TarjetaBancaria() {
    }

    public TarjetaBancaria(int idTarjeta, String numero) {
        this.idTarjeta = idTarjeta;
        this.numero = numero;
    }
    

    public TarjetaBancaria(String numero) {
        this.numero = numero;
    }

    
    
    public int getIdTarjeta() {
        return idTarjeta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}

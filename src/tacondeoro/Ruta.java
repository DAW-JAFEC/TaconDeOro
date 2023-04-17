/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacondeoro;

import java.util.ArrayList;

/**
 *
 * @author felis
 */
public class Ruta {
    private int idRuta;
    private ArrayList<String> areaInfluencia;
    private ArrayList<String> diasReparto;
    private ArrayList<Pedido> pedidosDeRuta;
    

    public Ruta() {
    }

    public Ruta(ArrayList<String> areaInfluencia, ArrayList<String> diasReparto, ArrayList<Pedido> pedidosDeRuta) {
        this.areaInfluencia = areaInfluencia;
        this.diasReparto = diasReparto;
        this.pedidosDeRuta = pedidosDeRuta;
    }

    public Ruta(int idRuta, ArrayList<String> areaInfluencia, ArrayList<String> diasReparto, ArrayList<Pedido> pedidosDeRuta) {
        this.idRuta = idRuta;
        this.areaInfluencia = areaInfluencia;
        this.diasReparto = diasReparto;
        this.pedidosDeRuta = pedidosDeRuta;
    }

    
    
    public ArrayList<String> getAreaInfluencia() {
        return areaInfluencia;
    }

    public int getIdRuta() {
        return idRuta;
    }
    
    public void setAreaInfluencia(ArrayList<String> areaInfluencia) {
        this.areaInfluencia = areaInfluencia;
    }

    public ArrayList<String> getDiasReparto() {
        return diasReparto;
    }

    public void setDiasReparto(ArrayList<String> diasReparto) {
        this.diasReparto = diasReparto;
    }

    @Override
    public String toString() {
        return "Ruta{" + "areaInfluencia=" + areaInfluencia + ", diasReparto=" + diasReparto + '}';
    }
}
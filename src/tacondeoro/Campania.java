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
public class Campania {
    private int idCampania;
    private int anio;
    private String temporada;
    private ArrayList<Articulo> articulosCampania;

    public Campania() {
    }

    public Campania(int idCampania, int anio, String temporada) {
        this.idCampania = idCampania;
        this.anio = anio;
        this.temporada = temporada;
    }

    public int getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(int idCampania) {
        this.idCampania = idCampania;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public ArrayList<Articulo> getArticulosCampania() {
        return articulosCampania;
    }

    public void setArticulosCampania(ArrayList<Articulo> articulosCampania) {
        this.articulosCampania = articulosCampania;
    }
    
    
}

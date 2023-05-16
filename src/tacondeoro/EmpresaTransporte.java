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
public class EmpresaTransporte {
    private int idEmpresa;
    private String nombre;
    private String CIF;
    private String domicilioFiscal;
    private ArrayList<Ruta> rutas;

    public EmpresaTransporte() {
    }

    public EmpresaTransporte(String nombre, String CIF, String domicilioFiscal, ArrayList<Ruta> rutas) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.domicilioFiscal = domicilioFiscal;
        this.rutas = rutas;
    }

    public EmpresaTransporte(int idEmpresa, String nombre, String CIF, String domicilioFiscal, ArrayList<Ruta> rutas) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.CIF = CIF;
        this.domicilioFiscal = domicilioFiscal;
        this.rutas = rutas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(String domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public ArrayList<Ruta> getRuta() {
        return rutas;
    }

    public void setRuta(ArrayList<Ruta> ruta) {
        this.rutas = ruta;
    }

    @Override
    public String toString() {
        return "EmpresaDeTransporte{" + "nombre=" + nombre + ", CIF=" + CIF + ", domicilioFiscal=" + domicilioFiscal + ", ruta=" + rutas + '}';
    }
}

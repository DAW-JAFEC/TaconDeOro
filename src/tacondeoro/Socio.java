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
public class Socio {
    private int idSocio;
    private String nombre;
    private String correoe;
    private String direccion;
    private String poblacion;
    private String contrasenia;
    private String tipo;
    private ArrayList<TarjetaBancaria> tarjetasSocio;
    private ArrayList<Pedido> pedidosSocio;

    public Socio() {
    }

    public Socio(int idSocio, String nombre, String correoe, String direccion, String poblacion, String contrasenia, ArrayList<TarjetaBancaria> tarjetasSocio, ArrayList<Pedido> pedidosSocio) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.correoe = correoe;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.contrasenia = contrasenia;
        this.tarjetasSocio = tarjetasSocio;
        this.pedidosSocio = pedidosSocio;
    }

    public Socio(String nombre, String correoe, String direccion, String poblacion, String contrasenia, String tipo) {
        this.nombre = nombre;
        this.correoe = correoe;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Socio(String nombre, String correoe, String direccion, String poblacion, String contrasenia, ArrayList<TarjetaBancaria> tarjetasSocio, ArrayList<Pedido> pedidosSocio) {
        this.nombre = nombre;
        this.correoe = correoe;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.contrasenia = contrasenia;
        this.tarjetasSocio = tarjetasSocio;
        this.pedidosSocio = pedidosSocio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    public int getIdSocio() {
        return idSocio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public ArrayList<TarjetaBancaria> getTarjetasSocio() {
        return tarjetasSocio;
    }

    public void setTarjetasSocio(ArrayList<TarjetaBancaria> tarjetasSocio) {
        this.tarjetasSocio = tarjetasSocio;
    }

    public ArrayList<Pedido> getPedidosSocio() {
        return pedidosSocio;
    }

    public void setPedidosSocio(ArrayList<Pedido> pedidosSocio) {
        this.pedidosSocio = pedidosSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
    
    
}

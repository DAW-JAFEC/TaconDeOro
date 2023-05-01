/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tacondeoro;

/**
 *
 * @author felis
 */
public interface IFunciones {
    public void registrarUsuario(Socio socio);
    public Socio iniciarSesion(String correo, String contrasenia);
    public void modificarUsuario(Socio socio);
    public boolean comprobarCorreoExistente(String correo);
    public void aniadirPedidoBBDD(Pedido pedido);
}

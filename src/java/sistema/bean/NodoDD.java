/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bean;

/**
 *
 * @author crist
 */
public class NodoDD {
    private NodoDD Siguiente;
    
    private int cantidad;
    private int precio;
    private Producto Producto;

    public NodoDD(int cantidad, int precio, String codProducto) {
        this.cantidad = cantidad;
        this.precio=precio;
        
        if(web.servicioWeb.ServicioWeb.tablaHash.buscar(codProducto)!=null)
            this.Producto = web.servicioWeb.ServicioWeb.tablaHash.buscar(codProducto);
        else 
            System.out.println("Se ingresa un detalle de un producto que no existe");
        Siguiente = null;
    }

    public NodoDD getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoDD Siguiente) {
        this.Siguiente = Siguiente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Object getProducto() {
        return Producto;
    }

    
}
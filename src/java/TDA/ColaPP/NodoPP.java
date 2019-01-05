/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ColaPP;

/**
 *
 * @author bruno
 */
public class NodoPP {
    private NodoPP Siguiente;
    
    private int cantidad;
    private Object Producto;

    public NodoPP(Object Producto, int cantidad) {
        this.cantidad = cantidad;
        this.Producto = Producto;
        Siguiente = null;
    }

    public NodoPP getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoPP Siguiente) {
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

    public void setProducto(Object Producto) {
        this.Producto = Producto;
    }
    
    
}

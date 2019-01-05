/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ColaCC;

/**
 *
 * @author bruno
 */
public class NodoCC {
    private NodoCC Siguiente;
    
    private int cantidad;
    private Object Producto;

    public NodoCC(Object Producto, int cantidad) {
        this.cantidad = cantidad;
        this.Producto = Producto;
        Siguiente = null;
    }

    public NodoCC getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoCC Siguiente) {
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

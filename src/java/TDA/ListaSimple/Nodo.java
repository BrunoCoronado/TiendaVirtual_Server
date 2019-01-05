/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ListaSimple;

/**
 *
 * @author bruno
 */
public class Nodo {
    private Nodo siguiente;
    
    private String direccion;
    private int envio;
    private int facturacion;
    
    public Nodo(String direccion, int envio, int facturacion){
        this.direccion = direccion;
        this.envio = envio;
        this.facturacion = facturacion;
        siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEnvio() {
        return envio;
    }

    public void setEnvio(int envio) {
        this.envio = envio;
    }

    public int getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(int facturacion) {
        this.facturacion = facturacion;
    }
    
    
}

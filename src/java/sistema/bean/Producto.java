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
public class Producto {
        
    public String codigo;
    public String nombre;
    public String marca;
    public int precio;
    String ruta;
    
    public Producto(String codigo_, String nombre_, String marca, int precio, String ruta){
        this.codigo=codigo_;
        this.nombre=nombre_;
        this.marca=marca;
        this.precio=precio;
        this.ruta=ruta;
    }
    
}

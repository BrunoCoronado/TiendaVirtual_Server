/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.bean;

import TDA.ArbolAVL.NodoAVL;

/**
 *
 * @author crist
 */
public class Factura {
    public int no;
    public String fecha;
    public int total;
    
    //Apuntador al usuario
    public NodoAVL usuario_NodoAVL;
    //Apuntador al detalle
    public Detalle detalle;
    
    public Factura(int no_, String fecha_, int total_, String usuario)//Apuntadores
    {
        this.no=no_;
        this.fecha=fecha_;
        this.total=total_;
        //Apuntador usuario
        this.usuario_NodoAVL=web.servicioWeb.ServicioWeb.arbolAVL.buscar(usuario);
        //Apuntador detalle
        this.detalle=null;
    }
    void agregarDetalle(Detalle det){
        this.detalle=det;
    }
}

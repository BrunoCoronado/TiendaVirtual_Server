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
public class Factura {
    public int no;
    public String fecha;
    public int total;
    //Apuntador al usuario
    //Apuntador al detalle
    public Factura(int no_, String fecha_, int total_)//Apuntadores
    {
        this.no=no_;
        this.fecha=fecha_;
        this.total=total_;
        //Apuntador usuario
        //Apuntador detalle
    }
}

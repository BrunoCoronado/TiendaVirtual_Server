/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servicioWeb;

import TDA.ArbolAVL.ArbolAVL;
import TDA.ArbolAVL.NodoAVL;
import TDA.ArbolB.Btree;
import TDA.TablaHash.TablaHash;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author bruno
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {
    public static ArbolAVL arbolAVL = new ArbolAVL();
    public static TablaHash tablaHash = new TablaHash(10);
    public static Btree arbolB = new Btree(5);
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "nickname") String nickname, @WebParam(name = "contra") String contra) {
        //TODO write your implementation code here:
        boolean r= false;
        NodoAVL aux=web.servicioWeb.ServicioWeb.arbolAVL.buscar(nickname);
        
        if(aux!=null){
            if(contra.equals(aux.getContraseña())){
                r=true;
            }else{
                r=false;
            }
        }else{
            r=false;
        }
        return r;
    }
}

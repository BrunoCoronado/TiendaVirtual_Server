/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servicioWeb;

import TDA.ArbolAVL.ArbolAVL;
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
}

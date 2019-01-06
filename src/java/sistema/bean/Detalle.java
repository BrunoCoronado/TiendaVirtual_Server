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
public class Detalle {

    private NodoDD cabeza = null;

    public NodoDD getCabeza() {
        return cabeza;
    }
    
    public void push(int cantidad, int precio, String codProducto){
        NodoDD nuevo  = new NodoDD(cantidad, precio, codProducto);
        if(cabeza==null){
            cabeza =nuevo;
        }else{
            NodoDD tmp = cabeza;
            while(tmp.getSiguiente() != null){
                tmp = tmp.getSiguiente();
            }
            tmp.setSiguiente(nuevo);
        }
    }
   
    public void pop(){
        if(cabeza!=null)
            cabeza = cabeza.getSiguiente();
    }
    
    public Object peek(){
        if(cabeza!=null)
            return cabeza.getProducto();
        return null;
    }
    
}

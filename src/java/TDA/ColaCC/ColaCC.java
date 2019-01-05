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
public class ColaCC {
    private NodoCC cabeza = null;

    public NodoCC getCabeza() {
        return cabeza;
    }
    
    public void push(Object valor, int cantidad){
        NodoCC nuevo  = new NodoCC(valor, cantidad);
        if(cabeza==null){
            cabeza =nuevo;
        }else{
            NodoCC tmp = cabeza;
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

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
public class ColaPP {
    private NodoPP cabeza = null;

    public NodoPP getCabeza() {
        return cabeza;
    }
    
    public void push(Object valor, int cantidad){
        NodoPP nuevo  = new NodoPP(valor, cantidad);
        if(cabeza==null){
            cabeza =nuevo;
        }else{
            NodoPP tmp = cabeza;
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

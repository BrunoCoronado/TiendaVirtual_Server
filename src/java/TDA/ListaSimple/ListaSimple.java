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
public class ListaSimple {
    private Nodo cabeza = null;

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    public void insertarAlInicio(String valor, int envio, int facturacion){
        Nodo nuevo = new Nodo(valor, envio, facturacion);
        if(cabeza != null){
            Nodo tmp = cabeza;
            cabeza = nuevo;
            cabeza.setSiguiente(tmp);
        }else{
            cabeza = nuevo;
        }
    }
    
    public void mostrar(){
        if(cabeza != null){
            Nodo tmp = cabeza;
            while(tmp!=null){
                    System.out.print(tmp.getDireccion()+"  ");
                    tmp = tmp.getSiguiente();
            }
            System.out.println();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ColaCC;

import sistema.bean.Producto;

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
    
    public String graficar(String nickUsuario, String nodoConexion){
        String codigoGrafico = "";    
        String conexiones = "";
        int i = 0;
        Producto p = null;
        if(cabeza != null){
            p = (Producto)cabeza.getProducto();
            codigoGrafico += "subgraph clusterCPP"+nickUsuario+" {\nnode[shape=record];";
            codigoGrafico += "\ncc"+i+""+nickUsuario+"[label=\"{<n>|<data> "+p.nombre+"\\n"+p.codigo+"\\n"+p.precio+"\\n"+cabeza.getCantidad()+"|<next>}\"];\n";
            i++;
            NodoCC tmp = cabeza.getSiguiente();
            while(tmp != null){
                p = (Producto)tmp.getProducto();
                codigoGrafico += "cc"+i+""+nickUsuario+"[label=\"{<n>|<data> "+p.nombre+"\\n"+p.codigo+"\\n"+p.precio+"\\n"+cabeza.getCantidad()+"|<next>}\"];\n";
                conexiones += "cc"+(i-1)+""+nickUsuario+":next -> cc"+i+""+nickUsuario+":n;\n";
                i++;
                tmp = tmp.getSiguiente();
            }
            return codigoGrafico+conexiones+"}\n";
        }
        return "";
    }
}

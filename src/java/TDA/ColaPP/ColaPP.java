/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ColaPP;

import sistema.bean.Producto;

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
    
    public String graficar(String nickUsuario, String nodoConexion){
        String codigoGrafico = "";    
        String conexiones = "";
        int i = 0;
        Producto p = null;
        if(cabeza != null){
            p = (Producto)cabeza.getProducto();
            codigoGrafico += "subgraph clusterCPP"+nickUsuario+" {\nnode[shape=record];";
            codigoGrafico += "\npp"+i+""+nickUsuario+"[label=\"{<n>|<data> "+p.nombre+"\\n"+p.codigo+"\\n"+p.precio+"|<next>}\"];\n";
            i++;
            NodoPP tmp = cabeza.getSiguiente();
            while(tmp != null){
                p = (Producto)tmp.getProducto();
                codigoGrafico += "pp"+i+""+nickUsuario+"[label=\"{<n>|<data> "+p.nombre+"\\n"+p.codigo+"\\n"+p.precio+"|<next>}\"];\n";
                conexiones += "pp"+(i-1)+""+nickUsuario+":next -> pp"+i+""+nickUsuario+":n;\n";
                i++;
                tmp = tmp.getSiguiente();
            }
            return codigoGrafico+conexiones+"}\n";
        }
        return "";
    }
}

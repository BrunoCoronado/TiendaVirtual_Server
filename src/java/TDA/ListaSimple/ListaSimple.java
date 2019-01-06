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
    
    public String graficar(String nickUsuario, String nodoConexion){
        String codigoGrafico = "";    
        String conexiones = "";
        int i = 0;
        if(cabeza != null){
            codigoGrafico += "subgraph clusterdir"+nickUsuario+" {\nnode[shape=record];";
            codigoGrafico += "\nd"+i+""+nickUsuario+"[label=\"{<n>|<data> "+cabeza.getDireccion()+"\\nEnvio:"+convertirCont(cabeza.getEnvio())+"\\nFacturacion:"+convertirCont(cabeza.getFacturacion())+"|<next>}\"];\n";
            i++;
            Nodo tmp = cabeza.getSiguiente();
            while(tmp != null){
                codigoGrafico += "d"+i+""+nickUsuario+"[label=\"{<n>|<data> "+tmp.getDireccion()+"\\nEnvio:"+convertirCont(tmp.getEnvio())+"\\nFacturacion:"+convertirCont(tmp.getFacturacion())+"|<next>}\"];\n";
                conexiones += "d"+(i-1)+""+nickUsuario+":next -> d"+i+""+nickUsuario+":n;\n";
                i++;
                tmp = tmp.getSiguiente();
            }
            return codigoGrafico+conexiones+"}\n";
        }
        return "";
    }
    
    private String convertirCont(int cont){
        return (cont!=1)?"No":"Si";
    }
}

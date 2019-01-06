/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ArbolB;

import sistema.bean.Factura;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author crist
 */
public class Btree {
         
    NodoBT raiz;//Nodo raiz
    int t;//Grado del arbol
    
    //Dibujar
    File archivo;
    FileWriter fw;
    BufferedWriter bw;
    
    public Btree(int t_){
        this.t=t_;
        this.raiz=null;
    }
    void add(Factura f){
        raiz=agregar(f,raiz);
        System.out.println("___________+++_______________");
    }
    NodoBT agregar(Factura f, NodoBT tmp){
        System.out.println("Ingresando: "+f.no);
        if(tmp==null){
            System.out.println("Arbol vacio");
            //Se aloja el espacio en memoria para el nuevo nodo
            tmp= new NodoBT(t, null);
            //Se agrega el valor 
            tmp.agregar(f);
        }
        else{
            System.out.println("Arbol no  vacio");
            //hoja
            if(tmp.punteros[0]==null){
                System.out.println("No tiene hijos o punteros");
                if(tmp.n<t-1){
                    System.out.println("NO esta lleno");
                    tmp.agregar(f);
                }
                else{
                    System.out.println("Esta lleno");
                    tmp.agregar(f);
                    
                    if(tmp.padre==null){
                        System.out.println("NO tiene padre");
                        NodoBT nuevo= new NodoBT(t, null);
                        nuevo.agregar(tmp.facturas[t/2]);
                        
                        nuevo.punteros[0]= new NodoBT(t, nuevo);
                        nuevo.punteros[1]=new NodoBT(t, nuevo);
                        
                        for(int i=0; i<t/2;i++){
                            nuevo.punteros[0].agregar(tmp.facturas[i]);
                        }
                        for(int j=(t/2)+1; j<t;j++){
                            nuevo.punteros[1].agregar(tmp.facturas[j]);
                        }                        
                        tmp=nuevo;
                    }
                    else{
                        System.out.println("SI tiene padre");
                        System.out.println("Rompimiento recursivo");
                        /*tmp=*/split(tmp);
                        
                    }
                }
            }
            else{
                System.out.println("Tiene hijos o punteros");
                boolean mayor=true;
                int i=0;
                for(i=0; i <tmp.n;i++){
                    if(f.no<tmp.facturas[i].no){
                        System.out.println("Puntero al que ingresa: "+tmp.punteros[i].facturas[0].no);
                        System.out.println("Numero de veces de esto: "+i);
                        tmp.punteros[i]=agregar(f, tmp.punteros[i]);
                        
                        mayor=false;
                        break;
                    }
                }
                if(mayor){
                    tmp.punteros[i]=agregar(f, tmp.punteros[i]);//??
                }
            }
        }
    return tmp;
    }
    /*NodoBT*/void split(NodoBT h){
        System.out.println("*///////////////////*");
        if(h.padre.n<t-1){
            System.out.println("EL padre no esta lleno");
            System.out.println("Se agrega al padre: "+h.padre.facturas[0].no+"El valor medio"+h.facturas[t/2].no);
            h.padre.agregar(h.facturas[t/2]);

            System.out.println("Se crea el nodo para guardar la mitad del otro nodo");
            NodoBT tmp1 = new NodoBT(h.t,h.padre);
            
            h.n = h.t/2;

            //Dividir el contenido
            for (int j = h.t/2+1; j < h.t; j++)
                tmp1.agregar(h.facturas[j]);
            
            //Dividir los punteros
            System.out.print("Se dividen los punteros: ");
            if(h.punteros[0]==null){
                System.out.println("No hay punteros que pasar");
            }
            else{
                System.out.println("Pasando punteros");
                int r=0;
                for (int j =h.t/2+1 ; j < h.t; j++)
                    tmp1.punteros[r] = h.punteros[j]; r++;
            }
            //Quitar los punteros demas en el nodo que se rompe
            for (int j =h.t/2+1 ; j < h.t; j++){
                h.facturas[j]=null;
                h.punteros[j] = null;
            }
            
            System.out.print("Se busca el lugar al que pertencera el nuevo puntero: ");
            int i=0;
            for(i=0; i <h.padre.n;i++){
                if(h.facturas[t/2].no==h.padre.facturas[i].no){
                    break;
                }
            }
            System.out.println(" i: "+i);
                            
            int x=h.padre.n-1;;
            while(x>=0&&x>i){
                h.padre.punteros[x+1]=h.padre.punteros[x];
                x--;
            }
            
            h.padre.punteros[i+1]=tmp1;
            
        }else{
            System.out.println("Rompimiento recursivo");
            NodoBT aux2=h;
            NodoBT aux=h.padre;
            while(aux!=null&&!(aux.n<t-1)){
                System.out.println("Padre disponible:"+h.padre.facturas[0].no);
                aux2=aux;
                aux=aux.padre;
                System.out.println("Entro");
            }
            
            if(aux!=null){
                System.out.println("Necesaria nueva raiz");
                h.padre.agregar(h.facturas[t/2]);
                
                        NodoBT nuevo= new NodoBT(t, null);
                        nuevo.agregar(aux2.facturas[t/2]);

                        nuevo.punteros[0]= new NodoBT(t, nuevo);
                        nuevo.punteros[1]=new NodoBT(t, nuevo);

                        for(int i=0; i<t/2;i++){
                            nuevo.punteros[0].agregar(aux2.facturas[i]);
                        }
                        for(int j=(t/2)+1; j<t;j++){
                            nuevo.punteros[1].agregar(aux2.facturas[j]);
                        }
                        
                        nuevo.punteros[0].punteros[0]=h;
                        h.padre=nuevo.punteros[0];
                
            }
            else{
                h.padre.agregar(h.facturas[t/2]);
                System.out.println("Romper el padre con espacio");
            }
            
        }
        System.out.println("Final del split, se regresa el nodo solo con la mitad");
        System.out.println("*///////////////////*");
        //return h;
    }
    NodoBT nuevaRaiz(NodoBT tmp){
        NodoBT nuevo= new NodoBT(t, null);
        nuevo.agregar(tmp.facturas[t/2]);
                        
        nuevo.punteros[0]= new NodoBT(t, nuevo);
        nuevo.punteros[1]=new NodoBT(t, nuevo);
                        
        for(int i=0; i<t/2;i++){
            nuevo.punteros[0].agregar(tmp.facturas[i]);
        }
        for(int j=(t/2)+1; j<t;j++){
            nuevo.punteros[1].agregar(tmp.facturas[j]);
        }                        
        return nuevo;
    }
    void mostrar(NodoBT tmp){
        if(tmp!=null){
            tmp.mostrar();

            for(int i=0; i<tmp.t;i++){
                mostrar(tmp.punteros[i]);
            }
        }
    }
    public void dibujar()
    {
        System.out.println("Dibujando");
        
            try{
                archivo = new File("D:\\crist\\Documents\\NetBeansProjects\\arbolB\\Reportes\\ArbolB.txt");//Como crear una ruta relativa
                fw = new FileWriter(archivo,true);
                bw= new BufferedWriter(fw);
                
                bw.write("digraph arbolB{\n");
                //contenido
                //bw.write("rankdir=LR;\n");
                bw.write("node[shape=record];\n");
                
                NodosRecursivoso(raiz);
                EnlacesRecursivoso(raiz);

                bw.write("\n}");
                bw.close();
                
                try {
                    //String comando= "dot -Tsvg D:\\crist\\Documents\\NetBeansProjects\\TablaHash\\Reportes\\tablaHashProductos.txt -o D:\\crist\\Documents\\NetBeansProjects\\TablaHash\\Reportes\\tablaHashProductos.svg";
                    //Runtime.getRuntime().exec(comando);
                    //String comando2="D:\\crist\\Documents\\NetBeansProjects\\TablaHash\\Reportes\\tablaHashProductos.svg";
                    //Runtime.getRuntime().exec(comando2);
                } 
                catch (Exception e) {
                    System.out.println("Error: "+e.toString());
                }
            }
            catch(IOException e)
            {
                System.out.println("Error: "+e.toString());

            }
    }
    void NodosRecursivoso(NodoBT tmp){
        try{
            if(tmp!=null){
                bw.write("nodo"+tmp.facturas[0].no+"[label=\"");
                for(int i=0; i<tmp.n;i++){
                    if(i!=tmp.n-1){
                      bw.write(tmp.facturas[i].no+"|");  
                    }
                    else{
                      bw.write(tmp.facturas[i].no+"\"]\n");  
                    }
                    
                }

                for(int i=0; i<tmp.t;i++){
                    NodosRecursivoso(tmp.punteros[i]);
                }
            }
        }
        catch(Exception e){
            System.out.println("Error:"+e.toString());
        }
    }
    void EnlacesRecursivoso(NodoBT tmp) throws IOException{
        //try{
            if(tmp!=null){

                for(int i=0; i<tmp.t;i++){
                    if(tmp.punteros[i]!=null)
                        bw.write("nodo"+tmp.facturas[0].no+"->nodo"+tmp.punteros[i].facturas[0].no+"\n");
                    EnlacesRecursivoso(tmp.punteros[i]);
                }
            }
        //}
        //catch(Exception e){
            //System.out.println("Error: "+e.toString());
        //}
    }
    public Factura buscar(int facturaNo){
        return buscar(facturaNo, raiz);
    }
    public Factura buscar(int facturaNo, NodoBT tmp){
        if(tmp!=null){
            tmp.mostrar();

            for(int i=0; i<tmp.t;i++){
                mostrar(tmp.punteros[i]);
            }
        }
        
        return null;
    }
}

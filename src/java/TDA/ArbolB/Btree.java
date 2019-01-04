/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ArbolB;

import sistema.bean.Factura;

/**
 *
 * @author crist
 */
public class Btree {
     
    NodoBT raiz;//Nodo raiz
    int t;//Grado del arbol
    
    public ArbolB(int t_){
        this.t=t_;
        this.raiz=null;
    }
    void agregar(Factura f){
        raiz=agregar(f,raiz);
    }
    NodoBT agregar(Factura f, NodoBT tmp){
        if(tmp==null){
            //Se aloja el espacio en memoria para el nuevo nodo
            tmp= new NodoBT(t, null);
            //Se agrega el valor 
            tmp.agregar(f);
        }
        else{
            //hoja
            if(tmp.punteros[0]==null){
                if(tmp.n<t-1){
                    tmp.agregar(f);
                }
                else{
                    tmp.agregar(f);
                    System.out.println("agregar f"+f.no);
                    
                    if(tmp.padre==null){
                        
                        NodoBT nuevo= new NodoBT(t, tmp);
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
                        System.out.println("Rompimiento recursivo");
                        tmp=split(tmp);
                        
                    }
                }
            }
            else{
                boolean mayor=true;
                int i=0;
                for(i=0; i <tmp.n;i++){
                    if(f.no<tmp.facturas[i].no){
                        tmp.punteros[i]=agregar(f, tmp.punteros[i]);
                        System.out.println("recursivo");
                        mayor=false;
                    }
                }
                if(mayor){
                    tmp.punteros[i]=agregar(f, tmp.punteros[i]);//??
                    System.out.println("Recrsivoffg");
                }
            }
        }
    return tmp;
    }
    NodoBT split(NodoBT h) {
        
        h.padre.agregar(h.facturas[t/2]);
        
        NodoBT t1 = new NodoBT(h.t,h.padre);
        
        h.n = h.t/2;
        
        int r=0;
        for (int j =h.t/2+1 ; j < h.t; j++)
            t1.punteros[r] = h.punteros[j]; r++;
        for (int j = h.t/2+2; j < h.t; j++)
            t1.agregar(h.facturas[j]);
        
        for (int j = t/2; j < h.t; j++)
            h.facturas[j] = null;
        for (int j = t/2+1; j < h.t; j++)
            h.punteros[j] = null;
        
        
        int i=0;
        //Encontrar el lugar de insercion en el padre
        for(int k=0;k<h.padre.t-1;k++){
            if(h.padre.facturas[k]!=null){
                if(h.padre.facturas[k].equals(h.facturas[t/2])){
                    i=k;
                    System.out.println("i: "+i);
                }
            }
        }
        //Dezplazar los punteros hacia adelante para agregar la mitad del puntero hijo que se ha roto
        int x=h.padre.n-1;
        while(x>=0){
            h.padre.punteros[x+1]=h.padre.punteros[x];
            x--;
        }
        
        //h.padre.punteros[i]=t1;
        h.padre.punteros[i+1]=null;
        h.padre.punteros[i+1]=t1;
        
        return h;    
    }
    
    void romper(NodoBT hijo, NodoBT padre){/*
        if(padre.n<t-1){
            //Si el padre aun tiene espacio el valor se agrega
            padre.agregar(hijo.facturas[t/2]);//Ya hemos subido el valor al padre
            //Ahora falta componer los punteros y repartir el contenido del hijo en los punteros del padre
            //Correr los punteros
            //Lugar donde se inserto el nuevo elemento en el padre
            int i=0;
            //Encontrar el lugar de insercion en el padre
            for(int h=0;h<padre.t-1;h++){
                if(padre.facturas[h]!=null){
                    if(padre.facturas[h].equals(hijo.facturas[t/2])){
                        i=h;
                        System.out.println("i: "+i);
                    }
                }
            }
            //Dezplazar los punteros hacia adelante para agregar la mitad del puntero hijo que se ha roto
            int x=padre.n-1;
            while(x>=0){
                padre.punteros[x+1]=padre.punteros[x];
                x--;
            }
            
            
            Factura[] aux=new Factura[t];
            for(int t=0; t<t;t++){
                aux[t]=hijo.facturas[t];
                hijo.facturas[t]=null;
                padre.punteros[i+1].facturas[t]=null;
            }
            hijo.n=0;
            
            
            for(int z=0;z<hijo.t/2;z++){
                System.out.println("z: "+z);
                hijo.agregar(aux[z]);
            }
            padre.punteros[i]=hijo;
            
            for(int n=hijo.t/2+1;n<t;n++){
                padre.punteros[i+1].agregar(hijo.facturas[n]);
            }
            

            
        }else{
            //Si el padre esta en su capacidad maxima se vuelve a romper
            //Volver a romper
        }*/
    }
    void mostrar(NodoBT tmp){
        if(tmp!=null){
            tmp.mostrar();
            for(int i=0; i<tmp.t;i++){
                mostrar(tmp.punteros[i]);
            }
        }
    }
}

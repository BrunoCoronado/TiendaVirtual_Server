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
    
    public Btree(int t_){
        this.t=t_;
        this.raiz=null;
    }
    void agregar(Factura f){
        raiz=agregar(f,raiz);
    }
    NodoBT agregar(Factura f, NodoBT tmp){
        if(tmp==null){
            tmp= new NodoBT(t, null);
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
                    if(tmp.padre==null){
                        NodoBT nuevo= new NodoBT(t, tmp);
                        nuevo.agregar(tmp.facturas[t/2]);
                        
                        nuevo.punteros[0]= new NodoBT(t, nuevo);
                        nuevo.punteros[1]=new NodoBT(t, nuevo);
                        
                        for(int i=0; i<t/2;i++){
                            nuevo.punteros[0].agregar(tmp.facturas[i]);
                        }
                        for(int j=t/2+1; j<t;j++){
                            nuevo.punteros[0].agregar(tmp.facturas[j]);
                        }                        
                        tmp=nuevo;
                    }
                    else{
                        System.out.println("Falta implementar rompimiento recursivo");
                    }
                }
            }
            else{
                boolean mayor=true;
                int i=0;
                for(i=0; i <tmp.n;i++){
                    if(f.no<tmp.facturas[i].no){
                        tmp.punteros[i]=agregar(f, tmp.punteros[i]);
                        mayor=false;
                    }
                }
                if(mayor){
                    tmp.punteros[i]=agregar(f, tmp.punteros[i]);
                }
            }
        }
    return tmp;
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
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
public class NodoBT {
    Factura [] facturas;//Una lista de facturas
    int t;//Grado
    NodoBT [] punteros;//Una lista de punteros
    int n;//Número actual de claves
    NodoBT padre;
    
    public NodoBT(int t_, NodoBT padre_){
        this.t=t_;
        this.n=0;
        this.facturas= new Factura[t_];
        this.punteros= new NodoBT[t_];
        this.padre=padre_;
    }
    void agregar(Factura f){
        
        facturas[n++]=f;
        System.out.println("Numero de valores usados: "+n);
        if(n>1){
            ordenar();
        }
    }
    void ordenar(){
        Factura aux;
        for(int i=0;  i<n-1;i++){
            for(int j=0; j<n;j++){
                if(facturas[i].no>facturas[j].no){
                    aux=facturas[i];
                    facturas[i]=facturas[j];
                    facturas[j]=aux;
                }
            }
        }
    }
    void mostrar(){
        System.out.print("[");
        for(int i=0; i<n;i++){
            System.out.print(facturas[i].no+" ");
        }
        System.out.println("]");
    }
}

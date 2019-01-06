/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ArbolAVL;

import TDA.ColaCC.ColaCC;
import TDA.ColaPP.ColaPP;
import TDA.ListaSimple.ListaSimple;

/**
 *
 * @author bruno
 */
public class NodoAVL {
    private int fe;
    private int altura;
    private NodoAVL izquierda;
    private NodoAVL derecha;
    private NodoAVL padre;
    
    private String nickName;
    private String contraseña;
    private ListaSimple listaDirecciones;
    private ColaPP listaProductosPorComprar;
    private ColaCC listaCarritoDeCompras;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ListaSimple getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(ListaSimple listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public ColaPP getListaProductosPorComprar() {
        return listaProductosPorComprar;
    }

    public void setListaProductosPorComprar(ColaPP listaProductosPorComprar) {
        this.listaProductosPorComprar = listaProductosPorComprar;
    }

    public ColaCC getListaCarritoDeCompras() {
        return listaCarritoDeCompras;
    }

    public void setListaCarritoDeCompras(ColaCC listaCarritoDeCompras) {
        this.listaCarritoDeCompras = listaCarritoDeCompras;
    }

    public NodoAVL(String nickName, String contraseña) {
        this.nickName = nickName;
        this.contraseña = contraseña;
        this.listaDirecciones = new ListaSimple();
        this.listaCarritoDeCompras = new ColaCC();
        this.listaProductosPorComprar = new ColaPP();
    }

    public NodoAVL(String nickName, String contraseña, NodoAVL padre) {
        this.nickName = nickName;
        this.contraseña = contraseña;
        this.padre = padre;
        this.listaDirecciones = new ListaSimple();
        this.listaCarritoDeCompras = new ColaCC();
        this.listaProductosPorComprar = new ColaPP();
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }

    public NodoAVL getPadre() {
        return padre;
    }

    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }
    
   
}

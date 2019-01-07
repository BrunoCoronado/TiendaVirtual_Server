/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA.ArbolAVL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bruno
 */
public class ArbolAVL {
    private NodoAVL raiz;
    
    public void insertar(String nick, String contraseña){
        if(raiz != null)
            insertar(nick, contraseña, raiz);
        else
            raiz = new NodoAVL(nick, contraseña);
    }
    
    private void insertar(String nick, String contraseña, NodoAVL tmp){
        int comparacion = tmp.getNickName().compareTo(nick);
        if(comparacion > 0){
            if(tmp.getIzquierda() != null)
                insertar(nick, contraseña, tmp.getIzquierda());
            else{
                tmp.setIzquierda(new NodoAVL(nick, contraseña, tmp));
                balancear(tmp);
            }
        }else if(comparacion < 0){
            if(tmp.getDerecha()!= null)
                insertar(nick, contraseña, tmp.getDerecha());
            else{
                tmp.setDerecha(new NodoAVL(nick, contraseña, tmp));
                balancear(tmp);
            }
        }
    }
    
    private void balancear(NodoAVL tmp){
        tmp.setAltura(1 + Math.max(alturaNodo(tmp.getDerecha()), alturaNodo(tmp.getIzquierda())));
        tmp.setFe(alturaNodo(tmp.getDerecha())-alturaNodo(tmp.getIzquierda()));
        
        if(tmp.getFe() == -2){
            if(alturaNodo(tmp.getIzquierda().getIzquierda()) >= alturaNodo(tmp.getIzquierda().getDerecha()))
                tmp = rotacionDerecha(tmp);
            else{
                tmp.setIzquierda(rotacionIzquierda(tmp.getIzquierda()));
                tmp = rotacionDerecha(tmp);
            }
        }else if(tmp.getFe() == 2){
            if(alturaNodo(tmp.getDerecha().getDerecha()) >= alturaNodo(tmp.getDerecha().getIzquierda()))
                tmp = rotacionIzquierda(tmp);
            else{
                tmp.setDerecha(rotacionDerecha(tmp.getDerecha()));
                tmp = rotacionIzquierda(tmp);
            }
        }
        if(tmp.getPadre() != null)
            balancear(tmp.getPadre());
        else
            raiz = tmp;
    }
    
    private NodoAVL rotacionDerecha(NodoAVL tmp){
        NodoAVL n1 = tmp.getIzquierda();
        n1.setPadre(tmp.getPadre());
        tmp.setIzquierda(n1.getDerecha());
        if(tmp.getIzquierda() != null)
            tmp.getIzquierda().setPadre(tmp);
        n1.setDerecha(tmp);
        tmp.setPadre(n1);
        if(n1.getPadre() != null){
            if(n1.getPadre().getDerecha() == tmp)
                n1.getPadre().setDerecha(n1);
            else
                n1.getPadre().setIzquierda(n1);
        }
        tmp.setAltura(1 + Math.max(alturaNodo(tmp.getDerecha()), alturaNodo(tmp.getIzquierda())));
        tmp.setFe(alturaNodo(tmp.getDerecha())-alturaNodo(tmp.getIzquierda()));
        n1.setAltura(1 + Math.max(alturaNodo(n1.getDerecha()), alturaNodo(n1.getIzquierda())));
        n1.setFe(alturaNodo(n1.getDerecha())-alturaNodo(n1.getIzquierda()));
        return n1;
    }
    
    private NodoAVL rotacionIzquierda(NodoAVL tmp){
        NodoAVL n1 = tmp.getDerecha();
        n1.setPadre(tmp.getPadre());
        tmp.setDerecha(n1.getIzquierda());
        if(tmp.getDerecha() != null)
            tmp.getDerecha().setPadre(tmp);
        n1.setIzquierda(tmp);
        tmp.setPadre(n1);
        if(n1.getPadre() != null){
            if(n1.getPadre().getDerecha() == tmp)
                n1.getPadre().setDerecha(n1);
            else
                n1.getPadre().setIzquierda(n1);
        }        
        tmp.setAltura(1 + Math.max(alturaNodo(tmp.getDerecha()), alturaNodo(tmp.getIzquierda())));
        tmp.setFe(alturaNodo(tmp.getDerecha())-alturaNodo(tmp.getIzquierda()));
        n1.setAltura(1 + Math.max(alturaNodo(n1.getDerecha()), alturaNodo(n1.getIzquierda())));
        n1.setFe(alturaNodo(n1.getDerecha())-alturaNodo(n1.getIzquierda()));
        return n1;
    }
    
    int alturaNodo(NodoAVL nodoAVL){
        if(nodoAVL == null)
            return -1;
        return nodoAVL.getAltura();
    }
    
    String contenido = "";
    String nulos = "";
    String relaciones = "";
    String relacionesNulos = "";
    int contadorNull = 0;
    public void graficarArbol(){
        try{
            contenido = "";relaciones = "";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("AVL.txt", false))) {
                writer.write("digraph G {\n");
                contenido(raiz);
                writer.write(contenido);
                writer.write(nulos);
                writer.write(relaciones);
                writer.write(relacionesNulos);
                writer.write("}");
            }
            Runtime.getRuntime().exec("dot.exe -Tsvg AVL.txt -o AVL.svg");
            String [] cmd = {"cmd.exe", "/c", "start", "AVL.svg" };
            Runtime.getRuntime().exec(cmd);
        }catch(IOException ex){
            System.out.println("erroe");
        }
    }
    
    private void contenido(NodoAVL tmp){
        if(tmp != null){
            contenido += "nodo"+tmp.getNickName()+"[label = \"Nick: "+tmp.getNickName()+" \\n Contra: "+tmp.getContraseña()+"\"]\n";
            if(tmp.getIzquierda() != null)
                relaciones += "\"nodo"+tmp.getNickName()+"\"" + "->"+"\"nodo"+tmp.getIzquierda().getNickName()+"\"\n";
            else{
                contenido += "null"+contadorNull+" [shape=point];\n";
                relacionesNulos += "\"nodo"+tmp.getNickName()+"\"" + "->"+"\"null"+contadorNull+++"\"\n";
            }
            if(tmp.getDerecha() != null)
                relaciones += "\"nodo"+tmp.getNickName()+"\"" + "->"+"\"nodo"+tmp.getDerecha().getNickName()+"\"\n";
            else{
                nulos += "null"+contadorNull+" [shape=point];\n";
                relacionesNulos += "\"nodo"+tmp.getNickName()+"\"" + "->"+"\"null"+contadorNull+++"\"\n";
            }
            if(tmp.getListaDirecciones()!=null){
                contenido += tmp.getListaDirecciones().graficar(tmp.getNickName(), "nodo"+tmp.getNickName());
                relaciones += "\nnodo"+tmp.getNickName()+" -> d0"+tmp.getNickName()+"[dir=none];";
            }
            if(tmp.getListaProductosPorComprar()!=null){
                contenido += tmp.getListaProductosPorComprar().graficar(tmp.getNickName(), "nodo"+tmp.getNickName());
                relaciones += "\nnodo"+tmp.getNickName()+" -> pp0"+tmp.getNickName()+"[dir=none];";
            }
            if(tmp.getListaCarritoDeCompras()!=null){
                contenido += tmp.getListaCarritoDeCompras().graficar(tmp.getNickName(), "nodo"+tmp.getNickName());
                relaciones += "\nnodo"+tmp.getNickName()+" -> cc0"+tmp.getNickName()+"[dir=none];";
            }
            contenido(tmp.getIzquierda());
            contenido(tmp.getDerecha());
        }   
    }
    
    public void insertarDireccion(String nick, String direccion, int envio, int facturacion){
        if(raiz != null){
            if(!raiz.getNickName().equals(nick))
                insertarDireccion(nick, direccion, envio, facturacion, raiz);
            else{
                raiz.getListaDirecciones().insertarAlInicio(direccion, envio, facturacion);
            }
        }
    }
    
    private void insertarDireccion(String nick, String direccion, int envio, int facturacion, NodoAVL tmp){
        int comparacion = tmp.getNickName().compareTo(nick);
        if(comparacion > 0){
            if(tmp.getIzquierda() != null){
                if(!tmp.getIzquierda().getNickName().equals(nick)){
                    insertarDireccion(nick, direccion, envio, facturacion, tmp.getIzquierda());
                }else{
                    tmp.getIzquierda().getListaDirecciones().insertarAlInicio(direccion, envio, facturacion);
                }
            }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n");*/}
        }else if(comparacion < 0){
                if(tmp.getDerecha() != null){
                    if(!tmp.getDerecha().getNickName().equals(nick)){
                        insertarDireccion(nick, direccion, envio, facturacion, tmp.getDerecha());
                    }else{
                        tmp.getDerecha().getListaDirecciones().insertarAlInicio(direccion, envio, facturacion);
                    }                    
                }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n")*/;}
        
        }
    }
    
    public void insertarCarrito(String nick, int cantidad, Object producto){
        if(raiz != null){
            if(!raiz.getNickName().equals(nick))
                insertarCarrito(nick, cantidad, producto, raiz);
            else{
                raiz.getListaCarritoDeCompras().push(producto, cantidad);
            }
        }
    }
    
    private void insertarCarrito(String nick, int cantidad, Object producto, NodoAVL tmp){
        int comparacion = tmp.getNickName().compareTo(nick);
        if(comparacion > 0){
            if(tmp.getIzquierda() != null){
                if(!tmp.getIzquierda().getNickName().equals(nick)){
                    insertarCarrito(nick, cantidad, producto, tmp.getIzquierda());
                }else{
                    tmp.getIzquierda().getListaCarritoDeCompras().push(producto, cantidad);
                }
            }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n");*/}
        }else if(comparacion < 0){
                if(tmp.getDerecha() != null){
                    if(!tmp.getDerecha().getNickName().equals(nick)){
                        insertarCarrito(nick, cantidad, producto, tmp.getDerecha());
                    }else{
                        tmp.getDerecha().getListaCarritoDeCompras().push(producto, cantidad);
                    }                    
                }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n")*/;}
        
        }
    }
    
    public void insertarPorComprar(String nick, int cantidad, Object producto){
        if(raiz != null){
            if(!raiz.getNickName().equals(nick))
                insertarPorComprar(nick, cantidad, producto, raiz);
            else{
                raiz.getListaProductosPorComprar().push(producto, cantidad);
            }
        }
    }
    
    private void insertarPorComprar(String nick, int cantidad, Object producto, NodoAVL tmp){
        int comparacion = tmp.getNickName().compareTo(nick);
        if(comparacion > 0){
            if(tmp.getIzquierda() != null){
                if(!tmp.getIzquierda().getNickName().equals(nick)){
                    insertarPorComprar(nick, cantidad, producto, tmp.getIzquierda());
                }else{
                    tmp.getIzquierda().getListaProductosPorComprar().push(producto, cantidad);
                }
            }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n");*/}
        }else if(comparacion < 0){
                if(tmp.getDerecha() != null){
                    if(!tmp.getDerecha().getNickName().equals(nick)){
                        insertarPorComprar(nick, cantidad, producto, tmp.getDerecha());
                    }else{
                        tmp.getIzquierda().getListaProductosPorComprar().push(producto, cantidad);
                    }                    
                }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n")*/;}
        
        }
    }
    public NodoAVL buscar(String nick){
        if(raiz != null){
            if(!raiz.getNickName().equals(nick))
                return buscar(nick, raiz);
            else
                return raiz;
        }else{
            return null;
        }
        
    }
    
    
    private NodoAVL buscar(String nick, NodoAVL tmp){
        int comparacion = tmp.getNickName().compareTo(nick);
        if(comparacion > 0){
            if(tmp.getIzquierda() != null){
                if(!tmp.getIzquierda().getNickName().equals(nick)){
                    buscar(nick, tmp.getIzquierda());
                }else{
                    return tmp.getIzquierda();
                }
            }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n");*/}
        }else if(comparacion < 0){
                if(tmp.getDerecha() != null){
                    if(!tmp.getDerecha().getNickName().equals(nick)){
                        buscar(nick, tmp.getDerecha());
                    }else{
                        return tmp.getDerecha();
                    }                    
                }else{/*sistema.ui.VentanaConfiguracion.txtLog.append("!!!Imposible Modificar Tropa - No Encontrada!!!!\n")*/;}
        
        }
        return null;
    }
}

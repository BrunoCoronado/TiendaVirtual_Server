/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.sistema.archivos;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import sistema.bean.Producto;
import sistema.bean.Factura;
import sistema.bean.Detalle;

/**
 *
 * @author bruno
 */
@MultipartConfig
public class cargaArchivoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String tipoArchivo = request.getParameter("tipoArchivo");
        Part filePart=request.getPart("archivo");
        InputStream fileContent = filePart.getInputStream();
        java.util.Scanner s = new java.util.Scanner(fileContent);
        String contenido = "";
        try{
            switch(tipoArchivo){
                case "Usuario":
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        web.servicioWeb.ServicioWeb.arbolAVL.insertar(datos[0], datos[1]);
                    }
                    break;
                case "Direccion":
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        web.servicioWeb.ServicioWeb.arbolAVL.insertarDireccion(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
                    }
                    break;
                case "PorComprar":
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        web.servicioWeb.ServicioWeb.arbolAVL.insertarPorComprar(datos[0], Integer.parseInt(datos[1]), web.servicioWeb.ServicioWeb.tablaHash.buscar(datos[3]));
                    }
                    break;
                case "Carrito":
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        web.servicioWeb.ServicioWeb.arbolAVL.insertarCarrito(datos[0], Integer.parseInt(datos[1]), web.servicioWeb.ServicioWeb.tablaHash.buscar(datos[3]));
                    }
                    break;
                case "Producto":
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        web.servicioWeb.ServicioWeb.tablaHash.insertar(new Producto(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]));
                    }
                    web.servicioWeb.ServicioWeb.tablaHash.dibujar();
                    break;
                case "Venta/Factura":
                    /**
                     * Archivo:
                     * 78998,15-1-2019,4506,bruno16cca
                     * 78554,17-1-2019,106,cristuan6cas
                     */
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        web.servicioWeb.ServicioWeb.arbolB.add(new Factura(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), datos[3]));/*El dato[3] puede ser int o string depediendo de como vas implementar la busqueda en el AVL*/
                    }    /*NO hay apuntador al detalle porque es el detalle que debe traer indicado a que factura va aunado y en ese momento se agrega el detalle*/
                    break;
                case "Detalle":
                
                    /*
                    Archivo:
                    1;
                    1,15,0001
                    4,175,0002
                    */
                    Detalle detalle= new Detalle();
                    Factura factura=null;
                    
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(";");
                        //factura=web.servicioWeb.ServicioWeb.arbolB.buscar(Integer.parseInt(datos[0]));
                        /**
                         * el metodo buscar no esta implementado en el rbolB como te dije solo inserta
                         */
                        break;
                    }
                    
                    while(s.hasNext()){
                        contenido = s.next();
                        String[] datos = contenido.split(",");
                        detalle.push(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2]);
                    }
                    if(factura!=null){
                        factura.detalle=detalle;
                    }
                    else{
                        System.out.println("Detalle de una factura inexistente");
                    }
                    
                    
                    
                    break;       
            }
        }catch(Exception ex){}
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

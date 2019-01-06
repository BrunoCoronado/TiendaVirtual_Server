/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.sistema.archivos;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author bruno
 */
@WebServlet(name = "archivosServlet", urlPatterns = {"/archivosServlet"})
@MultipartConfig
public class archivosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

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
                    web.servicioWeb.ServicioWeb.arbolAVL.insertarPorComprar(datos[0], Integer.parseInt(datos[1]), datos[3]);
                }
                break;
            case "Carrito":
                while(s.hasNext()){
                    contenido = s.next();
                    String[] datos = contenido.split(",");
                    web.servicioWeb.ServicioWeb.arbolAVL.insertarCarrito(datos[0], Integer.parseInt(datos[1]), datos[3]);
                }
                break;
            case "Producto":
                break;
            case "Venta":
                break;
            case "Detalle":
                break;       
        }
        request.getRequestDispatcher("../index.jsp").forward(request, response);
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

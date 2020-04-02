/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Service.ServiceMethodsCarrera;
import exceptions.GlobalException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Carrera;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServicioEditarCarrera extends HttpServlet {

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
            throws ServletException, IOException, SQLException, GlobalException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                String codigo = request.getParameter("codigoCarrera");
                String nombre = request.getParameter("nombreCarrera");
                String titulo = request.getParameter("tituloCarrera");
                Carrera c = new Carrera(codigo, nombre, titulo);
                ServiceMethodsCarrera sc= ServiceMethodsCarrera.obtenerInstancia();
                if (sc.actualizarCarrera(c)) {
                    response.sendRedirect("listarCarrera.jsp");
                } else {
                    response.sendRedirect("agregarCarrera.jsp");

                }
            } catch (InstantiationException
                    | ClassNotFoundException
                    | IllegalAccessException ex) {

                Logger.getLogger(ServicioAgregarCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
         
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
        try {
         //   processRequest(request, response);
            PrintWriter out = response.getWriter();
             response.setContentType("text/html");
            String c = request.getParameter("codigo");
            ServiceMethodsCarrera sc = ServiceMethodsCarrera.obtenerInstancia();
            Carrera carrera = sc.BuscarCarreraCodigo(c);
            request.setAttribute("Carrera", carrera);
            RequestDispatcher  dispatcher=getServletContext().getRequestDispatcher("editarCarrera.jsp");
            dispatcher.forward(request, response);
            
//            out.println("<html>");
//            out.println("<head><title>Enviar parametros a un Servlet</title></head>");
//            out.println("<body>");
//            out.println("<h1>Enviar parametros a un Servlet</h1>");
//            out.println("Codigo: <strong>" + carrera.getCodigo() + "</strong><br>");
//            out.println("Nombre  <strong>" + carrera.getNombre() + "</strong><br>");
//            out.println("Titulo <strong>" + carrera.getTitulo() + "</strong><br>");
//            out.println("</body></html>");


        } catch (InstantiationException
                | ClassNotFoundException
                | IllegalAccessException ex) {

            Logger.getLogger(ServicioAgregarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServicioEditarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioEditarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GlobalException ex) {
            Logger.getLogger(ServicioEditarCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
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
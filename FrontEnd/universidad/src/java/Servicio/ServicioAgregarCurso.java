/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Service.ServiceMethodsCurso;
import exceptions.GlobalException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Curso;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServicioAgregarCurso extends HttpServlet {

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
            throws ServletException, IOException, GlobalException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                String codigo = request.getParameter("codigoCurso");
                String nombre = request.getParameter("nombreCurso");
                String carrera = request.getParameter("carrera");
                int creditos = Integer.parseInt(request.getParameter("creditoCurso"));
                int horas = Integer.parseInt(request.getParameter("horaCurso"));
                int ciclo = Integer.parseInt(request.getParameter("ciclo"));
                int anio = Integer.parseInt(request.getParameter("anioCurso"));
                Curso c = new Curso(codigo, nombre, creditos, horas, carrera, ciclo, anio);
                ServiceMethodsCurso sc = ServiceMethodsCurso.obtenerInstancia();
                if (sc.insertarCurso(c)) {
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
            processRequest(request, response);
        } catch (GlobalException ex) {
            Logger.getLogger(ServicioAgregarCurso.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (GlobalException ex) {
            Logger.getLogger(ServicioAgregarCurso.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Service.ServiceMethodsCarrera;
import Service.ServiceMethodsCurso;
import exceptions.GlobalException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Carrera;
import models.Curso;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServicioEditarCurso extends HttpServlet {

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
            try{
                String codigo = request.getParameter("codigoCurso");
                String nombre = request.getParameter("nombreCurso");
                String carrera = request.getParameter("carrera");
                int creditos = Integer.parseInt(request.getParameter("creditoCurso"));
                int horas = Integer.parseInt(request.getParameter("horaCurso"));
                int anio = Integer.parseInt(request.getParameter("anioCurso"));
                int ciclo = Integer.parseInt(request.getParameter("cicloCurso"));
                Curso c = new Curso(codigo, nombre, creditos, horas, carrera, ciclo, anio);
                ServiceMethodsCurso sc = ServiceMethodsCurso.obtenerInstancia();
                if (sc.actualizarCurso(c)) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Se ha actualizado Correctamente');");
                    out.println("location='listarCurso.jsp';");
                    out.println("</script>");

                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('No se ha podido actualizar el curso');");
                    out.println("location='listarCurso.jsp';");
                    out.println("</script>");

                }

            } catch (InstantiationException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | SQLException | GlobalException ex) {

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
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String c = request.getParameter("codigoC");
            ServiceMethodsCurso sc = ServiceMethodsCurso.obtenerInstancia();
            ServiceMethodsCarrera sca= ServiceMethodsCarrera.obtenerInstancia();
            Curso curso = sc.buscarCursoPorCodigo(c);
            Carrera carrera = sca.BuscarCarreraCodigo(curso.getCodigoCarrera());
            request.setAttribute("codigo",curso.getCodigo() );
            request.setAttribute("nombre", curso.getNombre());
            request.setAttribute("creditos", curso.getCreditos());
            request.setAttribute("horas", curso.getHorasSemanales());
            request.setAttribute("carrera", curso.getCodigoCarrera());
            request.setAttribute("carreraC", carrera.getNombre());
            request.setAttribute("ciclo", curso.getCiclo());
            request.setAttribute("anio", curso.getAnio());
            request.getRequestDispatcher("editarCurso.jsp").forward(request, response);
           
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
        processRequest(request, response);
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

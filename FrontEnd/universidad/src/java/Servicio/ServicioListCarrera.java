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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Carrera;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class ServicioListCarrera extends HttpServlet {

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
            throws ServletException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException, GlobalException {
   response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           // String optbusqueda = request.getParameter("searchType");
            List<Carrera> carreras
                    = ServiceMethodsCarrera.obtenerInstancia().buscarTodasCarreras();
            System.out.println(carreras);
            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();
            for (Carrera c : carreras) {
                JSONObject pj = new JSONObject();
                pj.put("codigo", c.getCodigo());
                pj.put("nombre",c.getNombre());
                pj.put("titulo",c.getTitulo());
                a.put(pj);
            }
            r.put("carreras", a);
            out.print(r);
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
            response.setContentType("text/html");

            String search = request.getParameter("search");
            String tipo = request.getParameter("tipo");

            if (search == "scodigo") {
                Carrera c = ServiceMethodsCarrera.obtenerInstancia().BuscarCarreraCodigo(tipo);

                JSONObject r = new JSONObject();
                JSONArray a = new JSONArray();
                JSONObject pj = new JSONObject();
                pj.put("codigo", c.getCodigo());
                pj.put("nombre", c.getNombre());
                pj.put("titulo", c.getTitulo());
                a.put(pj);
                r.put("carreras", a);
            }
            if (search == "snombre") {

            }
        } catch (InstantiationException 
                | ClassNotFoundException
                | IllegalAccessException
                | GlobalException ex) {
            Logger.getLogger(ServicioListCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServicioListCarrera.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioListCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioListCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioListCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GlobalException ex) {
            Logger.getLogger(ServicioListCarrera.class.getName()).log(Level.SEVERE, null, ex);
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
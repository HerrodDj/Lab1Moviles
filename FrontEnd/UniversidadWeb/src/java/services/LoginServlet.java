/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Service.ServiceMethodsUsuario;
import exceptions.GlobalException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Usuario;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class LoginServlet extends HttpServlet {

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

           ServiceMethodsUsuario su= new ServiceMethodsUsuario();
           String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            Usuario user= su.getUsuario(usuario, password);
            if(user!=null){
            
                HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuario", su);
            sesion.setMaxInactiveInterval(60 * 5);
            Cookie ck = new Cookie("username", usuario);
            response.addCookie(ck);
            response.sendRedirect("adminGeneral.jsp");
            
            }
            
            
//            if (usuario != null && password != null) {
//                administradorValido = gI.verificarAdministrador(usuario, password);
//            }
//            if (administradorValido) {
//                Administrador i = gI.recuperar(usuario);
//                HttpSession sesion = request.getSession(true);
//                sesion.setAttribute("usuario", i);
//
//                sesion.setMaxInactiveInterval(60 * 3);
//                Cookie ck = new Cookie("username", usuario);
//                response.addCookie(ck);
//                response.sendRedirect("adminGeneral.jsp");
//            } else {
//                response.sendRedirect("loginError.jsp");
//            }
        }    }

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

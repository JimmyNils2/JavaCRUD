/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jimmy
 */
public class InicioSesion extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            
            //Instancia HttpSession
            HttpSession sesion = request.getSession();
            
            
            //Instancia crea un objeto metodos
            MetodosSQL metodos = new MetodosSQL();
            
            //Instancia variables con los valores de los inputs del HTML
            String txtUsuario = request.getParameter("txtUsuario");
            String txtContrasena = request.getParameter("txtContrasena");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            //Abre etiqueta Script
            out.println("<script type=\"text/javascript\">");
            
            boolean inicioSesion = metodos.buscarUsuarioLogin(txtUsuario, txtContrasena);
            
            if(inicioSesion == true){//El usuario esta registrado y actualiza la pagina
                out.println("alert('Bienvenido,\\nIniciaste sesion como "+txtUsuario+"')");
                out.println("location='paginaInicio.html'");
                
                //Obtiene el nombre del usuario
                String nombre = metodos.buscarNombre(txtUsuario);
                System.out.println("El nombre del usuario es "+nombre);
                
                //Agregamos a la sesion el nombre y usuario
                sesion.setAttribute("nombre", nombre);
                sesion.setAttribute("usuario", txtUsuario);
            }
            else{
                out.println("alert('Usuario y Constraseña con coinciden, intente nuevamente')");
                out.println("location='index.html'");
            }
            //Log
            System.out.println("El valor de inicioSesion en SERVLET es: "+inicioSesion);
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
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

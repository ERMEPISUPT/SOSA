/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Usuario;
import Modelo.UsuarioAdmin;
import Modelo.UsuarioDAO;

/**
 *
 * @author USUARIO
 */
public class Controlador extends HttpServlet {
 
    AdminDAO Adao=new AdminDAO();
    UsuarioAdmin pa=new UsuarioAdmin();
    int Ur;
    
    UsuarioDAO Udao=new UsuarioDAO();
    Usuario p=new Usuario();
    int Ar;
    
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
        
        String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String dni=request.getParameter("txtdni");
            String clave=request.getParameter("txtclave");
            p.setDni(dni);
            p.setClave(clave);
            Ur=Udao.Validar(p);
            if(Ur==0){
                request.getSession().setAttribute("dni",dni);
                request.getSession().setAttribute("clave",clave);
                request.getRequestDispatcher("PrincipalUser.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        if(accion.equals("Ingresar")){
            String dni=request.getParameter("txtdni");
            String clave=request.getParameter("txtclave");
            pa.setDni(dni);
            pa.setClave(clave);
            Ar=Adao.Validar(pa);
            if(Ar==1){
                request.getSession().setAttribute("dni",dni);
                request.getSession().setAttribute("clave",clave);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
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

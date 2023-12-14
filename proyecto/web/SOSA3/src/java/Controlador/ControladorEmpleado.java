/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;

import javax.servlet.RequestDispatcher;

/**
 *
 * @author USUARIO
 */
public class ControladorEmpleado extends HttpServlet {
    
    
    String Listar="VistaEmpleado/listar.jsp";
    String add="VistaEmpleado/agregar.jsp";
    String edit="VistaEmpleado/editar.jsp";
    Empleado emp=new Empleado();
    EmpleadoDAO dao=new EmpleadoDAO();

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=Listar;
        }
         else if (action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
            
            int vid = Integer.parseInt(request.getParameter("txtid"));
            String vdni=request.getParameter("txtdni");
            String vclave=request.getParameter("txtclave");
            String vnom=request.getParameter("txtnom");
            String vape=request.getParameter("txtape");
            String vema=request.getParameter("txtema");
            String vtel=request.getParameter("txttel");
            String vhor=request.getParameter("txthor");
            int vcargo_id = Integer.parseInt(request.getParameter("txtcargo_id"));
            
            emp.setId(vid);
            emp.setDni(vdni);
            emp.setClave(vclave);
            emp.setNombre(vnom);
            emp.setApellido(vape);
            emp.setEmail(vema);
            emp.setTelefono(vtel);
            emp.setHorario(vhor);
            emp.setCargo_id(vcargo_id);
            
            dao.add(emp);
            acceso=Listar;
        }
        else if (action.equalsIgnoreCase("eliminar")){
            int vid = Integer.parseInt(request.getParameter("vid"));
            dao.eliminar(vid);
            acceso=Listar;
        }
        else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("valid",request.getParameter("vid"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            
            int vid = Integer.parseInt(request.getParameter("txtid"));
            String vdni=request.getParameter("txtdni");
            String vclave=request.getParameter("txtclave");
            String vnom=request.getParameter("txtnom");
            String vape=request.getParameter("txtape");
            String vema=request.getParameter("txtema");
            String vtel=request.getParameter("txttel");
            String vhor=request.getParameter("txthor");
            int vcargo_id = Integer.parseInt(request.getParameter("txtcargo_id"));
            
            emp.setId(vid);
            emp.setDni(vdni);
            emp.setClave(vclave);
            emp.setNombre(vnom);
            emp.setApellido(vape);
            emp.setEmail(vema);
            emp.setTelefono(vtel);
            emp.setHorario(vhor);
            emp.setCargo_id(vcargo_id);
            
            dao.edit(emp);
            acceso=Listar;
        }
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request,response);
        
        //processRequest(request, response);
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

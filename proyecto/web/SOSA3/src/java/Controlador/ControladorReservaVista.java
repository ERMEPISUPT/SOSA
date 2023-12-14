/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Maquinas;
import ModeloDAO.MaquinasDAO;

import javax.servlet.RequestDispatcher;
/**
 *
 * @author ORDENADOR
 */
public class ControladorReservaVista {
    String Listar="VistaMaquinas/listaruser.jsp";
    String add="VistaMaquinas/listaruser.jsp";
    Maquinas hab=new Maquinas();
    MaquinasDAO dao=new MaquinasDAO();
}

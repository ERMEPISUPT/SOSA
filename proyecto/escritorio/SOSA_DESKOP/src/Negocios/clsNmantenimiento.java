/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Config.*;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ORDENADOR
 */
public class clsNmantenimiento {
    Conexion cn=new Conexion();
    Connection con; 
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    clsEMantenimiento E =new clsEMantenimiento();
    public clsEMantenimiento buscarEncargadoPorDNI(String dni) {
        clsEMantenimiento cliente = null;
        String SQL = "SELECT * FROM tbempleado WHERE dni = ?";
        String SQL2 = "SELECT * FROM tbcontactos WHERE dni = ?";

        try {
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new clsEMantenimiento();
                cliente.setDni(rs.getString("dni"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println("error" + e.toString());
        } finally {
            // Close resources (ResultSet, PreparedStatement, and Connection)
            // to prevent memory leaks
            closeResources();
        }

        return cliente;
    }
    public boolean MtdModificarMantenimiento(clsEMantenimiento objEC) {
        String SQL = "UPDATE tbmantenimiento "
            + "SET emp_con = '" + objEC.getEmp_con() + "', "
            + "estado = '" + objEC.getEstado() + "', "
            + "observaciones = '" + objEC.getObservaciones() + "', "
            + "fecha = '" + objEC.getFecha() + "' "
            + "WHERE id_maquina = '" + objEC.getId_maquina() + "'";
        System.out.println("sentencia " + SQL);
       try{
            con=(Connection) cn.getConnection();
            st=con.createStatement();
            st.executeUpdate(SQL);
             return true;       
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            return false;  
        }
    }

    public List<clsEMantenimiento> MtdListarMaquinas() {
    List<clsEMantenimiento> listaMaquinas = new ArrayList<>();

    String SQL = "SELECT * FROM tbmantenimiento";

    try {
        con = (Connection) cn.getConnection();
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();

        while (rs.next()) {
            clsEMantenimiento pro = new clsEMantenimiento();
            pro.setId_maquina(Integer.parseInt(rs.getString("id_maquina")));
            pro.setEmp_con(Integer.parseInt(rs.getString("emp_con")));
            pro.setNumero(rs.getString("numero"));
            pro.setTipo(rs.getString("tipo"));
            pro.setEstado(rs.getString("estado"));
            pro.setObservaciones(rs.getString("observaciones"));
            pro.setFecha(rs.getString("fecha"));

            listaMaquinas.add(pro);
        }

    } catch (SQLException e) {
        System.out.println("error" + e.toString());
    } finally {
        // Close resources (ResultSet, PreparedStatement, and Connection)
        // to prevent memory leaks
        closeResources();
    }

    return listaMaquinas;
    }


    // Method to close resources
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("error closing resources" + e.toString());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

/**
 *
 * @author HP
 */
import Config.Conexion;
import Entidad.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clsNempleado {
    Conexion cn=new Conexion();
    Connection con; 
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    clsEEmpleado E =new clsEEmpleado();
 
    public ResultSet MtdLogin(clsEEmpleado objEE)
    {
        ResultSet rst = null;
            String SQL = "select * from tbusuarios  "
               + "where dni= '"+objEE.getDni()+"' and clave= '"+objEE.getClave()+"'";
        System.out.println("sentencia "+ SQL);
        try{
            con=(Connection) cn.getConnection();
            ps=con.prepareStatement(SQL);
            rst=ps.executeQuery(SQL);
                    
        }catch(SQLException e){
            System.out.println("error"+e.toString());
            
        }
        
        return rst;
    }
    public boolean MtdGuardarEmpleado(clsEEmpleado objEC) {
        String SQL = "INSERT INTO tbempleado(dni,nombre,apellido,direccion,telefono,email,clave,estado,fkcodcar,fkcodtur) "
               + "VALUES( '"+objEC.getDni()+"','"+objEC.getNombre()+"','"+objEC.getApellido()+"','"+objEC.getDireccion()+"','"+objEC.getTelefono()+"','"+objEC.getEmail()+"','"+objEC.getClave()+"','"+objEC.getEstado()+"','"+objEC.getCargo()+"','"+objEC.getTurno()+"')";
        
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
    public boolean MtdModificarEmpleado(clsEEmpleado objEC) {
        String SQL = "UPDATE tbempleado "
            + "SET nombre = '" + objEC.getNombre() + "', "
            + "apellido = '" + objEC.getApellido() + "', "
            + "direccion = '" + objEC.getDireccion() + "', "
            + "telefono = '" + objEC.getTelefono() + "', "
            + "email = '" + objEC.getEmail() + "', "
            + "clave = '" + objEC.getClave() + "', "
            + "estado = '" + objEC.getEstado() + "', "
            + "fkcodcar = '" + objEC.getCargo() + "', "
            + "fkcodtur = '" + objEC.getTurno() + "' "
            + "WHERE dni = '" + objEC.getDni() + "'";
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
    public boolean MtdEliminarEmpleado(clsEEmpleado objEC) {
        String SQL = "delete from tbempleado "               
               + "where dni='"+objEC.getDni()+"';";
        System.out.println("sentenci "+SQL);
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
    public List<clsEEmpleado> MtdListarEmpleado() {
    List<clsEEmpleado> listaEmpleados = new ArrayList<>();

    String SQL = "SELECT * FROM tbempleado";

    try {
        con = (Connection) cn.getConnection();
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();

        while (rs.next()) {
            clsEEmpleado empleado = new clsEEmpleado();
            empleado.setDni(rs.getString("dni"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setDireccion(rs.getString("direccion"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setEmail(rs.getString("email"));
            empleado.setClave(rs.getString("clave"));
            empleado.setEstado(rs.getString("estado"));
            empleado.setCargo(rs.getString("fkcodcar"));
            empleado.setTurno(rs.getString("fkcodtur"));

            listaEmpleados.add(empleado);
        }

    } catch (SQLException e) {
        System.out.println("error" + e.toString());
    } finally {
        // Close resources (ResultSet, PreparedStatement, and Connection)
        // to prevent memory leaks
        closeResources();
    }

    return listaEmpleados;
    }
    public List<clsEEmpleado> MtdBuscarEmpleado(String codigoNombre) {
         List<clsEEmpleado> listaEmpleados = new ArrayList<>();

        String SQL = "SELECT * FROM tbempleado WHERE dni LIKE ? OR nombre LIKE ?";

        try {
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, "%" + codigoNombre + "%");
            ps.setString(2, "%" + codigoNombre + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                clsEEmpleado empleado = new clsEEmpleado();
                empleado.setDni(rs.getString("dni"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
                empleado.setClave(rs.getString("clave"));
                empleado.setEstado(rs.getString("estado"));
                empleado.setCargo(rs.getString("fkcodcar"));
                empleado.setTurno(rs.getString("fkcodtur"));

                listaEmpleados.add(empleado);
            }

        } catch (SQLException e) {
            System.out.println("error" + e.toString());
        } finally {
            // Close resources (ResultSet, PreparedStatement, and Connection)
            // to prevent memory leaks
            closeResources();
        }

        return listaEmpleados;
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

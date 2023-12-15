/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocios;

import Config.Conexion;
import Entidad.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class clsNcontacto {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    public boolean MtdGuardarContacto(clsEContacto objEC) {
        String SQL = "INSERT INTO tbcontactos(dni, nombre, apellido, direccion,telefono,email,clave,estado, cargo_codigo) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, objEC.getDni());
            ps.setString(2, objEC.getNombre());
            ps.setString(3, objEC.getApellido());
            ps.setString(4, objEC.getDireccion());
            ps.setString(5, objEC.getTelefono());
            ps.setString(6, objEC.getEmail());
            ps.setString(7, objEC.getClave());
            ps.setString(8, objEC.getEstado());
            ps.setString(9, objEC.getCargoCodigo());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    public boolean MtdModificarContacto(clsEContacto objEC) {
        String SQL = "UPDATE tbcontactos "
                + "SET nombre = ?, "
                + "apellido = ?, "
                + "direccion = ?, "
                + "telefono = ?, "
                + "email = ?, "
                + "clave = ?, "
                + "estado = ?, "
                + "cargo_codigo = ? "
                + "WHERE dni = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, objEC.getNombre());
            ps.setString(2, objEC.getApellido());
            ps.setString(3, objEC.getDireccion());
            ps.setString(4, objEC.getTelefono());
            ps.setString(5, objEC.getEmail());
            ps.setString(6, objEC.getClave());
            ps.setString(7, objEC.getEstado());
            ps.setString(8, objEC.getCargoCodigo());
            ps.setString(9, objEC.getDni());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    public boolean MtdEliminarContacto(clsEContacto objEC) {
        String SQL = "delete from tbcontactos "               
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

    public List<clsEContacto> MtdListarContacto() {
        List<clsEContacto> listaContactos = new ArrayList<>();

        String SQL = "SELECT * FROM tbcontactos";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                clsEContacto Contacto = new clsEContacto();
                Contacto.setDni(rs.getString("dni"));
                Contacto.setNombre(rs.getString("nombre"));
                Contacto.setApellido(rs.getString("apellido"));
                Contacto.setDireccion(rs.getString("direccion"));
                Contacto.setTelefono(rs.getString("telefono"));
                Contacto.setEmail(rs.getString("email"));
                Contacto.setClave(rs.getString("clave"));
                Contacto.setEstado(rs.getString("estado"));
                Contacto.setCargoCodigo(rs.getString("cargo_codigo"));

                listaContactos.add(Contacto);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return listaContactos;
    }
    public List<clsEContacto> MtdBuscarContacto(String busqueda) {
        List<clsEContacto> listaContactos = new ArrayList<>();

        String SQL = "SELECT * FROM tbcontactos WHERE dni LIKE ? OR nombre LIKE ? OR apellido LIKE ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, "%" + busqueda + "%");
            ps.setString(2, "%" + busqueda + "%");
            ps.setString(3, "%" + busqueda + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                clsEContacto Contacto = new clsEContacto();
                Contacto.setDni(rs.getString("dni"));
                Contacto.setNombre(rs.getString("nombre"));
                Contacto.setApellido(rs.getString("apellido"));
                Contacto.setDireccion(rs.getString("direccion"));
                Contacto.setTelefono(rs.getString("telefono"));
                Contacto.setEmail(rs.getString("email"));
                Contacto.setClave(rs.getString("clave"));
                Contacto.setEstado(rs.getString("estado"));
                Contacto.setCargoCodigo(rs.getString("cargo_codigo"));

                listaContactos.add(Contacto);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return listaContactos;
    }
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


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
import java.util.List;
import java.util.ArrayList;




public class clsNcargo {
    Conexion cn=new Conexion();
    Connection con; 
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    clsECargo c =new clsECargo();
    
    public boolean MtdGuardarCargo(clsECargo objEC) {
        String SQL = "INSERT INTO tbcargos(id,nombre) "
               + "VALUES( '"+objEC.getCodigo()+"','"+objEC.getNombre()+"')";
        
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
    public boolean MtdModificarCargo(clsECargo objEC) {
        String SQL = "update tbcargos "
                + "set nombre= '"+objEC.getNombre()+"'"
               + "where id='"+objEC.getCodigo()+"'";
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
    public boolean MtdEliminarCargo(clsECargo objEC) {
        String SQL = "delete from tbcargos "               
               + "where id='"+objEC.getCodigo()+"';";
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
    public List<clsECargo> MtdListarCargo() {
        List<clsECargo> listaCargos = new ArrayList<>();

        String SQL = "SELECT * FROM tbcargos";

        try {
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                clsECargo cargo = new clsECargo();
                cargo.setCodigo(rs.getInt("id"));
                cargo.setNombre(rs.getString("nombre"));

                listaCargos.add(cargo);
            }

        } catch (SQLException e) {
            System.out.println("error" + e.toString());
        } finally {
            // Close resources (ResultSet, PreparedStatement, and Connection)
            // to prevent memory leaks
            closeResources();
        }

        return listaCargos;
    }
    public List<clsECargo> MtdBuscarCargo(String codigoNombre) {
        List<clsECargo> listaCargos = new ArrayList<>();

        String SQL = "SELECT * FROM tbcargos WHERE id LIKE ? OR nombre LIKE ?";

        try {
            con = (Connection) cn.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, "%" + codigoNombre + "%");
            ps.setString(2, "%" + codigoNombre + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                clsECargo cargo = new clsECargo();
                cargo.setCodigo(rs.getInt("id"));
                cargo.setNombre(rs.getString("nombre"));

                listaCargos.add(cargo);
            }

        } catch (SQLException e) {
            System.out.println("error" + e.toString());
        } finally {
            // Close resources (ResultSet, PreparedStatement, and Connection)
            // to prevent memory leaks
            closeResources();
        }

        return listaCargos;
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

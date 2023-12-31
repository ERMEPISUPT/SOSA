/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;
import Config.Conexion;
import Modelo.Maquinas;
import Interfaces.*;
import java.sql.*;
import java.util.ArrayList; //guardar datos en memoria


import java.util.List;
import Interfaces.CRUDMaquinas;

/**
 *
 * @author USUARIO
 */
public class MaquinasDAO implements CRUDMaquinas {

    
    Conexion cn=new Conexion();//para reestablecer la conexion
    Connection con; //para llamar a la cadena de conexion
    PreparedStatement ps; //ejecutar consulta
    ResultSet rs; //almacena datos de la consulta
    Maquinas maquina =new Maquinas(); //objeto Empleado
    
    
    @Override
    public List listar() {
          
        ArrayList<Maquinas> list=new ArrayList<>();
        String sql="select * from tbmaquinas";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                
                Maquinas hab=new Maquinas();
                
                hab.setId(rs.getInt("id"));
                hab.setNumero(rs.getString("numero"));
                hab.setTipo(rs.getString("tipo"));
                hab.setPrecio(rs.getFloat("precio"));
                hab.setEstado(rs.getString("estado"));
                
                list.add(hab); //se almacena en memoria en nuestro array
            }
        } catch (SQLException e){
            System.out.println("error "+e.getMessage());
        }
        
        return list;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Maquinas list(int id) {
         String sql="select id, numero,tipo,precio,estado from tbmaquinas where id='"+id+"'";
        try{
           con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
                
                Maquinas hab=new Maquinas();
                
                hab.setId(rs.getInt("id"));
                hab.setNumero(rs.getString("numero"));
                hab.setTipo(rs.getString("tipo"));
                hab.setPrecio(rs.getFloat("precio"));
                hab.setEstado(rs.getString("estado"));
                
                return hab;
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return null;
    }

    @Override
    public boolean add(Maquinas hab) {
        String sql="INSERT INTO tbmaquinas (id,numero,tipo,precio,estado)\n" + "VALUES('"+hab.getId()+"','"+hab.getNumero()+"','"+hab.getTipo()+"','"+hab.getPrecio()+"','"+hab.getEstado()+"');";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("error al Agregar "+e.getMessage());
        }
    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return false;
    }

    @Override
    public boolean edit(Maquinas hab) {
          String sql="Update tbmaquinas set numero='"+hab.getNumero()+"',tipo='"+hab.getTipo()+"',precio='"+hab.getPrecio()+"',estado='"+hab.getEstado()+"' where id='"+hab.getId()+"';";
       
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("error al Editar "+e.getMessage());
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
         String sql="delete from tbmaquinas where id='"+id+"'";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("error al Eliminar "+e.getMessage());
        }
        return false;
    }
    
    
    
    
}


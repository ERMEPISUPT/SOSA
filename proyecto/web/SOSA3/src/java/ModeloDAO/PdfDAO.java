package ModeloDAO;

import Config.*;
import Modelo.PdfVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PdfDAO {

    /*Metodo listar*/
    public ArrayList<PdfVO> Listar_PdfVO() {
        ArrayList<PdfVO> list = new ArrayList<PdfVO>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM empleado;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO vo = new PdfVO();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setDireccionpdf(rs.getString(3));
                vo.setArchivopdf2(rs.getBytes(4));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
            }
        }
        return list;
    }


    /*Metodo agregar*/
    public void Agregar_PdfVO(PdfVO vo) {
        Conexion conec = new Conexion();
        String sql = "INSERT INTO empleado (codigopdf, nombrepdf,direccionpdf,archivopdf) VALUES(?, ?,?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.setString(2, vo.getNombrepdf());
            ps.setString(3, vo.getDireccionpdf());
            ps.setBlob(4, vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    /*Metodo agregar*/
    public void Firmar_PdfVO(PdfVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE empleado SET FirmaAdmin = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getFirmaAdmin());
            ps.setInt(2, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    /*Metodo Modificar*/
    public void Firmar_PdfVO2(PdfVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE empleado SET FirmaAdmin = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getFirmaAdmin());
            ps.setInt(2, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    /*Metodo Modificar*/
    public void Modificar_PdfVO(PdfVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE empleado SET nombrepdf = ?, direccionpdf = ?,archivopdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setString(2, vo.getDireccionpdf());
            ps.setBlob(3, vo.getArchivopdf());
            ps.setInt(4, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }
    
    /*Metodo Modificar*/
    public void Modificar_PdfVO2(PdfVO vo) {
        Conexion conec = new Conexion();
        String sql = "UPDATE empleado SET nombrepdf = ? ,direccionpdf = ? WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setString(2, vo.getDireccionpdf());
            ps.setInt(3, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(int id) {
        Conexion conec = new Conexion();
        String sql = "DELETE FROM empleado WHERE codigopdf = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Consulta id*/
    public PdfVO getPdfVOById(int studentId) {
        PdfVO vo = new PdfVO();
        Conexion db = new Conexion();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM empleado WHERE codigopdf = ?;";
        try {
            preparedStatement = db.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setDireccionpdf(rs.getString(3));
                vo.setArchivopdf2(rs.getBytes(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                rs.close();
                preparedStatement.close();
            } catch (Exception ex) {
            }
        }
        return vo;
    }

}

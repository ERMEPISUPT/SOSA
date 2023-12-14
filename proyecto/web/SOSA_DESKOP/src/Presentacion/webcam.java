/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Config.Conexion;
import Entidad.clsEEmpleado;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ORDENADOR
 */
public class webcam {

    public static void main(String[] args) {
        startWebcam();
    }

    public static void startWebcam() {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(320, 240));
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setMirrored(false);
        JFrame jFrame = new JFrame();
        jFrame.add(webcamPanel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        do {
            try {
                BufferedImage image = webcam.getImage();
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Result result = new MultiFormatReader().decode(bitmap);
                if (result.getText() != null) {
                    JOptionPane.showMessageDialog(null, result.getText(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    Conexion cn=new Conexion();
                    Connection con; 
                    PreparedStatement ps;
                    ResultSet rs;
                    Statement st;
                    clsEEmpleado E =new clsEEmpleado();
                    ResultSet rst = null;
                    String SQL = "SELECT * FROM tbempleado WHERE CONCAT(dni, clave) = '" + result.getText() + "'";
                    System.out.println("sentencia " + SQL);

                    try {
                        con = (Connection) cn.getConnection();
                        ps = con.prepareStatement(SQL);
                        rst = ps.executeQuery();

                        // Verificar si hay resultados en el ResultSet
                        if (rst.next()) {
                            // Si hay resultados, mostrar FrmPrincipal
                            FrmPrincipal frmPrincipal = new FrmPrincipal();
                            frmPrincipal.setVisible(true);
                            jFrame.dispose();
                            webcam.close();
                            break;
                        } else {
                            // No hay resultados, puedes mostrar un mensaje o manejarlo según tus necesidades
                            System.out.println("No se encontraron resultados.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.toString());

                    }

                    jFrame.setVisible(false);
                    jFrame.dispose();
                    webcam.close();
                    break;
                }
            } catch (Exception e) {
            }
        } while (true);
    }
}
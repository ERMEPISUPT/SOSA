<%-- 
    Document   : pdf
    Created on : 30 oct 2023, 12:11:52
    Author     : ORDENADOR
--%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="Modelo.*"%>
<%@page import="ModeloDAO.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.itextpdf.text.*"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page contentType="application/pdf"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    Connection con;
    Statement st;
    ResultSet rs;
    int varid = Integer.parseInt(request.getParameter("id"));

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsosa", "root", "");

        // Consulta para obtener los datos del empleado a editar
        String query = "SELECT * FROM tbreservas WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, varid);
        rs = ps.executeQuery();

        if (rs.next()) {
            // Obtener los datos del empleado de la base de datos
            int idR = rs.getInt("id");
            String clienteR = rs.getString("cliente_dni");
            int maquinasR = rs.getInt("maquinas_id");
            String fechareservaR = rs.getString("fechareserva");
            String estadoR = rs.getString("estado");
            String entradaR = rs.getString("fecha_entrada");
            String salidaR = rs.getString("fecha_salida");
            int ptotalR = rs.getInt("ptotal");

            
            String Query2 = "SELECT * FROM tbmaquinas WHERE id=?";
            PreparedStatement Ms = con.prepareStatement(Query2);
            Ms.setInt(1, maquinasR); // Suponiendo que id es una clave externa en la tabla "otraTabla"
            ResultSet TMs = Ms.executeQuery();

            if (TMs.next()) {
                int idM = TMs.getInt("id");
                int reservaidM = TMs.getInt("dni_cliente");
                String numeroM = TMs.getString("numero");
                String tipoM = TMs.getString("tipo");
                String precioM = TMs.getString("precio");
                String estadoM = TMs.getString("estado");
                String firma = TMs.getString("firma");
                
                String Query3 = "SELECT * FROM tbusuarios WHERE dni=?";
                PreparedStatement Us = con.prepareStatement(Query3);
                Us.setString(1, clienteR); // Suponiendo que id es una clave externa en la tabla "otraTabla"
                ResultSet TUs = Us.executeQuery();

                if (TUs.next()) {
                    String dni = TUs.getString("dni");
                    String clave = TUs.getString("clave");
                    String nombre = TUs.getString("nombre");
                    String apellido = TUs.getString("apellido");
                    String email = TUs.getString("email");
                    String telefono = TUs.getString("telefono");
                    String estado = TUs.getString("estado");
                    int cargo = TUs.getInt("fk_cargo");
                    
                    String Query4 = "SELECT * FROM tbformadepago WHERE id=1";
                    PreparedStatement Fp = con.prepareStatement(Query4);
                    Us.setString(1, clienteR); // Suponiendo que id es una clave externa en la tabla "otraTabla"
                    ResultSet Fps = Fp.executeQuery();

                    if (Fps.next()) {
                        int idMP = Fps.getInt("id");
                        String bancoMP = Fps.getString("banco");
                        String cuentaMP = Fps.getString("numero_cuenta");
                        String titularMP = Fps.getString("titular");
                    
                    // Crear un nuevo documento PDF
                    Document document = new Document();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PdfWriter.getInstance(document, baos);
                    document.open();

                    // Configurar el contenido del PDF
                    Paragraph paragraph = new Paragraph();
                    paragraph.add("                                           CONTRATO Y VOUCHER DE PAGO"+"                       RUC: 2044921677\n\n");
                    paragraph.add("SOSA"+"                     "+"       "+"          "+"            "+"     "+"      "+"          "+" "+" "+"FECHA :       "+fechareservaR+"          "+"\n");
                    paragraph.add("E HIJAS S.A.C."+"                     "+"            "+"     "+"      "+"          "+" "+" "+"Nro RESERVA : "+idR+"            "+"\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("EL S./Sña. " + nombre +" "+apellido+" ,con DNI "+dni+"\n");
                    paragraph.add("Para alquilar la " + tipoM +" numero "+numeroM+" ,con un costo de s/"+precioM+" por dia máquina seca incluye IGV "
                    + "18 porciento. Desde el " + entradaR +" hasta "+salidaR+" ,La suma por ese periodo de tiempo es de s/"+ptotalR+".\n");
                    paragraph.add("\n");
                    paragraph.add("CONDICIONES"+ "\n");
                    paragraph.add("-El estado de la maquina permanecera en pendiente hasta que se comfirme el pago."+"\n");
                    paragraph.add("-Si la maquina alquilada llegase a averiarce en medio del tiempo alquilado llamar al siguiente numero : 952523247."+"\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("\n");
                    paragraph.add("FORMA DE PAGO\n");        
                    paragraph.add("El pago se realizara en un plazo de 24 horas en el siguiente banco y numero de cuenta:\n"); 
                    paragraph.add("Nombre del banco:" + bancoMP + "\n");
                    paragraph.add("Numero de cuenta:" + cuentaMP + "\n");
                    paragraph.add("Titular:" + titularMP + "\n");
                    document.add(paragraph);
                    document.close();

                    // Definir el nombre del archivo PDF a generar
                    String pdfFileName = "ContratoEmpleado.pdf";

                    // Preparar la respuesta para el navegador
                    response.setHeader("Content-Disposition", "inline; filename=" + pdfFileName);

                    // Obtener el flujo de salida para escribir el PDF
                    OutputStream outStream = response.getOutputStream();
                    baos.writeTo(outStream);
                    outStream.flush();
                    outStream.close();
                    } else {
                    // Manejar el caso en que no se encuentre el empleado
                    out.println("Empleado no encontrado.");
                }
                } else {
                // Manejar el caso en que no se encuentre el empleado
                out.println("Empleado no encontrado.");
            }
            } else {
            // Manejar el caso en que no se encuentre el empleado
            out.println("Empleado no encontrado.");
        }
        } else {
            // Manejar el caso en que no se encuentre el empleado
            out.println("Empleado no encontrado.");
    }
    } catch (Exception e) {
        // Manejar excepciones
        out.println("Error: " + e.getMessage());
    }
%>
</body>
</html>
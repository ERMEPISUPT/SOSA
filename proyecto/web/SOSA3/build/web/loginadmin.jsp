<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <br>
        <%@page import="java.sql.*"%>
        <%@page import="java.util.*"%>
        <%
        Connection con = null;
        String username = request.getParameter("txtdni");
        String password = request.getParameter("txtcla");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbsosa", "root", "");

            // Modifica la consulta SQL para incluir fk_cargo
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tbusuarios WHERE dni = ? AND clave = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Obtiene el valor de fk_cargo
                int fkCargo = rs.getInt("fk_cargo");

                // Redirige a diferentes páginas según el valor de fk_cargo
                if (fkCargo == 1) {
                    response.sendRedirect("Principal.jsp?dni="+username);
                } else if (fkCargo == 2) {
                    response.sendRedirect("Principal.jsp?dni=username");
                } else if (fkCargo == 3) {
                    response.sendRedirect("Principal.jsp?dni=username");
                } else if (fkCargo == 4) {
                    response.sendRedirect("PrincipalUser.jsp?dni=username");
                } else {
                    out.println("Cargo no reconocido");
                }
            } else {
                out.println("Credenciales incorrectas");
            }

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        %>

    </body>
</html>
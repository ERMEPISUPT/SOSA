<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Maquinas"%>
<%@page import="ModeloDAO.MaquinasDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Maquinas</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Maquinas Disponibles</h1>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>NUMERO</th>
                    <th>TIPO</th>
                    <th>PRECIO</th>
                    <th>ESTADO</th>
                </tr>
            </thead>
            
            <%
                MaquinasDAO dao = new MaquinasDAO();
                List<Maquinas> list = dao.listar();
                Iterator<Maquinas> iter = list.iterator();
                Maquinas hab = null;
                while (iter.hasNext()) {
                    hab = iter.next();
            %>
            
            <tbody>
                <tr>
                    <td><%= hab.getId()%></td>
                    <td><%= hab.getNumero()%></td>
                    <td><%= hab.getTipo()%></td>
                    <td><%= hab.getPrecio()%></td>
                    <td><%= hab.getEstado()%></td>
                    
                </tr>
                
                <% } %>
            </tbody>
        </table>
        
        <a class="btn btn-secondary" href="./PrincipalUser.jsp">Regresar</a>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Lista de Empleados</h1>
    </center>

    <div class="datagrid">
        <a id="mostrar" href="ControllerPdf?action=insert&id=<%=pdfvo.getCodigopdf()%>"> <img src="Imagen/nuevo.png" title="Nuevo registro"/></a>
        <table>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Pdf</th>
                    <th>editar / eliminar / aprobacion</th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td><%=pdfvo.getCodigopdf()%></td>
                    <td><%=pdfvo.getNombrepdf()%></td>
                    <td><%=pdfvo.getDireccionpdf()%></td>
                    <td>
                        <a href="ControllerPdf?action=edit&id=<%=pdfvo.getCodigopdf()%>"> <img src="Imagen/editar.png" title="Modificar"/></a>----------
                        <a href="ControllerPdf?action=delete&id=<%=pdfvo.getCodigopdf()%>"> <img src="Imagen/delete.png" title="Eliminar"/></a>----------
                        <a href="ControllerPdf?action=pdf&id=<%=pdfvo.getCodigopdf()%>"> <img src="Imagen/mpdf.png" title="PDF"/></a>
                    </td>
                    </td>
                </tr>
                <%}
                    }%>
            </tbody>
        </table>
    </div>    
</body>
</html>

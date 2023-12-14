<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="Modelo.Reservas"%>
<%@page import="ModeloDAO.ReservasDAO"%>
<%@page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Alquiler</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333333;
            font-family: Arial, sans-serif;
            padding-top: 50px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        .container h1 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ced4da;
            border-radius: 4px;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 4px;
        }

        .btn-primary:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
    <div class="container">
        <% 
            ReservasDAO dao=new ReservasDAO();
            int id = Integer.parseInt(request.getParameter("vid"));
            Reservas reservas = dao.list(id);
        %>
        
        <h1 class="mt-4">MODIFICAR ALQUILER</h1>
        
        <form action="ControladorReservas" class="mt-4">
            <div class="form-group">
                <label for="txtid" class="form-label">ID:</label>
                <input type="text" class="form-control" name="txtid" value="<%=reservas.getId()%>">
            </div>
            <div class="form-group">
                <label for="txtc_dni" class="form-label">DNI CLIENTE:</label>
                <input type="text" class="form-control" name="txtc_dni" value="<%=reservas.getCliente_dni()%>">
            </div>
            <div class="form-group">
                <label for="txtm_id" class="form-label">ID MAQUINA:</label>
                <input type="text" class="form-control" name="txtm_id" value="<%=reservas.getMaquinas_id()%>">
            </div>
            <div class="form-group">
                <label for="txtf_re" class="form-label">FECHA RESERVA:</label>
                <input type="text" class="form-control" name="txtf_re" value="<%=reservas.getFechareserva()%>">
            </div>
            <div class="form-group">
                <label for="txtest" class="form-label">ESTADO:</label>
                <select class="form-control" name="txtest" id="txtest" value="<%=reservas.getEstado()%>">
                  <option value="Disponible">Disponible</option>
                  <option value="Pendiente">Pendiente</option>
                  <option value="Ocupado">Ocupado</option>
                  <option value="Mantenimiento">Mantenimiento</option>
                </select>
            </div>
            <div class="form-group">
                <label for="txtf_en" class="form-label">FECHA ENTRADA:</label>
                <input type="text" class="form-control" name="txtf_en" value="<%=reservas.getFecha_entrada()%>">
            </div>
            <div class="form-group">
                <label for="txtf_sal" class="form-label">FECHA SALIDA:</label>
                <input type="text" class="form-control" name="txtf_sal" value="<%=reservas.getFecha_salida()%>">
            </div>
            <div class="form-group">
                <label for="txtptl" class="form-label">TOTAL:</label>
                <input type="text" class="form-control" name="txtptl" value="<%=reservas.getPtotal()%>">
            </div>
            <input type="hidden" name="txtvid" value=0>
            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
            <a href="ControladorReservas?accion=listar" class="btn btn-secondary">Regresar</a>
        </form>
    </div>
          

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

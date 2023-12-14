<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agregar Maquina</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-4">AGREGAR MAQUINA</h1>
        <form action="ControladorHabitaciones" class="mt-4">
            <div class="form-group">
                <label for="txtid" class="form-label">ID MAQUINA:</label>
                <input type="text" class="form-control" name="txtid">
            </div>
            <div class="form-group">
                <label for="txtnum" class="form-label">NUMERO MAQUINA:</label>
                <input type="text" class="form-control" name="txtnum">
            </div>
            <div class="form-group">
                <label for="txttip" class="form-label">TIPO MAQUINA:</label>
                <input type="text" class="form-control" name="txttip" id="txttip">
            </div>
            <div class="form-group">
                <label for="txtpre" class="form-label">PRECIO:</label>
                <input type="text" class="form-control" name="txtpre" id="txtpre">
            </div>
            <div class="form-group">
                <label for="txtestado" class="form-label">ESTADO:</label>
                <input type="text" class="form-control" name="txtestado" value="Disponible" readonly>
            </div>
            
            <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
            <a href="ControladorHabitaciones?accion=listar" class="btn btn-secondary">Regresar</a>
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    <script>
        // Obtener el campo de entrada
        var txtpre = document.getElementById('txtpre');

        // Agregar evento de escucha para el evento "input"
        txtpre.addEventListener('input', function(e) {
            // Obtener el valor actual del campo de entrada
            var valor = txtpre.value;

            // Verificar si el valor ingresado es un número float válido
            if (valor === "") {
            // Si no se ingresa nada, establecer el valor predeterminado como 0
            txtpre.value = "0";
            } else if (isNaN(parseFloat(valor))) {
            // Si no es un número float válido, borrar el contenido del campo de entrada
            txtpre.value = "";
            }
        });
    </script>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <style>
        body {
            background-color: #f4f4f4; 
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #555; 
            text-align: center;
        }

        form {
            background-color: #fff; 
            border-radius: 10px; 
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); 
            width: 400px; 
            margin: 0 auto; 
            padding: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007BFF; 
            color: #fff; 
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
    </head>
    <body>
        <h1>LOGIN</h1>
        <br>
        <%@page import="java.sql.*"%>
        <%@page import="java.util.*"%>

        <form action="loginadmin.jsp?vardni=txtdni" method="POST">
            <br>Ingrese su DNI:
            <input type="text" name="txtdni">
            <br>Ingrese su clave:
            <input type="text" name="txtcla">
            <br>
            <div class="form-group">
                <label>reCaptcha:</label>
                <div class="g-recaptcha" data-sitekey="6LcGw_0oAAAAALQPXlC_pYRJKleVQInCuRwa_22g"></div>
            </div>
            <br>  
            <input type="submit" name="Ingresar" value="Ingresar">
        </form>
            <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </body>
</html>

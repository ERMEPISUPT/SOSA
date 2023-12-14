<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LOGIN USUARIOS</title>
    <link href="css/estilos.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        body {
            background-size: cover;
            background-position: center;
        }
        .login-container {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-form {
            width: 400px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 5px;
        }
        .login-img {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }
        .login-img img {
            height: 80px;
            width: 80px;
        }
        .btn-login {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container-fluid login-container">
        <form action="Controlador?vardni=txtdni" class="login-form">
            <div class="login-img">
                <img src="images/logo2.png" height="80" width="80">
            </div>
            <div class="form-group text-center">
                <p><strong>+++LOGIN+++</strong></p>
            </div>
            <div class="form-group">
                <label for="txtdni">DNI:</label>
                <input class="form-control" type="text" name="txtdni" id="txtdni" placeholder="Ingrese su DNI">
            </div>
            <div class="form-group">
                <label for="txtclave">Contraseña:</label>
                <input type="password" name="txtclave" id="txtclave" placeholder="Ingrese su Contraseña" class="form-control">
            </div>
            <div class="form-group">
                <label>reCaptcha:</label>
                <div class="g-recaptcha" data-sitekey="6LcGw_0oAAAAALQPXlC_pYRJKleVQInCuRwa_22g"></div>
            </div>
            <div class="form-group">
                <a href="ControladorAgregarUsuarios?accion=add" class="link-primary">Registrarse</a>
                <a href="PrincipalUser.jsp">user</a>
                <a href="Principal.jsp">admin</a>
            </div>
            <input class="btn btn-primary btn-block btn-login" type="submit" name="accion" value="Ingresar">
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</body>
</html>

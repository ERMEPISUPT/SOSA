<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Alquiler de Maquinaria Pesada</title>
	<meta name="description" content="">
<!--

Template 2079 Garage

http://www.tooplate.com/view/2079-garage

-->
	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/slider.css">
	<link rel="stylesheet" type="text/css" href="style/mystyle.css">
</head>
<body>
<!-- Header -->
<div class="allcontain">
	<div class="header">
			<ul class="socialicon"><br>
				<li><a href="ejemplo1.html"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="https://www.universidadperu.com/empresas/sosa-e-hijas.php"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-pinterest"></i></a></li><br>
			</ul>
			<ul class="givusacall"><br>
                                <li>TELEFONO : 952523247</li><br>
                                <li>Bienvenido al sistema...<strong>Administrador: dni</strong></li>
			</ul>
                        <ul class="logreg">
				<div class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Cerrar Sesión
                                    </a>
                                    <div class="dropdown-menu text-center">
                                        <a><img src="img/img1.png" height="40" width="40"></a><br>
                                        <a>${dni}</a>
                                        <div class="dropdown-divider"></div>
                                        <a href="index.jsp" class="dropdown-item">Salir</a>
                                    </div>
                                </div>
			</ul>
	</div>
	<!-- Navbar Up -->
	<nav class="topnavbar navbar-default topnav">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed toggle-costume" data-toggle="collapse" data-target="#upmenu" aria-expanded="false">
					<span class="sr-only"> Toggle navigaion</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand logo" href="#"><img src="images/logo4.png" alt="logo"></a>
			</div>	 
		</div>
		<div class="collapse navbar-collapse" id="upmenu">
			<ul class="nav navbar-nav" id="navbarontop">
                            <button onclick="window.location.href='ControladorUsuarios?accion=listar'">
                            <span class="postnewcar">GESTION DE USUARIOS</span>
                            </button>
                            <button onclick="window.location.href='ControladorHabitaciones?accion=listar'">
                            <span class="postnewcar">GESTION DE MAQUINAS</span>
                            </button>
                            <button onclick="window.location.href='ControladorReservas?accion=listar'">
                            <span class="postnewcar">GESTION DE ALQUILER</span>
                            </button>
                            <button onclick="window.location.href='VistaReservas/listarH.jsp'">
                            <span class="postnewcar">HISTORIAL DE MAQUINAS ALQUILADAS</span>
                            </button>
			</ul>
		</div>
	</nav>
</div>                                       
<!--_______________________________________ Carousel__________________________________ -->
<div class="allcontain">
	<div id="carousel-up" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner " role="listbox">
			<div class="item">
				<img src="images/retroescabador.jpg" alt="oldcar">
				<div class="carousel-caption">
					<h2>RETROEXCAVADOR CAT</h2>
					<p>Las retroexcavadoras son máquinas versátiles que combinan las funciones,<br>
						de una excavadora y una cargadora frontal. </p>
				</div>
			</div>
			<div class="item">
				<img src="images/cargador2.jpg" alt="porche">
				<div class="carousel-caption">
					<h2>CARGADOR CAT 950H</h2>
						<p>Los cargadores son máquinas diseñadas para cargar materiales como tierra, <br>
						arena, grava u otros tipos de carga en camiones u otros vehículos de transporte.</p>
				</div>
			</div>
			<div class="item active">
				<img src="images/cargador3.jpg" alt="benz">
				<div class="carousel-caption">
					<h2>CAMIONETAS</h2>
					<p>Las camionetas 4x4 son vehículos todo terreno con tracción en las cuatro <br>
						ruedas.</p>
				</div>
			</div>
                        <div class="item">
                                <img src="images/cargador4.jpg" alt="benz">
                                <div class="carousel-caption">
                                        <h2>MARTILLO NEUMATICO</h2>
                                        <p>Los martillos neumáticos son herramientas impulsadas por aire<br>
                                            comprimido que se utilizan para romper o demoler superficies duras como concreto o <br>
                                            roca. </p>
                                </div>
			</div>
                        <div class="item">
				<img src="images/cargador5.jpg" alt="benz">
				<div class="carousel-caption">
					<h2>COMPRESORAS NEUMATICAS</h2>
					<p>Las compresoras son máquinas diseñadas para comprimir aire u otros <br>
						gases. </p>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default midle-nav">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed textcostume" data-toggle="collapse" data-target="#navbarmidle" aria-expanded="false">
						<h1>SEARCH TEXT</h1>
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			
		</nav>
	</div>
</div>
<!-- Script para inicializar el gráfico de líneas -->
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/isotope.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> 
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
</body>
</html>

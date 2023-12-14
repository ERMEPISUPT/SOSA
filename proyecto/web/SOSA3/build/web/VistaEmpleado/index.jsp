<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="https://www.universidadperu.com/empresas/sosa-e-hijas.php"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-pinterest"></i></a></li><br>
			</ul>
			<ul class="givusacall"><br>
                                <li>TELEFONO : 952523247</li><br>
                                <li>Bienvenido al sistema...<strong>Administrador: ${dni}</strong></li>
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
                                <span class="postnewcar">Mantenimiento de Usuarios</span>
                                </button>
                                <button onclick="window.location.href='ControladorHabitaciones?accion=listar'">
                                <span class="postnewcar">Mantenimiento de Maquinas</span>
                                </button>
                                <button onclick="window.location.href='ControladorReservas?accion=listar'">
                                <span class="postnewcar">Mantenimiento de Alquiner</span>
                                </button>
			</ul>
		</div>
	</nav>
</div>
<!--_______________________________________ Carousel__________________________________ -->
<div class="allcontain">
	<div id="carousel-up" class="carousel slide" data-ride="carousel">
		<div class="carousel-inner " role="listbox">
			<div class="item active">
				<img src="images/Maquina1.jpg" alt="oldcar">
				<div class="carousel-caption">
					<h2>Retroexcabadora</h2>
					<p>hola u.u ,<br>
						chau xd </p>
				</div>
			</div>
			<div class="item">
				<img src="image/porche.jpg" alt="porche">
				<div class="carousel-caption">
					<h2>Porche</h2>
						<p>Lorem ipsum dolor sit amet, consectetur ,<br>
						sed do eiusmod tempor incididunt ut labore </p>
				</div>
			</div>
			<div class="item">
				<img src="image/benz.jpg" alt="benz">
				<div class="carousel-caption">
					<h2>Car</h2>
					<p>Lorem ipsum dolor sit amet, consectetur ,<br>
						sed do eiusmod tempor incididunt ut labore </p>
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
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/isotope.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> 
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
</body>
</html>
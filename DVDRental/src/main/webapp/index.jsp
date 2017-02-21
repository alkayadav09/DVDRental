<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src = "resources/js/jquery-3.1.1.min.js"></script>
<!-- <script type="text/javascript" src="resources/js/jquery.simplePagination.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/simplePagination.css"/> -->
<script src = "resources/js/bootstrap.js"></script>
<link href = "resources/css/bootstrap.css" rel = "stylesheet">
<link rel="stylesheet" href="resources/css/bootstrap-table.css">
<script src="resources/js/bootstrap-table.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="border: 2px solid grey; background-color:pink;">
			<div class="col-md-12 , text-center" >
				<h2>DVD Rentals</h2>
			</div>
		</div>	
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- <div class=navbar-header>
				<button type=" class=navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
      			  	<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">DVD Rentals</a>
			</div> -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<a href="getHome.html">Home</a>
					</li>
					<li>
						<a href="#">Rentals</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">Movie<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="getFilm.html">Search</a></li>
							<li><a href="addMovie.html">Add</a></li>
							<li><a href="#">Update</a></li>	
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">Actor<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="getActors.html">Search</a></li>
							<li><a href="addActor.html">Add</a></li>
							<li><a href="#">Update</a></li>	
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">Employee<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Search</a></li>
							<li><a href="#">Add</a></li>
							<li><a href="#">Update</a></li>	
						</ul>
					</li>	
				</ul>
			</div>
		</div>
	</nav>
	 
</body>
</html>

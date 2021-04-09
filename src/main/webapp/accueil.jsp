<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  	<div class="card-header text-primary text-center" style="font-size:30px">
			    Bonjour ${name }
			  	</div>
				<div class="card-body d-flex justify-content-between">
					<a class="btn btn-success" href="catalogue">Consulter le catalogue</a>
					<a class="btn btn-primary" href="#">Suivre vos commandes</a>
					<a class="btn btn-warning" href="panier">Visualiser votre panier</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogue</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container">
		<div class="col-md-12">
			<div class="card my-5">
			  	<div class="card-header text-primary text-center" style="font-size:30px">
			    	Catalogue
			  	</div>
				<div class="card-body">
					<select class="form-control col-md-4 mb-5">
					  <option selected>Choisissez le genre</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
					</select>  
					  <table class="table">
						  <thead>
						    <tr>
						      <th scope="col">Réference</th>
						      <th scope="col">Designation</th>
						      <th scope="col">Prix</th>
						      <th scope="col">photo</th>
						      <th scope="col">Stock</th>
					      	  <th scope="col">Categorie</th>
					      	  <th></th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <th scope="row">1</th>
						      <td>Otto</td>
						      <td>@mdo</td>
						      <td>Mark</td>
						      <td>Mark</td>
						      <td><img src="photos/test.png" alt="Erreurs" height="50" width="50"></td>
						      <td>
						      	<form action="ajouterPanier.sebo" method="post">
						      		<button class="btn btn-primary">Ajouter au panier</button>
						      	</form> 
						      </td>
						    </tr>
						  </tbody>
						</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
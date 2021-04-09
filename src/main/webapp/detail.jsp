<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détail</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  <div class="card-header text-primary display-4 text-center">
			    Détail de l'article	
			  </div>
			  <div class="card-body">
				  <div class="form-group">
				    <label for="" class="font-weight-bold">Réference</label>
				    <div class="text-success">${article.id }</div>
				  </div>
				  <div class="form-group">
				    <label for="" class="font-weight-bold">Designation</label>
				    <div class="text-danger">${article.designation }</div>
				  </div>
				  <div class="form-group">
				  	<label for="" class="font-weight-bold">Prix</label>
				    <div class="text-success">${article.prix } MAD</div>
				  </div>
				  <div class="form-row">
					<div class="form-group col-md-6">
						<label for="" class="font-weight-bold">Categorie</label>
						<div class="text-danger">${article.id_cat }</div>
				    </div>
				    <div class="form-group col-md-6">
						<label for="" class="font-weight-bold">Stock</label>
						<div class="text-danger">${article.stock }</div>
				    </div>
				   </div>
				   <div class="form-group">
				    <label for="" class="font-weight-bold">Photo</label>
				    <div class=""><img alt="..." height="80" width="80" src="${pageContext.request.contextPath}/${article.photo }"></div>
				   </div>
			  </div>
			  <div class="card-footer d-flex">
			    <a href="catalogue.sebo" class="btn btn-danger mr-4">Retour</a>
			    <form action="ajouterPanier.sebo?CodeArticle=${article.id }" method="post">
					<button class="btn btn-light">
						<img alt="..." src="${pageContext.request.contextPath}/icons/panier.png" height="30" width="30">
					</button>
				</form> 
			  </div>
			</div>
		</div>
	</div>
</body>
</html>
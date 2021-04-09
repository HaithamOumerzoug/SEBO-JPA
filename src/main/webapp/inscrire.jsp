<%@page import="sebo.haitham_said.metier.Client"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscrire</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  <div class="card-header text-primary display-4 text-center">
			    Inscrivez vous	
			  </div>
			  <div class="card-body">
			    <form action="inscrire" method="post">
				  <div class="form-group">
				    <label for="nom">Nom</label>
				    <input type="text" class="form-control" name="nom"  aria-describedby="nom" value="${client.nom }">
				    <div class="text-danger"><i>${erreurs['nom'] }</i></div>
				  </div>
				  <div class="form-group">
				    <label for="prenom">Prénom</label>
				    <input type="text" class="form-control" name="prenom" aria-describedby="prenom" value="${client.prenom }">
				    <div class="text-danger"><i>${erreurs['prenom'] }</i></div>
				  </div>
				  <div class="form-group">
				  	<label for="nom">E-mail</label>
				    <input type="email" class="form-control" name="email" value="${client.email }">
				    <div class="text-danger"><i>${erreurs['email'] }</i></div>
				  </div>
				  <div class="form-group">
				  	<label for="nom">Adresse</label>
				    <input type="text" class="form-control" name="adresse" value="${client.adresse }">
				  </div>
				  <div class="form-row">
					<div class="form-group col-md-6">
				    	<input type="text" class="form-control" placeholder="Ville" name="ville" value="${client.ville }">
				    </div>
				    <div class="form-group col-md-6">
				    	<input type="text" class="form-control" placeholder="Code postal" name="codepostal" value="${client.codepostal }"><%-- ou bien param.codepostal --%>
				    </div>
				   </div>
				  <div class="form-group">
				    <label for="motdepass">Mot de passe</label>
				    <input type="password" class="form-control" name="motdepasse">
				    <div class="text-danger"><i>${erreurs['motdepasse'] }</i></div>
				  </div>
				  
				  <button type="submit" class="btn btn-success btn-block">Ok</button>
				</form>
			  </div>
			  <div class="card-footer d-flex justify-con">
			    <a href="index" class="btn btn-danger mr-4">Retour</a>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>
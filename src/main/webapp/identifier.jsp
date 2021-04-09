<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Identifier</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  <div class="card-header text-primary display-4 text-center">
			    Identifier vous	
			  </div>
			  <div class="card-body">
			    <form action="identifier" method="post">
				  <div class="form-group">
				  	<label for="nom">E-mail</label>
				    <input type="text" class="form-control" name="email" value="${email }">
				    <div class="text-danger"><i>${erreurs['email'] }</i></div>
				  </div>
				  <div class="form-group">
				    <label for="motdepass">Mot de passe</label>
				    <input type="password" class="form-control" name="motdepasse">
				    <div class="text-danger"><i>${erreurs['motdepasse'] }</i></div>
				  </div>
				  <div class="text-danger"><i>${erreurs['general'] }</i></div>
				  
				  <button type="submit" class="btn btn-info btn-block">Ok</button>
				</form>
			  </div>
			  <div class="card-footer">
			  	<a class="btn btn-info float-right" href="inscrire">inscrivez vous</a>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>
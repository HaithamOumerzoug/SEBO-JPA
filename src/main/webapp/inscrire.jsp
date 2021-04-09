<%@page import="sebo.haitham_said.metier.Client"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<% Map<String,String> erreurs =(HashMap<String,String>)request.getAttribute("erreurs"); 
%>
<% Client client =(Client)request.getAttribute("client"); %>
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
				    <input type="text" class="form-control" name="nom"  aria-describedby="nom" value="<%=client.getNom()==null?"":client.getNom() %>">
				    <div class="text-danger"><i><%=erreurs.get("nom").equals("")?"":erreurs.get("nom") %></i></div>
				  </div>
				  <div class="form-group">
				    <label for="prenom">Prénom</label>
				    <input type="text" class="form-control" name="prenom" aria-describedby="prenom" value="<%=client.getPrenom()==null?"":client.getPrenom() %>">
				    <div class="text-danger"><i><%=erreurs.get("prenom").equals("")?"":erreurs.get("prenom") %></i></div>
				  </div>
				  <div class="form-group">
				  	<label for="nom">E-mail</label>
				    <input type="email" class="form-control" name="email" value="<%=client.getEmail()==null?"":client.getEmail() %>">
				    <div class="text-danger"><i><%=erreurs.get("email").equals("")?"":erreurs.get("email") %></i></div>
				  </div>
				  <div class="form-group">
				  	<label for="nom">Adresse</label>
				    <input type="text" class="form-control" name="adresse" value="<%=client.getAdresse()==null?"":client.getAdresse() %>">
				  </div>
				  <div class="form-row">
					<div class="form-group col-md-6">
				    	<input type="text" class="form-control" placeholder="Ville" name="ville" value="<%=client.getVille()==null?"":client.getVille() %>">
				    </div>
				    <div class="form-group col-md-6">
				    	<input type="text" class="form-control" placeholder="Code postal" name="codepostal" value="<%=client.getCodepostal()==0?"":client.getCodepostal() %>">
				    </div>
				   </div>
				  <div class="form-group">
				    <label for="motdepass">Mot de passe</label>
				    <input type="password" class="form-control" name="motdepasse">
				    <div class="text-danger"><i><%=erreurs.get("motdepasse").equals("")?"":erreurs.get("motdepasse") %></i></div>
				  </div>
				  
				  <button type="submit" class="btn btn-success btn-block">Ok</button>
				</form>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<form action="catalogue.sebo" method="post" class="mb-5 d-flex ">
						<select class="form-control col-md-4 mr-3" name="categorie">
						  <option selected value="cat_name"></option>
						  <c:forEach items="${cat_model.categories}" var="categorie">
						  	<option value="${categorie.cat }">${categorie.cat }</option>
						  </c:forEach>
						</select>
						<button type="submit" class="btn btn-primary btn-sm">Choisissez le genre</button> 
					</form> 
					  <table class="table">
						  <thead>
						    <tr>
						      <th scope="col">Réference</th>
						      <th scope="col">Designation</th>
						      <th scope="col">Prix</th>
						      <th scope="col">Photo</th>
						      <th scope="col">Stock</th>
					      	  <th scope="col">Categorie</th>
					      	  <th></th>
						    </tr>
						  </thead>
						  <tbody>
						  	<c:forEach items="${model.articles}" var="article">
							    <tr>
							      <th scope="row"><a href="${pageContext.request.contextPath}/detail.sebo?CodeArticle=${article.id }" class="text-decoration-none">${article.id }</a></th>
							      <td>${article.designation }</td>
							      <td>${article.prix }</td>
							      <td><img src="${pageContext.request.contextPath}/${article.photo }" alt="Erreur" height="50" width="50"></td>
							      <td>${article.stock }</td>
							      <td>${article.id_cat }</td>
							      <td>
							      	<form action="ajouterPanier.sebo" method="post">
							      		<button class="btn btn-primary">Ajouter au panier</button>
							      	</form> 
							      </td>
							    </tr>
							 </c:forEach>
						  </tbody>
						</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
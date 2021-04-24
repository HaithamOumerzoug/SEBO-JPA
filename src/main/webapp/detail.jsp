<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><fmt:message key="detail" /></title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  <div class="card-header text-primary display-4 text-center">
			    <fmt:message key="detailArt" />
			  </div>
			  <div class="card-body">
				  <div class="form-group">
				    <label for="" class="font-weight-bold"><fmt:message key="ref" /></label>
				    <div class="text-success">${article.id }</div>
				  </div>
				  <div class="form-group">
				    <label for="" class="font-weight-bold">Designation</label>
				    <div class="text-danger">${article.designation }</div>
				  </div>
				  <div class="form-group">
				  	<label for="" class="font-weight-bold"><fmt:message key="prix" /></label>
				    <div class="text-success"><fmt:formatNumber value = "${article.prix}" type = "currency"/></div>
				  </div>
				  <div class="form-row">
					<div class="form-group col-md-6">
						<label for="" class="font-weight-bold"><fmt:message key="categorie" /></label>
						<div class="text-danger">${article.category.cat }</div>
				    </div>
				    <div class="form-group col-md-6">
						<label for="" class="font-weight-bold">Stock</label>
						<div class="text-danger">${article.stock }</div>
				    </div>
				   </div>
				   <div class="form-group">
				    <label for="" class="font-weight-bold"><fmt:message key="photo" /></label>
				    <div class=""><img alt="..." height="80" width="80" src="${pageContext.request.contextPath}/${article.photo }"></div>
				   </div>
			  </div>
			  <div class="card-footer d-flex">
			    <a href="catalogue" class="btn btn-danger mr-4"><fmt:message key="retour" /></a>
			    <form action="ajouterPanier?CodeArticle=${article.id }" method="post">
					<button class="btn btn-light">
						<img alt="..." src="${pageContext.request.contextPath}/icons/panier.png" height="30" width="30">
					</button>
				</form> 
			  </div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
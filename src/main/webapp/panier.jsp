<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panier</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  <div class="card-header text-primary display-4 text-center">
			    Panier
			  </div>
			  <div class="card-body">
				  	<c:choose>
					  	<c:when test="${articles!=null }">
						  	<c:forEach items="${articles }" var="article">
						  		<div class="form-group">
							    	<label for="" class="font-weight-bold">Designation</label>
							    	<div class="text-danger">${article.designation }</div>
							  	</div>
							  <div class="form-group">
							  	<label for="" class="font-weight-bold">Prix</label>
							    <div class="text-success">${article.prix } MAD</div>
							  </div>
							  <div class="form-group">
									<label for="" class="font-weight-bold">Stock</label>
									<div class="text-danger">${article.stock }</div>
							    </div>
							  <div class="form-row">
								<div class="form-group">
							    	<label for="" class="font-weight-bold">Photo</label>
							    	<div class=""><img alt="..." height="80" width="80" src="${pageContext.request.contextPath}/${article.photo }"></div>
							   </div>
							    
							   </div>
							   <form action="commander.sebo?CodeArticle=${article.id }" method="post"> 
								   <div class="form-row">
									   <div class="form-group col-md-6">
											<label for="quantite" class="font-weight-bold">Quantite</label>
											 <input type="number" min="1" max="${article.stock }" value="1" class="form-control" name="quantite">
									    </div>
										<button type="submit" class="btn ml-4">
											<img alt="..." src="${pageContext.request.contextPath}/icons/commander.png" height="30" width="30">
										</button> 
									</div>
								</form>
								<hr>
							</c:forEach>
					  	</c:when>
					  <c:otherwise>
					  	<p>Panier est vide!</p>
					  </c:otherwise>
				  </c:choose> 
				  
			  </div>
			  <div class="card-footer d-flex">
			    <a href="accueil" class="btn btn-danger mr-4">Retour</a>
			  </div>
			</div>
		</div>
	</div>
					
</body>
</html>
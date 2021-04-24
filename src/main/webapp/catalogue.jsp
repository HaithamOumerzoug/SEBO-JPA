<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><fmt:message key="catal" /></title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container">
		<div class="col-md-12">
			<div class="card my-5">
			  	<div class="card-header text-primary text-center" style="font-size:30px">
			    	<fmt:message key="catal" />
			  	</div>
				<div class="card-body">
					<form action="catalogue" method="post" class="mb-5 d-flex ">
						<select class="form-control col-md-4 mr-3" name="categorie">
						  <option <c:choose><c:when test="${old_cat == 'all' }">selected</c:when></c:choose> value="all"></option>
						  <c:forEach items="${cat_model.categories}" var="categorie">
						  	<option <c:choose><c:when test="${old_cat == categorie.cat }">selected</c:when></c:choose> value="${categorie.cat }">${categorie.cat }</option>
						  </c:forEach>
						</select>
						<button type="submit" class="btn btn-primary btn-sm"><fmt:message key="genre" /></button> 
					</form> 
					  <table class="table">
						  <thead>
						    <tr>
						      <th scope="col"><fmt:message key="reference" /></th>
						      <th scope="col">Designation</th>
						      <th scope="col"><fmt:message key="prix" /></th>
						      <th scope="col"><fmt:message key="photo" /></th>
						      <th scope="col">Stock</th>
					      	  <th scope="col"><fmt:message key="categorie" /></th>
					      	  <th>&#x271A;</th>
						    </tr>
						  </thead>
						  <tbody>
						  	<c:forEach items="${model.articles}" var="article">
							    <tr>
							      <th scope="row"><a href="${pageContext.request.contextPath}/detail?CodeArticle=${article.id }" class="text-decoration-none">${article.id }</a></th>
							      <td>${article.designation }</td>
							      <td><fmt:formatNumber value = "${article.prix}" type = "currency"/></td>
							      <td><img src="${pageContext.request.contextPath}${article.photo }" alt="Erreur" height="50" width="50"></td>
							      <td>${article.stock }</td>
							      <td>${article.category.cat }</td>
							      <td>
							      	<form action="ajouterPanier?CodeArticle=${article.id }" method="post">
							      		<button class="btn btn-light">
											<img alt="..." src="icons/panier.png" height="30" width="30">
										</button>
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
	<%@include file="footer.jsp" %>
</body>
</html>
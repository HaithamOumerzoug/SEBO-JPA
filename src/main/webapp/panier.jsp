<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><fmt:message key="panier" /></title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body style="background-image:url('images/background.jpg')">
	<div class="container">
		<div class="col-md-8 offset-2">
			<div class="card my-5">
			  <div class="card-header text-primary display-4 text-center">
			    <fmt:message key="panier" />
			  </div>
			  <div class="card-body">
			  	<c:choose>
					  	<c:when test="${fn:length(articles) !=0}">
						  	<c:forEach items="${articles }" var="article">
						  		<div class="form-group">
							    	<label for="" class="font-weight-bold">Designation</label>
							    	<div class="text-danger">${article.designation }</div>
							  	</div>
							  <div class="form-group">
							  	<label for="" class="font-weight-bold"><fmt:message key="prix" /></label>
							    <div class="text-success">
								    <fmt:formatNumber value = "${article.prix}" type ="currency" />
							  	</div>
							 </div>
							  <div class="form-group">
									<label for="" class="font-weight-bold">Stock</label>
									<div class="text-danger">${article.stock }</div>
							    </div>
							  <div class="form-row">
								<div class="form-group">
							    	<label for="" class="font-weight-bold"><fmt:message key="photo" /></label>
							    	<div class=""><img alt="..." height="80" width="80" src="${pageContext.request.contextPath}/${article.photo }"></div>
							   </div>
							    
							   </div>
							   <form action="commander?CodeArticle=${article.id }" method="post"> 
								   <div class="form-row">
									   <div class="form-group col-md-6">
											<label for="quantite" class="font-weight-bold"><fmt:message key="quantite" /></label>
											 <input type="number" min="1" max="${article.stock }" value="1" class="form-control" name="quantite">
									    </div>
										<button type="submit" class="btn ml-4 ">
											<img alt="..." src="${pageContext.request.contextPath}/icons/commande.png" height="40" width="40">
										</button> 
									</div>
								</form>
								<hr>
							</c:forEach>
					  	</c:when>
					  <c:otherwise>
					  	<p><fmt:message key="panierV" /></p>
					  </c:otherwise>
				  </c:choose> 
				  
			  </div>
			  <div class="card-footer d-flex justify-con">
			    <a href="accueil" class="btn btn-danger mr-4"><fmt:message key="retour" /></a>
			  </div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>				
</body>
</html>
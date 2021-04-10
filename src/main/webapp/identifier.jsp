<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" />
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
			    <fmt:message key="identifier" />
			  </div>
			  <div class="card-body">
			    <form action="identifier" method="post">
				  <div class="form-group">
				  	<label for="nom">E-mail</label>
				    <input type="text" class="form-control" name="email" value="${email }">
				    <div class="text-danger"><i>${erreurs['email'] }</i></div>
				  </div>
				  <div class="form-group">
				    <label for="motdepass"><fmt:message key="motDePasse" /></label>
				    <input type="password" class="form-control" name="motdepasse">
				    <div class="text-danger"><i>${erreurs['motdepasse'] }</i></div>
				  </div>
				  <div class="text-danger"><i>${erreurs['general'] }</i></div>
				  
				  <button type="submit" class="btn btn-info btn-block"><fmt:message key="ok" /></button>
				</form>
			  </div>
			  <div class="card-footer">
			  	<a class="btn btn-info float-right" href="inscrire"><fmt:message key="sinscrire" /></a>
			  </div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
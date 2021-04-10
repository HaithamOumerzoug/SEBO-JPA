<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commandes</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-8 offset-2 justify-content-center mt-4">
			<h2 class="text-center text-primary">
				<fmt:message key="Service" />...
			</h2>
			<a href="accueil" class="btn btn-warning btn-block">
				<fmt:message key="retour"/>
			</a>
		</div>
	</div>
</body>
</html>
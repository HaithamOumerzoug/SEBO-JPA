<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><fmt:message key="pageN" /></title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="text-center">
		<h1 class="p-3 mb-2 text-danger"><fmt:message key="pageN" /></h1>
		<p class="display-5"><fmt:message key="resource" /></p>
		<a href="accueil"><fmt:message key="pageA" /></a>
	</div>
</body>
</html>
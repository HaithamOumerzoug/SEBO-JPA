<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="messages" />
<fmt:setLocale value="${langue}" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEBO</title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
	   <div class="text-center">
	      <form method="post" action="language" class="mt-3 d-flex ">
				<select class="form-control col-md-2 mr-3" name="langue">
				      <option value="fr_FR">Français</option>
                      <option value="en_US">English</option>
				</select>
				<button type="submit" class="btn btn-primary btn-sm"><fmt:message key="langue" /></button> 
		  </form>
		 </div>
		<div class="text-center">
			<h1 class="text-primary text-center my-5" style="font-size:30px">
				<span>
					<u><fmt:message key="bienvenue" /></u>
				</span>
			</h1>
			<a class="btn btn-success" href="identifier"><fmt:message key="identification" /></a>
			<a class="btn btn-primary" href="inscrire"><fmt:message key="inscription" /></a>
		  	
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
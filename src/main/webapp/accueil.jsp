<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><fmt:message key="accueil" /></title>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body style="background-image:url('images/background.jpg')">
	<%@include file="Header.jsp" %>
	<div class="container">
		<%-- <%@include file="SelectLangue.jsp" %> --%>
		<div class="col-md-8 offset-2 ">
			<div class="card my-5 shadow-lg p-3 mb-5 bg-white rounded" >
			  	<div class="card-header text-primary text-center" style="font-size:30px">
			    <fmt:message key="bonjour" /> ${client_name }
			  	</div>
				<div class="card-body d-flex justify-content-between">
					<a class="btn btn-success" href="catalogue"><fmt:message key="catalogue" /></a>
					<a class="btn btn-primary" href="commande.jsp"><fmt:message key="commande" /></a>
					<a class="btn btn-warning" href="panier"><fmt:message key="panier" /></a>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
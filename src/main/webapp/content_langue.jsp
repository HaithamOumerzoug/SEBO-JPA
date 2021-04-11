<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setBundle basename="messages" />
<!-- Contenue de index -->
<div class="container">
	 <%@include file="SelectLangue.jsp" %>
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
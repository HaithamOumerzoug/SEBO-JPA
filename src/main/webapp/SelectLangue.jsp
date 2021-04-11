<fmt:setBundle basename="messages" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="text-center">
	      <form method="post" action="language" class="mt-3 d-flex ">
			<select class="form-control col-md-2 mr-3" name="langue">
				<option 
					<c:choose><c:when test="${langue =='fr_FR' }">selected</c:when></c:choose> 
					value="fr_FR">Français
				</option>
                <option 
                	<c:choose><c:when test="${langue =='en_US' }">selected</c:when></c:choose> 
                	value="en_US">English
                </option>
			</select>
			<button type="submit" class="btn btn-primary btn-sm"><fmt:message key="langue" /></button> 
		 </form>
	 </div>
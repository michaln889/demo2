<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value="/books" var="books" />

<div class="container">

    <h1>Nothing found</h1>
	
	<div class="margin-bottom-10">
        <a href="${books}" >Back to search engine</a>
    </div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>

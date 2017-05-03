<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value="/book/edit" var="editBookUrl"/>
<c:url value="/book/delete" var="deleteBookUrl"/>
<c:url value="/booksfinder" var="searchByTitle"/>
<c:url value="/books" var="books"/>

<c:url value="/rent/book" var="rentUrl"/>

<div class="container">

    <h1>List of books</h1>
    
   <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                	<sec:authorize access="hasRole('ADMIN')">
                    	<th class="text-center col-md-1">Id</th>
                    </sec:authorize>
                    <th class="text-center">Title</th>
                    <th class="text-center">Author</th>
                    <th class="text-center col-md-1">Available</th>
                    <sec:authorize access="hasAnyRole('ADMIN', 'USER')">
	                    <sec:authorize access="hasRole('ADMIN')">
		                    <th class="text-center col-md-1">Edit</th>
		                    <th class="text-center col-md-1">Delete</th>
	    				</sec:authorize>
	                    <th class="text-center col-md-1">Rent</th>
					</sec:authorize>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${findedBooks}">
                    <tr>
                    	<sec:authorize access="hasRole('ADMIN')">
                        	<td>${book.id}</td>
                        </sec:authorize>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.available}</td>
                        
                        <sec:authorize access="hasRole('ADMIN')">
	                        <td class="text-center"><a href="${editBookUrl}/${book.id}" class="btn btn-sm btn-primary">Edit</a></td>
	                        <td class="text-center">
	                            <a href="${deleteBookUrl}/${book.id}" class="btn btn-sm btn-danger delete-button">Delete</a>
	                        </td>
						</sec:authorize>
						
						<sec:authorize access="hasAnyRole('ADMIN', 'USER')">
	                        <td class="text-center">
	                        <c:choose>
	                            <c:when test="${book.available > 0}">
	                                <a href="${rentUrl}/${book.id}" class="btn btn-info btn-sm">Rent</a>
	                            </c:when>
	                            <c:otherwise>
	                                brak
	                            </c:otherwise>
	                        </c:choose>
	                        </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    
    <div class="margin-bottom-10">
        <a href="${books}" >Back to search engine</a>
    </div>

</div>

<script>

    $(function() {
        $('.delete-button').on('click', function(event) {
            console.log(event);
            event.preventDefault();
            var url = event.target.href;
            $.post(url)
            .done(function() {
                location.reload();
            });
        });
    });




</script>

<%@ include file="/WEB-INF/include/footer.jsp" %>
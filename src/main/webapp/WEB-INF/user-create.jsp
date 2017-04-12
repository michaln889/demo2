<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value="/create-user" var="createUserURL"/>
<c:url value="/users" var="showAllUsers"/>
<c:url value="/" var="showMainPage"/>

<div class="container">

    <c:if test="${user.id == null}">
        <h1>Create user</h1>
    </c:if>

    <c:if test="${user.id != null}">
        <h1>Edit user</h1>
    </c:if>


    <div class="row">
        <form action="${createUserURL}" method="post" role="form" class="form-horizontal">

            <input type="hidden" value="${user.id}" name="id"/>

            <div class="form-group">
                <label class="control-label col-sm-2" for="firstName">First name:</label>
                <div class="col-sm-6">
                    <input value="${user.firstName}" name="firstName" type="text" id="firstName" class="form-control" placeholder="Enter first name" autofocus required>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="lastName">Last name:</label>
                <div class="col-sm-6">
                    <input value="${user.lastName}" name="lastName" type="text" id="lastName" class="form-control" placeholder="Enter last name" required>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-6">
                    <input value="${user.email}" name="email" type="email" id="email" class="form-control" placeholder="Enter email" required>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password:</label>
                <div class="col-sm-6">
                    <input value="" name="password" type="password" id="password" class="form-control" placeholder="Enter password" required>
                </div>
            </div>
              
            <sec:authorize access="hasAnyRole('ADMIN')">
            <!-- <div class="form-group">
                <label class="control-label col-sm-2" for="role">Role:</label>
                <div class="col-sm-6">
                    <input value="${user.role}" name="role" type="text" id="role" class="form-control" placeholder="ADMIN or USER" required>
                </div>
            </div> to jest stara wersja -->
           
           <div class="form-group">
               	<label class="control-label col-sm-2" for="role">Role:</label>
            	
	            	<div class="col-sm-6">         		
            	   		<select name="role" >
							<option>USER</option>
							<option>ADMIN</option>
						</select>
					</div>
   	       </div> 
            </sec:authorize>                    

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <sec:authorize access="hasAnyRole('ADMIN')">
                    	<a href="${showAllUsers}" class="btn btn-danger">Cancel</a>
                	</sec:authorize>
                	<sec:authorize access="hasAnyRole('USER')">
                    	<a href="${showMainPage}" class="btn btn-danger">Cancel</a>
                	</sec:authorize>
                	
                </div>
            </div>

        </form>
    </div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>
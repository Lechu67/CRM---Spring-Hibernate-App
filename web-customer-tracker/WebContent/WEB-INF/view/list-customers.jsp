<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>



<html>
<head>
	<title>List of customers</title>
	
	<!-- reference the style sheet -->
	
	<link	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager </h2>
			</div>
		</div>

		<div id="container">
		
			<div id="content">
				<!-- NEW BOTTUN: ADD CUSTOMER -->
				
				<input type="button" value="Add Customer"
						onclick="window.location.href='showFormForAdd'; return false;"
						class="add-button"
				/>
				<!-- ADD a search box -->
				
				<form:form action="search" method="POST">
					Search customer: <input type="text" name="theSearchName" />
					<input type="submit" value="Search" class="add-button" />
				</form:form>
				
				<!-- ADD OUR HTML TABLE HERE -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Importance</th>
						<th>Action</th>
					</tr>
					
					<!-- LOOP OVER AND PRINT OUR COUSTOMERS -->
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- construct an update link -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
						
						<!-- construct an delete link -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							<td> ${tempCustomer.importance} </td>
							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" onclick="if(!(confirm('Confirm to delete this client'))) return false">Delete</a>
								
							</td>
						</tr>
					
					</c:forEach>
					
				</table>
			
			</div>
		
		</div>
</body>

</html>
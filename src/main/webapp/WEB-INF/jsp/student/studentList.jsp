<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<br>
	<span class="PageTitle">&nbsp; Student List</span>
	<br>
		<div class="col-lg-12" style="text-align:right">
		&nbsp;
		</div>
	<div><a href="/student/add">Add Student</a></div>
	<div class="listing Box">
		<table class="sortable" id='tblList'>
		<tr>		
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>SSN</th>
			<th>Student Type</th>
			<th>Entry</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="student" items="${students}">
		<tr>
			<td>${student.firstName}</td>
			<td>${student.lastName}</td>
			<td>${student.gender}</td>
			<td>${student.user.email}</td>
			<td>${student.snn}</td>
			<td>${student.studentType}</td>
			<td>${student.entry.name}</td>			
			<td> &nbsp;
			<a href="${pageContext.request.contextPath}/student/edit?id=${student.studentId}"> <span   class="glyphicon glyphicon-pencil"></span></a>
			<a href="${pageContext.request.contextPath}/student/delete?id=${student.studentId}"> <span class="glyphicon glyphicon-remove"></span></a>
			</td>
		</tr>
		</c:forEach>	
		
		
		</table>
	</div>
</body>
</html>
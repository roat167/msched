<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Section List</title>
</head>
<body>
	<br>
	<span class="PageTitle">&nbsp; Section List</span>
	<br>
		<div class="col-lg-12" style="text-align:right">
		&nbsp;
		</div>
	<div><a href="/section/add">Add Section</a></div>
	<div class="listing Box">
		<table class="sortable" id='tblList'>
		<tr>		
			<th>Min Capacity</th>
			<th>Max Capacity</th>
			<th>Block</th>
			<th>Course</th>
			<th>Faculty</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="section" items="${sectionList}">
		<tr>
			<td>${section.minCapacity}</td>
			<td>${section.maxCapacity}</td>
			<td>${section.block.name}</td>
			<td>${section.course.courseName}</td>
			<td>Prof. ${section.faculty.lastName}</td>
			<td> &nbsp;
			<a href="${pageContext.request.contextPath}/section/edit?id=${section.sectionId}"> <span   class="glyphicon glyphicon-pencil"></span></a>
			<a href="${pageContext.request.contextPath}/section/delete?id=${section.sectionId}"> <span class="glyphicon glyphicon-remove"></span></a>
			</td>
		</tr>
		</c:forEach>	
		
		
		</table>
	</div>
</body>
</html>
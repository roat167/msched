<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty List</title>
</head>
<body>
	<br>
	<span class="PageTitle">&nbsp; Faculty List</span>
	<br>
		<div class="col-lg-12" style="text-align:right">
		&nbsp;
		</div>
	<div><a href="/faculty/add">Add Faculty</a></div>
	<div class="listing Box">
		<table class="sortable" id='tblList'>
		<tr>		
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Phone</th>
			<th>SSN</th>
			<th>Start Date</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="faculty" items="${facultyList}">
		<tr>
			<td>${faculty.firstName}</td>
			<td>${faculty.lastName}</td>
			<td>${faculty.gender}</td>
			<td>${faculty.user.email}</td>
			<td>${faculty.user.phoneNo}</td>
			<td>${faculty.snn}</td>
			<fmt:formatDate value="${faculty.startWorkDate}" var="startWorkDate" pattern="MMM/dd/yyyy" />
			<td>${startWorkDate}</td>			
			<td> &nbsp;
			<a href="${pageContext.request.contextPath}/faculty/edit?id=${faculty.facultyId}"> <span   class="glyphicon glyphicon-pencil"></span></a>
			<a href="${pageContext.request.contextPath}/faculty/delete?id=${faculty.facultyId}"> <span class="glyphicon glyphicon-remove"></span></a>
			</td>
		</tr>
		</c:forEach>	
		</table>
		
		<div id="Pagination" class="pagination"></div>
		<input value="Prev" name="prev_text" id="prev_text" type="hidden"><input value="Next" name="next_text" id="next_text" type="hidden"><input value="10" name="items_per_page" id="items_per_page" class="numeric" type="hidden"><input value="10" name="num_display_entries" id="num_display_entries" class="numeric" type="hidden"><input value="2" name="num_edge_entries" id="num_edge_entries" class="numeric" type="hidden">

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTable/filterTable.js"></script>

		<script type="text/javascript">
			//this script is important So, don't remove it
	         var table=document.getElementById('tblList');
	         if(table!=null)
	         {/*
		        var pager = new Pager('tblList', 10); 
		        pager.init(); 
		        pager.showPageNav('pager', 'pageNavPosition'); 
		        pager.showPage(1);
	 	        */
	         }
	    </script>

		<div class="col-lg-12" style="text-align:right">
		&nbsp;
		</div>			
	</div>
</body>
</html>
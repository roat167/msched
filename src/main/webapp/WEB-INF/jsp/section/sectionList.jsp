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
			<th>Block</th>
			<th>Course</th>
			<th>Faculty</th>
			<th>Min Capacity</th>
			<th>Max Capacity</th>
			<th>Seat Available</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="section" items="${sectionList}">
		<tr>			
			<td>${section.block.name}</td>
			<td>${section.course.courseName}</td>
			<td>Prof. ${section.faculty.lastName}</td>
			<td>${section.minCapacity}</td>
			<td>${section.maxCapacity}</td>
			<td>${section.maxCapacity - section.totalStudent}</td>
			<td> &nbsp;
			<a href="${pageContext.request.contextPath}/section/edit?id=${section.sectionId}"> <span   class="glyphicon glyphicon-pencil"></span></a>
			<a href="${pageContext.request.contextPath}/section/delete?id=${section.sectionId}"> <span class="glyphicon glyphicon-remove"></span></a>
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
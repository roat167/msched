<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>
<br>
<span class="PageTitle">&nbsp; Course List</span>
<br>
	<div class="col-lg-12" style="text-align:right">
	&nbsp;
	</div>
<div><a href="/course/add">Add Course</a></div>
<div class="listing Box">
	<table class="sortable" id='tblList'>
	<tr>		
		<th>Course Name</th>
		<th>Course Code</th>
		<th>Prerequisite</th>
		<th>Description</th>
	
		<th></th>
	</tr>	
	<c:forEach var="course" items="${courses}">
		<tr>
			<td>${course.courseName}</td>
			<td>CS${course.courseCode}</td>
			<c:if test="${not empty course.preReqiusite}">
				<td>${course.preReqiusite.courseName}</td>
			</c:if>
			<c:if test="${empty course.preReqiusite}">
				<td class="text-danger">No PreRequisite</td>
			</c:if>
			<td>${course.description}</td>		
			<td> &nbsp;
			<a href="${pageContext.request.contextPath}/course/edit?id=${course.id}"> <span   class="glyphicon glyphicon-pencil"></span></a>
			<a href="${pageContext.request.contextPath}/course/delete?id=${course.id}"> <span class="glyphicon glyphicon-remove"></span></a>
			
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
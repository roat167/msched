<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>
<br>
<span class="PageTitle">&nbsp; Entry List</span>
<br>
	<div class="col-lg-12" style="text-align:right">
	&nbsp;
	</div>
<div><a href="/entry/add">Add Entry</a></div>
<div class="listing Box">
	<table class="sortable" id='tblList'>
	<tr>		
		<th>Name</th>
		<th>Enroll Date</th>
		<th>MPP StuNo</th>
		<th>FFP StuNo</th>
		<th>CPT(%)</th>
		<th>OPT(%)</th>
		<th>US Student</th>
		<th>Action</th>
	</tr>	
	<c:forEach var="entry" items="${entries}">
		<tr>
			<td>${entry.name}</td>
			<td>${entry.displayEntryDate}</td>
			<td>${entry.mppStudentNum}</td>
			<td>${entry.fppStudentNum}</td>
			<td>${entry.percentOfCPT}</td>
			<td>${entry.percentOfOPT}</td>
			<td>${entry.localStudentNum}</td>			
			<td> &nbsp;
			<a href="${pageContext.request.contextPath}/entry/edit?id=${entry.entryId}"> <span   class="glyphicon glyphicon-pencil"></span></a>
			<a href="${pageContext.request.contextPath}/entry/delete?id=${entry.entryId}"> <span class="glyphicon glyphicon-remove"></span></a>
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
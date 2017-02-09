<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Student Schedule</title>
</head>
<body>
	<br>
	<span class="PageTitle">&nbsp; Student Schedule</span>
	<br>
	<div class="col-lg-12" style="text-align: right">&nbsp;</div>
	<c:choose>
	<c:when test="${not empty student.sections}">
		<div class="listing Box">
			<table class="sortable" id='tblList'>
				<tr>
					<th>Block</th>
					<th>Time</th>
					<th>Course</th>
					<th>Faculty</th>
					<th></th>
				</tr>
				<c:forEach var="section" items="${student.sections}">
					<tr>
						<fmt:formatDate value="${section.block.startDate}" var="startDate"
							pattern="MMM/dd/yyyy" />
						<fmt:formatDate value="${section.block.endDate}" var="endDate"
							pattern="MMM/dd/yyyy" />
						<td>${section.block.name}</td>
						<td>${startDate}to ${endDate}</td>
						<td>${section.course.courseName}</td>
						<td>Prof. ${section.faculty.lastName}</td>
						<td>&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div id="Pagination" class="pagination"></div>
		<input value="Prev" name="prev_text" id="prev_text" type="hidden">
		<input value="Next" name="next_text" id="next_text" type="hidden">
		<input value="10" name="items_per_page" id="items_per_page"
			class="numeric" type="hidden">
		<input value="10" name="num_display_entries" id="num_display_entries"
			class="numeric" type="hidden">
		<input value="2" name="num_edge_entries" id="num_edge_entries"
			class="numeric" type="hidden">

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/dataTable/filterTable.js"></script>

		<script type="text/javascript">
			//this script is important So, don't remove it
			var table = document.getElementById('tblList');
			if (table != null) {/*
						        var pager = new Pager('tblList', 10); 
						        pager.init(); 
						        pager.showPageNav('pager', 'pageNavPosition'); 
						        pager.showPage(1);
			 */
			}
		</script>
	</c:when>
	<c:otherwise>
	  <h4>Currently you haven't enrolled in any course yet. Click Enroll to register for courses</h4>
	 <Button type="button" class="linkToUrl btn btn-default" data-url="${pageContext.request.contextPath}/student/enrollCourse">Enroll</Button>
	</c:otherwise>
	</c:choose>
	<div class="col-lg-12" style="text-align: right">&nbsp;</div>
</body>
</html>
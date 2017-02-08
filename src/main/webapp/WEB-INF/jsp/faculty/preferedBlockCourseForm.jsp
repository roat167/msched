<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.mum.swe.msched.enumeration.*"%>
<html>
<head>
<title>Faculty Course And Block</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Faculty Course and Block</span>
	<form:form modelAttribute="faculty" action="/faculty/prefered_block_course/edit" method="post">
		<input name="facultyId" type="hidden" value="${faculty.facultyId}">

		<form:errors path="preferedBlocks" cssStyle="color:red" />
		<br>
Preferred Blocks:
		 <table class = "table">
		 	<tr>
		 		<th></th>
		 		<th>Blocks</th>
		 	</tr>
		 	
		 	<c:forEach var = "preferedBlock" items = "${preferedBlockList}">
		 	<tr>
		 		<td>
		 			<form:checkbox path = "preferedBlocks" value = "${preferedBlock}" checked="${preferedBlocks.contains(preferedBlock)?\"checked\":\"\"}" />
		 			<!-- ${perferedBlocks.contains(preferedBlock)?"selected":"" } -->
		 		</td>
		 		<td>
		 			${preferedBlock}
		 		</td>
		 	</tr>
		 	</c:forEach>
		 </table>

		<form:errors path="courses" cssStyle="color:red"></form:errors>
		<br>
Preferred Courses:
		 <table class = "table">
		 	<tr>
		 		<th></th>
		 		<th>Courses</th>
		 	</tr>
		 	
		 	<c:forEach var = "course" items = "${courseList}">
		 	<tr>
		 		<td>
		 			<form:checkbox path = "courses" value = "${course}" checked="${courses.contains(course)?\"checked\":\"\"}"/>
		 			<!-- ${courses.contain(course)?"selected":""} -->
		 		</td>
		 		<td>
		 			${course.courseName}
		 		</td>
		 	</tr>
		 	</c:forEach>
		 </table>


		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
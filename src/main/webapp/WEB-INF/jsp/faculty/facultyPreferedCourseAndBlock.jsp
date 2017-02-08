<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.mum.swe.msched.enumeration.*"%>
<html>
<head>
<title>Faculty Information</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Faculty Details</span>
	<form:form modelAttribute="faculty" action="/faculty/preferedblockcourse/edit" method="post">
		<input name="facultyId" type="hidden" value="${faculty.facultyId}">


Blocks: 

	<c:forEach var="block" items="${listOfBlocks}">
		<form:checkbox value = "${block}" />${block}
	</c:forEach>

	<c:forEach var="course" items="${listOfCourses}">
		<form:checkbox  value = "${course}" />${course}
	</c:forEach>
	
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
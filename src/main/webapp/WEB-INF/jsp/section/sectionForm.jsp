<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.mum.swe.msched.enumeration.*"%>
<html>
<head>
<title>Student Information</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Section Details</span>
	<form:form modelAttribute="section" action="/section/add" method="post">
		<input name="sectionId" type="hidden" value="${section.sectionId}">

 		<form:errors path="minCapacity" cssStyle="color:red" />
		<br>
Min Capacity: 
  <form:input class="form-control" placeholder="" path="minCapacity"
			type="number" required = "required" value="15"/>
		<br>

		<form:errors path="maxCapacity" cssStyle="color:red"></form:errors>
		<br>
Max Capacity:
<form:input class="form-control" placeholder="" path="maxCapacity"
			type="number" required = "required" value = "25"/>
		<br>

 		<form:errors path="block" cssStyle="color:red" />
		<br>	
Block:
	<form:select class="form-control" path="block" items="${blockList}" itemValue = "id" itemLabel = "name"/> 

 		<form:errors path="course" cssStyle="color:red" />
		<br>			
Course:
<form:select class="form-control" path="course" items = "${courseList}" itemValue = "id" itemLabel = "courseName"/>
		<br>

		<form:errors path="faculty" cssStyle="color:red" />
		<br>			
Faculty:
<form:select class="form-control" path="faculty" items = "${facultyList}" itemValue = "facultyId" itemLabel="lastName" />
		<br>


		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
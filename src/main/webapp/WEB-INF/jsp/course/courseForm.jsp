<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Course Details</span>
	<form:form modelAttribute="course" action="/course/add" method="post">
		<input name="id" type="hidden" value="${course.id}">




		<form:errors path="courseName" cssClass="error" cssStyle="color:red" />
		<br>
		<spring:message code="message.name" text="Course Name" />
		<form:input class="form-control" placeholder="Course Name"
			path="courseName" type="text" />

		<br>

		<form:errors path="courseCode" cssClass="error" cssStyle="color:red" />
		<br>
		<spring:message code="message.courseCode" text="Course Code" />
		<form:input class="form-control" placeholder="Course Code"
			path="courseCode" type="text" />

		<br>

		<form:errors path="description" cssClass="error" cssStyle="color:red" />
		<br>
		<spring:message code="message.description" text="Description:" />
		<form:input class="form-control" placeholder="Description"
			path="description" type="text" />

		<br>
PreRequisite:
		<form:select class="form-control" path="preReqiusite">
			<form:option value="-1">--Please Select--</form:option>
			<form:options items="${courses}" itemValue="id" itemLabel="courseName" />
		</form:select>



		<form:errors path="preReqiusite" cssClass="error" cssStyle="color:red"></form:errors>
		<br>


		<form:input path="id" type="hidden" />
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>
</html>
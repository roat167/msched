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



		<form:errors path="courseName" cssStyle="color:red" />
		<br>
		<spring:message code="message.name" text="Course Name" />
		<form:input class="form-control" placeholder="Course Name"
		 path="courseName" required="required" type="text" />

		<br>

		<form:errors path="courseCode" cssStyle="color:red" />
		<br>
		<spring:message code="message.courseCode" text="Course Code" />
		<form:input class="form-control" placeholder="Course Code"
			required="required" path="courseCode" type="text" />

		<br>

		<form:errors path="description" cssStyle="color:red" />
		<br>
		<spring:message code="message.description" text="Description:" />
		<form:input class="form-control" placeholder="Description"
			required="required" path="description" type="text" />
		<br>
PreRequisite:
		<form:select path="preReqiusite" items="${courses}" itemValue="id" itemLable="courseName">
		</form:select>
		<!-- <select class="form-control">
			<option value="WAP">WAP</option>
			<option value="WAA">WAA</option>
			<option value="EA">EA</option>
			<option value="ALGORITHM">ALGORITHM</option>
			<option value="BIG DATA">BIG DATA</option>
			<option value="DATABASE">DATABASE</option>
			<option value="ASD">ASD</option>
		</select> -->

		<form:errors path="targetBlocks" cssStyle="color:red"></form:errors>
		<br>
Target Blocks:
<form:input class="form-control" placeholder="Target Blocks"
			required="required" path="targetBlocks" type="text" />
		<br>

		<form:errors path="targetBlocks" cssStyle="color:red" />

		<form:input path="id" type="hidden" />
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>
</html>
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
		 path="courseName" type="text"/>

		<br>

		<form:errors path="courseCode" cssClass="error" cssStyle="color:red" />
		<br>
		<spring:message code="message.courseCode" text="Course Code" />
		<form:input class="form-control" placeholder="Course Code" path="courseCode" type="text" />

		<br>

		<form:errors path="description" cssClass="error" cssStyle="color:red" />
		<br>
		<spring:message code="message.description" text="Description:" />
		<form:input class="form-control" placeholder="Description"
				path="description" type="text" />
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

		<form:errors path="preReqiusite" cssClass="error"  cssStyle="color:red"></form:errors>
		<br>
Target Blocks:
<form:input class="form-control" placeholder="Target Blocks"
		path="targetBlocks" type="text" />
		<br>

		<form:errors path="targetBlocks" cssClass="error" cssStyle="color:red" />

		<form:input path="id" type="hidden" />
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>
</html>
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
	<span class="PageTitle">&nbsp; Block Details</span>
	<form:form modelAttribute="block" action="/block/add" method="post">
		<input name="id" type="hidden" value="${block.id}">



		<form:errors path="name" cssStyle="color:red" />
		<br>
		<spring:message code="message.name" text="Block Name" />
		<form:input class="form-control" placeholder="Block Name"
			required="required" path="name" type="text" />

		<br>

		<form:errors path="startDate" cssStyle="color:red" />
		<br>
		<spring:message code="message.startDate" text="Start Date" />
		<form:input class="form-control" placeholder="Start Date"
			required="required" path="startDate" type="text" />

		<br>

		<form:errors path="endDate" cssStyle="color:red" />
		<br>
		<spring:message code="message.endDate" text="End Date" />
		<form:input class="form-control" placeholder="End Date"
			required="required" path="endDate" type="text" />
		<br>


		<form:input path="id" type="hidden" />
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>
</html>
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

		<br>			
Entry Name:
<form:select class="form-control" path="entry" items="${entries}"
			itemValue="entryId" itemLabel="name" />
		<br>

		<form:errors path="entry" cssStyle="color:red" />
		<br>	

	
Block Name:
		
		<form:select class="form-control" path="name">
			<option value="">--Please Select Block Name--</option>
			<option value="January">January</option>
			<option value="February">February</option>
			<option value="March">March</option>
			<option value="April">April</option>
			<option value="May">May</option>
			<option value="June">June</option>
			<option value="July">July</option>
			<option value="August">August</option>
			<option value="September">September</option>
			<option value="October">October</option>
			<option value="November">November</option>
			<option value="December">December</option>

		</form:select>
		<br>
		<form:errors path="startDate" cssStyle="color:red" />
		<br>
		<spring:message code="message.startDate" text="Start Date" />
		<form:input class="form-control" placeholder="Start Date"
			path="startDate" type="text" />

		<br>

		<form:errors path="endDate" cssStyle="color:red" />
		<br>
		<spring:message code="message.endDate" text="End Date" />
		<form:input class="form-control" placeholder="End Date" path="endDate"
			type="text" />
		<br>


		<form:input path="id" type="hidden" />
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>
</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
Entry:
<form:select class="form-control" path="entry" items="${entries}"
			itemValue="entryId" itemLabel="entryDate" required ="required"/>
		<br>

		<form:errors path="entry" cssStyle="color:red" />
		<br>	

	
Block Name:
		
		<form:select class="form-control" path="name" items="${nameList}"
		selected="${fn:contains(nameList,name)?\"selected\":\"\"}">
			
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
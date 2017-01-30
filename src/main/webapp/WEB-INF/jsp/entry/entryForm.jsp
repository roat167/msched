<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Entry Page</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Entry Details</span>
	<form:form modelAttribute="entry" action="/entry/add" method="post">
		<input name="id" type="hidden" value="${entry.entryId}">
		<form:errors path="name" cssStyle="color:red" />
		<br>
		<spring:message code="message.name" text="Name" />
		<form:input class="form-control" placeholder="" path="name"	type="text" />

		<br>

		<form:errors path="displayEntryDate" cssStyle="color:red" />
		<br>		
		<spring:message code="message.entryDate" text="Date mm/dd/yyyy" />
		<form:input class="form-control" placeholder="" path="entryDate" type="text" />

		<br>

		<form:errors path="mppStudentNum" cssStyle="color:red" />
		<br>
		<spring:message code="message.mppStudentNum" text="MPP No:" />
		<form:input class="form-control" placeholder="" path="mppStudentNum" type="text" />
		<br>

		<form:errors path="fppStudentNum" cssStyle="color:red" />
		<br>
FPP No: 
  <form:input class="form-control" placeholder="" path="fppStudentNum"
			type="number" />
		<br>

		<form:errors path="percentOfCPT" cssStyle="color:red"></form:errors>
		<br>
CPT %:
<form:input class="form-control" placeholder="" path="percentOfCPT"		type="number" />
		<br>

		<form:errors path="percentOfOPT" cssStyle="color:red" />
		<br>	
OPT %:
<form:input class="form-control" path="percentOfOPT" type="number" />
		<br>

		<form:errors path="localStudentNum" cssStyle="color:red" />
		<br>	
US Student No:
<form:input class="form-control" path="localStudentNum" type="text" />
		<br>

		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
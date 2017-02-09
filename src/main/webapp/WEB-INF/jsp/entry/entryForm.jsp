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
		<input name="entryId" type="hidden" value="${entry.entryId}">
		<br>
	Entry Date:
	<form:input class="form-control datepicker" placeholder="Entry Date"
			path="entryDate" type="text"/>
		<br>
		<form:errors path="entryDate" cssClass="error" cssStyle="color:red" />
		<br>
		<br>

	MPP No:
	<form:input class="form-control " placeholder="Mpp Number"
			path="mppStudentNum" type="text" required = "required"/>
		<br>
		<form:errors path="mppStudentNum" cssClass="error" cssStyle="color:red" />
		<br>
		<br>

	FPP No:
	<form:input class="form-control " placeholder="Fpp Number" required = "required"
			path="fppStudentNum" type="text" />
		<br>
		<form:errors path="fppStudentNum" cssClass="error" cssStyle="color:red" />
		<br>
   CPT %:
	<form:input class="form-control" placeholder="CPT" path="percentOfCPT" 
			type="text" />
		<br>
		<form:errors path="percentOfCPT" cssClass="error"  cssStyle="color:red" />
		<br>
		<br>
		
	OPT %:
	<form:input class="form-control " placeholder="OPT" path="percentOfOPT"
			type="text" />
		<br>
		<form:errors path="percentOfOPT" cssClass="error" cssStyle="color:red" />
		<br>
		<br>
	US Student No:
	<form:input class="form-control " placeholder="US Student No"
			path="localStudentNum" type="text" />
		<br>
		<form:errors path="localStudentNum" cssStyle="color:red" />
		<br>
		<br>

		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
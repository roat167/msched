<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Profile</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">Contact</span>
	<br>
	<form:form modelAttribute="user" action="/profile/contact" method="post">
		<form:input path="userId" type="hidden" />
		<div class="form-group">		
			<label for="email" class="col-lg-3 control-label">Email: </label>		
			<form:input path="email"/>
			<form:errors path="email" cssClass="error" />
		</div>	
		<div class="form-group">
			<label for="phoneNo" class="col-lg-3 control-label">Phone No. :</label>
			<form:input path="phoneNo"/>
			<form:errors path="phoneNo" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="address" class="col-lg-3 control-label">Address :</label>
			<form:errors path="address" cssClass="error" />
			<form:input path="address"/>
		</div>
		<form:button class="btn btn-default" value="Update" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
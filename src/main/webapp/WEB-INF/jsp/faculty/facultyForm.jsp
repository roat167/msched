<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.mum.swe.msched.enumeration.*"%>
<html>
<head>
<title>Faculty Information</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Faculty Details</span>
	<form:form modelAttribute="faculty" action="/faculty/add" method="post">
		<input name="facultyId" type="hidden" value="${faculty.facultyId}">

		<!-- Keep default user's information  -->
		<form:input name="userId" type="hidden" path="user.userId"/>
		<form:input name="username" type="hidden" path="user.username"/>
		<form:input name="password" type="hidden" path="user.password"/>
		<form:input name="enabled" type="hidden" path="user.enabled"/>
		<form:input name="role" type="hidden" path="user.role"/>
		<form:input name="address" type="hidden" path="user.address"/>


		<form:errors path="firstName" cssStyle="color:red" />
		<br>
First Name: 
  <form:input class="form-control" placeholder="" path="firstName"
			type="text" required = "required"/>
		<br>

		<form:errors path="lastName" cssStyle="color:red"></form:errors>
		<br>
Last Name:
<form:input class="form-control" placeholder="" path="lastName"
			type="text" required = "required"/>
		<br>

		<form:errors path="gender" cssStyle="color:red" />
		<br>	
Gender:
	<form:select class="form-control" path="gender">
			<option ${faculty.gender.equals(GENDER.MALE) ? "selected" : ""}
				value="${GENDER.MALE}">MALE</option>
			<option ${faculty.gender.equals(GENDER.FEMALE) ? "selected" : ""}
				value="${GENDER.FEMALE}">FEMALE</option>

		</form:select>
		<br>

		<form:errors path="user.phoneNo" cssStyle="color:red" />
		<br>			
Phone No:
<form:input class="form-control" path="user.phoneNo" type="text" />
		<br>

		<form:errors path="user.email" cssStyle="color:red" />
		<br>			
Email:
<form:input required = "requried" class="form-control" path="user.email" type="email" />
		<br>


		<form:errors path="snn" cssStyle="color:red" />
		<br>
SSN:
<form:input class="form-control" path="snn" type="text" />
		<br>

		<form:errors path="startWorkDate" cssStyle="color:red" />
		<br>
		<spring:message code="message.startWorkDate" text="Start Work Date" />
		<form:input class="form-control" placeholder="Start Work Date"
			required="required" path="startWorkDate" type="text" />
		<br>


		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>

</body>
</html>
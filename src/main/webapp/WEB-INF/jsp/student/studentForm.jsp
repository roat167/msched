<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.mum.swe.msched.enumeration.*"%>
<html>
	<head>
		<title>Student Information</title>
	</head>
	<body>
		<br>
		<br>
		<span class="PageTitle">&nbsp; Student Details</span>
		<form:form modelAttribute="student" action="/student/add" method="post">
			<input name="studentId" type="hidden" value="${student.studentId}"/>
			
			<!-- Keep default user's information  -->
			<form:input name="userId" type="hidden" path="user.userId"/>
			<form:input name="username" type="hidden" path="user.username"/>
			<form:input name="password" type="hidden" path="user.password"/>
			<form:input name="enabled" type="hidden" path="user.enabled"/>
			<form:input name="role" type="hidden" path="user.role"/>
			<form:input name="address" type="hidden" path="user.address"/>
	
			<form:errors cssClass="error" path="firstName" cssStyle="color:red" />
			<br>
			First Name: 
			<form:input class="form-control" placeholder="" path="firstName" type="text" required= "required"/>
			<br>
	
			<form:errors cssClass="error" path="lastName" cssStyle="color:red"></form:errors>
			<br>
			Last Name:
			<form:input class="form-control" placeholder="" path="lastName"	type="text" required= "required"/>
			<br>
	
			<form:errors cssClass="error" path="gender" cssStyle="color:red" />
			<br>	
			Gender:
			<form:select class="form-control" path="gender"> 
	 			<option ${student.gender.equals(GENDER.MALE) ? "selected" : ""}
					value="${GENDER.MALE}">MALE</option>
				<option ${student.gender.equals(GENDER.FEMALE) ? "selected" : ""}
					value="${GENDER.FEMALE}">FEMALE</option>		
			</form:select>
			<br>
	
			<form:errors cssClass="error" path="user.phoneNo" cssStyle="color:red" />
			<br>			
			Phone No:
			<form:input class="form-control" path="user.phoneNo" type="text"/>
			<br>
	
			<form:errors cssClass="error" path="user.email" cssStyle="color:red" />
			<br>			
			Email:
			<form:input class="form-control" path="user.email" type="email" required= "required"/>
			<br>
	
	
			<form:errors cssClass="error" path="snn" cssStyle="color:red" />
			<br>
			SSN:
			<form:input class="form-control" path="snn" type="text"/>
			<br>
	
			<form:errors path="studentType" cssStyle="color:red" />
			<br>			
			 Student Type:
			<form:select class="form-control" path="studentType">
				<option
					${student.studentType.equals(STUDENT_TYPE.US) ? "selected" : ""}
					value="${STUDENT_TYPE.US}">US</option>
				<option
					${student.studentType.equals(STUDENT_TYPE.CPT) ? "selected" : ""}
					value="${STUDENT_TYPE.CPT}">CPT</option>
				<option
					${student.studentType.equals(STUDENT_TYPE.OPT) ? "selected" : ""}
					value="${STUDENT_TYPE.OPT}">OPT</option>
			</form:select>
			<br>
			
			<form:errors cssClass="error" path="entry" cssStyle="color:red" />
			<br>	
			Entry:
			<form:select class="form-control" path = "entry" items = "${entryList}" itemValue="entryId" itemLabel="name"/>
			<br>
	
			<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
		</form:form>	
	</body>
</html>
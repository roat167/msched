<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Course Registration</title>
</head>
<body>
	<br>
	<br>
	<span class="PageTitle">&nbsp; Course Registration</span>
	<form:form modelAttribute="student" action="/student/enrollCourse" method="post">
		<form:input path="studentId" type="hidden" />		
		<table class="table table-bordered table-striped">
			<c:forEach items="${blockList}" var="b" varStatus="i">										
	        <tr>
	            <td>
	              <button type="button" class="btn" data-toggle="collapse" data-target="#block${i}"></button>	              
	            </td>
	        </tr>
	        <c:choose>
	        <c:if test="${not empty b.sections}">
				<c:forEach items="${b.sections}" var="sect" varStatus="j">	                
					<form:checkbox id="sections${i.index}" checked="checked"
						name="${sect.course.courseName}" path="sections"
						value="${sect.sectionId}" label="${sect.course.courseName}" />
				</c:forEach>
			</c:if>
	        <c:otherwise>	        
	        	<tr id="block${i}" class="collapse out"><td><div>No sections available</div></td></tr>
	        </c:otherwise>
	        </c:choose>
	        </c:forEach>
	    </table>
		<%-- 	<c:forEach items="${blocks}" var="b" varStatus="i">
			<c:if test="${not empty b.sections}">
				<c:forEach items="${b.sections}" var="sect" varStatus="j">
					<form:checkbox id="sections${i.index}" checked="checked"
							name="${sect.course.courseName}" path="sections"
							value="${sect.sectionId}" label="${sect.course.courseName}" />
				<c:choose>
					<c:when test="${sect.isSelected}">
						<form:checkbox id="sections${i.index}" checked="checked"
							name="${sect.course.courseName}" path="sections"
							value="${sect.sectionId}" label="${cUsage.name}" />
					</c:when>
					<c:otherwise>
						<form:checkbox id="sections${i.index}" path="sections"
							name="${cUsage.name}" value="${cUsage.idCountryUsage}"
							label="${cUsage.name}" />
					</c:otherwise>
				</c:choose>
				</c:if>
			</c:forEach>
			<br />
		</c:forEach> --%>
		<form:button class="btn btn-default" value="Update" name="submit">Submit</form:button>
	</form:form>
</body>
</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<thead><th>Block</th><th>Course</th><th>Start Date</th><th>Faculty</th><th>Available Seats</th></thead>
			<c:forEach items="${blockList}" var="b" varStatus="i">
				<c:if test="${not empty b.sections}">
					<tr class="clsBlocks">
						<td rowSpan="${fn:length(b.sections) + 1}"><c:out value="${b.name}" /></td>
						<td colSpan="5"></td>						
					</tr>
					<c:forEach items="${b.sections}" var="sect" varStatus="j">
					<!--Checking availableSeat  -->
					<c:if test="${(sect.maxCapacity - sect.totalStudent) > 0}">
						<c:set var="isExists" value="false" />
						<c:if test="${fn:contains(student.sections, sect)}">
							<c:set var="isExists" value="true" />
						</c:if>
						<tr class="clsSections">
							<td><span> 
							<fmt:formatDate pattern="MMM-dd-yyyy" value="${sect.block.startDate}" var="startDate" /> 
							<c:choose>
								<c:when test="${isExists}">
									<form:checkbox id="sections${i.index}"
										class="chkSections${i.index}"
										name="${sect.course.courseName}" path="sections"
										value="${sect.sectionId}" checked="checked" />
								</c:when>
								<c:otherwise>
									<form:checkbox id="sections${i.index}"
										class="chkSections${i.index}"
										name="${sect.course.courseName}" path="sections"
										value="${sect.sectionId}" 
										lable="${sect.course.courseName}"/>
								</c:otherwise>
							</c:choose>
							</span>
							<c:out value="${sect.course.courseName}" />
							</td>							
							<td><c:out value="${startDate}" /></td>
							<td><c:out value="${sect.faculty.firstName}" /></td>
							<td><c:out value="${sect.maxCapacity - sect.totalStudent}" /></td>
						</tr>
					</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</table>		
		<form:button class="btn btn-default" value="Update" name="submit">Submit</form:button>
	</form:form>
</body>
</html>
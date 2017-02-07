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
			<c:forEach items="${blockList}" var="b" varStatus="i">
				<c:if test="${not empty b.sections}">
					<tr>
						<td>
							<button type="button" class="bcollapse btn" data-toggle="collapse"
								data-target="#block${i.index}">
								<c:out value="${b.name}" />
							</button>
						</td>
					</tr>
					<tr id="block${i.index}" class="bcollapse collapse out">
						<td>
						<c:forEach items="${b.sections}" var="sect" varStatus="j">
							<c:set var="isExists" value="false"/>							
							<c:if test="${fn:contains(student.sections, sect)}">
								<c:set var="isExists" value="true"/>
							</c:if>												
							<span>
							<fmt:formatDate pattern="MMM-dd-yyyy" value="${sect.block.startDate}" var="startDate"/>
							<c:choose>
							<c:when test="${isExists}">							
								<form:checkbox id="sections${i.index}" class="chkSections${i.index}"
									name="${sect.course.courseName}" path="sections"
									value="${sect.sectionId}" checked="checked"
									label="${sect.course.courseName}  ${startDate} ${sect.faculty.firstName} ${sect.maxCapacity - sect.totalStudent}" />
							</c:when>
							<c:otherwise>
								<form:checkbox id="sections${i.index}" class="chkSections${i.index}"
									name="${sect.course.courseName}" path="sections"
									value="${sect.sectionId}"
									label="${sect.course.courseName}  ${startDate} ${sect.faculty.firstName} ${sect.maxCapacity - sect.totalStudent}" />
							</c:otherwise>
							</c:choose>
							</span>							
							<br />
						</c:forEach>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>		
		<form:button class="btn btn-default" value="Update" name="submit">Submit</form:button>
	</form:form>
</body>
</html>
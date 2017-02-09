<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br>
<span class="PageTitle"> Schedule for: ${entry.name}</span> <a href="/generate-schedule">back to list</a>
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
    .tg .tg-yw4l{vertical-align:top}
</style>
<div class="col-lg-12">
<table class="table table-striped">

    <tr>
        <th >Block</th>
        <th >Start Date</th>
        <th >End Date</th>
        <th >Section</th>
    </tr>

    <c:forEach var="block" items="${blocks}">
    <tr>
        <td>${block.name}<a href="/block/edit?id=${block.id}"><span class="glyphicon glyphicon-pencil"></a></td>
        <td ><fmt:formatDate value="${block.startDate}" var="startDate" pattern="MM-dd-yyyy" /> ${startDate}</td>
        <td ><fmt:formatDate value="${block.endDate}" var="endDate" pattern="MM-dd-yyyy" />${endDate}</td>
        <td >
            <c:forEach var="section" items="${block.sections}">
                ${section.course.courseName}
                <c:choose>
                    <c:when test="${section.faculty==null}">
                        <span class="label label-danger">UNSTAFFED </span>

                    </c:when>
                    <c:otherwise>
                        <span class="label label-primary"> ${section.faculty.firstName}</span>

                    </c:otherwise>
                </c:choose>
                <a href="/section/edit?id=${section.sectionId}"><span class="glyphicon glyphicon-pencil"></a>
                <br>
            </c:forEach>
        </td>
    </tr>
    </c:forEach>

</table>
</div>
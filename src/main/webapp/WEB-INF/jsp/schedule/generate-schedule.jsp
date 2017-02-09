<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br>

<div class="col-lg-12">
    <span class="PageTitle">Generate Schedule</span>
<form method="post" action="/generate-schedule">
    <div class="form-group ">
    <label class="col-sm-2 control-label">Select Entry:</label>
        <div class="col-sm-4">
    <select class="form-control " name="entryId">
    <c:forEach var="entry" items="${entries}">
   		<fmt:formatDate type="date" pattern="MMM YYYY" var="entryDate" value="${entry.entryDate}"/>
        <option value="${entry.entryId}">${entryDate}</option>
    </c:forEach>
    </select>
        </div>
        <br>
   <div class="col-lg-12">
    <button type="submit" class="btn btn-success dropdown-toggle" >Generate Schedule</button>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
   </div>
    </div>
</form>
</div>
<br>
<div class="col-lg-8">
    <ul class="list-group">
        <li class="list-group-item list-group-item-info"><b>List of Schedules:</b></li>

        <c:forEach var="schedule" items="${schedules}">
        <fmt:formatDate type="date" pattern="MMM YYYY" var="entryDate" value="${schedule.entry.entryDate}"/>
        <li class="list-group-item"><a href="/view-schedule?entryId=${schedule.entry.entryId}">${entryDate}</a></li>
        </c:forEach>

    </ul>

</div>


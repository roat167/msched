<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>

<div class="col-lg-12">
    <span class="PageTitle">Generate Schedule</span>
<form method="post" action="/generate-schedule">
    <div class="form-group ">
    <label class="col-sm-2 control-label">Select Entry:</label>
        <div class="col-sm-4">
    <select class="form-control " name="entryId">
    <c:forEach var="entry" items="${entries}">
        <option value="${entry.entryId}">${entry.name}</option>
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
        <li class="list-group-item"><a href="/view-schedule?entryId=${schedule.entry.entryId}">${schedule.entry.name}</a></li>
        </c:forEach>

    </ul>

</div>


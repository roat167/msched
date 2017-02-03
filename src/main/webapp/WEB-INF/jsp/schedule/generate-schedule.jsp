<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<span class="PageTitle">Generate Schedule</span>
<form method="post" action="/generate-schedule">
    <label>Select Entry:</label>
    <select name="entryId">
    <c:forEach var="entry" items="${entries}">
        <option value="${entry.entryId}">${entry.name}</option>
    </c:forEach>
    </select>
    <br>
    <button type="submit" >Generate Schedule</button>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>


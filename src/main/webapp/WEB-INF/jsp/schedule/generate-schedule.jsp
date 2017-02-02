<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="get" action="/save-schedule">
    <select name="entryId">
    <c:forEach var="entry" items="${entries}">
        <option value="${entry.entryId}">${entry.name}</option>
    </c:forEach>
    </select>

    <button type="submit" >Generate Schedule</button>
</form>
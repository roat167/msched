<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<span class="PageTitle"> Schedule schedule for ${entry.name}</span>
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
    .tg .tg-yw4l{vertical-align:top}
</style>
<table class="tg">

    <tr>
        <th class="tg-yw4l">Block</th>
        <th class="tg-yw4l">Start Date</th>
        <th class="tg-yw4l">End Date</th>
        <th class="tg-yw4l">Courses</th>
    </tr>

    <c:forEach var="block" items="${blocks}">
    <tr>
        <td class="tg-yw4l">${block.name}</td>
        <td class="tg-yw4l">${block.startDate}</td>
        <td class="tg-yw4l">${block.endDate}</td>
        <td class="tg-yw4l">
            <c:forEach var="section" items="${block.sections}">
                ${section.course}<br>
            </c:forEach>
        </td>
    </tr>
    </c:forEach>

</table>
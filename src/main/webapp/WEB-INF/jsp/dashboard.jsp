<jsp:include page="structure/header.jsp"/>

<div class="row Body">
    <div class="col-lg-2"> </div>
	<div class="col-lg-8">
			<jsp:include page="${(not empty view ?view:'welcome')}.jsp"/>
	</div>
	<div class="col-lg-2"> </div>
</div>

<jsp:include page="structure/footer.jsp"/>
	
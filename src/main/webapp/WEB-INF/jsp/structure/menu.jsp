<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

<img id="Logo" class="linkToUrl" data-url="${pageContext.request.contextPath}/welcome" src="${pageContext.request.contextPath}/themes/default/images/logo.png" alt="MSched ::: MUM Schedule System" title="MSched ::: MUM Schedule System" />
   
<div class="Menu">        
        <!-- Brand and toggle get grouped for better mobile display -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"></button>
                <div class="navbar-header Menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                 </div>
            <!-- Collect the nav links, forms, and other content for toggling -->

			<div class="collapse navbar-collapse Menu" id="bs-example-navbar-collapse-1">
				<!-- left menu -->
                <ul class="nav navbar-nav">
                <sec:authorize access="hasAuthority('ADMIN')">
                     <li class="${(not empty view and fn:containsIgnoreCase(view, '/user') ?'active':'')}">
                        <a href="${pageContext.request.contextPath}">Students</a>
                    </li>				
					<li
						class="${(not empty view and fn:containsIgnoreCase(view, '/customer') ?'active':'')}">
						<a href="${pageContext.request.contextPath}">Faculty</a>
					</li>				
				
				<li class="${(not empty view and fn:containsIgnoreCase(view, '/carList') ?'active':'')}">
                        <a href="${pageContext.request.contextPath}/cars.do"> View Cars</a>
                </li>
                </sec:authorize>
				<sec:authorize access="hasAuthority('ADMIN') or hasAuthority('USER')">
                    <li class="${(not empty view and fn:containsIgnoreCase(view, 'Reservation') ?'active':'')}">
                       <a  href="${pageContext.request.contextPath}/reservationsList.do">My Schedule</a>
                    </li>
                </sec:authorize>
                   </ul>
      <!-- right menu  -->     
      <ul class="nav navbar-nav navbar-right">		
		<sec:authorize access="isAnonymous()">
        	<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <sec:authentication var="principal" property="principal" />
        	<li><a href="${pageContext.request.contextPath}/user/userProfile"><span class="glyphicon glyphicon-user"></span> ${principal.username}</a></li>	
        	<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </sec:authorize>
	</ul>
                
                
            </div>
             <!-- /.navbar-collapse -->
  </div>
        <!-- /.container -->
</nav><!-- Half Page Image Background Carousel Header 
<div style="float:right;padding: 4px 0;z-index:1000;width:200px;margin-top:80px;position:box">
 Language : <a href="?lang=en">English</a>|<a href="?lang=np">Nepali</a><br />
</div>
-->
<br><br><br><br>
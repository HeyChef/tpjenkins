<%@ page isELIgnored="false"  %>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<header class="header-section">
	<div class="header-top">
		<a href="<%=request.getContextPath()%>/accueil">
			<img class="logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Logo_TV_2015.png/280px-Logo_TV_2015.png">
		</a>
		<!-- <div class="container">
			<div class="row pt-4 pb-4">
				<div class="col-xl-12 col-lg-12 text-center "></div>
				<div class="col-xl-6 col-lg-5"></div>
				<div class="col-xl-4 col-lg-5"></div>
			</div>
		</div> -->
	</div>
	<nav class="main-navbar">
		<div class="container">
			<nav class="nav">
		        <c:forEach var="marque" items="${marques}">
        				<a class="nav-link" href="<%=request.getContextPath()%>/accueil/${marque.libelle}"><c:out value="${marque.libelle}"/></a>
      			</c:forEach>
			</nav>
		</div>
	</nav>
</header>
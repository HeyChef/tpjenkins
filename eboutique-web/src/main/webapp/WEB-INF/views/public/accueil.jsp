<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<%@ page pageEncoding="utf-8" %>

<html>
<head>
<spring:url value="/assets/bootstrap/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/assets/css/styles.css" var="main" />
<link rel="stylesheet" href="${bootstrap}">
<link rel="stylesheet" href="${main}">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<!-- <main class="container"> -->
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
					<form:form action="/eboutique-web/accueil" method="get">
						<div class="search-header">Recherche</div>
						<div class="search-div form-group">
						    <input type="text" class="form-control" placeholder="Search" name="critere"/>
						</div>
						<div class="search-div"><input type="submit" class="btn btn-primary" value="Rechercher"></div>
					</form:form>
				</div>
				<div class="col-md-10">
				<c:out value="${errorMessage}"/>
			        <c:forEach var="produit" items="${produits}">
			        	<a href="<%=request.getContextPath()%>/mobile/${produit.identifier}">
				        	<div class="product-container">
					        	<div class="row">
						        	<div class="col-md-3">
							      		<img src='<c:out value="${produit.image}"/>'/>
						        	</div>
						        	<div class="col-md-7">
						        		<c:out value="${produit.libelle}"/>
				        				<div class="marque-div">Par <c:out value="${produit.marque.getLibelle()}"/></div>
				        			</div>
									<div class="col-md-2">
				        				<div class="prix-div"><c:out value="${produit.prix}"/> €</div>
				        			</div>
		        				</div>
		        			</div>
	        			</a>
	      			</c:forEach>			
      			</div>
			</div>
		</div>
	<!-- <main> -->
</body>
</html>
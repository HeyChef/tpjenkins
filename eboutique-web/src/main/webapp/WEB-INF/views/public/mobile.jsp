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

	<main class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
	        	<div class="row">
		        	<div class="col-md-6">
			      		<img class="mobilePicture" src='<c:out value="${produit.image}"/>'/>
		        	</div>
		        	<div class="col-md-6">
		        		<div class="product-title"><c:out value="${produit.libelle}"/></div>
				        <div class="product-price"><c:out value="${produit.prix}"/> €</div>
        				<div class="product-libelle">Par <c:out value="${produit.marque.getLibelle()}"/></div>
        				<div class="product-description"><c:out value="${produit.description}"/></div>
        				<form:form action="/eboutique-web/addPanier" method="post">
        					<input type="hidden" name="produit" value="${produit.identifier}">
       						<div class="form-group row">
							    <label class="col-sm-3 col-form-label" for="exampleFormControlSelect1">Quantité : </label>
							    <select class="form-control col-sm-2" id="exampleFormControlSelect1" name="quantite">
							      <option>1</option>
							      <option>2</option>
							      <option>3</option>
							      <option>4</option>
							      <option>5</option>
							    </select>
							  </div>
							<div><input type="submit" class="btn btn-primary" value="Ajouter au panier"></div>
						</form:form>
        			</div>
     			</div>
			</div>
		</div>
	<main>
</body>
</html>
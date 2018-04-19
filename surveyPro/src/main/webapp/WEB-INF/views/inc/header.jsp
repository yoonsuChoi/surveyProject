<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
    
      <a class="navbar-brand" href="../">Home</a>
	  <c:if test="${empty sessionScope.login }">
            <a class="nav-link" href="../joinus/login">login</a>
      </c:if>
      
      <c:if test="${not empty sessionScope.login }">
            <a class="nav-link" href="../joinus/logout">logout</a>
            <a class="nav-link" href="../survey/surveylist">Survey</a>
		    <a class="nav-link" href="../mysurvey/mysurvey">MySurvey</a>
		    <a class="nav-link" href="../joinus/unregister">Unregister</a>
      </c:if>
    
    </div>
  </div>
</nav>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">울윤수와 거북이들</h1>
    <p class="lead">인간적으로 스프링은 넘나 어려운것 같아오...</p>
  </div>
</div>

</header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
   <head>
    <title>Happy House</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700,800,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/style.css">
    
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <!-- <link href="css/styles.css" rel="stylesheet" /> -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    
  </head>
  
  <!-- body start -->
  <body>
	  <c:if test="${userinfo == null}">
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    
	    <div class="container">
	      <a class="navbar-brand" href="${root }/">HappyHouse</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="${root}/" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="${root}/notice/list" class="nav-link">공지사항</a></li>
	          <li class="nav-item"><a href="${root}/qna/faq" class="nav-link">Q&A</a></li>
	          <li class="nav-item"><a href="#" class="nav-link">우리동네</a></li>
	        </ul>
	        <!-- 여기 추가했어여 -->
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="${root}/user/login" class="nav-link">Login / Sign Up</a></li>
	        </ul>
	      </div>
	    </div>
	   	    
	  </nav>
	  </c:if>

	<c:if test="${userinfo != null}">
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">HappyHouse</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><<a href="${root}/" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="${root}/notice/list" class="nav-link">공지사항</a></li>
	          <li class="nav-item"><a href="${root}/qna/faq" class="nav-link">Q&A</a></li>
	          <li class="nav-item"><a href="" class="nav-link">우리동네</a></li>
	          <li class="nav-item"><a href="" class="nav-link">관심지역</a></li>
	        </ul>
	        
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="" class="nav-link">Logout</a></li>
	          <li class="nav-item"><a href="" class="nav-link">MyPage</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
	</c:if>
    <!-- END nav -->
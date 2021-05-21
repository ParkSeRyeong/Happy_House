<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<%@ include file="/WEB-INF/views/include/header.jsp" %> 
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate pb-0 text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="fa fa-chevron-right"></i></a></span> <span>공지사항 <i class="fa fa-chevron-right"></i></span></p>
            <h1 class="mb-3 bread">공지사항</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section services-section bg-darken">
    	<div class="container">
    		<div class="row justify-content-center">
          <div class="col-md-12 text-center heading-section heading-section-white ftco-animate">
          	<span class="subheading">Notices</span>
            <h2 class="mb-3">주요 공지사항을 한번에 확인하세요</h2>
          </div>
        </div>
    		<div class="row">
    		<c:forEach var="notice" items="${notices }">
    			<div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services services-2">
              <div class="media-body py-md-4 text-center">
              	<div class="icon mb-1 d-flex align-items-center justify-content-center"><span>${notices.no }</span>
              	<img src="../images/blob.svg" alt="">
              	</div>
                <h3>${notices.title }</h3>
                <p>${notices.content }</p>
              </div>
            </div>      
          </div>
          </c:forEach>
          <!-- <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services services-2">
              <div class="media-body py-md-4 text-center">
              	<div class="icon mb-1 d-flex align-items-center justify-content-center"><span>02</span>
              	<img src="../images/blob.svg" alt=""></div>
                <h3>Meet Your Agent</h3>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services services-2">
              <div class="media-body py-md-4 text-center">
              	<div class="icon mb-1 d-flex align-items-center justify-content-center"><span>03</span>
              	<img src="../images/blob.svg" alt=""></div>
                <h3>Close the Deal</h3>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services services-2">
              <div class="media-body py-md-4 text-center">
              	<div class="icon mb-1 d-flex align-items-center justify-content-center"><span>04</span>
              	<img src="../images/blob.svg" alt=""></div>
                <h3>Have Your Property</h3>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
              </div>
            </div>      
          </div> -->
          
          
    		</div>
    	</div>
    </section>
<!-- 
    <section class="ftco-section">
    </section>
 -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %> 
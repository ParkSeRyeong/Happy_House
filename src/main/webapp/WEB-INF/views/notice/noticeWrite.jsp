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
          	<p class="breadcrumbs"><span class="mr-2"><a href="${root }/">Home <i class="fa fa-chevron-right"></i></a></span> <span>공지사항 <i class="fa fa-chevron-right"></i></span></p>
            <h1 class="mb-3 bread">공지사항 등록</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section contact-section">
        <div class="row block-9 justify-content-center mb-5">
          <div class="col-md-8 mb-md-5">
          	<h2 class="text-center">공지사항을 등록해주세요 <br>관리자 계정만 등록할 수 있습니다</h2>
            <form action="" class="bg-light p-5 contact-form" method="post">
              <div class="form-group">
                <input type="text" id="title" name="title" class="form-control" placeholder="제목">
              </div>
              <div class="form-group">
                <textarea id="content" name="content"  cols="30" rows="20" class="form-control" placeholder="공지사항 내용"></textarea>
              </div>
              <div class="form-group">
                <input type="submit" value="공지사항 등록" id="registerBtn" class="btn btn-primary py-3 px-5">
              </div>
            </form>
          
          </div>
        </div>
        
    </section>	
    
     <script>
       
       $("#registerBtn").click(function() {
   		if($("#title").val() == "") {
   			alert("제목을 입력해주세요");
   			return;
   		} else if($("#content").val() == "") {
   			alert("내용을 입력해주세요");
   			return;
   		} else {
   			$(".contact-form").attr("action", "${root}/notice/regist").submit();
   		} 
   	});
   	
   	
       
     </script>

<%@ include file="/WEB-INF/views/include/footer.jsp" %> 
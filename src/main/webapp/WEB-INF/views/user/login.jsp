<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script
    src="https://kit.fontawesome.com/64d58efce2.js"
    crossorigin="anonymous"
  ></script>
  <link rel="stylesheet" href="../css/login-style.css" />
  <title>Sign in & Sign up Form</title>

</head>
<body>
  <div class="container">
    <div class="forms-container">
      <div class="signin-signup">
        <form method="post" action="" class="sign-in-form">
          <h2 class="title">Sign in</h2>
          <div class="input-field">
            <i class="fas fa-user"></i>
            <input type="text" placeholder="ID" name="id" id="userid"/>
          </div>
          <div class="input-field">
            <i class="fas fa-lock"></i>
            <input type="password" placeholder="Password" name="pw" id="userpwd" onkeydown="javascript:if(event.keyCode == 13) {login();}"/>
          </div>
          <input type="submit" value="Login" class="btn solid" id="loginBtn"/>
          <p class="social-text">Or Sign in with social platforms</p>
          <div class="social-media">
            <a href="#" class="social-icon">
              <i class="fab fa-facebook-f"></i>
            </a>
            <a href="#" class="social-icon">
              <i class="fab fa-twitter"></i>
            </a>
            <a href="#" class="social-icon">
              <i class="fab fa-google"></i>
            </a>
            <a href="#" class="social-icon">
              <i class="fab fa-linkedin-in"></i>
            </a>
          </div>
        </form>
        <form method="post" action="" class="sign-up-form">
          <h2 class="title">Sign up</h2>
          <div class="input-field">
            <i class="fas fa-user"></i>
            <input type="text" id="id" name="id" placeholder="ID" />
          </div>
          <div class="input-field">
            <i class="fas fa-lock"></i>
            <input type="password" id="pw" name="pw" placeholder="Password" />
          </div>
          <div class="input-field">
            <i class="fas fa-user"></i>
            <input type="text" id="name" name="name" placeholder="Username" />
          </div>
           <div class="site-heading">
	          <div class="input-field2">
	           <p>Address</p>
	          </div>
			<select class="form-control" name="address_sido" id="sido">
				<option value="0">시/도</option>
			</select>
			<select class="form-control" name="address_gugun" id="gugun">
				<option value="0">구/군</option>
			</select>
			<select class="form-control" name="address_dong" id="dong">
				<option value="0">읍/면/동</option>
			</select>
		  </div>
          <div class="site-heading">
	          <div class="input-field2">
	           <p>MyArea</p>
	          </div>
			<select class="form-control" name="interest_sido" id="sido2">
				<option value="0">시/도</option>
			</select>
			<select class="form-control" name="interest_gugun" id="gugun2">
				<option value="0">구/군</option>
			</select>
			<select class="form-control" name="interest_dong" id="dong2">
				<option value="0">읍/면/동</option>
			</select>
		  </div>
          <div class="input-field">
            <i class="fas fa-mobile"></i>
            <input type="text" id="phone" name="phone" placeholder="Phone" />
          </div>
          <div class="input-field">
            <i class="fas fa-envelope"></i>
            <input type="email" id="email" name="email" placeholder="Email" />
          </div>
          <button type="button" class="btn" id="registerBtn">SIGN UP</button>
          <!-- <input type="submit" class="btn" id="registerBtn" value="Sign up" /> -->
          <p class="social-text">Or Sign up with social platforms</p>
          <div class="social-media">
            <a href="#" class="social-icon">
              <i class="fab fa-facebook-f"></i>
            </a>
            <a href="#" class="social-icon">
              <i class="fab fa-twitter"></i>
            </a>
            <a href="#" class="social-icon">
              <i class="fab fa-google"></i>
            </a>
            <a href="#" class="social-icon">
              <i class="fab fa-linkedin-in"></i>
            </a>
          </div>
        </form>
      </div>
    </div>

    <div class="panels-container">
      <div class="panel left-panel">
        <div class="content">
          <h3>New here ?</h3>
          <p>
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Debitis,
            ex ratione. Aliquid!
          </p>
          <button class="btn transparent" id="sign-up-btn">
            Sign up
          </button>
        </div>
        <img src="../images/log.svg" class="image" alt="" />
      </div>
      <div class="panel right-panel">
        <div class="content">
          <h3>One of us ?</h3>
          <p>회원가입이 되어있을경우에는, 로그인을 해주세요.</p>
          <p>
            회원가입이 되지 않은 회원인 경우, 회원가입을 해주세요.
            * MyArea : 살고 있지 않은 지역이라도 괜찮아요! 관심 지역을 설정해주세요!
          </p>
          <button class="btn transparent" id="sign-in-btn">
            Sign in
          </button>
        </div>
        <img src="../images/register.svg" class="image" alt="" />
      </div>
    </div>
  </div>

    <script src="../js/app.js"></script>
       <script>
       
       $("#registerBtn").click(function() {
   		if($("#name").val() == "") {
   			alert("이름 입력!!!");
   			return;
   		} else if($("#id").val() == "") {
   			alert("아이디 입력!!!");
   			return;
   		} else if($("#pw").val() == "") {
   			alert("비밀번호 입력!!!");
   			return;
   		} else {
   			$(".sign-up-form").attr("action", "${root}/user/regist").submit();
   		}
   	});
   	
   	$("#loginBtn").click(function() {
   		
   		if($("#userid").val() == "") {
   			alert("아이디 입력!!!");
   			return;
   		} else if($("#userpwd").val() == "") {
   			alert("비밀번호 입력!!!");
   			return;
   		} else {
   			$(".sign-in-form").attr("action", "${root}/user/login").submit();
   		}
   	});
   	
		    let colorArr = [ 'table-primary', 'table-success', 'table-danger' ];
			$(document).ready(function(){
				$.get("${root}/map/sido"
					,function(data, status){
						$.each(data, function(index, vo) {
							$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
						});//each
					}//function
					, "json"
				);//get
			});//ready
			$(document).ready(function(){
				$("#sido").change(function() {
					$.get("${root}/map/gugun"
							,{sido:$("#sido").val()}
							,function(data, status){
								$("#gugun").empty();
								$("#gugun").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
								});//each
							}//function
							, "json"
					);//get
				});//change
				$("#gugun").change(function() {
					$.get("${root}/map/dong"
							,{gugun:$("#gugun").val()}
							,function(data, status){
								$("#dong").empty();
								$("#dong").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
								});//each
							}//function
							, "json"
					);//get
				});//change
			});//ready
							
				$(document).ready(function(){
					$.get("${root}/map/sido"
						,function(data, status){
							$.each(data, function(index, vo) {
								$("#sido2").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
							});//each
						}//function
						, "json"
					);//get
				});//ready
				$(document).ready(function(){
					$("#sido2").change(function() {
						$.get("${root}/map/gugun"
								,{sido:$("#sido").val()}
								,function(data, status){
									$("#gugun2").empty();
									$("#gugun2").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#gugun2").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					$("#gugun2").change(function() {
						$.get("${root}/map/dong"
								,{gugun:$("#gugun").val()}
								,function(data, status){
									$("#dong2").empty();
									$("#dong2").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#dong2").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
						
		});//ready
					
					
					
					</script>
  </body>
</html>

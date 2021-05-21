<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<%@ include file="/WEB-INF/views/include/header.jsp" %> 

 <section class="hero-wrap" style="background-image: url('images/bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center">
          <div class="col-lg-7 col-md-6 ftco-animate d-flex align-items-end">
          	<div class="text">
	            <h1 class="mb-4">Find Perfect <br>House From Your Area.</h1>
	            <p><a href="${root}/map/housemap" class="btn btn-primary py-3 px-4">Find House</a></p>
            </div>
          </div>
        </div>
      </div>
 </section>
 
 
<%
	String dong = request.getParameter("dong");
	String aptName = request.getParameter("aptName");
%>

<script>

	$(document).ready(function(){
		alert("aa");
		$.get("${root}/map/dealInfo"
		, {dong:<%= dong %>, aptName:<%= aptName %>}
		, function(data, status){
			$("#apart-list").empty();
			
			$.each(data, function(index, vo){
				let str = "<div class='media margin-clear'>"
					+ "<div class='media-body'>"
					+ "<h4>" + vo.aptName + "</h4>"
					+ "<h6 class='media-heading' id='deal'>지번 : " + vo.jibun +"</h6>"
					+ "<p class='small margin-clear'>"
					+ "<i class='fa fa-calendar pr-10'></i>" + vo.buildYear
					+ "</p>" + "</div>" + "</div>" + "<hr>";
					
					console.log(str);
					$("#apart-list").append(str);
			});
		}
	)});
</script>

<br>
<!-- main-container start -->
<section class="main-container">
	<div class="container">
		<div class="row">

			<!-- main start -->
			<!-- ================ -->
			<div class="main col-lg-8 order-lg-2 ml-xl-auto">

				<!-- page-title start -->
				<!-- ================ -->
				<div class="row grid-space-10">
					<div class='col-12 justify-content-center' id="map"
						style="width: 400px; height: 600px"></div>
				</div>
			</div>
			<!-- main end -->

			<!-- sidebar start -->
			<!-- ================ -->
			<aside class="col-lg-3 order-lg-1">
				<div class="sidebar">
					<div class="block clearfix" id='houseInfo'>
						<h3 class="title">
							<%= dong %> - <%= aptName %>
						</h3>
						<div class="separator-2"></div>

						<div id="apart-list">
						</div>
					</div>
				</div>
			</aside>
			<!-- sidebar end -->
		</div>
	</div>
</section>
 
 
 <div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
	<script
		src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
	<script defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDh_rlbmn4Qc4sOsFyoxODa18E1TXsc8iY&callback=initMap"></script>
					
	<script>
		var map;
		var multi = {lat: 37.5665734, lng: 126.978179};
		var markers = [];
		
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center: multi, zoom: 12
			});
		}
		
		function changeCenter(lat, lng){
			var center = new google.maps.LatLng(lat, lng);
			map.panTo(center);
			map.setZoom(14);
		}
		
		function clearMarker(){
			for(let i=0;i<markers.length;i++){
				markers[i].setMap(null);
			}
			
			markers = [];
		}
		
		function addMarker(tmpLat, tmpLng, aptName) {
			console.log(tmpLat, tmpLng, aptName);
			
			var marker = new google.maps.Marker({
				position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
				label: aptName,
				title: aptName
			});
			marker.addListener('click', function() {
				map.setZoom(17);
				map.setCenter(marker.getPosition());
				callHouseDealInfo();
			});
			marker.setMap(map);
			
			markers.push(marker);
		}
		function callHouseDealInfo(label) {
			$.get(
					"${root}/map/dealInfo",
					{
						dong : $("#dong").val(),
						name : label
					});
		}
		initMap();
	 </script>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
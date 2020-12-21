<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>보호소 정보</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/blog/">

    <!-- Bootstrap core CSS -->
<link href="/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/4.5/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/4.5/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/4.5/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon.ico">
<meta name="msapplication-config" content="/docs/4.5/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">


    <style>
        @font-face { font-family: 'NEXON Lv1 Gothic OTF'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff'); font-weight: normal; font-style: normal; }
        @font-face { font-family: 'RIDIBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff'); font-weight: normal; font-style: normal; }
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      #margin{
          margin-bottom: 50px;
      }

      #mainmenu{
        font-family: 'RIDIBatang';
      }

      #projname{
        font-family: 'NEXON Lv1 Gothic OTF';
        font-size: 2rem;
        text-anchor: middle;
      }

      #text1{
        font-size: 1.25rem;
        text-anchor: middle;
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
  </head>
  <body>
    <jsp:include page="/main/index.jsp"/>
    <div class="container">
  		<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDhAd3t73rKM-WoSl9o7HA7Q-8pWLp1hWc&callback=initMap&region=kr"></script>
  		<script>
  		<!-- API에서 가져온 보호소 정보중 lat, lng를 기준으로 구글맵 띄움 -->
   			function initMap() {
	      		var site = { lat: ${st.lat} ,lng: ${st.lng} };
	      		var map = new google.maps.Map(
	       			document.getElementById('map'), {
	         		zoom: 14,
	         		center: site
	        	});
	            var marker = new google.maps.Marker({
	                position: site,
	                map: map
	              });
      
    		}
  		</script>
        <br/><br/><br/>
        <div>
        	<div class="float-right">
	        <ul>
	        	<br><br>
	            <c:if test="${not empty st.careNm}">
				<li><h5><strong><mark>${st.careNm}</mark></strong></h5></li></c:if>
				<c:if test="${not empty st.careAddr}">
				<li><h6><strong>${st.careAddr}</strong></h6></li></c:if>
				<c:if test="${not empty st.careTel}">
				<li><h6>전화번호: <strong>${st.careTel}</strong></h6></li></c:if>
				<c:if test="${not empty st.saveTrgtAnimal}">
				<li><h6>구조대상 동물: <strong>${st.saveTrgtAnimal}</strong></h6></li></c:if>
				<c:if test="${st.vetPersonCnt ne 0}">
				<li><h6>수의사 인원수: <strong>${st.vetPersonCnt}</strong></h6></li></c:if>
				<c:if test="${not empty st.weekOprStime}">
				<li><h6>평일 운영 시작 시각: <strong>${st.weekOprStime}</strong></h6></li></c:if>
				<c:if test="${not empty st.weekOprEtime}">
				<li><h6>평일 운영 종료 시각: <strong>${st.weekOprEtime}</strong></h6></li></c:if>
				<c:if test="${not empty st.weekendOprStime}">
				<li><h6>주말 운영 시작 시각: <strong>${st.weekendOprStime}</strong></h6></li></c:if>
				<c:if test="${not empty st.weekendOprEtime}">
				<li><h6>주말 운영 종료 시각: <strong>${st.weekendOprEtime}</strong></h6></li></c:if>
				<c:if test="${not empty st.closeDay}">
				<li><h6>휴무일: <strong>${st.closeDay}</strong></h6></li></c:if>
				<c:if test="${st.lat ne 0}">
				<li><h6>위도: ${st.lat}</h6></li></c:if>
				<c:if test="${st.lng ne 0}">
				<li><h6>경도: ${st.lng}</h6></li></c:if>
			</ul>
			</div>
            <div id="map" style="width:50%; height: 50vh;"></div>
        </div>
  </div>

  <hr>



<footer class="blog-footer">
</footer>
</body>
</html>
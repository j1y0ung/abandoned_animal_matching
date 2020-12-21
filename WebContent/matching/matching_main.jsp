<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>매칭 메인화면</title>
	
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

    <link href="../resources/css/style.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
	
	<style>
		@font-face { font-family: 'NEXON Lv1 Gothic OTF'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff'); font-weight: normal; font-style: normal; }
		@font-face { font-family: 'RIDIBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff'); font-weight: normal; font-style: normal; }
		@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
		p{
			font-family: 'Do Hyeon', sans-serif;
		}
		#select {
			text-align: center;
		}
		.btn {cursor:pointer;}	
		
		#btnText{
      	font-family: 'NEXON Lv1 Gothic OTF';
      	font-size: 1.85rem;
      	text-anchor: middle;
      }    
      
		#dscriptext{
      	font-family: 'RIDIBatang';
      	font-size: 1.2rem;
      	margin-top: 40px;
      	margin-bottom: 30px;
      }
	</style>
	
	<script>
		function check(kind) {
			var membership = "${membership}";
			console.log(membership);
			console.log("출력됨");
			
			if (kind == 'cat') {
				if(membership == "준회원" || membership == "예비견주" || membership == "" || membership == "비회원") {
					alert("해당 서비스 이용 권한이 없습니다.");
				}
				else {
					location.href = "/matching/matching_cat.jsp";
				}
			}
			else{
				if(membership == "준회원" || membership == "예비집사" || membership == "" || membership == "비회원") {
					alert("해당 서비스 이용 권한이 없습니다.");
				}
				else {
					location.href = "/matching/matching_dog.jsp";
				}
			}
		}
	</script>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
	<div class="text-center">
			<br><p id="dscriptext">매칭을 원하는 동물을 선택해주세요!</p><br/>
				<div id="select">
					<button id="btnText" class="btn btn-outline-info btn-lg" style="width:150pt;height:80pt;" onclick="check('dog');">강아지<br/>&#x1F436</button>
		            &nbsp;&nbsp;&nbsp;&nbsp;
		            <button id="btnText" class="btn btn-outline-warning btn-lg" style="width:150pt;height:80pt;" onclick="check('cat');">고양이<br/>&#x1F63A</button>
		            <br/><br/><br/>
				</div>
		</div>
	</div>
</body>
</html>
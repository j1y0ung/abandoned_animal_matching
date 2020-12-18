<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>

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
    <!-- Custom styles for this template -->
    <link href="<c:url value='/resources/css/blog.css' />" rel="stylesheet">

</head>
<body>
	<header class="blog-header py-3">
		<div class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-4 pt-1">
				<a class="text-muted" href="#">team솜동지</a>
			</div>
			<div class="col-4 text-center" id="projname">
				<p id=margin></p>
				<a class="blog-header-logo text-dark" href="<c:url value='/main/mainPage.jsp' />">유기동물 매칭입양서비스</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<c:if test="${ empty sessionScope.mem_id }"> <!-- 로그아웃 상태 -->
					<a class="btn btn-sm btn-outline-secondary" href="<c:url value='/member/member_login.jsp' />">로그인</a>
	   				<a class="btn btn-sm btn-outline-secondary" href="<c:url value='/member/member_insert_form.jsp' />">회원가입</a>
				</c:if>
				<c:if test="${ !empty sessionScope.mem_id }"> <!-- 로그인 상태 -->
					<p>${sessionScope.mem_id}님</p>
					<a class="btn btn-sm btn-outline-secondary" href="<c:url value='/member/logout' />">로그아웃</a>
					<a class="btn btn-sm btn-outline-secondary" href="<c:url value='/member/mypage' />">마이페이지</a>
					<c:if test="${ sessionScope.mem_id == 'admin' }">
						<a class="btn btn-sm btn-outline-secondary" href="<c:url value='/adminonly' />">관리</a>
					</c:if>
				</c:if>
			</div>
		</div>
	</header>
	
	<div class="nav-scroller py-1 mb-2" id="mainmenu">
		<ul class="nav justify-content-center">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/test/type' />">입양시험</a>
            </li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/searching' />">유기동물 검색</a>
            </li>
            <li class="nav-item">
				<a class="nav-link" href="<c:url value='/matching/matching_main.jsp' />">유기동물 매칭</a>
            </li>
            <li class="nav-item">
				<a class="nav-link" href="<c:url value='/lostpet/register/form' />">실종동물 찾기</a>
            </li>
			<li class="nav-item">
  				<a class="nav-link" href="<c:url value='/review/list' />">입양후기</a>
             </li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/question/list' />">Q&A</a>
			</li>
		</ul>  
	</div>
</body>
</html>
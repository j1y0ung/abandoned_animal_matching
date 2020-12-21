<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/nav_style.css">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
    <title></title>
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="https://kit.fontawesome.com/2d323a629b.js" crossorgin="annoymous"></script>
    <script src="/resources/js/main.js" defer></script>
    
    <style>
       @font-face { font-family: 'RIDIBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff'); font-weight: normal; font-style: normal; }

         .navbar_menu {
            font-family: 'RIDIBatang';
           font-size: 1.1rem;
           text-anchor: middle;
         }
    </style>
</head>

<body>
    <nav class="navbar">
        <div class="navbar_logo">
            <i class="fas fa-paw"></i>
            <a href="<c:url value='/main/mainPage.jsp' />">Somdongzi</a>
        </div>
        <ul class="navbar_menu">
            <li><a href="<c:url value='/main/mainPage.jsp' />">Home</a></li>
            <li><a href="<c:url value='/test/type' />">입양 시험</a></li>
            <li><a href="<c:url value='/searching' />">유기동물 검색</a></li>
            <li><a href="<c:url value='/matching/matching_main.jsp' />">유기동물 매칭</a></li>
            <li><a href="<c:url value='/lostpet/register/form' />">실종동물 찾기</a></li>
           <li><a href="<c:url value='/review/list' />">입양후기</a></li>
           <li><a href="<c:url value='/question/list' />">Q&A</a></li>
        </ul>   
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
    </nav>
</body>

</html>
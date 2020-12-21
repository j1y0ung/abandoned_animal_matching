<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>입양 후기</title>
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
        @font-face { font-family: 'RIDIBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff'); font-weight: normal; font-style: normal; }
      #text1{
      	margin-top:50px;
      	font-family: 'RIDIBatang';
        font-size: 1.1rem;
        text-anchor: middle;
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">

	<meta charset="UTF-8">

	
	<script src="../js/httpRequest.js"></script>
	<style>
    	th, td{
    		padding: 15px;
    	}
    </style>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<ul class="list-group">
	<li class="list-group-item">

	<table align="center" style="border-collapse : collapse">
		<c:if test="${ empty list }">
			<tr>
				<td colspan="2" align="center">
					등록된 입양후기가 없습니다.
				</td>
			</tr>
		</c:if>
		
		
		<c:set var="count" value="0"></c:set>
		<c:forEach var="p" items="${ list }">
			<c:if test="${count % 4 == 0}"> <!-- 테이블 줄바꿈 조건 설정 -->
				<tr>
			</c:if>

					<td>	
					<div class="card bg-light mb-3" style="max-width: 18rem;">
						  <div class="card-header">
						  <a href="<c:url value='/review/view?rev_idx=${p.rev_idx}' />">${ p.rev_title }</a>
						  </div>
						  <div class="card-body">
						    <img src="../images/${p.rev_img}" width="200" height="200">
						    <c:if test="${sessionScope.mem_id == 'admin'}">
						    <div class="card-footer bg-transparent border-dark">
							<input type="button" value="삭제" onclick="del('${p.rev_idx}');"/>
							</div>
							</c:if>
						  </div>
						  
						</div>

					<td>
						<img src="/images/${p.rev_img}" width="200" height="200"><br>
						<a href="<c:url value='/review/view?rev_idx=${p.rev_idx}' />">${ p.rev_title }</a>

					</td>
			<c:if test="${count % 4 == 3}">
				</tr>
			</c:if>
			<c:set var="count" value="${count + 1}"/>
		</c:forEach>
	</table>
	</li>
	</ul>
</body>
</html>
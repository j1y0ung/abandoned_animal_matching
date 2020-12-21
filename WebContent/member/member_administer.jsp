<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 페이지</title>
	
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			jQuery.noConflict();
			var tab_id = "tab-1";
			console.log("맨처음탭아이디" + tab_id);
			$("#tab-1").load("/member/list");
			
			$('ul.tabs li').click(function(){
				tab_id = $(this).attr('data-tab');
				console.log("탭아이디" + tab_id);
	
				$('ul.tabs li').removeClass('current');
				$('.tab-content').removeClass('current');
	
				$(this).addClass('current');
				$("#"+tab_id).addClass('current');
				
				if(tab_id == "tab-1") {
					$("#tab-1").load("/member/list");
				}
				if(tab_id == "tab-2") {
					$("#tab-2").load("/matching/list");
				}
				if(tab_id == "tab-3") {
					$("#tab-3").load("/admin/list");
				}
			})
		});
	</script>
	<link href="../resources/css/tabStyle.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<ul class="tabs">
			<li class="tab-link current" data-tab="tab-1">회원목록</li>
			<li class="tab-link" data-tab="tab-2">전체 입양 신청 관리</li>
			<li class="tab-link" data-tab="tab-3">보호소 관리자 승인</li>
		</ul>
	
		<div id="tab-1" class="tab-content current"></div>
		<div id="tab-2" class="tab-content"></div>
		<div id="tab-3" class="tab-content"></div>
	</div>
</body>
</html>
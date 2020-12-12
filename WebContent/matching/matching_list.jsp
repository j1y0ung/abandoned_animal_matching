<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>입양 신청 목록</title>
	
	<script type="text/javascript" src="../js/httpRequest.js"></script>
</head>
	
<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"> 입양 신청 목록 </p>
			<table border="1">
				<tr>
					<th>no.</th>
					<th>신청자 아이디</th>
					<th>동물유기번호</th>
					<th>보호소명</th>
					<th>보호소 주소</th>
					<th>보호소 전화번호</th>
				</tr>
				<c:forEach var="vo" items="${ list }">
					<tr>
						<td>${ vo.mat_idx }</td>
						<td>${ vo.mem_id }</td>
						<td>${ vo.mat_id }</td>
						<td>${ vo.mat_careName }</td>
						<td>${ vo.mat_careAddress }</td>
						<td>${ vo.mat_tel }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
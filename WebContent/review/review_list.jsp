<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>입양 후기</title>
	
	<script src="../js/httpRequest.js"></script>
	<style>
    	th, td{
    		padding: 15px;
    	}
    </style>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
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
						<img src="../images/${p.rev_img}" width="200" height="200"><br>
						<a href="<c:url value='/review/view?rev_idx=${p.rev_idx}' />">${ p.rev_title }</a>
					</td>
			<c:if test="${count % 4 == 3}">
				</tr>
			</c:if>
			<c:set var="count" value="${count + 1}"/>
		</c:forEach>
	</table>
</body>
</html>
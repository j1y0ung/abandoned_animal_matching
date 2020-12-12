<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="vo" value="${requestScope.vo}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>마이 페이지</title>
	
	<script type="text/javascript" src="../js/httpRequest.js"></script>
	
	<script>
		function send( f ){
			f.action = "/team4/member/update";
			f.method = "POST";
			f.submit();
		}
		
		function reg(mem_id) {
			alert("입양신청");
		}
	</script>
</head>
	
<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"> 내 정보 </p>
			<form>
				<table border="1">
					<tr>
						<td>이름</td>
						<td>${vo.mem_name}</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>${ vo.mem_id }<input type="hidden" name="mem_id" value="${vo.mem_id}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="mem_newPwd" value="${vo.mem_pwd}"></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="mem_phone" value="${vo.mem_phone}"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="mem_email" value="${vo.mem_email}"></td>
					</tr>
					<tr>
						<td>회원 등급</td>
						<td>${ vo.mem_membership }</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" name="updateCode" value="personal">
							<input type="button" value="회원정보 수정" onclick="send( this.form );">
							<input type="reset" value="취소" onclick="location.href='/team4/member/mypage'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>

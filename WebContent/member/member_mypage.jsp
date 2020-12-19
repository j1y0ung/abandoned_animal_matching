<%@page import="vo.MatchingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="vo" value="${requestScope.vo}" />
<c:set var="matvo" value="${requestScope.matvo}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>마이 페이지</title>
	
	<script type="text/javascript" src="../js/httpRequest.js"></script>
	
	<script>
		function send( f ){
			f.action = "/matching/list";
			f.method = "POST";
			f.submit();
		}
		
		function update(f) {
			f.action = "/member/update";
			f.method = "POST";
			f.submit();
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
						<td>입양 신청 현황</td>
						<td>
							<c:if test="${ matvo.mat_img != null }">
								<img src="${matvo.mat_img }" style="width:100px; height:130px;"/><br>
								${matvo.mat_kind}<br>
								상태: ${matvo.mat_state}<br>
								<c:if test="${ matvo.mat_state == '승인완료' }">
									<form>
										<input type="hidden" name="img" value="${matvo.mat_img }">
										<input type="button" value="입양후기작성" onclick="location.href='/review/review_reg_form.jsp'">
									</form>
								</c:if>
							</c:if>
						</td>
					</tr>
					<c:if test="${ vo.mem_membership == '보호소관리자' }">
						<tr>
							<td colspan="2">
								<input type="hidden" name="careName" value="${ vo.mem_careAdmin }">
								<input type="hidden" name="code" value="adm">
								<input type="button" value="입양신청관리" onclick="send(this.form);">
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="2">
							<form>
								<input type="hidden" name="updateCode" value="personal">
								<input type="button" value="수정" onclick="update(this.form);">
							</form>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
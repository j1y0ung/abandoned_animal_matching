<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>회원 목록 페이지</title>
	
	<script>
		function del(mem_id) {
			if(confirm("해당 회원을 삭제하시겠습니까?")==false){
				return;
			}
			
			//ajax를 통해 삭제 처리
			var url = "/member/delete";
			var param = "mem_id="+mem_id;
			
			sendRequest(url,param,delResultFn,"POST");
		}
		
		function delResultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				if( json[0].result == '0' ){
					alert("회원 삭제 실패" );
				}
				else{
					alert("회원 삭제 성공");
				}
				location.href="/member/list";
			}
		}
		
		function update(f) {
			if(confirm("회원정보를 수정하시겠습니까?")==false){
				return;
			}
			
			var updateCode = f.updateCode.value.trim();
			var mem_id = f.mem_id.value.trim();
			var mem_membership = f.mem_membership.value.trim();
			
			var url = "/member/update";
			var param = "updateCode=" + updateCode + "&mem_id=" + mem_id + "&mem_membership=" + mem_membership;
			
			sendRequest(url,param,updateResultFn,"POST");
		}
		
		function updateResultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				if( json[0].result == '0' ){
					alert("회원정보 업데이트 실패" );
				}
				else{
					alert("회원정보 업데이트 성공");
				}
				
				location.href="/member/list";
			}
		}
	</script>
	
	<script type="text/javascript" src="../js/httpRequest.js"></script>
</head>
	
<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"> 회원목록 </p>
			<table border="1">
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>회원등급</th>
					<th></th>
				</tr>
				<c:forEach var="vo" items="${ list }">
					<tr>
						<td>${ vo.mem_name }</td>
						<td>${ vo.mem_id }</td>
						<td>${ vo.mem_pwd }</td>
						<td>${ vo.mem_phone }</td>
						<td>${ vo.mem_email }</td>
						<td><!-- 관리자가 회원등급 직접 바꿔줄 수 있음 -->
							<form>
								<select name="mem_membership">
									<option value="" selected disabled hidden>${ vo.mem_membership }</option>
								  	<option value="준회원">준회원</option>
								  	<option value="예비집사">예비집사</option>
								  	<option value="예비견주">예비견주</option>
								  	<option value="댕냥마스터">댕냥마스터</option>
								</select>
								
								<input type="hidden" name="mem_id" value="${vo.mem_id }">
								<input type="hidden" name="updateCode" value="manager">
								<input type="button" value="회원정보 수정" onclick="update(this.form);">
								<input type="button" value="회원 삭제" onclick="del('${vo.mem_id}');">
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

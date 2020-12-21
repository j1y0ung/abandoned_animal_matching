<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>보호소 관리자 신청자 목록</title>
	
	<script>
		function reject(mem_id) {
			if(confirm("승인 거부하시겠습니까?")==false){
				return;
			}
			
			//ajax를 통해 삭제 처리
			var url = "/admin/update";
			var param = "updateCode=1&mem_id="+mem_id;
			
			sendRequest(url,param,delResultFn,"POST");
		}
		
		function delResultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				if( json[0].result == '0' ){
					alert("처리 실패하였습니다." );
				}
				else{
					alert("성공적으로 처리되었습니다.");
				}
				location.href="/adminonly";
			}
		}
		
		function update(mem_id) {
			if(confirm("승인 하시겠습니까?")==false){
				return;
			}
			
			var url = "/admin/update";
			var param = "updateCode=2&mem_id="+mem_id;
			
			sendRequest(url,param,updateResultFn,"POST");
		}
		
		function updateResultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				if( json[0].result == '0' ){
					alert("처리 실패하였습니다." );
				}
				else{
					alert("성공적으로 처리되었습니다.");
				}
				
				location.href="/adminonly";
			}
		}
	</script>
	<script type="text/javascript" src="../js/httpRequest.js"></script>
	<style>
		table{
			width: 100%;
		}
		table.type09 {
			border-collapse: collapse;
			text-align: left;
			line-height: 1.5;
		}
		table.type09 thead th {
			padding: 10px;
			font-weight: bold;
			vertical-align: top;
			color: #369;
			border-bottom: 3px solid #036;
		}
		table.type09 tbody th {
			padding: 10px;
			font-weight: bold;
			vertical-align: top;
			border-bottom: 1px solid #ccc;
			background: #f3f6f7;
		}
		table.type09 td {
			padding: 10px;
			vertical-align: top;
			border-bottom: 1px solid #ccc;
		}
	</style>
</head>
	
<body>
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"></p>
			<table class="type09">
				<thead>
					<tr>
						<th scope="cols">보호소명</th>
						<th scope="cols">이름</th>
						<th scope="cols">아이디</th>
						<th scope="cols">전화번호</th>
						<th scope="cols">이메일</th>
						<th scope="cols">가입일</th>
						<th scope="cols">..</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${ list }">
						<tr>
							<td>${ vo.mem_careAdmin }</td>
							<td>${ vo.mem_name }</td>
							<td>${ vo.mem_id }</td>
							<td>${ vo.mem_phone }</td>
							<td>${ vo.mem_email }</td>
							<td>${ vo.mem_regDate }</td>
							<td>
								<form>
									<input type="hidden" name="mem_id" value="${vo.mem_id }">
									<input type="hidden" name="updateCode" value="manager">
									<input type="button" value="승인" onclick="update('${vo.mem_id}');">
									<input type="button" value="거절" onclick="reject('${vo.mem_id}');">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
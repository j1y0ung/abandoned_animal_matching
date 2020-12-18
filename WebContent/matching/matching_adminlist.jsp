<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>개별 보호소 입양신청목록</title>
	
	<script type="text/javascript" src="../js/httpRequest.js"></script>
	<script>
		function del(f) {
			if(confirm("해당 신청을 거부하시겠습니까?")==false){
				return;
			}
			var mat_id = f.mat_id.value.trim();
			var mem_id = f.mem_id.value.trim();
			
			//ajax를 통해 삭제 처리
			var url = "/matching/delete";
			var param = "mat_id="+mat_id+"&mem_id="+mem_id;
			
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
				location.href="/matching/matching_adminlist.jsp";
			}
		}
		
		function update(f) {
			if(confirm("해당 신청을 승인 하시겠습니까?")==false){
				return;
			}
			
			var mem_id = f.mem_id.value.trim();
			var mat_id = f.mat_id.value.trim();
			
			var url = "/matching/update";
			var param = "mem_id=" + mem_id + "&mat_id=" + mat_id;
			
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
				
				location.href="/matching/matching_adminlist.jsp";
			}
		}
	</script>
	<style>
		table{
			width: 1000px;
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
	<jsp:include page="/main/index.jsp"/>
	
	<div id="l-margin">
		<br><p id="test-toptext-p" class="text-center"></p>
		<table class="type09">
			<thead>
				<tr>
					<th scope="cols">아이디</th>
					<th scope="cols">유기번호</th>
					<th scope="cols">종류</th>
					<th scope="cols">보호소명</th>
					<th scope="cols">신청날짜</th>
					<th scope="cols">상태</th>
					<th scope="cols">..</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${ list }">
					<tr>
						<td>${ vo.mem_id }</td>
						<td>${ vo.mat_id }</td>
						<td>${ vo.mat_kind }</td>
						<td>${ vo.mat_careName }</td>
						<td>${ vo.mat_date }</td>
						<td>${ vo.mat_state }</td>
						<td>
							<form>
								<input type="hidden" name="mat_id" value="${vo.mat_id }">
								<input type="hidden" name="mem_id" value="${vo.mem_id }">
								<input type="hidden" name="updateCode" value="manager">
								<input type="button" value="승인" onclick="update(this.form);">
								<input type="button" value="거절" onclick="del(this.form);">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
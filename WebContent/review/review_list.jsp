<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>입양 후기 목록</title>
	
	<script src="../js/httpRequest.js"></script>
	
	<script>
		function del( rev_idx ){
			if( confirm("삭제하시겠습니까?") == false ){
				return;
			}
			
			//ajax를 통해 삭제 처리
			var url = "/review/delete";
			var param = "rev_idx="+rev_idx;
			
			//삭제를 GET으로 하면 
			sendRequest(url, param, resultFn, "POST");
		}
		
		function resultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				//[{'res':'1'},{'idx':'3'}]
				if( json[0].result == '0' ){
					alert( json[1].rev_idx + "삭제 실패" );
				}
				else{
					alert(json[1].rev_idx+"번 후기 삭제 성공")
				}
				
				// 전체 목록을 select 하는 url로 다시 이동(서블릿)
				location.href="/review/list";
				//이동하면, select하고 list만들어서 이 페이지가 다시 나옴(forward 하니까)
			}
		}
	</script>
	
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
						<c:if test="${sessionScope.mem_id == 'admin'}">
							<input type="button" value="삭제" onclick="del('${p.rev_idx}');"/>
						</c:if>
					</td>
			<c:if test="${count % 4 == 3}">
				</tr>
			</c:if>
			<c:set var="count" value="${count + 1}"/>
		</c:forEach>
	</table>
</body>
</html>
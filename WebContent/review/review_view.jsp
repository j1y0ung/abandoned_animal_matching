<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>입양 후기 상세</title>
	
	<script>
		function del( rev_idx ){
			if( confirm("삭제하시겠습니까?") == false ){
				return;
			}
			
			//ajax를 통해 삭제 처리
			var url = "/review/delete";
			var param = "rev_idx="+rev_idx;
			
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
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<table align="center" width="600" border="1" style="border-collapse : collapse">
		<td>
			제목: ${ vo.rev_title }<br>
			작성일: ${vo.rev_date }<br>
			작성자: ${vo.mem_id }
			<hr><br>
			<img src="../images/${ vo.rev_img }"><br>
			내용 : ${vo.rev_content }<br>
			<c:if test="${sessionScope.mem_id == vo.mem_id || sessionScope.mem_id == 'admin'}">
				<input type="button" value="삭제" onclick="del('${vo.rev_idx}');"/>
			</c:if>
		</td>
	</table>
	
</body>
</html>
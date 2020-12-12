<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>입양 후기 상세 화면</title>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<table align="center" width="600" border="1" style="border-collapse : collapse">
		<td>
			제목: ${ vo.rev_title }<br>
			작성일: ${vo.rev_date }
			<hr><br>
			<img src="../images/${ vo.rev_img }"><br>
			내용 : ${vo.rev_content }
		</td>
	</table>
</body>
</html>
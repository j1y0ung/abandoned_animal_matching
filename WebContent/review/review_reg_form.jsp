<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<title>입양후기 등록</title>

	<script>
		function checkdata( f ){
			f.submit();
		}
	</script>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>

	<form name="f" method="post" action="/review/insert?mat_id=${mat_id }&title_img=${title_img }&mem_id=${mem_id}" enctype="multipart/form-data">
		<table align="center" width="600" border="1" style="border-collapse : collapse">
			<tr>
				<td>제목</td>
				<td colspan="4" align="center"><input name="rev_title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="4" align="center"><input name="rev_content"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td colspan="4" align="center"><input type="file" name="rev_img" ></td>
			</tr>
			<tr>
				<td colspan="5" align="center"></td>
				<td>
					<input type="hidden" value="${requestScope.mat_id}" name="mat_id"/>
					<input type="hidden" value="${requestScope.mat_id}" name="mat_id"/>
					<input type="hidden" value="${requestScope.title_img}" name="mat_titleImg"/>
					<input type="button" value="글 등록하기" onclick="checkdata(this.form);">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input</title>
</head>
<body>
<form>
	<input type="hidden" name="img" value="${matvo.mat_img }">
	<input type="button" value="입양후기작성" onclick="location.href='/review/testRslt.jsp'">
</form>
</body>
</html>
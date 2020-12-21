<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body>
<form action="/review/insert2" method="post" enctype="multipart/form-data">

					상품명 : <input type="text" name="item"><br>

					가격 : <input type="text" name="price"><br>

					상세설명 : <br>

					<textarea rows="5" cols="60" name="detail"></textarea><br>

					상품이미지 : <input type="file" name="img"><br> 

					<input type="submit" value="등록"><br>

					<input type="reset" value="취소"><br>

				</form>

</body>
</html>




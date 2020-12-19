<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	
	<script src="../js/httpRequest.js"></script>
	<script>
		function send(f) {
			var id = f.id.value.trim();
			var pwd = f.pwd.value.trim();
			
			if( id == '' || pwd == '' ) {
				alert("아이디 또는 비밀번호를 입력하세요!!");
				return;
			}
			
			var url = "/member/login";
			var param = "id=" + encodeURIComponent(id) +
						"&pwd=" + encodeURIComponent(pwd);
			sendRequest( url, param, resultFn, "POST" );
		}
		
		function resultFn() {  // id/pw 체크 후 콜백될 함수
			if( xhr.readyState == 4 && xhr.status == 200 ) {
				var data = xhr.responseText;
				var json = eval(data);
				
				if( json[0].param == 'no_id' ) {
					alert("아이디가 존재하지 않습니다.");
				}
				else if( json[0].param == 'no_pwd' ) {
					alert("비밀번호가 일치하지 않습니다.");
				}
				else if( json[0].param == 'clear' ) {
					location.href = "/main/mainPage.jsp";
				}
			}
		}
	</script>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"></p>
			<form>
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input name="id"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="button" value="로그인" onclick="send(this.form);">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
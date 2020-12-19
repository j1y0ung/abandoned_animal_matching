<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 페이지</title>

	<script src="../js/httpRequest.js"></script>
	<script>
		var b_idCheck = false;
		
		function send( f ){
			console.log("send!");
			var id = f.id.value.trim();
			var pwd = f.pwd.value.trim();
			var name = f.name.value.trim();
			var phone = f.phone.value.trim();
			var email = f.email.value.trim();
			var careAdmin = f.careAdmin.value.trim();
			console.log(careAdmin);
			
			//유효성 체크
			if( !b_idCheck ){
				alert("아이디 중복체크를 먼저 하세요");
				return;
			}			
			
			f.action = "/member/insert";
			f.method = "POST";
			f.submit();
			
		} //send()
		
		function check_id(){
			var id = document.getElementById("id").value.trim();
			
			if( id == '' ){
				alert("아이디를 입력하세요");
				return;
			}
			
			//id를 Ajax를 통해서 서버로 전송
			var url = "/member/checkId";
			
			//id에 @#와 같은 특수문자가 포함되어 있는 경우를 대비하여 인코딩하여 보낸다.
			var param = "id=" + encodeURIComponent(id);
			
			sendRequest(url, param, resultFn, "GET");
			
		}//check_id()
		
		function resultFn(){
			if( xhr.readyState == 4 && xhr.status == 200 ){
				//도착한 데이터를 읽는다.
				var data = xhr.responseText;
				
				//도착한 데이터를 JSON표기법으로 파싱
				var json = eval( data );
				
				if( json[0].result == 'no' ){
					alert( json[1].id + "은 이미 사용중인 아이디 입니다." );
					return;
				}
				alert( json[1].id + "는 사용 가능한 아이디 입니다." );
				b_idCheck = true;
			}
		}//resultFn()

		function isChecked() {
			document.getElementById('check_view_box').style.display='block';
		}
	</script>
	
	<style>
	#inputCare {
		width: 300px;
	}
	</style>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>

	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"></p>
			<form>
				아이디<br>
				<input name="id" id="id">
				<input type="button" value="중복체크" onclick="check_id();"><br>
				비밀번호<br>
				<input type="password" name="pwd"><br>
				이름<br>
				<input name="name"><br>
				전화번호<br>
				<input name="phone"><br>
				이메일<br>
				<input name="email"><br><br>
				보호소 관리자입니다
				<input id="yes" type="checkbox" onclick="isChecked();" value=1><br>
				<input type="text" id="check_view_box" name="careAdmin" style="width:300px; display:none;" placeholder="보호소명을 정확히 입력해주세요" /><br><br>
				
				<input type="button" value="가입" onclick="send( this.form );">
				<input type="reset" value="취소" onclick="location.href='/member/list'">
			</form>
		</div>
	</div>
</body>
</html>
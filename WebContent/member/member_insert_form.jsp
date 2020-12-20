<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>회원가입</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/blog/">

    <!-- Bootstrap core CSS -->
	<link href="/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
	<!-- Favicons -->
	<link rel="apple-touch-icon" href="/docs/4.5/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
	<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
	<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
	<link rel="manifest" href="/docs/4.5/assets/img/favicons/manifest.json">
	<link rel="mask-icon" href="/docs/4.5/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
	<link rel="icon" href="/docs/4.5/assets/img/favicons/favicon.ico">
	<meta name="msapplication-config" content="/docs/4.5/assets/img/favicons/browserconfig.xml">
	<meta name="theme-color" content="#563d7c">
	<style>
        @font-face { font-family: 'RIDIBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff'); font-weight: normal; font-style: normal; }

      #dscriptext{
      	font-family: 'RIDIBatang';
      	font-size: 1.2rem;
      	margin-top: 40px;
      	margin-bottom: 30px;
      }
      
      .container{
      	margin-top: 40px;
      }
      
      #loginbtn{
      	margin-top: 20px;
      }
      
      #inputCare {
		width: 300px;
		}
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
	


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
		<div class="col-md-7 col-lg-8">
        <h4 class="mb-3">회원가입</h4>
      </div>
			<br>
			<form>
				아이디&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-light btn-sm" onclick="check_id();">중복체크</button>
				<input type="text" class="form-control" name="id" id="id"><br>
				비밀번호<br>
				<input type="password" class="form-control" name="pwd"><br>
				이름<br>
				<input type="text" class="form-control" name="name"><br>
				전화번호<br>
				<input type="text" class="form-control" name="phone" placeholder="010-1234-2345"><br>
				이메일<br>
				<input type="text" class="form-control" name="email" placeholder="you@example.com"><br><br>
				보호소 관리자입니다
				<input id="yes" type="checkbox" onclick="isChecked();" value=1><br>
				<input type="text" id="check_view_box" name="careAdmin" style="width:300px; display:none;" placeholder="보호소명을 정확히 입력해주세요" /><br><br>
				
				<button class="btn btn-dark btn-lg" type="button" onclick="send( this.form );">회원가입</button>&nbsp;
				<button class="btn btn-primary btn-lg" type="reset" onclick="location.href='/member/list'">취소</button>
			</form>
		</div>
	</div>
</body>
</html>
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
	
	<div class = "container">
        
		<div id="l-margin">
		<div class="col-md-7 col-lg-8">
        <h4 class="mb-3">로그인</h4>
			<br>
			<form>
				아이디
				<input type="text" class="form-control" name="id" id="id"><br>
				비밀번호<br>
				<input type="password" class="form-control" name="pwd"><br>
				
				<button class="w-100 btn btn-dark btn-lg" type="button" onclick="send(this.form);">로그인</button>
			</form>
		</div>
		</div>
	</div>
</body>
</html>
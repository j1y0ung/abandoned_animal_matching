<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>강아지 매칭</title>
	
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

	<link href="../resources/css/style.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">

	<script>
		function checkdata( f ){
			var hair = f.hair.value.trim();
			var size = f.size.value.trim();
			var environment = f.environment.value.trim();
			var intelligence = f.intelligence.value.trim();
			var color = f.color.value.trim();
			var sex = f.sex.value.trim();
			var neuter = f.neuter.value.trim();
			
			if( hair == '' || size == '' || environment == '' || intelligence == '' || color == '' 
					|| sex == '' || neuter == '') {
				alert("선택하지 않은 항목이 있습니다.");
				return;
			}
			
			f.submit();
		}
	</script>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"> 강아지 매칭 </p>
			<form name="f" method="get" action="/matching/dog" enctype="multipart/form-data">
				1. 털빠짐<br>
				<input type='radio' name='hair' value='l'/>적음
				<input type='radio' name='hair' value='m'/>많음<br>
				2. 크기<br>
				<input type='radio' name='size' value='s'/>중,소형견
				<input type='radio' name='size' value='l'/>대형견<br>
				3. 주거환경<br>
				<input type='radio' name='environment' value='s'/>방 3개 이하의 다세대 주택
				<input type='radio' name='environment' value='l'/>넓거나 마당이 있는 집<br>
				4. 지능<br>
				<input type='radio' name='intelligence' value='l'/>낮은편
				<input type='radio' name='intelligence' value='h'/>높은편<br>
				5. 색상<br>
				<input type='radio' name='color' value='갈'/>갈색
				<input type='radio' name='color' value='검'/>검정색
				<input type='radio' name='color' value='흰'/>흰색<br>
				6. 성별<br>
				<input type='radio' name='sex' value='F'/>암컷
				<input type='radio' name='sex' value='M'/>수컷<br>
				7. 중성화여부<br>
				<input type='radio' name='neuter' value='Y'/>예
				<input type='radio' name='neuter' value='N'/>아니오<br>
				
				<input type="button" value="매칭 결과 보기" onclick="checkdata(this.form)">
			</form>
		</div>
	</div>
</body>
</html>
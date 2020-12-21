<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>유기동물입양서비스</title>

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
        @font-face { font-family: 'S-CoreDream-3Light'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-3Light.woff') format('woff'); font-weight: normal;font-style: normal;}
        .ent{
      	background-image: url(https://cdn.pixabay.com/photo/2016/01/19/17/41/friends-1149841_1280.jpg);
      	background-size: cover;
      }
      .display-4{
        font-family: 'S-CoreDream-3Light';
      	color: white;
        font-size: 1.75rem;
        font-weight: lighter;
      }
      #main-dark{
        opacity: 0.7;
        height: 100vh;
      }
      .box {
        position:absolute; 
        top:30%; left:50%;
        margin-top:70px; margin-left:-220px; 
        width:800px; height:200px; 
    }
    .box2 {
        position:absolute; 
        top:50%; left:50%;
        margin-top:-50px; margin-left:-560px; 
        width:800px; height:200px; 
    }
    .mainbox {
        max-width: 100%;
		max-height: 100%;
		bottom: 0;
		left: 0;
		margin: auto;
		margin-top:50px;
		overflow: auto;
		position: fixed;
		right: 0;
		top: 0;
    }
   </style>
</head>
<body>
<jsp:include page="/main/index.jsp"/>
    <main class="container">
    <div class="mainbox">
	 <div class="ent">
        <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark" id="main-dark">
    <div class="col-md-6 px-0">
    </div><br><br><br><br><br><br><br><br><br>
    <div class="box">
      <h1 class="display-4 font-italic">가족을 맞이하는 기쁨, 함께하세요</h1><br>
      <div class="box2">
      <p class="lead my-3">입양시험제도를 통해 자격 부여 후 매칭을 통해 본인 성향과 맞는 가족을 찾을 수 있습니다.</p>
        </div>
    </div>
    </div>
    </div>
    </div>
  </main>

</body>
</html>
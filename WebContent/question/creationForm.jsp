<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Q&A</title>
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
        @font-face { font-family: 'NEXON Lv1 Gothic OTF'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff'); font-weight: normal; font-style: normal; }
        @font-face { font-family: 'RIDIBatang'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff'); font-weight: normal; font-style: normal; }
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      #margin{
          margin-bottom: 50px;
      }

      #mainmenu{
        font-family: 'RIDIBatang';
      }

      #projname{
        font-family: 'NEXON Lv1 Gothic OTF';
        font-size: 2rem;
        text-anchor: middle;
      }

      #testbtn-dog{
        margin-right: 20px;
      }

      #l-margin{
          margin-left: 40px;
      }

      #test-text-p{
        font-family: 'RIDIBatang';
        font-size: 1rem;
        color:rgb(168, 158, 21);
      }

      #test-toptext-p{
        font-family: 'RIDIBatang';
        font-size: 1rem;
        color:dimgrey;
      }

    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
<script>
function questionCreate() {
	if (form.title.value == "") {
		alert("제목을 입력하십시오.");
		form.title.focus();
		return false;
	}
	if (form.content.value == "") {
		alert("내용을 입력하십시오.");
		form.content.focus();
		return false;
	}
	form.submit();
}
</script>
</head>
<body>
  	<jsp:include page="/main/index.jsp"/>
<!-- Question 질문게시글 생성이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
<c:if test="${creationFailed}">
	<font color="red"><c:out value="${exception.getMessage()}" /></font>
</c:if>
<div class="container">
	<div class="row-lg-10">
		<form name="form" method="POST" action="<c:url value='/question/create' />" enctype="multipart/form-data">
		  <div class="row-lg-10">
            <div class="form-group">
				<input type="text" class="form-control" name="title" autocomplete="off" placeholder="제목">
				<c:if test="${creationFailed}">value="${que.title}"</c:if>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
				<textarea class="form-control textarea" rows="20" name="content" placeholder="내용"></textarea>
				<c:if test="${creationFailed}">value="${que.content}"</c:if>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
				<input type="file" class="form-control" name="filename" placeholder="파일 선택">
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group form-check">
				<h5><input type="checkbox" value="y" class="form-check-input" name="secret" id="gridCheck1">
				<label class="form-check-label" for="gridCheck1">비밀글로 등록</label></h5>
            </div>
		  </div>
		  <div class="row-lg-10">
		  	<div class="form-group">
            	<div class="text-right">
		  			<button type="button" class="btn btn-primary btn-lg" onClick="questionCreate()">등록</button> &nbsp;
		  			<a href="<c:url value='/question/list' />" class="btn btn-secondary btn-lg">Q&A 목록</a>  
            	</div>
            </div>
		  </div>
		</form>
	</div>						
</div>
</body>
</html>
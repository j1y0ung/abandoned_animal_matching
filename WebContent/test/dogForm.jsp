<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>강아지 입양테스트</title>
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
  </head>
  <script>
  	var SetTime = 180;
  	
  	function msg_time() {
  		m = Math.floor(SetTime / 60) + "분 " + (SetTime % 60) + "초";
  		var msg = "현재 남은 시간은 <font color='red'>" + m + "</font> 입니다.";
  		document.all.ViewTimer.innerHTML = msg;
  		SetTime--;
  		if (SetTime < 0) {
  			clearInterval(tid);
  			alert("시간이 초과하여 자동으로 응답을 제출합니다.");
  			document.form.submit();
  		}
   	}
  	window.onload = function TimerStart(){ tid=setInterval('msg_time()',1000) };
  </script>
  <body>
    <jsp:include page="/main/index.jsp"/>
  <div class="container">
        <div id="l-margin">
            <br><p id="test-toptext-p" class="text-center"> &#x1F436 입양시험을 선택하셨습니다. </p>
            <br>
            <div id="ViewTimer"></div>
            <br>
            <form method="POST" name="form" action="<c:url value='/test/score' />">
                <br><p id="test-text-p"> / 마음가짐 / </p><br>
                <p>1. 하루에 한번, 적어도 이틀에 한번은 산책을 시킬 수 있나요?</p>
                <input type="radio" name="test1" value="1">O &nbsp;
                <input type="radio" name="test1" value="0">X<br><p></p>
                <p>2. 어떤 어려움이 닥치더라도 반려견의 죽음까지 책임질 자신이 있나요?</p>
                <input type="radio" name="test2" value="1">O &nbsp;
                <input type="radio" name="test2" value="0">X<br><p></p>
                <p>3. 현재 집에 같이 거주중인 구성원이 모두 반려동물을 원하나요?</p>
                <input type="radio" name="test3" value="1">O &nbsp;
                <input type="radio" name="test3" value="0">X<br><p></p>
                <p>4. 경제적으로 지원이 가능한가요?(사료, 물품, 병원비 등)</p>
                <input type="radio" name="test4" value="1">O &nbsp;
                <input type="radio" name="test4" value="0">X<br><p></p>
                <p>5. 반려동물이 살기 적합한 환경에 거주하고 계신가요?</p>
                <input type="radio" name="test5" value="1">O &nbsp;
                <input type="radio" name="test5" value="0">X<br><p></p>
                <br><p id="test-text-p"> / 배경지식 및 습성 / </p><br>
                <c:set var="i" value="6"/>
                <c:forEach var="dogTest" items="${dogTestList}">
                	<p>${i}.${dogTest.dogQ}</p>
                	<input type="radio" name="test${i}_@i" value="1">${dogTest.dogQ_1} <br>
                	<input type="radio" name="test${i}_@i" value="2">${dogTest.dogQ_2} <br>
                	<input type="radio" name="test${i}_@i" value="3">${dogTest.dogQ_3} <br>
                	<input type="radio" name="test${i}_@i" value="4">${dogTest.dogQ_4} <br><br>
                	<input type="hidden" name="answer${i}_@i" value="${dogTest.dogA}">
					<c:set var="i" value="${i+1}"/>
                </c:forEach>
                <div class="text-center">
                <input type="hidden" name="testKind" value="dog">
                <input type="submit" value="제출하기">
                </div>
             </form>
            <br/><br/><br/>
        </div>
  </div>

  <hr>


<footer class="blog-footer">
</footer>
</body>
</html>

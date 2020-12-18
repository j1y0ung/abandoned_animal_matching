<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>입양 테스트</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	 <!-- CSS only -->
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
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
  	<script>
		function check(kind) {
			var membership = "${membership}";

			if (kind == "cat") {
				var catFailNum = "${catFailNum}";
				catFailNum = parseInt(catFailNum);
				var catTimeFinish = "${catTimeFinish}";
				
				if(membership=="준회원" || membership=="예비견주") {
					if (catFailNum == 0) {
						alert("첫 번째 고양이 시험");
						location.href = "/test/cat/form";
					} else if (catFailNum == 1) {
						if (catTimeFinish=="y") {
							alert("첫 번째 재시험");
							location.href = "/test/cat/form";
						} else {
							alert("시험 응시일로부터 24시간이 지나야 재응시할 수 있습니다.");
						}
					} else {
						if (catTimeFinish=="y") {
							alert(catFailNum + " 번째 재시험");
							location.href = "/test/cat/form";
						} else {
							alert("시험 응시일로부터 " + (catFailNum-1)*3 + "개월이 지나야 재응시할 수 있습니다.");
						} 
					}
				} else {
					alert("시험 응시 자격이 없습니다.");
				}
			} else {
				var dogFailNum = "${dogFailNum}";
				dogFailNum = parseInt(dogFailNum);
				var dogTimeFinish = "${dogTimeFinish}";
				
				if(membership=="준회원" || membership=="예비집사") {
					if (dogFailNum == 0) {
						alert("첫 번째 강아지 시험");
						location.href = "/test/dog/form";
					} else if (dogFailNum == 1) {
						if (dogTimeFinish=="y") {
							alert("첫 번째 재시험");
							location.href = "/test/dog/form";
						} else {
							alert("시험 응시일로부터 24시간이 지나야 재응시할 수 있습니다.");
						}
					} else {
						if (dogTimeFinish=="y") {
							alert(dogFailNum + " 번째 재시험");
							location.href = "/test/dog/form";
						} else {
							alert("시험 응시일로부터 " + (dogFailNum-1)*3 + "개월이 지나야 재응시할 수 있습니다.");
						} 
					}
				} else {
					alert("시험 응시 자격이 없습니다.");
				}
			}
		}
	</script>
  </head>
  <body>
    <jsp:include page="/main/index.jsp"/>
    <div class="container">
        <div class="text-center">
            <br>
            <p>입양테스트를 원하는 동물의 종을 선택해주세요.</p><br/>
            <a class="btn btn-outline-primary btn-lg" onclick="check('dog');">강아지<br/>&#x1F436</a>
            <a class="btn btn-outline-success btn-lg" onclick="check('cat');">고양이<br/>&#x1F63A</a>
            <br/><br/><br/>
        </div>
  </div>

  <hr>

<footer class="blog-footer">
</footer>
</body>
</html>
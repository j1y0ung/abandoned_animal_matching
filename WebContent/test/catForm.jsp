<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>고양이 입양테스트</title>
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
  <body>
    <jsp:include page="/main/index.jsp"/>
  <div class="container">
        <div id="l-margin">
            <br><p id="test-toptext-p" class="text-center"> &#x1F63A 입양시험을 선택하셨습니다. </p>
            <br>
            <form method="POST" action="<c:url value='/test/score' />">
            	<input type="hidden" name="type" value="cat"/>
                <br><p id="test-text-p"> / 마음가짐 / </p><br>
                <p>1. 반려묘 키우는 데에는 한 달 평균 10 - 20만원의 고정비가 든다.</p>
                <input type="radio" name="test1" value="1">O &nbsp;
                <input type="radio" name="test1" value="0">X<br><p></p>
                <p>2. 지금까지 미처 발견하지 못했던 털 알레르기 혹은 동물 알레르기가 생겼을 때 대처할 방법을 생각해두었다.</p>
                <input type="radio" name="test2" value="1">O &nbsp;
                <input type="radio" name="test2" value="0">X<br><p></p>
                <p>3. 고양이의 평균 수명은 15 - 20년 정도이다. </p>
                <input type="radio" name="test3" value="1">O &nbsp;
                <input type="radio" name="test3" value="0">X<br><p></p>
                <p>4. 고양이를 키우고자 하는 이유가 가족이 원해서 혹은 일시적 지루함을 해소할 대상으로 생각하기 때문이다.</p>
                <input type="radio" name="test4" value="0">O &nbsp;
                <input type="radio" name="test4" value="1">X<br><p></p>
                <p>5. 고양이가 가진 발톱과 본능으로 인해 소파, 가구 등이 망가질 수 있다.</p>
                <input type="radio" name="test5" value="1">O &nbsp;
                <input type="radio" name="test5" value="0">X<br><p></p>
                <p>6. 고양이는 강아지와 달리 사람을 따르지 않을 수도 있다.</p>
                <input type="radio" name="test6" value="1">O &nbsp;
                <input type="radio" name="test6" value="0">X<br><p></p>
                <p>7. 이미 돌보고 있는 반려동물이 있다면 새로 입양하는 고양이와 문제가 생겼을 때 절대 집사가 나서면 안된다.</p>
                <input type="radio" name="test7" value="0">O &nbsp;
                <input type="radio" name="test7" value="1">X<br><p></p>
                <p>8. 고양이의 본능을 존중할 준비가 되어 있다. </p>
                <input type="radio" name="test8" value="1">O &nbsp;
                <input type="radio" name="test8" value="0">X<br><p></p>
                <p>9. 고양이는 집에 혼자 두어도 된다.</p>
                <input type="radio" name="test9" value="0">O &nbsp;
                <input type="radio" name="test9" value="1">X<br><p></p>
                <br><p id="test-text-p"> / 배경지식 및 습성 / </p><br>
                <p>10. 고양이가 토할 경우 병원에 갈 필요가 있는 토의 색은 무엇인가?</p>
                <input type="radio" name="test10" value="0">투명한 색 또는 흰색<br>
                <input type="radio" name="test10" value="0">노란색<br>
                <input type="radio" name="test10" value="0">연두색<br>
                <input type="radio" name="test10" value="1">사료가 섞인 토<br>
                <br><p></p>
                <p>11. 고양이는 하루에 최소 몇 분 이상 놀아주는 것이 좋은가?</p>
                <input type="radio" name="test11" value="0">고양이가 원하지 않는다면 굳이 놀아줄 필요는 없다.<br>
                <input type="radio" name="test11" value="0">하루 1번 이상, 한 번에 10~15분<br>
                <input type="radio" name="test11" value="1">하루 3번 이상, 한 번에 10~15분<br>
                <input type="radio" name="test11" value="0">하루 5번 이상, 한 번에 10~15분<br>
                <br><p></p>
                <p>12. 고양이가 하루종일 창 밖을 보고 있다면 어떤 상태를 의미하는가?</p>
                <input type="radio" name="test12" value="0">밖에 나가고 싶다<br>
                <input type="radio" name="test12" value="0">산책이 필요하다<br>
                <input type="radio" name="test12" value="0">몸 상태가 좋지 않다<br>
                <input type="radio" name="test12" value="1">아무 생각 없다<br>
                <br><p></p>
                <p>13. 새끼고양이는 어리기 때문에 목욕을 얼마나 자주 시켜줘야 하는가?</p>
                <input type="radio" name="test13" value="0">하루에 세번씩<br>
                <input type="radio" name="test13" value="0">하루에 두번씩<br>
                <input type="radio" name="test13" value="0">하루에 한번씩<br>
                <input type="radio" name="test13" value="1">되도록 시키지 않고, 8주이상 된 이후 빠르게 시켜준다<br>
                <br><p></p>
                <p>14. 다음 중 고양이에게 주어도 괜찮은 음식은 무엇인가?</p>
                <input type="radio" name="test14" value="0">참치캔<br>
                <input type="radio" name="test14" value="1">블루베리<br>
                <input type="radio" name="test14" value="0">아보카도<br>
                <input type="radio" name="test14" value="0">문어<br>
                <br><p></p>
                <p>15. 고양이의 화장실은 어떻게 관리해야 하는가?</p>
                <input type="radio" name="test15" value="1">벤토나이트, 두부모래, 우드 펠렛 등 고양이의 기호에 맞는 모래를 사용해야 한다.<br>
                <input type="radio" name="test15" value="0">사막화가 일어날 수 있으므로 화장실에는 모래를 최대한 적게 부어주는 것이 좋다.<br>
                <input type="radio" name="test15" value="0">화장실의 개수는 한 마리당 1개가 적당하다.<br>
                <input type="radio" name="test15" value="0">잘 청소를 해준다면 화장실을 바꿀 필요는 없다. <br>
                <br><p></p>
                <p>16. 고양이는 어떤 방법으로 산책시키는 것이 올바른가?</p>
                <input type="radio" name="test16" value="0">목줄을 하고 사람이 없는 곳을 피해 산책한다.<br>
                <input type="radio" name="test16" value="0">고양이가 겁먹지 않도록 품 안에 안고 산책한다.<br>
                <input type="radio" name="test16" value="0">야생성을 충족시켜주기 위해 하루 1번 이상 꼭 산책시켜주어야 한다.<br>
                <input type="radio" name="test16" value="1">고양이는 영역동물이기 때문에 밖에 나가는 것은 위험하므로 산책은 지양하는 것이 좋다.<br>
                <br><p></p>
                <p>17. 고양이와 외출을 해야 할 경우, 어떤 방법으로 이동하는 것이 적절한가?</p>
                <input type="radio" name="test17" value="0">고양이가 겁먹지 않도록 품 안에 안고 이동한다.<br>
                <input type="radio" name="test17" value="0">목줄이 잘 채워졌는지 확인한 후 이동한다.<br>
                <input type="radio" name="test17" value="1">이동용 백팩 또는 이동장에 넣어 이동한다.<br>
                <input type="radio" name="test17" value="0">버스, 지하철 등 대중교통을 이용해 이동한다.<br>
                <br><p></p>
                <p>18. 고양이를 키우면서 집에 들여도 괜찮은 식물은 무엇인가?</p>
                <input type="radio" name="test18" value="0">튤립<br>
                <input type="radio" name="test18" value="0">백합<br>
                <input type="radio" name="test18" value="1">장미<br>
                <input type="radio" name="test18" value="0">라벤더<br>
                <br><p></p>
                <p>19. 고양이는 언제 중성화를 하는 것이 적절한가?</p>
                <input type="radio" name="test19" value="0">태어난 후 즉시<br>
                <input type="radio" name="test19" value="0">3 ~ 5개월<br>
                <input type="radio" name="test19" value="1">6 ~ 8개월<br>
                <input type="radio" name="test19" value="0">성묘인 1살 이후<br>
                <br><p></p>
                <p>20. 고양이를 입양하고 해야 할 기본 예방 접종이 아닌 것은 무엇인가?</p>
                <input type="radio" name="test20" value="0">범백 혈구 감소증<br>
                <input type="radio" name="test20" value="0">허피스 바이러스<br>
                <input type="radio" name="test20" value="0">칼리시 바이러스<br>
                <input type="radio" name="test20" value="1">클라미디아 바이러스<br>
                <br><p></p>
                <div class="text-center">
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
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
  <body>
    <jsp:include page="/main/index.jsp"/>
  <div class="container">
        <div id="l-margin">
            <br><p id="test-toptext-p" class="text-center"> &#x1F436 입양시험을 선택하셨습니다. </p>
            <br>
            <form method="POST" action="<c:url value='/test/score' />">
                <input type="hidden" name="type" value="dog"/>
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
                <p>6. 동물등록제 관련 내용으로 옳지 않은 것은?</p>
                <input type="radio" name="test6" value="1">주택, 준주택에서 기르거나, 이외의 장소에서 반려의 목적으로 기르는 2개월령 이상인 개의 소유자가 지원대상이다.<br>
                <input type="radio" name="test6" value="0">2014.1.1부터 등록대상동물을 소유한 사람은 반드시 동물등록을 해야 한다.<br>
                <input type="radio" name="test6" value="0">동물 등록 방법으로는 내장형 무선식별장치 개체 삽입, 외장형 무선식별장치 부착, 등록 인식표 부착이 있다.<br>
                <input type="radio" name="test6" value="0">동물의 보호와 유실 및 유기 방지를 위함이다.<br>
                <input type="radio" name="test6" value="0">등록 대상 동물 미등록시 100만원 이하의 과태료가 부과된다.<br>
                <br><p></p>
                <p>7. 중성화 수술 관련 내용으로 옳지 않은 것은?</p>
                <input type="radio" name="test7" value="0">각종 생식 관련 질병 예방에 도움이 된다.<br>
                <input type="radio" name="test7" value="0">마운팅 교정 및 스트레스 예방에 도움이 된다.<br>
                <input type="radio" name="test7" value="0">공격성 완화에 도움이 된다.<br>
                <input type="radio" name="test7" value="1">정형외과 질병 위험이 낮아진다.<br>
                <br><p></p>
                <p>8. 개와 함께 자전거 여행을 하고 싶다면 권장되는 조치는 무엇인가?</p>
                <input type="radio" name="test8" value="0">개가 큰 반경에서 걸을 수 있도록 줄을 최대한 길게 묶어줘야 한다. <br>
                <input type="radio" name="test8" value="0">개의 발이 다치지 않도록 특별한 운동화를 착용시켜야 한다.<br>
                <input type="radio" name="test8" value="0">응급상황 시 빨리 잡아챌 수 있도록 줄은 자전거 핸들에 묶어야 한다.<br>
                <input type="radio" name="test8" value="1">개가 자전거와 함께 걷기 위한 체력과 운동신경이 발달되도록 적절히 훈련 시켜야 한다.<br>
                <br><p></p>
                <p>9. 강아지를 빈번하게 또는 오랜 시간 동안 견사에서 기르면 발달에 어떤 영향을 미칠 수 있는가?</p>
                <input type="radio" name="test9" value="0">혼자 있는 것을 잘 배울 수 있다.<br>
                <input type="radio" name="test9" value="1">사회적으로 결핍되고 문제행동을 보일 수 있다.<br>
                <input type="radio" name="test9" value="0">공격적이고, 많이 짖게 된다.<br>
                <input type="radio" name="test9" value="0">이에 관해 아무것도 과학적으로 입증되지 않았다.<br>
                <br><p></p>
                <p>10. 개를 입양하기 전에 무엇을 중요히 고려해야 하는가?</p>
                <input type="radio" name="test10" value="0">자녀가 있는가? 자녀와 개는 융화가 불가능하다.<br>
                <input type="radio" name="test10" value="0">개 생애의 첫해 동안 개를 기르고 돌볼 기회를 가질 수 있는가?<br>
                <input type="radio" name="test10" value="1">찾고 있는 견종의 성격이나 기질이 실제로 나의 생활 방식에 적합한가?<br>
                <input type="radio" name="test10" value="0">부모견이 상을 받았는가?<br>
                <br><p></p>
                <p>11. 어린 강아지의 사교성을 장려하기 위해 적합한 것은 무엇인가?</p>
                <input type="radio" name="test11" value="1">강아지 시기에 많은 사회적 자극을 제공해야 한다.<br>
                <input type="radio" name="test11" value="0">다른 낯선 강아지와의 접촉은 피해야 한다.<br>
                <input type="radio" name="test11" value="0">모견, 형제견과의 분리는 가능한 한 빨리 이루어져야 한다.<br>
                <input type="radio" name="test11" value="0">성견으로부터 억압받지 않도록 거리를 두어야 한다.<br>
                <br><p></p>
                <p>12. 왜 많은 개가 산책줄에 공격적으로 반응하는가?</p>
                <input type="radio" name="test12" value="0">줄을 매면 용감해지기 때문에.<br>
                <input type="radio" name="test12" value="1">줄을 매면 자유롭게 움직일 수 없고, 위협을 느끼기 때문에.<br>
                <input type="radio" name="test12" value="0">줄을 무리 구성원으로 생각하기 때문에.<br>
                <input type="radio" name="test12" value="0">줄에 매였다는 것에 화가 나서 다른 개에게 화를 전달하기 위해서.<br>
                <br><p></p>
                <p>13. 점점 공격성을 보이는 개에게 어떠한 처신이 적합한가?</p>
                <input type="radio" name="test13" value="0">유제품<br>
                <input type="radio" name="test13" value="1">줄에 묶인 개를 진정시키기 위한 쓰다듬<br>
                <input type="radio" name="test13" value="0">생고기 먹이<br>
                <input type="radio" name="test13" value="0">거친 신체적 놀이가 보통 공격성의 원인이다.<br>
                <br><p></p>
                <p>14. 당신은 개의 산책줄을 풀어준 상태로 산책하고 있는데, 한 무리의 아이들이 다가온다면 어떻게 행동해야 하는가?</p>
                <input type="radio" name="test14" value="1">산책줄을 맨다.<br>
                <input type="radio" name="test14" value="0">당신의 개는 아이들을 물지 않으므로 그냥 둔다.<br>
                <input type="radio" name="test14" value="0">당신의 개는 보통 말을 잘 들으므로 그냥 둔다.<br>
                <input type="radio" name="test14" value="0">아이들은 사냥 행위를 유발할 수 있으므로 당신은 아이들이 멈춰 서 있도록 요구한다.<br>
                <br><p></p>
                <p>15. 개 산책 중 어떤 사람이 내 개를 발견하곤, 자신의 개를 팔에 올려 안은 채 내 쪽으로 다가온다면 어떻게 행동해야 하는가?</p>
                <input type="radio" name="test15" value="0">내 개를 올려 안은 채로 지나간다.<br>
                <input type="radio" name="test15" value="1">내 개를 내 쪽으로 부르고 줄을 묶는다. 다른 사람이 지나갈 때, 내 개가 그 사람의 냄새를 맡거나 그에게 뛰어오르지 않도록 조심한다.<br>
                <input type="radio" name="test15" value="0">내 개는 친절하고, 뛰어오르지 않을 것을 알기에 자유롭게 가도록 둔다.<br>
                <input type="radio" name="test15" value="0">내 개는 아무것도 하지 않을 것이기에 그냥 두고, 다른 사람에게 그의 개를 밑으로 내려놓도록 요구한다. <br>
                <br><p></p>
                <p>16. 개가 올바른 행동을 했다면 얼마나 빨리 칭찬해야 하는가?</p>
                <input type="radio" name="test16" value="0">30 초에서 2 분 안에.<br>
                <input type="radio" name="test16" value="0">정확히 5 분 안에.<br>
                <input type="radio" name="test16" value="1">최대 2 초 안에.<br>
                <input type="radio" name="test16" value="0">시간은 중요하지 않다. 중요한 것은 칭찬이다.<br>
                <br><p></p>
                <p>17. 개 교육 과정과 관련하여 다음 중 올바른 것은 무엇인가?</p>
                <input type="radio" name="test17" value="0">개는 태어날 때부터 이미 명령을 이해하기 때문에 교육받을 필요가 없다.<br>
                <input type="radio" name="test17" value="1">제한을 설정하는 것은 개가 가족 내에서 자신의 위치를 찾고 올바르게 행동하도록 도와준다.<br>
                <input type="radio" name="test17" value="0">개는 본능적으로 행동 제어가 불가능하기 때문에 혼내는 것은 무의미하다.<br>
                <input type="radio" name="test17" value="0">개는 인간의 몸짓에만 반응하기 때문에 교육 과정에서 인간의 감정은 불필요하다.<br>
                <br><p></p>
                <p>18. 개가 사람에게 뛰어오르지 않도록 가르치는 것은 어떤 이유로 권장되는가?</p>
                <input type="radio" name="test18" value="1">개가 뛰어오르면 사람을 놀라게 하거나 상처를 줄 수 있다.<br>
                <input type="radio" name="test18" value="0">작은 개는 뛰어올라도 옷을 찢거나 다른 사람을 깜짝 놀라게 하지 않으므로 버릇을 고칠 필요가 없다.<br>
                <input type="radio" name="test18" value="0">개가 뛰어오르는 것은 기쁨의 표시이고 공격성과는 아무런 관련이 없으므로 버릇을 고칠 필요가 없다<br>
                <input type="radio" name="test18" value="0">개가 뛰어오르는 것은 친근한 접촉을 원하는 것이기에 버릇을 고칠 필요가 없다.<br>
                <br><p></p>
                <p>19. 강아지와의 훈련은 언제부터 시작해야 하는가?</p>
                <input type="radio" name="test19" value="0">나이는 중요하지 않다. 다만 훈련 시작 전 강아지가 새 가족에 친숙해지는데 약 3 주 정도 시간을 갖는 것이 중요하다.<br>
                <input type="radio" name="test19" value="1">바로 간단한 훈련부터 시작할 수 있다. 중요한 것은 강아지가 두려워하지 않고 너무 흥분하지 않는 것이다.<br>
                <input type="radio" name="test19" value="0">강아지는 미숙하기 때문에 6개월 전에 복종 훈련을 시작해서는 안 된다.<br>
                <input type="radio" name="test19" value="0">강아지와 함께 해야 할 유일한 훈련은 배변훈련이다. 강아지 시기는 그 밖의 다른 훈련을 하기에는 너무 어리다.<br>
                <br><p></p>
                <p>20. 모든 반려견과 아이는 함께 두어도 되는가?</p>
                <input type="radio" name="test20" value="0">그렇다. 반려견은 자신이 속한 무리의 구성원을 절대 물지 않기 때문이다.<br>
                <input type="radio" name="test20" value="0">아니다. 열 살 이상 나이가 든 반려견만 함께 둘 수 있다. 이런 반려견은 항상 침착하고 여유가 있기 때문이다.<br>
                <input type="radio" name="test20" value="1">아니다. 언제든 심각한 상황이 생길 수 있기 때문이다.<br>
                <input type="radio" name="test20" value="0">아니다. 작은 반려견(대략 닥스훈트 크기 정도까지)만 함께 둘 수 있다.<br>
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

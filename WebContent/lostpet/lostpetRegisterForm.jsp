<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>실종동물 찾기</title>
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
      #text1{
      	margin-top:50px;
      	margin-bottom:30px;
      	font-family: 'RIDIBatang';
        font-size: 1.1rem;
        text-anchor: middle;
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    
    <script>
    function lostPetCreate() {
    	if (form.animalType.value == "") {
    		alert("찾는 동물을 선택하십시오.");
    		form.animalType.focus();
    		return false;
    	} 
    	if (form.ownerName.value == "") {
    		alert("보호자 이름를 입력하십시오.");
    		form.ownername.focus();
    		return false;
    	}
    	if (form.ownerPhone.value == "") {
    		alert("보호자 번호를 입력하십시오.");
    		form.ownerPhone.focus();
    		return false;
    	}
    	if (form.animalSpecies.value == "") {
    		alert("찾는 동물의 품종을 입력하십시오.");
    		form.animalSpecies.focus();
    		return false;
    	}
    	if (form.region.value == "") {
    		alert("찾는 동물의 실종 지역을 입력하십시오.");
    		form.region.focus();
    		return false;
    	}
    	if (form.animalAge.value == "") {
    		alert("찾는 동물의 나이를 입력하십시오.");
    		form.animalAge.focus();
    		return false;
    	}
    	if (form.animalGender.value == "") {
    		alert("찾는 동물의 성별을 입력하십시오.");
    		form.animalGender.focus();
    		return false;
    	}
    	form.submit();
    }
    </script>
  </head>
    <body>
    <jsp:include page="/main/index.jsp"/>
  	<div class = "container">
        <div class="text-center">
            <p id="text1">실종동물 정보 등록</p>
            <br>
            <ul class="list-group">
            <li class="list-group-item">
            <br>
            <form name="form" method="POST" action="<c:url value='/lostpet/register' />">
             <fieldset>
             <div class="form-group row">
		      <label for="InputownerPhone"  class="col-sm-2 col-form-label">동물 종류</label>
		      <div class="col-sm-3">
		      <input type="radio" name="animalType" value="<%="강아지"%>">강아지
		      &nbsp;&nbsp;
		      <input type="radio" name="animalType" value="<%="고양이"%>">고양이
		      </div>
	        </div>
		    <div class="form-group row">
		      <label for="InputownerName" class="col-sm-2 col-form-label">보호자 이름</label>
		      <div class="col-sm-10">
		      <input type="text" class="form-control" name="ownerName" id="InputownerName" placeholder="(ex. 홍길동)">
		       </div>
		    </div>
		    <div class="form-group row">
		      <label for="InputownerPhone"  class="col-sm-2 col-form-label">보호자 전화번호</label>
		      <div class="col-sm-10">
		      <input type="text" class="form-control" name="ownerPhone" id="InputownerPhone" placeholder="(ex. 010-1234-2345)">
		      </div>
		    </div>
		    <div class="form-group row">
		      <label for="InputanimalSpecies"  class="col-sm-2 col-form-label">동물 품종</label>
		      <div class="col-sm-10">
		      <input type="text" class="form-control" name="animalSpecies" id="InputanimalSpecies" placeholder="(ex. 치와와)">
		      </div>
		    </div>
		    <div class="form-group row">
		      <label for="Inputregion"  class="col-sm-2 col-form-label">실종 지역</label>
		      <div class="col-sm-10">
		      <input type="text" class="form-control" name="region" id="Inputregion" placeholder="(ex. 경기도 파주 동패동)">
		      </div>
		    </div>
		    <div class="form-group row">
		      <label for="InputanimalAge"  class="col-sm-2 col-form-label">동물 나이</label>
		      <div class="col-sm-10">
		      <input type="number" class="form-control" name="animalAge" id="InputanimalAge" placeholder="(ex. 1)">
		      <small id="animalAgeHelp" class="form-text text-muted">1살 이하는 1을 적어주세요</small>
		      </div>
		    </div>
		    <div class="form-group row">
		      <label for="InputownerPhone"  class="col-sm-2 col-form-label">동물 성별</label>
		      <div class="col-sm-3">
		      <input type="radio" name="animalGender" value="<%="암컷"%>">암컷&nbsp;&nbsp;
		      <input type="radio" name="animalGender" value="<%="수컷"%>">수컷&nbsp;&nbsp;
		      <input type="radio" name="animalGender" value="<%="모름"%>">모름&nbsp;&nbsp;
		      </div>
	        </div>

	        <button type="button" class="btn btn-primary" onClick="lostPetCreate()">등록</button>
	        &nbsp;&nbsp;
	        <a href="<c:url value='/lostpet/list' />" class="btn btn-light">진행상황보기</a>
		  </fieldset>
            </form>
            </li>
            </ul>
            <br><br>
        </div>
  </div>


<footer class="blog-footer">
</footer>
</body>
</html>
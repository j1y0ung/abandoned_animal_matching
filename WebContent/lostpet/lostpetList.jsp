<%@page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	@SuppressWarnings("unchecked") 
	List<LostAnimal> lostPetList = (List<LostAnimal>)request.getAttribute("lostPetList");
--%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>실종동물찾기 진행내역</title>
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
      	font-family: 'RIDIBatang';
        font-size: 1.1rem;
        text-anchor: middle;
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    </head>
    <body>
	<jsp:include page="/main/index.jsp"/>
    <div class="container">
        <div class="text-center">
            <p id="text1">실종동물 정보 목록</p>
<%-- 
	if (lostPetList != null) {	
	  Iterator<LostAnimal> lpIter = lostPetList.iterator();
	
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( lpIter.hasNext() ) {
		LostAnimal lostPet = (LostAnimal)lpIter.next();
--%>
	<table class="table" align="center">
	 	<thead>
		<th>접수번호</th>
		<th>보호자이름</th>
		<th>동물종</th>
		<th>동물품종</th>
		<th>진행상태</th>
		<br><br>
		</thead>
		<tbody>
	  <c:forEach var="lostPet" items="${lostPetList}">  	
	  	<tr>	  	
		  <td width="190" align="center" bgcolor="ffffff" height="20">
		  	${lostPet.receiptNum}       <%-- <%=lostPet.getReceiptNum()%> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${lostPet.ownerName}        <%-- <%=lostPet.getOwnerName()%> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${lostPet.animalType}        <%-- <%=lostPet.getAnimalType()%> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${lostPet.animalSpecies}        <%-- <%=lostPet.getAnimalSpecies()%> --%>
		  </td>
		  <td width="200" align="center" bgcolor="ffffff" height="20">
		    ${lostPet.progress}        <%-- <%=lostPet.getProgress()%> --%>
		  </td>
		</tr>
	  </c:forEach> 
	  </tbody>
	</table>
<%--
	  }
	}
--%>	
        </div>
  </div>
<footer class="blog-footer">
</footer>
</body>
</html>
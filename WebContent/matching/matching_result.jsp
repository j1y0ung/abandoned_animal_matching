<%@ page import="vo.MatchingSelectVO"%>
<%@ page import="vo.MatchingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>매칭 결과화면</title>

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
	
    <style>
    	th, td{
    		padding: 15px;
    	}
    </style>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	
	<div class="container">
		<div id="l-margin">
			<br><p id="test-toptext-p" class="text-center"> 매칭 결과 </p>
			
			<table align="center" style="border-collapse: collapse;">
				<c:set var="count" value="0"></c:set>
				<c:set var="selected" value="${selected}"></c:set>
				
				<!-- 내가 선택한 값들 -->
				<c:set var="selectKind" value="${selected.getKind()}"/>
				<c:set var="selectColor" value="${selected.getColor()}"/>
				<c:set var="selectSize" value="${selected.getSize()}"/>
				<c:set var="selectSex" value="${selected.getSex()}"/>
				
				<!-- 매칭 결과 출력 -->
				<c:forEach var="results" items="${matchingList}">
					<c:set var="weight" value="${results.mat_size}"/>
					<c:set var="weightLength" value="${fn:length(weight)}"/>
					<c:set var="weightRslt" value="${fn:substring(weight, 0, weightLength-4)}"/>
					
					<c:set var="kind" value="${results.mat_kind}"/>
					<c:set var="kindLength" value="${fn:length(kind)}"/>
					<c:set var="kindRslt" value="${fn:substring(kind, 4, kindLength)}"/>
					
					<!-- 조건에 맞는 동물들만 화면에 출력되도록 함 -->
					<c:if test="${selectSize == 's'}"> <!-- 중, 소형견 -->	
						<c:if test="${fn:contains(selectKind, kindRslt)}">
							<c:if test="${ selectSex == results.mat_sex}">
								<c:if test="${ fn:contains(results.mat_color, selectColor)}">
									<c:if test="${ weightRslt < 10.00}">
										<c:if test="${count % 4 == 0}"> <!-- 테이블 줄바꿈 조건 설정 -->
											<tr>
										</c:if>
												<td>
													<img src="${results.mat_img}" style="width:200px; height:230px;"/><br>
													유기번호: ${results.mat_id}<br>
													나이: ${results.mat_age}<br>
													품종: ${results.mat_kind}<br>
													성별: ${results.mat_sex}<br>
													색: ${results.mat_color}<br>
													몸무게: ${results.mat_size}<br>
													특이사항: ${results.mat_detail}<br>
													보호소명: ${results.mat_careName}<br>
													보호소 주소: ${results.mat_careAddress}<br>
													보호소 전화번호: ${results.mat_tel}<br>

													<form name="f" method="get" action="/team4/matching/insert" enctype="multipart/form-data" >
														<c:set var="img" value="${results.mat_img}"/>
														<c:set var="id" value="${results.mat_id}"/>
														<c:set var="age" value="${results.mat_age}"/>
														<c:set var="kind" value="${results.mat_kind}"/>
														<c:set var="sex" value="${results.mat_sex}"/>
														<c:set var="color" value="${results.mat_color}"/>
														<c:set var="size" value="${results.mat_size}"/>
														<c:set var="detail" value="${results.mat_detail}"/>
														<c:set var="careName" value="${results.mat_careName}"/>
														<c:set var="careAddress" value="${results.mat_careAddress}"/>
														<c:set var="tel" value="${results.mat_tel}"/>
														
														<input type="hidden" name="mat_img" value="<c:out value="${img }"/>"/>
														<input type="hidden" name="mat_id" value="<c:out value="${id }"/>"/>
														<input type="hidden" name="mat_age" value="<c:out value="${age }"/>"/>
														<input type="hidden" name="mat_kind" value="<c:out value="${kind }"/>"/>
														<input type="hidden" name="mat_sex" value="<c:out value="${sex }"/>"/>
														<input type="hidden" name="mat_color" value="<c:out value="${color }"/>"/>
														<input type="hidden" name="mat_size" value="<c:out value="${size }"/>"/>
														<input type="hidden" name="mat_detail" value="<c:out value="${detail }"/>"/>
														<input type="hidden" name="mat_careName" value="<c:out value="${careName }"/>"/>
														<input type="hidden" name="mat_careAddress" value="<c:out value="${careAddress }"/>"/>
														<input type="hidden" name="mat_tel" value="<c:out value="${tel }"/>"/>
														
														<input type="submit" value="입양신청">
													</form>
												</td>
										<c:if test="${count % 4 == 3}">
											</tr>
										</c:if>
										<c:set var="count" value="${count + 1}"/>
									</c:if>
								</c:if>
							</c:if>
						</c:if>
					</c:if>
					
					<c:if test="${selectSize == 'l'}"> <!-- 대형견 -->	
						<c:if test="${fn:contains(selectKind, kindRslt)}">
							<c:if test="${ selectSex == results.mat_sex}">
								<c:if test="${ fn:contains(results.mat_color, selectColor)}">
									<c:if test="${ weightRslt >= 10.00}">
										<c:if test="${count % 4 == 0}"> <!-- 테이블 줄바꿈 조건 설정 -->
											<tr>
										</c:if>
												<td>
													<img src="${results.mat_img}" style="width:200px; height:230px;"/><br>
													유기번호: ${results.mat_id}<br>
													나이: ${results.mat_age}<br>
													품종: ${results.mat_kind}<br>
													성별: ${results.mat_sex}<br>
													색: ${results.mat_color}<br>
													몸무게: ${results.mat_size}<br>
													특이사항: ${results.mat_detail}<br>
													보호소명: ${results.mat_careName}<br>
													보호소 주소: ${results.mat_careAddress}<br>
													보호소 전화번호: ${results.mat_tel}<br>
													
													<form name="f" method="get" action="/team4/matching/insert" enctype="multipart/form-data" >
														<c:set var="img" value="${results.mat_img}"/>
														<c:set var="id" value="${results.mat_id}"/>
														<c:set var="age" value="${results.mat_age}"/>
														<c:set var="kind" value="${results.mat_kind}"/>
														<c:set var="sex" value="${results.mat_sex}"/>
														<c:set var="color" value="${results.mat_color}"/>
														<c:set var="size" value="${results.mat_size}"/>
														<c:set var="detail" value="${results.mat_detail}"/>
														<c:set var="careName" value="${results.mat_careName}"/>
														<c:set var="careAddress" value="${results.mat_careAddress}"/>
														<c:set var="tel" value="${results.mat_tel}"/>
														
														<input type="hidden" name="mat_img" value="<c:out value="${img }"/>"/>
														<input type="hidden" name="mat_id" value="<c:out value="${id }"/>"/>
														<input type="hidden" name="mat_age" value="<c:out value="${age }"/>"/>
														<input type="hidden" name="mat_kind" value="<c:out value="${kind }"/>"/>
														<input type="hidden" name="mat_sex" value="<c:out value="${sex }"/>"/>
														<input type="hidden" name="mat_color" value="<c:out value="${color }"/>"/>
														<input type="hidden" name="mat_size" value="<c:out value="${size }"/>"/>
														<input type="hidden" name="mat_detail" value="<c:out value="${detail }"/>"/>
														<input type="hidden" name="mat_careName" value="<c:out value="${careName }"/>"/>
														<input type="hidden" name="mat_careAddress" value="<c:out value="${careAddress }"/>"/>
														<input type="hidden" name="mat_tel" value="<c:out value="${tel }"/>"/>
														
														<input type="submit" value="입양신청">
													</form>
												</td>
										<c:if test="${count % 4 == 3}">
											</tr>
										</c:if>
										<c:set var="count" value="${count + 1}"/>
									</c:if>
								</c:if>
							</c:if>
						</c:if>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

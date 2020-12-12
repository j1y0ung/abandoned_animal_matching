<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- 정리완료 -->
<html>
<head>
	<meta charset="UTF-8">
	<title>보호소 정보</title>
	
</head>

<body>
	<jsp:include page="/main/index.jsp"/>
	<h6>동물보호센터명: ${st.careNm}</h6><br>
	<h6>소재지도로명주소: ${st.careAddr}</h6><br>
	<h6>전화번호: ${st.careTel}</h6><br>
	<h6>구조대상동물: ${st.saveTrgtAnimal}</h6><br>
	<h6>평일운영시작시각: ${st.weekOprStime}</h6><br>
	<h6>평일운영종료시각: ${st.weekOprEtime}</h6><br>
	<h6>휴무일: ${st.closeDay}</h6><br>
</body>
</html>
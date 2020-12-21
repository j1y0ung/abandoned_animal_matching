<%@page import="vo.MatchingVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="vo" value="${requestScope.vo}" />
<c:set var="matvo" value="${requestScope.matvo}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>마이페이지</title>
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
      #dscriptext{
      	font-family: 'RIDIBatang';
      	font-size: 1.2rem;
      	margin-top: 40px;
      	margin-bottom: 30px;
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
	
	<script type="text/javascript" src="../js/httpRequest.js"></script>
	
	<script>
		function send( f ){
			f.action = "/matching/list";
			f.method = "POST";
			f.submit();
		}
		
		function update(f) {
			f.action = "/member/update";
			f.method = "POST";
			f.submit();
		}
	</script>
</head>

<body>
	<jsp:include page="/main/index.jsp"/>

	<div class="container">
	<div class="text-center">
			<br><p id="dscriptext"> 내 정보 </p>
			<form>
				<table class="table" align="center">
					<tr>
						<td>이름</td>
						<td>${vo.mem_name}</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>${ vo.mem_id }<input type="hidden" name="mem_id" value="${vo.mem_id}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="mem_newPwd" value="${vo.mem_pwd}"></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="mem_phone" value="${vo.mem_phone}"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="mem_email" value="${vo.mem_email}"></td>
					</tr>
					<tr>
						<td>회원 등급</td>
						<td>${ vo.mem_membership }</td>
					</tr>
					<tr>
						<td>입양 신청 현황</td>
						<td>
							<c:if test="${ matvo.mat_img != null }">
								<img src="${matvo.mat_img }" style="width:100px; height:130px;"/><br>
								${matvo.mat_kind}<br>
								상태: ${matvo.mat_state}<br>
								<c:set var="ok" value="0" />
								<c:if test="${ matvo.mat_state == '승인완료' }">
									<input type="button" value="입양 후기 작성" onclick="location.href='/review/form?mat_id=${matvo.mat_id }&mat_img=${matvo.mat_img }&mem_id=${vo.mem_id}'">
								</c:if>
							</c:if>
						</td>
					</tr>
					<tr>
						<td>내가 쓴 Q&A 게시글</td>
						<c:forEach var="que" items="${vo.questionList}">
							<td><a href="<c:url value='/question/view'>
                    		 <c:param name='que_id' value='${que.id}'/>
                     		</c:url>">
                  			${que.title}</a></td>
						</c:forEach>
					</tr>
					<tr>
						<td>내가 쓴 Q&A 댓글</td>
						<c:forEach var="reply" items="${vo.replyList}">
							<td><a href="<c:url value='/question/view'>
                    		 <c:param name='que_id' value='${reply.que_id}'/>
                     		</c:url>">
                  			${reply.content}</a></td>
						</c:forEach>
					</tr>
					<tr>
						<td>내가 쓴 입양 후기</td>
						<c:forEach var="review" items="${vo.reviewList}">
							<td><a href="<c:url value='/review/view'>
                    		 <c:param name='rev_idx' value='${review.rev_idx}'/>
                     		</c:url>">
                  			${review.rev_title}</a></td>
						</c:forEach>
					</tr>					
					<c:if test="${ vo.mem_membership == '보호소관리자' }">
						<tr>
							<td colspan="2">
									<input type="hidden" name="careName" value="${ vo.mem_careAdmin }">
									<input type="hidden" name="code" value="adm">
									<input type="button" value="내 보호소 입양신청관리" onclick="send(this.form);">
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="2">
								<input type="hidden" name="updateCode" value="personal">
								<button type="button" class="btn btn-dark" onclick="update(this.form);">수정</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
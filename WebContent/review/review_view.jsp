<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>입양 후기 상세</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   	<link rel=stylesheet href="../resources/css/final_search_css.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    
    <meta name="generator" content="Jekyll v4.1.1">
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/blog/">

    <!-- Bootstrap core CSS -->
    <link href="/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/4.5/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/4.5/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <!-- <link rel="manifest" href="/docs/4.5/assets/img/favicons/manifest.json"> -->
    <link rel="mask-icon" href="/docs/4.5/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="/docs/4.5/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="/docs/4.5/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">


    <style>
        @font-face {
            font-family: 'NEXON Lv1 Gothic OTF';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        @font-face {
            font-family: 'RIDIBatang';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            margin-right: 40px;
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
</head>

	<script>
		function del( rev_idx ){
			if( confirm("삭제하시겠습니까?") == false ){
				return;
			}
			console.log(rev_idx);
			
			//ajax를 통해 삭제 처리
			var url = "/review/delete";
			var param = "rev_idx="+rev_idx;
			
			sendRequest(url, resultFn, "POST");
		}
		
		function resultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				//[{'res':'1'},{'idx':'3'}]
				if( json[0].result == '0' ){
					alert( json[1].rev_idx + "삭제 실패" );
				}
				else{
					alert(json[1].rev_idx+"번 후기 삭제 성공")
				}
				
				// 전체 목록을 select 하는 url로 다시 이동(서블릿)
				location.href="/review/list";
				//이동하면, select하고 list만들어서 이 페이지가 다시 나옴(forward 하니까)
			}
		}
	</script>

</head>

<body>
	<jsp:include page="/main/index.jsp"/>

	<br><br><br>
	<div class="container">
        <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col-auto d-none d-lg-block">
                       <img class="bd-placeholder-img" width="400" height="500" 
                               src="../images/${ vo.rev_img }" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"> 
                    </div>
                    <div class="col p-4 d-flex flex-column position-static">
                       	<h3><strong class="d-inline-block mb-2">${ vo.rev_title }</strong></h3>
                    	<h6 class="mb-1">작성일:&nbsp;&nbsp;&nbsp;${vo.rev_date }</h6>
                    	<br><br><br>
						<h6 class="mb-1">${vo.rev_content }</h6>
                    </div>
                </div>
   </div>

	
	<table align="center" width="600" border="1" style="border-collapse : collapse">
		<td>
			제목: ${ vo.rev_title }<br>
			작성일: ${vo.rev_date }<br>
			작성자: ${vo.mem_id }
			<hr><br>
			<img src="/images/${ vo.rev_img }"><br>
			내용 : ${vo.rev_content }<br>
			<c:if test="${sessionScope.mem_id == vo.mem_id || sessionScope.mem_id == 'admin'}">
				<input type="button" value="삭제" onclick="del('${vo.rev_idx}');"/>
			</c:if>
		</td>
	</table>
	

</body>
</html>
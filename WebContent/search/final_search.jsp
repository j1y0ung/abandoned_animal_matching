<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="model.dao.SearchingDAO,model.SearchingDTO" %>

<html>
<html lang="en">


<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel=stylesheet href="../resources/css/final_search_css.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
    <title>Dropdown Search Box</title>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".default_option").click(function () {
                $(".dropdown ul").toggleClass("active");
            });
            $(".default_option2").click(function () {
                $(".dropdown2 ul").toggleClass("active");
            });
            $(".default_option3").click(function () {
                $(".dropdown3 ul").toggleClass("active");
            });
            $(".dropdown ul li").click(function () {
                var text = $(this).text();
                $(".default_option").text(text);
                $(".dropdown ul").removeClass("active");
                $('[name=noticeNo]').val(text);
            })
            $(".dropdown2 ul li").click(function () {
                var text = $(this).text();
                $(".default_option2").text(text);
                $(".dropdown2 ul").removeClass("active");
                $('[name=processState]').val(text);
            })
            $(".dropdown3 ul li").click(function () {
                var text = $(this).text();
                $(".default_option3").text(text);
                $(".dropdown3 ul").removeClass("active");
                
                var order = text === "최신등록순" ? "DESC" : "ASC";
                $('[name=noticeSdt]').val(order);
            })
        });
        
        function goSearch() {
        	console.log('call function');
        	var f = document.getElementById('testForm');
        	console.log(f);
        	
        	if(!f.searchKeyword.value) {
        		f.searchKeyword.value = "";
        	}
        	
        	f.method = 'post';
        	f.action = '/team4/test/main';
        	f.submit();
        } 
        
        function goDetailPage(kind, age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight) {
        	
        	var f = document.getElementById('testForm');
        	
        	f.kind.value = kind;      	
        	f.age.value = age;        	
        	f.careAddr.value = careAddr;         	
        	f.careNm.value = careNm;        	
        	f.careTel.value = careTel;        	
        	f.chargeNm.value = chargeNm;        	
        	f.colorCd.value = colorCd;        	
        	f.desertionNo.value = desertionNo;        	
        	f.filename.value = filename;        	
        	f.happenDt.value = happenDt;        	
        	f.happenPlace.value = happenPlace;        	
        	f.kindCd.value = kindCd;        	
        	f.neuterYn.value = neuterYn;        	
        	f.noticeEdt.value = noticeEdt;        	
        	f.noticeNo.value = noticeNo;        	
        	f.noticeSdt.value = noticeSdt;        	
        	f.officetel.value = officetel;        	
        	f.orgNm.value = orgNm;        	
        	f.popfile.value = popfile;
        	f.processState.value = processState;        	
        	f.sexCd.value = sexCd;        	
        	f.specialMark.value = specialMark;        	
        	f.weight.value = weight;
        	f.method = 'post';
        	f.action = '/team4/search';	// 주소 파싱할 api 호출 
        	f.submit();
        }
    </script>


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>fianl_search</title>
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
    <!-- <link href="/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> -->

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
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
/*
        #margin {
            margin-bottom: 50px;
        }
        #mainmenu {
            font-family: 'RIDIBatang';
        }
        #projname {
            font-family: 'NEXON Lv1 Gothic OTF';
            font-size: 2rem;
            text-anchor: middle;
        }
        #text1 {
            font-size: 1.25rem;
            text-anchor: middle;
        }
*/
        
    </style>
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
</head>

<body>
<jsp:include page="/main/index.jsp"/>
<form method="post" name="testForm" id="testForm" action="<c:url value='/test/main' />">
	<input type="hidden" name="noticeNo" value="전국" />
	<input type="hidden" name="processState" value="보호중" />
	<input type="hidden" name="noticeSdt" value="DESC" />

	<input type="hidden" name="kind" />
	<input type="hidden" name="age" />
	<input type="hidden" name="careAddr" />
	<input type="hidden" name="careNm" />
	<input type="hidden" name="careTel" />
	<input type="hidden" name="chargeNm" />
	<input type="hidden" name="colorCd" />
	<input type="hidden" name="desertionNo" />
	<input type="hidden" name="filename" />
	<input type="hidden" name="happenDt" />
	<input type="hidden" name="happenPlace" />
	<input type="hidden" name="kindCd" />
	<input type="hidden" name="neuterYn" />
	<input type="hidden" name="noticeEdt" />
	<!-- <input type="hidden" name="noticeNo" /> -->
	<!-- <input type="hidden" name="noticeSdt" /> -->
	<input type="hidden" name="officetel" />
	<input type="hidden" name="orgNm" />
	<input type="hidden" name="popfile" />
	<!-- <input type="hidden" name="processState" /> -->
	<input type="hidden" name="sexCd" />
	<input type="hidden" name="specialMark" />
	<input type="hidden" name="weight" />


    <div class="view">
        <div class="wrapper">
            <div class="search_box">
                <div class="dropdown">
                    <div class="default_option">전국</div>
                    <ul class="region">
                        <li>전국</li>
                        <li>서울</li>
                        <li>경기</li>
                        <li>인천</li>
                        <li>강원</li>
                        <li>충북</li>
                        <li>충남</li>
                        <li>경북</li>
                        <li>경남</li>
                        <li>전북</li>
                        <li>전남</li>
                        <li>제주</li>
                    </ul>
                </div>
                <div class="dropdown2">
                    <div class="default_option2">보호중</div>
                    <ul class="state">
                        <li>보호중</li>
                        <li>종료</li>
                    </ul>
                </div>
                <div class="dropdown3">
                    <div class="default_option3">최신등록순</div>
                    <ul class="order">
                        <li>최신등록순</li>
                        <li>보호기간 임박순</li>
                    </ul>
                </div>
                <div class="search_field">
                    <input type="text" class="input" placeholder="Search" name="searchKeyword" value="${searchKeyword}">
                    <i class="fas fa-search" onClick="goSearch()"></i>
                </div>
            </div>
        </div>
    </div>
    <br>

    <div class="container">
        <div class="text-center">
            <p class="lead my-3 font-italic">Protected animal list</p> <br />
        </div>

        <div class="row mb-2">
        	<c:forEach items="${list}" var="sList" varStatus="status">
       		 <div class="col-md-6">
                <div class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                    	<c:if test="${sList.kind eq 'DOG'}" >
                    		<h4><strong class="d-inline-block mb-2 text-success">
                        		${sList.kind}
                        	</strong></h4>
                    	</c:if>
                    	<c:if test="${sList.kind eq 'CAT'}" >
                    		<h4><strong class="d-inline-block mb-2 text-danger">
                        		${sList.kind}
                        	</strong></h4>
                    	</c:if>
                    	<c:if test="${sList.kind eq 'OTHER'}" >
                    		<h4><strong class="d-inline-block mb-2">
                        		${sList.kind}
                        	</strong></h4>
                    	</c:if>
                   		<strong class="d-inline-block mb-2">
                       		${sList.noticeSdt}
                       	</strong>
                       	<strong class="d-inline-block mb-2">
                       		${sList.processState}
                       	</strong>
                        <strong class="mb-1">${sList.kindCd}</strong>
                        <p class="card-text mb-auto">${sList.sexCd}, ${sList.age}</p> <!-- "mb-1 text-muted" -->
                        <p class="card-text mb-auto">${sList.orgNm} ${sList.happenPlace} 발견</p>
                        <a href="#" onclick="goDetailPage('${sList.kind}','${sList.age}','${sList.careAddr}','${sList.careNm}','${sList.careTel}','${sList.chargeNm}','${sList.colorCd}','${sList.desertionNo}','${sList.filename}','${sList.happenDt}','${sList.happenPlace}','${sList.kindCd}','${sList.neuterYn}','${sList.noticeEdt}','${sList.noticeNo}','${sList.noticeSdt}','${sList.officetel}','${sList.orgNm}','${sList.popfile}','${sList.processState}','${sList.sexCd}','${sList.specialMark}','${sList.weight}')" class="stretched-link"></a>
                    </div>
                    <div class="col-auto d-none d-lg-block">
                      <img class="bd-placeholder-img" width="200" height="250" src="${sList.popfile}"
                            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" />
                    </div>
                </div>
            </div>
        	</c:forEach>
        </div>
    </div>
</form>
    <footer class="blog-footer">
    </footer>
</body> 
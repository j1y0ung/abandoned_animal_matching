<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
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
   
   <title>입양후기 등록 화면</title>

   <script>
      function checkdata( f ){
         f.submit();
      }
   </script>
</head>

<body>
   <jsp:include page="/main/index.jsp"/>

   <form name="f" method="post" action="/review/insert" enctype="multipart/form-data">
         
      <div class="container">
      <div class="text-center">
         <br><p id="dscriptext"> 입양 후기 등록 </p>
            
         <table class="table" align="center">
         <tr>
            <td>제목</td>
            <td colspan="4" align="center"><input name="rev_title"></td>
         </tr>
         <tr>
            <td>내용</td>
            <td colspan="4" align="center">
               <textarea cols="50" rows="10" name="rev_content"></textarea>
            </td>
         </tr>
         <tr>
            <td>이미지</td>
            <td colspan="4" align="center"><input type="file" name="rev_img" ></td>
         </tr>
         
            
         
         
<!-- 
         <tr>
            <td colspan="4" align="center"></td>   
            <td>
               <input type="button" value="글 등록하기" onclick="checkdata(this.form);">
               <input type="reset" value="초기화">
            </td>
         </tr>
         <tr>
            <td colspan="4" align="center"></td>
            <td>
               <c:set var="titleImg" value="${titleImg}" />
               <input type="hidden" value="${titleImg}" name="titleImg">
               <c:set var="mem_id" value="${mem_id}" />
               <input type="hidden" value="${mem_id}" name="mem_id">
               <c:set var="mat_id" value="${mat_id}" />
               <input type="hidden" value="${mat_id}" name="mat_id">
            </td>
         </tr>
-->
         </table>
         <br><br><br>
         <input type="button" class="btn btn-primary" value="글 등록하기" onclick="checkdata(this.form);">
         <input type="reset" class="btn btn-light" value="초기화">
            
            
               <c:set var="titleImg" value="${titleImg}" />
               <input type="hidden" value="${titleImg}" name="titleImg">
               <c:set var="mem_id" value="${mem_id}" />
               <input type="hidden" value="${mem_id}" name="mem_id">
               <c:set var="mat_id" value="${mat_id}" />
               <input type="hidden" value="${mat_id}" name="mat_id">
      </div>
      </div>
   </form>
</body>
</html> 
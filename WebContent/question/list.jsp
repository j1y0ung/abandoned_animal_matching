<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Q&A</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
   <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
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
      
      .col-11 {
         margin-top: 30px;
      }
      
      .size {
         font-size: 0.8rem;
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

<script>
function searchQuestion() {
   if (form.search.value == "") {
      alert("검색할 내용을 입력하십시오.");
      form.search.focus();
      return false;
   } 
   form.submit();
}
function createQuestion(targetUri) {
   var mem_id = '<%=(String)session.getAttribute("mem_id")%>';
   if (mem_id == "null") {
      alert("로그인이 필요합니다.");
      return false;
   }
   location.href = targetUri
}
</script>
  </head>
  <body>
     <jsp:include page="/main/index.jsp"/>
<c:if test="${secretAlert}">
   <div class="alert alert-warning alert-dismissable">
      <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
      <h4>비밀글입니다.</h4>
      작성자와 관리자만 확인할 수 있는 게시글입니다.
   </div>
</c:if>
<div class="row justify-content-md-center">
 <div class="col-11">
    <a class="size" href="<c:url value='/question/list'>
      <c:param name='order' value='orderOfDate'/>
      </c:url>">
   최신순&nbsp;&nbsp;</a>
   <a class="size" href="<c:url value='/question/list'>
      <c:param name='order' value='orderOfReply'/>
      </c:url>">
   댓글순&nbsp;&nbsp;</a>
   <a class="size" href="<c:url value='/question/list'>
      <c:param name='order' value='orderOfClick'/>
      </c:url>">
   조회순&nbsp;&nbsp;</a>
   <div class="float-right"> 
    <form class="form-inline" name="form" method="POST" action="<c:url value='/question/search' />"> 
       <div class="form-group">
          <select class="form-control" name="categories">
             <option value="1" selected>제목</option>
             <option value="2">제목+내용</option>
          </select>
       </div>&nbsp;
       <div class="form-group">
          <input type="text" name="search" class="form-control">
       </div>&nbsp;
       <input type="button" value="검색" onClick="searchQuestion()" class="form-control btn btn-success">
    </form>
   </div>
   <br>
   <table class="table table-striped text-center">
      <thead>
         <tr>
            <th scope="col">#</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
                <th scope="col">조회수</th>
         </tr>
      </thead>
      <tbody>
         <c:set var="i" value="${(pagination.curPage-1)*10}"/>
         <c:forEach var="que" items="${queList}">
            <tr>
               <c:set var="i" value="${i+1}"/>
               <th scope="row">${i}</th>
               <td>
                  <a href="<c:url value='/question/view'>
                     <c:param name='que_id' value='${que.id}'/>
                     <c:param name='que_writer_id' value='${que.writer_id}'/>
                     <c:param name='que_secret' value='${que.secret}'/>
                     </c:url>">
                  ${que.title}&nbsp;</a>
                  <c:if test="${que.total_reply > 0}"><span class="badge badge-pill badge-primary">${que.total_reply}</span></c:if>
                  <c:if test="${que.filename ne null}">
                     <i class="fa fa-file-image-o" aria-hidden="true"></i>
                  </c:if>
                  <c:if test="${que.secret.equals('y')}">
                     <span class="fa fa-lock" aria-hidden="true"></span>
                  </c:if>               
               </td>
               <td>${que.writer_id}</td>
               <td>${que.date}</td>
               <td>${que.hits}</td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
   <hr>
   <div>
      <div class="float-right">
      <button type="button" class="btn btn-primary text-left" onClick="createQuestion('<c:url value='/question/create/form' />')">글쓰기</button>
      <a class="btn btn-secondary text-right" href="<c:url value='/question/list'>
         <c:param name='order' value='my_question'/>
         </c:url>">
      내가 쓴 글 보기</a>
      </div>
   </div>
   <br><br>
   <nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center">
         <li class="page-item">
            <c:if test="${pagination.curRange ne 1}">
               <a class = "page-link" href="<c:url value='/question/list'>
                 <c:param name='curPage' value='1'/>
                 <c:param name='order' value='${order}'/>
                 </c:url>">처음</a>
            </c:if>
         </li>
         <li class="page-item">
            <c:if test="${pagination.curPage ne 1}">
               <a class = "page-link" href="<c:url value='/question/list'>
                 <c:param name='curPage' value='${pagination.prevPage}'/>
                 <c:param name='order' value='${order}'/>
               </c:url>">이전</a>
            </c:if>
         </li>
            <c:forEach var="pageNum" begin="${pagination.startPage}" end="${pagination.endPage}">
               <c:choose>
                  <c:when test="${pageNum eq  pagination.curPage}">
                     <li class="page-item">
                     <span style="font-weight: bold;">
                        <a class = "page-link" href="<c:url value='/question/list'>
                          <c:param name='curPage' value='${pageNum}'/>
                          <c:param name='order' value='${order}'/>
                        </c:url>">${pageNum}</a>
                     </span>
                     </li>
                  </c:when>
                  <c:otherwise>
                     <li class="page-item">
                     <a class = "page-link" href="<c:url value='/question/list'>
                     <c:param name='curPage' value='${pageNum}'/>
                     <c:param name='order' value='${order}'/>
                     </c:url>">${pageNum}</a>
                     </li>
                  </c:otherwise>
               </c:choose>
            </c:forEach>
            <li class="page-item">
               <c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
                  <a class = "page-link" href="<c:url value='/question/list'>
                    <c:param name='curPage' value='${pagination.nextPage}'/>
                    <c:param name='order' value='${order}'/>
                  </c:url>">다음</a>   
               </c:if>
            </li>
            <li class="page-item">
            <c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
               <a class = "page-link" href="<c:url value='/question/list'>
                 <c:param name='curPage' value='${pagination.pageCnt}'/>
                 <c:param name='order' value='${order}'/>
               </c:url>">끝</a>      
            </c:if>   
            </li>
         </ul>
   </nav>
   </div>
</div>   
<br>
<br>
</body>
</html>
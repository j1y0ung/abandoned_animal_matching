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
    <!-- Custom styles for this template -->
    <link href="../resources/css/blog.css" rel="stylesheet">
<script>
function questionRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
function replyRemove() {
	return confirm("정말 삭제하시겠습니까?");		
}
function firstReplyCreate() {
	if (firstReplyForm.content.value == "") {
		alert("내용을 입력하십시오.");
		firstReplyForm.content.focus();
		return false;
	}
	firstReplyForm.submit();
}
</script>
</head>
<body>
<!--  	<jsp:include page="/work/index.jsp"/>
	<hr> -->
<div class="container">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-header">
                	<h1><i class="fa fa-question-circle" aria-hidden="true"></i>
                	${que.title}</h1>
                    &nbsp;&nbsp;<a href="<c:url value='/user/view'>
                    	<c:param name='userId' value='${que.writer_id}'/>
                    	</c:url>">
                    	${que.writer_id}
                    </a>
                    <span>&nbsp;&nbsp;${que.date}&nbsp;&nbsp;|&nbsp;&nbsp;조회 - ${que.hits} </span>
                </div>
                <div class="card-body">
                <c:if test="${que.filename ne null}">
                	<img src="<c:url value='/images/${que.filename}' />" />   
                </c:if>          
                	<br>
                	<p>${que.content}</p><br><br><br>
                	<c:if test="${que.filename ne null}">
                	<hr><span class="badge badge-light">첨부파일(클릭시 다운로드)</span><br>
                	<a class = "card-link" href="<c:url value='/question/downloadfile'>
                	<c:param name='que_id' value='${que.id}'/>
                	</c:url>">${que.filename}</a><br></c:if>
                </div>
                <div class="card-footer">
				    <c:if test="${currentId eq que.writer_id}">
				    	<a class="btn btn-success" href="<c:url value='/question/update'>
				     		   <c:param name='que_id' value='${que.id}'/>
						 	 </c:url>">수정</a> &nbsp;
						 <a class="btn btn-danger" href="<c:url value='/question/delete'>
							   <c:param name='que_id' value='${que.id}'/>
							   <c:param name='filename' value='${que.filename}'/>
						 	 </c:url>" onclick="return questionRemove();">삭제</a> &nbsp; 
				    </c:if>
				    <div class="text-center">
				    	<a class="btn btn-info btn-lg" href="<c:url value='/question/list' />">Q&A 목록</a><br>
				    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<br>
<div class="container">
    <div class="row">
    	<div class="col">
    		<c:set var="i" value="0"/>
    		<c:set var="j" value="0"/>
    		<c:forEach var="reply" items="${replyList}">
    			<c:if test="${reply.parent_re_id eq '0'}">
					<div class="card border-light">
				  	<div class="card-header">
				  		<i class="fa fa-user" aria-hidden="true"></i>&nbsp;
						<a href="<c:url value='/user/view'>
	                    	<c:param name='userId' value='${reply.writer_id}'/>
								</c:url>">${reply.writer_id}</a>
								&nbsp;${reply.reg_date}
					</div>
					<div class="card-body">
				    	<p class="card-text">${reply.content}</p>
				    	<div class = "text-left">
				    		<c:if test="${currentId eq reply.writer_id}"><br>	
				    			<div class="accordion" id="accordionEx">
				    				<form name="updateForm_@i" method="POST" action="<c:url value='/reply/update' />">
				    					<input type="hidden" name="que_id" value="${que.id}">
				    					<input type="hidden" name="re_id" value="${reply.re_id}"> 
				    					<div id="update${i}">
				    						<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#collapseUpdate${i}" area-expanded="true" aria-controls="collapseUpdate${i}">수정</button> &nbsp;
				    					</div>
				   						<div id="collapseUpdate${i}" class="collapse<c:if test='${i==-1}'> show</c:if>" aria-labelledby="update${i}" data-parent="#accordionEx">
				   							<div class="form-group">
												<br><textarea class="form-control textarea" rows="5" name="content">${reply.content}</textarea>
											</div>
											<input type="submit" class="btn btn-primary" value="등록">
				   						</div>
				    				</form>
				    			</div>
								 <a class="btn btn-danger" href="<c:url value='/reply/delete'>
									   <c:param name='re_id' value='${reply.re_id}'/>
									   <c:param name='que_id' value='${que.id}'/>
								 	 </c:url>" onclick="return replyRemove();">삭제</a> &nbsp;	 
							</c:if>
				    	</div>
				    	<div class="accordion" id="accordionExample">
				    	<form name="secondReplyForm_@i" method="POST" action="<c:url value='/reply/create' />"> 
    	    				<input type="hidden" name="que_id" value="${que.id}"/>
    	    				<input type="hidden" name="parent_re_id" value="${reply.re_id}"/>
					    	<div class = "text-right" id="heading${i}">
					    		<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#collapse${i}" area-expanded="true" aria-controls="collapse${i}">대댓글달기</button>
					    	</div>	
					    		<div id="collapse${i}" class="collapse<c:if test='${i==-1}'> show</c:if>" aria-labelledby="heading${i}" data-parent="#accordionExample">
					    			<div class="form-group">
										<br><textarea class="form-control textarea" rows="5" name="content"></textarea>
									</div>
										<div class="text-right"><input type="submit" class="btn btn-success text" value="등록"></div>
								</div>
					    	<br>
					    </form>	 
					    </div>
					    <c:set var="i" value="${i+1}"/>
				    	<c:forEach var="secondReply" items="${replyList}">
							<c:if test="${secondReply.parent_re_id eq reply.re_id}">
								<div class="col-11 pull-right">
								<div class="card border-light">
							  	<div class="card-header">
							  		<i class="fa fa-user" aria-hidden="true"></i>&nbsp;
									<a href="<c:url value='/user/view'>
				                    	<c:param name='userId' value='${secondReply.writer_id}'/>
											</c:url>">${secondReply.writer_id}</a>
											&nbsp;${secondReply.reg_date}
								</div>
								<div class="card-body">
							    	<p class="card-text">${secondReply.content}</p><br>
							    	<div class = "text-right">
							    		<c:if test="${currentId eq secondReply.writer_id}">
							    			<div class="accordion" id="accordionExam">
							    				<form name="updateSecondForm_@i" method="POST" action="<c:url value='/reply/update' />">
							    					<input type="hidden" name="que_id" value="${que.id}">
							    					<input type="hidden" name="re_id" value="${secondReply.re_id}"> 
							    					<div id="updateSecond${j}">
							    						<button type="button" class="btn btn-success" data-toggle="collapse" data-target="#collapseUpdateSecond${j}" area-expanded="true" aria-controls="collapseUpdateSecond${j}">수정</button> &nbsp;
							    					</div>
							   						<div id="collapseUpdateSecond${j}" class="collapse<c:if test='${j==-1}'> show</c:if>" aria-labelledby="updateSecond${j}" data-parent="#accordionExam">
							   							<div class="form-group">
															<br><textarea class="form-control textarea" rows="5" name="content">${secondReply.content}</textarea>
														</div>
														<input type="submit" class="btn btn-primary" value="등록">
							   						</div>
							    				</form>
							    			</div>
											 <a class="btn btn-danger" href="<c:url value='/reply/delete'>
												   <c:param name='re_id' value='${secondReply.re_id}'/>
												   <c:param name='que_id' value='${que.id}'/>
											 	 </c:url>" onclick="return replyRemove();">삭제</a> &nbsp; 
										</c:if>
							    	</div>
							    	<hr>
								</div>
								</div>	
								</div>
							</c:if>
							<c:set var="j" value="${j+1}"/>
						</c:forEach>
						</div>
				    	<hr>
					</div>
				</c:if>
			</c:forEach>		
		</div>
	</div>
</div>
<br><br>
<div class="container">
    <div class="row">
    	<div class="col">
    		<form name="firstReplyForm" method="POST" action="<c:url value='/reply/create' />"> 
    			<input type="hidden" name="que_id" value="${que.id}"/> 
    			<input type="hidden" name="parent_re_id" value="0"/>
            	<div class="panel panel-default">
	                <div class="panel-body">
	                	<div class="form-group">
	                    	<textarea class="form-control textarea" rows="5" name="content"></textarea>
	                    </div>
	                </div>
	                <div class="panel-footer text-right">
	                	<button type="button" class="btn btn-success btn-lg" onClick="firstReplyCreate()">등록</button> &nbsp;
	                </div>
            	</div>
        	</form>
        </div>
    </div>
</div>
</body>
</html>
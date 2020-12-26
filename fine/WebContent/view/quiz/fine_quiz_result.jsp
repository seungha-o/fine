<%@page import="fine.community.quiz.service.QuizService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- icon(fontawesome) -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- link css -->
<link rel="stylesheet" href="<%=ctxPath %>/css/head_foot.css" />
<!-- font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet" />
	
<!-- CSS -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
	
<style>


/* SECTION */
.h_title {
	margin-bottom: 6vh;
	font-size: 50px;
}
#wrap {
	margin: 10vh 0;
	border-radius: 4px;
	margin-top: 100px;
	text-align: center;
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:50%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    text-align: center;
    border: 2px solid #A4A4A4;
    border-radius: 4px;
   /*  background-color: #A9F5D0; */
  /* 	background: linear-gradient(to bottom, blue, white); */
    /* background: linear-gradient(to right, blue, purple); */
 /*  	background: radial-gradient(circle, white, blue, violet); */
  	background: linear-gradient(45deg, blueviolet, aquamarine);
             }
}

#header {
	font-size: 100px;
	padding:10px;
	color:white;
}


#PtotalRs {
 	width:100%;
	height:150px;
	font-size: 50px;
	color:white;
}
#PtotalGd {
	width:100%;
	height:150px;
	font-size: 50px;
	color:white;
}
#BtnGoAdopt, #BtnGoTraining{
  background-color: #E6E6E6; 
  border: none;
  color: black;
  padding: 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 30px;
  margin: 1px 1px;
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
  font-family: 'Jua', sans-serif;
}
#BtnGoAdopt:hover {
	background-color: #848484;
	color:white;
	
}

#BtnGoTraining:hover {
	background-color: #848484;
	color:white;
}
</style>


</head>
<body>
<!-- header -->
<jsp:include page="/common/header.jsp" />
			
			
<!--Section -->
<% 
	String ctxpath = request.getContextPath();
	String count = (String)session.getAttribute("count");
	session.removeAttribute("count");
	session.removeAttribute("quizlist");

	
%>
<!-- 	session.removeAttribute("count");
				session.removeAttribute("quizlist");
				request.setAttribute("grade", grade);
				request.setAttribute("totalResult", totalResult); -->
<div id="wrap">	
	<div id="header">
		<h1 class="h_title">나의 퀴즈점수는?</h1>
	</div>
	 <div id="main">
		<c:if  test="${not empty totalResult }">
			<p id="PtotalRs">${totalResult }점을 획득하셨습니다!</p>
	
		<c:if  test="${not empty grade }">
			<p id="PtotalGd">${grade }등급입니다</p>
		</c:if>
		<c:choose>
			<c:when test="${totalResult ge 50 }"> 
				<button type="button" id="BtnGoAdopt" onclick="window.location='<%=ctxpath%>/find_adopt_List.do'">입양하러가기</button>
			</c:when>
			<c:when test="${totalResult lt 50 }"> 
				<button type="button" id="BtnGoTraining" onclick="window.location='<%=ctxpath%>/training_list.do'">훈련정보보기</button>
			</c:when>
		</c:choose>
		</c:if>
	</div>
</div>
<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />		
</body>
</html>
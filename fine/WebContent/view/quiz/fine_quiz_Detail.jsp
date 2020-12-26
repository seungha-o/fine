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
	font-family: 'Jua', sans-serif;
}

#quizDetailFrm {
	text-align: center;
	margin: 10vh 0;
}

#qzDetailTable {
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:50%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    text-align: center;
    border: 2px solid #A4A4A4;
}
#qzDetailTable td, #qzDetailTable th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
}

#tdQuizno,#tdCont,#tdAns {
	background-color: #F2F2F2;
	font-weight: bold;
	
}


#btnListUpDel {
	padding:10px;
}

#BtnGoList, #BtnUpdate, #BtnDelete {
  background-color: #E6E6E6; 
  border: none;
  color: black;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 1px 1px;
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
  font-family: 'Jua', sans-serif;
}
#BtnGoList:hover {
	background-color: #848484;
	color:white;
}

#BtnUpdate:hover {
	background-color: #848484;
	color:white;
}
#BtnDelete:hover {
	background-color: #848484;
	color:white;
}

</style>
</head>
<body>
<!-- header -->
<jsp:include page="/common/header.jsp" />
	<!--Section -->
	<form action="#"  id="quizDetailFrm">
		<h1 class="h_title">관리자 글 상세페이지</h1>
		<c:if test="${not empty list}">
			<c:forEach items="${ list }" var="mvo" varStatus="s">
			 <div id = "qzDetailTbl">
					<table id ="qzDetailTable">
						<tr>
							<td id="tdQuizno">글번호</td>
							<td>${mvo.quiz_no}</td>
						</tr>
						<tr>
							<td id="tdCont">글내용</td>
							<td>${mvo.quiz_content}</td>
						</tr>
						<tr>
							<td id="tdAns">정답</td>
							<td>${mvo.answer}</td>
						</tr>
					</table>
				</div>
				<div id="btnListUpDel">
					<button type="button" id="BtnGoList"
					onclick="window.location='<%=ctxPath%>/qzmListManager.do'">글목록</button>
					<button type="button" id="BtnUpdate"
					onclick="window.location='<%=ctxPath%>/quizUpdateInfo.do?no=${mvo.quiz_no}'">수정</button>
					<button type="button" id="BtnDelete"
					onclick="window.location='<%=ctxPath%>/quizDelete.do?no=${mvo.quiz_no}'">삭제</button>
				</div>
			</c:forEach>
		</c:if>
	</form>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
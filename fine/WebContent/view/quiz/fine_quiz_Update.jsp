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

#quizUpdateFrm {
	text-align: center;
	margin: 10vh 0;
}

#qzUpdateTable {
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:50%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    text-align: center;
    border: 2px solid #A4A4A4;
}
#qzUpdateTable td, #qzUpdateTable th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
}

#tdNo,#tdCont,#tdAns {
	background-color: #F2F2F2;
	font-weight: bold;
	
}
#no {
	border: 1px solid gray;
	text-align: center;
	height: 30px;
	width:100%;
}

#content {
 	width:100%;
	height:150px;
	border: 1px solid gray;
}
#answer {
	width:30%;
	height:30px;
	border: 1px solid gray;
	text-align: center;
}

#btnSubCan {
	padding:10px;
}
#BtnSubmit, #BtnCancel {
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
#BtnSubmit:hover {
	background-color: #848484;
	color:white;
}

#BtnCancel:hover {
	background-color: #848484;
	color:white;
}
</style>
</head>
<body>
<!-- header -->
<jsp:include page="/common/header.jsp" />
	<!--Section -->
	<c:if test="${not empty list}">
		<c:forEach items="${ list }" var="mvo" varStatus="s">
			<form action="<%=ctxPath%>/quizUpdate.do" method="POST" id="quizUpdateFrm">
				<h1 class="h_title">관리자 글 수정페이지</h1>
				<div id = "qzUpdateTbl">
					<table id ="qzUpdateTable" >
						<%-- <tr style="visibility: hidden;">
							<td id="tdNo">글번호</td>
							<td><input type="text" id="no" name="no" style="visibility: hidden;"
								value="${mvo.quiz_no}"></td>
						</tr> --%>
						<tr>
							<td id="tdCont">글내용</td>
							<td><textarea rows="3" cols="50" name="content" id="content">${mvo.quiz_content }</textarea></td>
	
						</tr>
						<tr>
							<td id="tdAns">정답</td>
							<td><select id="answer" name="answer" >
									<option>O</option>
									<option>X</option>
							</select></td>
						</tr>
						
					</table>
				</div>
				<div id = "btnSubCan">
						<input type="submit" id="BtnSubmit" value="전송"/>
						<button type="button" id="BtnCancel">취소</button>
				</div>
			</form>
		</c:forEach>
	</c:if>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
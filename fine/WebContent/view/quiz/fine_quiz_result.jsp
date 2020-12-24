<%@page import="fine.community.quiz.service.QuizService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
				
<c:if test="${not empty totalResult }">
	<p>${totalResult }입니다</p>


<c:if test="${not empty grade }">
	<p>${grade }입니다</p>
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

</body>
</html>
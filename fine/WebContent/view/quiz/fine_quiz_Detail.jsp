<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxpath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}

table tr, th, td {
	border: 1px solid black;
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body>
	<form action="">
		<c:if test="${not empty list}">
			<c:forEach items="${ list }" var="mvo" varStatus="s">
				<table>
					<tr>
						<td>글번호</td>
						<td>${mvo.quiz_no}</td>
					</tr>
					<tr>
						<td>글내용</td>
						<td>${mvo.quiz_content}</td>
					</tr>
					<tr>
						<td>정답</td>
						<td>${mvo.answer}</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" id="BtnGoList"
								onclick="window.location='<%=ctxpath%>/qzmListManager.do'">글목록</button>
							<button type="button" id="BtnDelete"
								onclick="window.location='<%=ctxpath%>/quizUpdateInfo.do?no=${mvo.quiz_no}'">수정</button>
							<button type="button" id="BtnDelete"
								onclick="window.location='<%=ctxpath%>/quizDelete.do?no=${mvo.quiz_no}'">삭제</button>
						</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
	</form>
</body>
</html>
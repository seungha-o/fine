
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Document</title>
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



	<c:if test="${not empty list}">
		<c:forEach items="${ list }" var="mvo" varStatus="s">
			<form action="<%=ctxPath%>/quizUpdate.do" method="POST">

				<table>
					<tr>
						<td>글번호</td>
						<td><input type="text" id="no" name="no"
							value="${mvo.quiz_no}"></td>
					</tr>
					<tr>
						<td>글내용</td>
						<td><textarea rows="3" cols="50" name="content">${mvo.quiz_content }</textarea></td>

					</tr>
					<tr>
						<td>정답</td>
						<td><select id="answer" name="answer">
								<option>O</option>
								<option>X</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="전송" />
							<button type="button" id="BtnCancel">취소</button></td>
					</tr>
				</table>
			</form>
		</c:forEach>
	</c:if>



</body>
</html>
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
<title>rescue 상세페이지</title>
</head>
<body>
	<form>
		count : ${detailList.rec_count }
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<c:if test="${not empty detailList }">
				<input type="hidden" name=rec_no value="${detailList.rec_no}">
				<tr>
					<td>번호</td>
					<td>${detailList.rec_no}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${detailList.rec_title}</td>
					<td>작성자</td>
					<td>${detailList.id }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${detailList.rec_write_date }</td>
					<td>조회수</td>
					<td>${detailList.rec_count }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${detailList.rec_contents }</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td>
						<c:forEach items="${detailList.rec_img}" var="img">
							<c:if test="${not empty img}">
								<img src="<%=ctxPath%>/files/${img}" width="300" height="150">
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
				<td colspan="2">
					<a href="rescueDetailToUpdate.do?rec_no=${detailList.rec_no}"><input type="button" value="수정"></a>
					&nbsp;&nbsp;<a href="rescueList.do">목록보기</a>
					&nbsp;&nbsp;<a href="rescueDelete?rec_no=${detailList.rec_no}">삭제</a>
					&nbsp;&nbsp;<a href="rescueReply_view.do?rec_no=${detailList.rec_no}">답변</a>
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>
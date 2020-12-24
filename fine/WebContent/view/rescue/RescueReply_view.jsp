<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert Reply</title>
</head>
<body>
	${reply_view.rec_no}
	<hr>
	${reply_view.ref}
	<hr>
	${reply_view.ref_step}
	<hr>
	${reply_view.ref_level}
	<hr>
	<form action="rescueReply.do" method="post">
		<input type="hidden" name="rec_no" value="${reply_view.rec_no}">
		<input type="hidden" name="ref" value="${reply_view.ref}">
		<input type="hidden" name="ref_step" value="${reply_view.ref_step}">
		<input type="hidden" name="ref_level" value="${reply_view.ref_level}">
		<table cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>글 번호</td>
				<td>${reply_view.rec_no}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${reply_view.rec_count }</td>
			</tr>
			<tr>
				<itd>답변 제목</td>
				<td><input type="text" name="title"
					value="${reply_view.rec_title}" placeholder="[댓글 ]혹은 [답글] : 제목"></td>
			</tr>
			<tr>
				<td>답변 작성자</td>
				<td><input type="text" name="id" value="${reply_view.id }"></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${reply_view.rec_write_date }</td>
			</tr>
			<tr>
				<td>답변 내용</td>
				<td><textarea rows="10" name="content">${reply_view.rec_contents}</textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><nput type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="답변">
					&nbsp;&nbsp;<a href="rescueList.do">목록</a></td>
			</tr>
		</table>
	</form>

</body>
</html>
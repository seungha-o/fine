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
<script type="text/javascript">
	function doUpdate() {
		let form = document.doUpdate;
		form.action = "../rescueUpdate";
		form.method = "post";
		form.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form name="doUpdate" action="rescueUpdate" encType="multipart/form-data" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<c:if test="${not empty updateList }" var="list">
				<input type="hidden" name=rec_no value="${updateList.rec_no}">
				<tr>
					<td>번호</td>
					<td>${updateList.rec_no}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${updateList.rec_title}"></td>
					<td>작성자</td>
					<td>${updateList.id }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${updateList.rec_write_date }</td>
					<td>조회수</td>
					<td>${updateList.rec_count }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" rows="10">
							${updateList.rec_contents }
						</textarea>
					</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td>
						<c:forEach items="${updateList.rec_img}" var="img">
							<c:if test="${not empty img}">
								<img src="<%=ctxPath%>/files/${img}" width="300" height="150">
							</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>x</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						&nbsp;&nbsp;<a href="rescueList.do">목록보기</a>
					</td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>
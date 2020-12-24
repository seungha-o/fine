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
<script type="text/javascript">
	function doSearch() {
		let form = document.search;
		form.action = "qnaSearch.do";
		form.method = "post";
		form.submit();
	}
</script>
<title>QnA SearchList</title>
</head>
<body>
	<form name="search">
		<input type="text" name="title" id="title" placeholder="제목"> <input
			type="submit" id="submit" value="검색" onclick="doSearch()">
	</form>
	<table border=1>
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>비밀글</th>
		</tr>
		<c:if test="${ not empty searchList }">
			<c:forEach items="${ searchList }" var="list" varStatus="s">
				<tr>
					<td>${s.count}</td>
					<td>${list.id}</td>
					<td><a href="qnaDetail.do?qna_no=${list.qna_no}">${list.qna_title}</a>
					</td>
					<td>${list.qna_write_date }</td>
					<td>${list.qna_count }</td>
					<td>${list.qna_statement }</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="6"><a href="qna/QnAWrite.jsp">글작성</a></td>
			<td>&nbsp;&nbsp;<a href="qnaList.do">목록보기</a></td>
		</tr>
	</table>

	<!--페이징 아래 숫자-->
	<div class="pagediv">
		<c:if test="${searchStartPage != searchEndPage}">
			<c:forEach varStatus="s" begin="${searchStartPage}" end="${searchEndPage}" step="1">
					<a href="qnaSearch.do?pageNum=${s.count}&title=${searchWord}">${s.count}</a>
					<!--변경 : href 경로
						&title=${searchWord} -->
			</c:forEach>
		</c:if>
	</div>
	
</body>
</html>
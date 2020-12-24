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

<style type="text/css">
	.training_content_side {
		display: inline;
		width: 20%;
	}
</style>
<title>QnA List</title>
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
		<c:if test="${ not empty qnaList }">
			<c:forEach items="${ qnaList }" var="list" varStatus="s">
				<tr>
					<td>${s.count}</td>
					<td>${list.id}</td>
					<td><a href="qnaDetail.do?qna_no=${list.qna_no}">${list.qna_title}</a>
					</td>
					<td>${list.qna_write_date }</td>
					<td>${list.qna_count }</td>
					<td>${list.qna_statement }</td>
					<td>${list.ref}</td>
					<td>${list.ref_step }</td>
					<td>${list.ref_level }</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="6"><a href="./view/qna/QnAWrite.jsp">글작성</a></td>
		</tr>
	</table>
	<!--페이징 아래 숫자-->
	<div class="training_content_side">
		<%
			int count = (int) request.getAttribute("count");
		int currentPage = (int) request.getAttribute("currentPage");
		int endPage = (int) request.getAttribute("endPage");
		int startPage = (int) request.getAttribute("startPage");
		int pagecount = (int) request.getAttribute("pagecount");
		if (count > 0) {
			if (currentPage > 0 || endPage < pagecount) {
				if (currentPage == startPage) {
		%>
		<div> <!-- 이전 -->
			<a href="<%=ctxpath%>/qnaList.do?pageNum=<%=startPage%>"> 이전</a>
			<%
				} else {
			%>
			<a href="<%=ctxpath%>/qnaList.do?pageNum=<%=currentPage - 1%>">
				이전</a>
			<%
				}
			}
			%>
		</div>
		<div class="pagediv">
			<c:if test="${startPage != endPage}">
				<c:forEach varStatus="s" begin="${startPage}" end="${endPage}"
					step="1">
					<a href="qnaList.do?pageNum=${s.count}">${s.count}</a>
					<!--변경 : href 경로 -->
				</c:forEach>
			</c:if>
		</div>
		<div> <!-- 다음 -->
			<%
				if (currentPage > 0 || endPage < pagecount) {
					if (currentPage == endPage) {
			%>
			<a href="<%=ctxpath%>/qnaList.do?pageNum=<%=endPage%>"> 다음</a>
			<%
					} else {
			%>
			<a href="<%=ctxpath%>/qnaList.do?pageNum=<%=currentPage + 1%>">
				다음</a>
			<%
					}
				}
			}
			%>
		</div>
	</div>
</body>
</html>
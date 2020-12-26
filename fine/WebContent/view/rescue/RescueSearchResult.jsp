<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxpath = request.getContextPath();
	String id = (String) request.getSession().getAttribute("sessionID");
	String level = (String) request.getSession().getAttribute("memberLev");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- icon(fontawesome) -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- link css -->
<link rel="stylesheet" href="<%=ctxpath %>/css/head_foot.css" />
<!-- font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet" />
<!-- FORM -->
<script type="text/javascript">
	function doSearch() {
		let form = document.search;
		form.action = "rescueSearch.do";
		form.method = "post";
		form.submit();
	}
</script>
<style>
/* SECTION */
.h_title {
	font-family: 'Jua', sans-serif;
	margin: 10vh;
	font-size: 1.5vmax;
	text-align: center;
	text-decoration: underline;
}
#searchForm {
	width: 60%;
	margin: 0 auto 2vh auto;
	text-align: right;
	font-family: "Open Sans", sans-serif;
}
#search {
	width: 60%;
	display: flex;
	text-align: right;
	padding: 10px;
	margin-top: 6vh;
}
#title {
	padding: 10px;
	border-radius: 4px;
	color: black;
	transition: .3s ease-in;
	margin-bottom: 5vh;
}
#title:hover {
	background-color: black; 
	color: white;
}
section {
	text-align: center;
	margin: 10vh 0;
}
#table {
	font-family: 'Jua', sans-serif;
	font-size: 1vmax;
	width: 60%;
	position: relative;
	left: 50%;
	transform: translate(-50%);
}
#table td, #table th {
	border-bottom: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}
#table tr:hover {
	background-color: rgb(235, 235, 235);
}
#table th {
	border-top: 2px solid #A4A4A4;
	border-bottom: 2px solid #A4A4A4;
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #F2F2F2;
	color: #black;
	text-decoration: none;
}

.btn {
	font-family: 'Jua', sans-serif;
	background-color: #E6E6E6;
	border: none;
	color: black;
	padding: 7px 13px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 1.1vmax;
	margin: 10px 10px;
	cursor: pointer;
	border-radius: 4px;
	transition: .3s ease-in;
}
.btn:hover {
	background-color: black;
	color: white;
}
#bottom {
	font-family: "Open Sans", sans-serif;
	margin-top: 2vh;
	text-align: center;
}
.paging {
	display: flex;
	width: 60%;
	justify-content: center;
	margin: 3vh auto 3vh auto;
}
</style>
<title>Rescue SearchList</title>
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/common/header.jsp" />
	<!-- SECTION -->
	<form name="search">
		<h2 class="h_title">Rescue Search List</h2>
		<div id="searchForm">
			<input type="text" name="title" id="title" placeholder="제목">
			<input type="submit" id="submit" class="btn" value="검색" onclick="doSearch()">
		</div>
	</form>
	<table id="table">
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
					<td><a href="rescueDetail.do?rec_no=${list.rec_no}">${list.rec_title}</a>
					</td>
					<td>${list.rec_write_date }</td>
					<td>${list.rec_count }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div id="bottom">
		<a href="<%=ctxpath %>/rescueList.do" class="btn">목록보기</a>
		<a href="./view/main/index.jsp"  class="btn">홈으로</a>
	</div>

	<!--페이징 아래 숫자-->
	<div class="paging">
		<c:if test="${searchStartPage != searchEndPage}">
			<c:forEach varStatus="s" begin="${searchStartPage}" end="${searchEndPage}" step="1">
					<a href="rescueSearch.do?pageNum=${s.count}&title=${searchWord}">${s.count}</a>
					<!--변경 : href 경로
						&title=${searchWord} -->
			</c:forEach>
		</c:if>
	</div>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
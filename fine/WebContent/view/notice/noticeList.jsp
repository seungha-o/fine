<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fine.notice.model.NoticeVO"%>
<%@page import="java.util.List"%>
<%@page import="fine.notice.model.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<title>Notice List</title>
 <script
      src="https://kit.fontawesome.com/333b7ab4b4.js"
      crossorigin="anonymous"
    ></script>
    <!-- link jQuery -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="<%=ctxPath %>/js/datepicker-ko.js"></script>
    <!-- link css -->
<link rel="stylesheet" href = "./css/head_foot.css">
    <!-- font -->
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
      rel="stylesheet"
    />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
      rel="stylesheet"
    />
<meta charset="UTF-8">
	<script type="text/javascript">
	
	function doSearch(){
		console.log("a");
		var form = document.search;
		form.action = "<%=ctxPath %>/noticeSearch.do";
		form.method = "post";
		form.submit();
	}
	</script>
<style>
.n_title {
	margin-bottom: 6vh;
}

#Notice_section {
	text-align: center;
	margin: 10vh 0;
}

#nTable {
	font-family: 'Jua', sans-serif;
	border-collapse: collapse;
	width: 60%;
	position: relative;
	left: 50%;
	transform: translate(-50%);
}

#nTable td, #nTable th {
	border-bottom: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

a {
	text-decoration: none;
}

#nTable tr:hover {
	background-color: #ddd;
}

#nTable th {
	border-top: 2px solid #A4A4A4;
	border-bottom: 2px solid #A4A4A4;
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #F2F2F2;
	color: #black;
	text-decoration: none;
}

#search {
	text-align: center;
	padding: 10px;
	margin-top: 6vh;
}

#btnSearch, #btnWrite {
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
}
#btnSearch:hover {
	background-color: #848484;
	color: white;
}

#btnWrite:hover {
	background-color: #848484;
	color: white;
}
</style>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<section id="Notice_section">
	<h1 class = "n_title">공지사항</h1>
	<div id = "nTbl">
	<table id = "nTable" >
		<tr>

			<th>제목</th>
			<th>아이디</th>
			<th>날짜</th>
			<th>조회수</th>  
		</tr>

		<c:forEach items="${list}" var="vo">
			<tr>
				<td><a href="noticeDetail.do?notice_no=${vo.notice_no}">${vo.notice_title}</a></td>
				<td>${vo.id}</td>
				<td>${vo.notice_write_date}</td>
				<td>${vo.notice_count}</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="5">
		 <c:if test="${memberLev eq 3 }">	
			<a href="noticeFixCount.do">글작성</a>
			 </c:if>
			</th>
		</tr>
	</table>
	</div>
		<form id ="search" action = "<%=ctxPath %>/noticeSearch.do" method = "post" >
		<input type="text" name="title" id="title" placeholder="제목">
		<button type = "submit" id = "btnSearch">검색</button>
	</form>
	<!--페이징 아래 숫자-->
			<div class="pagediv">
				<c:if test="${startPage != endPage}">
					<c:forEach varStatus="s"  begin="${startPage}" end="${endPage}" step="1">
						<a href="noticeList.do?pageNum=${s.count}">${s.count}</a>	<!--변경 : href 경로 -->
					</c:forEach>
				</c:if>
			</div>
	</section>
	


	<%@ include file="/common/footer.jsp" %>
</body>
</html>
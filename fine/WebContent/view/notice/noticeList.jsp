<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fine.notice.model.NoticeVO"%>
<%@page import="java.util.List"%>
<%@page import="fine.notice.model.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Notice List</title>
<link rel="stylesheet" href = "css/index.css">
<meta charset="UTF-8">
<script type="text/javascript">
	function doSearch() {
		let form = document.search;
		form.action = "noticeSearch.do";
		form.method = "post";
		form.submit();
	}
</script>

<style>
table {
   border-collapse: collapse;
	text-align : center;
	margin : auto;
	width : 1200px;
	position : relative;
	top : 50px;
}
table td {
  text-align: left;
  padding: 8px;
}
table tr:nth-child(even){background-color: #ECECAE}
table tr:hover :not(th){background-color:#DDE1C3}
table a {padding : 0; color : black;}
table a:hover {color: hsl(167, 49%, 35%)!important; }
th { height : 50px; border : 1px; }
form { 
margin: 0 auto; 
width:250px; 
padding : 20px; 
}
.pagediv {
text-align: center; 
}
.pagediv a{
color : black!important;
}
.pagediv a:hover {font-size:110%; }
input {
position : relative;
top : 20px;
text-align: left; 
}
</style>
</head>


<body>
	<%@ include file="/common/header.jsp" %>
	<section id="section">
	<table cellpadding="0" cellspacing="0" >
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>날짜</th>
			<th>조회수</th>  
		</tr>

		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.notice_no}</td>
				<td><a href="noticeDetail.do?notice_no=${vo.notice_no}">${vo.notice_title}</a></td>
				<td>${vo.id}</td>
				<td>${vo.notice_write_date}</td>
				<td>${vo.notice_count}</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="5"><a href="noticeFixCount.do">글작성</a></th>
		</tr>
	</table>
		<form name="search">
		<input type="text" name="title" id="title" placeholder="제목">
		<input type="submit" id="submit" value="검색" onclick="doSearch()">
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
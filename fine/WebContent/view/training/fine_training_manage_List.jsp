
<%@page import="fine.community.training.model.TrainingDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxpath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<script src="../js/jquery-3.5.1.js"></script>
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
   <script type="text/javascript">
	function goSearch() {
		var frm = document.trainingSearchFrm;
		frm.action = "<%=ctxpath%>/training_Search.do";
		frm.method = "post";
		frm.submit();
	}
	</script> 

</head>
<body>
	<form name=trainingSearchFrm>
		<h2>관리자게시판</h2>
			<input type="text" name="kwd" id="trainingSearch">
			<button type="button" onclick="goSearch()">검색</button>
			
		<table border="1" style="width: 500px; height: 150px">
			<tr>

				<th>글번호</th>
				<th>제목</th>
				<th>게시자</th>
			</tr>
			<c:if test="${not empty list}">
				<c:forEach items="${ list }" var="mvo" varStatus="s">
					<tr>
						<td><a href="<%=ctxpath%>/trainingDetail.do?no=${mvo.trn_no}">${mvo.trn_no}</a></td>
						<td>${mvo.trn_title}</td>
						<td>${mvo.write_date}</td>

					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="4">
				<a href="./view/training/fine_training_Write.jsp">
				<input type="button" id="btnWrite" value="글쓰기"></a> 

			</tr>
			
			<tr>
			</tr>
		</table>
		<%
		int count = (int)request.getAttribute("count");
		int currentPage = (int)request.getAttribute("currentPage");
		int endPage = (int)request.getAttribute("endPage");
		int startPage = (int)request.getAttribute("startPage");
		int pagecount = (int)request.getAttribute("pagecount");
			if (count > 0) {
			
				if (currentPage > 1 || endPage < pagecount) {
				if (currentPage == 1) {
					%>
					[<a style="display=none" href="./trmListManager.do?pageNum=<%=currentPage - 1%>">이전</a>]
					<%
				} else {
				%>
				[<a href="./trmListManager.do?pageNum=<%=currentPage - 1%>">이전</a>]
				<%
			}

		}
				for(int i = startPage; i<=endPage; i++){

		%>

		<a href="<%=ctxpath%>/trmListManager.do?pageNum=<%=i%>"><%=i%></a>
		


		<!-- //여기 나타내는거 -->
		<!-- 다음 -->
		<%
		if(i == pagecount) 
			break;
		}
		if (currentPage >= 1 && currentPage < pagecount) {

		if (currentPage == pagecount) {

		} else {
		%>
		[<a href="<%=ctxpath%>/trmListManager.do?pageNum=<%=currentPage + 1%>">다음</a>]
		<%
			}

		}

		}

		%>
	</form>
</body>
</html>

<%@page import="java.text.SimpleDateFormat"%>
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
<title>Insert title here</title>
<!-- icon(fontawesome) -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- link css -->
<link rel="stylesheet" href="<%=ctxPath %>/css/head_foot.css" />
<!-- font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet" />
	
<!-- CSS -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
	
<style>


/* SECTION */
.h_title {
	margin-bottom: 6vh;
	font-family: 'Jua', sans-serif;
}

#quizSearchFrm {
	text-align: center;
	margin: 10vh 0;
}

#quizSearchTable {
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:50%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    text-align: center;
    border: 2px solid #A4A4A4;
}
#quizSearchTable td, #quizSearchTable th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
}

#tdQuiz_no,#tdQuiz_content,#tdAnswer {
	background-color: #F2F2F2;
	font-weight: bold;
}

#btnListUpDel {
	padding:10px;
}

#btnWrite, #btnQuiz_search {
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
  font-family: 'Jua', sans-serif;
}
#btnWrite:hover {
	background-color: #848484;
	color:white;
}

#btnTrn_search:hover {
	background-color: #848484;
	color:white;
}

</style>
   <script type="text/javascript">
	function goSearch() {
		var frm = document.quizSearchFrm;
		frm.action = "<%=ctxPath%>/quiz_Search.do";
		frm.method = "post";
		frm.submit();
	}
	</script> 
</head>
<body>
<!-- header -->
<jsp:include page="/common/header.jsp" />
	<!--Section -->
	<form name=quizSearchFrm id="quizSearchFrm">
		<h2 class="h_title">관리자게시판</h2>
			<c:if test="${not empty list}">
				<c:forEach items="${ list }" var="mvo" varStatus="s">
 					<div id = "quizSearchTbl">
						<table id ="quizSearchTable">
							<tr>
								<td id="tdQuiz_no">글번호</td>
								<td><a href="<%=ctxPath%>/quizDetail.do?no=${mvo.quiz_no}">${mvo.quiz_no}</a></td>
							</tr>
							<tr>
								<td id="tdQuiz_content">퀴즈내용</td>
								<td>${mvo.quiz_content}</td>
							</tr>
							<tr>
								<td id="tdAnswer">답</td>	
								<td>${mvo.answer}</td>
							</tr>	
						</table>
					</div>
			</c:forEach>
					<div id="btnWriteSearch">
						<input type="text" name="kwd" id="quizSearch">
						<button type="button" id="btnQuiz_search" onclick="goSearch()">검색</button>
						<a href="./view//quiz/fine_quiz_Write.jsp">
						<input type="button" id="btnWrite" value="글쓰기"></a>
					</div>
		</c:if>
		
		<%
		String kwd = request.getParameter("kwd");
		int count = (int)request.getAttribute("count");
		int currentPage = (int)request.getAttribute("currentPage");
		int endPage = (int)request.getAttribute("endPage");
		int startPage = (int)request.getAttribute("startPage");
		int pagecount = (int)request.getAttribute("pagecount");
			if (count > 0) {
			
				if (currentPage > 1 || endPage < pagecount) {
				if (currentPage == 1) {
					%>
		[<a style=""
			href="./quiz_Search.do?pageNum=<%=currentPage - 1%>&kwd=<%=kwd%>">이전</a>]
		<%
				} else {
				%>
		[<a href="./quiz_Search.do?pageNum=<%=currentPage - 1%>&kwd=<%=kwd%>">이전</a>]
		<%
			}

		}
		for (int i = startPage; i <= endPage; i++) {

		%>

		<a href="<%=ctxPath%>/quiz_Search.do?pageNum=<%=i%>&kwd=<%=kwd%>"><%=i%></a>


		<!-- //여기 나타내는거 -->
		<!-- 다음 -->
		<%
			if (i == pagecount)
			break;
		}
		if (currentPage >= 1 && currentPage < pagecount) {

		if (currentPage == pagecount) {

		} else {
		%>
		[<a
			href="<%=ctxPath%>/quiz_Search.do?pageNum=<%=currentPage + 1%>&kwd=<%=kwd%>">다음</a>]
		<%
			}

		}

		}

		%>

	</form>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>

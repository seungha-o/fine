
<%@page import="fine.community.training.model.TrainingDAO"%>
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


#trainingSearchFrm {
	text-align: center;
	margin: 10vh 0;
}


#trainingMgrTable {
  	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:60%;
	position: relative;
    left: 50%; 
    transform: translate(-50%);
}

#trainingMgrTable td, #trainingMgrTable th {
	border-bottom: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}
 
a {
	text-decoration: none;		
}


#trainingMgrTable tr:hover {
	background-color: #ddd;
}

#trainingMgrTable th {
	border-top: 2px solid #A4A4A4;
	border-bottom: 2px solid #A4A4A4;
	padding-top:12px;
	padding-bottom:12px;
	text-align: center;
	background-color: #F2F2F2;
	color:#black;
	text-decoration: none;
	
}
#searchWrite {
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
  font-family: 'Jua', sans-serif;
}


#btnSearch:hover {
	background-color:#848484;
	color:white;
} 

#btnWrite:hover {
	background-color:#848484;
	color:white;
}

</style>
   <script type="text/javascript">
	function goSearch() {
		var frm = document.trainingSearchFrm;
		frm.action = "<%=ctxPath%>/training_Search.do";
		frm.method = "post";
		frm.submit();
	}
	</script> 

</head>
<body>
		<!-- header -->
<jsp:include page="/common/header.jsp" />
	<!-- section -->
	<form name=trainingSearchFrm id="trainingSearchFrm">
		<h1 class="h_title">관리자게시판</h1>
	<div id="trainingMgrTbl" >	
		<table id="trainingMgrTable">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:if test="${not empty list}">
				<c:forEach items="${ list }" var="mvo" varStatus="s">
					<tr>
						<td><a href="<%=ctxPath%>/trainingDetail.do?no=${mvo.trn_no}">${mvo.trn_no}</a></td>
						<td>${mvo.trn_title}</td>
						<td>${mvo.write_date}</td>

					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
	<div id = "searchWrite">
		<input type="text" name="kwd" id="trainingSearch">
		<button type="button" id="btnSearch" onclick="goSearch()">검색</button>
		<a href="./view/training/fine_training_Write.jsp"><input type="button"
		 id="btnWrite" value="글쓰기"></a> 
	</div>
			
		
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

		<a href="<%=ctxPath%>/trmListManager.do?pageNum=<%=i%>"><%=i%></a>
		


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
		[<a href="<%=ctxPath%>/trmListManager.do?pageNum=<%=currentPage + 1%>">다음</a>]
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

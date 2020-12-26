<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=99b1d8e23b122c900c17996f24c1ec0e&libraries=services"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<%=ctxPath %>/js/datepicker-ko.js"></script>

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

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
section {
  width: 70%;
	margin: 10vh auto;
		
}

table {
	border-collapse: collapse;
	margin-top: 80px;
	width: 100%;
}

table tr, th, td {
	
	text-align: center;
	padding: 5px;
}
th{
border-bottom: 1px solid; 
}
</style>
</head>
<body>
<jsp:include page="/common/header.jsp" />
	<section>
	<h1 style ="display: inline;">등록</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th>유기견사진</th>
				<th>보호소</th>
				<th>보호소주소</th>
				<th>발견장소</th>
				<th>발견날짜</th>
				<th>공고마감일</th>
				<th>성별</th>
				<th>중성화여부</th>
			</tr>
		</thead>
		
		<tbody>
		<c:if test="${not empty list }">
	<c:forEach items="${list }" var="mvo" varStatus="s">
		<tr>
		<td><img src="${mvo.filename }" style="width: 50px; height: 50px"></td>
		<td class = "careName">${mvo.careNm }</td>
		<td>${mvo.careAddr }</td>
		<td>${mvo.happenPlace }</td>
		<td>${mvo.happenDt }</td>
		<td>${mvo.noticeEdt }</td>
		<td>${mvo.sexCd }</td>
		<td>${mvo.neuterYn }</td>
		<td><button style="width: 100px; height: 30px" type="button" id="BtnDetail" onclick="window.location='<%=ctxPath%>/find_manage_delete.do?no=${mvo.desertionNo}'">삭제</button></td>
		</tr>
	
	</c:forEach>
	</c:if>
	<c:if test="${empty list }">
	<h1>찾는 결과가 없습니다.</h1>
	</c:if>
		</tbody>
	</table>
	<hr>
		<div id = "jhb-write" style="width: 97.6%; text-align: right; margin-top: 30px;">
		<button type="button" id="BtnWrite" onclick="window.location='<%=ctxPath %>/view/find/fine_find_manage_insert.jsp'" style="width: 150px; height: 50px;">글쓰기</button>
		</div>
		<br>
		<div style="width: 100%; text-align: center;">
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
					[<a style="display=none" href="./fine_find_manage_List.do?pageNum=<%=currentPage - 1%>">이전</a>]
					<%
				} else {
				%>
				[<a href="./fine_find_manage_List.do?pageNum=<%=currentPage - 1%>">이전</a>]
				<%
			}

		}
				for(int i = startPage; i<=endPage; i++){

		%>

		<a href="<%=ctxPath%>/fine_find_manage_List.do?pageNum=<%=i%>"><%=i%></a>
		


		<!-- //여기 나타내는거 -->
		<!-- 다음 -->
		<%
		if(i == pagecount) 
			break;
		}
		if (currentPage >= 1 && currentPage < pagecount) {

		if (currentPage == pagecount) {
	%>
		[<a style="display=none" href="<%=ctxPath%>/fine_find_manage_List.do?pageNum=<%=currentPage + 1%>">다음</a>]
	<%
		} else {
		%>
		[<a href="<%=ctxPath%>/fine_find_manage_List.do?pageNum=<%=currentPage + 1%>">다음</a>]
		<%
			}

		}

		}

		%>
		</div>
</section>
<jsp:include page="/common/footer.jsp" />	
</body>

</html>
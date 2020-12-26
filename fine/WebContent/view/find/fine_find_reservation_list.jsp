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
<h1 style="display: inline;">예약관리</h1>
<hr>

<table>
		<thead>
			<tr>
				<th>예약자</th>
				<th>예약일자</th>
				<th>유기견 코드</th>
			</tr>
		</thead>
		
		<tbody>
<c:if test="${not empty list }">
<c:forEach items="${list }" var="mvo" step="1" varStatus="s">
		<tr>
		<td>${mvo.id }</td>
		<td>${mvo.reservationDate }</td>
		<td>${mvo.desertionNo }</td>
		
		</tr>
</c:forEach>
</c:if>



		</tbody>
	</table>
	<c:if test="${ empty list }">
	<div style="width: 100%; text-align: center; margin-top: 50px">
<h1>예약정보가 없습니다.</h1>
</div>
</c:if>
		<div id="goMain" style="width: 100%; text-align: center; margin-top: 30px; margin-bottom: 30px;">
		<button type="button" id="BtnDetail" style="width: 150px; height: 50px;" onclick="window.location='<%=ctxPath%>/findHowMany.do'">메인으로</button>
		</div>
		</section>
<jsp:include page="/common/footer.jsp" />
</body>
</html>
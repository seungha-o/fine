<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctxpath = request.getContextPath();
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
</style>
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/common/header.jsp" />
<section>
	<div style="width: 100%; text-align: center;">
	
		<h2>입양을 결정해 주셔서 감사합니다.</h2>
	
	<div style="width: 100%; text-align: right; text-decoration: underline;">
		<a href="<%=ctxpath%>/documentDown.do?file=fine입양양식.hwp" >fine입양양식.hwp</a>
	</div>
		<p>방문시에 입양서 작성해서 지참하시길 바랍니다.</p>
	<br>
	<br>
	
	<div>
	
		<img src="<%=ctxpath%>/upload/images/happydog.png" alt="사진이 없습니다">
	</div>
<br>
<br>
	<div>
		<h4>행복한 가정되세요~!</h4>
	</div>
	<br>
	<br>
	<div>
	</div>
		<button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/fine_find_manage_List.do'" style="width: 150px; height: 50px;">예약현황 보러가기</button>
		<button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/findHowMany.do'" style="width: 150px; height: 50px;">메인으로</button>
		
	</div>
	</section>
	<jsp:include page="/common/footer.jsp" />	
</body>
</html>
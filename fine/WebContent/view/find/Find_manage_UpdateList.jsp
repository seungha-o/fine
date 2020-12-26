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
  width: 80%;
	margin: 10vh auto;
	background-image: url(./upload/images/runDog.png);
	
}


</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<section>

<div style="width: 100%; text-align: center;">
<h1 style="color: red">warning!!! 하루에 한번만 누르세요!!</h1>
<button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/find_manage_update.do'" style="width: 500px; height: 300px; font-size: xx-large;">오늘 구조된 유기견 불러오기</button>
</div>
            
</section>
<jsp:include page="/common/footer.jsp" />	
</body>
</html>
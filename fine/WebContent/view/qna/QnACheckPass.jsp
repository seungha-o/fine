<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctxpath = request.getContextPath();
	int strQna_no = Integer.parseInt(request.getParameter("qna_no"));
	request.setAttribute("qnaNO", strQna_no);
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
<link rel="stylesheet" href="<%=ctxpath %>/css/head_foot.css" />
<!-- font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet" />
<!-- CSS -->
<style>
section {
	height: 100%;
}
h1 {
	font-family: 'Jua', sans-serif;
	margin: 10vh 0;
	font-size: 2vmax;
	text-decoration: underline;
	text-align: center;
}
#pwdForm {
	font-family: 'Jua', sans-serif;
	display: flex;
	flex-flow: column wrap;
	align-items: center;
}
.input {
	font-family: 'Jua', sans-serif;
	border: 1px solid black;
	border-radius: 4px;
	padding: 10px;
	font-size: 1vmax;
}
#pwd {
	margin-right: 1vw;
	padding: 6px;
	border-radius: 4px;
	color: black;
	transition: .3s ease-in;
}
#pwd:hover {
	background-color: black; 
	color: white;
}
.btn {
	font-family: 'Jua', sans-serif;
	background-color: #E6E6E6;
	border: none;
	color: black;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 1vmax;
	margin: 1px 1px;
	cursor: pointer;
	border-radius: 4px;
	transition: .3s ease-in;
}
.btn:hover {
	background-color: black;
	color: white;
}
#input_pass {
	margin: 1vh auto 6vh auto;
	display: flex;
}
#bottom {
	margin: 1vh auto 10vh auto;
	display: flex;
}
#cancel {
	margin-right: 1vw;
}
</style>
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/common/header.jsp" />
	<!-- SECTION -->
	<section>
		<h1>비밀글 입니다</h1>
		<form name="pwdChk" action="<%=ctxpath%>/qnaConfirm.do?qna_no=${qnaNO}" id="pwdForm" method="post">
			<div id="input_pass">
				<input type="password" id="pwd" class="input" maxlength="4" name="pwChk" placeholder="비밀번호 입력해줘~">
				<input type="submit" class="btn" value="비밀글 확인">
			</div>
			<div id="bottom">
				<input type="reset" value="취소" id="cancel" class="btn" >
				<a href="<%=ctxpath%>/qnaList.do" class="btn">목록보기</a>
			</div>
		</form>
	</section>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
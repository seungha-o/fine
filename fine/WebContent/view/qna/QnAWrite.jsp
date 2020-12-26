<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
	String id = (String) request.getSession().getAttribute("sessionID");
	String level = (String) request.getSession().getAttribute("memberLev");
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
<link rel="stylesheet" href="<%=ctxPath %>/css/head_foot.css" />
<!-- font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet" />
<!-- FORM -->
<script type="text/javascript">
	function doWrite() {
		let form = document.write;
		form.action = "<%=ctxPath%>/qnaWrite.do";
		form.method = "post";
		form.submit();
	}
</script>
<style type="text/css">
img{
	object-fit: cover;
}
h2 {
	font-family: 'Jua', sans-serif;
	margin: 10vh;
	font-size: 1.5vmax;
	text-decoration: underline;
}
#writeForm {
	font-family: 'Jua', sans-serif;
	text-align: center;
	margin-bottom: 6vh;
}
#writeTable {
	font-family: 'Jua', sans-serif;
	border-collapse: collapse;
	width: 50%;
	position: relative;
	left: 50%;
	transform: translate(-50%);
	text-align: center;
	border: 2px solid #A4A4A4;
	margin-bottom: 6vh;
	border: 1px solid black;
}
#content {
	width: 30vw;
}
#writeTable td, #writeTable th {
	padding: 30px;
	text-align: left;
	font-size: 1vmax;
	width: 3vw;
	border: 1px solid #ddd;
}
.td1 {
	background-color: #F2F2F2;
	font-weight: bold;
}
.input {
	font-family: 'Jua', sans-serif;
	border: 1px solid black;
	border-radius: 4px;
	padding: 10px;
	font-size: 1vmax;
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
	background-color: #848484;
	color: white;
}
#btn:hover {
	background-color: black;
	color: white;
}
</style>
<title>QnA Write</title>
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/common/header.jsp" />
	<!-- SECTION -->
	<form name="write" id="writeForm" encType="multipart/form-data">
	<h2>QnA 작성하기</h2>
		<input type="hidden" name="id" value="<%=id%>"> <input
			type="hidden" name="level" value="<%=level%>">
		<table id="writeTable">
			<tr>
				<td class="td1">아이디</td>
				<!-- Update -->
				<td><%=id%></td>
			</tr>
			<tr>
				<td class="td1">제목</td>
				<td><input type="text" class="input" name="title" placeholder="제목"></td>
			</tr>
			<tr>
				<td class="td1">내용</td>
				<td><textarea name="content" rows="10" id="content" class="input"></textarea></td>
			</tr>
			<tr>
				<td class="td1">비밀번호</td>
				
				<td ><input type="checkbox" value="1" name="passchk">
				<input type="password" name="pass" placeholder="숫자 4자리를 입력하세요" maxlength="4" class="input"></td>
			</tr>
			<tr>
				<td class="td1">파일 첨부</td>
				<td><input type="file" class="btn" name="qna_img" rows="10" multiple></td>
			</tr>
			<tr>
				<td class="td1">파일 첨부</td>
				<td><input type="file" class="btn" name="qna_img2" rows="10" multiple></td>
			</tr>
		</table>
		<input type="button" value="등록" id="btn" class="btn" onclick="doWrite()">
		<a href="<%=ctxPath %>/qnaList.do" id="btn" class="btn">목록보기</a>
	</form>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
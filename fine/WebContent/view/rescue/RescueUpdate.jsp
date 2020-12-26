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
	function doUpdate() {
		let form = document.doUpdate;
		form.action = "../rescueUpdate";
		form.method = "post";
		form.submit();
	}
</script>
<title>Insert title here</title>
<style type="text/css">
img{
	object-fit: cover;
}
h2 {
	font-family: 'Jua', sans-serif;
	margin: 6vh 0;
	font-size: 1.5vmax;
	text-decoration: underline;
	text-align: center;
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
#bottom {
	display: flex;
	justify-content: center;
	margin: 6vh auto;
}
#bottom a {
	margin: 0 .5vw;
}

.td1 {
	background-color: #F2F2F2;
	font-weight: bold;
	width: 1vw;
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
	background-color: black;
	color: white;
}
</style>
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/common/header.jsp" />
	<!-- SECTION -->
	<form name="doUpdate" action="rescueUpdate" encType="multipart/form-data" method="post">
		<h2>Rescue 수정</h2>
		<table id="writeTable">
			<c:if test="${not empty updateList }" var="list">
				<input type="hidden" name=rec_no value="${updateList.rec_no}">
				<tr>
					<td  class="td1">번호</td>
					<td>${updateList.rec_no}</td>
				</tr>
				<tr>
					<td class="td1">제목</td>
					<td><input type="text" name="title" class="input" value="${updateList.rec_title}"></td>
				</tr>
				<tr>
					<td class="td1">작성자</td>
					<td>${updateList.id }</td>
				</tr>
				<tr>
					<td class="td1">작성일</td>
					<td>${updateList.rec_write_date }</td>
				</tr>
				<tr>
					<td class="td1">조회수</td>
					<td>${updateList.rec_count }</td>
				</tr>
				<tr>
					<td class="td1">내용</td>
					<td>
						<textarea name="content" rows="10" id="content" class="input">
							${updateList.rec_contents }
						</textarea>
					</td>
				</tr>
				<tr>
					<td class="td1">이미지</td>
					<td>
						<c:forEach items="${updateList.rec_img}" var="img">
							<c:if test="${not empty img}">
								<img src="<%=ctxPath%>/files/${img}" width="300" height="150">
							</c:if>
						</c:forEach>
					</td>
				</tr>

			</c:if>
		</table>
		<div id="bottom">
			<input type="submit" value="수정" class="btn">
			<a href="rescueList.do" class="btn">목록보기</a>
		</div>
	</form>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
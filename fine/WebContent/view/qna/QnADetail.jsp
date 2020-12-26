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
<script>
	function goInsertComment() {
		var frm = document.commentFrm;
		frm.action = "<%=ctxPath%>/qnaReply.do";
		frm.method = "get";
		frm.submit();
	}
</script>
<title>QnA 상세페이지</title>
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
#commentFrm {
	font-family: 'Jua', sans-serif;
	display: flex;
	flex-flow: column wrap;
	align-items: center;
}

#writeTable td, #writeTable th {
	padding: 30px;
	text-align: center;
	font-size: 1.3vmax;
	width: 3vw;
	border: 1px solid #ddd;
}
#comment {
	font-size: 1.5vmax;
	margin: 2vh 0 1vh 0;
}
#write_comment {
	padding: 10px;
	border-radius: 4px;
	color: black;
	transition: .3s ease-in;
	margin-bottom: 5vh;
}
#write_comment:hover {
	background-color: black; 
	color: white;
}
.comments {
	display: flex;
	text-align: left;
	font-size: 1vmax;
	margin: 1vh 0;
}
#BtnDetail {
	font-family: 'Jua', sans-serif;
	margin-left: .5vmax;
	padding: 2px;
	background-color: black;
	border-radius: 4px;
	color: white;
	cursor: pointer;
	transition: .3s ease-in;
}
#BtnDetail:hover {
	border: 1px solid black;
	background-color: white;
	color: black;	
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
	<section>
	<h2>QnA 상세보기</h2>
		<c:if test="${not empty detailList }">
			<table id="writeTable">
				<tr>
					<td  class="td1"><input type="hidden" name=qna_no
						value="${detailList.qna_no}"> 번호</td>
					<td>${detailList.qna_no}</td>
				</tr>
				<tr>
					<td class="td1">제목</td>
					<td>${detailList.qna_title}</td>
				</tr>
				<tr>
					<td class="td1">작성자</td>
					<td>${detailList.id }</td>
				</tr>
				<tr>
					<td class="td1">작성일</td>
					<td>${detailList.qna_write_date }</td>
				</tr>
				<tr>
					<td class="td1">조회수</td>
					<td>${detailList.qna_count }</td>
				</tr>
				<tr>
					<td class="td1">내용</td>
					<td>${detailList.qna_contents }</td>
				</tr>
				<tr>
					<td class="td1">이미지</td>
					<td><c:forEach items="${detailList.qna_img}" var="img">
							<c:if test="${not empty img}">
								<img src="<%=ctxPath%>/files/${img}" width="300" height="150">
							</c:if>
						</c:forEach></td>
				</tr>
				<tr>
					<td class="td1">비밀글</td>
					<td>${detailList.qna_statement }</td>
				</tr>
			</table>
			<form name="commentFrm" id="commentFrm">
				<c:if test="${empty list }">
					<p id="comment">댓글을 입력해 주세요</p>
				</c:if>
				<div>
				<input type="text" name="comments" id="write_comment" placeholder="댓글 달래?">
				<button type="submit" class="btn" onclick="goInsertComment()">댓글달기</button>
				</div>
				<input type="hidden" name="qna_no" value="${detailList.qna_no}"
					required="required"> <input type="hidden"
					name="ref_sub_step" value="${detailList.ref_step}"
					required="required"> <input type="hidden"
					name="ref_sub_level" value="${detailList.ref_level}"
					required="required">
				<c:if test="${not empty list }">
					<c:forEach items="${list }" var="mvo" step="1">
						<div class="comments">
							<p>${mvo.id }</p>
							<p> : ${mvo.qna_contents }</p>
							<c:if test="${id eq member_id }">
								<button type="button" id="BtnDetail" onclick="window.location='<%=ctxPath%>/qnaDelete.do?qna_no=${mvo.qna_no}'">삭제</button>
							</c:if> <br>
						</div>						
						<input type="hidden" name=ref_step
						value="${mvo.ref_step }"> <input type="hidden"
						name=ref_level value="${mvo.ref_level }">
					</c:forEach>
				</c:if>
			</form>
		</c:if>
		<div id="bottom">
			<a href="qnaList.do" class="btn">목록보기</a>
			<c:if test="${id eq member_id }">
				<a href="qnaDetailToUpdate.do?qna_no=${detailList.qna_no}" class="btn">수정</a>
				<a href="qnaDelete.do?qna_no=${detailList.qna_no}" class="btn">삭제</a>
			</c:if>
		</div>
	</section>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
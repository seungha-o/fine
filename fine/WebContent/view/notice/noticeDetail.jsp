<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href = "css/head_foot.css">
 <script
      src="https://kit.fontawesome.com/333b7ab4b4.js"
      crossorigin="anonymous"
    ></script>
    <!-- link jQuery -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="<%=ctxPath %>/js/datepicker-ko.js"></script>
    <!-- link css -->
    <!-- font -->
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
      rel="stylesheet"
    />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
      rel="stylesheet"
    />
<meta charset="UTF-8">
<script type="text/javascript">
	function goRegister() {
		let form = document.goRegister;
		form.action = "../noticeDetailtoUpdate.do";
		form.method = "post";
		form.submit();
	}
</script>

<style>
section {
	margin: 10px;
	font-family: 'Jua', sans-serif;
}

#goRegister {
	text-align: center;
}

#DetailTbl{
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:60%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    text-align: center;
    border: 2px solid #A4A4A4;
}
#DetailTbl td, #DetailTbl th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
	width : 15px;
}
.n_title {
	 text-align: center;
}
img{
object-fit: cover;}
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/common/header.jsp" %>
<section id="section">
<form name="goRegister">
		<table id = "DetailTbl" >
		<h1 class ="n_title">공지사항</h1>
			<c:if test="${not empty noticeVO}">
				<input type="hidden" name=notice_no value="${noticeVO.notice_no}">
				<tr>
					<td>번호</td>
					<td>${noticeVO.notice_no}</td>
						<td>작성자</td>
					<td>${noticeVO.id }</td>
					<td>조회수</td>
					<td>${noticeVO.notice_count}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan = "5">${noticeVO.notice_title}</td>
				
				</tr>
				<tr>
					<td>작성일</td>
					<td colspan = "5">${noticeVO.notice_write_date}</td>
					
				</tr>
	
						<td rowspan = "2">내용</td>
					<tr>
						<td colspan = "5">
							<c:forEach var="img" items = "${noticeVO.notice_img}"> 
								<c:if test="${not empty img}">
							<img src = "<%=ctxPath%>/files/${img}"><br>
								</c:if>
						</c:forEach>
							<p id = "contents">${noticeVO.notice_contents}</p>
						</td>
					</tr>

				<tr>
				<td colspan="6">
				<a href="noticeDetailtoUpdate.do?notice_no=${noticeVO.notice_no}"><input type="button" value="수정"></a>
					&nbsp;&nbsp;<a href="noticeList.do">목록보기</a>
					&nbsp;&nbsp;<a href="noticeDelete.do?notice_no=${noticeVO.notice_no}">삭제</a>
					</td>
			</tr>
			</c:if>
		</table>
	</form>
		</section>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href = "css/index.css">
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
table {
  border-collapse: collapse;
	text-align : center;
	margin : auto;
	width : 1200px;
}
table th, td {
  text-align: left;
  padding: 8px;
}
table tr:nth-child(even){background-color: #ECECAE}
table a {padding : 0; color : black;}
table a:hover {color: hsl(167, 49%, 35%)!important; }
form { 
margin: 0 auto; 
width:100%;
padding : 20px; 
}
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/common/header.jsp" %>
<section id="section">
<form name="goRegister">
		<table cellpadding="0" cellspacing="0" >
			<c:if test="${not empty noticeVO}">
				<input type="hidden" name=notice_no value="${noticeVO.notice_no}">
				<tr>
					<td>번호</td>
					<td>${noticeVO.notice_no}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${noticeVO.notice_title}</td>
					<td>작성자</td>
					<td>${noticeVO.id }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${noticeVO.notice_write_date}</td>
					<td>조회수</td>
					<td>${noticeVO.notice_count}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${noticeVO.notice_contents}</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td>
					<c:forEach var="img" items = "${noticeVO.notice_img}"> 
				<c:if test="${not empty img}">
						<img src = "<%=ctxPath%>/files/${img}" width = "300" height = "150">
				</c:if>
					</c:forEach>
					</td>
				</tr>
				<tr>
				<td colspan="2">
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
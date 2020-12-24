<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href = "css/index.css ">
<meta charset="UTF-8">
<script type="text/javascript">
	function goRegister() {
		let form = document.goRegister;
		form.action = "noticeUpdate.do";
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
<form action="noticeUpdate.do" method = "post" enctype="multipart/form-data" >
		
		<table cellpadding="0" cellspacing="0" >
			<c:if test="${not empty list}">
				<input type="hidden" name="notice_no" value="${list.notice_no}">
				<tr>
					<td>번호</td>
					<td>${list.notice_no}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type = "text" name ="notice_title" value = "${list.notice_title}"></td>
					<td>작성자</td>
					<td>${list.id }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${list.notice_write_date}</td>
					<td>조회수</td>
					<td>${list.notice_count}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type = "text" name = "notice_contents" value = "${list.notice_contents}"></td>
				</tr>
				<tr>  
					<td rowspan = "2">첨부파일</td>
					<td ><input type = "file" name="notice_img"  multiple ></td></tr>
					<tr>
					<td ><input type = "file" name="notice_img2"  multiple ></td>
					
				</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정">
				&nbsp;&nbsp;<a href="noticeList.do">목록보기</a>
				&nbsp;&nbsp;<a href="noticeDelete.do?qna_no=${list.notice_no}">삭제</a>
				</td>
			</tr>
			</c:if>
		</table>
	</form>
		</section>
		<%@ include file="/common/footer.jsp" %>
</body>
</html>
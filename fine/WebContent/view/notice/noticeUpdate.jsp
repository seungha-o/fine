<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
 <script
      src="https://kit.fontawesome.com/333b7ab4b4.js"
      crossorigin="anonymous"
    ></script>
    <!-- link jQuery -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="<%=ctxPath %>/js/datepicker-ko.js"></script>
    <!-- link css -->
<link rel="stylesheet" href = "css/head_foot.css ">
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
</head>
<style>
section {
	margin: 0;
	font-family: 'Jua', sans-serif;
}


#write {
	text-align: center;
}

#nWriteTbl{
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:50%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    text-align: center;
    border: 2px solid #A4A4A4;
}
#nWriteTbl td, #nWriteTbl th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
}

#tdCont,#tdAns {
	background-color: #F2F2F2;
	font-weight: bold;
	
}

#content {
 	width:100%;
	height:150px;
	border: 1px solid gray;
}

#btnRegister{
  background-color: #E6E6E6; 
  border: none;
  color: black;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 1px 1px;
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
}
#btnRegister:hover {
	background-color: #848484;
	color:white;
}
.n_title {
	 text-align: center;
}
</style>
<body>
<%@ include file="/common/header.jsp" %>
<section id="section">
<form name = "write" action="noticeUpdate.do" method = "post" enctype="multipart/form-data" >
		<table id = "nWriteTbl" >
			<h1 class ="n_title">공지사항 글쓰기</h1>
			<c:if test="${not empty list}">
				<input type="hidden" name="notice_no" value="${list.notice_no}">
				
				<tr>
					<th>작성자</th>
					<td>${list.id }</td>
					<th>작성일</th>
					<td>${list.notice_write_date}</td>
					<th>조회수</th>
					<td>${list.notice_count}</td>
					
				</tr>
				<tr>
				<th>제목</th>
					<td colspan = "5"><input type = "text" name ="notice_title" id = "content" value = "${list.notice_title}" style = "height : 25px"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan = "5" ><input type = "text" name = "notice_contents" id = "content" value = "${list.notice_contents}"></td>
				</tr>
							<tr>
					<th>이미지</th>
					<td colspan = "5">
					<c:forEach var="img" items = "${list.notice_img}"> 
				<c:if test="${not empty img}">
						<img src = "<%=ctxPath%>/files/${img}"> 
				</c:if>
					</c:forEach>
						
					</td>
				</tr>
				<tr>  
					<td rowspan = "2">첨부파일</td>
					<td colspan = "5"><input type = "file" name="notice_img"  multiple ></td></tr>
					<tr>
					<td colspan = "5"><input type = "file" name="notice_img2"  multiple ></td>
					
				</tr>
			<tr>
				<td colspan="6">
				<input type="submit" id = "btnRegister" value="수정">
				&nbsp;&nbsp;<a href="noticeList.do">목록보기</a>
				&nbsp;&nbsp;<a href="noticeDelete.do?qna_no=${list.notice_no}">삭제</a>
				</td>
			</tr>
			</c:if>
		</table>
		<br>
	</form>
		</section>
		<%@ include file="/common/footer.jsp" %>
</body>
</html>
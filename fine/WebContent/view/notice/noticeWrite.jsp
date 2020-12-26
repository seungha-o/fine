<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice write</title>
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
<link rel="stylesheet" href = "<%=ctxPath %>/css/head_foot.css">
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
</head>
<style>
section {
	margin: 10px;
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



#content {
 	width:100%;
	height:150px;
		border: 1px solid gray;
}



#btnRegister {
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
input {
width : 100% }
</style>
<script type="text/javascript">

function goRegister(){
	var count = $('#count').val();
	
	if($('#count').val() < 5 || document.getElementById("pin").checked == false){
		var frm = document.write;
		frm.action = "<%=ctxPath%>/noticeWrite.do";
		frm.method = "post";
		frm.submit();		 
	}
	else {
		alert("공지글은 다섯개만 등록할수 있습니다.");
	}
}
</script>

<body>
<%@ include file="/common/header.jsp" %>
<section class ="section">
	<table id = "nWriteTbl" >
		<h1 class ="n_title">공지사항 글쓰기</h1>
		<form name = "write" encType = "multipart/form-data">

			<tr>
				<th> 제목 </th>
				<td> <input type="text" name="notice_title"> </td>
			</tr>
			<tr>
				<th> 내용 </th>
				<td> <textarea placeholder="1000자이하 입력" id = "content" name="notice_contents" rows="10" ></textarea> </td>
			</tr>
			<tr>
				<th> 파일 첨부 </th>
				<td> <input type = "file" name="notice_img" rows="10" multiple></td>
			</tr>
			<tr>
				<th> 파일 첨부 </th>
				<td> <input type = "file" name="notice_img2" rows="10" multiple></td>
			</tr>
			<tr>
				<th colspan = "2">고정글<input type="checkbox" name="pin" id ="pin" value="1"></th>
			</tr>
				<th colspan="2"> 
				<button type="button" id="btnRegister" onclick="goRegister()">등록</button>&nbsp;&nbsp; 
				<a href="<%=ctxPath%>/noticeList.do">목록보기</a></th>
			</tr>
			<input type = "hidden" id = "count" name = "count" value  = "${cnt}">
		</form>
	</table>
	</section>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>
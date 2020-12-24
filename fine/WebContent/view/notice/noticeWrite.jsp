<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "<%=ctxPath %>/css/index.css">
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
</head>
<script type="text/javascript">

function goRegister(){
	var count = $('#count').val();
	if(count < 5){
		var frm = document.write;
		frm.action = "<%=ctxPath%>/noticeWrite.do";
		frm.method = "post";
		frm.submit();		 
	}
	if(document.getElementById("pin").checked == false){
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
<style>
table {
  border-collapse: collapse;
	text-align : center;
	margin : auto;
	width : 1200px;
		position : relative;
	top : 50px;
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
<body>
<%@ include file="/common/header.jsp" %>
<section id="section">
	<table width="500" cellpadding="0" cellspacing="0" border="1" >
		<form name = "write" encType = "multipart/form-data">

			<tr>
				<th> 제목 </th>
				<td> <input type="text" name="notice_title" size = "50"> </td>
			</tr>
			<tr>
				<th> 내용 </th>
				<td> <textarea name="notice_contents" rows="10" ></textarea> </td>
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
				<th>고정글<input type="checkbox" name="pin" id ="pin" value="1"></th>
			</tr>
				<th colspan="2"> 
				<button type="button" id="register" onclick="goRegister()">등록</button>&nbsp;&nbsp; 
				<a href="<%=ctxPath%>/noticeList.do">목록보기</a></th>
			</tr>
			<input type = "hidden" id = "count" name = "count" value  = "${cnt}">
		</form>
	</table>
	</section>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String ctxpath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function doWrite() {
		let form = document.write;
		form.action = "<%=ctxpath%>/rescueWrite.do";
		form.method = "post";
		form.submit();
	}
</script>
<title>rescue Write</title>
</head>
<body>
	<form name="write" encType="multipart/form-data">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="id" placeholder="아이디"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" placeholder="제목"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10"></textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="rec_img" rows="10" multiple></td>
			</tr>
			<tr>
				<td>파일 첨부</td>
				<td><input type="file" name="rec_img2" rows="10" multiple></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="등록" onclick="doWrite()">
				&nbsp;&nbsp; <a href="<%=ctxpath%>/rescueList.do">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
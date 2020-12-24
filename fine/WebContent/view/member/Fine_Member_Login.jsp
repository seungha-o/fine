<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
<script type="text/javascript">
function login() {
	var logi = document.loginform
	logi.action = "<%=ctxPath%>/login.do"
	logi.method = "POST";
	logi.submit();
}
</script>
</head>
<body>
<div>
	<form name="loginform">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
		</table>
		<input type="button" value="로그인" onclick="login()">
	</form>
</div>
<script type="text/javascript">

</script>
</body>
</html>
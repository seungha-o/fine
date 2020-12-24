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
$(function() {
	$("#clickid").on('click', function() {
		$.ajax({
			url : "../../findID.do",
			data : {eid : $("#eid").val(),eweb : $("#eweb").val()},
			success : function(result) {
				$("#findid").html(result);
			}
		});
	});
});

function findPW() {
	var fp = document.findPwForm
	fp.action = "../../findPW.do"
	fp.method = "POST";
	fp.submit();
}

</script>
</head>
<body>
	<div>
		<div>
			<form>
				<table>
					<tr>
						<td>이메일</td>
						<td><input type="text"  id="eid">@<input
							type="text"  id="eweb"></td>
					</tr>
					<tr>
						<td><span id="findid"></span></td>
					</tr>
				</table>
			</form>
			<button type="button" id="clickid">아이디찾기</button>
		</div>

		<div>
			<form name="findPwForm">
				<table>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="eid">@<input type="text"
							name="eweb"></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</form>
			<button type="button" onclick="findPW()">비밀번호 찾기</button>
		</div>
	</div>
</body>
</html>
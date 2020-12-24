<!DOCTYPE html>
<%@page import="fine.community.quiz.model.QuizVO"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
</body>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String ctxpath = request.getContextPath();
%>

<!-- <!DOCTYPE html> -->
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/333b7ab4b4.js"></script>
<script src="../js/jquery-3.5.1.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<script type="text/javascript">
function qanswer(aaa){
	if(aa==-1){
		//cnt에 value를 -1;
	} else  {
		//cnt value 1로 채우고 
}
	frm.action="<%=ctxpath%>/quiz_List_user.do";
	frm.method="post";
	frm.submit();
}
</script>
	<!-- /* 토글 버튼 이벤트 */ -->
<script src="./js/main.js" defer></script>


<style>
* {
	margin: 0;
}

body {
	max-width: 100%;
	height: 100%;
	margin: auto;
	/* font-family: 'Source Sans Pro'; */
}

/*  #header {
   background-color: rgb(175, 230, 209);
   width: 100%;
   height: 100%;
}  */
#section {
	background-color: #fff8e1;
	width: 100%;
	height: 900px;
}

html {
	background: #f5f7f8;
	font-family: 'Roboto', sans-serif;
	-webkit-font-smoothing: antialiased;
	padding: 0;
}

a {
	text-decoration: none;
	color: #fdfbfa;
}

.navbar {
	/* 아이콘 나란히 */
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: hsl(167, 49%, 35%);
	padding: 8px 12px;
}

.navbar_logo {
	font-size: 24px;
	color: white;
}

.navbar_logo i {
	color: #d49466;
}

.navbar_menu {
	border: 1px solid yellowgreen;
	display: flex;
	list-style: none;
	padding-left: 0;
	padding: 40px, 40px;
}

.navbar_menu li {
	padding: 8px 12px;
}

.navbar_menu li:hover {
	background-color: #d49466;
	border-radius: 4px;
}

.navbar_icons {
	list-style: none;
	color: white;
	display: flex;
	padding-left: 0;
}

.navbar_icons li {
	padding: 8px 12px;
}
.navbar_toggleBtn {
	display : none;
	position : absolute;
	right: 32px;
	font-size: 24px;
	color: #d49466;
}

@media screen and (max-width: 768px) {
	.navbar {
		flex-direction: column;
		align-items: flex-start;
		padding: 8px 24px;
	}
	.navbar_menu {
		display : none;
		flex-direction: column;
		align-items: center;
		width: 100%;
	}
	.navbar_menu li {
		width:100%;
		text-align:center;
	}
	.navbar_menu a {
		display: inline;
	}
	.navbar_icons {
		display : none;
		justify-content: center;
		width: 100%;
	}
	.navbar_toggleBtn {
		display : block;
	}
	
	.navbar_menu.active, 
	.navbar_icons.active{
		display : flex;
	}
}

h1 {
	font-size: 50px;
	margin: 0;
	color: #333;
}

article {
	flex: 1;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	padding: 15px;
}

article p {
	flex: 1;
}

@media screen and (min-width:500px) {
	.band {
		grid-template-columns: 1fr 1fr;
	}
	.item-1 {
		grid-column: 1/3;
	}
}

@media screen and (min-width:850px) {
	.band {
		grid-template-columns: repeat(4, 1fr);
	}
}

table {
    width: 100%;
    text-align: center;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    border-spacing: 100px;
}

.quizForm {
	padding-top: 120px;
	max-width: 1000px;
	max-height: 1500px;
	padding-bottom: 30px;
	border: 2px solid #ddd;
	margin: 0 auto;
	position: relative;
	z-index: 1;
}

.quizForm::after {
	width: 100%;
	height: 100%;
	content: "";
	background: url("./img/dog.jpg");
	position: absolute;
	top: 0;
	left: 0;
	z-index: -1;
	opacity: 0.5;
}

div {
	display: block;
}

ul {
	list-style: none;
}

#ans1, #ans2 {
	display: inline-block;
    width: 300px;
    height: 300px;
    line-height: 250px;
    margin: 0 10px;
    font-size: 300px;
    font-weight: bold;
    color: #fff;
    background: #177160;
    border-radius: 50%;
    text-align: center;
    cursor: pointer;
   
}

label {
	display: none;
}

.quiztitle {
	margin: 100px; 100 px;
	position: relative;
	bottom: 150px;
}

.title {
	font-size: 70px;
}

/* .a_01 {
	margin: 100px;
	100px;
} */

/* .a_01, .a_02 {
text-align: center;
height: 100px;
width : 100px;

} */
.a_03 {
	text-align: right;
	position: relative;
	left: -50px;
	bottom: 50px;
}

.quizlist #a_02 input[type="radio"]:checked+.sel_o {
	background-color: #1d62e1;
}

.quizlist #a_02 input[type="radio"]:checked+.sel_x {
	background-color: #ff4750;;
}

#a_02 input[type="radio"] {
	position: absolute;
	top: 0;
	left: 0;
	z-index: -999;
	height: 1px;
	opacity: 0;
}

.nextBtn {
	border: none;
	background-color: transparent;
	margin-top: 80px;
}

#footer {
	padding: 30px 0;
	background-color: burlywood;
	position: relative;
	bottom: 0;
	border-top: 1px solid #dbdbdb;
}

.footer {
	text-align: center;
	padding: 30px 50px;
}

.footer li {
	position: relative;
	display: inline;
	padding: 0 7px 0 10px;
	white-space: nowrap;
}

.footer li:before {
	content: '';
	width: 1px;
	height: 12px;
	background-color: #dbdbdb;
	position: absolute;
	left: 0;
	top: 2px;
}

.footer li:first-child:before {
	width: 0;
}

.footer address {
	padding-top: 15px;
}

#button {
	display: flex;
	justify-content: center;
	background-color: gray;
}

a {
	text-decoration: none;
	display: inline-block;
	padding: 8px 16px;
}

a:hover {
	background-color: #ddd;
	color: black;
}
</style>
</head>
<body>
	<header id="header">
		<nav class="navbar">
			<div class="navbar_logo">
				<i class="fas fa-paw"></i> <a href="">Fine</a>
			</div>
			<!-- 메뉴 -->
			<ul class="navbar_menu">
				<li><a href="#">찾기</a></li>
				<li><a href="#">등록</a></li>
				<li><a href="#">게시판</a></li>
				<li><a href="#">커뮤니티</a></li>
				<li><a href="#">마이페이지</a></li>
			</ul>
			<!--아이콘  -->
			<ul class="navbar_icons">
				<li><i class="fab fa-instagram"></i></li>
				<li><i class="fab fa-facebook-square"></i></li>
			</ul>
			
			<a href="#" class="navbar_toggleBtn">
				<i class="fas fa-bars"></i>
			</a>
		</nav>
	</header>

	<section id="section">
		<%
			if (session.getAttribute("quizlist") == null) {
			response.sendRedirect(ctxpath + "/quiz_List_user.do"); // 예외처리  
			} else {
			List<QuizVO> quizlist = (List<QuizVO>) session.getAttribute("quizlist");
			System.out.println("jsp로 가져옴");
			int count = (int) session.getAttribute("count");

			if (!(count >= 0 && count <= 9)) {
				response.sendRedirect(ctxpath + "/quiz_List_user.do"); // 예외처리  
			} else { // 정상 케이스 아래
				QuizVO vo = quizlist.get(count);
		%>
		<div>
			<%=count%><hr>
			<form>
				<table>
					<tbody id = "tb_01">
						<tr>
							<th>글내용</th>
						</tr>
					<tbody>
					<tbody id = "tb_02">
						<tr>
							<td><%=vo.getQuiz_content()%></td>
						</tr>
					</tbody>
					<tbody id="a_02">
						<tr>
							<td><label for="answer1" id="ans1"> O </label> <input type="radio" name="q_answer" id="answer1" value="0" checked="checked">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								<label for="answer2" id="ans2"> X </label> <input type="radio" name="q_answer" id="answer2" value="1"></td>
						</tr>
					</tbody>
					<tbody>
						<tr>
							<td><input type="hidden" name="cnt" id="cnt">
								<button name="prev" id="prevBtn" onclick="goSubmit(-1);">이전</button>
								<button name="next" id="nextBtn" onclick="goSubmit(1);">다음</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<!-- <div class=a_02>
			<input type="radio" name="radioOX" id="radioO" value="1"><label for="radioO" class="selO">O</label>
			<input type="radio" name="radioOX" id="radioX" value="0"><label for="radioX" class="selX">X</label>
		</div> -->

		<%
			}
		}
		%>

<script>
	function goSubmit(pos){
		if(pos==-1){
			console.log("aa"+pos);
			$("#cnt").val("-1");
		} else  {
			console.log("bb"+pos);
			$("#cnt").val("1");
			
		}
		frm.action="<%=ctxpath%>/quiz_List_user.do";
		frm.method = "post";
		frm.submit();
	}
</script>
	</section>
	<footer id="footer">

		<div class="footer">
			<ul>
				<li><a href="#">사이트 도움말</a></li>
				<li><a href="#">사이트 이용약관</a></li>
				<li><a href="#">사이트 운영원칙</a></li>
				<li><a href="#"><strong>개인정보취급방침</strong></a></li>
				<li><a href="#">책임의 한계와 법적고지</a></li>
				<li><a href="#">게시중단요청서비스</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
			<address>
				Copyright &copy; <a href="#"><strong>Fine</strong></a> All Rights
				Reserved.
			</address>
		</div>

	</footer>

</body>
</html>
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

<!-- icon(fontawesome) -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
   crossorigin="anonymous"></script>
<!-- link jQuery -->
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
<!-- link css -->
<link rel="stylesheet" href="/FINE/css/head_foot.css" />
<!-- font -->
<link
   href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
   rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
   rel="stylesheet" />
<style type="text/css">
* {
  margin: 0;
  padding: 0;
}
body {
  font-family: "Open Sans", sans-serif;
}
a {
  text-decoration: none;
}
li {
  list-style: none;
}

/* HEADER */
header {
  font-family: "Jua", sans-serif;
}
#header_top {
  height: 6vh;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.page_logo {
  font-size: 1.8vmax;
  color: rgb(107, 107, 107);
  margin: 0 5vw;
}
.page_logo span {
  font-size: 1.8vmax;
  color: rgb(107, 107, 107);
}
.login_form {
  margin-right: 5vw;
  font-size: 1.3vmax;
}
.login_form a {
  color: rgb(107, 107, 107);
  transition: 0.3s ease-in;
}

.login_form a:hover {
  text-shadow: 0px -1px 0px rgb(163, 163, 163), 0 0 5px rgba(175, 175, 175, 0.8),
    0 -4px 15px rgba(191, 191, 191, 0.5);
}
.login_form a:visited {
  color: rgb(107, 107, 107);
}

.nav {
  background-color: #272727;
  padding: 8px 12px;
}
.nav,
.nav_menu {
  padding: 0;
  display: flex;
  justify-content: center;
  font-size: 1.5vmax;
}
.nav_menu a:visited {
  color: #f7e3d3;
}
.nav_menu li {
  margin: 8px 12px 8px 12px;
  padding: 0 12px;
  transition: 0.2s ease-in;
}
.nav_menu li:hover {
  text-shadow: 0px -2px 0px rgb(5, 5, 5), 0 0 5px rgba(255, 255, 255, 0.8),
    0 -4px 15px rgba(255, 255, 255, 0.5);
}

.underline {
  color: #f7e3d3;
  text-decoration: none;
  display: inline-block;
  padding: 15px 0;
  position: relative;
}
.underline:after {
  background: none repeat scroll 0 0 transparent;
  content: "";
  display: block;
  height: 2px;
  left: 50%;
  position: absolute;
  background: #f7e3d3;
  transition: width 0.3s ease 0s, left 0.3s ease 0s;
  width: 0;
}
.underline:hover:after {
  width: 100%;
  left: 0;
}
.drop_menu {
  width: 50%;
  margin: 0 auto;
  padding: 50px 70px 30px 70px;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  background-color: #dcdbdb;
  opacity: 0.7;
  font-size: 35px;
  display: none;
}
.indrop {
  display: flex;
  justify-content: space-around;
  font-size: 1.3vw;
}
.indrop a {
  color: #181818;
}
.indrop li {
  margin-bottom: 1vh;
  text-decoration: underline;
}

/* FOOTER */
footer {
  width: 100%;
  background-color: #dcdbdb;
  height: 470px;
}
#footer_top {
  display: flex;
  justify-content: center;
  font-size: 24px;
  font-weight: bold;
  padding: 3vh;
  margin-bottom: 3vh;
}
.f_t_2 {
  margin: 0 10vw;
}
.f_t_1,
.f_t_2,
.f_t_3 {
  padding: 3vh;
  border-radius: 7px;
  background-color: #9b9999;
}
#footer_middle {
  width: 50vw;
  margin: 0 auto;
  padding: 3vh 0;
  text-align: center;
  font-size: 17px;
  opacity: 0.9;
}
#footer_bottom {
  width: 50vw;
  margin: 0 auto;
  text-align: center;
  opacity: 0.7;
}


#login_form {
   position:relative;
   width: 30%;
   left:50%;
   transform:translateX(-50%);
}

input[type=text], select {
   height: 100%;
   padding: 10px 15px;
   margin: 5px 0;
   display: inline-block;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
   position: relative;
   left: 50%;
   transform: translate(-50%);
   width: 100%;
}

button[type=button] {
   width: 100%;
   background-color:  #22ad78;
   color: white;
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}

button[type=button]:hover {
   background-color: #45a049;
}

#sectionF{
	height : 50vh;
	background-image: url("https://images.mypetlife.co.kr/content/uploads/2019/09/04222847/dog-panting-1024x683.jpg");
	background-repeat: no-repeat;
	background-size: cover ;
	background-position: center;
	padding-top: 15vh;
	padding-bottom: 15vh;
}
section{
	border-radius: 16px;
	padding : 5%;
	margin-left : auto;
	margin-right : auto;
	width: 30vw;
	height : 20vh;
	background: rgba(255,255,255,0.6);
	box-shadow: 2px 2px 2px;
}

</style>
<script type="text/javascript">
$(function() {
	$("#clickid").on('click', function() {
		$.ajax({
			url : "../../findID.do",
			data : {email : $("#email").val()},
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
<!-- header -->
<header id="header">
	<div id="header_top">
		<div class="page_logo">
			<i class="fas fa-paw"></i> <a href=""> <span id="fine">Fine</span>
			</a>
		</div>
		<div class="login_form">
			<a href="#"><span id="login"> 로그인 | </span></a> <a href="#"><span
				id="register"> 회원가입</span></a>
		</div>
	</div>
	<nav class="nav">
		<ul class="nav_menu">
			<li class="nav_li"><a href="#"><span class="underline">찾기</span></a>
			</li>
			<li class="nav_li"><a href="#"><span class="underline">등록</span></a>
			</li>
			<li class="nav_li"><a href="#"><span class="underline">게시판</span></a>
			</li>
			<li class="nav_li"><a href="#"><span class="underline">커뮤니티</span></a>
			</li>
			<li class="nav_li"><a href="#"><span class="underline">마이페이지</span></a>
			</li>
		</ul>
	</nav>
	<div class="drop_menu">
		<div class="indrop">
			<ul id="find">
				<li><a href="">유기견 찾기</a></li>
				<li><a href="">입양하기</a></li>
			</ul>
			<ul id="care">
				<li><a href="">입양관리</a></li>
				<li><a href="">유기견등록</a></li>
			</ul>
			<ul id="board">
				<li><a href="">공지사항</a></li>
				<li><a href="">QnA</a></li>
			</ul>
			<ul id="community">
				<li><a href="">입양후기</a></li>
				<li><a href="">구조후기</a></li>
				<li><a href="">훈련정보</a></li>
				<li><a href="">퀴즈</a></li>
			</ul>
			<ul id="mypage">
				<li><a href="">회원정보</a></li>
			</ul>
			<ul id="super">
				<li><a href="">회원관리</a></li>
				<li><a href="">훈련정보관리</a></li>
				<li><a href="">퀴즈관리</a></li>
				<li><a href="">초기화</a></li>
			</ul>
		</div>
	</div>
</header>
	 <div  id="sectionF">
<section>
		<div style="float: left;">
			<h1 style="text-align: center;">아이디찾기</h1>
			<form>
				<table style="float: right;">
					<tr>
						<td>이메일</td>
						<td><input type="text"  id="email"></td>
					</tr>
					<tr>
						<td colspan="2"><span id="findid"></span></td>
					</tr>
				</table>
			</form>
			<button type="button" id="clickid">아이디찾기</button>
		</div>

		<div style="float: right; border: 1px;">
			<h1 style="text-align: center;">비밀번호찾기</h1>
			<form name="findPwForm">
				<table style="float: left;">
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</form>
			<button type="button" onclick="findPW()">비밀번호 찾기</button>
		</div>
</section>
	</div>
<!-- footer -->
<footer>
	<div id="footer_top">
		<div class="f_t_1">
			<div>
				<a href="">foot1-1</a>
			</div>
			<div>
				<a href="">foot1-2</a>
			</div>
			<div>
				<a href="">foot1-3</a>
			</div>
			<div>
				<a href="">foot1-4</a>
			</div>
		</div>
		<div class="f_t_2">
			<div>
				<a href="">foot2-1</a>
			</div>
			<div>
				<a href="">foot2-2</a>
			</div>
			<div>
				<a href="">foot2-3</a>
			</div>
			<div>
				<a href="">foot2-4</a>
			</div>
		</div>
		<div class="f_t_3">
			<div>
				<a href="">foot3-1</a>
			</div>
			<div>
				<a href="">foot3-2</a>
			</div>
			<div>
				<a href="">foot3-3</a>
			</div>
			<div>
				<a href="">foot3-4</a>
			</div>
		</div>
	</div>
	<div id="footer_middle">Fine is optimized for learning and
		training. Examples might be simplified to improve reading and
		learning. Tutorials, references, and examples are constantly reviewed
		to avoid errors, but we cannot warrant full correctness of all
		content. While using W3Schools, you agree to have read and accepted
		our terms of use, cookie and privacy policy.</div>
	<div id="footer_bottom">
		<address>Copyright 1999-2020 by Refsnes Data. All Rights
			Reserved. W3Schools is Powered by W3.CSS.</address>
	</div>
</footer>
<!-- jQuery -->
<script>
	jQuery(document).ready(function() {
		$(".nav_li").click(function() {
			$(".drop_menu").slideToggle("slow");
		});
	});
</script>
</body>
</html>
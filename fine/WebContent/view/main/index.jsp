<%@page import="fine.community.training.model.TrainingDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/333b7ab4b4.js"></script>
<script src="../js/jquery-3.5.1.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<style>
* {
	margin: 0;
}

body {
	max-width: 100%;
	height: 100%;
	margin: auto;
	font-family: 'Source Sans Pro ';
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
	color: black;
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
	border: 1px solid white;
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

@media screen and (max-width: 768px) {
	.navbar {
		flex-direction: column;
		align-items: flex-start;
		padding: 8px 24px;
	}
	.navbar_menu {
		flex-direction: row;
		align-items: center;
		width: 100%;
	}
	.navbar_menu a {
		display: inline;
	}
	.navbar_icons {
		justify-content: center;
		width: 100%;
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

				<li><a href="<%=ctxPath%>/find_Lists.do">찾기</a></li>
				<li><a href="<%=ctxPath%>/find_adopt_List.do">입양</a></li>
				<li><a href="<%=ctxPath%>/noticeList.do">공지사항</a></li>
				<li><a href="<%=ctxPath%>/qnaList.do">Qna</a></li>
				<li><a href="<%=ctxPath%>/adoptList.do">입양후기</a></li>
				<li><a href="<%=ctxPath%>/rescueList.do">구조후기</a></li>
				<li><a href="<%=ctxPath%>/training_list.do">훈련정보</a></li>
				<li><a href="<%=ctxPath%>/view/quiz/fine_quiz.jsp">퀴즈</a></li>
				<c:if test="${memberLev eq 2 }">
				<li><a href="<%=ctxPath%>/fine_find_manage_List.do">등록</a></li>
				</c:if>
				<c:if test="${memberLev eq 3 }">
				<li><a href="<%=ctxPath%>/trmListManager.do">관리자훈련정보</a></li>
				<li><a href="<%=ctxPath%>/qzmListManager.do">관리자퀴즈</a></li>				
				<li><a href="<%=ctxPath%>/view/find/Find_manage_UpdateList.jsp">초기화</a></li>
				<li><a href="<%=ctxPath%>/myPageList.do">회원관리</a></li>
				</c:if>
				<c:if test="${not empty sessionID }">
				<li><a href="<%=ctxPath%>/MyPage.do">마이페이지</a></li>
				</c:if>
			</ul>
			
			<ul class="memeber_menu">
			<c:if test="${empty sessionID }">
				<li><a href="<%=ctxPath%>/view/member/Fine_Member_Login.jsp">로그인</a></li>
				<li><a href="<%=ctxPath%>/view/member/Finn_Member_Register.jsp">회원가입</a></li>
			</c:if>
			<c:if test="${not empty sessionID }">
				<li>${sessionID}님 환영합니다.</li>
				<li><a href="<%=ctxPath%>/logout.do">로그아웃</a></li>
			</c:if>
			</ul>
			<!--아이콘  -->
			<ul class="navbar_icons">
				<li><i class="fab fa-instagram"></i></li>
				<li><i class="fab fa-facebook-square"></i></li>
			</ul>
			
		</nav>
		
	</header>

	<section id="section">
	</section>
	<footer id="footer">
		<!-- <div class="container">
            <div class="row"> -->
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
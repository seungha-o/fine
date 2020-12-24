<%@page import="fine.community.training.model.TrainingDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%
   String ctxpath = request.getContextPath();
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
	max-width: 1467px;
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

.previous {
	background-color: #f1f1f1;
	color: black;
}

.next {
	background-color: #f1f1f1;
	color: black;
}

.round {
	border-radius: 50%;
}

#training_content {
	display: flex;
	justify-content: space-around;
	align-items: center;
	width: 100%;
	height: 100%;
}

.training_content_side {
	
	
}

video {
	width: 700px;
	height: 100%;
}

.training_content_center_info{
	display: flex;
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
				<li><a href="">찾기</a></li>
				<li><a href="">등록</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">커뮤니티</a></li>
				<li><a href="">마이페이지</a></li>
			</ul>
			<!--아이콘  -->
			<ul class="navbar_icons">
				<li><i class="fab fa-instagram"></i></li>
				<li><i class="fab fa-facebook-square"></i></li>
			</ul>
		</nav>
	</header>

	<section id="section">
		<div id="training_content">
			<div class="training_content_side">
			<%
			int count = (int)request.getAttribute("count");
			int currentPage = (int)request.getAttribute("currentPage");
			int endPage = (int)request.getAttribute("endPage");
			int startPage = (int)request.getAttribute("startPage");
			int pagecount = (int)request.getAttribute("pagecount");
				if (count > 0) {
				 
					if (currentPage > 0 || endPage < pagecount) {
					if(currentPage == startPage){
			%>
				<a href="<%=ctxpath%>/training_list.do?pageNum=<%=startPage%>"><img src="./img/nac.png" alt="사진이 없슴둥">asdas</a>
				<%	
					}else{
					
						%>
						<a href="<%=ctxpath%>/training_list.do?pageNum=<%=currentPage-1%>"><img src="./img/nac.png" alt="사진이 없슴둥">asdasd</a>
						<%
					}
				}
				
				%>
			</div>
			<c:if test="${not empty list}">
            <c:forEach items="${ list }" var="mvo" varStatus="s">
			<div id="training_content_center">
				<div id="training_content_center_header"
					style="text-align: center; width: 700px; height: 100%; margin:50px 0 50px 0;">
					<h1>${mvo.trn_title}</h1>
				</div>
				<div id="training_content_center_info">
					<p class="training_content_center_text">${mvo.write_date}</p>
					<p class="training_content_center_text">관리자</p>
				</div>
				
				<div id="training_content_center_media"
					style="width: 700px; height: 100%; margin-bottom: 50px;">
					<div style="width: 100%; height: 400px">
						<video controls>
							<source src="./upload/${mvo.media }" type="video/mp4">
						</video>
					</div>
				</div>
				<div id="training_content_center_coment"
					style="text-align: center; width: 700px; height: 100%; margin-bottom: 50px;">
					${mvo.content }
					</div>

			</div>
			</c:forEach>
         </c:if>
			<div class="training_content_side">
			
		<%	
				
	
				
					if (currentPage > 0 || endPage < pagecount) {
					if(currentPage == endPage){
			%>
				<a href="<%=ctxpath%>/training_list.do?pageNum=<%=endPage%>"><img src="./img/navigater.png" alt="사진이 없슴둥">asdasd</a>
				<%	
					}else{
					
						%>
						<a href="<%=ctxpath%>/training_list.do?pageNum=<%=currentPage+1%>"><img src="./img/navigater.png" alt="사진이 없슴둥">asdasd</a>
						<%
					}
				}
			}
		
				%>
		
			
			
			</div>
		</div>


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
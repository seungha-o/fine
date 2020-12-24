<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
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
<title>전체 회원 정보 - 관리자</title>
<script src="https://code.jquery.com/jquery-3.4.0.js"></script>
</head>
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
	color: black
	
}
a:hover {
	background-color: #ddd;
	color: black;
}

</style>
<script type="text/javascript">
function FunS() {
	var search = document.SearchForm
	search.action = "<%=ctxPath%>/SearchId.do";
		search.method = "POST";
		search.submit();
	}
</script>
<body>
	<h1 align="center">FINE Web Project</h1>
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
				<li><a href="<%=ctxPath%>/MyPage.do">마이페이지</a></li>
			</ul>
			<!--아이콘  -->
			<ul class="navbar_icons">
				<li><i class="fab fa-instagram"></i></li>
				<li><i class="fab fa-facebook-square"></i></li>
			</ul>
		</nav>
	</header>
	<section id="section">
		<form name="SearchForm">
			<table>
				<tr>
					<td colspan="3"><h2>전체 회원 정보</h2></td>
				</tr>
				<tr>
					<td>ID 찾기 :</td>
					<td><input type="text" name="id" id="searchid"></td>
					<td><button type="button" id="send" onclick="FunS()">검색</button></td>
				</tr>
			</table>
		</form>


		<div>
			<form name="AdminForm">
				<c:if test="${not empty myPageList}">
						<c:forEach items="${myPageList }" var="vo" varStatus="s">
				<table border="2">
					<tr>
						<td>번 호</td>
						<td>아이디</td>
						<td>보호소</td>
						<td>이 름</td>
						<td>핸드폰 번호</td>
						<td>Email</td>
						<td>주 소</td>
						<td>좋아하는 품종</td>
						<td>등급</td>
						<td>권한 관리</td>
						<td>승인 상태</td>
						<td>가입 일자</td>
						<td>생일</td>
						<td>삭제</td>
					</tr>
				
				
							<tr>
								<td>${s.count }</td>
								<td>${vo.id }</td>
								<td>${vo.care_no }</td>
								<td>${vo.name }</td>
								<td>${vo.phone }</td>
								<td>${vo.email }</td>
								<td>${vo.address }</td>
								<td>${vo.dog_kind_no }</td>
								<td>${vo.grade }</td>
								<td>${vo.lev }</td>
								<td>${vo.status }</td>
								<td>${vo.sign_date }</td>
								<td>${vo.birthday }</td>
								<td><button type="button"
										onclick="window.location='<%=ctxPath%>/del.do?id=${vo.id }'">삭제</button></td>
							</tr>
								
				
							
					
				</table>
				</c:forEach>
					</c:if>
					<c:if test="${empty myPageList }">
						
							<div>가입된 회원이 없습니다.</div>
						
					</c:if>
				
			</form>
			
			<%
			String searchId = (String)request.getAttribute("searchId");
			%>
			<div class="pagediv">
				<c:if test="${startPage != endPage}">
					<c:forEach varStatus="s" begin="${startPage}" end="${endPage}"
						step="1">
						<a href="SearchId.do?pageNum=${s.count}&searchId=<%=searchId %>">${s.count}</a>
						<!--변경 : href 경로 -->
					</c:forEach>
				</c:if>
				
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
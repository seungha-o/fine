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
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->

<!-- link css -->
<link rel="stylesheet" href="<%=ctxPath%>/css/head_foot.css" />
<!-- font -->
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital@0;1&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet" />
<!-- CSS -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"></script>
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
	background-color:  #f5f7f8;
	width: 100%;
	height: 900px;
}
table {
   border-collapse: collapse;
	text-align : center;
	margin : auto;
	width : 1200px;
	position : relative;
	top : 50px;
	border-radius: 1em;
}
table td {
  text-align: left;
  padding: 8px;
}

table tr:nth-child(even){background-color: #dcdcdc}
table tr:hover :not(th){background-color: #aaaaaa}
table a {padding : 0; color : black;}
th { height : 50px; border : 1px; }

form { 
	margin: 0 auto;  
	padding : 20px; 
}
.pagediv {margin: 0 auto;  
	      padding : 20px; 
	      
	      text-align : center;}
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
	background-color: #505050;
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
</head>

<body>
	
<!-- HEADER -->
	<jsp:include page="/common/header.jsp" />
	
<!-- SECTION -->	
	<section id="section">
		<form name="SearchForm">
			<table>
				<tr>
					<td colspan="3"><h2>전체 회원 정보</h2></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" name="id" id="searchid" style="height:30px; width: 650px;"></td>
					<td><button type="button" id="send" style="height: 35px; background: #dcdcdc; font-size: 1em; border-radius: 0.5em; padding: 2px 20px;" onclick="FunS()">ID 검색</button></td>
				</tr>
			</table>
		</form>
		<div>
			<form name="AdminForm">
				<table border="2">
					<tr>						
						<td>아이디</td>
						<td>보호소</td>
						<td>이  름</td>
						<td>핸드폰 번호</td>
						<td>Email</td>
						<td>주  소</td>
						<td>좋아하는 품종</td>
						<td>등급</td>
						<td>권한 관리</td>
						<td>승인 상태</td>
						<td>가입 일자</td>
						<td>생일</td>
						<td>삭제</td>
					</tr>
					<c:if test="${not empty myPageList}">
						<c:forEach items="${myPageList }" var="vo" varStatus="s">
							<tr>								
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
						</c:forEach>
					</c:if>

					<c:if test="${empty myPageList }"><br>
						<tr>
							<td colspan="13">가입된 회원이 없습니다.</td>
						</tr>
					</c:if>
				</table>
			</form>
			<div class="pagediv">
				<c:if test="${startPage != endPage}">
					<c:forEach  varStatus="s" begin="${startPage}" end="${endPage}"
						step="1">
						<a href="myPageList.do?pageNum=${s.count}">${s.count}</a>
						<!--변경 : href 경로 -->
					</c:forEach>
				</c:if>
			</div>
		</div>
	</section>  
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
	
	<!-- <%@ include file="/common/footer.jsp" %> 자바 형식 -->
	 </body>
</html>
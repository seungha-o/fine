<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPaths = request.getContextPath();
%>
	<header id="header">
		<div id="header_top">
			<div class="page_logo">
				<i class="fas fa-paw"></i> 
				<a href="<%=ctxPaths%>/findHowMany.do">
					<span id="fine">Fine</span>
				</a>
			</div>
			<c:if test="${empty sessionID }">
				<div class="login_form">
					<a href="<%=ctxPaths%>/view/member/Fine_Member_Login.jsp"><span id="login"> 로그인 | </span></a> 
					<a href="<%=ctxPaths%>/view/member/Fine_Member_Register.jsp"><span id="register"> 회원가입</span></a>
				</div>
			</c:if>
			<c:if test="${not empty sessionID }">
				<div class="login_form">
					<span> ${sessionID}님 환영합니다. </span>
					<a href="<%=ctxPaths%>/logout.do"><span> 로그아웃 </span></a>
				</div>
			</c:if>
		</div>
		<nav class="nav">
			<ul class="nav_menu">
				<li class="nav_li"><a href="#"><span class="underline">찾기</span></a>
				</li>
				<c:if test="${memberLev eq 2 }">
				<li class="nav_li"><a href="#"><span class="underline">등록</span></a>
				</li>
				</c:if>
				<li class="nav_li"><a href="#"><span class="underline">게시판</span></a>
				</li>
				<li class="nav_li"><a href="#"><span class="underline">커뮤니티</span></a>
				</li>
				<li class="nav_li"><a href="#"><span class="underline">마이페이지</span></a>
				</li>
				<c:if test="${memberLev eq 3 }">
				<li class="nav_li"><a href="#"><span class="underline">관리자</span></a>
				</li>
				</c:if>
			</ul>
		</nav>
		<div class="drop_menu">
			<div class="indrop">
				<ul id="find">
					<li><a href="<%=ctxPaths%>/find_Lists.do">유기견 찾기</a></li>
					<li><a href="<%=ctxPaths%>/find_adopt_List.do">입양하기</a></li>
				</ul>
				<ul id="care">
					<c:if test="${memberLev eq 2 }">
						<li><a href="<%=ctxPaths%>/reservationChck.do">입양관리</a></li>
						<li><a href="<%=ctxPaths%>/fine_find_manage_List.do">유기견등록</a></li>
					</c:if>
				</ul>
				<ul id="board">
					<li><a href="<%=ctxPaths%>/noticeList.do">공지사항</a></li>
					<li><a href="<%=ctxPaths%>/qnaList.do">QnA</a></li>
				</ul>
				<ul id="community">
					<li><a href="<%=ctxPaths%>/adoptList.do">입양후기</a></li>
					<li><a href="<%=ctxPaths%>/rescueList.do">구조후기</a></li>
					<li><a href="<%=ctxPaths%>/training_list.do">훈련정보</a></li>
						<li><a href="<%=ctxPaths%>/view/quiz/fine_quiz.jsp">퀴즈</a></li>
				</ul>
				<ul id="mypage">
					<li><a href="<%=ctxPaths%>/MyPage.do">마이페이지</a></li>					
				</ul>
				<ul id="super">
				<c:if test="${memberLev eq 3 }">
					<li><a href="<%=ctxPaths%>/MyPage.do">회원정보</a></li>
					<li><a href="<%=ctxPaths%>/trmListManager.do">훈련정보관리</a></li>
					<li><a href="<%=ctxPaths%>/qzmListManager.do">퀴즈관리</a></li>
					<li><a href="<%=ctxPaths%>/view/find/Find_manage_UpdateList.jsp">초기화</a></li>
				</c:if>
				</ul>
			</div>
		</div>
	</header>
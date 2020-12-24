
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
<title>MyPageview</title>

<script src="../JS/jquery-3.5.1.js"></script>
<script type="text/javascript">
function del() {
	var del = document.InfoForm
	del.action = "<%=ctxPath%>/view/member/myPage_pwCheck_delete.jsp";
		del.method = "POST";
		del.submit();
	}

function sub() {
	var send = document.Modiform
	send.action = "<%=ctxPath%>/Update.do";
	send.method = "POST";
	send.submit();
}
</script>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
	rel="stylesheet">
<style>
* {
	margin: 0;
}

body {
	max-width: 1200px;
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
	height: 100%;
}

html {
	background: #f5f7f8;
	font-family: 'Roboto', sans-serif;
	-webkit-font-smoothing: antialiased;
	padding: 20px 0;
}

.section_head {
	margin-bottom: 10px;
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
	font-size: 20px;
	margin: 0;
	color: #333;
}

.card span {
	font-size: 12px;
	font-weight: bold;
	color: #999;
	text-transform: uppercase;
	letter-spacing: .05em;
	margin: 2em 0 0 0;
}

.band {
	width: 100%;
	max-width: 1240px;
	margin: 0 auto;
	display: grid;
	grid-template-columns: 1fr;
	grid-template-rows: auto;
	grid-gap: 20px;
}

.card {
	background: #fff;
	text-decoration: none;
	color: #444;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .1);
	display: flex;
	min-height: 100%;
	flex-direction: column;
	justify-content: space-between;
	position: relative;
	top: 0;
	transition: 0.2s;
}

.card:hover {
	top: -2px;
	box-shadow: 0 4px 5px rgba(0, 0, 0, .2);
}

.thumb {
	padding-bottom: 60%;
	background-size: cover;
	background-position: center center;
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

#section {
	background-color: #afc2c6;
	width: 1200px;
	height: 550px;
}

.a1 {
	display: none;
}

input {
	height: 25px;
	border-radius: 5px 5px 5px 5px;
}

#one:nth-of-type(1) {
	display: none;
}

#one:nth-of-type(1) ~div:nth-of-type(1) {
	display: none;
}

#one:nth-of-type(1):checked ~div:nth-of-type(1) {
	display: block;
}

#two:nth-of-type(2) ~div:nth-of-type(2) {
	display: none;
}

#two:nth-of-type(2):checked ~div:nth-of-type(2) {
	display: block;
}

#one:nth-of-type(1):checked ~section.buttons>label:nth-of-type(1) {
	background: #7bb8b3;
	color: #708350;
}

#two:nth-of-type(2):checked ~section.buttons>label:nth-of-type(2) {
	background: #7bb8b3;
	color: #708350;
}

section.buttons {
	overflow: hidden;
	font-size: 20px;
}

section.buttons>label {
	float: left;
	display: block;
	width: 50%;
	height: 50px;
	line-height: 60px;
	text-align: center;
	border-radius: 5px 5px 5px 5px;
	box-sizing: border-box;
	border: 1px solid gray;
	background: rgb(106, 180, 184);
	color: white;
	font-weight: bold;
}

section.buttons>label:hover {
	background: darkcyan;
	color: black;
}

.item {
	overflow: hidden;
	padding: 10px;
	border: 1px solid black;
	border-top: none;
}

table {
	border-spacing: 20px;
}

.space {
	padding-left: 100px;
}

tfoot>tr>td {
	text-align: right;
	line-height: 50px;
}

#footer {
	padding: 30px 0;
	background-color: burlywood;
	position: relative;
	transform: translateY(0%);
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
	background-color: burlywood;
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
	color: burlywood;
	font-size: 1em;
	border-radius: 0.5em;
	padding: 2px 20px;
}

a {
	text-decoration: none;
	display: inline-block;
	padding: 2px 16px;
	height: 30px;
}

.previous {
	background-color: #f1f1f1;
	color: black;
}

.link:hover {
	background-color: #ddd;
	color: black;
}

.footer {
	background-color: burlywood;
	color: black;
}

.next {
	background-color: #f1f1f1;
	color: black;
}

.round {
	border-radius: 50%;
}

#dd {
	background-color: blue;
}

.cl {
	color: blue;
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
		<div class="tabmenu">
			<input type="radio" class="a1" name="tab" id="one" checked> <input
				type="radio" class="a1" name="tab" id="two">
			<section class="buttons">
				<label for="one" class="tab">회원정보</label> <label for="two"
					class="tab">정보수정</label>
			</section>
			<div class=tab_item>
		<!-- 화면에서 mypage 개인 정보 보여주는 곳 -->
				<c:if test="${not empty myPageList}">
					<c:forEach items="${ myPageList }" var="vo" varStatus="s">
						<form name="InfoForm">
							<table>

								<caption> 회원 정보 </caption>
								<tbody>
									<tr>
										<td class="space">이름</td>
										<td>${vo.name}</td>
									</tr>
									<tr>
										<td class="space">등급</td>
										<td>${vo.grade}</td>
									</tr>
									<tr>
										<td class="space">견종</td>
										<td>${vo.dog_kind_no}</td>
									</tr>
									<tr>
										<td class="space">주소</td>
										<td>${vo.address}</td>
									</tr>
									<tr>
										<td class="space">핸드폰</td>
										<td>${vo.phone}</td>
									</tr>
									<tr>
										<td class="space">이메일</td>
										<td>${vo.email}</td>
									</tr>

								</tbody>
								<tfoot>
									<tr>

										<td colspan="2">
											<button
												style="height: 35px; background: #f8e4c6; font-size: 1em; border-radius: 0.5em; padding: 5px 20px;"
												onclick="del()">탈퇴 요청</button>
										</td>
									</tr>
								</tfoot>
							</table>
						</form>
					</c:forEach>
				</c:if>
		 <!-- 화면에서 mypage 개인 정보 수정 곳 -->
			</div>
			<div class=tab_item>
				<c:if test="${not empty myPageList}">
					<c:forEach items="${ myPageList }" var="vo" varStatus="s">
						<form name="Modiform">

							<table>
							<caption> 회원 정보 수정</caption>
								<tbody>
									<tr>
										<td class="space">이름</td>
										<td>${vo.name}</td>
									</tr>
									<tr>
										<td class="space">등급</td>
										<td>${vo.grade}</td>
									</tr>
									<tr>
									     <td class="space">견종</td>
                        <td><select onchange="categoryChange(this)" style="width: 100px">
							  <option value="choice">항목을 선택해 주세요</option>
							  <option value="a">가</option>
							  <option value="b">나</option>
							  <option value="c">다</option>
							  <option value="d">라</option>
							  <option value="e">마</option>
							  <option value="f">바</option>
							  <option value="g">사</option>
							  <option value="h">아</option>
							  <option value="i">자</option>
							  <option value="j">차</option>
							  <option value="k">카</option>
							  <option value="l">타</option>
							  <option value="m">파</option>
							  <option value="n">하</option>
							  <option value="o">기타</option>
							</select>
							 
							<select id="kind" name="kind" style="width: 100px">
							</select><br></td>
					
									</tr>
									<tr>
										<td class="space">주소</td>
										<td><input type="text" name="address" id="address"
											value="${vo.address}" required></td>
									</tr>
									<tr>
										<td class="space">핸드폰</td>
										<td><input type="text" id="phone" name="phone" required
											value="${vo.phone}" placeholder="숫자만 입력하세요"></td>
									</tr>
									<tr>
										<td class="space">이메일</td>
										<td><input type="email" id="email" name="email"
											value="${vo.email}" required></td>
									</tr>
									<tr>
										<td class="space">비밀번호</td>
										<td><input type="password" id="password" name="password" required></td>
									</tr>
									<tr>
										<td></td>
										<td>
											<!-- <button
												style="height: 35px; background: #f8e4c6; font-size: 1em; border-radius: 0.5em; padding: 5px 20px;"
												onclick="modify()">수정</button> -->
											<button 
												style="height: 35px; background: #f8e4c6; font-size: 1em; border-radius: 0.5em; padding: 2px 20px;"
												onclick="sub()">전송</button>
									</tr>
								</tbody>
							</table>
						</form>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</section>
	<div class="footer">
		<ul>
			<li><a class="link" href="#">사이트 도움말</a></li>
			<li><a class="link" href="#">사이트 이용약관</a></li>
			<li><a class="link" href="#">사이트 운영원칙</a></li>
			<li><a class="link" href="#"><strong>개인정보취급방침</strong></a></li>
			<li><a class="link" href="#">책임의 한계와 법적고지</a></li>
			<li><a class="link" href="#">게시중단요청서비스</a></li>
			<li><a class="link" href="#">고객센터</a></li>
		</ul>
		<address>
			Copyright &copy; <a href="#"><strong>Fine</strong></a> All Rights
			Reserved.
		</address>
	</div>
	<script type="text/javascript">
	function categoryChange(e) {
		  var good_a = 
			  ["골든 리트리버",
			  "그레이 하운드",
			  "그레이트 덴",
			  "그레이트 피레니즈",
			  "꼬똥 드 뚤레아"];
		  var good_b = ["네오폴리탄 마스티프",
			  "노르포크 테리어",
			  "노리치 테리어",
			  "뉴펀들랜드"];
		  var good_c = ["닥스훈트",
			  "달마시안",
			  "댄디 딘몬트 테리어",
			  "도고 까니리오",
			  "도고 아르젠티노",
			  "도고 아르젠티노",
			  "도베르만",
			  "도사",
			  "동경견"];
		  var good_d = ["라브라도 리트리버",
			  "라사 압소",
			  "라이카",
			  "래빗 닥스훈드",
			  "랫 테리어",
			  "레이크랜드 테리어",
			  "로디지안 리즈백",
			  "로트바일러",
			  "롯트와일러"];
		  var good_e = ["마리노이즈",
			  "마스티프",
			  "말라뮤트",
			  "말티즈",
			  "맨체스터테리어",
			  "미니어쳐 닥스훈트",
			  "미니어쳐 불 테리어",
			  "미니어쳐 슈나우저",
			  "미니어쳐 푸들",
			  "미니어쳐 핀셔",
			  "미디엄 푸들",
			  "미텔 스피츠"];
		  var good_f = ["바센지",
			  "바셋 하운드",
			  "버니즈 마운틴 독",
			  "베들링턴 테리어",
			  "벨기에 그로넨달",
			  "벨기에 쉽독",
			  "벨기에 테뷰런",
			  "벨지안 셰퍼드 독",
			  "보더 콜리",
			  "보르조이",
			  "보스턴 테리어",
			  "복서",
			  "볼로네즈",
			  "부비에 데 플랑드르",
			  "불 테리어",
			  "불독",
			  "브뤼셀그리펀",
			  "브리타니 스파니엘",
			  "블랙 테리어",
			  "비글",
			  "비숑 프리제",
			  "비어디드 콜리",
			  "비즐라",
			  "빠삐용"];
		  var good_g = ["사모예드",
			  "살루키",
			  "삽살개",
			  "샤페이",
			  "세인트 버나드",
			  "센트럴 아시안 오브차카",
			  "셔틀랜드 쉽독",
			  "셰퍼드",
			  "슈나우져",
			  "스코티쉬 테리어",
			  "스코티시 디어하운드",
			  "스탠다드 푸들",
			  "스테포드셔불테리어",
			  "스피츠",
			  "시바",
			  "시베리안 허스키",
			  "시베리안라이카",
			  "시잉프랑세즈",
			  "시츄",
			  "시코쿠",
			  "실리햄 테리어",
			  "실키테리어"];
		  var good_h = [
			  "아나톨리안 셰퍼드",
			  "아메리칸 불독",
			  "아메리칸 스태퍼드셔 테리어",
			  "아메리칸 아키다",
			  "아메리칸 에스키모",
			  "아메리칸 코카 스파니엘",
			  "아메리칸 핏불 테리어",
			  "아메리칸불리",
			  "아이리쉬 레드 앤 화이트 세터",
			  "아이리쉬 세터",
			  "아이리쉬 울프 하운드",
			  "아이리쉬소프트코튼휘튼테리어",
			  "아키다",
			  "아프간 하운드",
			  "알라스칸 말라뮤트",
			  "에어델 테리어",
			  "오브차카",
			  "오스트랄리안 셰퍼드 독",
			  "오스트랄리안 캐틀 독",
			  "올드 잉글리쉬 불독",
			  "올드 잉글리쉬 쉽독",
			  "와이마라너",
			  "와이어 폭스 테리어",
			  "요크셔 테리어",
			  "울프독",
			  "웨스트 시베리언 라이카",
			  "웨스트하이랜드화이트테리어",
			  "웰시 코기 카디건",
			  "웰시 코기 펨브로크",
			  "웰시 테리어",
			  "이탈리안 그레이 하운드",
			  "잉글리쉬 세터",
			  "잉글리쉬 스프링거 스파니엘",
			  "잉글리쉬 코카 스파니엘",
			  "잉글리쉬 포인터"];
		  var good_i = [
			  "자이언트 슈나우져",
			  "재패니즈 스피츠",
			  "잭 러셀 테리어",
			  "저먼 셰퍼드 독",
			  "저먼 와이어헤어드 포인터",
			  "저먼 포인터",
			  "제주개",
			  "제페니즈칭",
			  "진도견"];
		  var good_j = [
			  "차우차우",
			  "차이니즈 크레스티드 독",
			  "치와와"];
		  var good_k = [
			  "카레리안 베어독",
			  "카이훗",
			  "캐벌리어 킹 찰스 스파니엘",
			  "케니스펜더",
			  "케리 블루 테리어",
			  "케언 테리어",
			  "케인 코르소",
			  "코리아 트라이 하운드",
			  "코리안 마스티프",
			  "코카 스파니엘",
			  "코카 푸",
			  "코카시안오브차카",
			  "콜리",
			  "클라인스피츠",
			  "키슈",
			  "키스 훈드"];
		  var good_l = [
			  "토이 맨체스터 테리어",
			  "토이 푸들",
			  "티베탄 마스티프"
		  ];
		  var good_m = [
			  "파라오 하운드",
			  "파슨 러셀 테리어",
			  "팔렌",
			  "퍼그",
			  "페키니즈",
			  "페터데일테리어",
			  "포메라니안",
			  "포인터",
			  "폭스테리어",
			  "푸들",
			  "풀리",
			  "풍산견",
			  "프레사까나리오",
			  "프렌치 불독",
			  "프렌치 브리타니",
			  "플랫 코티드 리트리버",
			  "플롯하운드",
			  "피레니안 마운틴 독",
			  "필라 브라질레오",
			  "핏불테리어"];
		  var good_n = [
			  "허배너스",
			  "화이트리트리버",
			  "화이트테리어",
			  "휘펫"];
		  var good_o = ["기타", "믹스견"];

		  var target = document.getElementById("kind");
		 
		  if(e.value == "a") var d = good_a;
		  else if(e.value == "b") var d = good_b;
		  else if(e.value == "c") var d = good_c;
		  else if(e.value == "d") var d = good_d;
		  else if(e.value == "e") var d = good_e;
		  else if(e.value == "f") var d = good_f;
		  else if(e.value == "g") var d = good_g;
		  else if(e.value == "h") var d = good_h;
		  else if(e.value == "i") var d = good_i;
		  else if(e.value == "j") var d = good_j;
		  else if(e.value == "k") var d = good_k;
		  else if(e.value == "l") var d = good_l;
		  else if(e.value == "m") var d = good_m;
		  else if(e.value == "n") var d = good_n;
		  else if(e.value == "o") var d = good_o;
		 
		  target.options.length = 0;
		 
		  for (x in d) {
		    var opt = document.createElement("option");
		    opt.value = d[x];
		    opt.innerHTML = d[x];
		    target.appendChild(opt);
		  } 
		}
	</script>
</body>
</html>
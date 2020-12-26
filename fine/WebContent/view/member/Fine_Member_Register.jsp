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
div{
	border-radius: 4px;
}


input[type=text],input[type=password]{
   width: 200px;
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
select{
	width: 100%;
  	height: 100%;
	font-size: 0.9vmax;
	position: relative;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}
input[type=button] {
   width: 100%;
   background-color:  #22ad78;
   color: white;
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}

input[type=button]:hover {
   background-color: #45a049;
}


#sectionF{
	height : 75vh;
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
	width: 20vw;
	background: rgba(255,255,255,0.6);
	box-shadow: 2px 2px 2px;
}
.hspan{
	font-size: 0.7vmax;
}
.selt{

}
</style>
<script type="text/javascript">
function register() {
	      	var rgstf = document.registerForm
	      	
	      	var idck2 = "사용가능한 id 입니다";
	      	var phoneck2 = "사용가능한 phone 입니다";
	      	var emailck2 = "사용가능한 email 입니다";
	      	var pwck2 = "사용가능한 비밀번호 입니다";
	      	
	      	var pwck = document.getElementById('resultPW').innerText;
			var p1 = document.getElementById('pw').value;
			var p2 = document.getElementById('pwdck').value;
	      	var idck =  document.getElementById('resultID').innerText;
	      	console.log(idck+"="+idck2);
	      	var phoneck =  document.getElementById('resultPHONE').innerText;   // 여기 이름을 왜 그랬데요~ emailck = 
	      	console.log(phoneck+"="+phoneck2);
	      	var emailck =  document.getElementById('resultEMAIL').innerText;  // 여기 이름을 왜 그랬데요~ phoneck = 
	    	console.log(emailck+"="+emailck2);
	    	console.log(pwck+"="+pwck2)
	     	if(pwck != pwck2) {
	     		alert("비밀번호 형식을 확인해주세요.");
	     	}else if(p1 != p2){
	     		alert("비밀번호가 일치 하지 않습니다");
	     	}else if(idck != idck2){
	     		alert("아이디를 확인해주세요.");
	     	}else if(phoneck != phoneck2){
	     		alert("핸드폰번호를 확인해주세요.");
	     	}else if(emailck != emailck2){
	     		alert("이메일을 확인해주세요.");
	      	}else{
	      		rgstf.action = "<%=ctxPath%>/register.do";
	      		rgstf.method = "POST";
	      		rgstf.submit();
	     	}
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


<div id="sectionF">
<section>
	<div>
		<form name="registerForm">
			<h1 style="text-align: center; margin-bottom: 3vh;">회원가입</h1>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id"><span
						id="resultID" class="hspan"></span></td>
				</tr>
				<tr>
					<td><label for="a">보호소 </label><input name="careCK" type="checkbox" id="a" value="1"></td>
					<td><input style="display: none" type="text" id="b"
						name="care_no" placeholder="보호소 번호를입력해주세요." required="required"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" id="pw" required="required"><span id="resultPW" class="hspan"></span></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" name="pwdck" id="pwdck" required="required"></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><input type="text" name="phone" id="phone"
						placeholder=' " - "는생략해주세요.' required="required"><span id="resultPHONE" class="hspan"></span></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" id="email" required="required"><span
						id="resultEMAIL" class="hspan"></span></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" id="address" required="required"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td style="display: flex;">
						<select class="selt" name="years" id="years"></select>
						<select class="selt" name="months" id="months"></select>
						<select class="selt" name="days" id="days"></select>
					</td>
				</tr>
				<tr>
					<td>좋아하는견종</td>
					<td>
						<select onchange="categoryChange(this)" size="maxwhith">
							<option value="a" selected="selected">가</option>
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
						<select id="dog_kind_no" name="dog_kind_no" size="maxwhith"></select>
					</td>
				</tr>
			</table>
					<input type="button" value="가입" onclick="register()">
		</form>
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
	<script type="text/javascript">
	jQuery(document).ready(function() {
		$(".nav_li").click(function() {
			$(".drop_menu").slideToggle("slow");
		});
	});
	
		$(document).ready(function() {
			$("#a").change(function() {
				if ($("#a").is(":checked")) {
					$("#b").css("display", "block");
				} else {
					$("#b").css("display", "none");
				}
			});
		});

		$(function() {
			for (i = new Date().getFullYear(); i > 1900; i--) {
				$('#years').append($('<option />').val(i).html(i));
			}
			for (i = 1; i < 13; i++) {
				$('#months').append($('<option />').val(i).html(i));
			}
			updateNumberOfDays();
			$('#years, #months').change(function() {
				updateNumberOfDays();
			});
		});
		function updateNumberOfDays() {
			$('#days').html('');
			month = $('#months').val();
			year = $('#years').val();
			days = daysInMonth(month, year);

			for (i = 1; i < days + 1; i++) {
				$('#days').append($('<option />').val(i).html(i));
			}
		}
		function daysInMonth(month, year) {
			return new Date(year, month, 0).getDate();
		}

		$('#id').focusout("input", function() {
			var aaa = $("#id").val();
			var regex = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/; //4~20
			if (!regex.exec(aaa)) {
				$("#resultID").html("아이디 형식에 맞지 않습니다");
				return;
			}
			$("#resultID").html("아이디 형식 OK");
			$.ajax({
				url : "../../IdCheck",
				data : {
					id : $("#id").val()
				},
				success : function(result) {
					$("#resultID").html(result);
				}
			});
		});
		$('#email').focusout("input",function() {
			var aaa = $("#email").val();
			var regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			if (!regex.exec(aaa)) {
				$("#resultEMAIL").html("이메일 형식에 맞지 않습니다");
				return;
			}
			$("#resultEMAIL").html("이메일 형식 OK");
			$.ajax({
				url : "../../EmailCheck",
				data : {
					email : $("#email").val()
				},
				success : function(result) {
					$("#resultEMAIL").html(result);
				}
			});
		});
		$('#phone').focusout("input", function() {
			var aaa = $("#phone").val();
			var regex = /^\d{3}\d{3,4}\d{4}$/;
			if (!regex.exec(aaa)) {
				$("#resultPHONE").html("전화번호 형식에 맞지 않습니다");
				return;
			}
			$("#resultPHONE").html("전화번호 형식 OK");
			$.ajax({
				url : "../../PhoneCheck",
				data : {
					phone : $("#phone").val()
				},
				success : function(result) {
					$("#resultPHONE").html(result);
				}
			});
		});
		
		$('#pw').focusout("input", function() {
      		var aaa = $("#pw").val();
          	var regex =  /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			if (!regex.exec(aaa)) {
				$("#resultPW").html("비밀번호형식에 맞지 않습니다");
				return;
			}else{
			$("#resultPW").html("사용가능한 비밀번호 입니다");
			}
		});
	
		
		
		
		
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

			  var target = document.getElementById("dog_kind_no");
			 
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
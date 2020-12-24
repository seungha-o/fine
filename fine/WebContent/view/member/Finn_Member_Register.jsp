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
<style type="text/css">
</style>
<script type="text/javascript">
function register() {
	var rgstf = document.registerForm
	rgstf.action = "<%=ctxPath%>/register.do";
		rgstf.method = "POST";
		rgstf.submit();
	}
</script>
</head>
<body>
	<div>
		<form name="registerForm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" id="id"><span
						id="resultID"></span></td>
				</tr>
				<tr>
					<td>보호소<input name="careCK" type="checkbox" id="a" value="1"></td>
					<td><input style="display: none" type="text" id="b"
						name="care_no" placeholder="보호소 번호를입력해주세요."></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="text" name="pwdck"></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><input type="text" name="phone" id="phone"
						placeholder=' " - "는생략해주세요.'><span id="resultPHONE"></span></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" id="email"><span
						id="resultEMAIL"></span></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" id="address"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><select name="years" id="years"></select> <select
						name="months" id="months"></select> <select name="days" id="days"></select>
					</td>
				</tr>
				<tr>
					<td>좋아하는견종</td>
					<td><select onchange="categoryChange(this)" size="maxwhith">
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
					
					<select id="dog_kind_no" name="dog_kind_no" size="maxwhith">
					</select>
					</td>

				</tr>
			</table>
			<input type="button" value="가입" onclick="register()">
		</form>
	</div>
	<script type="text/javascript">
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
		$('#email')
				.focusout(
						"input",
						function() {
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
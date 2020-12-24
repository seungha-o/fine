<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=99b1d8e23b122c900c17996f24c1ec0e&libraries=services"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<%=ctxPath %>/js/datepicker-ko.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

table tr, th, td {
	border: 1px solid black;
	text-align: center;
	padding: 5px;
}
</style>
 <script type="text/javascript">
	function goFindSearch() {
		var frm = document.findDog;
		frm.action = "<%=ctxPath%>/find_Search.do";
		frm.method = "get";
		frm.submit();
	}
	
	$(function(){

	    $("#happenDt").datepicker({

	        showOn: "both",

	        buttonImage: "images/calendar.gif",

	        buttonImageOnly: true,

	        buttonText: "Select date"

	    });

	});

	</script> 
</head>
<body>
<form name="findDog">
			<label>시/도</label><br> 	
						<select name="sido" id="sido" onchange="categorySidoChange(this)">
						<option value="강원도">강원도</option>
						<option value="경기도">경기도</option>
						<option value="경상남도">경상남도</option>
						<option value="경상북도">경상북도</option>
						<option value="광주광역시">광주광역시</option>
						<option value="대구광역시">대구광역시</option>
						<option value="대전광역시">대전광역시</option>
						<option value="부산광역시">부산광역시</option>
						<option value="서울특별시">서울특별시</option>
						<option value="세종특별자치시">세종특별자치시</option>
						<option value="울산광역시">울산광역시</option>
						<option value="인천광역시">인천광역시</option>
						<option value="전라남도">전라남도</option>
						<option value="전라북도">전라북도</option>
						<option value="제주특별자치도">제주특별자치도</option>
						<option value="충청남도">충청남도</option>
						<option value="충청북도">충청북도</option>
					</select>
					<br> 
		<label>시/군/구</label>
		<br><select id="sigungu" name="sigungu">

		</select><br> 
		<label>견종</label><br>
<select onchange="categoryChange(this)">
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
 
<select id="dog_kind" name="dogKind">
</select><br>

<input type="text" name="happenDt" id="happenDt" size="12"><br>

<button type="submit" onclick="goFindSearch()">검색</button>

	</form>
<div id="map" style="width:800px;height:500px;"></div>
	
	<table border="1">
		<thead>
			<tr>
				<th>유기견사진</th>
				<th>보호소</th>
				<th>보호소주소</th>
				<th>발견장소</th>
				<th>발견날짜</th>
				<th>성별</th>
				<th>중성화여부</th>
			</tr>
		</thead>
		
		<tbody>
		<c:if test="${not empty list }">
	<c:forEach items="${list }" var="mvo" varStatus="s">
		<tr>
		<td><img src="${mvo.filename }"></td>
		<td class = "careName">${mvo.careNm }</td>
		<td class = "address">${mvo.careAddr }</td>
		<td>${mvo.happenPlace }</td>
		<td>${mvo.happenDt }</td>
		<td>${mvo.sexCd }</td>
		<td>${mvo.neuterYn }</td>
		<td> <button type="button" id="BtnDetail" onclick="window.location='<%=ctxPath%>/findDetail.do?no=${mvo.desertionNo}'">상세보기</button></td>
		</tr>
	
	</c:forEach>
	</c:if>
	<c:if test="${empty list }">
	<h1>찾는 결과가 없습니다. 기재사항 모두 입력해 주세요</h1>
	</c:if>
		</tbody>
	</table>
	<%
		int count = (int)request.getAttribute("count");
		int currentPage = (int)request.getAttribute("currentPage");
		int endPage = (int)request.getAttribute("endPage");
		int startPage = (int)request.getAttribute("startPage");
		int pagecount = (int)request.getAttribute("pagecount");
			if (count > 0) {
			
				if (currentPage > 1 || endPage < pagecount) {
				if (currentPage == 1) {
					%>
					[<a style="display=none" href="./find_Lists.do?pageNum=<%=currentPage - 1%>">이전</a>]
					<%
				} else {
				%>
				[<a href="./find_Lists.do?pageNum=<%=currentPage - 1%>">이전</a>]
				<%
			}

		}
				for(int i = startPage; i<=endPage; i++){

		%>

		<a href="<%=ctxPath%>/find_Lists.do?pageNum=<%=i%>"><%=i%></a>
		


		<!-- //여기 나타내는거 -->
		<!-- 다음 -->
		<%
		if(i == pagecount) 
			break;
		}
		if (currentPage >= 1 && currentPage < pagecount) {

		if (currentPage == pagecount) {
	%>
		[<a style="display=none" href="<%=ctxPath%>/find_Lists.do?pageNum=<%=currentPage + 1%>">다음</a>]
	<%
		} else {
		%>
		[<a href="<%=ctxPath%>/find_Lists.do?pageNum=<%=currentPage + 1%>">다음</a>]
		<%
			}

		}

		}

		%>
<script type="text/javascript">
function categorySidoChange(e) {
	var good_a = ["춘천시",
		"원주시",
		"강릉시",
		"동해시",
		"태백시",
		"속초시",
		"삼척시",
		"홍천군",
		"횡성군",
		"영월군",
		"평창군",
		"정선군",
		"철원군",
		"화천군",
		"양구군",
		"인제군",
		"고성군",
		"양양군"];
	var good_b = ["수원시",
		"성남시",
		"안산시",
		"용인시",
		"부천시",
		"광명시",
		"평택시",
		"과천시",
		"오산시",
		"시흥시",
		"군포시",
		"의왕시",
		"하남시",
		"이천시",
		"안성시",
		"김포시",
		"화성시",
		"광주시",
		"여주시",
		"양평군",
		"고양시",
		"의정부시",
		"동두천시",
		"구리시",
		"파주시",
		"양주시",
		"포천시",
		"연천군",
		"가평군"];
	var good_c = ["창원시",
		"진주시",
		"통영시",
		"사천시",
		"김해시",
		"밀양시",
		"거제시",
		"양산시",
		"의령군",
		"함안군",
		"창녕군",
		"고성군",
		"남해군",
		"하동군",
		"산청군",
		"함양군",
		"거창군",
		"합천군"
	];
	var good_d = ["포항시",
		"경주시",
		"김천시",
		"안동시",
		"구미시",
		"영주시",
		"영천시",
		"상주시",
		"문경시",
		"경산시",
		"군위군",
		"의성군",
		"청송군",
		"영양군",
		"영덕군",
		"청도군",
		"고령군",
		"성주군",
		"칠곡군",
		"예천군",
		"봉화군",
		"울진군",
		"울릉군"];
	var good_e = ["동구",
		"서구",
		"남구",
		"북구",
		"광산구"
	];
	var good_f = ["중구",
		"동구",
		"서구",
		"남구",
		"북구",
		"수성구",
		"달서구",
		"달성군"];
	var good_g = ["동구",
		"중구",
		"서구",
		"유성구",
		"대덕구"
	];
	var good_h = ["중구",
		"서구",
		"동구",
		"영도구",
		"부산진구",
		"동래구",
		"남구",
		"북구",
		"강서구",
		"해운대구",
		"사하구",
		"금정구",
		"연제구",
		"수영구",
		"사상구",
		"기장군"];
	var good_i =
		["종로구",
			"중구",
			"용산구",
			"성동구",
			"광진구",
			"동대문구",
			"중랑구",
			"성북구",
			"강북구",
			"도봉구",
			"노원구",
			"은평구",
			"서대문구",
			"마포구",
			"양천구",
			"강서구",
			"구로구",
			"금천구",
			"영등포구",
			"동작구",
			"관악구",
			"서초구",
			"강남구",
			"송파구",
			"강동구"];

	var good_k = [
		"중구",
		"남구",
		"동구",
		"북구",
		"울주군"];
	var good_l = [
		"중구",
		"동구",
		"미추홀구",
		"연수구",
		"남동구",
		"부평구",
		"계양구",
		"서구",
		"강화군",
		"옹진군"
	];
	var good_m = [
		"목포시",
		"여수시",
		"순천시",
		"나주시",
		"광양시",
		"담양군",
		"곡성군",
		"구례군",
		"고흥군",
		"보성군",
		"화순군",
		"장흥군",
		"강진군",
		"해남군",
		"영암군",
		"무안군",
		"함평군",
		"영광군",
		"장성군",
		"완도군",
		"진도군",
		"신안군"];
	var good_n = [
		"전주시",

		"군산시",
		"익산시",
		"김제시",
		"완주군",
		"진안군",
		"무주군",
		"장수군",
		"임실군",
		"순창군",
		"고창군",
		"부안군"];
	var good_o = ["제주시",
		"서귀포시"];
	var good_p = ["천안시",

		"공주시",
		"보령시",
		"아산시",
		"서산시",
		"논산시",
		"계룡시",
		"당진시",
		"금산군",
		"부여군",
		"서천군",
		"청양군",
		"홍성군",
		"예산군",
		"태안군"];
	var good_q = ["청주시",
		"충주시",
		"제천시",
		"보은군",
		"옥천군",
		"영동군",
		"증평군",
		"진천군",
		"괴산군",
		"음성군",
		"단양군"];

	var target = document.getElementById("sigungu");

	if (e.value == "강원도") var d = good_a;
	else if (e.value == "경기도") var d = good_b;
	else if (e.value == "경상남도") var d = good_c;
	else if (e.value == "경상북도") var d = good_d;
	else if (e.value == "광주광역시") var d = good_e;
	else if (e.value == "대구광역시") var d = good_f;
	else if (e.value == "대전광역시") var d = good_g;
	else if (e.value == "부산광역시") var d = good_h;
	else if (e.value == "서울특별시") var d = good_i;

	else if (e.value == "울산광역시") var d = good_k;
	else if (e.value == "인천광역시") var d = good_l;
	else if (e.value == "전라남도") var d = good_m;
	else if (e.value == "전라북도") var d = good_n;
	else if (e.value == "제주특별자치도") var d = good_o;
	else if (e.value == "충청남도") var d = good_p;
	else if (e.value == "충청북도") var d = good_q;

	target.options.length = 0;

	for (x in d) {
		var opt = document.createElement("option");
		opt.value = d[x];
		opt.innerHTML = d[x];
		target.appendChild(opt);
	}
}


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

	  var target = document.getElementById("dog_kind");
	 
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
	
	
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
mapOption = { 
    center: new kakao.maps.LatLng(36.991879423239666, 128.03755800986698), // 지도의 중심좌표
    level: 13 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
//확대 축소
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
var geocoder = new kakao.maps.services.Geocoder();
//마커를 표시할 위치와 title 객체 배열입니다 
var positions = document.getElementsByClassName('address');
var careName = document.getElementsByClassName('careName');
	for(var i=0; i<=positions.length; i++){
	console.log(positions[i]);	
		
	}
	
	for (var i=0; i < positions.length ; i++) {
		geocoder.addressSearch(positions[i].innerText, function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		       
		        var infowindow = new kakao.maps.InfoWindow({
		            content:  '<div style="width:150px;text-align:center;padding:6px 0;"><a href="https://map.kakao.com/link/to/'+careName[i]+',' +coords.Ma+','+ coords.La+'" style="color:blue" target="_blank">길찾기</a></div>'
		        });
		        kakao.maps.event.addListener(marker, 'click', function() {
		            // 마커 위에 인포윈도우를 표시합니다
		            infowindow.open(map, marker);  
		      });
		       
				

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		    } 
		})


		};    
</script>
</body>

</html>
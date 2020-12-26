<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String ctxPath = request.getContextPath(); %>
    <%
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	String id = "hcare";
	String lev = "2";
	request.getSession().setAttribute("id", id);
	request.getSession().setAttribute("lev", lev);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>


<!-- icon(fontawesome) -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- link css -->
<link rel="stylesheet" href="<%=ctxPath %>/css/head_foot.css" />
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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<%=ctxPath %>/js/datepicker-ko.js"></script>
<style type="text/css">
section {
  width: 70%;
	margin: 10vh auto;
	
		
}

table {
	border-collapse: collapse;
	margin-top: 80px;
	
}

table th, td {
	
	text-align: center;
	padding: 5px;

}
th{
border-bottom: 1px solid; 
}

td{
font-size: large;
text-align: left;
}
tr{
border-bottom: 1px solid white;
}

input {
	width: 500px;
	height: 50px;
}
</style>
    <script type="text/javascript">
	function goRegister() {
		var frm = document.fineWriteFrm;
		frm.action = "<%=ctxPath%>/find_fine_manage_write.do";
		frm.method = "post";
		frm.enctype="multipart/form-data";
		frm.submit();
	}
	

	$(function(){

	    $("#happenDt").datepicker({

	    	showOn : "both",

			buttonImage : "<%=ctxPath%>/upload/images/cal.png",

			buttonImageOnly : true,

			buttonText : "Select date"

	   

	       

	    });

	});

	
	</script>



</head>
<body>



<jsp:include page="/common/header.jsp" />
<section>
            <h1>유기견 등록</h1>
            <hr>
<div style="width: 80%; margin: 0 auto;">
 	<form name="fineWriteFrm" style="width:60%; margin: 0 auto;">
            <table>
                    <tr>
                        <td style="text-align: left; background-color: gray;">첨부파일(사진)</td>
                        <td>
                            <input type="file" accept="image/*" name="uploadFile" id="attchFile" multiple>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">발견장소</td>
                        <td><input type="text" id="happenPlace" name="happenPlace"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">나이</td>
                        <td><input type="text" id="age" name="age"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">색깔</td>
                        <td><input type="text" id="colorCd" name="colorCd"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">발견일</td>
                        <td><input type="text" name="happenDt" id="happenDt" size="12" readonly="readonly" style="width: 93%;"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">품종</td>
                        <td><select onchange="categoryChange(this)" style="width: 300px">
							<option value="as">선택해주세요</option>
							<option value="a">초성이 '가' 인가요?</option>
							<option value="b">초성이 '나' 인가요?</option>
							<option value="c">초성이 '다' 인가요?</option>
							<option value="d">초성이 '라' 인가요?</option>
							<option value="e">초성이 '마' 인가요?</option>
							<option value="f">초성이 '바' 인가요?</option>
							<option value="g">초성이 '사' 인가요?</option>
							<option value="h">초성이 '아' 인가요?</option>
							<option value="i">초성이 '자' 인가요?</option>
							<option value="j">초성이 '차' 인가요?</option>
							<option value="k">초성이 '카' 인가요?</option>
							<option value="l">초성이 '타' 인가요?</option>
							<option value="m">초성이 '파' 인가요?</option>
							<option value="n">초성이 '하' 인가요?</option>
							<option value="o">기타</option>
							</select>
							 <br>
							<select id="dog_kind" name="dogKind" style="width: 500px">
							</select><br></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">증성화 여부</td>
                        <td>
                        <select id="neuterYn" name="neuterYn" style="width: 80px;">
                        	<option>Y</option>
                        	<option>N</option>
                        	<option>U</option>
                        </select>
                        </td>
                    </tr>
                  
                    <tr>
                        <td style="text-align: left; background-color: gray;">담당자전화번호</td>
                        <td><input type="text" id="officetel" name="officetel"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">시도 주소</td>
                        <td><input type="text" id="orgNm" name="orgNm"></td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">성별</td>
                        <td>
                        <select id="sexCd" name="sexCd" style="width: 80px;">
                        <option>M</option>	
                        <option>F</option>	
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">특이사항</td>
                        <td><textarea rows="15" cols="70" id="specialMark" name="specialMark"></textarea>
                       </td>
                    </tr>
                    <tr>
                        <td style="text-align: left; background-color: gray;">몸무게</td>
                        <td><input type="text" id="weight" name="weight"></td>
                    </tr>
                

                    
                    <tr>
                        <td colspan="2">
                        	
                        </td> 
                        
                    </tr>        
            </table>
            <div style="width: 100%; text-align: right;" >
            <button type="button" id="BtnRegister" onclick="goRegister()" style="width: 150px; height: 50px;">등록</button>
            <button type="button" id="BtnGoList" onclick="window.location='<%=ctxPath%>/fine_find_manage_List.do'" style="width: 150px; height: 50px;">돌아가기</button>
        	</div>
        </form>
        </div>
  </section>

<script type="text/javascript">



	function categoryChange(e) {
		var good_a = [ "골든 리트리버", "그레이 하운드", "그레이트 덴", "그레이트 피레니즈",
				"꼬똥 드 뚤레아" ];
		var good_b = [ "네오폴리탄 마스티프", "노르포크 테리어", "노리치 테리어", "뉴펀들랜드" ];
		var good_c = [ "닥스훈트", "달마시안", "댄디 딘몬트 테리어", "도고 까니리오", "도고 아르젠티노",
				"도고 아르젠티노", "도베르만", "도사", "동경견" ];
		var good_d = [ "라브라도 리트리버", "라사 압소", "라이카", "래빗 닥스훈드", "랫 테리어",
				"레이크랜드 테리어", "로디지안 리즈백", "로트바일러", "롯트와일러" ];
		var good_e = [ "마리노이즈", "마스티프", "말라뮤트", "말티즈", "맨체스터테리어",
				"미니어쳐 닥스훈트", "미니어쳐 불 테리어", "미니어쳐 슈나우저", "미니어쳐 푸들",
				"미니어쳐 핀셔", "미디엄 푸들", "미텔 스피츠" ];
		var good_f = [ "바센지", "바셋 하운드", "버니즈 마운틴 독", "베들링턴 테리어",
				"벨기에 그로넨달", "벨기에 쉽독", "벨기에 테뷰런", "벨지안 셰퍼드 독", "보더 콜리",
				"보르조이", "보스턴 테리어", "복서", "볼로네즈", "부비에 데 플랑드르", "불 테리어",
				"불독", "브뤼셀그리펀", "브리타니 스파니엘", "블랙 테리어", "비글", "비숑 프리제",
				"비어디드 콜리", "비즐라", "빠삐용" ];
		var good_g = [ "사모예드", "살루키", "삽살개", "샤페이", "세인트 버나드",
				"센트럴 아시안 오브차카", "셔틀랜드 쉽독", "셰퍼드", "슈나우져", "스코티쉬 테리어",
				"스코티시 디어하운드", "스탠다드 푸들", "스테포드셔불테리어", "스피츠", "시바",
				"시베리안 허스키", "시베리안라이카", "시잉프랑세즈", "시츄", "시코쿠", "실리햄 테리어",
				"실키테리어" ];
		var good_h = [ "아나톨리안 셰퍼드", "아메리칸 불독", "아메리칸 스태퍼드셔 테리어",
				"아메리칸 아키다", "아메리칸 에스키모", "아메리칸 코카 스파니엘", "아메리칸 핏불 테리어",
				"아메리칸불리", "아이리쉬 레드 앤 화이트 세터", "아이리쉬 세터", "아이리쉬 울프 하운드",
				"아이리쉬소프트코튼휘튼테리어", "아키다", "아프간 하운드", "알라스칸 말라뮤트", "에어델 테리어",
				"오브차카", "오스트랄리안 셰퍼드 독", "오스트랄리안 캐틀 독", "올드 잉글리쉬 불독",
				"올드 잉글리쉬 쉽독", "와이마라너", "와이어 폭스 테리어", "요크셔 테리어", "울프독",
				"웨스트 시베리언 라이카", "웨스트하이랜드화이트테리어", "웰시 코기 카디건", "웰시 코기 펨브로크",
				"웰시 테리어", "이탈리안 그레이 하운드", "잉글리쉬 세터", "잉글리쉬 스프링거 스파니엘",
				"잉글리쉬 코카 스파니엘", "잉글리쉬 포인터" ];
		var good_i = [ "자이언트 슈나우져", "재패니즈 스피츠", "잭 러셀 테리어", "저먼 셰퍼드 독",
				"저먼 와이어헤어드 포인터", "저먼 포인터", "제주개", "제페니즈칭", "진도견" ];
		var good_j = [ "차우차우", "차이니즈 크레스티드 독", "치와와" ];
		var good_k = [ "카레리안 베어독", "카이훗", "캐벌리어 킹 찰스 스파니엘", "케니스펜더",
				"케리 블루 테리어", "케언 테리어", "케인 코르소", "코리아 트라이 하운드", "코리안 마스티프",
				"코카 스파니엘", "코카 푸", "코카시안오브차카", "콜리", "클라인스피츠", "키슈",
				"키스 훈드" ];
		var good_l = [ "토이 맨체스터 테리어", "토이 푸들", "티베탄 마스티프" ];
		var good_m = [ "파라오 하운드", "파슨 러셀 테리어", "팔렌", "퍼그", "페키니즈",
				"페터데일테리어", "포메라니안", "포인터", "폭스테리어", "푸들", "풀리", "풍산견",
				"프레사까나리오", "프렌치 불독", "프렌치 브리타니", "플랫 코티드 리트리버", "플롯하운드",
				"피레니안 마운틴 독", "필라 브라질레오", "핏불테리어" ];
		var good_n = [ "허배너스", "화이트리트리버", "화이트테리어", "휘펫" ];
		var good_o = [ "기타", "믹스견" ];

		var target = document.getElementById("dog_kind");

		if (e.value == "a")
			var d = good_a;
		else if (e.value == "b")
			var d = good_b;
		else if (e.value == "c")
			var d = good_c;
		else if (e.value == "d")
			var d = good_d;
		else if (e.value == "e")
			var d = good_e;
		else if (e.value == "f")
			var d = good_f;
		else if (e.value == "g")
			var d = good_g;
		else if (e.value == "h")
			var d = good_h;
		else if (e.value == "i")
			var d = good_i;
		else if (e.value == "j")
			var d = good_j;
		else if (e.value == "k")
			var d = good_k;
		else if (e.value == "l")
			var d = good_l;
		else if (e.value == "m")
			var d = good_m;
		else if (e.value == "n")
			var d = good_n;
		else if (e.value == "o")
			var d = good_o;

		target.options.length = 0;

		for (x in d) {
			var opt = document.createElement("option");
			opt.value = d[x];
			opt.innerHTML = d[x];
			target.appendChild(opt);
		}
	}
	
	</script>
	<jsp:include page="/common/footer.jsp" />	
    </body>
    
    </html>
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


<!-- icon(fontawesome) -->
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- link css -->
<link rel="stylesheet" href="<%=ctxpath %>/css/head_foot.css" />
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<%=ctxpath%>/js/datepicker-ko.js"></script>
<style type="text/css">
section {
  width: 70%;
	margin: 10vh auto;	
}
.ui-datepicker{ font-size: 40px; width: 100%;  }
.ui-datepicker select.ui-datepicker-month{ width:50%; font-size: 40px; }
.ui-datepicker select.ui-datepicker-year{ width:50%; font-size: 40px; }
</style>
<script>
$(function(){

    $("#datepicker").datepicker({

    	    dateFormat: 'yymmdd',
    	    onSelect: function (date) {
    		var reservationDate = date;
    		console.log(reservationDate);
    	 	document.getElementById("date").value = reservationDate;
    	
    		}

    });

});


function goFindSearch() {
	var frm = document.reservationFrm;
	frm.action = "<%=ctxpath%>/Reservation.do";

		frm.method = "get";
		frm.submit();
	}
</script>


</head>
<body>
<jsp:include page="/common/header.jsp" />
<section>
<div style=" width:100%; text-align: center;">
	<h1 style="font-size: 40px;" >입양예약</h1>
</div>
<br>
<br>
<hr>
<br>
<br>
	<c:if test="${not empty list}">
		<c:forEach items="${ list }" var="mvo" varStatus="s">
			<form name="reservationFrm">
				<div>
					<input type="hidden" value="${mvo.desertionNo }" name="dogNum">
					<!-- 가져가기 -->
					<input type="hidden" id="careName" name="careName" value="${mvo.careNm}"> <input
						type="hidden" id="address" value="${mvo.careAddr}">
				</div>

				<div>
					<div id="datepicker" style="width: 100%; "></div>
					<br>
<br>
<hr>
<br>

					
						<div style="font-size: 20px; margin-bottom: 20px;">
					<c:if test="${not empty lists }">
						<c:forEach items="${lists }" var="mvo" step="1">

							<h4 style="display: inline;">아이디</h4> : ${mvo.id }
							<br>
							<!-- 가져가기 -->
							<h4 style="display: inline;">성명</h4> : ${mvo.name }
							<br>
							<h4 style="display: inline;">주소</h4> : ${mvo.address }
							<br>
							<h4 style="display: inline;">핸드폰 번호</h4> : ${mvo.phone }
							<br>
							<h4 style="display: inline;">예약날짜 : </h4><input type="text" id="date" name="date" readonly="readonly"
							required="required" /><br>
						</c:forEach>
					</c:if>
					</div>
					<!-- 가져가기 -->
					<input type="checkbox" name="agree" required="required"><label
						for="agree">(필수)아래의 약관을 읽어보시고 동의를 눌러주세요.</label> <br>
					<div
						style="width: 100%; height: 200px; overflow: scroll; border: 1px solid; background-color: #F2F2F2">
						1 개인정보의 처리 목적<br> ① FINE은(는) 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의
						목적 이외의 용도로는 이용하지 않습니다.<br> 고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인
						식별·인증, 회원자격 유지·관리, 물품 또는 서비스 공급에 따른 금액 결제, 물품 또는 서비스의 공급·배송, 마케팅 및
						광고에의 활용<br> 2 개인정보의 처리 및 보유 기간 작성<br> ① FINE은(는) 정보주체로부터
						개인정보를 수집할 때 동의 받은 개인정보 보유·이용기간 또는 법령에 따른 개인정보 보유·이용기간 내에서 개인정보를
						처리·보유합니다.<br> ② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다.<br> 고객
						가입 및 관리 : 서비스 이용계약 또는 회원가입 해지시까지, 다만 채권·채무관계 잔존시에는 해당 채권·채무관계
						정산시까지<br> 전자상거래에서의 계약·청약철회, 대금결제, 재화 등 공급기록 : 5년<br> 3
						정보주체와 법정대리인의 권리·의무 및 그 행사방법<br> 정보주체는 FINE에 대해 언제든지 다음 각 호의
						개인정보 보호 관련 권리를 행사할 수 있습니다.<br> 1. 개인정보 열람요구<br> 2. 오류 등이
						있을 경우 정정 요구<br> 3. 삭제요구<br> 4. 처리정지 요구<br> 4 처리하는
						개인정보 항목<br> 개인정보 처리업무: 홈페이지 회원가입 및 관리, 민원사무 처리, 재화 또는 서비스 제공,
						마케팅 및 광고에의 활용<br> 필수항목: 로그인ID, 비밀번호, 서비스 이용 기록, 접속 로그, 쿠키, 접속
						IP 정보, 결제기록<br> 선택항목: 이메일, 성별, 이름<br> 5 개인정보의 파기<br>
						파기절차<br> 이용자가 입력한 정보는 목적 달성 후 별도의 DB에 옮겨져(종이의 경우 별도의 서류) 내부
						방침 및 기타 관련 법령에 따라 일정기간 저장된 후 혹은 즉시 파기됩니다. 이 때, DB로 옮겨진 개인정보는 법률에
						의한 경우가 아니고서는 다른 목적으로 이용되지 않습니다.<br> 파기기한<br> 이용자의 개인정보는
						개인정보의 보유기간이 경과된 경우에는 보유기간의 종료일로부터 5일 이내에, 개인정보의 처리 목적 달성, 해당 서비스의
						폐지, 사업의 종료 등 그 개인정보가 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 5일
						이내에 그 개인정보를 파기합니다.<br> 6 개인정보 자동 수집 장치의 설치·운영 및 그 거부에 관한 사항<br>
						① FINE은 개별적인 맞춤서비스를 제공하기 위해 이용정보를 저장하고 수시로 불러오는 ‘쿠키(cookie)’를
						사용합니다.<br> ② 쿠키는 웹사이트를 운영하는데 이용되는 서버(http)가 이용자의 컴퓨터 브라우저에게
						보내는 소량의 정보이며 이용자들의 컴퓨터 내의 하드디스크에 저장되기도 합니다.<br> 가. 쿠키의 사용 목적
						: 이용자가 방문한 각 서비스와 웹 사이트들에 대한 방문 및 이용형태, 인기 검색어, 보안접속 여부, 등을 파악하여
						이용자에게 최적화된 정보 제공을 위해 사용됩니다. 나. 쿠키의 설치·운영 및 거부 : 웹브라우저 상단의 도구>인터넷
						옵션>개인정보 메뉴의 옵션 설정을 통해 쿠키 저장을 거부 할 수 있습니다.<br> 다. 쿠키 저장을 거부할
						경우 맞춤형 서비스 이용에 어려움이 발생할 수 있습니다.<br> 7 개인정보 보호책임자<br> 이름:
						홍길동<br> 소속: 운영팀<br> 전화: 02-1234-5678<br> 이메일:
						john.smith@example.com<br> 8 개인정보의 안전성 확보 조치<br> 개인정보의
						암호화<br> 이용자의 비밀번호는 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는
						파일 및 전송 데이터를 암호화 하거나 파일 잠금 기능을 사용하는 등의 별도 보안기능을 사용하고 있습니다.<br>
						9 개인정보처리방침의 변경<br> 이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른 변경내용의
						추가, 삭제 및 정정이 있는 경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.<br>
						공고일자 : 2000년 00월 00일<br> 시행일자 : 2000년 00월 00일
					</div>
					<br>
					<!-- 가져가기 -->
					<input type="checkbox" name="agree" required="required" value="ssss"><label
						for="agree">(필수)미성년자는 보호자의 허락을 맡고 동의를 눌러주세요.</label><br>
					<div
						style="width: 100%; height: 200px; overflow: scroll; border: 1px solid; background-color: #F2F2F2">
						1.미성년자의 조건<br> 미성년자(未成年者, minor)는 대한민국 민법상으로는 만 19세에 달하지 않은
						자를 말한다.<br> (대한민국 민법 제4조) 연령은 출생일을 산입하여 역(歷)에 따라 계산한다.<br>
						(대한민국 민법 제158조) 성년기를 선고하는 입법례로는, 스위스민법의 성년선고제도 및 프랑스민법의 자치산제도 등이
						있다.<br> 대한민국 민법에서 미성년자는 혼인에 의하여 성년으로 의제(간주)되므로(제826조의 2), 혼인의
						성립과 동시에 미성년자는 성년자와 같은 능력을 가진다.<br> 성년의제는 법률혼에 한정된다. 그러나
						공직선거법, 청소년보호법(19세미만), 근로기준법 등의 적용에서는 여전히 미성년자이다.<br> 한편 대한민국
						형법상 미성년자는 만14세 미만인 자를 이르며(대한민국 형법 제9조), 책임능력이 없는 것으로 간주된다.<br>
						2.부모님 동의 조건<br> 부모님의 동의가 없을 시 유기견 입양은 취소되며 유기견을 입양하러 올 때 부모님을
						모시고 오지 않으면 입양에 제한이 있습니다<br> 이를 어길 시 최대 30만원의 벌금이 있슴을 고지합니다.<br>

					</div>
					<br>
					<div style="width: 100%; text-align: right;" >
					
						<!-- 입력 서블릿으로 갈 버튼 -->
						<button onclick="goFindSearch()" style="width: 150px; height: 50px;">입양결정</button>
						<!--1단계뒤로-->
						<button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/fine_find_manage_List.do'" style="width: 150px; height: 50px;">돌아가기</button>
					</div>
				</div>
			</form>
		</c:forEach>
	</c:if>
	</section>
	<jsp:include page="/common/footer.jsp" />	
</body>
</html>
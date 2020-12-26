<!DOCTYPE html>
<%@page import="fine.community.quiz.model.QuizVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String ctxPath = request.getContextPath();
%>

<!-- <!DOCTYPE html> -->
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/333b7ab4b4.js"></script>
<script src="../js/jquery-3.5.1.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<script type="text/javascript">
function qanswer(aaa){
	if(aa==-1){
		//cnt에 value를 -1;
	} else  {
		//cnt value 1로 채우고 
}
	frm.action="<%=ctxPath%>/quiz_List_user.do";
	frm.method="post";
	frm.submit();
}
</script>
	<!-- /* 토글 버튼 이벤트 */ -->
<script src="./js/main.js" defer></script>


<style>

#h_title {
	font-size:35px;
	margin-bottom: 6vh;
	font-family: 'Jua', sans-serif;
}


.quizForm {
	padding-top: 120px;
	max-width: 1000px;
	max-height: 1500px;
	padding-bottom: 30px;
	border: 2px solid #ddd;
	margin: 0 auto;
	position: relative;
	z-index: 1;
	 width: 100%;
    text-align: center;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    border-spacing: 100px;
}

.quizForm::after {
	width: 100%;
	height: 100%;
	content: "";
	background: url("./img/dog.jpg");
	position: absolute;
	top: 0;
	left: 0;
	z-index: -1;
	opacity: 0.5;
}

div {
	display: block;
}

ul {
	list-style: none;
}



.quiztitle {
	margin: 100px; 100 px;
	position: relative;
	bottom: 150px;
}

.title {
	font-size: 70px;
}

.a_03 {
	text-align: right;
	position: relative;
	left: -50px;
	bottom: 50px;
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

#qcont {
	width:100%;
	position: relative;
    left: 50%;
    transform: translate(-50%);
    margin-top: 100px;
    font-family: 'Roboto', sans-serif;
	-webkit-font-smoothing: antialiased;
	text-align: center;
}



#qcont_01 {
	display : none;
	margin: 20px 0; 
}

/* 퀴즈문제 */
#qcont_02 {
	font-weight:bold;
	margin: 20px 0; 
	text-align: center;
	font-size: 35px;
	font-family: 'Jua', sans-serif;

}

/* OX버튼 */
#qcont_03 {
	display: inline-flex;
	margin: 20px; 
	margin-left: -30px;
	
}

/* 이전, 다음 버튼 */
#qcont_04 {
	padding: 120px;
	margin-left: -60px;

}

input[type=radio]:checked + #ans1 { background:#1d62e1;}
input[type=radio]:checked + #ans2 { background:#ff4750;}

input[type="radio"] {	
	position: absolute;
	top: 0;
	left: 0;
	z-index: -999;
	height: 1px;
	opacity: 0;
}
#ans1, #ans2 {
	display: inline-block;
    width: 200px;
    height: 200px;
    line-height: 180px;
    margin: 0 10px;
    font-size: 200px;
    font-weight: bold;
    color: #fff;
    background: #177160;
    border-radius: 50%;
    text-align: center;
    cursor: pointer;
   
}
#ans1.on{color:#fff200;}

button {
font-size: 25px;
cursor: pointer;
padding: 12px 30px;
}

button {
  border-radius: 4px;
  background-color: #c1a18a;
  border: none;
  color:white;
  text-align: center;
  font-size: 20px;
  padding: 10px;
  width: 100px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  font-family: 'Jua', sans-serif;
}

button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

#nextBtn span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

#prevBtn span:before {
  content: '\00ab';
  position: absolute;
  opacity: 0;
  top: 0;
  left: -20px;
  transition: 0.5s;
}

#nextBtn:hover span {
  padding-right: 25px;
}

#prevBtn:hover span {
  padding-left: 25px;
}

#nextBtn:hover span:after {
  opacity: 1;
  right: 0;
}

#prevBtn:hover span:before {
  opacity: 1;
  left: 0;
}


</style>
</head>
<body>
<!-- header -->
<jsp:include page="/common/header.jsp" />
	<!--Section -->
	<section id="section">
		<%
			if (session.getAttribute("quizlist") == null) {
			response.sendRedirect(ctxPath + "/quiz_List_user.do"); // 예외처리  
			} else {
			List<QuizVO> quizlist = (List<QuizVO>) session.getAttribute("quizlist");
			System.out.println("jsp로 가져옴");
			int count = (int) session.getAttribute("count");

			if (!(count >= 0 && count <= 9)) {
				response.sendRedirect(ctxPath + "/quiz_List_user.do"); // 예외처리  
			} else { // 정상 케이스 아래
				QuizVO vo = quizlist.get(count);
		%>
		<div>
			<h1 id ="h_title" style="text-align: center; margin-top: 15px;"><%=count+1%>/10 문제</h1>
			
			<form id = "quizfrm">
				<div id="qcont">
					<div id = "qcont_01">
						<h3>글내용</h3>
					</div>
					<div id = "qcont_02">
						<%=vo.getQuiz_content()%>
					</div>
					<div id="qcont_03">
						<input type="radio" name="q_answer" id="answer1" value="0" > <label for="answer1" id="ans1" style="margin:50px 50px 0 0;"> O </label> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						 <input type="radio" name="q_answer" id="answer2" value="1"> <label for="answer2" id="ans2" style="margin:50px 0 0 50px;"> X </label>
					</div>
					<div id="qcont_04">
						<input type="hidden" name="cnt" id="cnt">
							<button name="prev" id="prevBtn" onclick="goSubmit(-1);" style="margin-right:10px"><span>이전</span></button>
							<button name="next" id="nextBtn" onclick="goSubmit(1);"style="margin-left:10px"><span>다음</span></button>
					</div>
				</div>
			</form>
		</div>

		<%
			}
		}
		%>

<script>
	function goSubmit(pos){
		if(pos==-1){
			console.log("aa"+pos);
			$("#cnt").val("-1");
		} else  {
			console.log("bb"+pos);
			$("#cnt").val("1");
			
		}
		frm.action="<%=ctxPath%>/quiz_List_user.do";
		frm.method = "post";
		frm.submit();
	}
</script>
	</section>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
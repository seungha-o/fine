<%@page import="fine.community.training.model.TrainingDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	
<style>



/* Section */
.h_title {
	margin-bottom: 6vh;
	font-family: 'Jua', sans-serif;
}

#trainingDetailFrm {
	text-align: center;
	margin: 10vh auto;
}

#trainingDetailTable {
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width: 40%;
    text-align: center;
    margin: 0 auto;
    border: 2px solid #A4A4A4;
    font-size: 15px;
}
#trainingDetailTable td, #trainingDetailTable th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
}

#tdTran_no, #tdTitle, #tdCont, #tdFile {
	background-color: #F2F2F2;
	font-weight: bold;
	font-size: 16px;
}


#btnListUpDel {
	width: 60%;
	display: inline; 
 	text-align: center;
	padding:10px;
	margin-top: 6vh;
}

#BtnGoList, #BtnUpdate, #BtnDelete {
  background-color: #E6E6E6; 
  border: none;
  color: black;
  padding:5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin-top :10px;
  /* margin: 1px 1px; */
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
  font-family: 'Jua', sans-serif;
}
#BtnGoList:hover {
	background-color: #848484;
	color:white;
}

#BtnUpdate:hover {
	background-color: #848484;
	color:white;
}
#BtnDelete:hover {
	background-color: #848484;
	color:white;
}
</style>

</head>
<body>
  <!-- header -->
<jsp:include page="/common/header.jsp" />
<!--Section -->  
	<form method="get" id="trainingDetailFrm">
       <h1 class="h_title">관리자 글 상세페이지</h1>
          <c:if test="${not empty list}">
		  <c:forEach items="${ list }" var="mvo" varStatus="s">
          
          <div id = "trainingDetailTbl">
            <table id ="trainingDetailTable">
            		<tr>
                        <td id="tdTran_no">글번호</td>
                        <td>${mvo.trn_no}</td>
                    </tr>
                    <tr>
                        <td id="tdTitle">글제목</td>
                        <td>${mvo.trn_title}</td>
                    </tr>
                    <tr>
						<td id="tdCont">글내용</td>
                        <td>${mvo.content}</td>
                    </tr>
                    <tr>
                        <td id="tdFile">첨부파일</td>
                        <td>
                           <video id="before_video" controls style="width: 320px; height: 240px;">
							<source src="./upload/${mvo.media }" type="video/mp4">
						</video>
                        </td>
                    </tr>
            	</table>
            </div>
            <div id="btnListUpDel">
               <button type="button" id="BtnGoList" onclick="window.location='<%=ctxPath%>/trmListManager.do'">글목록</button>
               <button type="button" id="BtnDelete" onclick="window.location='<%=ctxPath%>/trainingUpdateInfo.do?no=${mvo.trn_no}'">수정</button>
               <button type="button" id="BtnDelete" onclick="window.location='<%=ctxPath%>/trainingDelete.do?no=${mvo.trn_no}'">삭제</button>
           </div>        
       	 </c:forEach>
		</c:if>
   	</form> 
   	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
   </body>
   </html>
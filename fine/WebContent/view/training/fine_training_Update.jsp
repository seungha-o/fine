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

#trainingUpdateFrm {
	text-align: center;
	margin: 10vh auto;
}

#traingUpdateTable {
	font-family: 'Jua', sans-serif;
  	border-collapse: collapse;
  	width:40%;
    text-align: center;
    margin: 0 auto;
    border: 2px solid #A4A4A4;
    font-size: 15px;
}
#traingUpdateTable td, #traingUpdateTable th {
	padding: 30px;
	text-align: center;
	border: 1px solid #ddd;
}

#tdTitle, #tdCont,#tdFile, #tdFileDetail {
	background-color: #F2F2F2;
	font-weight: bold;
	font-size: 16px;
}

#title {
	width:100%;
	/* height:50px; */
	border: 1px solid gray;
	font-size: 18px;

}
#content {
 	width:100%;
	height:200px;
	border: 1px solid gray;
	font-size: 18px;
}

#btnSubCan {
	width: 60%;
	display: inline; 
 	text-align: center;
	padding:10px;
	margin-top: 6vh;
}
#BtnSubmit, #BtnGoList {
  background-color: #E6E6E6; 
  border: none;
  color: black;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
 /*  margin: 1px 1px; */
 margin-top :10px;
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
  font-family: 'Jua', sans-serif;
}
 #attchFile {
  border: none;
  color: black;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 1px 1px;
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
 
 }
 #clearFile {
  border: 1px solid gray;
  color: black;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 1px 1px;
  padding: 3px;
  cursor: pointer;
  border-radius: 4px;
  transition: .2s ease-in;
 }
 #clearFile:hover {
 	background-color: #ddd;
 }
#BtnSubmit:hover {
	background-color: #848484;
	color:white;
}

#BtnGoList:hover {
	background-color: #848484;
	color:white;
}
/* #image_containers input[type="file"]+#attchFile {
	width:320px;
	height: 240px;
} */


</style>
</head>
<body>
<!-- header -->
<jsp:include page="/common/header.jsp" />
			<!--Section -->
            <c:if test="${not empty list}">
				<c:forEach items="${ list }" var="mvo" varStatus="s">
	 	<form id="trainingUpdateFrm" action = "<%=ctxPath%>/trainingUpdate.do?no=${mvo.trn_no}" method = "POST" enctype="multipart/form-data">
	            <h1 class="h_title">관리자 글 수정페이지</h1>
				<div id = "trainingUpdateTbl">
						<table id ="traingUpdateTable" >
		                    <tr>
		                        <td id="tdTitle">글제목</td>
		                        <td><input type="text" id="title" name="title" value="${mvo.trn_title}" required="required"></td>
		                    </tr>
		                    <tr>
		                        <td id="tdCont">글내용</td>
		                        <td><textarea rows="3" cols="50"  name="content" id="content" required="required">${mvo.content }</textarea></td>
		                    </tr>
		                    <tr>
			                    <td id="tdFile">첨부된 영상</td>
			                    <td>
			                    <div id="image">
			                    <video id="before_video" controls style="width: 320px; height: 240px;" >
									<source src="./upload/${mvo.media }" type="video/mp4">
								</video>	
								</div> 
		                    </tr>
		                    
		                    <tr>
		                        <td id="tdFileDetail">수정할 동영상
		                        </td>
		                        <td>
		                        <div id="image_containers" >
		                       	   <input type="file" style="width: 320px; height: 240px;" accept="video/*" name="uploadFile" id="attchFile" onchange="setThumbnail(event)">
		                        </div>
		                           <button type="button" id="clearFile">초기화</button><br>수정하실 동영상이 없다면 하단의 수정하기버튼을 눌러주세요
		                        </td>
		                    </tr>
	            	</table>
	            </div>
	                   <div id = "btnSubCan">
	                        <input type="submit" id="BtnSubmit" value="전송"/>
	                        <button type="button" id="BtnGoList" onclick="window.location='<%=ctxPath%>/trmListManager.do'">글목록</button>
	                    </div>        
	        </form>
            	</c:forEach>
			</c:if>

<script type="text/javascript">

var deleteImg = $("#training_img").attr("src");

		$('#clearFile').click(function(){
	 	$('#currVideo').attr("src","");
	 	$('#attchFile').val('');
	});
	
function setThumbnail(event) {
	var reader = new FileReader(); 
	reader.onload = function(event) {
		var video = document.createElement("video");
		video.setAttribute("id", "currVideo");
		video.setAttribute("controls","controls");
		var source = document.createElement("source");
		source.setAttribute("src", event.target.result);
		source.setAttribute("type", "video/mp4");
		document.querySelector("div#image_containers").appendChild(video).appendChild(source); 
		}; 
		reader.readAsDataURL(event.target.files[0]); 
}

	</script>
	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
    </body>
    
    </html>
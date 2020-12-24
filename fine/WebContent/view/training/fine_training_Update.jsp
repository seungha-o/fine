
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>Document</title>
<style>
table {
    border-collapse: collapse;
}

table tr, th, td {
    border: 1px solid black;
    text-align: center;
    padding:5px;



</style>




<%-- <script type="text/javascript">
	function goRegister() {
		var frm = document.trainingWriteFrm;
		frm.action = "<%=ctxPath%>/trainingUpdate.do";
		frm.method = "post";
		frm.enctype="multipart/form-data";
		frm.submit();
	}
	</script> --%>



</head>
<body>



            <c:if test="${not empty list}">
				<c:forEach items="${ list }" var="mvo" varStatus="s">
	 	<form action = "<%=ctxPath%>/trainingUpdate.do?no=${mvo.trn_no}" method = "POST" enctype="multipart/form-data">
	            <h4>관리자 글쓰기</h4>
					
	            <table>
	                    <tr>
	                        <td>글제목</td>
	                        <td><input type="text" id="title" name="title" value="${mvo.trn_title}" required="required"></td>
	                    </tr>
	                    <tr>
	                        <td>글내용</td>
	                        <td><textarea rows="3" cols="50"  name="content" required="required">${mvo.content }</textarea></td>
	                        
	                    </tr>
	                    <tr>
	                    
	                    <td>첨부된 영상</td>
	                    <td>
	                    <div id="image">
	                    <video id="before_video" controls >
							<source src="./upload/${mvo.media }" type="video/mp4">
						</video>	
						</div> 
	                    </tr>
	                    
	                    <tr>
	                        <td>수정할 동영상<br>
	                        	수정하실 동영상이 없다면<br>
	                        	하단의 수정하기버튼을 눌러주세요
	                        </td>
	                        <td>
	                        <div id="image_containers"></div>
	                        <input type="file" accept="video/*" name="uploadFile" id="attchFile" onchange="setThumbnail(event)">                        
	           	
	                           <button type="button" id="clearFile">초기화</button>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="2">
	                        <input type="submit" value="전송"/>
	                        <button type="button" id="BtnGoList" onclick="window.location='<%=ctxPath%>/trmListManager.do'">글목록</button>
	                        </td> 
	                    </tr>        
	            </table>
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
    </body>
    
    </html>
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
#h_title {
	font-size: 40px;
	font-family: 'Jua', sans-serif;

}

#training_content {
	display: flex;
	justify-content: space-around;
	align-items: center;
	width: 100%;
	height: 100%;
}

.training_content_side {
}

video {
	width: 700px;
	height: 100%;
}

.training_content_center_info{
	display: flex;
}

p {
	font-family: 'Jua', sans-serif;
}

#training_content_center_comment{
	font-family: 'Jua', sans-serif;
}

</style>
</head>
<body>
  <!-- header -->
<jsp:include page="/common/header.jsp" />
<!--Section -->  
	<section id="section">
		<div id="training_content">
			<div class="training_content_side">
			<%
			int count = (int)request.getAttribute("count");
			int currentPage = (int)request.getAttribute("currentPage");
			int endPage = (int)request.getAttribute("endPage");
			int startPage = (int)request.getAttribute("startPage");
			int pagecount = (int)request.getAttribute("pagecount");
				if (count > 0) {
				 
					if (currentPage > 0 || endPage < pagecount) {
					if(currentPage == startPage){
			%>
				<a href="<%=ctxPath%>/training_list.do?pageNum=<%=startPage%>"><img src="./img/nac.png" alt="사진없음"></a>
				<%	
					}else{
					
						%>
						<a href="<%=ctxPath%>/training_list.do?pageNum=<%=currentPage-1%>"><img src="./img/nac.png" alt="사진없음"></a>
						<%
					}
				}
				
				%>
			</div>
			<c:if test="${not empty list}">
            <c:forEach items="${ list }" var="mvo" varStatus="s">
			<div id="training_content_center">
				<div id="training_content_center_header"
					style="text-align: center; width: 700px; height: 100%; margin:50px 0 50px 0;">
					<h1 id=h_title>${mvo.trn_title}</h1>
				</div>
				<div id="training_content_center_info">
					<p class="training_content_center_text">${mvo.write_date}</p>
					<p class="training_content_center_text">관리자</p>
				</div>
				
				<div id="training_content_center_media"
					style="width: 700px; height: 100%; margin-bottom: 50px;">
					<div style="width: 100%; height: 400px">
						<video controls>
							<source src="./upload/${mvo.media }" type="video/mp4">
						</video>
					</div>
				</div>
				<div id="training_content_center_comment"
					style="text-align: center; width: 700px; height: 100%; margin-bottom: 50px;">
					${mvo.content }
					</div>

			</div>
			</c:forEach>
         </c:if>
			<div class="training_content_side">
			
		<%	
	
					if (currentPage > 0 || endPage < pagecount) {
					if(currentPage == endPage){
			%>
				<a href="<%=ctxPath%>/training_list.do?pageNum=<%=endPage%>"><img src="./img/navigater.png" alt="사진없음"></a>
				<%	
					}else{
					
						%>
						<a href="<%=ctxPath%>/training_list.do?pageNum=<%=currentPage+1%>"><img src="./img/navigater.png" alt="사진없음"></a>
						<%
					}
				}
			}
		
				%>
		
			</div>
		</div>
	</section>
	   	<!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
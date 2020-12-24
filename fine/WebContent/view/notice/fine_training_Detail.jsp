
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxpath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap" rel="stylesheet">
    <title>Document</title>
<style>
table {
    border-collapse: collapse;
}

table tr, th, td {
    border: 1px solid black;
    text-align: center;
    padding:5px;
    
}

</style>

</head>
<body>
    
<form method="get">
            <h4>관리자 글상세</h4>
                 	<c:if test="${not empty list}">
					<c:forEach items="${ list }" var="mvo" varStatus="s">
            <table>
       
            		<tr>
                        <td>글번호</td>
                        <td>${mvo.trn_no}</td>
                    </tr>
                    <tr>
                        <td>글제목</td>
                        <td>${mvo.trn_title}</td>
                    </tr>
                    <tr>
                        <td>글내용</td>
                        <td>${mvo.content}</td>
                    </tr>
                    <tr>
                        <td>첨부파일(동영상)</td>
                        <td>
                           <video id="before_video" controls >
							<source src="./upload/${mvo.media }" type="video/mp4">
						</video>
                        </td>
                    </tr>
                  
                    <tr>
                    
                        <td colspan="2">
                        <button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/trmListManager.do'">글목록</button>
                       <button type="button" id="BtnDelete" onclick="window.location='<%=ctxpath%>/trainingUpdateInfo.do?no=${mvo.trn_no}'">수정</button>
                        <button type="button" id="BtnDelete" onclick="window.location='<%=ctxpath%>/trainingDelete.do?no=${mvo.trn_no}'">삭제</button>
                        
                        </td> 
                    </tr>        
            </table>
       	 </c:forEach>
				</c:if>
   </form> 
    </body>
    
    </html>
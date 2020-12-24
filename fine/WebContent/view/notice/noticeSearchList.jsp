<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href = "css/index.css ">
<meta charset="UTF-8">
<script type="text/javascript">
   function doSearch() {
      let form = document.search;
      form.action = "noticeSearch.do";
      form.method = "post";
      form.submit();
   }
</script>
<style>
table {
  border-collapse: collapse;
	text-align : center;
	margin : auto;
	width : 1200px;
}
table th, td {
  text-align: left;
  padding: 8px;
}
table tr:nth-child(even){background-color: #ECECAE}
table a {padding : 0; color : black;}
table a:hover {color: hsl(167, 49%, 35%)!important; }
form { 
margin: 0 auto; 
width:100%;
padding : 20px; 
}
</style>
<title>notice search list</title>
</head>
<body>
<%@ include file="/common/header.jsp" %>
<section id="section">
<form name="search">
      <input type="text" name="title" id="title" placeholder="제목"> <input
         type="submit" id="submit" value="검색" onclick="doSearch()">
   </form>
 	<table width="500" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <th>글 번호</th>
         <th>작성자</th>
         <th>제목</th>
         <th>작성일</th>
         <th>조회수</th>
      </tr>
      <c:if test="${ not empty list }">
         <c:forEach items="${list}" var="list" varStatus="s">
            <tr>
               <td>${s.count}</td>
               <td>${list.id}</td>
               <td><a href="noticeDetail.do?notice_no=${list.notice_no}">${list.notice_title}</a>
               </td>
               <td>${list.notice_write_date }</td>
               <td>${list.notice_count }</td>
            </tr>
         </c:forEach>
      </c:if>
      <tr>
         <td colspan="5"><a href="notice/noticeWrite.jsp">글작성</a></td>
         <td>&nbsp;&nbsp;<a href="noticeList.do">목록보기</a></td>
      </tr>
   </table>
   <!--페이징 아래 숫자-->
   <div class="pagediv">
      <c:if test="${startPage != endPage}">
         <c:forEach varStatus="s" begin="${startPage}" end="${endPage}" step="1">
               <a href="noticeSearch.do?pageNum=${s.count}&title=${word}">${s.count}</a>
         </c:forEach>
      </c:if>
   </div>
	</section>
		<%@ include file="/common/footer.jsp" %>
</body>
</html>
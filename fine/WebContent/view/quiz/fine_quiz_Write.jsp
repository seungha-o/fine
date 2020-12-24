<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String ctxPath = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <script type="text/javascript">
	function goRegister() {
		var frm = document.quizWriteFrm;
		frm.action = "<%=ctxPath%>/quizWrite.do";
		frm.method = "post";
		frm.submit();
	}
	</script>



</head>
<body>



 	<form name="quizWriteFrm">
            <h4>관리자 글쓰기</h4>
            <table>
                    <tr>
                        <td>작성자</td>
                        <td><textarea rows="3" cols="50" placeholder="1000자이하 입력" id="content" name="content"></textarea></td>
                   
                        
                    </tr>
                     <tr>
                        <td>정답</td>
                        <td><select id="answer" name="answer" >
                        	<option>O</option>
                        	<option>X</option>
                        </select>
 						</td>                       
                    </tr>
                    <tr>
                        <td colspan="2">
                        <button type="button" id="BtnRegister" onclick="goRegister()">등록</button>
                   
                        <button type="button" id="BtnCancel">취소</button>
                        </td> 
                    </tr>        
            </table>
        </form>
  


    </body>
    
    </html>
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
<title>정보 탈퇴시 비밀번호 체크</title>
<script src="https://kit.fontawesome.com/333b7ab4b4.js"
	crossorigin="anonymous"></script>
<!-- link jQuery -->

<!-- link css -->
<link rel="stylesheet" href="<%=ctxPath%>/css/head_foot.css" />
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
<script type="text/javascript">
function pwCheck() {
	var pwck = document.delpwCheckform
	pwck.action = "<%=ctxPath%>/delete.do";
	pwck.method = "POST";
	pwck.submit();
}
</script>
  <style>
 * {
   margin: 0;
}

body {
   max-width: 100%;
   height: 100%;
   margin: auto;
   font-family: 'Source Sans Pro ';
}

/*  #header {
   background-color: rgb(175, 230, 209);
   width: 100%;
   height: 100%;
}  */ 

#section {
   background-color:  #f5f7f8;
   width: 100%;
   height: 100%;
}
html {
   background: #f5f7f8;
   font-family: 'Roboto', sans-serif;
   -webkit-font-smoothing: antialiased;
   padding: 20px 0;
}
.section_head {
   margin-bottom: 10px;
}
a {
   text-decoration: none;
   color: #fdfbfa;
}
.navbar {
   /* 아이콘 나란히 */
   display: flex;
   justify-content: space-between;
   align-items: center;
   background-color: hsl(167, 49%, 35%);
   padding: 8px 12px;
}
.navbar_logo {
   font-size: 24px;
   color: white;
}
.navbar_logo i {
   color: #d49466;
}
.navbar_menu {
   border: 1px solid white;
   display: flex;
   list-style: none;
   padding-left: 0;
   padding: 40px, 40px;
}
.navbar_menu li {
   padding: 8px 12px;
}
.navbar_menu li:hover {
   background-color: #d49466;
   border-radius: 4px;
}
.navbar_icons {
   list-style: none;
   color: white;
   display: flex;
   padding-left: 0;
}
.navbar_icons li {
   padding: 8px 12px;
}
@media screen and (max-width: 768px) {
   .navbar {
      flex-direction: column;
      align-items: flex-start;
      padding: 8px 24px;
   }
   .navbar_menu {
      flex-direction: row;
      align-items: center;
      width: 100%;
   }
   .navbar_menu a {
      display: inline;
   }
   .navbar_icons {
      justify-content: center;
      width: 100%;
   }
}
h1 {
   font-size: 20px;
   margin: 0;
   color: #333;
}
.card span {
   font-size: 12px;
   font-weight: bold;
   color: #999;
   text-transform: uppercase;
   letter-spacing: .05em;
   margin: 2em 0 0 0;
}
.band {
   width: 100%;
   max-width: 1240px;
   margin: 0 auto;
   display: grid;
   grid-template-columns: 1fr;
   grid-template-rows: auto;
   grid-gap: 20px;
}

.card {
   background: #fff;
   text-decoration: none;
   color: #444;
   box-shadow: 0 2px 5px rgba(0, 0, 0, .1);
   display: flex;
   min-height: 100%;
   flex-direction: column;
   justify-content: space-between;
   position: relative;
   top: 0;
   transition: 0.2s;
}
.card:hover {
   top: -2px;
   box-shadow: 0 4px 5px rgba(0, 0, 0, .2);
}

.thumb {
   padding-bottom: 60%;
   background-size: cover;
   background-position: center center;
}

article {
   flex: 1;
   display: flex;
   flex-direction: column;
   justify-content: space-between;
   padding: 15px;
}

article p {
   flex: 1;
}

@media screen and (min-width:500px) {
   .band {
      grid-template-columns: 1fr 1fr;
   }
   .item-1 {
      grid-column: 1/3;
   }
}

@media screen and (min-width:850px) {
   .band {
      grid-template-columns: repeat(4, 1fr);
   }
}

 #section {
    background-color:#f5f7f;  
    width: 100%;
    height: 650px;
     }
  .a1 {display :none; }

    input
        { height: 25px;
         border-radius :  5px 5px 5px 5px;}

        #one:nth-of-type(1) {display:none;}
        #one:nth-of-type(1) ~div:nth-of-type(1) {display:none;}
        #one:nth-of-type(1):checked ~div:nth-of-type(1) {display:block;}
		#two:nth-of-type(2) ~div:nth-of-type(2) {display:none;}
		#two:nth-of-type(2):checked ~div:nth-of-type(2) {display:block;}

		#one:nth-of-type(1):checked ~section.buttons>label:nth-of-type(1) {
	    background: #8c8c8c;
	    color: #787878;
       }

		#two:nth-of-type(2):checked ~section.buttons>label:nth-of-type(2) {
		background: #8c8c8c;
		color: #787878;
		}
		section.buttons {
            overflow:hidden;
            font-size: 20px;}
		section.buttons > label {
			float:left;
			display:block;
			width: 50%;
			height: 50px;
			line-height:60px;
			text-align: center;

			border-radius: 5px 5px 5px 5px;
			box-sizing: border-box;
			border:1px solid gray;
			
			background: rgb(106, 180, 184);
			color:white;
            font-weight: bold;
		}
		 .pwch {
            background:#aaaaaa;
            height: 40px;
            padding-top:10px;
            padding-left:40px;
            color:black;
        }
       
        
		.item {
			overflow:hidden;
			padding:10px;
			border: 1px solid black;
			border-top:none;
		}
   table{
         border-spacing:20px ;
        }
   .space {
       padding-left: 100px;
        }
    tfoot > tr> td { 
      text-align: right;
      line-height: 50px;
        } 
       
    #footer {
   padding: 30px 0;
   background-color: burlywood;
   position: relative;
   transform: translateY(0%);
   border-top: 1px solid #dbdbdb;
}

.footer {
   text-align: center;
   padding: 30px 50px;
}

.footer li {
   position: relative;
   display: inline;
   padding: 0 7px 0 10px;
   white-space: nowrap;
}

.footer li:before {
   content: '';
   width: 1px;
   height: 12px;
   background-color: burlywood;
   position: absolute;
   left: 0;
   top: 2px;
}

.footer li:first-child:before {
   width: 0;
}
.footer address {
   padding-top: 15px;
    
}
#button {
   display: flex;
   justify-content: center;
   background-color: gray ;
   color: burlywood ;  
   font-size:1em;
   border-radius:0.5em; 
   padding:2px 20px;
   
}
a {
   text-decoration: none;
   display: inline-block;
   padding: 2px 16px;
   height: 30px;
}
.previous {
   background-color: #f1f1f1;
   color: black;
}
 
.link:hover {
   background-color: #ddd;
   color: black;
}
.footer {
   background-color:  burlywood;
   color: black;
}
.next {
   background-color: #f1f1f1;
   color: black;
}
.round {
   border-radius: 50%;
}
#dd {
   background-color: blue;
}
.cl{
   color : blue;
}        
 </style>
</head>
<body>

<!-- HEADER -->
	<jsp:include page="/common/header.jsp" />
 <!-- SECTION -->      
<section id="section">
 <div class="pwch">                
     <strong padding-left="100px">회원 탈퇴시 비밀 번호 체크</strong>
			<form name="delpwCheckform">
				<table>
					<tr>
						<td>아이디</td>
      					<c:if test="${not empty sessionID }">
						<td><input type="text"name="id"id="id"value="${sessionID}"></td>
						</c:if>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw" id="pw"></td>
					</tr>
					<tr>
						<td colspan="2">
				   		<button style="height: 35px; background:#d2d2d2;font-size:1em; border-radius:0.5em; padding:5px 20px;" onclick="pwCheck()">확인</button>
				   		</td>
				   </tr>
				</table>
			</form>
 	 </div>
  </section> 
            


    <!-- FOOTER -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>
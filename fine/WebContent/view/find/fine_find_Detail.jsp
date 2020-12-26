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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=99b1d8e23b122c900c17996f24c1ec0e&libraries=services"></script>

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


<style>
section {
  width: 80%;
	margin: 10vh auto;
		}
		
		h3{
		display: inline;
		}
</style>
</head>
<body>

<c:if test="${not empty list}">
<c:forEach items="${ list }" var="mvo" varStatus="s">
<jsp:include page="/common/header.jsp" />
<section>
<form>				
                 	<div id = jhb-content style="display: flex; flex-wrap: wrap;justify-content:space-around; ">
					<div id=dogImg>
					<img src="${mvo.popfile}" width="700px" height="800px">
					</div>
					<div id=dogInfo>
                        <h3>발견위치 : </h3> ${mvo.happenPlace}<br><br>
              
                    
              
                         <h3>발견날자 : </h3>${mvo.happenDt}<br><br>
              
                    
                       <h3>보호중인 시설 : </h3>
                        <p id="careName" style="display: inline;">${mvo.careNm}</p><br><br>
              
                   
                         <h3>보호시설 주소 : </h3>
                        <p id="address" style="display: inline;">${mvo.careAddr}</p><br><br>
              
                    
                         <h3>보호시설 번호 : </h3>${mvo.careTel}<br><br>
                         <h3>견종 : </h3>${mvo.kindCd}<br><br>
              
          					 <h3>나이  : </h3>${mvo.age}<br><br>
                    
                    
                         <h3>색깔  : </h3>${mvo.colorCd}<br><br>
              
                  
                         <h3>성별 : </h3>${mvo.sexCd}<br><br>
              

                         <h3>중성화 유무 : </h3> ${mvo.neuterYn}<br><br>
                    
                         <h3>몸무게 : </h3> ${mvo.weight}<br><br>
                    
                         <h3>특이사항 : </h3> ${mvo.specialMark}<br><br>
                         </div>
                         </div>
                   
                    
                    <div style="width:1550px; margin-bottom: 50px">
					<div id="map" style="width:100%;height:500px;"></div>
        			</div>
                        <button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/find_Lists.do'" style="width: 150px; height: 50px;">글목록</button>

				
   </form>
   </section>
       	 </c:forEach>
   </c:if>
   <script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 
//확대 축소
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
var address = document.getElementById('address').innerText;
var careName = document.getElementById('careName').innerText;
console.log(address);
console.log(careName);

// 주소로 좌표를 검색합니다


geocoder.addressSearch(address, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        console.log(coords);
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
  		var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+address+'<a href="https://map.kakao.com/link/to/'+careName+',' +coords.Ma+','+ coords.La+'" style="color:blue" target="_blank">길찾기</a></div>'
        });
      
  		 infowindow.open(map, marker);
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    

   





</script> 
<jsp:include page="/common/footer.jsp" />	
</body>
</html>
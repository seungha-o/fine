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
<div id="map" style="width:600px;height:500px;"></div>
<form>
        
                 	<c:if test="${not empty list}">
					<c:forEach items="${ list }" var="mvo" varStatus="s">
            <table>
       
            		<tr>
                        <td colspan="2"><img src="${mvo.popfile}"></td>
                    </tr>
                    <tr>
                        <td>나이</td>
                        <td>${mvo.age}</td>
                    </tr>

                     <tr>
                        <td>발견위치</td>
                        <td>${mvo.happenPlace}</td>
              
                    </tr>
                     <tr>
                        <td>발견날자</td>
                        <td>${mvo.happenDt}</td>
              
                    </tr>
                     <tr>
                        <td>보호중인 시설</td>
                        <td id="careName">${mvo.careNm}</td>
              
                    </tr>
                     <tr>
                        <td>보호시설 주소</td>
                        <td id="address">${mvo.careAddr}</td>
              
                    </tr>
                     <tr>
                        <td>보호시설 번호</td>
                        <td>${mvo.careTel}</td>
              
                    </tr>
                      <tr>
                        <td>색갈</td>
                        <td>${mvo.colorCd}</td>
              
                    </tr>
                     <tr>
                        <td>성별</td>
                        <td>${mvo.sexCd}</td>
              
                    </tr>
                    <tr>
                        <td>중성화 유무</td>
                        <td>${mvo.neuterYn}</td>
                    </tr>
                      <tr>
                        <td>몸무게</td>
                        <td>${mvo.weight}</td>
                    </tr>
                      <tr>
                        <td>특이사항</td>
                        <td>${mvo.specialMark}</td>
                    </tr>
              
                  
                    <tr>
                    
                        <td colspan="2">
                        <button type="button" id="BtnGoList" onclick="window.location='<%=ctxpath%>/find_Lists.do'">글목록</button>
                        </td> 
                    </tr>        
            </table>
       	 </c:forEach>
				</c:if>
   </form>
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
</body>
</html>
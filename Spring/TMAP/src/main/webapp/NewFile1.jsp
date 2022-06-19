<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>simpleMap</title>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xxe8583592f510477c8480044d12760288"></script>
		<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

//1. 지도 띄우기
function initTmap(){
	
map = new Tmapv2.Map("map_div", {
	center: new Tmapv2.LatLng(37.52084364186228,127.058908811749),
	width: "100%",
	height: "400px",
	zoom: 12
});


// 2. 시작, 도착 심볼찍기

var markerList = [];
var pointArray = [];

	// 시작
	addMarker("llStart",127.02810900563199,37.519892712436906,1);
	// 도착 
	addMarker("llEnd",127.11971717230388,37.49288934463672,2);
	function addMarker(status, lon, lat, tag) {
	//출도착경유구분
	//이미지 파일 변경.
	var markerLayer;
	switch (status) {
		case "llStart":
			imgURL = 'http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png';
			break;
		case "llPass":
			imgURL = 'http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_p.png';
			break;
		case "llEnd":
			imgURL = 'http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png';
			break;
		default:
	};
	var marker = new Tmapv2.Marker({
		position: new Tmapv2.LatLng(lat,lon),
		icon: imgURL,
		map: map
	});
	// 마커 드래그 설정
	marker.tag = tag;
	marker.addListener("dragend", function (evt) {
	markerListenerEvent(evt);
    });
    marker.addListener("drag", function (evt) {    	
    	markerObject = markerList[tag];
    });
    markerList[tag] = marker;
	return marker;
}
	// 3. 경유지 심볼 찍기
	addMarker("llPass",127.07389565460413,37.5591696189164,3);
	addMarker("llPass",127.13346617572014,37.52127761904626,4);

	var startX = 127.02810900563199;
	var startY = 37.519892712436906;
	var endX = 127.11971717230388;
	var endY = 37.49288934463672;
	var passList = "127.07389565460413,37.5591696189164_127.13346617572014,37.52127761904626";
	var prtcl;
	var headers = {};
	headers["appKey"]=unq_tmak;
	$.ajax({
			method:"POST", 
			headers : headers, 
			url:"https://apis.openapi.sk.com/tmap/routes?version=1&format=json",//
			async:false,
			data:{ 
				startX : startX,
				startY : startY,
				endX : endX,
				endY : endY,
				passList : passList,
				reqCoordType : "WGS84GEO",
				resCoordType : "WGS84GEO",
				angle : "172",
				searchOption : "0",
				trafficInfo : "Y"
			},
			success:function(response){
			prtcl = response;
			
			// 5. 경로탐색 결과 Line 그리기 
			var trafficColors = {
				extractStyles:true,
				/* 실제 교통정보가 표출되면 아래와 같은 Color로 Line이 생성됩니다. */
				trafficDefaultColor:"#636f63", //Default
				trafficType1Color:"#19b95f", //원할
				trafficType2Color:"#f15426", //지체
				trafficType3Color:"#ff970e"  //정체		
			};    			
			var style_red = {
				fillColor:"#FF0000",
				fillOpacity:0.2,
				strokeColor: "#FF0000",
				strokeWidth: 3,
				strokeDashstyle: "solid",
				pointRadius: 2,
				title: "this is a red line"
			};
			drawData(prtcl);
			
			// 6. 경로탐색 결과 반경만큼 지도 레벨 조정
			var newData = geoData[0];
			PTbounds = new Tmapv2.LatLngBounds();
					for (var i = 0; i < newData.length; i++) {
						var mData = newData[i];
						var type = mData.geometry.type;
						var pointType = mData.properties.pointType;
						if(type == "Point"){
							var linePt = new Tmapv2.LatLng(mData.geometry.coordinates[1],mData.geometry.coordinates[0]);
							console.log(linePt);
							PTbounds.extend(linePt);
						}
						else{
							var startPt,endPt;
							for (var j = 0; j < mData.geometry.coordinates.length; j++) {
								var linePt = new Tmapv2.LatLng(mData.geometry.coordinates[j][1],mData.geometry.coordinates[j][0]);
								PTbounds.extend(linePt);
							}
					}
				}
				map.fitBounds(PTbounds);
			
			
			},
			error:function(request,status,error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

</script>
</head>



<body onload="initTmap()">
	<div id="map_div">
        
        </div>       
</body>
</html>
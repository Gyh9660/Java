<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>simpleMap</title>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xxe8583592f510477c8480044d12760288"></script>
		<script src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
	
<script>
        var map,marker;
    	var lonlat;
    	var markers = [];
// 페이지가 로딩이 된 후 호출하는 함수입니다.

function initTmap(){
	// map 생성
	// Tmapv2.Map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
	map = new Tmapv2.Map("map_div", { // 지도가 생성될 div
		center: new Tmapv2.LatLng(37.566481622437934,126.98502302169841), // 지도 초기 좌표
		width : "100%", // 지도의 넓이
		height : "400px"  // 지도의 높이
		
	});
	map.addListener("click", onClick); // 이벤트의 종류와 해당 이벤트 발생 시 실행할 함수를 리스너를 통해 등록합니다
	map.addListener("zoom_changed", onChanged); // 지도의 줌 변경시, 이벤트 리스너 등록.
	map.addListener("drag", onDrag); // 지도 드래그시, 이벤트 리스너 등록.
	map.addListener("dragstart", onDragstart); // 지도 드래그 시작시, 이벤트 리스너 등록.
	map.addListener("dragend", onDragend); // 지도 드래그 끝났을 때, 이벤트 리스너 등록.
	map.addListener("contextmenu", onContextmenu); // 지도 우클릭시, 이벤트 리스너 등록.
	map.addListener("touchstart", onTouchstart); // 모바일에서 지도 터치 시작시, 이벤트 리스너 등록.
	map.addListener("touchend", onTouchend); // 모바일에서 지도 터치 터치가 끝났을때, 이벤트 리스너 등록.
	
}
function DragBlock(){
 	map.setOptions({ draggable: false }); //지도 드래그 이동을 비활성화 합니다.
}
// 지도의 드래그 이동을 가능하게 하는 함수입니다.
function Drag(){
	map.setOptions({ draggable: true }); //지도 드래그 이동을 활성화 합니다.
}
//'맵에 줌버튼을 추가' 버튼을 클릭하면  지도에 줌버튼을 추가 해주는 함수입니다. 
function add() {
	map.setOptions({zoomControl:true}); // 지도 옵션 줌컨트롤 표출 활성화
}
// '맵에 줌버튼을 제거' 버튼을 클릭하면 지도에 표시된 줌버튼을 제거 해주는 함수입니다.
function remove() {
	map.setOptions({zoomControl:false}); // 지도 옵션 줌컨트롤 표출 비활성화
}
var lonlat =  new Tmapv2.LatLng(37.566481622437934,126.98502302169841);

function zoom(){
	
map.setZoom(10); // 레벨 설정
}

//클릭한 곳 위치값을 받아서 시작버튼 누르면 그자리에 시작버튼 추가
//경유지 누르면 추가, 도착지점 누르면 도착 마커추가?
// 빵집 표시는 마커 안움직이게 박아놓고 지도사진 고정?
		//지도에서 이름으로검색(?마커등록이 먼저필요한가)
//지도를 클릭했을때 발생하는 이벤트 함수입니다.
function onClick(e) {
	lonlat=e.latLng;
	
	var result = '클릭한 위치의 좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
	
	removeMarkers();

	
	marker = new Tmapv2.Marker({
		position: new Tmapv2.LatLng(lonlat.lat(),lonlat.lng()), //Marker의 중심좌표 설정.
		map: map //Marker가 표시될 Map 설정.
	});
	  
	markers.push(marker);
}


// 모든 마커를 제거하는 함수입니다.
function removeMarkers() {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}
	markers = [];
}

	
	
	
function onChanged(e) {
	var result = '현재 zoom : ' + e.zoom+ '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}
function onDrag(e) {
	var result = '드래그한 위치의 좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}
function onDragstart(e) {
	var result = '드래그를 시작한 위치의 좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}
function onDragend(e) {
	var result = '드래그가 끝난 위치의 중앙좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}
function onContextmenu(e) {
	var result = '우클릭한 위치의 좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}
function onTouchstart(e) {
	var result = '모바일에서 터치가 시작된 위치의 좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}

function onTouchend(e) {
	var result = '모바일에서 터치가 끝난 위치의 좌표는' + e.latLng + '입니다.';
	var resultDiv = document.getElementById("result");
	resultDiv.innerHTML = result;
}
function size(){
	map.resize("500px","500px");
}

function lonlat(){
var lonlat =  new Tmapv2.LatLng(37.566481622437934,126.98502302169841);	
var point = new Tmapv2.LatLng(37.566671, 126.978413);
var point2 = new Tmapv2.LatLng(37.566481,126.986023);

var lonlat = point.distanceTo(point2);
lonlat.clone();
lonlat.toString();
lonlat.lat();
lonlat.lng();
lonlat.latitude();
lonlat.longitude();
lonlat.equals(coord);
lonlat.toBesselTm();
lonlat.toEPSG3857();
}

	function googleTranslateElementInit(){
		new google.translate.TranslateElement({
			pageLanguage: 'ko',
			layout: google.translate.TranslateElement.InlineLayout.SIMPLE,
			includeLanguages: 'ko,zh-CN,zh-TW,ja,vi,th,tl,km,my,mn,ru,en,fr,ar',
			autoDisplay: false
		}
		,'google_translate_element');
	}



</script>
    </head>
    <body onload="initTmap()">
        <div id="map_div">
        
        </div>        
        <div>
		<button onClick="DragBlock()">지도 드래그 이동 막기</button>
		<button onClick="Drag()">지도 드래그 이동 켜기</button>
	</div>
	<div>
		<button onClick="remove()">맵에 줌컨트롤을 제거</button>
		<button onClick="add()">맵에 줌컨트롤을 추가</button>
		<button onClick="zoom()">맵에 줌레벨 변경</button>
	</div>
	<div>
		<button onClick="size()">맵크기 변경</button>
	</div>
	<p id="result" />
	<p id="lonlat" >${lonlat } </p>
	<div>
		<button onClick="lonlat()">경로</button>
	</div>
	
	<div id="google_translate_element" class="hd_lang"></div>
	
	한글
	
	
	
	
	
	
	
    </body>
</html>	

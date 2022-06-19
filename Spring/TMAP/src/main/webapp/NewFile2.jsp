<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>simpleMap</title>
        <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xxe8583592f510477c8480044d12760288"></script>
		<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
		
		
<script type="text/javascript">
var map;

function initTmap(){
	map = new Tmapv2.Map("map_div",{
		center: new Tmapv2.LatLng(37.566481622437934,126.98502302169841),
		width:"100%",
		height:"400px"
		
	});
	//지도에 컨트롤러 추가
	new Tmapv2.extension.MeasureDistance({
		map: map
	});
}




</script>
</head>
<body  onload="initTmap()">
<div id="map_div"></div>

</body>
</html>
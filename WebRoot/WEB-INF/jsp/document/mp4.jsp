<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>${fileName }</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body onload="load()" style="text-align: center;">
	    <video id="video" controls="controls" autoplay="autoplay" src="${pageContext.request.contextPath}/market/conductPropagandaFile/readConductPropagandaFileById.action?id=${id}" style="width: 1280px;height: 720px;">
	    	
	    </video>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
  <script type="text/javascript">
  	function load(){
  		var video = document.getElementById("video");
  		var height = video.clientHeight;
  		$("#video").css("margin-top" , ($(window).height()-80-height)/2+"px");
  	}
  </script>
</html>

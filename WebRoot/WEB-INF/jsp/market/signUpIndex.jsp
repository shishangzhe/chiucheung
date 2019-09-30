<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>2018照彰全国巡展报名</title>
	
    <!-- 移动设备支持 -->
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
<meta name="x5-orientation"content="portrait">
<meta content="no-cache" http-equiv="pragma">
<meta content="0" http-equiv="expires">
<meta content="telephone=no, address=no" name="format-detection">
<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
<meta name="apple-mobile-web-app-capable" content="yes"> 
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  <style>
</style>
  <body id="grad" style="background-size:100%;background-image: url('${pageContext.request.contextPath}/wechatImg/background.jpg')">
  		<%-- <img src="${pageContext.request.contextPath}/wechatImg/logo1.png" style="width: 50%;">
  		<img src="${pageContext.request.contextPath}/wechatImg/logo2.png" style="width: 30%;padding-top: 10px;">
  		<span style="font-size: 10px;color: #1c384b">联合主办</span>
  		<img src="${pageContext.request.contextPath}/wechatImg/backgroundFont.png" style="width: 50%;margin-left: 5%;margin-top: 5%"> --%>
		<img src="${pageContext.request.contextPath}/wechatImg/background-bottom.png" style="width: 100%; bottom:0; right:0;position: fixed;" onclick="return false;" ontouchstart = "return false;">
		
		<form id="form" action="signUp.action"></form>
		<a href="signUp.action">
		<button id="forward" style="width: 120px;height: 40px;background-color: #0b4379;border: 0px;border-radius: 5px;color: white;margin-left: 30%;margin-top: 65%;margin-left: 7%"><span style="font-size: 16px;">报名</span></button>
		</a>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
</html>

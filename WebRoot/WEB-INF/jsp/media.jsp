<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>${title }</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body style="text-align: center;padding-top: 30px;" onload="onload()">
  	<p>${title }</p>
    <video id="video" src="${pageContext.request.contextPath}${url}" controls="controls" autoplay=true width="1024">
		您的浏览器不支持 video 标签。
	</video>
  </body>
</html>

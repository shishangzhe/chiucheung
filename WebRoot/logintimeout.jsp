<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- 登陆超时，跳转到该页面，该页面在让父页面跳转到登陆页面 -->
    <script type="text/javascript">
    	/* alert("登陆超时，请重新登陆！"); */
    	parent.location.replace("${pageContext.request.contextPath}/system/user/login.action");
    </script>
  </head>
  
  <body>
  </body>
</html>

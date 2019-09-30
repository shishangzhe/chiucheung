<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<script type="text/javascript">
  		alert("${error }");
  		window.opener = null;//为了不出现提示框 
  		window.open('','_self');
		window.close();//关闭窗口
	</script>
  </body>
</html>

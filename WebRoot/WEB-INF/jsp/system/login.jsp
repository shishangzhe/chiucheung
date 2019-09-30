<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>东莞照彰五金电器制品有限公司-登陆</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
  	$(function(){
  		$("#login").css("margin-top",($(window).height()-80-$("#login").height())/2+"px");
  		
  		$("#form").keyup(function (event){
			if (event.keyCode == 13){
				submitForm();
			}
		});
  	});
  	//浏览器缩放
  	window.onload=window.onresize = function(){
  		$("#login").css("margin-top",($(window).height()-80-$("#login").height())/2+"px");
  	}
  	function submitForm(){
  		var flag = true;
  		var msg = "";
  		if ($("#loginName").val()==null || $("#loginName").val()==""){
  			flag = false;
  			msg = "用户名不能为空";
  		} else if ($("#loginPassword").val()==null || $("#loginPassword").val()==""){
  			flag = false;
  			msg = "密码不能为空";
  		}
  		$("#errorMsg").text(msg);
  		if (flag){
  			$("#errorMsg").text("");
  			$("#form").submit();
  		}
  	}
  </script>
<body>   
	<div id="login">
		<div style="margin:20px auto;width:200px;height:auto">
			<img src="${pageContext.request.contextPath}/image/logo.png" style="margin:0;width:100%;height:auto;">
		</div>
		<div style="padding:0 20px">
			<form id="form" action="${pageContext.request.contextPath}/system/user/login.action" method="post">
				<div style="text-align:center;margin-top:30px;margin-bottom: 10px">
					<input id="loginName" class="easyui-textbox" name="loginName" data-options="prompt:'Type username',iconCls:'icon-man'" style="width:220px;height:38px" value="${loginName}">
				</div>
				<div style="text-align:center;">
					<input id="loginPassword" class="easyui-textbox" name="loginPassword" type="password" data-options="prompt:'Type password',iconCls:'icon-lock'" style="width:220px;height:38px">
				</div>
				<div style="text-align:center;height: 20px">
					<span id="errorMsg" style="color: red;font-size: small;">${errorMessage}</span>
				</div>
				<div style="text-align:center;">
					<a class="easyui-linkbutton" style="width:120px;height:40px" onclick="submitForm()"><span style="font-size:16px">登录</span></a>
				</div>
			</form>
		</div>
	</div>
</body>    
</html>

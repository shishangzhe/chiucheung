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
  		$("#login").css("margin-top",($(window).height()-$("#login").height())/2+"px");
  		$("#login").css("margin-left",($(window).width()-$("#login").width())/2+"px");
  		
  		$("#form").keyup(function (event){
			if (event.keyCode == 13){
				submitForm();
			}
		});
  	});
  	//浏览器缩放
  	window.onload=window.onresize = function(){
  		$("#login").css("margin-top",($(window).height()-$("#login").height())/2+"px");
  		$("#login").css("margin-left",($(window).width()-$("#login").width())/2+"px");
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
  			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/market/map/login.action",//ajax请求的url
				data: $("#form").serialize(),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						//清空password
						$("#loginPassword").val("");
						//隐藏父页面的当前iframe
						$("#login",window.parent.document).hide();
						if (window.parent.option.series.length == 1){//true时，表示是新打开页面，则需要登陆，登陆后需要重新获取地图数据，如果为false，则是打开页面后停留太久，需要重新登陆，登陆后只需要隐藏登陆的窗口，不需要进行其他操作
							window.parent.getMapData("world", "中国", null);
						}
					}else{
						$("#errorMsg").text(data.message);
					}
				}
			});
  		}
  	}
  </script>
<body>   
	<div id="login" style="background-color: white;width: 252px;height: 350px;padding-top: 10px;border-radius: 10px;">
		<div style="margin:20px auto;width:200px;height:auto;">
			<img src="${pageContext.request.contextPath}/image/logo.png" style="margin:0;width:100%;height:auto;">
		</div>
		<div style="padding:0 20px;">
			<form id="form">
				<div style="text-align:center;margin-top:30px;margin-bottom: 10px">
					<input id="loginName" class="easyui-textbox" name="loginName" data-options="prompt:'Type username',iconCls:'icon-man'" style="width:220px;height:38px" value="${loginName}">
				</div>
				<div style="text-align:center;">
					<input id="loginPassword" class="easyui-textbox" name="loginPassword" type="password" data-options="prompt:'Type password',iconCls:'icon-lock'" style="width:220px;height:38px">
				</div>
				<div style="text-align:center;height: 20px">
					<span id="errorMsg" style="color: red;font-size: small;"></span>
				</div>
				<div style="text-align:center;">
					<a class="easyui-linkbutton" style="width:120px;height:40px" onclick="submitForm()"><span style="font-size:16px">登录</span></a>
				</div>
			</form>
		</div>
	</div>
</body>    
</html>

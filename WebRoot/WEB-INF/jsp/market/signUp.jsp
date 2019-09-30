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
	#grad {  
		background: -webkit-linear-gradient(left, #2483b9 , #205a88); /* Safari 5.1 - 6.0 */
		background: -o-linear-gradient(right, #2483b9, #205a88); /* Opera 11.1 - 12.0 */  
		background: -moz-linear-gradient(right, #2483b9, #205a88); /* Firefox 3.6 - 15 */ 
		background: linear-gradient(to right, #2483b9 , #205a88); /* 标准的语法 */ 
	}
</style>
  <body id="grad" style="text-align: center;<%-- background-size:100%;background-image: url('${pageContext.request.contextPath}/wechatImg/background2.jpg') --%>" onload="load();">
  	<!-- <p>开发中...</p> -->
	  	<form id="form">
	  		<input type="hidden" name="exhibitionName" value="2018全国巡展">
	  		<div id="zhe" style="z-index: 998px;position: absolute;"></div>
	  		<img id="img" alt="" src="${pageContext.request.contextPath}/wechatImg/background2Font2.png" style="margin-top: 20px;width: 80%;" onclick="return false;">
	  		
	  		
	  		
	  		<table style="margin-left: 10%;z-index: 990px;position: relative;">
	  			<tr>
	  				<td style="text-align: left;padding-top: 5px;">
	  					<span style="color: white;font-size: 10px;">姓名：</span>
	  					<br>
	  					<input id="userName" type="text" name="userName" style="width: 200px;height: 25px;font-size: 16px;border:0px;border-radius: 3px;padding-left: 5px">
	  				</td>
	  			</tr>
	  			<tr>
	  					
	  				<td style="text-align: left;padding-top: 5px;">
	  					<span style="color: white;font-size: 10px;">电话：</span>
	  					<br>
	  					<input id="phoneNumber" type="text" name="phoneNumber" style="width: 200px;height: 25px;font-size: 16px;border:0px;border-radius: 3px;padding-left: 5px">
	  				</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: left;padding-top: 5px;">
	  					<span style="color: white;font-size: 10px;">邮箱：</span>
	  					<br>
	  					<input id="email" type="text" name="email" style="width: 200px;height: 25px;font-size: 16px;border:0px;border-radius: 3px;padding-left: 5px">
	  				</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: left;padding-top: 5px;">
	  					<span style="color: white;font-size: 10px;">公司：</span>
	  					<br>
	  					<input id="company" type="text" name="company" style="width: 200px;height: 25px;font-size: 16px;border:0px;border-radius: 3px;padding-left: 5px">
	  				</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: left;padding-top: 5px;">
	  					<span style="color: white;font-size: 10px;">性质：</span>
	  					<span style="color: red;font-size: 10px;" >*多选</span>
	  					<br>
	  					<input id="property1" type="checkbox" name="property" value="工程/集成商" style="border:0px;">
			    		<label for="property1" style="color: white;font-size: 10px;">工程/集成商</label>
			    		<input id="property2" type="checkbox" name="property" value="终端用户" style="border:0px;margin-left: 30px;">
			    		<label for="property2" style="color: white;font-size: 10px;">终端用户</label>
			    		<br>
	  					<input id="property3" type="checkbox" name="property" value="经销/代理商" style="border:0px;">
			    		<label for="property3" style="color: white;font-size: 10px;">经销/代理商</label>
	  					<input id="property4" type="checkbox" name="property" value="科研机构" style="border:0px;margin-left: 30px;">
			    		<label for="property4" style="color: white;font-size: 10px;">科研机构</label>
			    		<br>
	  					<input id="property5" type="checkbox" name="property" value="生产/制造商" style="border:0px">
			    		<label for="property5" style="color: white;font-size: 10px;">生产/制造商</label>
	  					<input id="property6" type="checkbox" name="property" value="协会/媒体" style="border:0px;margin-left: 30px;">
			    		<label for="property6" style="color: white;font-size: 10px;">协会/媒体</label>
			    		<br>
	  					<input id="property7" type="checkbox" name="property" value="其他" style="border:0px">
			    		<label for="property7" style="color: white;font-size: 10px;">其他</label>
	  				</td>
	  			</tr>
	  					
	  			<tr>
	  				<td style="text-align: left;padding-top: 5px;">
	  				<span style="color: white;font-size: 10px;">站点：</span>
	  					<br>
	  					<select id="site" type="text" name="site" style="width: 200px;height: 30px;font-size: 16px;border:0px;border-radius: 3px;" onchange="changeSite()">
			    			<option value="南宁">南宁 - 4月26日</option>
			    			<option value="济南">济南 - 5月8日</option>
			    			<option value="福州">福州 - 5月15日</option>
			    			<option value="厦门">厦门 - 5月18日</option>
			    			<option value="长沙">长沙 - 5月22日</option>
			    			<option value="南昌">南昌 - 5月25日</option>
			    			<option value="武汉">武汉 - 5月30日</option>
			    			<option value="杭州">杭州 - 6月6日</option>
			    			<option value="南京">南京 - 6月13日</option>
			    			<option value="呼和浩特">呼和浩特 - 6月20日</option>
			    			<option value="重庆">重庆 - 6月27日</option>
			    			<option value="青岛">青岛 - 7月3日</option>
			    			<option value="昆明">昆明 - 7月10日</option>
			    			<option value="广州">广州 - 7月18日</option>
			    			<option value="深圳">深圳 - 7月20日</option>
			    			<option value="石家庄">石家庄 - 7月26日</option>
			    			<option value="乌鲁木齐">乌鲁木齐 - 8月2日</option>
			    			<option value="阿克苏">阿克苏 - 8月8日</option>
			    			<option value="伊犁州">伊犁州 - 8月15日</option>
			    			<option value="阿勒泰">阿勒泰 - 8月22日</option>
			    		</select>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: left;padding-top: 10px;">
	  					<button id="submit" style="width: 200px;height: 40px;background-color: #0b4379;border: 0px;border-radius: 5px;color: white;" type="button" onclick="submitData();"><span id="submitText" style="font-size: 16px;">提交</span></button>
	  				</td>
	  			</tr>
			</table>
		</form>
		<div style="width: 128px;height: 160px;bottom:0; right:0;position: fixed;background-image: url('${pageContext.request.contextPath}/wechatImg/background2-bottom.png');background-size:100%;"></div>
		<%-- <img src="${pageContext.request.contextPath}/wechatImg/background2-bottom.png" style="width: 40%; bottom:0; right:0;position: fixed;" onclick="return false;" oncontextmenu="return false;"> --%>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
  <script type="text/javascript">
  	var successSite = "";
  	function load(){
  		$("#zhe").height(document.body.scrollHeight-10);
  		$("#zhe").width(document.body.clientWidth);
  		$("option").each(function(){
  			var site = $(this).text();
  			site = site.split(" - ")[1];
  	  		var month = site.split("月")[0];
  	  		var day = site.split("月")[1].split("日")[0];
  	  		
			var curTime = new Date();
  		
	  		var endTime = new Date();
	  		endTime.setFullYear(curTime.getFullYear(), month-1, day);
	  		endTime.setHours(12, 0, 0, 0);
	  		if (curTime < endTime){
	  			$(this).attr("selected","selected");
	  			return false;
	  		}
  		});
  	}
  	function submitData(){
  		var b = validate();
  		if (b){
  			$.ajax({
  				type:'POST',//post请求
  				url: '${pageContext.request.contextPath}/market/exhibitionContact/signUpAdd.action',//ajax请求的url
  				data: $("#form").serialize(),//传的参数,序列化表单
  				async: false,//同步请求
  				cache: false,//不缓存此页面
  				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
  					if (data.success){
  						$("#submit").attr("disabled",true);
  			  	  		$("#submitText").text("报名成功");
  			  	  		successSite += $("#site").find("option:selected").val() + ",";
  					}
  				}
  			});
  		}
  	}
  	function changeSite(){
  		
  		var site = $("#site").find("option:selected").text();
  		site = site.split(" - ")[1];
  		var month = site.split("月")[0];
  		var day = site.split("月")[1].split("日")[0];
  		
  		var curTime = new Date();
  		
  		var endTime = new Date();
  		endTime.setFullYear(curTime.getFullYear(), month-1, day);
  		endTime.setHours(12, 0, 0, 0);
  		
  		if (curTime > endTime){
  			$("#submit").attr("disabled",true);
  	  		$("#submitText").text("该站点报名已结束");
  		}else{
  			if (successSite.indexOf($("#site").find("option:selected").val()) != -1){
  				$("#submit").attr("disabled",true);
  	  	  		$("#submitText").text("已报名");
  			}else{
	  			$("#submit").attr("disabled",false);
	  	  		$("#submitText").text("提交");
  			}
  		}
  	}
  	function validate(){
  		var userName = $("#userName").val();
  		if ($.trim(userName) == ""){
  			alert("姓名不能为空");
  			return false;
  		}else{
  			$("#userName").val($.trim(userName));	
  		}
  		
  		var phoneNumber = $("#phoneNumber").val();
  		if ($.trim(phoneNumber) == ""){
  			alert("电话不能为空");
  			return false;
  		}else{
  			$("#phoneNumber").val($.trim(phoneNumber));	
  			if (!checkMobile($.trim(phoneNumber)) && !checkPhone($.trim(phoneNumber))){
  				alert("电话格式错误");
  				return false;
  			}
  		}
  		
  		var email = $("#email").val();
  		if ($.trim(email) == ""){
  			alert("邮箱不能为空");
  			return false;
  		}else{
  			$("#email").val($.trim(email));	
  			if (!checkEmail($.trim(email))){
  				alert("邮箱格式错误");
  				return false;
  			}
  		}
  		
  		var company = $("#company").val();
  		if ($.trim(company) == ""){
  			alert("公司不能为空");
  			return false;
  		}else{
  			$("#company").val($.trim(company));	
  		}
  		
  		var checkedLength = $("input[name='property']:checked").length;
  		if (checkedLength <=0 ){
  			alert("请至少选择一项性质");
  			return false;
  		}
  		
  		return true;
  	}
  	
  	function checkMobile(str) {
  		var re = /^1[3-9]\d{9}$/
  		if (re.test(str)) {
  	 		return true;
  	 	} else {
  	  		return false;
  	 	}
  	}
  	function checkPhone(str){
 		var re = /^0\d{2,3}-?\d{7,8}$/;
 		if(re.test(str)){
 			return true;
 		}else{
 			return false;
  	 	}
  	}
  	function checkEmail(str){
  		var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
  		if(re.test(str)){
  			return true;
		}else{
			return false;
  		}
  	}


  </script>
</html>

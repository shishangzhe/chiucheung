<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>照彰实业(东莞)有限公司</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
	<jsp:include page="/common.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ztree.core-3.5.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css">
	<script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		$("#dialog").dialog({//加载一个dialog
			closed:$("#dialog").dialog("options").closed,
			left:($(document.body).width()-$("#dialog").width())/2,
			top:($(document.body).height()-74-$("#dialog").height())/2,
		});
		//当浏览器小于这个窗口时，将该窗口设置成浏览器大小
		if ($(document.body).height()<$("#dialog1").height()){
			$("#dialog1").dialog({
				closed:$("#dialog1").dialog("options").closed,
				height: $(document.body).height()
			});
		}else{
			$("#dialog1").dialog({
				closed:$("#dialog1").dialog("options").closed,
				height: 600
			});
		}
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-37-$("#dialog1").height())/2,
		});

	}
	/* window.onresize = function(){//如何放在上面，IE中刚打开页面会出现偏下一点点的问题，在页面大小更改时反而好了
		$(".messageDiv").each(function(i){
			$(this).parent().window('resize',{
				left:$(document.body).width()-300, // 与左边界的距离
				top:$(document.body).height()-(150*(i+1)) // 与顶部的距离
			});
		});
	} */
	//JS模拟ArrayList
	function ArrayList(){ 
		this.arr=[],
		
		this.size=function(){ 
			return this.arr.length; 
		},
		
		this.add=function(){ 
			if(arguments.length==1){ 
				this.arr.push(arguments[0]); 
			}else if(arguments.length>=2){ 
				var deleteItem=this.arr[arguments[0]]; 
				this.arr.splice(arguments[0],1,arguments[1],deleteItem);
		 	} 
		 	return this; 
		},
		
		this.get=function(index){ 
			return this.arr[index]; 
		},
		
		this.removeIndex=function(index){ 
			this.arr.splice(index,1); 
		},
		
		this.removeObj=function(obj){ 
			this.removeIndex(this.indexOf(obj)); 
		},
		
		this.indexOf=function(obj){ 
			for(var i=0;i<this.arr.length;i++){ 
				if (this.arr[i]===obj) { 
					return i; 
				}; 
			} 
		 	return -1; 
		},
		
		this.isEmpty=function(){ 
			return this.arr.length==0; 
		},
		
		this.clear=function(){ 
			this.arr=[]; 
		},
		
		this.contains=function(obj){ 
			return this.indexOf(obj)!=-1; 
		},
		
		this.toString=function(){
			var str = '';
			for (var i=0;i<this.arr.length;i++){
				if (i <this.arr.length-1){
					str = str + this.arr[i] + ",";
				}else{
					str = str + this.arr[i];
				}
			}
			return str;
		}
	}; 
	var ids = new ArrayList();//已经显示的消息id
	
	
	$(function () {
		//加载树形菜单的配置
		var setting = {
			view: {
				dblClickExpand: false,
				showLine: true,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable:true,
					idKey: "mid",
					pIdKey: "pid",
					rootPId: ""
				}
			},
			callback: {
				//点击前判断是否是父节点，是则展开，
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("tree");
					//如果是父节点，则展开
					if (treeNode.isParent) {
						zTree.expandNode(treeNode);
						return false;
					}else{
						return true;
					}
				},
				//给子节点添加点击事件
				onClick: function(event, treeId, treeNode){
					//如果不是父节点，则打开tabs
					if (!treeNode.isParent) {
						Open(treeNode.name, treeNode.clickurl);
					}
				}
			}
		};
		//用ajax从来台取数据
		$(document).ready(function(){
			$.post('${pageContext.request.contextPath }/system/user/showMenu.action',{},function(data){
				var t = $("#tree");
				t = $.fn.zTree.init(t, setting, data);
			});
			
			getMessageAndOnlineUserTotalAndAllAuditCount();
		});
		
	    
	    
	    //绑定tabs的右键菜单
	    $("#tabs").tabs({
	        onContextMenu : function (e, title) {
	            e.preventDefault();
	            $('#tabsMenu').menu('show', {
	                left : e.pageX,
	                top : e.pageY
	            }).data("tabTitle", title);
	        }
	    });
	    
	    //实例化menu的onClick事件
	    $("#tabsMenu").menu({
	        onClick : function (item) {
	            CloseTab(this, item.name);
	        }
	    });
	    
	    
		
	});
	
	//在右边center区域打开菜单，新增tab
    function Open(text, url) {
		if (url == "/market/map/index.action"){
			window.open('${pageContext.request.contextPath }'+url,'_blank','');
		}else{
	        if ($("#tabs").tabs('exists', text)) {
	            $('#tabs').tabs('select', text);
	        } else {
	            $('#tabs').tabs('add', {
	                title : text,
	                closable : true,
	                content : createFrame('${pageContext.request.contextPath }'+url)
	            });
	        }
		}
    }
    
	//创建frame
    function createFrame(url)
    {
    	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:99.5%;"></iframe>';
    	return s;
    }
    
    
  //几个关闭事件的实现
    function CloseTab(menu, type) {
        var curTabTitle = $(menu).data("tabTitle");
        var tabs = $("#tabs");
        
        if (type === "close") {
            tabs.tabs("close", curTabTitle);
            return;
        }
        
        var allTabs = tabs.tabs("tabs");
        var closeTabsTitle = [];
        
        $.each(allTabs, function () {
            var opt = $(this).panel("options");
            if (opt.closable && opt.title != curTabTitle && type === "Other") {
                closeTabsTitle.push(opt.title);
            } else if (opt.closable && type === "All") {
                closeTabsTitle.push(opt.title);
            }
        });
        
        for (var i = 0; i < closeTabsTitle.length; i++) {
            tabs.tabs("close", closeTabsTitle[i]);
        }
    }
    
	
	function openDialog(){
		$("#form").form('reset');//重置表单数据
		$("#dialog").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:'修改密码'//该dialog的标题
		});
	}
	function changePassword(){
		var url = "${pageContext.request.contextPath}/system/user/changePassword.action";
		$.ajax({
			type:'GET',//post请求
			url: url,//ajax请求的url
			data: $("#form").serialize(),//传的参数,序列化表单
			async: false,//同步请求
			cache: false,//不缓存此页面
			contentType: 'application/json;charset=utf-8',
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				showMessager("提示",data);
				if (data == "修改成功"){
					$("#dialog").dialog({//关闭这个dialog
						closed:true
					});
				}
			}
		});
	}

	
	function loginout(){
		window.location.href = "${pageContext.request.contextPath}/system/user/logout.action";
	}
	
	
	
	
	
	
	//获取消息和在线用户数
	function getMessageAndOnlineUserTotalAndAllAuditCount(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/message/findMessageAndOnlineUserInfo.action',//ajax请求的url
			data: {ids:ids.toString()},
			async: true,//异步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data != "" && data != null){
					if(data.newMessage.length > 0){
						$(".messageDiv").each(function(i){
							$(this).parent().window('resize',{
								left:$(document.body).width()-300, // 与左边界的距离
								top:$(document.body).height()-(150*(data.newMessage.length+i+1)) // 与顶部的距离
							});
						});
					}
					for (var i=0;i<data.newMessage.length;i++){
						ids.add(data.newMessage[i].id);
						$.messager.show({
							title:'消息',
							msg:"<div>"+data.newMessage[i].message+"</div><div class='messageDiv' style='padding-top:20px;padding-left:100px'><a id='"+data.newMessage[i].id+"' class='easyui-linkbutton' plain='true' onClick='read(\""+data.newMessage[i].id+"\")' style='float: left;'>不在显示此消息</a><div>",
							width:300,
							height:150,
							timeout:0,
							style:{
							    left:$(document.body).width()-300, // 与左边界的距离
							    top:$(document.body).height()-(150*(i+1)), // 与顶部的距离
							    opacity:0.9
							},
							onBeforeClose:function(){
								$(this).children(".messageDiv").children("a").click();//点击该消息提示框内的不在显示此消息
								return false;
							}
						});
					}
					if (ids.size()>0){
						$("#messageTotalDiv").show();
						$("#messageTotalDiv2").hide();
					}else{
						$("#messageTotalDiv").hide();
						$("#messageTotalDiv2").show();
					}
					$("#messageTotal").html(ids.size());
					$("#onlineUserTotal").html(data.onlineUserTotal);
					$("#audtiCount").html(data.auditCount);
				}
			},
			complete: function (XMLHttpRequest, textStatus) {
				var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
				if(sessionstatus=="timeout"){ 
					//如果超时就处理 ，指定要跳转的页面  
					window.location.replace("${pageContext.request.contextPath}/logintimeout.jsp");   
				}else{
					/* setTimeout(function(){
						getMessageAndOnlineUserTotalAndAllAuditCount();
					}, 5000); */
				}
			}
		});
		//开启定时任务,每一分钟读取一次消息
		//window.setTimeout(getMessageAndOnlineUserTotalAndAllAuditCount, 20000); 
	}
	
	//将消息设置为已读(必须得放在这上面，否则会报错 read undefined)
	function read(id){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/message/updateMessageIsReadById.action',//ajax请求的url
			data: {id:id},
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){
				var msg = $("#"+id).parent().parent();//获取消息窗口
				msg.window('destroy');//关闭消息窗口(必须是销毁，否则$(".messageDiv")获取到它)
				ids.removeObj(id);
				$(".messageDiv").each(function(i){
					$(this).parent().window('resize',{
						left:$(document.body).width()-300, // 与左边界的距离
						top:$(document.body).height()-(150*(i+1)) // 与顶部的距离
					});
				});
				//设置未读消息数
				if (ids.size()>0){
					$("#messageTotalDiv").show();
					$("#messageTotalDiv2").hide();
				}else{
					$("#messageTotalDiv").hide();
					$("#messageTotalDiv2").show();
				}
				$("#messageTotal").html(ids.size());
			}
		});
	}
	
	function showMessage(){
		Open("即时消息", '/system/message/showAllMessage.action?pageNo=1');
	}
	function showAudit(){
		Open("审批", '/system/message/auditIndex.action');	
	}
	
	function showOnlineUser(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/getOnlineUserList.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'在线用户列表'//该dialog的标题
				});
				var divs = "<div id='onlineUserDiv'><div>";
				$("#dialog1").html(divs);
				for(var i=0;i<data.length;i++){
					var kickOut = "";
					if("${user.loginName}" != data[i].loginName){//表示不是本人，自己不能踢自己
						kickOut = "<div style='float:right;padding-right:10px'><input id='"+data[i].id+"Button' type='button' value='强制退出' onclick='kickOut(\""+data[i].id+"\")' onmousemove='mousemove(\""
						+data[i].id+"\")' onmouseout='mouseout(\""+data[i].id+"\")' style='border-width:0px;background-color:#e1e1e1;height:30px;'></div>";
					}
					var div = "<div id='"+data[i].id+"' style='height:30px;text-align:left;line-height:30px;padding-top:5px'>"
					+"<span style='font-size:16px;padding-left:10px'>"+data[i].username+"</span>"
					+ kickOut
					+"<div/>";
					
					$("#onlineUserDiv").append(div);
				}
			}
		});
	}
	
	function kickOut(id){
		$.messager.confirm('确认对话框', '确定要踢出该用户吗？', function(b){
			if (b){//如何用户点击的是确认
				$.ajax({
					type:'POST',//post请求
					url: '${pageContext.request.contextPath}/system/user/kickOutUserById.action',//ajax请求的url
					data: {id:id},
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data == '踢出成功'){
							$("#"+id).remove();
						}else{
							showMessager("错误",data);
						}
					}
				});
			}
		});
	}
	
	function mousemove(id){
		$("#"+id+"Button").css("background-color","#34b4e3");
		$("#"+id+"Button").css("border-color","#34b4e3");
	}
	
	function mouseout(id){
		$("#"+id+"Button").css("background-color","#e1e1e1");
		$("#"+id+"Button").css("border-color","#000000");
	}
	
	
	
	//给其他页面调用，
	//刷新待审批的数据，顺便刷新在线用户数、未读消息数、消息
	function RefreshData(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/message/findMessageAndOnlineUserInfo.action',//ajax请求的url
			data: {ids:ids.toString()},
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data != "" && data != null){
					if(data.newMessage.length > 0){
						$(".messageDiv").each(function(i){
							$(this).parent().window('resize',{
								left:$(document.body).width()-300, // 与左边界的距离
								top:$(document.body).height()-(150*(data.newMessage.length+i+1)) // 与顶部的距离
							});
						});
					}
					for (var i=0;i<data.newMessage.length;i++){
						ids.add(data.newMessage[i].id);
						$.messager.show({
							title:'消息',
							msg:"<div>"+data.newMessage[i].message+"</div><div class='messageDiv' style='padding-top:20px;padding-left:100px'><a id='"+data.newMessage[i].id+"' class='easyui-linkbutton' plain='true' onClick='read(\""+data.newMessage[i].id+"\")' style='float: left;'>不在显示此消息</a><div>",
							width:300,
							height:150,
							timeout:0,
							style:{
							    left:$(document.body).width()-300, // 与左边界的距离
							    top:$(document.body).height()-(150*(i+1)), // 与顶部的距离
							    opacity:0.9
							},
							onBeforeClose:function(){
								$(this).children(".messageDiv").children("a").click();//点击该消息提示框内的不在显示此消息
							}
						});
					}
					if (ids.size()>0){
						$("#messageTotalDiv").show();
						$("#messageTotalDiv2").hide();
					}else{
						$("#messageTotalDiv").hide();
						$("#messageTotalDiv2").show();
					}
					$("#messageTotal").html(ids.size());
					$("#onlineUserTotal").html(data.onlineUserTotal);
					$("#audtiCount").html(data.auditCount);
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){//请求失败后的回调函数。
				if(XMLHttpRequest.status == 0 && XMLHttpRequest.readyState ==0){
					showMessager("提示",'<font color="red">无法连接服务器<font/>');
				}
			}
		});
	}
	</script>
	
	<style>
	  article, aside, figure, footer, header, hgroup, 
	  menu, nav, section { display: block; }
	  .west{
	    width:200px;
	    padding:10px;
	  }
	  .north{
	    height:100px;
	  }
	  .panel-title{
		text-align: center;
		font-size: 14px;
	}
	a{
		text-decoration:none;
	 }
	 a:HOVER {
		text-decoration: underline;
	 }
	</style>
  </head>
  
<body class="easyui-layout">
	<div region="north" class="north" style="height: 32px;background: #9a9a9a">
		<img src="${pageContext.request.contextPath}/image/logo2.png" style="margin-top: 5px;margin-left: 10px;">
		<span style="font-size: 20px;">照彰实业(东莞)有限公司</span>
		
		<div style="float: right;padding-right: 20px;font-size: larger;">
			<div style="float: right;line-height: 30px;"><a style="cursor: pointer;" onclick="loginout()">重新登录</a></div>
			<div style="float: right;">&nbsp;&nbsp;</div>
			<div style="float: right;line-height: 30px;"><a style="cursor: pointer;" onclick="openDialog()">更改密码</a></div>
			<div style="float: right;">&nbsp;&nbsp;</div>
		</div>
		
		<div style="float: right;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div id="audtiCountDiv" style="background-color: #fa6c05;float: right;border-radius:5px;width: 20px;text-align: center;" title="待审批数">
				<span id="audtiCount" style="color: white;font-family:Arial;font-size: 11px;"></span>
			</div>
			<div style="float: right;line-height: 30px;font-size: larger;"><a style="cursor: pointer;" onclick="showAudit()">审批</a></div>
		</div>
		
		<div id="messageTotalDiv" style="background-color: #fa6c05;float: right;border-radius:5px;width: 20px;text-align: center;" title="未读消息数">
			<span id="messageTotal" style="color: white;font-family:Arial;font-size: 11px;z-index: 10;"></span>
		</div>
		<div id="messageTotalDiv2" style="float: right;border-radius:5px;width: 20px;height: 5px; text-align: center;">
		</div>
		
		
		<div style="float: right;padding-top: 5px; padding-left:10px; font-size: larger;">
			<img id="messageImg" alt="即时消息" src="image/message1.png" height="18px" title="即时消息" style="cursor: pointer;" onclick="showMessage()" onmousemove="$('#messageImg').attr('src','image/message2.png')" onmouseout="$('#messageImg').attr('src','image/message1.png')">
		</div>
		
		
		<div id="onlineUserTotalDiv" style="background-color: #fa6c05;float: right;border-radius:5px;width: 20px;text-align: center;" title="在线用户数">
			<span id="onlineUserTotal" style="color: white;font-family:Arial;font-size: 11px;z-index: 10;"></span>
		</div>
		
		<div style="float: right;padding-top: 5px; font-size: larger;">
			<img id="onlineUserImg" alt="在线用户" src="image/onlineUser1.png" height="18px" title="在线用户" style="cursor: pointer;" onclick="showOnlineUser()" onmousemove="$('#onlineUserImg').attr('src','image/onlineUser2.png')" onmouseout="$('#onlineUserImg').attr('src','image/onlineUser1.png')">
		</div>
		
		<div style="float: right;padding-right: 20px;padding-top: 7px; font-size: larger;">
			欢迎您：${user.username}！
		</div>
	</div>
	<div region="center" split:true>
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页">
				<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
				  <tr>
				    <td align="center"><img src="image/welcome.gif" width="145" height="46" /></td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	<div region="west" class="west" title="菜单"  split=true width=180px>
  		<!-- <ul id="tree"></ul> -->
  		<ul id="tree" class="ztree"></ul>
	</div>

	<div id="tabsMenu" class="easyui-menu" style="width:120px;">  
  		<div name="close">关闭</div>  
  		<div name="Other">关闭其他</div>  
  		<div name="All">关闭所有</div>
	</div>   
	

	<div id="dialog" class="easyui-dialog" style="width: 300px;height: 200px;text-align: center;"
	  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form">
  		<table style="border-spacing:10px;border-bottom: 0.5px;">
  			<tr>
  				<td style="text-align: right;">原密码：</td>
  				<td><input type="password" name="password" class="easyui-textbox" data-options="required:true,missingMessage:'原密码不能为空'"></td>
  			</tr>
  			<tr>
  				<td style="text-align: right;">新密码：</td>
  				<td><input id="pwd" type="password" name="newPassword" class="easyui-textbox" data-options="required:true,missingMessage:'新密码不能为空'"></td>
  			</tr>
  			<tr>
  				<td style="text-align: right;">重复新密码：</td>
  				<td><input type="password" name="newPassword2" class="easyui-textbox" required="required" missingMessage="重复新密码不能为空" validType="equals['#pwd']"></td>
  			</tr>
  		</table>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="changePassword()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog')">关闭</a>
	</div> 
	
	
	<div id="dialog1" class="easyui-dialog" style="width: 250px;height: 600px;text-align: center;"
	  	data-options="closed: true,draggable:false,modal:true">
  		
  	</div>
	 
</body>    
</html>

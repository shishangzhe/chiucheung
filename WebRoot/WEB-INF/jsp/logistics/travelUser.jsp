<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>用户管理</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
	}
  	$(function(){
		var tableId = "dg";
		var title = "差旅(APP)用户表";
		var url = "${pageContext.request.contextPath}/logistics/travelUser/findAllTravelUserList.action";
		var columns = [[
						{field:'workNo',title:'工号',width:120,align:'center',sortable:true},
				        {field:'username',title:'用户名',width:120,align:'center',sortable:true},
				        {field:'groupsId',title:'分组',width:120,align:'center',sortable:true},
				        {field:'isAllowedLogin',title:'是否允许登陆',width:100,align:'center',sortable:true},
				        {field:'deviceSerialNumber',title:'设备序列号',width:150,align:'center',sortable:true},
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
		//加载分组的combobox
		$('#groupsId_query').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "销售部"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		$('#groupsId').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "销售部"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		
		//加载是否允许登陆的combobox
		$('#isAllowedLogin').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "是否允许登陆"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		
		//form表单的回车事件，回车提交
		$("#form1").keyup(function (event){
			if (event.keyCode == 13){
				saveOrUpdate();
			}
		});
		//form查询表单的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
  	});
  	
  	//打开用户新增窗口
  	function add(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
				$('#workNo').textbox('enableValidation');//启用验证
				$('#workNo').textbox('readonly',false);//改为可写
		  		$('#username').textbox('enableValidation');//启用验证
				$('#username').textbox('readonly',false);//改为可写
				$('#password').textbox('enableValidation');//启用验证
				$('#level').combobox('clear');
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增用户'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	//打开用户修改窗口
  	function edit(){
  		$("#form1").form('reset');//重置表单数据
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$('#workNo').textbox('disableValidation');//禁用验证
  			$('#workNo').textbox('readonly',true);//改为只读
  			$('#username').textbox('disableValidation');//禁用验证
  			$('#username').textbox('readonly',true);//改为只读
  			$('#password').textbox('disableValidation');//禁用验证
			
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/logistics/travelUser/findTravelUserById.action?id="+select.id,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
					$("#form1").form('load',data);//读取记录填充到表单中。
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:"修改用户"//该dialog的标题
					});
				}
			});
			
  		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
  	}
  	//新增或者保存用户数据
  	function saveOrUpdate(){
  		if ($("#form1").form('validate')){//判断 验证是否通过
			var flag = $("#flag").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/logistics/travelUser/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveTravelUser.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateTravelUser.action";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: $("#form1").serialize(),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						showMessager("提示","保存成功");
						$("#dialog1").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg").datagrid('reload');//重新加载数据，保持在当前页
					}else{
						showMessager("错误","保存失败：<font color='red'>"+data.message+"</font>");
					}
				}
			});
		}
  	}
  	//删除用户数据
  	function removeData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/logistics/travelUser/deleteTravelUserById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","删除成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误","删除失败：<font color='red'>" + data.message + "</font>");
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
		}
  	}
  	
  	function unbind(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要解除绑定吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/logistics/travelUser/deleteDeviceSerialNumberById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","解除成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误","解除失败：<font color='red'>" + data.message + "</font>");
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
		}
  	}
  	//刷新数据
  	function reload(){
  		$("#dg").datagrid('reload');
  	}
  	//查询数据
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
  	}
  </script>
<body>   
	<table id="dg" 
		<p:isPrivilege pid="hi" mid="hib"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="hi" mid="hia"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="hi" mid="hib"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="hi" mid="hic"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="hi" mid="hid">
				<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="unbind();" style="float: left;">解除绑定</a> <div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				工号：<input id="workNo_query" type="text" class="easyui-textbox" name="workNo" style="width: 70px" >
				用户名：<input id="username_query" type="text" class="easyui-textbox" name="username" style="width: 70px" >
				分组：<input id="groupsId_query" class="easyui-combobox clearButton" name="groupsId" style="width: 100px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="hi" mid="hia"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
	    <p:isPrivilege pid="hi" mid="hib">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="hi" mid="hic"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="hi" mid="hid">
	    	<div data-options="iconCls:'icon-cancel'" onclick="unbind();">解除绑定</div>
		</p:isPrivilege>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 260px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="userId" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  			<tr>
	  				<td>
	  					工号：
	  				</td>
		  			<td>
		  				<input id="workNo" type="text" name="workNo" class="easyui-textbox" data-options="required:true,missingMessage:'工号不能为空',validType:'checkWorkNoIsRepeat'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					用户名：
	  				</td>
		  			<td>
		  				<input id="username" type="text" name="username" class="easyui-textbox" data-options="required:true,missingMessage:'用户名不能为空',validType:'checkUsernameIsRepeat'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					密码：
	  				</td>
		  			<td>
		  				<input id="password" type="password" name="password" class="easyui-textbox" data-options="required:true,missingMessage:'密码不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					分组：
	  				</td>
		  			<td>
		  				<input id="groupsId" name="groupsId" style="width: 100%" data-options="required:true,missingMessage:'分组不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					是否允许登陆：
	  				</td>
		  			<td>
		  				<input id="isAllowedLogin" name="isAllowedLogin" style="width: 100%" data-options="required:true,missingMessage:'是否允许登陆？'">
		  			</td>
	  			</tr>
  			</table>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdate()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
</body>    
</html>

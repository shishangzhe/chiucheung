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
		var title = "设备管理表";
		var url = "${pageContext.request.contextPath}/market/deviceNameSerialNumber/findAllDeviceNameSerialNumber.action";
		var columns = [[
				        {field:'deviceModel',title:'设备型号',width:420,align:'center',sortable:true},    
				        {field:'useName',title:'姓名',width:120,align:'center',sortable:true},
				        {field:'serialNumber',title:'序列号',width:150,align:'center',sortable:true},
				        {field:'isAllowedDownload',title:'是否允许下载',width:120,align:'center',sortable:true,formatter: function(value,row,index){
																																if (value){
																																	return "是";
																																}else{
																																	return "否";
																																}
																															}
						}
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
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
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增设备'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	//打开用户修改窗口
  	function edit(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/market/deviceNameSerialNumber/findDeviceNameSerialNumberById.action?id="+select.id,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#flag").val('update');
					$("#form1").form('load',data);
					$("#isAllowedDownload").combobox('setValue',$("#isAllowedDownload").combobox('getValue'));
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:"修改设备"//该dialog的标题
					});
				}
			});
  		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
  	}
  	
  //打开用户修改窗口
  	function copy(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/market/deviceNameSerialNumber/copyDeviceNameSerialNumberById.action?id="+select.id,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#flag").val('add');
					$("#form1").form('load',data);
					$("#isAllowedDownload").combobox('setValue',$("#isAllowedDownload").combobox('getValue'));
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:"新增设备"//该dialog的标题
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
			var url = "${pageContext.request.contextPath}/market/deviceNameSerialNumber/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveDeviceNameSerialNumber.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateDeviceNameSerialNumber.action";
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
						showMessager("错误",data.message);
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
						url: "${pageContext.request.contextPath}/market/deviceNameSerialNumber/deleteDeviceNameSerialNumberById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","删除成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误",data.message);
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
		<p:isPrivilege pid="bc" mid="bcb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="fi" mid="fia"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fi" mid="fib"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fi" mid="fia"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copy()" style="float: left;">复制</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fi" mid="fic"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			
		</div>
		<div>
			<form id="queryForm">
				设备型号：<input id="deviceModel_query" type="text" class="easyui-textbox" name="deviceModel" style="width: 70px" >
				使用者姓名：<input id="useName_query" type="text" class="easyui-textbox" name="useName" style="width: 70px" >
				序列号：<input id="serialNumber" type="password" name="serialNumber" class="easyui-textbox" style="width: 70px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="fi" mid="fia"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
	    <p:isPrivilege pid="fi" mid="fib">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="fi" mid="fia"> 
	    	<div data-options="iconCls:'icon-large-shapes'" onclick="copy();">复制</div>
	    </p:isPrivilege>
    	<p:isPrivilege pid="fi" mid="fic"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 220px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="userId" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td>
  						设备：
  					</td>
	  				<td>
		  				<input id="deviceModel" type="text" name="deviceModel" class="easyui-textbox" data-options="required:true,missingMessage:'设备不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					姓名：
	  				</td>
		  			<td>
		  				<input id="useName" type="text" name="useName" class="easyui-textbox" data-options="required:true,missingMessage:'姓名不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					序列号：
	  				</td>
		  			<td>
		  				<input id="serialNumber" type="text" name="serialNumber" class="easyui-textbox" data-options="required:true,missingMessage:'设备号不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					是否允许下载：
	  				</td>
		  			<td>
		  				<select id="isAllowedDownload" class="easyui-combobox" name="isAllowedDownload" style="width: 100%" data-options="editable:false">   
						    <option value="true">是</option>
						    <option value="false">否</option>
						</select>  
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

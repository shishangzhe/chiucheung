<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>地图经纬度</title>
	
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
		var title = "地图经纬度";
		var url = "${pageContext.request.contextPath}/system/mapLli/findAllMapLliList.action";
		var columns = [[
				        {field:'name',title:'中文名',width:150,align:'center',sortable:true},    
				        {field:'engName',title:'英文名',width:150,align:'center',sortable:true},
				        {field:'parent',title:'所属地图',width:100,align:'center',sortable:true},
				        {field:'longitude',title:'经度',width:100,align:'center',sortable:true},
				        {field:'latitude',title:'纬度',width:100,align:'center',sortable:true},
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
		
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
				$("#name").textbox('textbox').validatebox('options').validType = "checkMapNameIsRepeat['name']";
				$("#engName").textbox('textbox').validatebox('options').validType = "checkMapNameIsRepeat['engName']";
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增地图经纬度'//该dialog的标题
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
				url: "${pageContext.request.contextPath}/system/mapLli/findSysMapLliById.action?id="+select.id,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						$("#flag").val('update');
						$("#name").textbox('textbox').validatebox('options').validType = "";
						$("#engName").textbox('textbox').validatebox('options').validType = "";
						$("#form1").form('load',data.mapLli);
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:"修改地图经纬度"//该dialog的标题
						});
					}else{
						showMessager("错误",data.message);
					}
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
			var url = "${pageContext.request.contextPath}/system/mapLli/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveSysMapLli.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateSysMapLli.action";
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
						url: "${pageContext.request.contextPath}/system/mapLli/deleteSysMapLliById.action",//ajax请求的url
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
		<p:isPrivilege pid="bg" mid="bgb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="bg" mid="bga"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="bg" mid="bgb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="bg" mid="bgc"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm">
				中文名：<input id="name_query" type="text" class="easyui-textbox" name="name" style="width: 70px" >
				英文名：<input id="engName_query" type="text" class="easyui-textbox" name="engName" style="width: 70px">
				所属地图：<input id="parent_query" type="text" class="easyui-textbox" name="parent" style="width: 70px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <p:isPrivilege pid="bg" mid="bga"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <p:isPrivilege pid="bg" mid="bgb">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="bg" mid="bgc"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 300px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td>
  						中文名：
  					</td>
	  				<td>
		  				<input id="name" type="text" name="name" class="easyui-textbox" data-options="required:true,missingMessage:'中文名不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					英文名：
	  				</td>
		  			<td>
		  				<input id="engName" type="text" name="engName" class="easyui-textbox" data-options="required:true,missingMessage:'英文名不能为空',validType:'checkMapNameIsRepeat[\'engName\']'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					所有地图：
	  				</td>
		  			<td>
		  				<input id="parent" type="text" name="parent" class="easyui-textbox" data-options="required:true,missingMessage:'所属地图不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					经度：
	  				</td>
		  			<td>
		  				<input id="longitude" name="longitude" class="easyui-numberbox" data-options="precision:7,required:true,missingMessage:'经度不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					纬度：
	  				</td>
		  			<td>
		  				<input id="latitude" name="latitude" class="easyui-numberbox" data-options="precision:7,required:true,missingMessage:'纬度不能为空'">
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

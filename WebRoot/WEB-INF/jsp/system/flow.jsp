<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>流程管理</title>
	
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
		var title = "流程定义表";
		var url = "${pageContext.request.contextPath}/system/flow/findAllProcessDefinition.action";
		var columns = [[
				        {field:'deploymentId',title:'流程部署id',width:80,align:'center',sortable:true},    
				        {field:'id',title:'流程定义id',width:150,align:'center',sortable:true},
				        {field:'name',title:'流程定义名称',width:150,align:'center',sortable:true},
				        {field:'key',title:'流程定义key',width:150,align:'center',sortable:true},
				        {field:'version',title:'流程定义版本',width:100,align:'center',sortable:true},
				        {field:'bpmn',title:'bpmn',width:100,align:'center',
				        	formatter: function(value,row,index){
								return '<a href="${pageContext.request.contextPath}/system/flow/queryProcessDefinitionResource.action?' + value + '" target="_blank">查看bpmn</a>'
							}
						},
				        {field:'png',title:'图片',width:100,align:'center',
				        	formatter: function(value,row,index){
								return '<a href="${pageContext.request.contextPath}/system/flow/queryProcessDefinitionResource.action?' + value + '" target="_blank">查看图片</a>'
							}
						}
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
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增流程定义'//该dialog的标题
				});
			}
		});
  		
  	}
  	
  	//新增或者保存用户数据
  	function save(){
  		if ($("#form1").form('validate')){//判断 验证是否通过
			var url = "${pageContext.request.contextPath}/system/flow/saveDeployment.action";
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: new FormData($( "#form1" )[0]),//传的参数,序列化表单    
				async: false,//同步请求
				cache: false,//不缓存此页面
				contentType: false,
		        processData: false,
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data == '保存成功'){
						showMessager("提示",data);
						$("#dialog1").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg").datagrid('reload');//重新加载数据，保持在当前页
					}else{
						showMessager("错误",data);
					}
				}
			});
		}
  	}
  	//删除用户数据
  	function removeData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '删除该流程定义会同时删除该流程定义正在进行的流程，你真的要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/system/flow/deleteDeploymentByProcessDefinitionId.action",//ajax请求的url
						data: {ProcessDefinitionId:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data == '删除成功'){
								showMessager("提示",data);
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误",data);
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
	<table id="dg"></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="bf" mid="bfa"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="bf" mid="bfb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm">
				流程名称：<input id="name_query" type="text" class="easyui-textbox" name="name" style="width: 70px" >
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="bf" mid="bfa"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
    	<p:isPrivilege pid="bf" mid="bfb"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 400px;height: 160px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td style="text-align: right;">
  						选择流程的bpmn文件：
  					</td>
	  				<td>
		  				<input id="resource_bpmn" class="easyui-filebox" name="resource_bpmn" style="width:150px;" data-options="buttonText:'浏览',buttonAlign:'left',required:true,missingMessage:'文件不能为空',validType:'checkBPMN'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					选择流程的png文件：
	  				</td>
		  			<td>
		  				<input id="resource_png" class="easyui-filebox" name="resource_png" style="width:150px;" data-options="buttonText:'浏览',buttonAlign:'left',required:true,missingMessage:'文件不能为空',validType:'checkPNG'">
		  			</td>
	  			</tr>
  			</table>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>

</body>
<style>
	a{
		text-decoration: none;
		color: blue;
	}
	a:HOVER {
		color: blue;
	}
}
</style>    
</html>

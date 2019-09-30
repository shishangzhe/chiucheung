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
  	$(function(){
		var tableId = "dg";
		var title = "打卡";
		var url = "${pageContext.request.contextPath}/logistics/travelClockIn/findAllTravelClockInList.action";
		var columns = [[
						{field:'username',title:'姓名',width:80,align:'center',sortable:true},
				        {field:'clockOn',title:'打卡 时间',width:140,align:'center',sortable:true},
				        {field:'address',title:'打卡地点',width:500,align:'left',sortable:true},
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
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm">
				用户名：<input id="username_query" type="text" class="easyui-textbox" name="username" style="width: 70px" >
				日期：<input id="startTime_query" type="text" name="startTime" class="easyui-datebox" style="width: 100px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endTime_query" type="text" name="endTime" class="easyui-datebox" style="width: 100px" data-options="editable:false">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdate()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
</body>    
</html>

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
		var title = "展会报名表";
		var url = "${pageContext.request.contextPath}/market/exhibitionContact/findAllExhibitionContact.action";
		var columns = [[
				        {field:'exhibitionName',title:'展会名称',width:150,align:'center',sortable:true},    
				        {field:'userName',title:'姓名',width:120,align:'center',sortable:true},
				        {field:'phoneNumber',title:'电话',width:150,align:'center',sortable:true},
				        {field:'email',title:'邮箱',width:220,align:'center',sortable:true},
				        {field:'company',title:'公司',width:120,align:'center',sortable:true},
				        {field:'property',title:'性质',width:120,align:'center',sortable:true},
				        {field:'site',title:'站点',width:120,align:'center',sortable:true},
				        {field:'signUpTime',title:'报名时间',width:180,align:'center',sortable:true}
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
  	});
  	
  	//刷新数据
  	function reload(){
  		$("#dg").datagrid('reload');
  	}
  	//查询数据
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
  	}
  //导出excel
  	function exportExcel(){
  		/* var queryParams = $("#dg").datagrid('options').queryParams;//获取当前查询的条件
  		$("#exportExcel").form('load',queryParams);//将查询条件赋值到导出Excel表格的表单 */
  		$("#queryForm").submit();//提交表单
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
			<p:isPrivilege pid="fj" mid="fja"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportExcel();" style="float: left;">导出Excel</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm" action="${pageContext.request.contextPath }/market/exhibitionContact/exportExcel.action" method="post">
				展会名称：<input id="exhibitionName_query" type="text" class="easyui-textbox" name="exhibitionName" style="width: 70px" >
				站点：<input id="site_query" type="text" class="easyui-textbox" name="site" style="width: 70px" >
				日期：<input id="startTime_query" type="text" name="startTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endTime_query" type="text" name="endTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
</body>    
</html>

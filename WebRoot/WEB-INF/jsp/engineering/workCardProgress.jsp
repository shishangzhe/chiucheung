<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>工程工咭进度表</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
  	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
	}
  
  
	  $(function(){
			var tableId = "dg";
			var title = "工时";
			var url = "${pageContext.request.contextPath}/engineering/workCardProgress/findAllWorkCardProgressList.action";
			var columns = [[
					        {field:'workCardNo',title:'工咭号',width:100,align:'center',sortable:true},
					        {field:'quotationNo',title:'QN编号',width:100,align:'center',sortable:true},
					        {field:'projectLeader',title:'项目负责人',width:80,align:'center',sortable:true},
					        {field:'workCardDate',title:'下单日期',width:100,align:'center',sortable:true},
					        {field:'projectName',title:'货品名称',width:150,align:'center',sortable:true},
					        {field:'productModel',title:'规格型号',width:150,align:'center',sortable:true},
					        {field:'quantity',title:'数量',width:120,align:'center',sortable:true},
					        {field:'category',title:'类型',width:120,align:'center',sortable:true},
					        {field:'expectedDeliveryDate',title:'预交期',width:100,align:'center',sortable:true},
					        {field:'saleOweData',title:'欠设备资料',width:100,align:'center',sortable:true},
					        {field:'engReviewerDate',title:'工程评审时间',width:80,align:'center',sortable:true},
					        {field:'engReleaseDataDate',title:'工程预下资料日期',width:80,align:'center',sortable:true},
					        {field:'orderMaterialBom',title:'订料BOM',width:80,align:'center',sortable:true},
					        {field:'mainBody',title:'主体',width:80,align:'center',sortable:true},
					        {field:'other',title:'其他',width:80,align:'center',sortable:true},
					        {field:'bom',title:'BOM',width:80,align:'center',sortable:true},
					        {field:'engOweData',title:'尚欠资料',width:80,align:'center',sortable:true},
					        {field:'actualCompleteTime',title:'实际完成时间',width:80,align:'center',sortable:true},
					        {field:'engNgQuestion',title:'NG问题',width:80,align:'center',sortable:true},
					        {field:'engLeader',title:'工程负责人',width:80,align:'center',sortable:true},
					    ]];
			var gridToolBarId = "#gridToolBar";
			var menuId = "menu";
			loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
	  })
  </script>
<body>   
	<table id="dg" style="width: 715px;height: 675px;"
		<p:isPrivilege pid="cd" mid="cdb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="cd" mid="cda"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="cd" mid="cdb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			
			
		</div>
		<div>
			<form id="queryForm">
				工咭号：<input id="workCardNo_query" type="text" name="workCardNo" class="easyui-textbox" style="width: 70px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
  		<p:isPrivilege pid="cd" mid="cda"> 
    		<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		</p:isPrivilege>
    	<p:isPrivilege pid="cd" mid="cdb"> 
    		<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 306px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
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

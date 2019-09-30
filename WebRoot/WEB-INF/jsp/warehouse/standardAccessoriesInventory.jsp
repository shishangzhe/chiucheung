<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>生产工咭进度表</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
	  $(function(){
			//加载适用产品的combobox
			$('#product').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "适用产品"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false,//不允许编辑
			    multiple:true
			});
			
			
			
			//下面是查询的combobox
			//加载适用产品的combobox
			$('#productQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "适用产品"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载分类的combobox
			$('#classificationQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "分类"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载物料属性的combobox
			$('#materialPropertiesQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "物料属性"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载规格型号的combobox
			$('#specificationsQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "规格型号"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载高度的combobox
			$('#heightQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "高度"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载宽度的combobox
			$('#widthQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "宽度"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载深度的combobox
			$('#depthQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "深度"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			//加载颜色的combobox
			$('#colorQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "颜色"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			
			
			//加载仓存的combobox
			$('#warehouseInventoryQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "仓存"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			
			
			//加载仓位的combobox
			$('#warehousePositionsQuery').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "仓位"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			});
			
			
			var tableId = "dg";
			var title = "标准配件";
			var url = "${pageContext.request.contextPath}/warehouse/standardAccessoriesInventory/findAllWarStandardAccessoriesInventoryList.action";
			var columns = [[
							{field:'accessoriesCode',title:'K3代码',width:120,align:'center',sortable:true},
					        {field:'accessoriesName',title:'配件名称',width:120,align:'center',sortable:true},
					        {field:'existingQuantity',title:'现存数量',width:80,align:'center',sortable:true},
					        {field:'expectQuantity',title:'预计入库数量',width:90,align:'center',sortable:true},
					        {field:'occupyQuantity',title:'占有量',width:60,align:'center',sortable:true},
					        {field:'unit',title:'单位',width:50,align:'center',sortable:true},
					        {field:'product',title:'适用产品',width:100,align:'center',formatter: function(value,row,index){
		        																					$('#product').combobox('setValues',value);
		        																					var value = $('#product').combobox('getText');
		        																					return value.substring(0,value.length);
																								}
							},
					        {field:'classification',title:'分类',width:60,align:'center',sortable:true},
					        {field:'materialProperties',title:'物料属性',width:80,align:'center',sortable:true},
					        {field:'specifications',title:'规格型号',width:80,align:'center',sortable:true},
					        {field:'height',title:'高度',width:80,align:'center',sortable:true},
					        {field:'width',title:'宽度',width:80,align:'center',sortable:true},
					        {field:'depth',title:'深度',width:80,align:'center',sortable:true},
					        {field:'color',title:'颜色',width:50,align:'center',sortable:true},
					        {field:'lowestWarehousingQuantity',title:'最低存仓量',width:80,align:'center',sortable:true},
					        {field:'onceProduceQuantity',title:'一次生产量',width:80,align:'center',sortable:true},
					        {field:'eachNumber',title:'每套数量',width:60,align:'center',sortable:true},
					        {field:'warehouseInventory',title:'仓存',width:60,align:'center',sortable:true},
					        {field:'warehousePositions',title:'仓位',width:60,align:'center',sortable:true},
					        {field:'fileId',title:'附件',width:50,align:'center'},
					        {field:'remark',title:'备注',width:200,align:'center',sortable:true},
					    ]];
			var gridToolBarId = "#gridToolBar";
			var menuId = "menu";
			loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
			
			
			
			//form查询表单的回车事件，回车提交
			$("#queryForm").keyup(function (event){
				if (event.keyCode == 13){
					query();
				}
			});
	  });
	  
	  
	  
	  function reload(){
		  $("#dg").datagrid("reload");
	  }
	  
	  
	
	
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
  	}
  </script>
<body>   
	<table id="dg"></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div> -->
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			
		</div>
		<div>
			<form id="queryForm">
				K3代码：<input id="accessoriesNameQuery" class="easyui-textbox" name="accessoriesCode" style="width: 80px;">
				配件名称：<input id="accessoriesNameQuery" class="easyui-textbox" name="accessoriesName" style="width: 80px;">
				适用产品：<input id="productQuery" class="clearButton" name="product" style="width: 80px;">
				分类：<input id="classificationQuery" class="clearButton" name="classification" style="width: 80px;">
				物料属性：<input id="materialPropertiesQuery" class="clearButton" name="materialProperties" style="width: 80px;">
				规格型号：<input id="specificationsQuery" class="clearButton" name="specifications" style="width: 80px;">
				高度：<input id="heightQuery" name="height" class="clearButton" style="width: 80px;">
				宽度：<input id="widthQuery" name="width" class="clearButton" style="width: 80px;">
				深度：<input id="depthQuery" name="depth" class="clearButton" style="width: 80px;">
				颜色：<input id="colorQuery" name="color" class="clearButton" style="width: 80px;">
				仓存：<input id="warehouseInventoryQuery" class="clearButton" name="warehouseInventory" style="width: 80px;">
				仓位：<input id="warehousePositionsQuery" class="clearButton" name="warehousePositions" style="width: 80px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
   		<!-- <div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
	    <div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div> -->
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
		<input id="product" name="product" type="hidden">
</body>    
</html>

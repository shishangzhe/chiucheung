<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>库存查询</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
	  $(function(){
		  $(".easyui-combobox").combobox({
				url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
				valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:true,//允许编辑
			    panelHeight:'auto',
				events:{
					keyup:fnComFixedChineseInput,
					keydown:function(event){
						if (event.keyCode == 13){
							editableComboboxAutoCompleteSelect(this);
						}
					},
					change:function(){
						editableComboboxAutoCompleteSelect(this);
			    	}
				},
				onLoadSuccess:function(){
					if ($(this).attr("id") == "applicableProductQuery"){//代表queryFrom里有
						$("#applicableProduct").combobox({
				    		valueField:'dictionarieCode',//相当于select的key
						    textField:'dictionarieName',//相当于select的value
				    	});
						$("#applicableProduct").combobox('loadData',$(this).combobox('getData'));
					}
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			
			
			var tableId = "dg";
			var title = "库存查询";
			var url = "${pageContext.request.contextPath}/warehouse/materialInventory/findAllWarMaterialInventoryList.action";
			var columns = [[
							{field:'materialCode',title:'代码',width:120,halign:'center',align:'left',sortable:true},
							{field:'materialName',title:'名称',width:120,halign:'center',align:'left',sortable:true},
							{field:'materialType',title:'类型',width:60,halign:'center',align:'left',sortable:true},
					        {field:'existingQuantity',title:'现存数量',width:80,align:'center',sortable:true},
					        {field:'expectQuantity',title:'预计入库数量',width:90,align:'center',sortable:true},
					        {field:'occupyQuantity',title:'占有量',width:60,align:'center',sortable:true},
							{field:'applicableProduct',title:'适用产品',width:100,halign:'center',align:'left',formatter: function(value,row,index){
																									$('#applicableProduct').combobox('setValues',value);
																									var value = $('#applicableProduct').combobox('getText');
																									return value.substring(0,value.length);
																								}
							},
							{field:'classification',title:'分类',width:60,halign:'center',align:'left',sortable:true},
							{field:'materialProperties',title:'物料属性',width:80,halign:'center',align:'left',sortable:true},
							{field:'specifications',title:'规格型号',width:80,halign:'center',align:'left',sortable:true},
							{field:'length',title:'长度',width:80,halign:'center',align:'left',sortable:true},
							{field:'height',title:'高度',width:80,halign:'center',align:'left',sortable:true},
							{field:'width',title:'宽度',width:80,halign:'center',align:'left',sortable:true},
							{field:'depth',title:'深度',width:80,halign:'center',align:'left',sortable:true},
							{field:'color',title:'颜色',width:50,halign:'center',align:'left',sortable:true},
							{field:'purchaseUnit',title:'采购单位',width:80,halign:'center',align:'left',sortable:true},
							{field:'purchaseQuantityAccuracy',title:'采购数量精度',width:80,halign:'center',align:'left',sortable:true},
							{field:'useUnit',title:'使用单位',width:80,halign:'center',align:'left',sortable:true},
							{field:'useQuantityAccuracy',title:'使用数量精度',width:80,halign:'center',align:'left',sortable:true},
							{field:'unitConversionFormula',title:'单位换算公式',width:80,halign:'center',align:'left',sortable:true},
							{field:'batch',title:'批量',width:80,halign:'center',align:'left',sortable:true},
							{field:'procurementCycle',title:'采购周期',width:80,halign:'center',align:'left',sortable:true},
							{field:'division',title:'分割数',width:80,halign:'center',align:'left',sortable:true},
							{field:'productionWorkshop',title:'生产车间',width:80,halign:'center',align:'left',sortable:true},
							{field:'lowestWarehousingQuantity',title:'最低存仓量',width:80,halign:'center',align:'left',sortable:true},
							{field:'highestWarehousingQuantity',title:'最高存仓量',width:80,halign:'center',align:'left',sortable:true},
							{field:'onceProduceQuantity',title:'<span style="font-size:8px;">一次生产/订购量</span>',width:80,halign:'center',align:'left',sortable:true},
							{field:'minProduceQuantity',title:'<span style="font-size:8px;">最少生产/订购量</span>',width:80,halign:'center',align:'left',sortable:true},
							{field:'drawingNumber',title:'图号',width:80,halign:'center',align:'left'},
							{field:'inspectionStandard',title:'检验标准',width:80,halign:'center',align:'left'},
							{field:'inspectionWay',title:'检验方式',width:80,halign:'center',align:'left'},
							{field:'warehouse',title:'仓库',width:60,halign:'center',align:'left',sortable:true},
							{field:'warehousePositions',title:'仓位',width:60,halign:'center',align:'left',sortable:true},
							{field:'fileId',title:'附件',width:50,halign:'center',align:'left'},
							{field:'remark',title:'备注',width:200,halign:'center',align:'left',sortable:true}
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
				代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 80px;">
				名称：<input id="materialNameQuery" class="easyui-textbox" name="materialName" style="width: 80px;">
				类型：<input id="materialTypeQuery" class="easyui-combobox" name="materialType" style="width: 80px;" data-options="queryParams: {'keyword' : '类型'}">
				适用产品：<input id="applicableProductQuery" class="easyui-combobox" name="applicableProduct" style="width: 80px;" data-options="queryParams: {'keyword' : '适用产品'}">
				分类：<input id="classificationQuery" class="easyui-combobox" name="classification" style="width: 80px;" data-options="queryParams: {'keyword' : '分类'}">
				物料属性：<input id="materialPropertiesQuery" class="easyui-combobox" name="materialProperties" style="width: 80px;" data-options="queryParams: {'keyword' : '物料属性'}">
				规格型号：<input id="specificationsQuery" class="easyui-combobox" name="specifications" style="width: 80px;" data-options="queryParams: {'keyword' : '规格型号'}">
				颜色：<input id="colorQuery" name="color" class="easyui-combobox" style="width: 80px;" data-options="queryParams: {'keyword' : '颜色'}">
				长度：<input id="lengthQuery" name="length" class="easyui-combobox" style="width: 80px;" data-options="queryParams: {'keyword' : '长度'}">
				宽度：<input id="widthQuery" name="width" class="easyui-combobox" style="width: 80px;" data-options="queryParams: {'keyword' : '宽度'}">
				高度：<input id="heightQuery" name="height" class="easyui-combobox" style="width: 80px;" data-options="queryParams: {'keyword' : '高度'}">
				深度：<input id="depthQuery" name="depth" class="easyui-combobox" style="width: 80px;" data-options="queryParams: {'keyword' : '深度'}">
				仓库：<input id="warehouseQuery" class="easyui-combobox" name="warehouse" style="width: 80px;" data-options="queryParams: {'keyword' : '仓库'}">
				仓位：<input id="warehousePositionsQuery" class="easyui-combobox" name="warehousePositions" style="width: 80px;" data-options="queryParams: {'keyword' : '仓位'}">
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
		<input id="applicableProduct" name="product" type="hidden">
</body>    
</html>

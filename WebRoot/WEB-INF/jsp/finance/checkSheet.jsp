<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>差旅支出记录表</title>
	<jsp:include page="/common.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/fusioncharts.js"></script>
  </head>
  <script type="text/javascript">
  window.onload=window.onresize = function(){
	  if ($(document.body).width()<$("#dialog1").width()){
			if ($(document.body).height()<$("#dialog1").height()){
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width: $(document.body).width(),
					height:$(document.body).height(),
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:0
				});
			}else{
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width: $(document.body).width(),
					height:600,
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:($(document.body).height()-74-$("#dialog1").height())/2,
				});
			}
		}else{
			if ($(document.body).height()<($("#dialog1").height()+74)){
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width: 800,
					height:$(document.body).height(),
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:0
				});
			}else{
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width:800,
					height:600,
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:($(document.body).height()-74-$("#dialog1").height())/2,
				});
			}
		}
	  $("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
  }
	$(function () {
		$('#dg').treegrid({
			title:'报账单',
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
		    url:'${pageContext.request.contextPath}/finance/checkSheet/findAllCheckSheetList.action',    
		    idField:'id', 
		    treeField:'checkSheetNo',  
		    toolbar: '#gridToolBar',
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    //rownumbers:true,//显示一个行号列。
		    //lines:true,//定义是否显示treegrid行
		    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
		    frozenColumns:[[
							{field:'checkSheetNo',title:'报账单号',width:110,align:'center',sortable:true},
							{field:'applicant',title:'<div style="height:100%;float:left">申请<br>人</div><div style="height:9px"></div>',width:50,align:'center',sortable:true},
							{field:'installWorkCardNo',title:'<div style="height:100%;float:left">安装<br>工咭号</div><div style="height:9px"></div>',width:70,align:'center',sortable:true},
							{field:'totalCost',title:'总费用',width:80,align:'center',sortable:true},
							{field:'projectManager',title:'<div style="height:100%;float:left">项目<br>经理</div><div style="height:9px"></div>',width:50,align:'center',sortable:true},
							{field:'accompanyingPersonnel',title:'随同人员',width:120,align:'center',sortable:true},
							{field:'businessTripDate',title:'出差时间',width:75,align:'center',sortable:true},
							{field:'departureDate',title:'离开时间',width:75,align:'center',sortable:true},
							{field:'travelPlace',title:'出差地点',width:85,align:'center',sortable:true},
							{field:'travelDate',title:'日期',width:80,align:'center',sortable:true},
							{field:'username',title:'姓名',width:50,align:'center',sortable:true},
		                      ]],
		    columns:[[	
						{field:'workCardNo',title:'工咭号',width:70,align:'center',rowspan:2,sortable:true},
				        {field:'isAirpoint',title:'<div style="height:100%;float:left">机场<br>项目</div><div style="height:9px"></div>',width:40,align:'center',rowspan:2,sortable:true},
				        {field:'provinces',title:'省份',width:45,align:'center',rowspan:2,sortable:true},
				        {field:'city',title:'城市',width:45,align:'center',rowspan:2,sortable:true},
						{title:'住宿',colspan:2},
				        {title:'上午',colspan:3},
				        {title:'下午',colspan:3},
				        {title:'晚上',colspan:3},
				        {field:'startPoint',title:'起点',width:45,align:'center',rowspan:2},
				        {field:'endPoint',title:'终点',width:45,align:'center',rowspan:2},
				        {field:'trafficType',title:'交通类型',width:60,align:'center',rowspan:2},
				        {field:'invoiceType',title:'有无发票',width:60,align:'center',rowspan:2},
				        {field:'trafficPrice',title:'价格',width:45,align:'center',rowspan:2,formatter: function(value,row,index){
																											if (value != undefined && value != null && value != ""){
																												if ((value*1).toFixed(0) == value*1){//如果小数点后面不是两位，则截取两位小数点
																													value = (value*1).toFixed(0);
																												}
																											}
																											return value;
																										}
						},
				        {field:'description',title:'费用描述',width:100,align:'center',rowspan:2},
				        {field:'subsidiesType',title:'费用类型',width:60,align:'center',rowspan:2},
				        {field:'otherPrice',title:'价格',width:45,align:'center',rowspan:2,formatter: function(value,row,index){
																											if (value != undefined && value != null && value != ""){
																												if ((value*1).toFixed(0) == value*1){//如果小数点后面不是两位，则截取两位小数点
																													value = (value*1).toFixed(0);
																												}
																											}
																											return value;
																										}
				        },
				    ],[
						{field:'liveNumber',title:'房间数',width:55,align:'center',sortable:true},
						{field:'livePrice',title:'价格',width:50,align:'center',sortable:true},
						{field:'startTime1',title:'开始时间',width:70,align:'center',sortable:true},
				        {field:'endTime1',title:'结束时间',width:70,align:'center',sortable:true},
				        {field:'lunch',title:'午餐',width:50,align:'center',sortable:true},
				        {field:'startTime2',title:'开始时间',width:70,align:'center',sortable:true},
				        {field:'endTime2',title:'结束时间',width:70,align:'center',sortable:true},
				        {field:'dinner',title:'晚餐',width:50,align:'center',sortable:true},
				        {field:'startTime3',title:'开始时间',width:70,align:'center',sortable:true},
				        {field:'endTime3',title:'结束时间',width:70,align:'center',sortable:true},
				        {field:'midnightSnack',title:'夜宵',width:50,align:'center',sortable:true}
				    ]],
			onContextMenu: function(e, row) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).treegrid('clearSelections');
                if (row!=null){
                	$(this).treegrid("select", row.id); //根据索引选中该行
				}
                $("#menu").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },
		    onBeforeExpand:function(row){
		    	//动态设置展开查询的url 
		    	/* var url = '${pageContext.request.contextPath}/finance/checkSheet/findAllCheckSheetList.action'; 
                $(this).treegrid("options").url = url;  
                return true;  */
		    	var url = "";
                //动态设置展开查询的url
                if ($(this).treegrid('getLevel',row.id) == 1){
		    		url = '${pageContext.request.contextPath}/finance/checkSheet/findAllTravelSpendingRecordsByFinCheckSheetId.action'; 
                }else if ($(this).treegrid('getLevel',row.id) == 2){
                	url = '${pageContext.request.contextPath}/finance/checkSheet/findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId.action';
                }
                $(this).treegrid("options").url = url;  
                return true;      
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/finance/checkSheet/findAllCheckSheetList.action'; 
                $(this).treegrid("options").url = url;
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/finance/checkSheet/findAllCheckSheetList.action'; 
                $(this).treegrid("options").url = url;
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/finance/checkSheet/findAllCheckSheetList.action'; 
                $(this).treegrid("options").url = url;
            }
		});
		
		$("#selectChartType").combobox();
		$("#selectChartType").combobox("loadData",[
		                                           {value:'column2D',text:'柱状图2D'},
		                                           {value:'column3D',text:'柱状图3D'},
		                                           {value:'line2D',text:'线性图'},
		                                           {value:'area2D',text:'面积图'},
		                                           {value:'pie2D',text:'饼状图2D'},
		                                           {value:'pie3D',text:'饼状图3D'}
		                                           ]);
		$('#selectChartType').combobox({
			onChange: function(newValue,oldValue){
				graphicalReportsForFCF();
			}
		});


		
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		
	});
	
	
	
	function reload(){
		$("#dg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
		$("#dg").treegrid('clearSelections');
	}
	
	function query(){
		$("#dg").treegrid('load',$("#queryForm").serializeObject());//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	function exportExcelForCheckSheet(){
		var selected = $('#dg').treegrid("getSelected");
		if (selected != null){
			var id = "";
			//判断是否是子节点
			if ($('#dg').treegrid('getLevel',selected.id) == 1){//是父节点
				id = selected.id;
			}else if ($('#dg').treegrid('getLevel',selected.id) == 2){//如果是父节点下的父节点
				id = selected._parentId;
			}else{//父节点下的父节点下的子节点
				id = $('#dg').treegrid('getParent',selected.id)._parentId;
			}
			window.open("${pageContext.request.contextPath }/finance/checkSheet/exportExcelForCheckSheetById.action?id="+id);
		}else{
			showMessager("提示","请选择一条记录进行导出");
		}
	}
	
	var column2D = new FusionCharts("Column2D.swf", "Column2D", "780", "480", "0", "0");
	var column3D = new FusionCharts("Column3D.swf", "Column3D", "780", "480", "0", "0");
	var line2D = new FusionCharts("Line.swf", "Line2D", "780", "480", "0", "0");
	var area2D = new FusionCharts("Area2D.swf", "Area2D", "780", "480", "0", "0");
	var pie2D = new FusionCharts("Pie2D.swf", "Pie2D", "780", "480", "0", "0");
	var pie3D = new FusionCharts("Pie3D.swf", "Pie3D", "780", "480", "0", "0");
	function graphicalReportsForFCF(){
		var fusionCharts = $("#selectChartType").combobox("getValue");
		if ($("#selectChartType").combobox("getValue") == "" || $("#selectChartType").combobox("getValue") == null || $("#selectChartType").combobox("getValue") == undefined){
			$("#selectChartType").combobox("setValue","column2D");
			fusionCharts = "column2D";
		}else{
			var selected = $('#dg').treegrid("getSelected");
			if (selected != null){
				var id = "";
				//判断是否是子节点
				if ($('#dg').treegrid('getLevel',selected.id) == 1){//是父节点
					id = selected.id;
				}else if ($('#dg').treegrid('getLevel',selected.id) == 2){//如果是父节点下的父节点
					id = selected._parentId;
				}else{//父节点下的父节点下的子节点
					id = $('#dg').treegrid('getParent',selected.id)._parentId;
				}
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath }/finance/checkSheet/graphicalReportsForFCFById.action",//ajax请求的url
					data: {id:id},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							if (data.success){
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'图形报表'//该dialog的标题
								});
								
								switch (fusionCharts) {
									case "column2D":
										//column2D.setJSONData(data.chartData);
										column2D.setXMLData(data.chartData);
										column2D.render("chartdiv");
										break;
									case "column3D":
										//column3D.setJSONData(data.chartData);
										column3D.setXMLData(data.chartData);
										column3D.render("chartdiv");
										break;
									case "line2D":
										//line2D.setJSONData(data.chartData);
										line2D.setXMLData(data.chartData);
										line2D.render("chartdiv");
										break;
									case "area2D":
										//line2D.setJSONData(data.chartData);
										area2D.setXMLData(data.chartData);
										area2D.render("chartdiv");
										break;
									case "pie2D":
										//line2D.setJSONData(data.chartData);
										pie2D.setXMLData(data.chartData);
										pie2D.render("chartdiv");
										break;
									case "pie3D":
										//line2D.setJSONData(data.chartData);
										pie3D.setXMLData(data.chartData);
										pie3D.render("chartdiv");
										break;
								}
								
							}else{
								showMessager("错误",'<font color="red">'+data.message+'<font/>');
							}
						}
					}
				});
			}else{
				showMessager("提示","请选择一条记录");
			}
		}
	}
	
	function tackBackToLogistics(){
		var selected = $('#dg').treegrid("getSelected");
		if (selected != null){
			$.messager.confirm('确认对话框', '您确定要退回给物流吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
					var id = "";
					//判断是否是子节点
					if ($('#dg').treegrid('getLevel',selected.id) == 1){//是父节点
						id = selected.id;
					}else if ($('#dg').treegrid('getLevel',selected.id) == 2){//如果是父节点下的父节点
						id = selected._parentId;
					}else{//父节点下的父节点下的子节点
						id = $('#dg').treegrid('getParent',selected.id)._parentId;
					}
					$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/finance/checkSheet/updateCheckSheetByIdForTackBackToLogistics.action",//ajax请求的url
						data: {id:id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data != null && data != ""){
								if (data.success){
									showMessager("提示","退回成功");
									reload();
								}else{
									showMessager("错误",'<font color="red">'+data.message+'<font/>');
								}
							}
						}
					});
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行退回");
		}
	}
	
	function expand(){
		var selected = $('#dg').treegrid("getSelected");
		if (selected != null){
			var id = "";
			//判断是否是子节点
			if ($('#dg').treegrid('getLevel',selected.id) == 1){//是父节点
				id = selected.id;
			}else if ($('#dg').treegrid('getLevel',selected.id) == 2){//如果是父节点下的父节点
				id = selected._parentId;
			}else{//父节点下的父节点下的子节点
				id = $('#dg').treegrid('getParent',selected.id)._parentId;
			}
			$('#dg').treegrid('expandAll',id);
		}else{
			showMessager("提示","请选择一条记录进行退回");
		}
	}
  </script>
  <body>
  
  	<table id="dg"   
  		
  		data-options="onDblClickRow:function (row){$(this).treegrid(row.state == 'closed' ? 'expand' : 'collapse',row.id)}"
  		
  	></table>
  	
  	<div id="gridToolBar" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="gi" mid="gia">
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportExcelForCheckSheet();" style="float: left;">导出报账单</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gi" mid="gib">
				<a href="#" class="easyui-linkbutton" iconCls="icon-large-chart" plain="true" onclick="graphicalReportsForFCF();" style="float: left;">图形报表</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gi" mid="gic">
				<a href="#" class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="tackBackToLogistics();" style="float: left;">退回物流</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" plain="true" onclick="expand();" style="float: left;">展开</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm">
				报账单号：<input id="checkSheetNo_query" type="text" class="easyui-textbox" name="checkSheetNo" style="width: 70px">
				申请人：<input id="applicant_query" type="text" class="easyui-textbox" name="applicant" style="width: 70px">
				安装工咭号：<input id="installWorkCardNo_query" type="text" class="easyui-textbox" name="installWorkCardNo" style="width: 70px" >
				项目经理：<input id="projectManager_query" type="text" class="easyui-textbox" name="projectManager" style="width: 70px">
				出差地点：<input id="travelPlace_query" type="text" class="easyui-textbox" name="travelPlace" style="width: 70px" >
				
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	   	<p:isPrivilege pid="gi" mid="gia">
	   		<div data-options="iconCls:'icon-redo'" onclick="exportExcelForCheckSheet();">导出报账单</div>
	   	</p:isPrivilege>
	   	<p:isPrivilege pid="gi" mid="gib">
	   		<div data-options="iconCls:'icon-large-chart'" onclick="graphicalReportsForFCF();">图形报表</div>
	   	</p:isPrivilege>
	   	<p:isPrivilege pid="gi" mid="gic">
	   		<div data-options="iconCls:'icon-back'" onclick="tackBackToLogistics();">退回物流</div>
	   	</p:isPrivilege>
	   	<div onclick="expand();">展开</div>
	</div>
	<div id="dialog1" class="easyui-dialog" style="width: 800px;height: 600px;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb1'">
  		<input id="selectChartType" type="text" style="width: 120px;" data-options="editable:false">
  		<div id=chartdiv>
  		</div>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1');">关闭</a>
	</div>
  	
  </body>
</html>

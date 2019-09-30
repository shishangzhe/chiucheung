<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>差旅支出记录表</title>
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
	$(function () {
		$('#dg').treegrid({
			title:'差旅支出记录表',
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
		    url:'${pageContext.request.contextPath}/finance/travelSpendingRecords/findAllTravelSpendingRecords.action',    
		    idField:'id', 
		    treeField:'travelDate',  
		    toolbar: '#gridToolBar',
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    //rownumbers:true,//显示一个行号列。
		    //lines:true,//定义是否显示treegrid行
		    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
		    frozenColumns:[[
						{field:'travelDate',title:'日期',width:120,align:'center',sortable:true},
						{field:'username',title:'姓名',width:60,align:'center',sortable:true},
						{field:'workCardNo',title:'工咭号',width:70,align:'center',sortable:true},
	                      ]],
		    columns:[[	
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
		    	var url = '${pageContext.request.contextPath}/finance/travelSpendingRecords/findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId.action'; 
                $(this).treegrid("options").url = url;  
                return true; 
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/finance/travelSpendingRecords/findAllTravelSpendingRecords.action'; 
                $(this).treegrid("options").url = url;
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/finance/travelSpendingRecords/findAllTravelSpendingRecords.action'; 
                $(this).treegrid("options").url = url;
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/finance/travelSpendingRecords/findAllTravelSpendingRecords.action'; 
                $(this).treegrid("options").url = url;
            }
		});
		
		
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		
		$("#form1").keyup(function (event){
			if (event.keyCode == 13){
				calculate();
			}
		});
		
	});
	
	
	function reload(){
		$("#dg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	function query(){
		$("#dg").treegrid('load',$("#queryForm").serializeObject());//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	
	function numberToFixed(obj){
		if (obj.toFixed(0) == obj){//如果小数点是0，则取整数
			obj = obj.toFixed(0);
		}
		return obj;
	}
	
	function calculateCost(){
		$("#workCardNo").textbox("clear");
		$("#results").html("");
		$("#dialog1").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:'计算成本'//该dialog的标题
		});
	}
	
	function calculate(){
		if ($("#form1").form('validate')){//判断 验证是否通过
			$.ajax({
				type:'POST',//post请求
				url: '${pageContext.request.contextPath}/finance/travelSpendingRecords/calculateCostByWorkCardNo.action',//ajax请求的url
				data: $( "#form1" ).serialize(),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success){
							$("#results").html(data.results);
						}else{
							showMessager("错误",'<font color="red">'+data.message+'<font/>');
						}
					}
				}
			});
		}
	}
  </script>
  <body>
  
  	<table id="dg"   
  		
  		data-options="onDblClickRow:function (row){
													    	if ($(this).treegrid('isLeaf',row.id)){//判断是否是子节点
														    	<p:isPrivilege pid="hj" mid="hjb">
														    		edit();//是子节点则开始编辑
													    		</p:isPrivilege>
													    	}else{
													    		<p:isPrivilege pid="hh" mid="hj">
														    		$(this).treegrid(row.state == 'closed' ? 'expand' : 'collapse',row.id);//是父节点则展开或折叠
														    	</p:isPrivilege>
													    	}
													    }"
  		
  	></table>
  	
  	<div id="gridToolBar" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-sum" plain="true" onclick="calculateCost();" style="float: left;">计算成本</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm">
				姓名：<input id="username_query" type="text" class="easyui-textbox" name="username" style="width: 70px" >
				工咭号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				省份：<input id="provinces_query" type="text" class="easyui-textbox" name="provinces" style="width: 70px" >
				城市：<input id="city_query" type="text" class="easyui-textbox" name="city" style="width: 70px" >
				
				日期：<input id="startTime_query" type="text" name="startTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endTime_query" type="text" name="endTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
  	
  	
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 150px;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb1'">
  		<div style="padding-top: 20px;">
  			<form id="form1">
  				工咭号：<input id="workCardNo" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkWorkCardNoFormat'">
  				<a href="#" class="easyui-linkbutton" onclick="calculate()">计算</a>
  			</form>
  			<div id="results"></div>
  		</div>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
  </body>
</html>

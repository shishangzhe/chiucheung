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
		$("#dialog2").dialog({//加载一个dialog
			closed:$("#dialog2").dialog("options").closed,
			left:($(document.body).width()-$("#dialog2").width())/2,
			top:($(document.body).height()-74-$("#dialog2").height())/2,
		});
	}
  	$(function(){
		var tableId = "dg";
		var title = "厂购飞机/火车票";
		var url = "${pageContext.request.contextPath}/finance/planeTrainTicket/findAllPlaneTrainTicketList.action";
		var columns = [[
						{field:'workCardNo',title:'工咭号',width:100,align:'center',sortable:true},
						{field:'trafficType',title:'类型',width:50,align:'center',sortable:true},
				        {field:'orderTicketsDate',title:'订票日期',width:100,align:'center',sortable:true},
				        {field:'departureTime',title:'出发时间',width:150,align:'center',sortable:true},
				        {field:'travelPersonnel',title:'出差人员',width:80,align:'center',sortable:true},
				        {field:'startPoint',title:'出发地',width:80,align:'center',sortable:true},
				        {field:'endPoint',title:'目的地',width:80,align:'center',sortable:true},
				        {field:'planeTrainNumber',title:'航班号/车次',width:80,align:'center',sortable:true},
				        {field:'seat',title:'座位',width:60,align:'center',sortable:true},
				        {field:'berth',title:'铺位',width:80,align:'center',sortable:true},
				        {field:'price',title:'价格',width:80,align:'center',sortable:true,formatter: function(value,row,index){
							if (value*1 >=0){
								return value;
							}else{
								return "<font color='red'>"+value+"</font>";
							}
						}
				        	
				        },
				        {field:'orderNumber',title:'订单号',width:100,align:'center',sortable:true},
				        {field:'remark',title:'备注',width:200,align:'center',sortable:true},
				        {field:'isLock',title:'是否已报账',width:100,align:'center',sortable:true,formatter: function(value,row,index){
																												if (value){
																													return '<img alt="" src="${pageContext.request.contextPath }/jquery-easyui-1.4.5/themes/icons/ok.png">';
																												}else{
																													return '<img alt="" src="${pageContext.request.contextPath }/jquery-easyui-1.4.5/themes/icons/no.png">';
																												}
																											}
				        },
				        {field:'isReceiveReceipt',title:'是否收回票据',width:100,align:'center',sortable:true,formatter: function(value,row,index){
																															if (value){
																																return '<img alt="" src="${pageContext.request.contextPath }/jquery-easyui-1.4.5/themes/icons/ok.png">';
																															}else{
																																return '<img alt="" src="${pageContext.request.contextPath }/jquery-easyui-1.4.5/themes/icons/no.png">';
																															}
																														}
				        }
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
		
		
		$('#travelPersonnel').combogrid({
			url:'${pageContext.request.contextPath}/finance/planeTrainTicket/findAllTravelUserList.action',
			panelWidth:420,    
		    idField:'username',//下列表的标识id    
		    textField:'username',//下拉框文本显示的字段
		    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
		    editable:false,//下拉框文本不可以编辑
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    toolbar:'#gridToolBar2',
		    columns:[[	
						{field:'workNo',title:'工号',width:70,align:'center'},
						{field:'username',title:'姓名',width:70,align:'center'},
						{field:'groupsId',title:'分组',width:70,align:'center'},
						{field:'isAllowedLogin',title:'是否允许登陆',width:70,align:'center'}
				    ]],//表格的各个字段
					fitColumns: true
		});
		
		$('#groupsId_query2').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "销售部"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		
		
		//form表单的回车事件，回车提交
		$("#form1").keydown(function (event){
			if (event.keyCode == 13){
				saveOrUpdate();
			}
		});

		//form查询表单的回车事件，回车提交
		$("#queryForm").keydown(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		
		//form查询表单的回车事件，回车提交
		$("#queryForm2").keydown(function (event){
			if (event.keyCode == 13){
				query2();
			}
		});
		
		$("#trafficType").combobox({
			onChange: function(newValue,oldValue){
				if (newValue == "火车"){
					$("#seat").textbox("enable");
					$("#berth").textbox("enable");
					$("#orderNumber").textbox("enable");
				}else {
					$("#seat").textbox("clear");
					$("#seat").textbox("disable");
					$("#berth").textbox("clear");
					$("#berth").textbox("disable");
					$("#orderNumber").textbox("clear");
					$("#orderNumber").textbox("disable");
				}
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
				
				$("#form1 .easyui-textbox").each(function(index, domEle){
					if (index != 8){//备注
					   $(domEle).textbox('enable');
					}
				 });
				$("#trafficType").combobox('enable');
				$("#orderTicketsDate").datebox('enable');
				$("#departureTime").datetimebox('enable');
				$("#price").numberbox('enable');
				
				$("#queryForm2").form('reset');
				query2();
				
				$("#trafficType").combobox('select','火车');
				$("#seat").textbox("enable");
				$("#berth").textbox("enable");
				$("#orderNumber").textbox("enable");
				$("#isLock").val(false);
				$("#isReceiveReceipt").val(false);
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增厂购飞机/火车票'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	//打开用户修改窗口
  	function edit(){
  		$("#form1").form('reset');//重置表单数据
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var url = "${pageContext.request.contextPath}/finance/planeTrainTicket/findPlaneTrainTicketById.action";//根据ID从后台取数据的url
  			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: {id:select.id},//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
						$("#form1").form('load',data.planeTrainTicket);//读取记录填充到表单中。
						if (data.planeTrainTicket.isReceiveReceipt|| data.planeTrainTicket.isLock){//交票了或报账了
							$("#form1 .easyui-textbox").each(function(index, domEle){
								if (index != 8){//备注
								   $(domEle).textbox('disable');
								}
							 });
							$("#trafficType").combobox('disable');
							$("#orderTicketsDate").datebox('disable');
							$("#departureTime").datetimebox('disable');
							$("#price").numberbox('disable');
						}else{
							$("#queryForm2").form('reset');
							
							$("#username_query2").textbox("setValue",data.planeTrainTicket.travelPersonnel);
							query2();
							
							$("#form1 .easyui-textbox").each(function(index, domEle){
								if (index != 8){//备注
								   $(domEle).textbox('enable');
								}
							 });
							$("#trafficType").combobox('enable');
							$("#orderTicketsDate").datebox('enable');
							$("#departureTime").datetimebox('enable');
							$("#price").numberbox('enable');
							
							if ($("#trafficType").combobox('getValue')=="飞机"){
								$("#seat").textbox("clear");
								$("#seat").textbox("disable");
								$("#berth").textbox("clear");
								$("#berth").textbox("disable");
								$("#orderNumber").textbox("clear");
								$("#orderNumber").textbox("disable");
							}
							
							/* if ($("#trafficType").combobox('getValue')=="火车"){
								$("#seat").textbox("enable");
								$("#berth").textbox("enable");
								$("#orderNumber").textbox("enable");
							}else{
								$("#seat").textbox("clear");
								$("#seat").textbox("disable");
								$("#berth").textbox("clear");
								$("#berth").textbox("disable");
								$("#orderNumber").textbox("clear");
								$("#orderNumber").textbox("disable");
							} */
						}
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:"修改厂购飞机/火车票"//该dialog的标题
						});
					}else{
						showMessager("错误","<font color='red'>"+data.message+"</font>");
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
			var url = "${pageContext.request.contextPath}/finance/planeTrainTicket/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "savePlaneTrainTicket.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updatePlaneTrainTicket.action";
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
						$("#dg").datagrid('clearSelections');//清除所有选择的行
					}else{
						showMessager("错误","保存失败：<font color='red'>"+data.message+"</font>");
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
						url: "${pageContext.request.contextPath}/finance/planeTrainTicket/deletePlaneTrainTicketById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","删除成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误","删除失败：<font color='red'>" + data.message + "</font>");
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
		}
  	}
  	//复制
  	function copy(){
  		$("#form1").form('reset');//重置表单数据
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var url = "${pageContext.request.contextPath}/finance/planeTrainTicket/copyPlaneTrainTicketById.action?id="+select.id;//根据ID从后台取数据的url
			$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$("#form1").form('load',url);//读取记录填充到表单中。
			
			$("#queryForm2").form('reset');
			$("#username_query2").textbox("setValue",$("#travelPersonnel").combogrid("getValue"));
			query2();
			
			$("#form1 .easyui-textbox").each(function(index, domEle){
				if (index != 8){//备注
				   $(domEle).textbox('enable');
				}
			 });
			$("#trafficType").combobox('enable');
			$("#orderTicketsDate").datebox('enable');
			$("#departureTime").datetimebox('enable');
			$("#price").numberbox('enable');
			
			if ($("#trafficType").combobox('getValue')=="飞机"){
				$("#seat").textbox("clear");
				$("#seat").textbox("disable");
				$("#berth").textbox("clear");
				$("#berth").textbox("disable");
				$("#orderNumber").textbox("clear");
				$("#orderNumber").textbox("disable");
			}
			$("#dialog1").dialog({//加载一个dialog
				closed:false,//将该dialog的状态由不显示改成显示
				title:"新增厂购飞机/火车票"//该dialog的标题
			});
  		}else{
			showMessager("提示","请选择一条记录进行复制");
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
  	
  	function query2(){
  		$("#travelPersonnel").combogrid('grid').datagrid('load',$("#queryForm2").serializeObject());//重新加载数据
		$("#travelPersonnel").combogrid('grid').datagrid('clearSelections');//清除所有选择的行
  	}
  	
  	//设为已报账
  	function lock(isLock){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var tipMsg = "";
  			if (isLock){
  				tipMsg = "您确定要设为已报账吗？";
  			}else{
  				tipMsg = "您确定要设为未报账吗？";
  			}
  			$.messager.confirm('确认对话框', tipMsg, function(b){//给用户一个确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/finance/planeTrainTicket/updatePlaneTrainTicketByIdForLock.action",//ajax请求的url
						data: {id:select.id,isLock:isLock},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","设置成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误","设置失败：<font color='red'>" + data.message + "</font>");
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行设置");
		}
  	}
  	
  	//设为已收票据
  	function receiveReceipt(isReceiveReceipt){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var tipMsg = "";
  			if (isLock){
  				tipMsg = "您确定要设为已收票据吗？";
  			}else{
  				tipMsg = "您确定要设为未收票据吗？";
  			}
  			$.messager.confirm('确认对话框', tipMsg, function(b){//给用户一个确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/finance/planeTrainTicket/updatePlaneTrainTicketByIdForReceiveReceipt.action",//ajax请求的url
						data: {id:select.id,isReceiveReceipt:isReceiveReceipt},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","设置成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误","设置失败：<font color='red'>" + data.message + "</font>");
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行设置");
		}
  	}
  	
  	function openImportExcelDialog(){
  		$("#form2").form('reset');//重置表单数据
  		$("#dialog2").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:"导入Excel"//该dialog的标题
		});
  	}
  	
  	//导入Excel
  	function importExcel(){
  		if ($("#form2").form('validate')){//判断 验证是否通过
	  		$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/finance/planeTrainTicket/importExcel.action",//ajax请求的url
				data: new FormData($( "#form2" )[0]),
				async: false,//同步请求
				cache: false,//不缓存此页面
				contentType: false,  
		        processData: false,  
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success){
							showMessager("提示",data.message);
							$("#dg").datagrid('reload');//重新加载数据，保持在当前页
							$("#dg").datagrid('clearSelections');//清除所有选择的行
						}else{
							showMessager("错误",'<font color="red">' + data.message + '<font/>');
						}
					}
				}
			});
  		}
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
		<p:isPrivilege pid="gh" mid="ghb">
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="gh" mid="gha"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gh" mid="ghb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gh" mid="ghc"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gh" mid="gha"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copy()" style="float: left;">复制</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="gh" mid="ghd"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="lock(true);" style="float: left;">设为已报账</a><div class="btn-separator"></div>
				<a href="#" class="easyui-linkbutton" iconCls="icon-no" plain="true" onclick="lock(false);" style="float: left;">设为未报账</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gh" mid="ghe"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="receiveReceipt(true);" style="float: left;">设为已收票据</a><div class="btn-separator"></div>
				<a href="#" class="easyui-linkbutton" iconCls="icon-no" plain="true" onclick="receiveReceipt(false);" style="float: left;">设为未收票据</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gh" mid="ghf"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="openImportExcelDialog();" style="float: left;">导入Excel</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gh" mid="ghg"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportExcel();" style="float: left;">导出Excel</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm" action="${pageContext.request.contextPath }/finance/planeTrainTicket/exportExcel.action" method="post">
				工咭号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				类型：<input id="trafficType_query" class="easyui-combobox clearButton" name="trafficType" style="width: 70px" data-options="editable:false,
																															valueField: 'label',
																															textField: 'value',
																															data: [{
																																label: '火车',
																																value: '火车'
																															},{
																																label: '飞机',
																																value: '飞机'
																															}]" />
				出差人员：<input id="travelPersonnel_query" type="text" class="easyui-textbox" name="travelPersonnel" style="width: 70px" >
				日期：<input id="startTime_query" type="text" name="startTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endTime_query" type="text" name="endTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				订单号：<input id="orderNumber_query" type="text" class="easyui-textbox" name="orderNumber" style="width: 100px;">
				是否已报账：<input id="isLock_query" class="easyui-combobox clearButton" name="isLock" style="width: 70px" data-options="editable:false,
																																	valueField: 'label',
																																	textField: 'value',
																																	data: [{
																																		label: 'true',
																																		value: '是'
																																	},{
																																		label: 'false',
																																		value: '否'
																																	}]" />
				是否收回票据：<input id="isReceiveReceipt_query" class="easyui-combobox clearButton" name="isReceiveReceipt" style="width: 70px" data-options="editable:false,
																																						valueField: 'label',
																																						textField: 'value',
																																						data: [{
																																							label: 'true',
																																							value: '是'
																																						},{
																																							label: 'false',
																																							value: '否'
																																						}]" />
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="gh" mid="gha"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
	    <p:isPrivilege pid="gh" mid="ghb">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="gh" mid="ghc"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="gh" mid="gha"> 
			<div data-options="iconCls:'icon-large-shapes'" onclick="copy();">复制</div>
		</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="gh" mid="ghd"> 
		    <div data-options="iconCls:'icon-ok'" onclick="lock(true);">设为已报账</div>
		    <div data-options="iconCls:'icon-no'" onclick="lock(false);">设为未报账</div>
		</p:isPrivilege>
		<p:isPrivilege pid="gh" mid="ghe">   
		    <div data-options="iconCls:'icon-ok'" onclick="receiveReceipt(true);">设为已收票据</div>
		    <div data-options="iconCls:'icon-no'" onclick="receiveReceipt(false);">设为未收票据</div>
	    </p:isPrivilege>
	    <p:isPrivilege pid="gh" mid="ghf"> 
			<div data-options="iconCls:'icon-undo'" onclick="openImportExcelDialog();">导入Excel</div>
		</p:isPrivilege>
	    <p:isPrivilege pid="gh" mid="ghg"> 
	    	<div data-options="iconCls:'icon-redo'" onclick="exportExcel();">导出报账单</div>
	    </p:isPrivilege>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 540px;height: 330px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<input id="isLock" type="hidden" name="isLock" value="false">
  			<input id="isReceiveReceipt" type="hidden" name="isReceiveReceipt" value="false">
  			<table style="border-spacing:10px;border-bottom: 0.5px;width: 100%">
  				<tr>
	  				<td style="width: 100px;text-align: right;">
	  					工咭号：
	  				</td>
		  			<td>
		  				<input id="workCardNo" type="text" name="workCardNo" class="easyui-textbox" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkWorkCardNoFormatForTrainTicket'">
		  			</td>
	  				<td style="width: 100px;text-align: right;">
	  					类型：
	  				</td>
		  			<td>
		  				<select id="trafficType" class="easyui-combobox" name="trafficType" style="width: 100%" data-options="editable:false">   
						    <option value="火车">火车</option> 
						    <option value="飞机">飞机</option>   
						</select>  
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="width: 100px;text-align: right;">
	  					订票日期：
	  				</td>
		  			<td>
		  				<input id="orderTicketsDate" type="text" name="orderTicketsDate" class="easyui-datebox" data-options="required:true,missingMessage:'用户名不能为空',editable:false">
		  			</td>
	  				<td style="text-align: right;">
	  					出发日期：
	  				</td>
		  			<td>
		  				<input id="departureTime" type="text" name="departureTime" class="easyui-datetimebox" data-options="required:true,missingMessage:'密码不能为空',editable:false">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="width: 100px;text-align: right;">
	  					出差人员：
	  				</td>
		  			<td>
		  				<input id="travelPersonnel" type="text" name="travelPersonnel" class="easyui-textbox" style="width: 100%" data-options="required:true,missingMessage:'用户名不能为空'">
		  			</td>
	  				<td style="text-align: right;">
	  					出发地：
	  				</td>
		  			<td>
		  				<input id="startPoint" type="text" name="startPoint" class="easyui-textbox" data-options="required:true,missingMessage:'出发地不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					目的地：
	  				</td>
		  			<td>
		  				<input id="endPoint" type="text" name="endPoint" class="easyui-textbox" data-options="required:true,missingMessage:'目的地不能为空'">
		  			</td>
	  				<td style="text-align: right;">
	  					航班号/车次：
	  				</td>
		  			<td>
		  				<input id="planeTrainNumber" type="text" name="planeTrainNumber" class="easyui-textbox" data-options="required:true,missingMessage:'车次不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					座位：
	  				</td>
		  			<td>
		  				<input id="seat" type="text" name="seat" class="easyui-textbox" data-options="required:true,missingMessage:'座位不能为空'">
		  			</td>
	  				<td style="text-align: right;">
	  					铺位：
	  				</td>
		  			<td>
		  				<input id="berth" type="text" name="berth" class="easyui-textbox" data-options="required:true,missingMessage:'铺位不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					价格：
	  				</td>
		  			<td>
		  				<input id="price" type="text" name="price" class="easyui-numberbox" data-options="required:true,missingMessage:'价格不能为空',precision:1">
		  			</td>
	  				<td style="text-align: right;">
	  					订单号：
	  				</td>
		  			<td>
		  				<input id="orderNumber" type="text" name="orderNumber" class="easyui-textbox" data-options="required:true,missingMessage:'订单号不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					备注：
	  				</td>
		  			<td colspan="3">
		  				<input id="remark" type="text" name="remark" class="easyui-textbox" style="width: 420px">
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
	
	<div id="dialog2" class="easyui-dialog" style="width: 480px;height: 140px;text-align: center;padding-top: 20px;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb2'">
  		<form id="form2">
  			<input class="easyui-filebox" name="uploadFile" style="width:300px;" data-options="required:true,missingMessage:'请选择Excel文件',validType:'checkExcel'">
  		</form>
  	</div>
  	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb2" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="importExcel()">导入</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
	</div>
	
	
	<div id="gridToolBar2" style="padding:5px;height:auto;">
		<form id="queryForm2">
			工号：<input id="workNo_query2" type="text" class="easyui-textbox" name="workNo" style="width: 50px" >
			姓名：<input id="username_query2" type="text" class="easyui-textbox" name="username" style="width: 50px" >
			分组：<input id="groupsId_query2" class="easyui-combobox clearButton" name="groupsId" style="width: 100px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2();">查询</a>
		</form>
	</div>
	
</body>    
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>工咭</title>
	<jsp:include page="/common.jsp"></jsp:include>
  </head>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		//当浏览器小于这个窗口时，将该窗口设置成浏览器大小
		if ($(document.body).width()<$("#workCardDialog").width()){
			$("#workCardDialog").dialog({
				closed:$("#workCardDialog").dialog("options").closed,
				width: $(document.body).width()
			});
		}else{
			$("#workCardDialog").dialog({
				closed:$("#workCardDialog").dialog("options").closed,
				width: 900
			});
		}
		$("#workCardDialog").dialog({//加载一个dialog
			closed:$("#workCardDialog").dialog("options").closed,
			left:($(document.body).width()-$("#workCardDialog").width()-14)/2,
			top:0
		});
		
		
		
		if ($(document.body).width()<$("#confirmationDialog").width()){
			$("#confirmationDialog").dialog({
				closed:$("#confirmationDialog").dialog("options").closed,
				width: $(document.body).width()
			});
		}else{
			$("#confirmationDialog").dialog({
				closed:$("#confirmationDialog").dialog("options").closed,
				width: 900
			});
		}
		$("#confirmationDialog").dialog({//加载一个dialog
			closed:$("#confirmationDialog").dialog("options").closed,
			left:($(document.body).width()-$("#confirmationDialog").width()-14)/2,
			top:0
		});
		
		$("#auditUserDialog").dialog({//加载一个dialog
			closed:$("#auditUserDialog").dialog("options").closed,
			left:($(document.body).width()-$("#auditUserDialog").width())/2,
			top:($(document.body).height()-74-$("#auditUserDialog").height())/2,
		});
		
		$("#takeBackDialog").dialog({//加载一个dialog
			closed:$("#takeBackDialog").dialog("options").closed,
			left:($(document.body).width()-$("#takeBackDialog").width())/2,
			top:($(document.body).height()-74-$("#takeBackDialog").height())/2,
		});
		
		$("#rollBackDialog").dialog({//加载一个dialog
			closed:$("#rollBackDialog").dialog("options").closed,
			left:($(document.body).width()-$("#rollBackDialog").width())/2,
			top:($(document.body).height()-74-$("#rollBackDialog").height())/2,
		});
		
		$("#antiAuditDialog").dialog({//加载一个dialog
			closed:$("#antiAuditDialog").dialog("options").closed,
			left:($(document.body).width()-$("#antiAuditDialog").width())/2,
			top:($(document.body).height()-74-$("#antiAuditDialog").height())/2,
		});
		
	};
	
	$(function () {
		$('#workCardDg').treegrid({
			title:'工咭',
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
		    url:'${pageContext.request.contextPath}/sales/workCard/findAllWorkCardList.action',    
		    idField:'id',    
		    remoteSort:true,//从服务器进行排序    
		    treeField:'quotationNo',  
		    toolbar: '#gridToolBar',
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    //rownumbers:true,//显示一个行号列。
		    //lines:true,//定义是否显示treegrid行
		    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
		    frozenColumns:[[
							{field:'quotationNo',title:'报价单号',width:120,align:'center',sortable:true},
							{field:'workCardNo',title:'工咭号',width:80,align:'center',sortable:true},
							{field:'workCardLeader',title:'工咭项目负责人',width:110,align:'center',sortable:true},
							{field:'workCardDate',title:'下工咭日期',width:80,align:'center',sortable:true},
	                      ]],
		    columns:[[	
						{field:'productCode',title:'产品代码',width:100,align:'center'},
				        {field:'productName',title:'产品名称',width:150,align:'center'},
						{field:'productModel',title:'规格(外尺寸)',width:100,align:'center'},
				        {field:'quantity',title:'数量',width:60,align:'center'},
				        {field:'unit',title:'单位',width:60,align:'center'},
				        {field:'expectedDeliveryDate',title:'预交货期',width:110,align:'center'},
				        {field:'engReleaseDataDate',title:'工程下资料日期',width:110,align:'center'},
				        {field:'proPeriod',title:'生产做货周期',width:110,align:'center'},
				        {field:'confirmation',title:'做货确认单',width:80,align:'center'},
				        {field:'processInstanceId',title:'任务类型',width:70,align:'center'}
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
		    	var url = '${pageContext.request.contextPath}/sales/workCard/findAllSalWorkCardSubsidiaryListBySalWorkCardId.action'; 
                $(this).treegrid("options").url = url;  
                return true; 
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/sales/workCard/findAllWorkCardList.action'; 
                $(this).treegrid("options").url = url;  
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/sales/workCard/findAllWorkCardList.action'; 
                $(this).treegrid("options").url = url;
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/sales/workCard/findAllWorkCardList.action'; 
                $(this).treegrid("options").url = url;
            }
		});

		var tableId = "auditUserDg";
		var columns = [[
				        {field:'loginName',title:'登录名',width:120,align:'center',sortable:true},    
				        {field:'username',title:'用户名',width:120,align:'center',sortable:true},
				        {field:'departmentId',title:'部门',width:100,align:'center',sortable:true},
				        {field:'groupsId',title:'分组',width:100,align:'center',sortable:true},
				    ]];
		loadDataGrid1(tableId,'','',columns,'','');
		
		//表单提交的回车事件
		/* $("#workCardForm").keyup(function (event){
			if (event.keyCode == 13){
				save();
			}
		}); */
		//查询的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
	});
	
	
	function queryAuditor(){
  		var selected = $('#workCardDg').treegrid("getSelected");
  		if (selected != null){
			var id = "";
			var processInstanceId = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
					processInstanceId = selected.processInstanceId;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#workCardDg').treegrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if(processInstanceId == "" || processInstanceIdInput.text() == "审核中"){
	  			$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCard/queryAuditorById.action",//ajax请求的url
					data: {id:id},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							if (data.rows.length>0){//表示还有下一节点
								$("#auditUserDg").datagrid("clearSelections");
								$("#auditUserDg").datagrid('loadData',data.rows);
								//$("#processInstanceId").val(processInstanceId);
								$("#workCardId").val(id);
								$("#auditUserDialog").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'请选择接收任务的人员'
								});
							}else{//表示最后一个节点
								$.messager.confirm('确认对话框', '您确定要审核吗？', function(b){
									if (b){//如何用户点击的是确认
										$.ajax({
											type:'POST',//post请求
											url: "${pageContext.request.contextPath}/sales/workCard/auditWorkCard.action",//ajax请求的url
											data: {id:id},//传的参数
											async: false,//同步请求
											cache: false,//不缓存此页面
											success: function(data){//请求成功后的回调函数。data：服务器返回数据。
												if (data.success){
													showMessager("提示","审核成功");
													$("#workCardDg").treegrid('reload');//重新加载数据，保持在当前页
													
													//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
													window.top.RefreshData();
												}else{
													showErrorMessager("审核失败", data.message);
												}
											}
										});
									}
								});
							}
						}else{
							showErrorMessager("获取下一节点失败", data.message);
						}
					}
				});
			}else if(processInstanceIdInput.text() == "审核完成"){
				showErrorMessager("审核失败", '当前流程已经结束，不能审核');
			}
  		}else{
			showMessager("提示","请选择一条记录进行审核");
		}
  	}
	
	//给指定的人发送审核
	function audit(){
		var selected = $("#auditUserDg").datagrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请先选择接收任务的人员");
		}else{
			var assigneeId = selected.id;
			if (assigneeId != undefined && assigneeId !=null && assigneeId != ''){
				//var processInstanceId = $("#processInstanceId").val();
				var id = $("#workCardId").val();
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCard/auditWorkCard.action",//ajax请求的url
					data: {assigneeId:assigneeId,id:id},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							showMessager("提示","审核成功");
							$("#auditUserDialog").dialog({//关闭这个dialog
								closed:true
							});
							$("#workCardDg").treegrid('reload');//重新加载数据，保持在当前页
	
							//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
							window.top.RefreshData();
						}else{
							showErrorMessager("审核失败", data.message);
						}
					}
				});
			}else{
				showMessager("提示","您选择接收任务的用户不存在");
			}
		}
	}
	
	  
	  
	  //撤销流程
	  function revokeProcess(){
		  var selected = $("#workCardDg").treegrid("getSelected");
		  if (selected != null){
			  var id = "";
			  var processInstanceId = "";
			  while (id == ""){
				  if (selected._parentId == undefined){//根节点
					  id = selected.id;
					  processInstanceId = selected.processInstanceId;
					  
				  }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					  selected = $('#workCardDg').treegrid('getParent',selected.id);
				  }
			  }
			  var processInstanceIdInput = $(processInstanceId);
			  if (processInstanceId == ""){
				  showErrorMessager("撤销失败", '没有开启审核流程');
			  }else if(processInstanceIdInput.text() == "审核中"){
				  $.messager.confirm('确认对话框', '您确定要撤销本流程吗？本流程的所有痕迹将会清除', function(b){
					  if (b){//如何用户点击的是确认
							$.ajax({
								type:'POST',//post请求
								url: "${pageContext.request.contextPath}/sales/workCard/revokeProcess.action",//ajax请求的url
								data: {id:id},//传的参数
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(data){//请求成功后的回调函数。data：服务器返回数据。
									if (data.success){
										showMessager("提示","撤销成功");
										$("#workCardDg").treegrid('reload');//重新加载数据，保持在当前页
										
										//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
										window.top.RefreshData();
									}else{
										showErrorMessager("撤销失败", data.message);
									}
								}
							});
						}
				  });
			  }else if(processInstanceIdInput.text() == "审核完成"){
				  showErrorMessager("撤销失败", '当前流程已经结束，不能撤销');
			  }
		  }else{
				showMessager("提示","请选择一条记录进行撤销");
			}
	  }
	  
	  
		//打开收回的操作
		function openTakeBackDialog(){
			var selected = $("#workCardDg").treegrid('getSelected');//取得选中的行
			if (selected==null){
				showMessager("提示","请选择一条记录进行收回");
			}else{
				var processInstanceId = "";
				var id = "";
				while (id == ""){
					if (selected._parentId == undefined){//根节点
						id = selected.id;
						processInstanceId = selected.processInstanceId;
					}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
						selected = $('#workCardDg').treegrid('getParent',selected.id);
					}
				}
				var processInstanceIdInput = $(processInstanceId);
				if (processInstanceId == ""){
					  showErrorMessager("收回失败", '没有开启审核流程');
				}else if(processInstanceIdInput.text() == "审核中"){
					$("#takeBackForm").form("reset");
					$("#takeBackId").val(id);
					$("#takeBackDialog").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:'收回操作'//该dialog的标题
					});
				}else if(processInstanceIdInput.text() == "审核完成"){
					showErrorMessager("收回失败", '当前流程已经结束，不能收回');
				}
			}
		}
		
		//收回
		function takeBack(){
			if ($("#takeBackForm").form("validate")){
				$.messager.confirm('确认对话框', '确定要收回审核吗？', function(b){
					if (b){//如何用户点击的是确认
						$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/sales/workCard/takeBackWorkCard.action",//ajax请求的url
							data: $("#takeBackForm").serialize(),//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data.success){
									showMessager("提示","收回审核成功");
									$("#takeBackDialog").dialog({//加载一个dialog
										closed:true,//将该dialog的状态由不显示改成显示
									});
									//$("#dg").treegrid('clearSelections');
									$("#workCardDg").treegrid('reload');
									
									//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
									window.top.RefreshData();
								}else{
									showErrorMessager("收回失败", data.message);
								}
							}
						});
					}
				});
			}
		}
	
	//打开退回的dialog
	function openRollBackDialog(){
		var selected = $("#workCardDg").treegrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行退回");
		}else{
			var processInstanceId = "";
			var id = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
					processInstanceId = selected.processInstanceId;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#workCardDg').treegrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if (processInstanceId == ""){
				  showErrorMessager("退回失败", '没有开启审核流程');
			}else if(processInstanceIdInput.text() == "审核中"){
				$("#rollBackForm").form("reset");
				$("#rollBackId").val(id);
				$("#rollBackDialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'退回操作'//该dialog的标题
				});
			}else if(processInstanceIdInput.text() == "审核完成"){
				showErrorMessager("退回失败", '当前流程已经结束，不能退回');
			}
		}
	}
	
	//退回
	function rollBack(){
		if ($("#rollBackForm").form("validate")){
			$.messager.confirm('确认对话框', '确定要退回审核吗？', function(b){
				if (b){//如何用户点击的是确认
					$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/sales/workCard/rollBackWorkCard.action",//ajax请求的url
						data: $("#rollBackForm").serialize(),//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","退回审核成功");
								$("#rollBackDialog").dialog({//加载一个dialog
									closed:true,//将该dialog的状态由不显示改成显示
								});
								//$("#dg").treegrid('clearSelections');
								$("#workCardDg").treegrid('reload');

								//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
								window.top.RefreshData();
							}else{
								showErrorMessager("退回失败", data.message);
							}
						}
					});
				}
			});
		}
	}
	
	//打开反审的dialog
	function openAntiAuditDialog(){
		var selected = $("#workCardDg").treegrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行反审核");
		}else{
			var processInstanceId = "";
			var id = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
					processInstanceId = selected.processInstanceId;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#workCardDg').treegrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if (processInstanceId == ""){
				  showErrorMessager("反审失败", '没有开启审核流程');
			}else if(processInstanceIdInput.text() == "审核完成"){
				$("#antiAuditForm").form("reset");
				$("#antiAuditId").val(id);
				$("#antiAuditDialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'反审操作'//该dialog的标题
				});
			}else if(processInstanceIdInput.text() == "审核中"){
				showErrorMessager("反审失败", '当前流程未审核完成，不能重新审核');
			}
		}
	}
	
	//反审核
	function antiAudit(){
		if ($("#antiAuditForm").form("validate")){
			$.messager.confirm('确认对话框', '确定要反审核吗？', function(b){
				if (b){//如何用户点击的是确认
					$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/sales/workCard/antiAuditWorkCard.action",//ajax请求的url
						data: $("#antiAuditForm").serialize(),//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","反审核成功");
								$("#antiAuditDialog").dialog({//加载一个dialog
									closed:true,//将该dialog的状态由不显示改成显示
								});
								//$("#dg").treegrid('clearSelections');
								$("#workCardDg").treegrid('reload');

								//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
								window.top.RefreshData();
							}else{
								showErrorMessager("反审核失败", data.message);
							}
						}
					});
				}
			});
		}
	}
	
	

	function reload(){
		$("#workCardDg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	function query(){
		$("#workCardDg").treegrid('load',$("#queryForm").serializeObject());//重载行。等同于'load'方法，但是它将保持在当前页。
	}

  </script>
  <body class="easyui-layout">
 	 <div data-options="region:'center'" style="background:#eee;">
	  	<table id="workCardDg"   
	  		
	  		data-options="onDblClickRow:function (row){
															    	<p:isPrivilege pid="di" mid="dia">
															    		editWorkCard();//是子节点则开始编辑
														    		</p:isPrivilege>
														    }
														    ,onSelect:function(row){
												            	var url = '${pageContext.request.contextPath}/sales/workCard/findWorkCardFileListBySalWorkCardId.action'; 
												            	var id = '';
												            	//判断是否是子节点
																if($('#workCardDg').treegrid('isLeaf',row.id)){//是子节点
																	id = row._parentId
																}else{//不是子节点
																	id = row.id;
																}
												            	$('#workCardFileDg').datagrid('options').url = url;
												            	$('#workCardFileDg').datagrid('reload',{
												            		salReviewerId:id
												            	});
												            	$('#workCardFileDg').datagrid('unselectAll');
										           			}"
			
	  		
	  	></table>
	  </div>
	  <div data-options="region:'south',hideCollapsedContent:false,expandMode:'dock',title:'工咭相关文件',split:true" style="height:200px;margin-bottom: -3px">
	  	<jsp:include page="workCardFile.jsp"></jsp:include>
	  </div>
  	
  	<div id="gridToolBar" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<p:isPrivilege pid="dg" mid="dga">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addWorkCard()" style="float: left;">新增</a><div class="btn-separator"></div>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editWorkCard();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a class="easyui-linkbutton" iconCls="icon-mini-edit" plain="true" onClick="viewWorkCard();" style="float: left;">查看</a> <div class="btn-separator"></div>
			<p:isPrivilege pid="dg" mid="dgb">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleteWorkCard();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="dg" mid="dgc">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="queryAuditor();" style="float: left;">审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="revokeProcess();" style="float: left;">撤销流程</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openTakeBackDialog();" style="float: left;">收回审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openRollBackDialog();" style="float: left;">退回审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="dg" mid="dgd">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAntiAuditDialog();" style="float: left;">反审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				Q编号：<input id="quotationNo_query" type="text" class="easyui-textbox" name="quotationNo" style="width: 70px" >
				年份：<input id="quotationYear_query" type="text" class="easyui-textbox" name="quotationYear" style="width: 40px" >
				工咭编号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				年份：<input id="workCardYear_query" type="text" class="easyui-textbox" name="workCardYear" style="width: 40px" >
				项目负责人：<input id="workCardLeader_query" type="text" name="workCardLeader" style="width: 80px" class="easyui-textbox">
				下工咭日期：<input id="startWorkCardDate_query" type="text" name="startWorkCardDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endWorkCardDate_query" type="text" name="endWorkCardDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				我的待办查询：<input id="assignee" name="assignee" class="easyui-switchbutton" data-options="onText:'开启',offText:'关闭',onChange:function(checked){query()}">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
		<p:isPrivilege pid="dg" mid="dga">
	    	<div data-options="iconCls:'icon-add'" onclick="addWorkCard();">新增</div>
    		<div data-options="iconCls:'icon-edit'" onclick="editWorkCard();">修改</div>
   		</p:isPrivilege>
   		<div data-options="iconCls:'icon-mini-edit'" onclick="viewWorkCard();">查看</div>
   		<p:isPrivilege pid="dg" mid="dgb">
    		<div data-options="iconCls:'icon-remove'" onclick="deleteWorkCard();">删除</div>
   		</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="dg" mid="dgc">
	    	<div data-options="iconCls:'icon-man'" onclick="queryAuditor();">审核</div>
		    <div data-options="iconCls:'icon-cancel'" onclick="revokeProcess();">撤销流程</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openTakeBackDialog();">收回审核</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openRollBackDialog();">退回审核</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="dg" mid="dgd">
    		<div data-options="iconCls:'icon-man'" onclick="openAntiAuditDialog();">反审核</div>
    	</p:isPrivilege>
	</div>
  	
  	
	<jsp:include page="workCardTable.jsp"></jsp:include>
	<jsp:include page="workCardTableView.jsp"></jsp:include>
	
	
	<div id="auditUserDialog" class="easyui-dialog" style="width: 500px;height: 400px;text-align: center;"
  	data-options="closed:true,draggable:true,modal:true,buttons:'#auditUserBB'">
  		<table id="auditUserDg"></table>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="auditUserBB" style="text-align: center;">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="audit()">发送</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('auditUserDialog')">关闭</a>
	</div>
	
	
	
	
	
	<div id="takeBackDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#takeBackBB'">
  		<form id="takeBackForm">
  			<div style="padding-top: 15px;">
  				<input id="takeBackId" type="hidden" name="id">
  				收回原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="takeBackBB" style="text-align: center;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="takeBack()">收回</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('takeBackDialog')">取消</a>
	</div>
	
  	<div id="rollBackDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#rollBackBB'">
  		<form id="rollBackForm">
  			<div style="padding-top: 15px;">
  				<input id="rollBackId" type="hidden" name="id">
  				退回原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="rollBackBB" style="text-align: center;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="rollBack()">退回</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('rollBackDialog')">取消</a>
	</div>
	
  	<div id="antiAuditDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#antiAuditBB'">
  		<form id="antiAuditForm">
  			<div style="padding-top: 15px;">
  				<input id="antiAuditId" type="hidden" name="id">
  				反审原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="antiAuditBB" style="text-align: center;">
			<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="antiAudit()">发送</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('antiAuditDialog')">关闭</a>
	</div>
  </body>
</html>

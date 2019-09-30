<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>即时消息</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
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
		
		$("#reAuditDialog").dialog({//加载一个dialog
			closed:$("#reAuditDialog").dialog("options").closed,
			left:($(document.body).width()-$("#reAuditDialog").width())/2,
			top:($(document.body).height()-74-$("#reAuditDialog").height())/2,
		});
		
	};
	  $(function(){
			$("#dg").datagrid({
				title:"待评审",//表格的标题
				fit:true,//当设置为true的时候面板大小将自适应父容器
				fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
				idField:'id',
				striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
				//multiSort:true,//允许多行排序
				singleSelect:true ,//单选
				//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
				pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
			    idField:'id',//指明哪一个字段是标识字段。
			    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
			    rownumbers:true,//显示一个行号列。
			    columns:[[
			                {field:'modular',title:'所属模块',width:150,align:'center',sortable:true},
			                {field:'auditStateUrl',title:'审批状态',width:150,align:'center'},
			                {field:'processInstanceId',title:'流程实例id',width:70,align:'center',sortable:true,hidden:true},
					        {field:'name',title:'报价单号/工咭号/文件名',width:100,align:'center',sortable:true},
					        {field:'startUsername',title:'发起人',width:100,align:'center',sortable:true},
					        {field:'startTime',title:'流程发起时间',width:150,align:'center',sortable:true},
					        {field:'receiveTime',title:'接收时间',width:150,align:'center',sortable:true},
					        {field:'endTime',title:'流程结束时间',width:150,align:'center',sortable:true},
					    ]],//表格的各个字段
			    toolbar: "#gridToolBar",
				onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
	                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
	                e.preventDefault(); //阻止浏览器捕获右键事件
	                $(this).datagrid("clearSelections"); //取消所有选中项
	                if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
	                	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
	                }
	                $("#menu").menu('show', {//显示右键菜单
	                    left: e.pageX,//在鼠标点击处显示菜单
	                    top: e.pageY
	                });
	            }
			});
			
			$("#auditUserDg").datagrid({
				fit:true,//当设置为true的时候面板大小将自适应父容器
				striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
				remoteSort:false,//不从服务器进行排序
			    idField:'id',//指明哪一个字段是标识字段。
			    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
			    rownumbers:true,//显示一个行号列。
			    columns:[[
							{field:'ck',checkbox:true},  
					        {field:'loginName',title:'登录名',width:120,align:'center',sortable:true},    
					        {field:'username',title:'用户名',width:120,align:'center',sortable:true},
					        {field:'departmentId',title:'部门',width:100,align:'center',sortable:true},
					        {field:'groupsId',title:'分组',width:100,align:'center',sortable:true},
					    ]],//表格的各个字段
			});
			
			$("#dg").datagrid('options').url = "${pageContext.request.contextPath}/system/message/showAllAuditByState.action";
			$("#dg").datagrid('load',$("#queryForm").serializeObject());
			
			//默认加载的就是项目评审表的待审批
			$("#dg").datagrid('hideColumn','auditStateUrl');
			$("#dg").datagrid('showColumn','receiveTime');
			$("#dg").datagrid('hideColumn','endTime');
			
			$("#audit1").hide();
			$("#rollBack1").show();
			$("#takeBack1").hide();
			$("#reAudit1").hide();
			
			$("#audit2").hide();
			$("#rollBack2").show();
			$("#takeBack2").hide();
			$("#reAudit2").hide();
			
			/* $("#cc").combobox({
				onChange:function(newValue,oldValue){
					$("#dg").datagrid('options').url = "${pageContext.request.contextPath}/system/message/showAllAuditByState.action?state=" + newValue;
					if (newValue == 0){
						$("#dg").datagrid('getPanel').panel('setTitle',"待审批");
						
						$("#dg").datagrid('hideColumn','auditStateUrl');
						$("#dg").datagrid('showColumn','receiveTime');
						$("#dg").datagrid('hideColumn','endTime');
						
						$("#rollBack1").show();
						$("#takeBack1").hide();
						$("#rollBack2").show();
						$("#takeBack2").hide();
						$("#reAudit1").hide();
						$("#reAudit2").hide();
					}else if (newValue == 1){
						$("#dg").datagrid('getPanel').panel('setTitle',"已审批");
						
						$("#dg").datagrid('showColumn','auditStateUrl');
						$("#dg").datagrid('showColumn','receiveTime');
						$("#dg").datagrid('showColumn','endTime');
						
						$("#rollBack1").hide();
						$("#takeBack1").show();
						$("#rollBack2").hide();
						$("#takeBack2").show();
						$("#reAudit1").hide();
						$("#reAudit2").hide();
					}else if (newValue == 2){
						$("#dg").datagrid('getPanel').panel('setTitle',"已发送审批");
						
						$("#dg").datagrid('showColumn','auditStateUrl');
						$("#dg").datagrid('hideColumn','receiveTime');
						$("#dg").datagrid('showColumn','endTime');
						
						$("#rollBack1").hide();
						$("#takeBack1").hide();
						$("#rollBack2").hide();
						$("#takeBack2").hide();
						$("#reAudit1").show();
						$("#reAudit2").show();
					}
					$("#dg").datagrid('load');
				}
			}); */
	  });
	  
	  function changeModularState(state){
		  $("input[type='button'][id^='modularState']").attr("class","enable");
		  $("input[type='button'][id^='modularState']").removeAttr("disabled");
		  $("#modularState" + state).attr("class","disabled");
		  $("#modularState" + state).attr("disabled","disabled");
		  
		  $("#modularState").val(state);
		  $("#dg").datagrid('load',$("#queryForm").serializeObject());
		  showHideButton();
		  $("#dg").datagrid('clearSelections');
	  }
	  
	  function changeAuditState(state){
		  $("input[type='button'][id^='auditState']").attr("class","enable");
		  $("input[type='button'][id^='auditState']").removeAttr("disabled");
		  $("#auditState" + state).attr("class","disabled");
		  $("#auditState" + state).attr("disabled","disabled");
		  
		  $("#auditState").val(state);
		  $("#dg").datagrid('load',$("#queryForm").serializeObject());
		  showHideButton();
		  $("#dg").datagrid('clearSelections');
	  }
	  
	  function showHideButton(){
		  var modularState = $("#modularState").val();
			 var auditState = $("#auditState").val();
			 
			 if (auditState == "0"){//待评审
				 $("#dg").datagrid('getPanel').panel('setTitle',"待审批");
					
				 $("#dg").datagrid('hideColumn','auditStateUrl');
				 $("#dg").datagrid('showColumn','receiveTime');
				 $("#dg").datagrid('hideColumn','endTime');
				 
				 $("#audit1").hide();
				 $("#rollBack1").show();
				 $("#takeBack1").hide();
				 $("#reAudit1").hide();
				 $("#audit2").hide();
				 $("#rollBack2").show();
				 $("#takeBack2").hide();
				 $("#reAudit2").hide();
			 }else if (auditState == "1"){//已评审
				 $("#dg").datagrid('getPanel').panel('setTitle',"已审批");
					
				 $("#dg").datagrid('showColumn','auditStateUrl');
				 $("#dg").datagrid('showColumn','receiveTime');
				 $("#dg").datagrid('showColumn','endTime');
				 
				 $("#audit1").hide();
				 $("#rollBack1").hide();
				 $("#takeBack1").show();
				 $("#reAudit1").hide();
				 $("#audit2").hide();
				 $("#rollBack2").hide();
				 $("#takeBack2").show();
				 $("#reAudit2").hide();
			 }else if (auditState == "2"){//已发送评审
				 $("#dg").datagrid('getPanel').panel('setTitle',"已发送审批");
					
				 $("#dg").datagrid('showColumn','auditStateUrl');
				 $("#dg").datagrid('hideColumn','receiveTime');
				 $("#dg").datagrid('showColumn','endTime');
				 
				 $("#audit1").hide();
				 $("#rollBack1").hide();
				 $("#takeBack1").hide();
				 $("#reAudit1").show();
				 $("#audit2").hide();
				 $("#rollBack2").hide();
				 $("#takeBack2").hide();
				 $("#reAudit2").show();
			 }
			 
			 if (modularState == "2"){//只有工咭相关文件例外
				 if (auditState == "0"){//待评审
					 $("#audit1").show();
					 $("#audit2").show();
					 $("#rollBack1").hide();
					 $("#rollBack2").hide();
				 }else if (auditState == "1"){//已评审
					 $("#takeBack1").hide();
					 $("#takeBack2").hide();
				 }else if (auditState == "2"){//已发送评审
					 
				 }
			 }else if (modularState == "5"){
				 if (auditState == "1"){
					 $("#reAudit1").show();
					 $("#reAudit2").show();
				 }
			 }
	  }

	  
	  //刷新数据
	  function reload(){
		  window.top.RefreshData();
		  $("#dg").datagrid('reload');
	  }
	  
	  function queryWorkCardFileAuditor(){
			var selected = $("#dg").datagrid('getSelected');//取得选中的行
			if (selected==null){
				showMessager("提示","请选择一条记录进行审核");
			}else{
				var processInstanceId = selected.processInstanceId;
				/* processInstanceId = $(processInstanceId).attr('href');
				processInstanceId = processInstanceId.split("?processInstanceId=")[1]; */
				var id = selected.id;
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCardCollect/queryAuditorByProcessInstanceId.action",//ajax请求的url
					data: {id:id},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success == true){
							if (data.rows.length>0){//表示还有下一节点
								$("#auditUserDg").datagrid("clearSelections");
								$("#auditUserDg").datagrid('loadData',data.rows);
								/* $("#processInstanceId").val(processInstanceId);
								$("#workCardFileId").val(id); */
								$("#auditUserDialog").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'请选择接收任务的人员'//该dialog的标题
								});
							}else{//表示最后一个节点
								$.messager.confirm('确认对话框', '您确定要评审吗？', function(b){
									if (b){//如何用户点击的是确认
										$.ajax({
											type:'POST',//post请求
											url: "${pageContext.request.contextPath}/sales/workCardCollect/auditWorkCardFile.action",//ajax请求的url
											data: {id:id},//传的参数
											async: false,//同步请求
											cache: false,//不缓存此页面
											success: function(data){//请求成功后的回调函数。data：服务器返回数据。
												if (data == '审核成功'){
													showMessager("提示",data);
													
													$("#dg").datagrid('reload');//重新加载数据，保持在当前页
													$("#dg").datagrid('clearSelections');//清除所有选择的行。
													
													//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
													window.top.RefreshData();
												}else{
													showMessager("错误",data);
												}
											}
										});
									}
								});
							}
						}else{
							showMessager("错误",data.message);
						}
					}
				});
			}
		}
		
		//给指定的人发送审核
		function auditWorkCardFile(){
			var selections = $("#auditUserDg").datagrid('getSelections');//取得选中的行
			if (selections==null || selections==""){
				showMessager("提示","请至少选择一个人进行审核");
			}else{
				var assignees = "";
				for (var i=0;i<selections.length;i++){
					assignees = assignees + selections[i].loginName;
					if (i < (selections.length - 1)){
						assignees = assignees + ",";
					}
				}
				var selected = $("#dg").datagrid('getSelected');//取得选中的行
				//var processInstanceId = selected.processInstanceId;
				var id = selected.id;
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCardCollect/auditWorkCardFile.action",//ajax请求的url
					data: {assignees:assignees,id:id},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data == '审核成功'){
							showMessager("提示",data);
							$("#auditUserDialog").dialog({//关闭这个dialog
								closed:true
							});
							$("#dg").datagrid('reload');//重新加载数据，保持在当前页
							$("#dg").datagrid('clearSelections');//清除所有选择的行。

							//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
							window.top.RefreshData();
						}else{
							showMessager("错误",data);
						}
					}
				});
			}
		}
		
		
		//打开退回的dialog
		function openRollBackDialog(){
			var selected = $("#dg").datagrid('getSelected');//取得选中的行
			if (selected==null){
				showMessager("提示","请选择一条记录进行退回");
			}else{
				var id = selected.id;
				var modularState = $("#modularState").val();
				$("#rollBackForm").form("reset");
				$("#rollBackId").val(id);
				$("#rollBackModularState").val(modularState);
				$("#rollBackDialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'退回操作'//该dialog的标题
				});
			}
		}
	  
	  
	  //退回审批
	  function rollBack(){
			if ($("#rollBackForm").form("validate")){
				$.messager.confirm('确认对话框', '确定要退回审核吗？', function(b){
					if (b){//如何用户点击的是确认
						$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/system/message/rollBack.action",//ajax请求的url
							data: $("#rollBackForm").serialize(),//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data == '退回成功'){
									showMessager("提示",data);
									$("#rollBackDialog").dialog({//加载一个dialog
										closed:true,//将该dialog的状态由不显示改成显示
									});
									$("#dg").datagrid('clearSelections');
									$("#dg").datagrid('reload');
	
									//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
									window.top.RefreshData();
								}else{
									showMessager("错误",data);
								}
							}
						});
					}
				});
			}
	  }
	  
	  
	//打开收回的操作
	function openTakeBackDialog(){
		var selected = $("#dg").datagrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行收回");
		}else{
			//var processInstanceId = selected.processInstanceId;
			var auditStateUrl = selected.auditStateUrl;
			var id = selected.id;
			var modularState = $("#modularState").val();
			//var processInstanceIdInput = $(processInstanceId);
			var auditStateUrlInput = $(auditStateUrl);
			if(auditStateUrlInput.text() == "审核中"){
				$("#takeBackForm").form("reset");
				$("#takeBackId").val(id);
				$("#takeBackModularState").val(modularState);
				$("#takeBackDialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'收回操作'//该dialog的标题
				});
			}else if(auditStateUrlInput.text() == "审核完成"){
				showMessager("提示",'<font color="red">'+ '当前流程已经结束，不能收回' +'<font/>');
			}
		}
	}
	  
	  //收回审批
	  function takeBack(){
		  if ($("#takeBackForm").form("validate")){
				$.messager.confirm('确认对话框', '确定要收回审核吗？', function(b){
					if (b){//如何用户点击的是确认
						$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/system/message/takeBack.action",//ajax请求的url
							data: $("#takeBackForm").serialize(),//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data == '收回审核成功'){
									showMessager("提示",data);
									$("#takeBackDialog").dialog({//加载一个dialog
										closed:true,//将该dialog的状态由不显示改成显示
									});
									$("#dg").datagrid('clearSelections');
									$("#dg").datagrid('reload');
									
									//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
									window.top.RefreshData();
								}else{
									showMessager("错误",data);
								}
							}
						});
					}
				});
			}
	  }
	  
	  
	//打开重审的dialog
	function openReAuditDialog(){
		var selected = $("#dg").datagrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行重新审核");
		}else{
			var auditStateUrl = selected.auditStateUrl;
			//var processInstanceId = selected.processInstanceId;
			var id = selected.id; 
			var modularState = $("#modularState").val();
			//var processInstanceIdInput = $(processInstanceId);
			var auditStateUrlInput = $(auditStateUrl);
			if(auditStateUrlInput.text() == "审核完成"){
				if (modularState == 2){
					$.messager.confirm('确认对话框', '确定要重新开始审核吗？', function(b){
						if (b){//如何用户点击的是确认
							$.ajax({
								type:'POST',//post请求
								url: "${pageContext.request.contextPath}/system/message/reAudit.action",//ajax请求的url
								data: {id:id,modularState:modularState},//传的参数
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(data){//请求成功后的回调函数。data：服务器返回数据。
									if (data == '重新审核成功'){
										showMessager("提示",data);
										$("#reAuditDialog").dialog({//加载一个dialog
											closed:true,//将该dialog的状态由不显示改成显示
										});
										$("#dg").datagrid('clearSelections');
										$("#dg").datagrid('reload');

										//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
										window.top.RefreshData();
									}else{
										showMessager("错误",data);
									}
								}
							});
						}
					});
				}else{
					$("#reAuditForm").form("reset");
					$("#reAuditId").val(id);
					$("#reAuditModularState").val(modularState);
					$("#reAuditDialog").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:'重审操作'//该dialog的标题
					});
				}
			}else if(auditStateUrlInput.text() == "审核中"){
				showMessager("提示",'<font color="red">'+ '当前流程未审核完成，不能重新审核' +'<font/>');
			}
		}
	}
	  
	  //重新审批
	  function reAudit(){
		  if ($("#reAuditForm").form("validate")){
				$.messager.confirm('确认对话框', '确定要重新开始审核吗？', function(b){
					if (b){//如何用户点击的是确认
						$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/system/message/reAudit.action",//ajax请求的url
							data: $("#reAuditForm").serialize(),//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data == '重新审核成功'){
									showMessager("提示",data);
									$("#reAuditDialog").dialog({//加载一个dialog
										closed:true,//将该dialog的状态由不显示改成显示
									});
									$("#dg").datagrid('clearSelections');
									$("#dg").datagrid('reload');

									//立即刷新页面最上面，待审批的数据，顺便刷新在线用户数、未读消息数、消息
									window.top.RefreshData();
								}else{
									showMessager("错误",data);
								}
							}
						});
					}
				});
			}
	  }
  </script>
<body class="easyui-layout">
	<div region="north" style="padding-bottom: 10px;padding-top: 10px;text-align: center;height: 50px;">
		<div>
			<div style="width: 33%;float: left;">
				<input id="auditState0" class="disabled" type="button" style="width: 88px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" disabled="disabled" onclick="changeAuditState(0)" value="待审批">
			</div>
			<div style="width: 33%;float: left;">
				<input id="auditState1" class="enable" type="button" style="width: 88px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeAuditState(1)" value="已审批">
			</div>
			<div style="width: 33%;float: left;">
				<input id="auditState2" class="enable" type="button" style="width: 88px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeAuditState(2)" value="已发送审批">
			</div>
		</div>
	</div>
	<div region="west" style="width: 130px;">
		<div>
			<div style="margin-top: 5px;margin-left: 5px;">
				<input id="modularState0" class="disabled" type="button" style="width: 120px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" disabled="disabled" onclick="changeModularState(0)" value="项目评审表">
			</div>
			<div style="margin-top: 5px;margin-left: 5px;">
				<input id="modularState1" class="enable" type="button" style="width: 120px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeModularState(1)" value="工咭">
			</div>
			<div style="margin-top: 5px;margin-left: 5px;">
				<input id="modularState2" class="enable" type="button" style="width: 120px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeModularState(2)" value="工咭相关按资料">
			</div>
			<div style="margin-top: 5px;margin-left: 5px;">
				<input id="modularState3" class="enable" type="button" style="width: 120px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeModularState(3)" value="存仓工咭">
			</div>
			<div style="margin-top: 5px;margin-left: 5px;">
				<input id="modularState4" class="enable" type="button" style="width: 120px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeModularState(4)" value="标准配件入库">
			</div>
			<div style="margin-top: 5px;margin-left: 5px;">
				<input id="modularState5" class="enable" type="button" style="width: 120px;height:26px;border-radius:5px;border: 1px solid #b4b4b4;" onclick="changeModularState(5)" value="标准配件出库">
			</div>
		</div>
		<form id="queryForm">
			<input id="auditState" type="hidden" name="auditState" value="0">
			<input id="modularState" type="hidden" name="modularState" value="0">
		</form>
	</div>
	<div region="center">
		<table id="dg"></table>
	</div>
	
	<div id="auditUserDialog" class="easyui-dialog" style="width: 500px;height: 400px;text-align: center;"
	  	data-options="closed:true,draggable:true,modal:true,buttons:'#auditUserBB'">
  		<input id="processInstanceId" type="hidden">
  		<input id="workCardFileId" type="hidden">
  		<table id="auditUserDg"></table>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
	  	<div id="auditUserBB" style="text-align: center;">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="auditWorkCardFile()">发送</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('auditUserDialog')">关闭</a>
		</div>
	
	
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<div id="audit1" style="float: left;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="queryWorkCardFileAuditor()" style="float: left;">审核</a><div class="btn-separator"></div>
			</div>
			<div id="rollBack1" style="float: left;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-back" plain="true" onClick="openRollBackDialog()" style="float: left;">退回审核</a><div class="btn-separator"></div>
			</div>
			<div id="takeBack1" style="float: left;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-back" plain="true" onClick="openTakeBackDialog();" style="float: left;">收回审核</a> <div class="btn-separator"></div>
			</div>
			<div id="reAudit1" style="float: left;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openReAuditDialog();" style="float: left;">重新审核</a><div class="btn-separator"></div>
			</div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
		</div>
	</div>
	
	
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
  		<div id="audit2" data-options="iconCls:'icon-man'" onclick="queryWorkCardFileAuditor();">审核</div>
   		<div id="rollBack2" data-options="iconCls:'icon-back'" onclick="openRollBackDialog();">退回审核</div>
   		<div id="takeBack2" data-options="iconCls:'icon-back'" onclick="openTakeBackDialog();">收回审核</div>
	    <div id="reAudit2" data-options="iconCls:'icon-man'" onclick="openReAuditDialog();">重新审核</div>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	
	
	
	
	
	
	<div id="takeBackDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#takeBackBB'">
  		<form id="takeBackForm">
  			<div style="padding-top: 15px;">
  				<input id="takeBackId" type="hidden" name="id">
  				收回原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  				<input id="takeBackModularState" type="hidden" name="modularState">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="takeBackBB" style="text-align: center;">
  		<p:isPrivilege pid="im" mid="ime">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="takeBack()">收回</a>
		</p:isPrivilege>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('takeBackDialog')">取消</a>
	</div>
	
  	<div id="rollBackDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#rollBackBB'">
  		<form id="rollBackForm">
  			<div style="padding-top: 15px;">
  				<input id="rollBackId" type="hidden" name="id">
  				退回原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  				<input id="rollBackModularState" type="hidden" name="modularState">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="rollBackBB" style="text-align: center;">
	  	<p:isPrivilege pid="im" mid="imf">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="rollBack()">退回</a>
		</p:isPrivilege>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('rollBackDialog')">取消</a>
	</div>
	
  	<div id="reAuditDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#reAuditBB'">
  		<form id="reAuditForm">
  			<div style="padding-top: 15px;">
  				<input id="reAuditId" type="hidden" name="id">
  				重审原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  				<input id="reAuditModularState" type="hidden" name="modularState">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="reAuditBB" style="text-align: center;">
	  	<p:isPrivilege pid="im" mid="img">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="reAudit()">发送</a>
		</p:isPrivilege>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('reAuditDialog')">关闭</a>
	</div>
	
	
	
</body>
<style>
	.disabled{
		background-color: #069dd6;
		color: white;
	}
	.enable{
		background-color: #f0f0f0;
		color: black;
	}
</style>
</html>

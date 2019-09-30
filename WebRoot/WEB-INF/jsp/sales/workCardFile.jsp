<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<table id="workCardFileDg"></table>
<input id="workCardFileId" type="hidden" name="id" value="">
<div id="workCardFileToolBar" style="padding:5px;height:auto;">
	<div style="display:inline-block;">
		<p:isPrivilege pid="dg" mid="dge">
			<form id="workCardFileForm" style="float: left;">
				<input class="easyui-filebox" name="workCardFile" data-options="accept:'application/pdf',buttonText:'选择',buttonAlign:'left',validType:'checkPDF'">
			</form>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="uploadWorkCardFile();" style="float: left;">上传</a> <div class="btn-separator"></div>
		</p:isPrivilege>
		<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reloadWorkCardFile();" style="float: left;">刷新</a><div class="btn-separator"></div>
		<p:isPrivilege pid="dg" mid="dgf">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleteWorkCardFile();" style="float: left;">删除</a> <div class="btn-separator"></div>
		</p:isPrivilege>
		<p:isPrivilege pid="dg" mid="dgg">
			<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="queryAuditorForWorkCardFile();" style="float: left;">审核</a><div class="btn-separator"></div>
			<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="revokeProcessWorkCardFile();" style="float: left;">撤销流程</a><div class="btn-separator"></div>
		</p:isPrivilege>
		<p:isPrivilege pid="dg" mid="dgh">
			<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAntiAuditForWorkCardFileDialog();" style="float: left;">反审核</a><div class="btn-separator"></div>
		</p:isPrivilege>
	</div>
</div>
  		
<div id="workCardFileMenu" class="easyui-menu" style="width: 80px; display: none;">
	<div data-options="iconCls:'icon-reload'" onclick="reloadWorkCardFile();">刷新</div>
	<p:isPrivilege pid="dg" mid="dgf">
		<div data-options="iconCls:'icon-remove'" onclick="deleteWorkCardFile();">删除</div>
	</p:isPrivilege>
	<p:isPrivilege pid="dg" mid="dgg">
    	<div data-options="iconCls:'icon-man'" onclick="queryAuditorForWorkCardFile();">审核</div>
	    <div data-options="iconCls:'icon-cancel'" onclick="revokeProcessWorkCardFile();">撤销流程</div>
   	</p:isPrivilege>
   	<p:isPrivilege pid="dg" mid="dgh">
   		<div data-options="iconCls:'icon-man'" onclick="openAntiAuditDialogForWorkCardFile();">反审核</div>
   	</p:isPrivilege>
</div>


<div id="auditUserForWorkCardFileDialog" class="easyui-dialog" style="width: 500px;height: 400px;text-align: center;"
  	data-options="closed:true,draggable:true,modal:true,buttons:'#auditUserForWorkCardFileBB'">
  		<table id="auditUserForWorkCardFileDg"></table>
</div>
 	<!-- dialog上面dialog的按钮 -->
<div id="auditUserForWorkCardFileBB" style="text-align: center;">
	<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="auditWorkCardFile()">发送</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('auditUserForWorkCardFileDialog')">关闭</a>
</div>


<div id="antiAuditForWorkCardFileDialog" class="easyui-dialog" style="width: 400px;height: 125px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#antiAuditForWorkCardFileBB'">
  		<form id="antiAuditForWorkCardFileForm">
  			<div style="padding-top: 15px;">
  				<input id="antiAuditForWorkCardFileId" type="hidden" name="id">
  				反审原因：<input class="easyui-textbox" name="cause" style="width: 300px;" required="required">
  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="antiAuditForWorkCardFileBB" style="text-align: center;">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="antiAuditWorkCardFile()">发送</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('antiAuditForWorkCardFileDialog')">关闭</a>
	</div>
<script type="text/javascript">
	$(function () {
		//加载datagrid表格
		$("#workCardFileDg").datagrid({
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:[[
						{field:'fileName',width:400,title:'文件名',align:'center'},
						{field:'processInstanceId',width:100,title:'审核状态',align:'center'},
				      ]],//表格的各个字段
		    toolbar: '#workCardFileToolBar',
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
	            //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
	            e.preventDefault(); //阻止浏览器捕获右键事件
	            $(this).datagrid("clearSelections"); //取消所有选中项
	            if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
	            	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
	            }
	            $("#workCardFileMenu").menu('show', {//显示右键菜单
	                left: e.pageX,//在鼠标点击处显示菜单
	                top: e.pageY
	            });
	        },onHeaderContextMenu: function(e, field) { //右键时触发事件
	        	e.preventDefault();
				if (!cmenu){
					createColumnMenu();
				}
				cmenu.menu('show', {
					left:e.pageX,
					top:e.pageY
				});
	        }
		});
		
		
		
		$("#auditUserForWorkCardFileDg").datagrid({
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
	});

	function reloadWorkCardFile(){
		$("#workCardFileDg").datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
	}

	function uploadWorkCardFile(){
		var selected = $("#workCardDg").treegrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条工咭记录进行上传");
		}else{
			if ($("#workCardFileForm").form('validate')){//判断 验证是否通过
				var url = "${pageContext.request.contextPath}/sales/workCard/uploadWorkCardFile.action?id="+selected.id+"&workCardNo="+selected.workCardNo;
				$.ajax({
					type:'POST',//post请求
					url: url,//ajax请求的url
					data: new FormData($( "#workCardFileForm" )[0]),
					async: false,//同步请求
					cache: false,//不缓存此页面
					contentType: false,  
			        processData: false,  
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							if (data.success){
								showMessager("提示","上传成功");
								$("#workCardFileDg").datagrid('reload');
								$("#workCardFileForm").form('reset');
							}else{
								showMessager("错误",data.message);
							}
						}
					}
				});
			}
		}
	}


	function deleteWorkCardFile(){
		var selected = $("#workCardFileDg").datagrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行审核");
		}else{
			$.messager.confirm('确认对话框', '是否删除该文件？', function(b){
				if (b){//如何用户点击的是确认
					var id = selected.id;
					$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/sales/workCard/deleteWorkCardFileById.action",//ajax请求的url
						data: {id:id},//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success == true){
								showMessager("提示","删除成功");
								$("#workCardFileDg").datagrid('reload');
								$("#workCardFileDg").datagrid('clearSelections');
							}else{
								showMessager("错误",'<font color="red">' + data.message + '<font/>');
							}
						}
					});
				}
			});
		}
	}

	function queryAuditorForWorkCardFile(){
			var selected = $('#workCardFileDg').datagrid("getSelected");
			if (selected != null){
			var id = "";
			var processInstanceId = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
					processInstanceId = selected.processInstanceId;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#workCardFileDg').treegrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if(processInstanceId == "" || processInstanceIdInput.text() == "审核中"){
	  			$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCard/queryAuditorForWorkCardFileById.action",//ajax请求的url
					data: {id:id},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							if (data.rows.length>0){//表示还有下一节点
								$("#auditUserForWorkCardFileDg").datagrid("clearSelections");
								$("#auditUserForWorkCardFileDg").datagrid('loadData',data.rows);
								//$("#processInstanceId").val(processInstanceId);
								$("#workCardFileId").val(id);
								$("#auditUserForWorkCardFileDialog").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'请选择接收任务的人员'
								});
							}else{//表示最后一个节点
								$.messager.confirm('确认对话框', '您确定要审核吗？', function(b){
									if (b){//如何用户点击的是确认
										$.ajax({
											type:'POST',//post请求
											url: "${pageContext.request.contextPath}/sales/workCard/auditWorkCardFile.action",//ajax请求的url
											data: {id:id},//传的参数
											async: false,//同步请求
											cache: false,//不缓存此页面
											success: function(data){//请求成功后的回调函数。data：服务器返回数据。
												if (data.success){
													showMessager("提示","审核成功");
													$("#workCardFileDg").datagrid('reload');//重新加载数据，保持在当前页
													
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
	function auditWorkCardFile(){
		var selections = $("#auditUserForWorkCardFileDg").datagrid('getSelections');//取得选中的行
		if (selections==null || selections==""){
			showMessager("提示","请至少选择一个人进行审核");
		}else{
			var assigneeIds = "";
			for (var i=0;i<selections.length;i++){
				assigneeIds = assigneeIds + selections[i].id;
				if (i < (selections.length - 1)){
					assigneeIds = assigneeIds + ",";
				}
			}
			
			if (assigneeIds != undefined && assigneeIds !=null && assigneeIds != ''){
				//var processInstanceId = $("#processInstanceId").val();
				var id = $("#workCardFileId").val();
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCard/auditWorkCardFile.action",//ajax请求的url
					data: {assigneeIds:assigneeIds,id:id},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							showMessager("提示","审核成功");
							$("#auditUserForWorkCardFileDialog").dialog({//关闭这个dialog
								closed:true
							});
							$("#workCardFileDg").datagrid('reload');//重新加载数据，保持在当前页
	
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
  function revokeProcessWorkCardFile(){
	  var selected = $("#workCardFileDg").datagrid("getSelected");
	  if (selected != null){
		  var id = "";
		  var processInstanceId = "";
		  while (id == ""){
			  if (selected._parentId == undefined){//根节点
				  id = selected.id;
				  processInstanceId = selected.processInstanceId;
				  
			  }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
				  selected = $('#workCardFileDg').datagrid('getParent',selected.id);
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
							url: "${pageContext.request.contextPath}/sales/workCard/revokeProcessWorkCardFile.action",//ajax请求的url
							data: {id:id},//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data.success){
									showMessager("提示","撤销成功");
									$("#workCardFileDg").datagrid('reload');//重新加载数据，保持在当前页
									
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
  
	//打开反审的dialog
	function openAntiAuditForWorkCardFileDialog(){
		var selected = $("#workCardFileDg").datagrid('getSelected');//取得选中的行
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
					selected = $('#workCardFileDg').datagrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if (processInstanceId == ""){
				  showErrorMessager("反审失败", '没有开启审核流程');
			}else if(processInstanceIdInput.text() == "审核完成"){
				$("#antiAuditForWorkCardFileForm").form("reset");
				$("#antiAuditForWorkCardFileId").val(id);
				$("#antiAuditForWorkCardFileDialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'反审操作'//该dialog的标题
				});
			}else if(processInstanceIdInput.text() == "审核中"){
				showErrorMessager("反审失败", '当前流程未审核完成，不能重新审核');
			}
		}
	}
	
	//反审核
	function antiAuditWorkCardFile(){
		if ($("#antiAuditForWorkCardFileForm").form("validate")){
			$.messager.confirm('确认对话框', '确定要反审核吗？', function(b){
				if (b){//如何用户点击的是确认
					$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/sales/workCard/antiAuditWorkCardFile.action",//ajax请求的url
						data: $("#antiAuditForWorkCardFileForm").serialize(),//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","反审核成功");
								$("#antiAuditForWorkCardFileDialog").dialog({//加载一个dialog
									closed:true,//将该dialog的状态由不显示改成显示
								});
								//$("#dg").treegrid('clearSelections');
								$("#workCardFileDg").datagrid('reload');

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
</script>
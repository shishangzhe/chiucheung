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
		var title = "用户表";
		var url = "${pageContext.request.contextPath}/system/user/findAllSysUserCustomList.action";
		var columns = [[
				        {field:'loginName',title:'登录名',width:120,align:'center',sortable:true},    
				        {field:'username',title:'用户名',width:120,align:'center',sortable:true},
				        {field:'departmentId',title:'部门',width:100,align:'center',sortable:true},
				        {field:'groupsId',title:'分组',width:100,align:'center',sortable:true},
				        {field:'roleId',title:'角色',width:200,align:'center',sortable:true},
				        {field:'isAllowedLogin',title:'是否允许登陆',width:100,align:'center',sortable:true}
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
		//加载部门的combobox
		$('#departmentId').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "部门"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false,//不允许编辑
		    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
		    	var text = $('#departmentId').combobox('getText');
		    	if (text == '工程部'){
		    		$("#groupsId").textbox('enableValidation');
		    	}else{
		    		$("#groupsId").textbox('disableValidation');
		    	}
		    	$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//ajax请求的url
					data: {keyword:text},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						$('#groupsId').combobox('clear');
						$('#groupsId').combobox('loadData',data);
					}
				});
		    }
		});
		//分组的combobox，但是需要跟根据部门来选
		$('#groupsId').combobox({
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		//加载角色的combobox
		$('#roleId').combobox({    
		    url:"${pageContext.request.contextPath}/system/user/findAllRole.action",//加载数据的url   
		    multiple:true,
		    valueField:'id',//相当于select的key
		    textField:'roleName',//相当于select的value
		    editable:false//不允许编辑
		});
		//加载是否允许登陆的combobox
		$('#isAllowedLogin').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "是否允许登陆"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		
		//form表单的回车事件，回车提交
		$("#form1").keyup(function (event){
			if (event.keyCode == 13){
				saveOrUpdate();
			}
		});
		//form查询表单的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
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
		  		$('#loginName').textbox('enableValidation');//启用验证
				$('#loginName').textbox('readonly',false);//改为可写
				$('#loginPassword').textbox('enableValidation');//启用验证
				$("#groupsId").textbox('disableValidation');//禁用验证，当部门选到工程部才启用验证
		  		$('#groupsId').combobox("loadData","");//清空分组的下拉选框，因为他要根据部门来加载
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增用户'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	//打开用户修改窗口
  	function edit(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$('#loginName').textbox('disableValidation');//禁用验证
  			$('#loginName').textbox('readonly',true);//改为只读
  			$('#loginPassword').textbox('disableValidation');//禁用验证
  			$("#groupsId").textbox('disableValidation');//禁用验证，当部门选到工程部才启用验证
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/system/user/findSysUserById.action?id="+select.id,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#flag").val('update');
					$("#form1").form('load',data);
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:"修改用户"//该dialog的标题
					});
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
			var url = "${pageContext.request.contextPath}/system/user/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveSysUser.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateSysUser.action";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: $("#form1").serialize(),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data == '保存成功'){
						showMessager("提示",data);
						$("#dialog1").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg").datagrid('reload');//重新加载数据，保持在当前页
					}else{
						showMessager("错误",data);
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
						url: "${pageContext.request.contextPath}/system/user/deleteSysUserById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data == '删除成功'){
								showMessager("提示",data);
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误",data);
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
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
  	
  	//打开设置用户权限的窗口
  	function setUserRole(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var url = "${pageContext.request.contextPath}/system/user/findSysUserRoleCustomByUserId.action";//根据ID从后台取数据的url
  			$.ajax({
  				type:'POST',//post请求
  				url: url,//ajax请求的url
  				data: {userId:select.id},//传的参数,序列化表单
  				async: false,//同步请求
  				cache: false,//不缓存此页面
  				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
  					if (data != null && data != ""){
	  					$('#roleId').combobox('reload');
	  					$("#form2").form('load',data);//读取记录填充到表单中。
	  					$("#dialog2").dialog({//加载一个dialog
	  						closed:false,//将该dialog的状态由不显示改成显示
	  						title:"设置用户权限"//该dialog的标题
	  					});
  					}
  				}
  			});
  		}else{
			showMessager("提示","请选择一条用户进行设置");
		}
  	}
  	
  	//保存用户权限的窗口
  	function saveUserRole(){
  		var url = "${pageContext.request.contextPath}/system/user/saveSysUserRoleCustom.action";//根据form表单保存数据
  		$.ajax({
			type:'POST',//post请求
			url: url,//ajax请求的url
			data: $("#form2").serialize(),//传的参数,序列化表单
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data == '设置成功'){
					showMessager("提示",data);
					$("#dialog2").dialog({//关闭这个dialog
						closed:true
					});
					$("#dg").datagrid('reload');//重新加载数据，保持在当前页
				}else{
					showMessager("错误",data);
				}
			}
		});
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
			<p:isPrivilege pid="bc" mid="bca"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="bc" mid="bcb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="bc" mid="bcc"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="bc" mid="bcd"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="setUserRole();" style="float: left;">设置用户角色</a><div class="btn-separator"></div>
			</p:isPrivilege>
			
		</div>
		<div>
			<form id="queryForm">
				登录名：<input id="loginName_query" type="text" class="easyui-textbox" name="loginName" style="width: 70px" >
				用户名：<input id="username_query" type="text" class="easyui-textbox" name="username" style="width: 70px" >
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="bc" mid="bca"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
	    <p:isPrivilege pid="bc" mid="bcb">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="bc" mid="bcc"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="bc" mid="bcd"> 
   			<div data-options="iconCls:'icon-man'" onclick="setUserRole();">设置用户角色</div>
		</p:isPrivilege>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 300px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="userId" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td>
  						登录名：
  					</td>
	  				<td>
		  				<input id="loginName" type="text" name="loginName" class="easyui-textbox" data-options="required:true,missingMessage:'登录名不能为空',validType:'loginNameIsRepeat'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					用户名：
	  				</td>
		  			<td>
		  				<input id="username" type="text" name="username" class="easyui-textbox" data-options="required:true,missingMessage:'用户名不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					密码：
	  				</td>
		  			<td>
		  				<input id="loginPassword" type="password" name="loginPassword" class="easyui-textbox" data-options="required:true,missingMessage:'密码不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					部门：
	  				</td>
		  			<td>
		  				<input id="departmentId" name="departmentId" style="width: 100%" data-options="required:true,missingMessage:'请选择部门'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					分组：
	  				</td>
		  			<td>
		  				<input id="groupsId" name="groupsId" style="width: 100%" data-options="required:true,missingMessage:'请选择分组'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					是否允许登陆：
	  				</td>
		  			<td>
		  				<input id="isAllowedLogin" name="isAllowedLogin" style="width: 100%" data-options="required:true,missingMessage:'是否允许登陆？'">
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
	
	
	<!-- 设置用户角色的dialog -->
	<div id="dialog2" class="easyui-dialog" style="width: 250px;height: 190px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb2'">
  		<form id="form2">
  			<input id="userID" type="hidden" name="userID" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td>
  						登录名：
  					</td>
	  				<td>
		  				<input type="text" name="loginName" class="easyui-textbox" data-options="readonly:true">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					用户名：
	  				</td>
		  			<td>
		  				<input type="text" name="username" class="easyui-textbox" data-options="readonly:true">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					角色：
	  				</td>
		  			<td>
		  				<input id="roleId" name="roleId" style="width: 100%">
		  			</td>
	  			</tr>
  			</table>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb2" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveUserRole()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
	</div>
</body>    
</html>

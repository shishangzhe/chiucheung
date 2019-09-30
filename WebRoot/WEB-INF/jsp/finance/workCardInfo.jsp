<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>工咭信息</title>
	
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
		var title = "工咭信息";
		var url = "${pageContext.request.contextPath}/finance/workCardInfo/findAllWorkCardInfoList.action";
		var columns = [[
						{field:'workCardNo',title:'工咭号',width:120,align:'center',sortable:true},
				        {field:'projectLeader',title:'项目经理',width:120,align:'center',sortable:true},
				        <p:isPrivilege pid="gk" mid="gkz"> 
				        {field:'contractAmount',title:'合同金额',width:150,align:'center',sortable:true,formatter: function(value,row,index){
																													return value.replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
																												}
				        },
				        </p:isPrivilege>
				        <p:isPrivilege pid="gk" mid="gky"> 
				        {field:'expectedInstallationCost',title:'预计安装费用',width:100,align:'center',sortable:true,formatter: function(value,row,index){
																													return value.replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
																												}
				        },
				        </p:isPrivilege>
				        {field:'expectedInstallationTime',title:'预计安装工时',width:100,align:'center',sortable:true},
				        {field:'actualAuxiliaryTime',title:'实际辅助工时',width:100,align:'center',sortable:true},
				        {field:'completionDate',title:'完结日期',width:100,align:'center',sortable:true},
				        {field:'unSubmitCheckSheetNumber',title:'未提交的报账单数量',width:130,align:'center',sortable:true,formatter: function(value,row,index){
																														if (value != 0){
																															return "<font color='red'>"+value+"</font>"
																														}
																													}
				        },
				        {field:'unGeneratCheckSheetNumber',title:'未生成的报账单数量',width:130,align:'center',sortable:true,formatter: function(value,row,index){
																															if (value != 0){
																																return "<font color='red'>"+value+"</font>"
																															}
																														}
				        }
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
		
		$('#groupsId').combobox({    
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
		
		$("#queryForm2").keydown(function (event){
			if (event.keyCode == 13){
				query2();
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
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增工咭信息'//该dialog的标题
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
  			var url = "${pageContext.request.contextPath}/finance/workCardInfo/findWorkCardInfoById.action?id="+select.id;//根据ID从后台取数据的url
			$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$("#form1").form('load',url);//读取记录填充到表单中。
			$("#dialog1").dialog({//加载一个dialog
				closed:false,//将该dialog的状态由不显示改成显示
				title:"修改工咭信息"//该dialog的标题
			});
  		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
  	}
  	//新增或者保存用户数据
  	function saveOrUpdate(){
  		if ($("#form1").form('validate')){//判断 验证是否通过
			var flag = $("#flag").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/finance/workCardInfo/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveWorkCardInfo.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateWorkCardInfo.action";
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
						url: "${pageContext.request.contextPath}/finance/workCardInfo/deleteWorkCardInfoById.action",//ajax请求的url
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
  	//刷新数据
  	function reload(){
  		$("#dg").datagrid('reload');
  	}
  	//查询数据
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
  	}
  	
  	function openDialog(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form2").form('reset');//重置表单数据
				$("#dialog2").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'导出安装完结工咭明细表'//该dialog的标题
				});
			}
		});
  	}
  	
  	//导出excel
  	function exportExcel(){
  		if ($("#form2").form('validate')){//判断 验证是否通过
  			$("#form2").submit();//提交表单
  		}
  	}
  	
  	
  	function openImportExcelDialog(){
  		$("#form3").form('reset');//重置表单数据
  		$("#dialog3").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:"导入Excel"//该dialog的标题
		});
  	}
  	
  	//导入Excel
  	function importExcel(){
  		if ($("#form3").form('validate')){//判断 验证是否通过
	  		$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/finance/workCardInfo/importExcel.action",//ajax请求的url
				data: new FormData($( "#form3" )[0]),
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
  </script>
<body>   
	<table id="dg" 
		<p:isPrivilege pid="gk" mid="gkb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="gk" mid="gka"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gk" mid="gkb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="gk" mid="gkc"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="gk" mid="gkd"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="openDialog();" style="float: left;">导出安装完结工咭明细表</a><div class="btn-separator"></div>
		    </p:isPrivilege>
		    <p:isPrivilege pid="gk" mid="gke"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="openImportExcelDialog();" style="float: left;">导入Excel</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				工咭号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				项目经理：<input id="projectLeader_query" type="text" class="easyui-textbox" name="projectLeader" style="width: 70px" >
				日期：<input id="startTime_query" type="text" name="startTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endTime_query" type="text" name="endTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="gk" mid="gka"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
	    <p:isPrivilege pid="gk" mid="gkb">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="gk" mid="gkc"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="gk" mid="gkd"> 
	    	<div data-options="iconCls:'icon-redo'" onclick="openDialog();">导出安装完结工咭明细表</div>
	    </p:isPrivilege>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 440px;height: 220px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id">
  			<table style="border-spacing:10px;border-bottom: 0.5px;width: 100%;">
  				<tr style="text-align: right;">
	  				<td style="width: 100px;">
	  					工咭号：
	  				</td>
		  			<td>
		  				<input id="workCardNo" type="text" name="workCardNo" class="easyui-textbox" style="width: 100px;" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkWorkCardNoFormat',disabled:true
		  				<p:isPrivilege pid="gk" mid="gkt">
		  					,disabled:false
		  				</p:isPrivilege>
		  				">
		  			</td>
	  				<td style="width: 100px;">
	  					项目经理：
	  				</td>
		  			<td>
		  				<input id="projectLeader" type="text" name="projectLeader" class="easyui-textbox" style="width: 100px;" data-options="required:true,missingMessage:'项目经理不能为空',disabled:true
		  				<p:isPrivilege pid="gk" mid="gku">
		  					,disabled:false
		  				</p:isPrivilege>
		  				">
		  			</td>
	  			</tr>
	  			<tr style="text-align: right;">
	  				<td>
	  					<p:isPrivilege pid="gk" mid="gkz"> 
	  						合同金额：
	  					</p:isPrivilege>
	  				</td>
		  			<td>
		  				<p:isPrivilege pid="gk" mid="gkz"> 
		  					<input id="contractAmount" type="text" name="contractAmount" class="easyui-numberbox" style="width: 100px;" data-options="precision:2,groupSeparator:','">
		  				</p:isPrivilege>
		  			</td>
		  			<td>
		  				<p:isPrivilege pid="gk" mid="gky"> 
	  						预计安装费用：
	  					</p:isPrivilege>
	  				</td>
		  			<td>
		  				<p:isPrivilege pid="gk" mid="gky"> 
		  					<input id="expectedInstallationCost" type="text" name="expectedInstallationCost" class="easyui-numberbox" style="width: 100px;" data-options="precision:2,groupSeparator:','">
		  				</p:isPrivilege>
		  			</td>
	  			</tr>
	  			<tr style="text-align: right;">
	  				<td>
	  					预计安装工时：
	  				</td>
		  			<td>
		  				<input id="expectedInstallationTime" type="text" name="expectedInstallationTime" class="easyui-numberbox" style="width: 100px;" data-options="precision:1,disabled:true
		  				<p:isPrivilege pid="gk" mid="gkv">
		  					,disabled:false
		  				</p:isPrivilege>
		  				">
		  			</td>
	  				<td>
	  					实际辅助工时：
	  				</td>
		  			<td>
		  				<input id="actualAuxiliaryTime" type="text" name="actualAuxiliaryTime" class="easyui-numberbox" style="width: 100px;" data-options="precision:1,disabled:true
		  				<p:isPrivilege pid="gk" mid="gkw">
		  					,disabled:false
		  				</p:isPrivilege>
		  				">
		  			</td>
	  			</tr>
	  			<tr style="text-align: right;">
	  				<td>
	  					完结日期：
	  				</td>
		  			<td colspan="3" style="text-align: left;">
		  				<input id="completionDate" type="text" name="completionDate" class="easyui-datebox" style="width: 100px;" data-options="editable:false,disabled:true
		  				<p:isPrivilege pid="gk" mid="gkx">
		  					,disabled:false
		  				</p:isPrivilege>
		  				">
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
	
	
	<div id="dialog2" class="easyui-dialog" style="width: 300px;height: 230px;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb2'">
  		<div style="line-height: 35px;">
  			<form id="form2" method="post" action="${pageContext.request.contextPath }/finance/workCardInfo/exportExcel.action" target="_BLANK">
  				开始时间：<input type="text" name="startTime" style="width: 92px" class="easyui-datebox" data-options="required:true,missingMessage:'开始日期不能为空',editable:false">
  				<br/>
  				结束时间：<input type="text" name="endTime" style="width: 92px" class="easyui-datebox" data-options="required:true,missingMessage:'结束日期不能为空',editable:false">
  				<br/>
  				按 分 组：<input id="groupsId" name="groupsId" style="width: 92px" class="easyui-combobox clearButton">
  				<br/>
  				按 工 咭：<input type="text" name="workCardNo" style="width: 92px" class="easyui-textbox">
  			</form>
  		</div>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb2" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="exportExcel()">导出</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
	</div>
	
	
		<div id="dialog3" class="easyui-dialog" style="width: 480px;height: 140px;text-align: center;padding-top: 20px;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb3'">
  		<form id="form3">
  			<input class="easyui-filebox" name="uploadFile" style="width:300px;" data-options="required:true,missingMessage:'请选择Excel文件',validType:'checkExcel'">
  		</form>
  	</div>
  	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb3" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="importExcel()">导入</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog3')">关闭</a>
	</div>
</body>    
</html>

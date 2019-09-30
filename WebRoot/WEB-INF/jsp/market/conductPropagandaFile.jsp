<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>宣传文件管理</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
	<style type="text/css">
		a:visited { 
		color:#0066cc; 
		text-decoration:none; 
		} 
	</style>
  <script type="text/javascript">
  	var intervalId;
  	var ajax;
  	
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
	}
  	$(function(){
		var tableId = "dg";
		var title = "宣传文件";
		var url = "${pageContext.request.contextPath}/market/conductPropagandaFile/findAllConductPropagandaFile.action";
		var columns = [[
				        {field:'fileName',title:'文件名',width:320,align:'left',sortable:true,formatter: function(value,row,index){
																											return "<a target='_blank' href='${pageContext.request.contextPath}/market/conductPropagandaFile/readConductPropagandaFileById.action?id=" + row.id + "'>"+value+"</a>";
																										}
				        },    
				        {field:'fileVersion',title:'版本',width:50,align:'center',sortable:true},
				        {field:'createTime',title:'创建时间',width:200,align:'center',sortable:true},
				        {field:'downloadURL',title:'下载',width:320,align:'left',sortable:true,formatter: function(value,row,index){
													return "<a target='_blank' href='${pageContext.request.contextPath}/market/conductPropagandaFile/downloadConductPropagandaFileById.action?id=" + row.id + "'>"+row.fileName+"</a>";
												}
						},
				    ]];
		var gridToolBarId = "#gridToolBar";
		var menuId = "menu";
		loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
		
		$("#dg").datagrid({
			onSelect: function(index, row){
				$("#dg1").datagrid('options').url = "${pageContext.request.contextPath}/market/conductPropagandaFile/findAllOldConductPropagandaFileByNewId.action";
				$("#dg1").datagrid('reload',{
					id:row.id
				});
				$('#dg1').datagrid('unselectAll');
			}
		});
		
		
		
		var tableId = "dg1";
		var title = "更多版本";
		var columns = [[
				        {field:'fileName',title:'文件名',width:320,align:'left',sortable:true,formatter: function(value,row,index){
																											return "<a target='_blank' href='${pageContext.request.contextPath}/market/conductPropagandaFile/readConductPropagandaFileById.action?id=" + row.id + "'>"+value+"</a>";
																										}
				        },    
				        {field:'fileVersion',title:'版本',width:50,align:'center',sortable:true},
				        {field:'createTime',title:'创建时间',width:200,align:'center',sortable:true},
				        {field:'downloadURL',title:'下载',width:320,align:'left',sortable:true,formatter: function(value,row,index){
													return "<a target='_blank' href='${pageContext.request.contextPath}/market/conductPropagandaFile/downloadConductPropagandaFileById.action?id=" + row.id + "'>"+row.fileName+"</a>";
												}
						},
				    ]];
		var gridToolBarId = "";
		var menuId = "";
		loadDataGrid1(tableId,title,null,columns,gridToolBarId,menuId);
		
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
  	
  	//打开宣传文件新增窗口
  	function add(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
				$('#uploadDiv').hide();
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'上传宣传文件'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	//打开更新宣传文件版本
  	function edit(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.ajax({
  				type:'POST',//post请求
  				url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
  				async: false,//同步请求
  				cache: false,//不缓存此页面
  				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
  					$("#form1").form('reset');//重置表单数据
  					$('#uploadDiv').hide();
  					$('#save').show();
  			  		$('#close').show();
  					$("#dialog1").dialog({//加载一个dialog
  						closed:false,//将该dialog的状态由不显示改成显示
  						title:"更新宣传文件版本"//该dialog的标题
  					});
  					$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
  					$("#fileName").val(select.fileName);
  				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行更新");
		}
  	}
  	//新增或者保存用户数据
  	function saveOrUpdate(){
  		if ($("#form1").form('validate')){//判断 验证是否通过
			var flag = $("#flag").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/market/conductPropagandaFile/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveConductPropagandaFile.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateConductPropagandaFile.action";
			}
			ajax = $.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: new FormData($( "#form1" )[0]),
				async: true,//异步请求
				cache: false,//不缓存此页面
				contentType: false,  
		        processData: false,  
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						window.clearInterval(intervalId);
						$('#uploadDiv').hide();
						$('#save').show();
				  		$('#close').show();
						showMessager("提示","上传成功");
						$("#dialog1").dialog({//关闭这个dialog
							closed:true
						});
						reload();//重新加载数据，保持在当前页
					}else{
						showMessager("错误",data.message);
					}
				}
			});
			showStatus();
		}
  	}
  	
  	//获取进度
  	function showStatus(){
  		intervalId = setInterval(function(){
	  		$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/market/conductPropagandaFile/getPorgress.action",//ajax请求的url
				async: true,//异步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						$('#uploadDiv').show();
						$('#save').hide();
				  		$('#close').hide();
						$('#progress').progressbar('setValue',((data.status.pBytesRead/data.status.pContentLength)*100).toFixed(2));
					}else{
						showMessager("错误",data.message);
					}
				}
			});
  		},100);
  	}
  	
  	//删除用户数据
  	function removeData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/market/conductPropagandaFile/deleteConductPropagandaFileById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","删除成功");
								reload();//重新加载数据，保持在当前页
								$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误",data.message);
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
  		$("#dg").datagrid('unselectAll');
  		$("#dg1").datagrid('loadData',{ total: 0, rows: [] });
  	}
  	//查询数据
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
  		$("#dg").datagrid('unselectAll');
  		$("#dg1").datagrid('loadData',{ total: 0, rows: [] });
  	}
  	
  	function cancelUpload(){
  		ajax.abort();
  		window.clearInterval(intervalId);
  		$('#uploadDiv').hide();
  		$('#save').show();
  		$('#close').show();
  		document.getElementById("uploadDiv").style.display("none");
  	}
  </script>
<body class="easyui-layout">  
	<div data-options="region:'center'" style="background:#eee;">
		<table id="dg" 
			<p:isPrivilege pid="bc" mid="bcb"> 
				data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
			</p:isPrivilege>
		></table>
		<!-- 上面表格的toolbar按钮 -->
		<div id="gridToolBar" style="padding:5px;height:auto">
			<div style="display:inline-block;">
				<p:isPrivilege pid="fh" mid="fha"> 
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">上传</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="fh" mid="fhb"> 
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">更新</a> <div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="fh" mid="fhc"> 
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
				</p:isPrivilege>
				<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
				
			</div>
			<div>
				<form id="queryForm">
					文件名：<input id="fileName_query" type="text" class="easyui-textbox" name="fileName" style="width: 70px" >
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
				</form>
			</div>
		</div>
		<!-- 上面表格的右键菜单 -->
	  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
		    <!--放置一个隐藏的菜单Div-->
		    <p:isPrivilege pid="fh" mid="fha"> 
		    	<div data-options="iconCls:'icon-add'" onclick="add();">上传</div>
		    </p:isPrivilege>
		    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
		    <p:isPrivilege pid="fh" mid="fhb">
		    	<div data-options="iconCls:'icon-edit'" onclick="edit();">更新</div>
	    	</p:isPrivilege>
	    	<p:isPrivilege pid="fh" mid="fhc"> 
		    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
	    	</p:isPrivilege>
		    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
		</div>
		
		<!-- 增&改用户的dialog -->
	  	<div id="dialog1" class="easyui-dialog" style="width: 400px;height: 180px;text-align: center;padding-top: 20px;"
	  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
	  		<form id="form1">
	  			<input id="flag" type="hidden" value="">
	  			<input id="fileName" name="fileName" type="hidden">
	  			<input id="file" name="file" class="easyui-filebox" style="width: 300px;" data-options="required:true,buttonAlign:'left',buttonText:'浏览',missingMessage:'文件不能为空',validType:'checkFileSize[\'500\',\'flag\']'">
	  			<div id="uploadDiv" style="padding-top: 20px;padding-left: 10px;display: none;">
	  				<div id="progress" class="easyui-progressbar" data-options="value:0" style="width:320px;float: left;"></div> 
	  				<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="cancelUpload();" style="float: left;"></a>
	  			</div>
	  		</form>
	  	</div>
	  	<!-- dialog上面dialog的按钮 -->
	  	<div id="bb1" style="text-align: center;">
			<a id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdate()">保存</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
		</div>
	</div>
	<div data-options="region:'south',hideCollapsedContent:false,expandMode:'dock',split:true" style="height:200px;margin-bottom: -3px">
		<table id="dg1"></table>
	</div>
</body>    
</html>

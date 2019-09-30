<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>项目信息</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/viewer/js/viewer.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/viewer/css/viewer.css">
	
	
  </head>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
	}
  	$(function(){
		//加载datagrid表格
		$("#dg").datagrid({
			title:"项目信息",//表格的标题
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
			pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    url:"${pageContext.request.contextPath}/sales/projectInfo/findAllProjectInfoList.action",//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:[[
						{field:'workCardNo',title:'工咭号',width:100,align:'center',sortable:true},    
				        {field:'year',title:'年',width:70,align:'center',sortable:true},    
				        {field:'country',title:'国家',width:120,align:'center',sortable:true},
				        {field:'province',title:'省份',width:100,align:'center',sortable:true},
				        {field:'city',title:'市',width:100,align:'center',sortable:true},
				        {field:'industry',title:'行业',width:100,align:'center',sortable:true},
				        {field:'custom',title:'客户',width:200,align:'center',sortable:true},
				    ]],//表格的各个字段
		    toolbar: "#gridToolBar",
		    view: detailview, 
		    detailFormatter: function(rowIndex, rowData){
		    	var context = "";
		    	if (rowData.picIds.length > 0){
			    	context += '<ul id="pic' + rowIndex + '" style="margin:0;padding:0;margin-top:3px;margin-left:3px;max-width: 790px;">';
			    	for (var i=0;i<rowData.picIds.length;i++){
			    		context += '<li style="list-style:none;float: left;border: 2px solid transparent;overflow: hidden;"><img src="${pageContext.request.contextPath}/sales/projectInfo/getPicIoById.action?id=' + rowData.picIds[i] + '&thumbnails=true" data-original="${pageContext.request.contextPath}/sales/projectInfo/getPicIoById.action?id=' + rowData.picIds[i] + '&thumbnails=false" style="height:80px;cursor: pointer;"></li>';
			    	}
					
			    	context += '</ul>';
		    	}
		    	return context;
		    	/* var context = '<table><tr>';
		    	for (var i=0;i<rowData.picIds.length;i++){
		    		context +=  '<td style="border:0"><img src="${pageContext.request.contextPath}/sales/projectInfo/getPicIoById.action?id=' + rowData.picIds[i] + '&thumbnails=true" style="height:50px;"></td>';
		    	}
				
		    	context += '</tr></table>'; 
		    	return context; */

		    },
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
            },onHeaderContextMenu: function(e, field) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，field点击的表头字段
            	/*$.fn.easyuiExtension.showHideColumns($(this), {
                    left: e.clientX,
                    top: e.clientY
                  });
                  e.preventDefault();*/
            	e.preventDefault();
				if (!cmenu){
					createColumnMenu();
				}
				cmenu.menu('show', {
					left:e.pageX,
					top:e.pageY
				});
            },
            onLoadSuccess:function(data){
            	var row = $("#dg").datagrid("getRows");
                for (var r = 0; r < row.length; r++){
                	if (row[r].picIds != "" && row[r].picIds.length > 0){
                    	$("#dg").datagrid("expandRow",r);
                    }
                    //$("#dg").datagrid("getExpander",r).hide(); //隐藏折叠展开的，但是显示有bug
                }
                $('ul[id^="pic"]').viewer({
            		url: 'data-original'
            	});
            }
		});
		var cmenu;//右键菜单，可以隐藏和显示列信息
		function createColumnMenu(){
			cmenu = $('<div/>').appendTo('body');
			var fields = $("#dg").datagrid('getColumnFields');
			var nonHiddenCount = 0;//用来记录隐藏的item数
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						if (nonHiddenCount<fields.length-1){
							$("#dg").datagrid('hideColumn', item.name);
							nonHiddenCount++;
							cmenu.menu('setIcon', {
								target: item.target,
								iconCls: 'icon-empty'
							});
						}
					} else {
						$("#dg").datagrid('showColumn', item.name);
						nonHiddenCount--;
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-ok'
						});
					}
				}
			});
			for(var i=0; i<fields.length; i++){
				var field = fields[i];
				var col = $("#"+tableId).datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
		
		
		
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
				$("#editPic").empty();
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增项目信息'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	//打开用户修改窗口
  	function edit(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/sales/projectInfo/findSalProjectInfoById.action?id="+select.id,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						$("#form1").form('reset');//重置表单数据
						$("#flag").val('update');
						$("#form1").form('load',data.projectInfo);
						$("#editPic").empty();
						var picIds = data.projectInfo.picIds;
						for (var i=0;i<picIds.length;i++){
							$("#editPic").append('<div id="' + picIds[i] + '" style="padding-right:5px;padding-top:5px;float:left;position:relative;">'+
							<p:isPrivilege pid="dk" mid="dkc">
								'<a style="position:absolute; top:0; right:0; z-index:99; cursor: pointer;" onclick="removePic(\'' + picIds[i] + '\')"><img style="width:12px;" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/icons/no.png"></a>'+
							</p:isPrivilege> 
							'<img style="height:60px;" src="${pageContext.request.contextPath}/sales/projectInfo/getPicIoById.action?id=' + picIds[i] + '&thumbnails=true"></div>');
						}
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:"修改项目信息"//该dialog的标题
						});
					}else{
						showMessager("错误",data.message);
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
			var url = "${pageContext.request.contextPath}/sales/projectInfo/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveSalProjectInfo.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateSalProjectInfo.action";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data:  new FormData($( "#form1" )[0]),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				contentType: false,  
		        processData: false,  
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						showMessager("提示","保存成功");
						$("#dialog1").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg").datagrid('reload');//重新加载数据，保持在当前页
					}else{
						showMessager("错误",data.message);
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
						url: "${pageContext.request.contextPath}/sales/projectInfo/deleteSalProjectInfoById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","删除成功");
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
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
  	}
  	//查询数据
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
  	}
  	
  	//删除图片
  	function removePic(id){
  		$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
			if (b){//如何用户点击的是确认
	  			$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/projectInfo/deleteSalProjectInfoPicById.action",//ajax请求的url
					data: {id:id},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							$("#"+id).remove();
							var src = "${pageContext.request.contextPath}/sales/projectInfo/getPicIoById.action?id=" + id + "&thumbnails=true";
							var ul = $("img[src='"+src+"']").parent().parent();
							
							$("img[src='"+src+"']").parent().remove();
							
							if (ul.children().length == 0){//如果没有图片，则折叠
								$("#dg").datagrid("collapseRow",$("#dg").datagrid("getRowIndex",$("#dg").datagrid("getSelected")));
							}
						}else{
							showMessager("错误",data.message);
						}
					}
				});
			}
		});
  	}
  	
  	
  	function openImportExcelDialog(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form2").form('reset');//重置表单数据
				$("#dialog2").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'导入Excel'//该dialog的标题
				});
			}
		});
  	}
  	
  	function importExcel(){
  		if ($("#form2").form('validate')){//判断 验证是否通过
			var url = "${pageContext.request.contextPath}/sales/projectInfo/importExcel.action";
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data:  new FormData($( "#form2" )[0]),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				contentType: false,  
		        processData: false,  
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						showMessager("提示",data.message);
						$("#dialog2").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg").datagrid('reload');//重新加载数据，保持在当前页
					}else{
						showMessager("错误",data.message);
					}
				}
			});
		}
  	}
  	
  	function exportExcel(){
  		window.open("${pageContext.request.contextPath}/sales/projectInfo/exportExcel.action");
  	}
  	
  </script>
<body>   
	<table id="dg" 
		<p:isPrivilege pid="dk" mid="dkb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="dk" mid="dka"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="dk" mid="dkb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="dk" mid="dkc">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="dk" mid="dke">
				<a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onClick="openImportExcelDialog();" style="float: left;">导入Excel</a> <div class="btn-separator"></div>
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onClick="exportExcel();" style="float: left;">导出Excel</a> <div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				工咭号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				年：<input id="name_query" type="text" class="easyui-numberbox" name="year" style="width: 70px" >
				国家：<input id="country_query" type="text" class="easyui-textbox" name="country" style="width: 70px">
				省份：<input id="province_query" type="text" class="easyui-textbox" name="province" style="width: 70px">
				 市：<input id="city_query" type="text" class="easyui-textbox" name="city" style="width: 70px">
				 行业：<input id="industry_query" type="text" class="easyui-textbox" name="industry" style="width: 70px">
				 客户：<input id="custom_query" type="text" class="easyui-textbox" name="custom" style="width: 70px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="dk" mid="dka"> 
	    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
	    </p:isPrivilege>
	    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
	    <p:isPrivilege pid="dk" mid="dkb">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="dk" mid="dkc"> 
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 480px;height: 400px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1" >
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td style="text-align: right;">
  						工咭号：
  					</td>
	  				<td style="text-align: left;">
		  				<input id="workCardNo" type="text" name="workCardNo" class="easyui-textbox">
		  			</td>
		  			<td style="text-align: right;">
  						年：
  					</td>
	  				<td style="text-align: left;">
		  				<input id="year" type="text" name="year" class="easyui-numberbox" data-options="required:true,missingMessage:'年不能为空'">
		  			</td>
	  			</tr>
  				<tr>
	  				<td style="text-align: right;">
	  					国家：
	  				</td>
		  			<td style="text-align: left;">
		  				<input id="country" type="text" name="country" class="easyui-textbox" data-options="required:true,missingMessage:'国家不能为空'">
		  			</td>
		  			<td style="text-align: right;">
	  					省份：
	  				</td>
		  			<td style="text-align: left;">
		  				<input id="province" type="text" name="province" class="easyui-textbox" data-options="required:true,missingMessage:'省份不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					市：
	  				</td>
		  			<td style="text-align: left;">
		  				<input id="city" type="text" name="city" class="easyui-textbox" data-options="required:true,missingMessage:'市不能为空'">
		  			</td>
		  			<td style="text-align: right;">
	  					行业：
	  				</td>
		  			<td style="text-align: left;">
		  				<input id="industry" type="text" name="industry" class="easyui-textbox" data-options="required:true,missingMessage:'行业不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td style="text-align: right;">
	  					客户：
	  				</td>
		  			<td style="text-align: left;">
		  				<input id="custom" type="text" name="custom" class="easyui-textbox" data-options="required:true,missingMessage:'客户不能为空'">
		  			</td>
		  			<td style="text-align: right;">
	  					图片：
	  				</td>
		  			<td style="text-align: left;">
		  				<input id="pic" class="easyui-filebox" name="pic" data-options="buttonText:'浏览',buttonAlign:'left',multiple:true,validType:'checkPic'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td colspan="4">
	  					<div id="editPic">
	  					
	  					</div>
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
	
	
	<div id="dialog2" class="easyui-dialog" style="width: 300px;height: 120px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb2'">
  		<form id="form2" style="padding-top: 12px;" >
			<input id="excel" class="easyui-filebox" name="excel" style="width:85%;" data-options="buttonText:'浏览',buttonAlign:'left',validType:'checkExcel'">
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb2" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="importExcel()">导入</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
	</div>
	
</body>    
</html>

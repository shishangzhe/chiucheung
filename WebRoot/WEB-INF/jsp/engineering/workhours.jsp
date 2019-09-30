<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>工程工时</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
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
  
  
	  $(function(){
			var tableId = "dg";
			var title = "工时";
			var url = "${pageContext.request.contextPath}/engineering/workhours/findAllWorkHoursList.action";
			var columns = [[
					        {field:'workHoursDate',title:'日期',width:100,align:'center',sortable:true},
					        {field:'userId',title:'姓名',width:100,align:'center',sortable:true},
					        {field:'workCardNo',title:'工咭号',width:100,align:'center',sortable:true},
					        {field:'workCardItem',title:'工咭项次',width:150,align:'center',sortable:true},
					        {field:'workContent',title:'工作内容',width:120,align:'center',sortable:true},
					        {field:'workContentCustom',title:'自定义工作内容',width:200,align:'center',sortable:true},
					        {field:'workHours',title:'工时',width:80,align:'center',sortable:true},
					        {field:'workShiftId',title:'班次',width:80,align:'center',sortable:true}
					    ]];
			var gridToolBarId = "#gridToolBar";
			var menuId = "menu";
			loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
			
			//设置分页
			/* var pager = $('#dg').datagrid().datagrid('getPager');     
			pager.pagination({  
			  displayMsg:'<div style="padding-right:600px">to:{to} from:{from} total:{total}</div>'  
			}); */ 
			/* $("#dg").datagrid({
				onLoadSuccess:function(data){
					var tr = $("div[class='datagrid-pager pagination']").children("table").children("tbody").children("tr");
					if (tr.children("td").length == 13){
						tr.append('<td style="padding-left:30px;">总工时：<span style="color:red;">' + data.sum + '</span></td>');
					}else if (tr.children("td").length > 13){
						tr.children("td").last().html('总工时：<span style="color:red;">' + data.sum + '</span>');
					}
				}
			}); */
			
			
			
			//当时间更改时，重新验证工时
			$('#workHoursDate').datebox({
				onChange:function (newValue, oldValue){
					$("#workHours").textbox('validate');//更换了日期，让工时重新验证
				}
			});
			
			$('#workCardCategory').combobox({    
			    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "工咭类别"
				},
			    valueField:'dictionarieName',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false,//不允许编辑
			    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
			    	if (newValue == '其他'){
			    		$("#workCardNo").textbox('disable');//禁用组件
			    		$("#workCardNo").textbox('clear');//清空组件
			    		
			    		$("#workCardYear").combobox('disable');
			    		$("#workCardYear").combobox('clear');
			    		
			    		$("#workCardItem").textbox('disable');
			    		$("#workCardItem").textbox('clear');
			    		
			    		//加载工作内容
			    		$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//ajax请求的url
							data: {keyword:'其他工作内容'},//传的参数,序列化表单
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								$('#workContent').combobox('clear');
								$('#workContent').combobox('loadData',data);
							}
						});
			    		
			    	}else{
			    		$("#workCardNo").textbox('enable');
			    		$("#workCardYear").combobox('enable');
			    		$("#workCardItem").textbox('enable');
			    		
			    		//加载工作内容
			    		$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//ajax请求的url
							data: {keyword:'工作内容'},//传的参数,序列化表单
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								$('#workContent').combobox('clear');
								$('#workContent').combobox('loadData',data);
							}
						});
			    	}
			    }
			});
			
			$('#workShiftId').combobox({    
			    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "班次"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false,//不允许编辑
			    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
			    	$("#workHours").textbox('validate');//更换了班次，让工时重新验证
			    }
			});
			
			$('#workShiftId_query').combobox({    
			    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "班次"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false,//不允许编辑
			});
			
			
			
			$('#workContent').combobox({    
			    valueField:'dictionarieName',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false,//不允许编辑
			    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
			    	if (newValue == '自定义......'){
			    		$("#showHide").show();
			    		$("#workContentCustom").textbox('enable');
			    		$("#workContentCustom").textbox('enableValidation');
			    	}else if (newValue == '待工学习'){
			    		$("#showHide").show();
			    		$("#workContentCustom").textbox('enable');
			    		$("#workContentCustom").textbox('disableValidation');
			    	}else{
			    		$("#showHide").hide();
			    		$("#workContentCustom").textbox('disable');
			    	}
			    }
			});
			
			
			//form表单的回车事件，回车提交
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
		  		$('#workContent').combobox('loadData',{});
		  		$("#id").val("");
		  		$("#showHide").hide();
		  		$("#workCardNo").textbox('enable');
				$("#workCardYear").combobox('enable');
				$("#workCardItem").textbox('enable');
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:"新增工时"//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				$("#workShiftId").combobox('select',"1");//选择刚选择或新增的keyword
			}
		});
  	}
	
	//打开用户修改窗口
	function edit(){
		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var url = "${pageContext.request.contextPath}/engineering/workhours/findEngWorkHoursById.action?id="+select.id;//根据ID从后台取数据的url
			$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success == true){
							$("#dialog1").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:"修改工时("+data.row.username+")"//该dialog的标题
							});
							$("#form1").form('load',data.row);
						}else{
							showMessager("错误",data.message);
						}
					}
				}
			});
  		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	//保存更新数据
  	function saveOrUpdate(){
  		$(".easyui-textbox").each(function(){//清除首尾空格
  		 	$(this).textbox('setText',$(this).textbox('getText').replace(/(^\s+)|\s+$/g,""));
  		});
  		if ($("#form1").form('validate')){
  			var flag = $("#flag").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/engineering/workhours/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveEngWorkHours.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateEngWorkHours.action";
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
	
	//删除数据
	function removeData(){
		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/engineering/workhours/deleteEngWorkHoursById.action",//ajax请求的url
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
  	
  	//导出工时的Excel
  	function exportExcel(){
  		var queryParams = $("#dg").datagrid('options').queryParams;//获取当前查询的条件
  		$("#exportExcel").form('load',queryParams);//将查询条件赋值到导出Excel表格的表单
  		$("#exportExcel").submit();//提交表单
		//window.open("${pageContext.request.contextPath }/engineering/workhours/exportExcel.action?"+$("#exportExcel").serialize());
  	}
  	//导出施工成绩表的Excel
  	function exportResultsExcel(flag){
  		$("#flag").val(flag);
  		$("#exportResultsExcel").submit();//提交表单
		//window.open("${pageContext.request.contextPath }/engineering/workhours/exportExcel.action?"+$("#exportExcel").serialize());
  	}
  	function sum(){
  		var url = "${pageContext.request.contextPath}/engineering/workhours/sumEngWorkHours.action";
  		$.ajax({
			type:'POST',//post请求
			url: url,//ajax请求的url
			data: $("#dg").datagrid('options').queryParams,
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data != null && data != ""){
					if (data.success == true){
						alert(data.sum);
					}else{
						showMessager("错误",data.message);
					}
				}
			}
		});
  	}
  	
  </script>
<body>   
	<table id="dg" style="width: 715px;height: 675px;"
		<p:isPrivilege pid="cd" mid="cdb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="cd" mid="cda"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="cd" mid="cdb"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="cd" mid="cdc"> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="cd" mid="cdh"> 
				<form id="exportResultsExcel" action="${pageContext.request.contextPath }/engineering/workhours/exportResultsExcel.action" style="float: left;" method="post">
					开始日期：<input type="text" name="startWorkHoursDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
					结束日期：<input type="text" name="endWorkHoursDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
					<input id="flag" type="hidden" name="flag">
				</form>
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportResultsExcel(1);" style="float: left;">导出施工成绩表</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportResultsExcel(2);" style="float: left;">导出工时分布表</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportResultsExcel(3);" style="float: left;">导出工咭工时月统计表</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportResultsExcel(4);" style="float: left;">导出实做工咭工时分析</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportResultsExcel(5);" style="float: left;">导出工咭产值结算表</a>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				开始日期：<input id="startWorkHoursDate_query" type="text" name="startWorkHoursDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				结束日期：<input id="endWorkHoursDate_query" type="text" name="endWorkHoursDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				姓名：<input id="username_query" type="text" name="username" class="easyui-textbox" style="width: 60px">
				工咭号：<input id="workCardNo_query" type="text" name="workCardNo" class="easyui-textbox" style="width: 70px">
				项次：<input id="workCardItem_query" type="text" name="workCardItem" class="easyui-textbox" style="width: 80px">
				工作内容：<input id="workContent_query" type="text" name="workContent" class="easyui-textbox" style="width: 80px">
				班次：<input id="workShiftId_query" name="workShiftId" class="clearButton" style="width:80px ">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
				<p:isPrivilege pid="cd" mid="cdd"> 
					<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportExcel();">导出工时</a>
				</p:isPrivilege>
				<a href="#" class="easyui-linkbutton" iconCls="icon-sum" plain="true" onclick="sum();">计算总工时</a>
			</form>
			<form id="exportExcel" action="${pageContext.request.contextPath }/engineering/workhours/exportExcel.action" style="display: none;" method="post">
				开始日期：<input type="text" name="startWorkHoursDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				结束日期：<input type="text" name="endWorkHoursDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				姓名：<input type="text" name="username" class="easyui-textbox" style="width: 60px">
				工咭号：<input type="text" name="workCardNo" class="easyui-textbox" style="width: 70px">
				项次：<input type="easyui-textbox" name="workCardItem" class="easyui-textbox" style="width: 80px">
				工作内容：<input type="text" name="workContent" class="easyui-textbox" style="width: 80px">
				班次：<input name="workShiftId" style="width:55px ">
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
  		<p:isPrivilege pid="cd" mid="cda"> 
    		<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		</p:isPrivilege>
    	<p:isPrivilege pid="cd" mid="cdb"> 
    		<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
    	<p:isPrivilege pid="cd" mid="cdc"> 
    		<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
   		</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 330px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<input id="userId" type="hidden" name="userId" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td>
  						日期：
  					</td>
	  				<td>
		  				<input id="workHoursDate" type="text" name="workHoursDate" class="easyui-datebox" style="width: 160px" value="<p:date/>" data-options="editable:false,required:true,missingMessage:'日期不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					工咭号：
	  				</td>
		  			<td>
		  				<input id="workCardCategory" type="text" name="workCardCategory" style="width: 60px" data-options="required:true,missingMessage:'工咭类别不能为空'">
		  				<input id="workCardNo" type="text" name="workCardNo" class="easyui-textbox" style="width: 40px" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkWorkCardNo'">-
		  				<select id="workCardYear" class="easyui-combobox" name="workCardYear" style="width:50px;" data-options="required:true,editable:false,missingMessage:'工咭年份不能为空'">
		  					<p:getYear times="10" year="year">   
						    	<option value="${year}">${year}</option>   
						    </p:getYear>
						</select> 
		  				
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					工咭项次：
	  				</td>
		  			<td>
		  				<input id="workCardItem" type="easyui-textbox" name="workCardItem" class="easyui-textbox" style="width: 160px" data-options="required:true,missingMessage:'项次不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					工时：
	  				</td>
		  			<td>
		  				<input id="workHours" type="text" name="workHours" class="easyui-textbox" style="width: 98px" required="required" missingMessage="工时不能为空" validType="checkWorkHours['#workShiftId','#workHoursDate','#id']">
		  				<input id="workShiftId" name="workShiftId" style="width:60px " data-options="required:true,missingMessage:'班次不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					工作内容：
	  				</td>
		  			<td>
		  				<input id="workContent" type="text" name="workContent" style="width: 160px" data-options="required:true,missingMessage:'工作内容不能为空'">
		  			</td>
	  			</tr>
	  			<tr>
	  				<td colspan="2">
	  					<div id="showHide">
	  						<input id="workContentCustom" type="text" name="workContentCustom" style="width: 230px;height: 40px;" class="easyui-textbox" data-options="required:true,missingMessage:'工作内容不能为空',multiline:true,disabled:true">
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
	
</body>    
</html>

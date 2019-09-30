<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>资料分发记录表</title>
	
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
			var title = "工咭资料分发记录登记表";
			var url = "${pageContext.request.contextPath}/engineering/workCardProgress/findAllWorkCardProgressList.action";
			var columns = [[
					        {field:'workCardNo',title:'工咭号',width:100,align:'center',sortable:true},
					        {field:'quotationNo',title:'QN编号',width:100,align:'center',sortable:true},
					        {field:'projectLeader',title:'项目负责人',width:80,align:'center',sortable:true},
					        {field:'workCardDate',title:'下单日期',width:100,align:'center',sortable:true},
					        {field:'projectName',title:'货品名称',width:150,align:'center',sortable:true},
					        {field:'productModel',title:'规格型号',width:150,align:'center',sortable:true},
					        {field:'quantity',title:'数量',width:120,align:'center',sortable:true},
					        {field:'category',title:'类型',width:120,align:'center',sortable:true},
					        {field:'expectedDeliveryDate',title:'预交期',width:100,align:'center',sortable:true},
					        {field:'saleOweData',title:'欠设备资料',width:100,align:'center',sortable:true},
					        {field:'engReviewerDate',title:'工程评审时间',width:80,align:'center',sortable:true},
					        {field:'engReleaseDataDate',title:'工程预下资料日期',width:80,align:'center',sortable:true},
					        {field:'orderMaterialBom',title:'订料BOM',width:80,align:'center',sortable:true},
					        {field:'mainBody',title:'主体',width:80,align:'center',sortable:true},
					        {field:'other',title:'其他',width:80,align:'center',sortable:true},
					        {field:'bom',title:'BOM',width:80,align:'center',sortable:true},
					        {field:'engOweData',title:'尚欠资料',width:80,align:'center',sortable:true},
					        {field:'actualCompleteTime',title:'实际完成时间',width:80,align:'center',sortable:true},
					        {field:'engNgQuestion',title:'NG问题',width:80,align:'center',sortable:true},
					        {field:'engLeader',title:'工程负责人',width:80,align:'center',sortable:true},
					    ]];
			var gridToolBarId = "#gridToolBar";
			var menuId = "menu";
			loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
			
			//加载下拉的表格
			$('#workCardNo').combogrid({
				idField:'workCardNo',
			    textField:'workCardNo',//下拉框文本显示的字段
			    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
			    editable:false,//下拉框文本不可以编辑
				toolbar:'#gridToolBar3',
			    columns:[[	
							{field:'workCardNo',title:'工咭号',width:70,align:'center'},
					    ]],//表格的各个字段
						fitColumns: true,
			    onShowPanel:function(){//显示combogrid下拉框事件
			    	$(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/engineering/dataDistribution/findAllWorkCardNo.action';
					$(this).combogrid('grid').datagrid('load');//重新加载数据，否则下面隐藏方法给表格添加表格含有相同数据的时候，无法开启表格的编辑
			    },
			    onHidePanel:function(){
			    	var workCardNo = $('#workCardNo').combogrid('getValue');
					if (workCardNo != "" && workCardNo != null && workCardNo != undefined){//如何选择了工咭
						/* $("#workCardItem").combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/engineering/dataDistribution/findAllWorkCardSubsidiary.action';
				    	$("#workCardItem").combogrid('grid').datagrid('load',{
				    		workCardNo:workCardNo
				    	}); */
				    	//alert($("select[id^=workCardItem]").length);
			    		$("#item").combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/engineering/dataDistribution/findAllWorkCardSubsidiary.action';
			    		$("#item").combogrid('grid').datagrid('load',{
				    		workCardNo:workCardNo
				    	});
				    	$("select[id^='workCardItem']").each(function(index,domEle){
				    		$(domEle).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/engineering/dataDistribution/findAllWorkCardSubsidiary.action';
				    		$(domEle).combogrid('grid').datagrid('load',{
					    		workCardNo:workCardNo
					    	});
				    	});
					}else{//如果没有选择工咭
						
					}
			    }
			});
			
			//加载下拉的表格
			$("#item").combogrid({
			    idField:'id',//下列表的标识id
			    valueField:'id',
			    textField:'sequence',//下拉框文本显示的字段
			    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
			    multiple:true,//允许多选
			    editable:false,//下拉框文本不可以编辑
			    columns:[[	{field:'ck',checkbox:true},
							{field:'sequence',title:'项次',width:70,align:'center'},
							{field:'projectName',title:'名称',width:100,align:'center'},
							{field:'productModel',title:'规格(外尺寸)',width:100,align:'center'},
							{field:'quantity',title:'数量',width:100,align:'center'}
					    ]],//表格的各个字段
						fitColumns: true,
			    onShowPanel:function(){//显示combogrid下拉框事件
					
			    },
			    onHidePanel:function(){
			    	var g = $("#item").combogrid('grid');
			    	var mySelections = g.datagrid('getSelections');
			    	if (mySelections.length > 0){//代表已选择
			    		$("input[id^='attachment']").each(function(index,domEle){
			    			var select  = $(domEle).parent().parent().parent().children('td:eq(7)').children('select');
			    			if (select.combogrid('grid').datagrid('getSelections').length <= 0){
			    				select.combogrid('setValues',$("#item").combogrid('getValues'));
			    			}
			    		});
			    	}
			    	var selections = new Array();//这里这么做是因为，如果直接用mySelections，则会影响$("#item")，mySelections添加了，则$("#item")也会选择添加的，只是没有显示，当你选择或取消选择时，则会显示出来
			    	for (var i=0;i<mySelections.length;i++){
			    		selections.push(mySelections[i]);
			    	}
			    	$("select[id^='workCardItem']").each(function(index,domEle){
			    		var g2 = $(domEle).combogrid('grid');
			    		var selects = g2.datagrid('getSelections');
			    		for (var i=0;i<selects.length;i++){
			    			var b = true;//标识符
			    			for (var j=0;j<selections.length;j++){
				    			if (selections[j].id == selects[i].id){//有的话，则跳出循环，将b设成true
				    				b = false;
				    				break;	
				    			}
				    		}
			    			if (b){//如果还是true，表示没有，则要添加
			    				selections.push(selects[i]);
			    			}
			    		}
			    	});
			    	var childrens = $("#contextDiv").children('div');
			    	if (childrens.length > selections.length){
			    		for (var i=selections.length;i<childrens.length;i++){
			    			$(childrens.get(i)).remove();
			    		}
			    	}
			    	for (var i=0;i<selections.length;i++){
			    		if (i < childrens.length){
			    			if ($(childrens.get(i)).attr("id") != selections[i].id){
			    				$(childrens.get(i)).attr("id",selections[i].id);
			    				$(childrens.get(i)).html("");
					    		var trueCheckbox = $("<input name='isComplete' type='checkbox' value='true'>");
					    		var falseCheckbox = $("<input name='isComplete' type='checkbox' value='false' checked='checked'>");
					    		var engData = $("<input name='engdata' type='text' style='width: 120px' class='easyui-textbox'>");
					    		var engOweData = $("<input name='engOweData' type='text' style='width: 120px' class='easyui-textbox'>");
					    		var salOweData = $("<input name='salOweData' type='text' style='width: 120px' class='easyui-textbox'>");
					    		var otherInstructions = $("<input name='otherInstructions' type='text' style='width:120px' class='easyui-textbox'>");
					    		var id = $("<input name='id' type='hidden' value='" + selections[i].id + "'>");
					    		$(childrens.get(i)).append("项"+selections[i].sequence+"是否完成：");
					    		$(childrens.get(i)).append(trueCheckbox);
					    		$(childrens.get(i)).append("是");
					    		$(childrens.get(i)).append(falseCheckbox);
					    		$(childrens.get(i)).append("否");
					    		$(childrens.get(i)).append("&nbsp;&nbsp;&nbsp;&nbsp;工程资料：");
					    		$(childrens.get(i)).append(engData);
					    		$(childrens.get(i)).append("&nbsp;&nbsp;工程尚欠：");
					    		$(childrens.get(i)).append(engOweData);
					    		$(childrens.get(i)).append("&nbsp;&nbsp;销售尚欠：");
					    		$(childrens.get(i)).append(salOweData);
					    		$(childrens.get(i)).append("&nbsp;&nbsp;其他说明：");
					    		$(childrens.get(i)).append(otherInstructions);
					    		$(childrens.get(i)).append(id);
					    		$(childrens.get(i)).children(".easyui-textbox").textbox();
					    		$(childrens.get(i)).children("input[type='checkbox']").click(function(){
									var name = $(this).attr("name");
									var value = $(this).val();
									$("input[name='"+name+"']").each(function(index,domEle){
										if (value != $(domEle).val()){
											$(domEle).attr("checked",false);
										}
									});
								});
			    			}
			    		}else{
				    		var div = $("<div id='" + selections[i].id + "' style='padding-top:10px;'><div>");
				    		var trueCheckbox = $("<input name='isComplete' type='checkbox' value='true'>");
				    		var falseCheckbox = $("<input name='isComplete' type='checkbox' value='false' checked='checked'>");
				    		var engData = $("<input name='engdata' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var engOweData = $("<input name='engOweData' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var salOweData = $("<input name='salOweData' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var otherInstructions = $("<input name='otherInstructions' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var id = $("<input name='id' type='hidden' value='" + selections[i].id + "'>");
				    		div.append("项"+selections[i].sequence+"是否完成：");
				    		div.append(trueCheckbox);
				    		div.append("是");
				    		div.append(falseCheckbox);
				    		div.append("否");
				    		div.append("&nbsp;&nbsp;&nbsp;&nbsp;工程资料：");
				    		div.append(engData);
				    		div.append("&nbsp;&nbsp;工程尚欠：");
				    		div.append(engOweData);
				    		div.append("&nbsp;&nbsp;销售尚欠：");
				    		div.append(salOweData);
				    		div.append("&nbsp;&nbsp;其他说明：");
				    		div.append(otherInstructions);
				    		div.append(id);
				    		$("#contextDiv").append(div);
				    		div.children(".easyui-textbox").textbox();
				    		div.children("input[type='checkbox']").click(function(){
								var name = $(this).attr("name");
								var value = $(this).val();
								if ($(this).attr("checked")){
									return false;
								}else{
									$("input[name='"+name+"']").each(function(index,domEle){
										if (value != $(domEle).val()){
											$(domEle).attr("checked",false);
										}else{
											$(domEle).attr("checked",true);
										}
									});
								}
							});
			    		}
			    	}
			    }
			});
			
			//加载下拉的表格
			$("select[name^='workCardItem']").combogrid({
			    idField:'id',//下列表的标识id
			    valueField:'id',
			    textField:'sequence',//下拉框文本显示的字段
			    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
			    multiple:true,//允许多选
			    editable:false,//下拉框文本不可以编辑
			    columns:[[	{field:'ck',checkbox:true},
							{field:'sequence',title:'项次',width:70,align:'center'},
							{field:'projectName',title:'名称',width:100,align:'center'},
					    ]],//表格的各个字段
						fitColumns: true,
			    onShowPanel:function(){//显示combogrid下拉框事件
					
			    },
			    onHidePanel:function(){
			    	var g = $("#item").combogrid('grid');
			    	var mySelections = g.datagrid('getSelections');
			    	var selections = new Array();//这里这么做是因为，如果直接用mySelections，则会影响$("#item")，mySelections添加了，则$("#item")也会选择添加的，只是没有显示，当你选择或取消选择时，则会显示出来
			    	for (var i=0;i<mySelections.length;i++){
			    		selections.push(mySelections[i]);
			    	}
			    	$("select[id^='workCardItem']").each(function(index,domEle){
			    		var g2 = $(domEle).combogrid('grid');
			    		var selects = g2.datagrid('getSelections');
			    		for (var i=0;i<selects.length;i++){
			    			var b = true;//标识符
			    			for (var j=0;j<selections.length;j++){
				    			if (selections[j].id == selects[i].id){//有的话，则跳出循环，将b设成true
				    				b = false;
				    				break;	
				    			}
				    		}
			    			if (b){//如果还是true，表示没有，则要添加
			    				selections.push(selects[i]);
			    			}
			    		}
			    	});
			    	var childrens = $("#contextDiv").children('div');
			    	if (childrens.length > selections.length){
			    		for (var i=selections.length;i<childrens.length;i++){
			    			$(childrens.get(i)).remove();
			    		}
			    	}
			    	for (var i=0;i<selections.length;i++){
			    		if (i < childrens.length){
			    			if ($(childrens.get(i)).attr("id") != selections[i].id){
			    				$(childrens.get(i)).attr("id",selections[i].id);
			    				$(childrens.get(i)).html("");
					    		var trueCheckbox = $("<input name='isComplete' type='checkbox' value='true'>");
					    		var falseCheckbox = $("<input name='isComplete' type='checkbox' value='false' checked='checked'>");
					    		var engData = $("<input name='engdata' type='text' style='width: 120px' class='easyui-textbox'>");
					    		var engOweData = $("<input name='engOweData' type='text' style='width: 120px' class='easyui-textbox'>");
					    		var salOweData = $("<input name='salOweData' type='text' style='width: 120px' class='easyui-textbox'>");
					    		var otherInstructions = $("<input name='otherInstructions' type='text' style='width:120px' class='easyui-textbox'>");
					    		var id = $("<input name='id' type='hidden' value='" + selections[i].id + "'>");
					    		$(childrens.get(i)).append("项"+selections[i].sequence+"是否完成：");
					    		$(childrens.get(i)).append(trueCheckbox);
					    		$(childrens.get(i)).append("是");
					    		$(childrens.get(i)).append(falseCheckbox);
					    		$(childrens.get(i)).append("否");
					    		$(childrens.get(i)).append("&nbsp;&nbsp;&nbsp;&nbsp;工程资料：");
					    		$(childrens.get(i)).append(engData);
					    		$(childrens.get(i)).append("&nbsp;&nbsp;工程尚欠：");
					    		$(childrens.get(i)).append(engOweData);
					    		$(childrens.get(i)).append("&nbsp;&nbsp;销售尚欠：");
					    		$(childrens.get(i)).append(salOweData);
					    		$(childrens.get(i)).append("&nbsp;&nbsp;其他说明：");
					    		$(childrens.get(i)).append(otherInstructions);
					    		$(childrens.get(i)).append(id);
					    		$(childrens.get(i)).children(".easyui-textbox").textbox();
					    		$(childrens.get(i)).children("input[type='checkbox']").click(function(){
									var name = $(this).attr("name");
									var value = $(this).val();
									$("input[name='"+name+"']").each(function(index,domEle){
										if (value != $(domEle).val()){
											$(domEle).attr("checked",false);
										}
									});
								});
			    			}
			    		}else{
				    		var div = $("<div id='" + selections[i].id + "' style='padding-top:10px;'><div>");
				    		var trueCheckbox = $("<input name='isComplete' type='checkbox' value='true'>");
				    		var falseCheckbox = $("<input name='isComplete' type='checkbox' value='false' checked='checked'>");
				    		var engData = $("<input name='engdata' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var engOweData = $("<input name='engOweData' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var salOweData = $("<input name='salOweData' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var otherInstructions = $("<input name='otherInstructions' type='text' style='width: 120px' class='easyui-textbox'>");
				    		var id = $("<input name='id' type='hidden' value='" + selections[i].id + "'>");
				    		div.append("项"+selections[i].sequence+"是否完成：");
				    		div.append(trueCheckbox);
				    		div.append("是");
				    		div.append(falseCheckbox);
				    		div.append("否");
				    		div.append("&nbsp;&nbsp;&nbsp;&nbsp;工程资料：");
				    		div.append(engData);
				    		div.append("&nbsp;&nbsp;工程尚欠：");
				    		div.append(engOweData);
				    		div.append("&nbsp;&nbsp;销售尚欠：");
				    		div.append(salOweData);
				    		div.append("&nbsp;&nbsp;其他说明：");
				    		div.append(otherInstructions);
				    		div.append(id);
				    		$("#contextDiv").append(div);
				    		div.children(".easyui-textbox").textbox();
				    		div.children("input[type='checkbox']").click(function(){
								var name = $(this).attr("name");
								var value = $(this).val();
								if ($(this).attr("checked")){
									return false;
								}else{
									$("input[name='"+name+"']").each(function(index,domEle){
										if (value != $(domEle).val()){
											$(domEle).attr("checked",false);
										}else{
											$(domEle).attr("checked",true);
										}
									});
								}
							});
			    		}
			    	}
			    }
			});
			
			
			//form查询表单的回车事件，回车提交
			$("#workCardNoQueryForm").keyup(function (event){
				if (event.keyCode == 13){
					workCardNoQuery(); 
				}
			});
			
			//checkbox单选
			$("input[type='checkbox'][class!='noRadio']").click(function(){
				var name = $(this).attr("name");
				var value = $(this).val();
				if ($(this).attr("checked")){
					return false;
				}else{
					$("input[name='"+name+"']").each(function(index,domEle){
						if (value != $(domEle).val()){
							$(domEle).attr("checked",false);
						}else{
							$(domEle).attr("checked",true);
						}
					});
				}
			});
			
			//点checkbox上面的td，相当于点击checkbox
			/* $("input[type='checkbox'][name^='department']").parent().click(function(){
				//$(this).children('input').click();
				if ($(this).children('input').attr('checked')){
					alert(1);
					$(this).children('input').attr('checked',false);
				}else{
					alert(2);
					$(this).children('input').attr('checked',true);
				}
			}); */
			
			$("input[type='checkbox'][name^='department']").click(function(){
				var select  = $(this).parent().parent().children('td:eq(7)').children('select');
				var id = select.attr("id");
				var index = id.charAt(id.length - 1);
				var div = $(this).parent().parent().children('td:eq(8)').children('div');
				//表示当前行的checkbox有选中
				if($("input[type='checkbox'][name='"+$(this).attr("name")+"']:checked").length > 0){
					if (select.combogrid('grid').datagrid('getSelections').length <= 0){//表示当前行的下拉选框没有选中，则要进行选中
						select.combogrid('setValues',$("#item").combogrid('getValues'));
					}
					if (div.children('input').length <= 0){//表示当前行没有文件上传框，则要进行添加
						var filebox = $('<input class="easyui-filebox" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'请上传附件\',accept:\'application/pdf\',buttonText:\'选择\',validType:\'checkPDF\'">');
						div.append(filebox);
						filebox.attr("id","attachment"+index);
						filebox.attr("name","attachment"+index);
						filebox.filebox();
					}
				}else{//当前行的checkbox没有选中，则清除
					select.combogrid('clear');
					div.html("");
				}
			});
			
			
			$("input[id^='attachment']").each(function(index,domEle){
				$(domEle).filebox({
					onChange:function(newValue, oldValue){
						var select  = $(this).parent().parent().children('td:eq(7)').children('select');
						if (newValue != ""){
							if (select.combogrid('grid').datagrid('getSelections').length <= 0){
								select.combogrid('setValues',$("#item").combogrid('getValues'));
							}
						}else{
							select.combogrid('clear');
						}
					}
				});
			});
	  });
	  
	  function workCardNoQuery(){
		  $("#workCardNo").combogrid('grid').datagrid('load',$("#workCardNoQueryForm").serializeObject());//重新加载数据
	  }
	  
	  
	//打开用户新增窗口
  	function add(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
		  		$("#id").val("");
				//清空下拉选框
				$("#item").combogrid('grid').datagrid('options').url="";
				$("#item").combogrid('grid').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
				$("select[id^='workCardItem']").each(function(index,domEle){
					$(domEle).combogrid('grid').datagrid('options').url="";
					$(domEle).combogrid('grid').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
				});
				//清空文件框
				$("div[id^='file']").html("");
				
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:"新增工咭资料分发记录登记表"//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
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
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			
			
		</div>
		<div>
			<form id="queryForm">
				工咭号：<input id="workCardNo_query" type="text" name="workCardNo" class="easyui-textbox" style="width: 70px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
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
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 940px;height: 620px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<div style="padding-top: 10px;padding-bottom: 10px;">
	  			工咭号：<select id="workCardNo" name="workCardNo" style="width: 25%;"></select>
	  			项次：<select id="item" name="item" style="width: 60%;"></select>
  			</div>
  			<div style="padding-bottom: 10px;">
				第&nbsp;<input id="sequence" name="sequence" type="text" class="easyui-textbox" style="width: 38px;" data-options="readonly:true">&nbsp;次
				填表人：<input id="preparer" type="text" name="preparer" style="width: 70px;" class="easyui-textbox" data-options="readonly:true" value="${user.username}">
				填表时间：<input id="prepareTime" name="prepareTime" type="text" class="easyui-textbox" style="width: 130px;" data-options="readonly:true">
			</div>
			<table cellspacing="0" align="center" width="900px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
				<tr height="14px">
					<td colspan="1" rowspan="2" style="width: 20px;">
						序号
					</td>
					<td colspan="1" rowspan="2" style="width: 150px;">
						资料名称
					</td>
					<td colspan="5" rowspan="1" style="width: 150px;">
						分发部门
					</td>
					<td colspan="1" rowspan="2" style="width: 282px;">
						项次<br>(当资料不是上面选择的全部项次时，请在这里单独选择项次)
					</td>
					<td colspan="1" rowspan="2" style="width: 282px;">
						附件
					</td>					
				</tr>
				<tr height="14px">
					<td>
						生产部
					</td>
					<td>
						仓务部
					</td>
					<td>
						采购部
					</td>
					<td>
						品管部
					</td>
					<td>
						PMC
					</td>
				</tr>
				<tr height="30px">
					<td>
						1
					</td>
					<td>
						工咭(含配件清单)
					</td>
					<td>
						<input type="checkbox" name="department1" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department1" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department1" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department1" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department1" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem1" name="workCardItem1" style="width: 100%;height: 27px;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file1">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						2
					</td>
					<td>
						工咭更改单
					</td>
					<td>
						<input type="checkbox" name="department2" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department2" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department2" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department2" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department2" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem2" name="workCardItem2" style="width: 100%;height: 27px;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file2">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						3
					</td>
					<td>
						其他部门资料转发
					</td>
					<td>
						<input type="checkbox" name="department3" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department3" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department3" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department3" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department3" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem3" name="workCardItem3" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file3">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						4
					</td>
					<td>
						BOM
					</td>
					<td>
						<input type="checkbox" name="department4" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department4" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department4" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department4" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department4" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem4" name="workCardItem4" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file4">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						5
					</td>
					<td>
						裁剪单/机加件清单
					</td>
					<td>
						<input type="checkbox" name="department5" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department5" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department5" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department5" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department5" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem5" name="workCardItem5" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file5">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						6
					</td>
					<td>
						<span style="font-size: 11px;">批核图/客户原图/效果图</span>
					</td>
					<td>
						<input type="checkbox" name="department6" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department6" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department6" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department6" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department6" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem6" name="workCardItem6" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file6">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						7
					</td>
					<td>
						施工图
					</td>
					<td>
						<input type="checkbox" name="department7" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department7" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department7" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department7" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department7" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem7" name="workCardItem7" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file7">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						8
					</td>
					<td>
						外发加工图
					</td>
					<td>
						<input type="checkbox" name="department8" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department8" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department8" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department8" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department8" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem8" name="workCardItem8" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file8">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						9
					</td>
					<td>
						<span style="font-size: 11px;">施工更改单/工作联络单</span>
					</td>
					<td>
						<input type="checkbox" name="department9" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department9" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department9" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department9" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department9" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem9" name="workCardItem9" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file9">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						10
					</td>
					<td>
						<span style="font-size: 10px;">产品评审、验证、交付前确认表</span>
					</td>
					<td>
						<input type="checkbox" name="department10" class="noRadio" value="生产部">
					</td>
					<td>
						<input type="checkbox" name="department10" class="noRadio" value="仓务部">
					</td>
					<td>
						<input type="checkbox" name="department10" class="noRadio" value="采购部">
					</td>
					<td>
						<input type="checkbox" name="department10" class="noRadio" value="品管部">
					</td>
					<td>
						<input type="checkbox" name="department10" class="noRadio" value="PMC">
					</td>
					<td>
						<select id="workCardItem10" name="workCardItem10" style="width: 100%;height: 100%;"></select>
					</td>
					<td style="text-align: left;">
						<div id="file10">
						</div>
					</td>
				</tr>
				<tr height="30px">
					<td>
						11
					</td>
					<td colspan="9">
						<div style="float: left;width: 50%;">
							电子文档移交生产：<input type="checkbox" name="docTransferPro" value="true">是<input type="checkbox" name="docTransferPro" value="false" checked="checked">否
						</div>
						<div style="float: left;width: 50%;">
							K3 BOM下达通知：<input type="checkbox" name="bomGiveNotice" value="true">是<input type="checkbox" name="giveNotice" value="false" checked="checked">否
						</div>
					</td>
				</tr>
			</table>
			
			<div id="contextDiv" style="padding-bottom: 10px;">
				
			</div>
			
			<table>
				<tr>
					<td style="text-align: right;">
						<span style="font-size: 11px">工程审核人：</span>
					</td>
					<td>
						<input id="engSigner" type="text" name="engSigner" style="width: 58px;" class="easyui-textbox" data-options="readonly:true">
					</td>
					<td style="text-align: right;">
						时间：
					</td>
					<td>
						<input id="engSignerDateTime" name="engSignerDateTime" type="text" class="easyui-textbox" style="width: 128px;" data-options="readonly:true">
					</td>
					<td style="text-align: right;">
						生产签收：
					</td>
					<td>
						<input id="proSigner" name="proSigner" type="text" style="width: 58px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						时间：
					</td>
					<td>
						<input id="proSignerDateTime" name="proSignerDateTime" type="text" style="width: 128px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						仓库签收：
					</td>
					<td>
						<input id="warSigner" name="warSigner" type="text" style="width: 58px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						时间：
					</td>
					<td>
						<input id="warSignerDateTime" name="warSignerDateTime" type="text" style="width: 128px;" class="easyui-textbox">
					</td>
				</tr>
				<tr>
					<td style="text-align: right;">
						采购签收：
					</td>
					<td>
						<input id="purSigner" name="purSigner" type="text" style="width: 58px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						时间：
					</td>
					<td>
						<input id="purSignerDateTime" name="purSignerDateTime" type="text" style="width: 128px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						品管签收：
					</td>
					<td>
						<input id="qcSigner" name="qcSigner" type="text" style="width: 58px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						时间：
					</td>
					<td>
						<input id="qcSignerDateTime" name="qcSignerDateTime" type="text" style="width: 128px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						PMC签收：
					</td>
					<td>
						<input id="pmcSigner" name="pmcSigner" type="text" style="width: 58px;" class="easyui-textbox">
					</td>
					<td style="text-align: right;">
						时间：
					</td>
					<td>
						<input id="pmcSignerDateTime" name="pmcSignerDateTime" type="text" style="width: 128px;" class="easyui-textbox">
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
	
	<div id="gridToolBar3" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<form id="workCardNoQueryForm">
				工咭号：<input id="workCardNo_query" type="text" name="workCardNo" class="easyui-textbox" style="width: 70px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="workCardNoQuery()">查询</a>
			</form>
		</div>
	</div>
	
</body>    
</html>

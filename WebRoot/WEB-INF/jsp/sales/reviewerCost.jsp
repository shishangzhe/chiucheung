<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>项目信息评审-成本核算</title>
	<jsp:include page="/common.jsp"></jsp:include>
  </head>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		//当浏览器小于这个窗口时，将该窗口设置成浏览器大小
		if ($(document.body).width()<$("#dialog1").width()){
			$("#dialog1").dialog({
				closed:$("#dialog1").dialog("options").closed,
				width: $(document.body).width()
			});
		}else{
			$("#dialog1").dialog({
				closed:$("#dialog1").dialog("options").closed,
				width: 1000
			});
		}
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width()-14)/2,
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
		$('#dg').treegrid({
			title:'项目信息评审表-成本核算',
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
		    url:'${pageContext.request.contextPath}/sales/reviewerCost/findAllSalReviewerList.action',    
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
							{field:'quotationNo',title:'Q编号',width:120,align:'center',sortable:true},
	                      ]],
		    columns:[[	
						{field:'infoRecordNumber',title:'次数',width:40,align:'center',rowspan:2,sortable:true},
						{field:'createTime',title:'评审日期',width:80,align:'center',rowspan:2,sortable:true},
				        {field:'projectLeader',title:'项目负责人',width:80,align:'center',rowspan:2,sortable:true},
						{field:'workCardNo',title:'工咭号',width:100,align:'center',rowspan:2,sortable:true},
				        {field:'sequence',title:'项次',width:30,align:'center',rowspan:2},
				        {field:'productName',title:'项目名称',width:120,align:'center',rowspan:2},
				        {field:'productModel',title:'产品型号',width:200,align:'center',rowspan:2},
				        {field:'quantity',title:'数<br>量',width:25,align:'center',rowspan:2},
				        {field:'unit',title:'单<br>位',width:20,align:'center',rowspan:2},
				        {field:'engLeader',title:'负责人',width:60,align:'center',rowspan:2},
				        {title:'工程周期',colspan:4},
				        {title:'生产周期',colspan:3},
				        {field:'specialMaterial',title:'特别物料',width:100,align:'center',rowspan:2,sortable:true},
				        {field:'isAttached',title:'是否有附件',width:80,align:'center',rowspan:2,sortable:true,formatter: function(value,row,index){
				        																									if (value != null){
					        																									if (value){
					        																										return '是';
					        																									}else{
					        																										return '否';
					        																									}
				        																									}
				        																								}},
				        {field:'salPreparer',title:'制表人',width:70,align:'center',rowspan:2,sortable:true},
				        {field:'processInstanceId',title:'任务类型',width:70,align:'center',rowspan:2}
				    ],[
				       	{field:'engActualNeedTime',title:'工程实际时间',width:100,align:'center'},
						{field:'engExpectedStartTime',title:'预计开工日期',width:90,align:'center'},
						{field:'engExpectedShortestCompletionTime',title:'最短(天)',width:80,align:'center'},
						{field:'engExpectedLongestCompletionTime',title:'最长(天)',width:80,align:'center'},
						{field:'proExpectedStartTime',title:'预计开工日期',width:90,align:'center'},
						{field:'proExpectedShortestCompletionTime',title:'最短(天)',width:70,align:'center'},
						{field:'proExpectedLongestCompletionTime',title:'最长(天)',width:70,align:'center'}
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
		    	var url = '${pageContext.request.contextPath}/sales/reviewerCost/findAllSalReviewerSubsidiaryListBySalReviewerId.action'; 
                $(this).treegrid("options").url = url;  
                return true; 
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/sales/reviewerCost/findAllSalReviewerList.action'; 
                $(this).treegrid("options").url = url;  
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/sales/reviewerCost/findAllSalReviewerList.action'; 
                $(this).treegrid("options").url = url;  
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/sales/reviewerCost/findAllSalReviewerList.action'; 
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
		
		$("#dg2").datagrid({
			title:'关联文件表',
			fit:false,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			singleSelect:true,//单选
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:[[
						{field:'docId',title:'文件id',hidden:true,width:520,align:'center'},
			        	{field:'filename',title:'文件名',width:520,align:'center'},
			        	{field:'extension',title:'类型',width:100,align:'center'},
				    ]],//表格的各个字段
		    toolbar: '#gridToolBar2',
		    onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
                $("#menu2").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },
		});
		
		$("#dg3").datagrid({
			title:'关联文件表',
			fit:false,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			singleSelect:true,//单选
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:[[
						{field:'docId',title:'文件id',hidden:true,width:520,align:'center'},
			        	{field:'filename',title:'文件名',width:520,align:'center'},
			        	{field:'extension',title:'类型',width:100,align:'center'},
				    ]],//表格的各个字段
		    toolbar: '#gridToolBar3',
		    onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
                $("#menu3").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },
		});
		
		//把checkbox变成radiao来使用
		$(".radio").click(function(){
			var name = $(this).attr("name");
			var value = $(this).val();
			$("input[name='"+name+"']").each(function(index,domEle){
				if (value != $(domEle).val()){
					$(domEle).prop("checked",false);
				}
			});
			$(this).prop("checked",true);
		});
		
		
		//查询的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
	});
	//打开新增项目信息评审表的dialog
	function add(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
				$("#specialProcessing").textbox('disable');
				$("input[name='isSpecialProcessing'][value='false']")[0].click();
				$('#dg2').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
				$("#firstTd").attr("rowspan",7);//将添加的表格重置
				$(".add").each(function (index, domEle){
					if (index>0){
						$(this).remove();
					}
				});
				$("#engRemark").textbox('setValue','1.如该项目客户要求交期紧迫，工程可以在此提出“XX”项目是否可以延迟等要求。\r\n2.如属新产品交期要考虑：是否要打样验证、不打样则要考虑验证后修改时间等。');
				$("#e6Form").form('reset');//重置表单数据
				$("#username").textbox('disableValidation');
				$("#password").textbox('disableValidation');
				$("#E6").textbox('disableValidation');
				$("#id").val("");
		  		$("#processInstanceId").val("");
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增项目信息评审表'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
	}
	
	//打开修改项目评审表的dialog
	function edit(){
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
		if (selected != null){
			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/sales/reviewerCost/findSalReviewerByIdForEdit.action?id='+id,
				async: false,//同步请求
				cache: false,//不缓存此页面
				success:function(data){
					if (data.success){
						if (data.datas.isEdit){
							$("#form1").form('reset');//重置表单数据
							$("#e6Form").form('reset');//重置表单数据
							$("#username").textbox('disableValidation');
							$("#password").textbox('disableValidation');
							$("#E6").textbox('disableValidation');
							$('#dg2').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
							$("#firstTd").attr("rowspan",7);//将添加的表格重置
							$(".add").each(function (index, domEle){
								if (index>0){
									$(this).remove();
								}
							});
							$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
							
							$("#dialog1").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:'修改项目信息评审表'//该dialog的标题
							});
							$("#form1").form('load',data.datas.reviewer);
							
							//checkbox的选中，因为存储是将多个同name的用，号隔开，以varchar方式存储
							
							//客户需求项目 
							if (data.datas.reviewer.project.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.project.split(',').length;i++){
									$("input[name='project'][value=" +"'"+ data.datas.reviewer.project.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//包装
							if (data.datas.reviewer.packaging.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.packaging.split(',').length;i++){
									$("input[name='packaging'][value=" +"'"+ data.datas.reviewer.packaging.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//送货方式
							if (data.datas.reviewer.delivery.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.delivery.split(',').length;i++){
									$("input[name='delivery'][value=" +"'"+ data.datas.reviewer.delivery.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//抄送相关部门
							if (data.datas.reviewer.aboutDepartment.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.aboutDepartment.split(',').length;i++){
									$("input[name='aboutDepartment'][value=" +"'"+ data.datas.reviewer.aboutDepartment.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//特别加工手段
							if (data.datas.reviewer.isSpecialProcessing){
								$("#specialProcessing").textbox('enable');
							}else{
								$("#specialProcessing").textbox('disable');
							}
							
							//加载工程部那的多条记录
							for(var i=0;i<data.datas.reviewerSubsidiaries.length;i++){
								if (i>0){
									addTable();
								}
								$("#id"+i).val(data.datas.reviewerSubsidiaries[i].id);
								$("#sequence"+i).val(data.datas.reviewerSubsidiaries[i].sequence);
								$("#productName"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productName);
								$("#unit"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].unit);
								$("#productModel"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productModel);
								$("#quantity"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].quantity);
								$("#category"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].category);
								$("#engLeader"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engLeader);
								$("#engActualNeedTime"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engActualNeedTime);
								$("#engExpectedStartTime"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedStartTime);
								$("#engExpectedShortestCompletionTime"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedShortestCompletionTime);
								$("#engExpectedLongestCompletionTime"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedLongestCompletionTime);
							}
							//加载文件列表
							if (data.datas.reviewerFiles != undefined){
								for (var i=0;i<data.datas.reviewerFiles.length;i++){
									$("#dg2").datagrid('appendRow',data.datas.reviewerFiles[i]);
								}
							}
						}else{
							//则是查看
							alert(data.datas.doNotEditMessage);
							$("#formView1").form('reset');//重置表单数据
							$("#e6FormView").form('reset');//重置表单数据
							$("#usernameView").textbox('disableValidation');
							$("#passwordView").textbox('disableValidation');
							$('#dg3').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
							$("#firstTdView").attr("rowspan",7);//将添加的表格重置
							$(".addView").each(function (index, domEle){
								if (index>0){
									$(this).remove();
								}
							});
							
							$("#viewDialog").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:'查看项目信息评审表'//该dialog的标题
							});
							
							data.datas.reviewer.projectView = data.datas.reviewer.project;
							data.datas.reviewer.packagingView = data.datas.reviewer.packaging;
							data.datas.reviewer.deliveryView = data.datas.reviewer.delivery;
							data.datas.reviewer.aboutDepartmentView = data.datas.reviewer.aboutDepartment;
							
							$("#formView1").form('load',data.datas.reviewer);
							
							//checkbox的选中，因为存储是将多个同name的用，号隔开，以varchar方式存储
							
							//客户需求项目 
							if (data.datas.reviewer.project.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.project.split(',').length;i++){
									$("input[name='projectView'][value=" +"'"+ data.datas.reviewer.project.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//包装
							if (data.datas.reviewer.packaging.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.packaging.split(',').length;i++){
									$("input[name='packagingView'][value=" +"'"+ data.datas.reviewer.packaging.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//送货方式
							if (data.datas.reviewer.delivery.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.delivery.split(',').length;i++){
									$("input[name='deliveryView'][value=" +"'"+ data.datas.reviewer.delivery.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//抄送相关部门
							if (data.datas.reviewer.aboutDepartment.split(',').length > 1){
								for(var i=0;i<data.datas.reviewer.aboutDepartment.split(',').length;i++){
									$("input[name='aboutDepartmentView'][value=" +"'"+ data.datas.reviewer.aboutDepartment.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//特别加工手段
							if (data.datas.reviewer.isSpecialProcessing){
								$("#specialProcessingView").textbox('enable');
							}else{
								$("#specialProcessingView").textbox('disable');
							}
							
							//加载工程部那的多条记录
							for(var i=0;i<data.datas.reviewerSubsidiaries.length;i++){
								if (i>0){
									addTableForView();
								}
								$("#idView"+i).val(data.datas.reviewerSubsidiaries[i].id);
								$("#sequenceView"+i).val(data.datas.reviewerSubsidiaries[i].sequence);
								$("#productNameView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productName);
								$("#unitView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].unit);
								$("#productModelView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productModel);
								$("#quantityView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].quantity);
								$("#categoryView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].category);
								$("#engLeaderView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engLeader);
								$("#engActualNeedTimeView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engActualNeedTime);
								$("#engExpectedStartTimeView"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedStartTime);
								$("#engExpectedShortestCompletionTimeView"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedShortestCompletionTime);
								$("#engExpectedLongestCompletionTimeView"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedLongestCompletionTime);
							}
							//加载文件列表
							if (data.datas.reviewerFiles != undefined){
								for (var i=0;i<data.datas.reviewerFiles.length;i++){
									$("#dg3").datagrid('appendRow',data.datas.reviewerFiles[i]);
								}
							}
						}
					}else{
						showErrorMessager("修改失败", data.message);
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	
	//打开查看项目评审表的dialog
	function view(){
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
		if (selected != null){
			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/sales/reviewerCost/findSalReviewerByIdForView.action?id='+id,
				async: false,//同步请求
				cache: false,//不缓存此页面
				success:function(data){
					if (data.success){
						$("#formView1").form('reset');//重置表单数据
						$("#e6FormView").form('reset');//重置表单数据
						$("#usernameView").textbox('disableValidation');
						$("#passwordView").textbox('disableValidation');
						$('#dg3').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
						$("#firstTdView").attr("rowspan",7);//将添加的表格重置
						$(".addView").each(function (index, domEle){
							if (index>0){
								$(this).remove();
							}
						});
						$("#flag").val('view');//新增和修改用的是同一个dialog，用于区分是新增还是修改
						
						$("#viewDialog").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:'查看项目信息评审表'//该dialog的标题
						});
						
						data.datas.reviewer.projectView = data.datas.reviewer.project;
						data.datas.reviewer.packagingView = data.datas.reviewer.packaging;
						data.datas.reviewer.deliveryView = data.datas.reviewer.delivery;
						data.datas.reviewer.aboutDepartmentView = data.datas.reviewer.aboutDepartment;
						
						$("#formView1").form('load',data.datas.reviewer);
						
						//checkbox的选中，因为存储是将多个同name的用，号隔开，以varchar方式存储
						
						//客户需求项目 
						if (data.datas.reviewer.project.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.project.split(',').length;i++){
								$("input[name='projectView'][value=" +"'"+ data.datas.reviewer.project.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//包装
						if (data.datas.reviewer.packaging.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.packaging.split(',').length;i++){
								$("input[name='packagingView'][value=" +"'"+ data.datas.reviewer.packaging.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//送货方式
						if (data.datas.reviewer.delivery.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.delivery.split(',').length;i++){
								$("input[name='deliveryView'][value=" +"'"+ data.datas.reviewer.delivery.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//抄送相关部门
						if (data.datas.reviewer.aboutDepartment.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.aboutDepartment.split(',').length;i++){
								$("input[name='aboutDepartmentView'][value=" +"'"+ data.datas.reviewer.aboutDepartment.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//特别加工手段
						if (data.datas.reviewer.isSpecialProcessing){
							$("#specialProcessingView").textbox('enable');
						}else{
							$("#specialProcessingView").textbox('disable');
						}
						
						//加载工程部那的多条记录
						for(var i=0;i<data.datas.reviewerSubsidiaries.length;i++){
							if (i>0){
								addTableForView();
							}
							$("#idView"+i).val(data.datas.reviewerSubsidiaries[i].id);
							$("#sequenceView"+i).val(data.datas.reviewerSubsidiaries[i].sequence);
							$("#productNameView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productName);
							$("#unitView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].unit);
							$("#productModelView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productModel);
							$("#quantityView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].quantity);
							$("#categoryView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].category);
							$("#engLeaderView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engLeader);
							$("#engActualNeedTimeView"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engActualNeedTime);
							$("#engExpectedStartTimeView"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedStartTime);
							$("#engExpectedShortestCompletionTimeView"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedShortestCompletionTime);
							$("#engExpectedLongestCompletionTimeView"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedLongestCompletionTime);
						}
						//加载文件列表
						if (data.datas.reviewerFiles != undefined){
							for (var i=0;i<data.datas.reviewerFiles.length;i++){
								$("#dg3").datagrid('appendRow',data.datas.reviewerFiles[i]);
							}
						}
					}else{
						showErrorMessager("查看失败", data.message);
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	
	//打开修改项目评审表的dialog
	function copyData(){
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
		if (selected != null){
			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/sales/reviewerCost/findSalReviewerByIdForCopy.action?id='+id,
				async: false,//同步请求
				cache: false,//不缓存此页面
				success:function(data){
					if (data.success){
						$("#form1").form('reset');//重置表单数据
						$("#e6Form").form('reset');//重置表单数据
						$("#username").textbox('disableValidation');
						$("#password").textbox('disableValidation');
						$("#E6").textbox('disableValidation');
						$('#dg2').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
						$("#firstTd").attr("rowspan",7);//将添加的表格重置
						$(".add").each(function (index, domEle){
							if (index>0){
								$(this).remove();
							}
						});
						$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
						
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:'复制项目信息评审表'//该dialog的标题
						});
						$("#form1").form('load',data.datas.reviewer);
						
						$("#infoRecordNumber").numberbox('setValue',data.datas.reviewer.infoRecordNumber*1+1);
						
						//checkbox的选中，因为存储是将多个同name的用，号隔开，以varchar方式存储
						
						//客户需求项目 
						if (data.datas.reviewer.project.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.project.split(',').length;i++){
								$("input[name='project'][value=" +"'"+ data.datas.reviewer.project.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//包装
						if (data.datas.reviewer.packaging.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.packaging.split(',').length;i++){
								$("input[name='packaging'][value=" +"'"+ data.datas.reviewer.packaging.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//送货方式
						if (data.datas.reviewer.delivery.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.delivery.split(',').length;i++){
								$("input[name='delivery'][value=" +"'"+ data.datas.reviewer.delivery.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//抄送相关部门
						if (data.datas.reviewer.aboutDepartment.split(',').length > 1){
							for(var i=0;i<data.datas.reviewer.aboutDepartment.split(',').length;i++){
								$("input[name='aboutDepartment'][value=" +"'"+ data.datas.reviewer.aboutDepartment.split(',')[i] + "'" + "]")[0].checked = true;
							}
						}
						//特别加工手段
						if (data.datas.reviewer.isSpecialProcessing){
							$("#specialProcessing").textbox('enable');
						}else{
							$("#specialProcessing").textbox('disable');
						}
						
						//加载工程部那的多条记录
						for(var i=0;i<data.datas.reviewerSubsidiaries.length;i++){
							if (i>0){
								addTable();
							}
							$("#id"+i).val(data.datas.reviewerSubsidiaries[i].id);
							$("#sequence"+i).val(data.datas.reviewerSubsidiaries[i].sequence);
							$("#productName"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productName);
							$("#unit"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].unit);
							$("#productModel"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].productModel);
							$("#quantity"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].quantity);
							$("#category"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].category);
							$("#engLeader"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engLeader);
							$("#engActualNeedTime"+i).textbox('setValue',data.datas.reviewerSubsidiaries[i].engActualNeedTime);
							$("#engExpectedStartTime"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedStartTime);
							$("#engExpectedShortestCompletionTime"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedShortestCompletionTime);
							$("#engExpectedLongestCompletionTime"+i).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedLongestCompletionTime);
						}
						//加载文件列表
						if (data.datas.reviewerFiles != undefined){
							for (var i=0;i<data.row.reviewerFiles.length;i++){
								$("#dg2").datagrid('appendRow',data.datas.reviewerFiles[i]);
							}
						}
					}else{
						showErrorMessager("复制失败", data.message);
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	//保存项目信息评审表
	function save(){
		if ($("#form1").form('validate')){//判断 验证是否通过
			var url = "${pageContext.request.contextPath}/sales/reviewerCost/";
			var flag = $("#flag").val();//获取标识符，
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveReviewer.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateReviewer.action";
			}
			var params = "";
			var datas = $("#dg2").datagrid("getData");
			for (var i=0;i<datas.rows.length;i++){
				params = params
							+ 'reviewerFiles[' + i + '].docId=' + datas.rows[i].docId
							+ "&" + 'reviewerFiles[' + i + '].filename=' + datas.rows[i].filename
							+ "&" + 'reviewerFiles[' + i + '].extension=' + datas.rows[i].extension
							+ "&";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: params + $( "#form1" ).serialize(),
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						showMessager("提示","保存成功");
						$("#dialog1").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg").treegrid('reload');//重新加载数据，保持在当前页
					}else{
						showErrorMessager("保存失败", data.message);
					}
				}
			});
		}
	}
	
	//删除项目信息评审表
	function removeData(){
		var selected = $("#dg").datagrid("getSelected");
  		if (selected != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
					var id = "";
					var processInstanceId = "";
					while (id == ""){
						if (selected._parentId == undefined){//根节点
							id = selected.id;
							processInstanceId = selected.processInstanceId;
						}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
							selected = $('#dg').treegrid('getParent',selected.id);
						}
					}
					var processInstanceIdInput = $(processInstanceId);
					if(processInstanceId == ""){
			  			$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/sales/reviewerCost/deleteSalReviewerById.action",//ajax请求的url
							data: {id:id},//传的参数,序列化表单
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data.success){
									showMessager("提示","删除成功");
									$("#dg").treegrid('reload');//重新加载数据，保持在当前页
									$("#dg").treegrid('clearSelections');//清除所有选择的行
								}else{
									showErrorMessager("删除失败", data.message);
								}
							}
						});
					}else if(processInstanceIdInput.text() == "审核中" || processInstanceIdInput.text() == "审核完成"){
						showErrorMessager("删除失败", '已开启审核，不能删除');
					}
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
		}
	}
	
	//导出word
	function exportWord(){
		var selected = $("#dg").datagrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行导出");
		}else{
			window.open('${pageContext.request.contextPath}/sales/reviewerCost/exportWord.action?id=' + selected.id);
		}
	}
	
	function reload(){
		$("#dg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	function query(){
		$("#dg").treegrid('load',$("#queryForm").serializeObject());//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	
	
	
	
	//启动和禁用文本框
	function showHiddenTextBox(obj){
		if($(obj).val() == 'true'){
			$(obj).parent().children("input[type='text']").textbox('enable');
		}else{
			$(obj).parent().children("input[type='text']").textbox('disable');
			$(obj).parent().children("input[type='text']").textbox('setText',"");
		}
	}
	
	//添加一行表格
	function addTable(){
		var tempRow = $(".add").length;
		$("#firstTd").attr("rowspan",$("#firstTd").attr("rowspan")*1+1);
		var tr = $('<tr class="add" style="height: 30px"></tr>');
		
		var td1 = $('<td colspan="1" style="text-align: center;width: 50px"></td>');
		var td1Id = $('<input id="id' +tempRow + '" type="hidden" name="reviewerSubsidiaries[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="sequence' +tempRow + '" type="hidden" name="reviewerSubsidiaries[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		td1.append(td1Id);
		td1.append(td1Sequence);
		td1.append(tempRow+1);
		tr.append(td1);
		
		var td2 = $('<td colspan="2" style="text-align: center;"></td>');
		var td2Content = $('<input id="productName' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].productName" style="width: 140px;height: 27px" data-options="required:true,missingMessage:\'货品名称不能为空\'">');
		td2.append(td2Content);
		td2Content.textbox();
		tr.append(td2);
		
		var td3 = $('<td colspan="2" style="text-align: center;"></td>');
		var td3Content = $('<input id="productModel' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].productModel" style="width: 205px;height: 27px" data-options="required:true,missingMessage:\'产品型号不能为空\'">');
		td3.append(td3Content);
		td3Content.textbox();
		tr.append(td3);
		
		var td4 = $('<td colspan="1" style="text-align: center;"></td>');
		var td4Content = $('<input id="quantity' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].quantity" style="width: 35px;height: 27px" data-options="required:true,missingMessage:\'数量不能为空\'">');
		td4.append(td4Content);
		td4Content.numberbox();
		tr.append(td4);
		
		var td5 = $('<td colspan="1" style="text-align: center;"></td>');
		var td5Content = $('<input id="unit' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].unit" style="width: 26px;height: 27px" data-options="required:true,missingMessage:\'单位不能为空\'">');
		td5.append(td5Content);
		td5Content.textbox();
		tr.append(td5);
		
		var td6 = $('<td colspan="1" style="text-align: center;"></td>');
		var td6Content = $('<input id="category' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].category" style="width: 36px;height: 27px" data-options="readonly:true">');
		td6.append(td6Content);
		td6Content.textbox();
		tr.append(td6);
		
		var td7 = $('<td colspan="1" style="text-align: center;"></td>');
		var td7Content = $('<input id="engLeader' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engLeader" style="width: 81px;height: 27px" data-options="readonly:true">');
		td7.append(td7Content);
		td7Content.textbox();
		tr.append(td7);
		
		
		var td8 = $('<td colspan="2" style="text-align: center;"></td>');
		var td8Content = $('<input id="engActualNeedTime' +tempRow + '" name="reviewerSubsidiaries[' + tempRow + '].engActualNeedTime" type="text" style="width: 54px;height: 27px" data-options="readonly:true">');
		td8.append(td8Content);
		td8Content.textbox();
		tr.append(td8);
		
		var td9 = $('<td colspan="2" style="text-align: center;"></td>');
		var td9Content = $('<input id="engExpectedStartTime' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedStartTime" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">');
		td9.append(td9Content);
		td9Content.datebox();
		tr.append(td9);
		
		var td10 = $('<td colspan="2" style="text-align: center;"></td>');
		var td10Content = $('<input id="engExpectedShortestCompletionTime' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedShortestCompletionTime" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">');
		td10.append(td10Content);
		td10Content.datebox();
		tr.append(td10);
		
		var td11 = $('<td colspan="2" style="text-align: center;"></td>');
		var td11Content = $('<input id="engExpectedLongestCompletionTime' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedLongestCompletionTime" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">');
		td11.append(td11Content);
		td11Content.datebox();
		tr.append(td11);
		$(".add").last().after(tr);
		
		//改变datebox控件的输入框的宽度
		td9Content.next().children('input').first().css('width',td9Content.next().width()-22);
		td10Content.next().children('input').first().css('width',td10Content.next().width()-22);
		td11Content.next().children('input').first().css('width',td11Content.next().width()-22);
	}
	
	//添加一行表格
	function addTableForView(){
		var tempRow = $(".addView").length;
		$("#firstTdView").attr("rowspan",$("#firstTdView").attr("rowspan")*1+1);
		var tr = $('<tr class="addView" style="height: 30px"></tr>');
		
		var td1 = $('<td colspan="1" style="text-align: center;width: 50px"></td>');
		var td1Id = $('<input id="idView' +tempRow + '" type="hidden" name="reviewerSubsidiaries[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="sequenceView' +tempRow + '" type="hidden" name="reviewerSubsidiaries[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		td1.append(td1Id);
		td1.append(td1Sequence);
		td1.append(tempRow+1);
		tr.append(td1);
		
		var td2 = $('<td colspan="2" style="text-align: center;"></td>');
		var td2Content = $('<input id="productNameView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].productName" style="width: 140px;height: 27px" data-options="readonly:true">');
		td2.append(td2Content);
		td2Content.textbox();
		tr.append(td2);
		
		var td3 = $('<td colspan="2" style="text-align: center;"></td>');
		var td3Content = $('<input id="productModelView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].productModel" style="width: 205px;height: 27px" data-options="readonly:true">');
		td3.append(td3Content);
		td3Content.textbox();
		tr.append(td3);
		
		var td4 = $('<td colspan="1" style="text-align: center;"></td>');
		var td4Content = $('<input id="quantityView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].quantity" style="width: 35px;height: 27px" data-options="readonly:true">');
		td4.append(td4Content);
		td4Content.numberbox();
		tr.append(td4);
		
		var td5 = $('<td colspan="1" style="text-align: center;"></td>');
		var td5Content = $('<input id="unitView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].unit" style="width: 26px;height: 27px" data-options="readonly:true">');
		td5.append(td5Content);
		td5Content.textbox();
		tr.append(td5);
		
		var td6 = $('<td colspan="1" style="text-align: center;"></td>');
		var td6Content = $('<input id="categoryView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].category" style="width: 36px;height: 27px" data-options="readonly:true">');
		td6.append(td6Content);
		td6Content.textbox();
		tr.append(td6);
		
		var td7 = $('<td colspan="1" style="text-align: center;"></td>');
		var td7Content = $('<input id="engLeaderView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engLeader" style="width: 81px;height: 27px" data-options="readonly:true">');
		td7.append(td7Content);
		td7Content.textbox();
		tr.append(td7);
		
		
		var td8 = $('<td colspan="2" style="text-align: center;"></td>');
		var td8Content = $('<input id="engActualNeedTimeView' +tempRow + '" name="reviewerSubsidiaries[' + tempRow + '].engActualNeedTime" type="text" style="width: 54px;height: 27px" data-options="readonly:true">');
		td8.append(td8Content);
		td8Content.textbox();
		tr.append(td8);
		
		var td9 = $('<td colspan="2" style="text-align: center;"></td>');
		var td9Content = $('<input id="engExpectedStartTimeView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedStartTime" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">');
		td9.append(td9Content);
		td9Content.datebox();
		tr.append(td9);
		
		var td10 = $('<td colspan="2" style="text-align: center;"></td>');
		var td10Content = $('<input id="engExpectedShortestCompletionTimeView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedShortestCompletionTime" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">');
		td10.append(td10Content);
		td10Content.datebox();
		tr.append(td10);
		
		var td11 = $('<td colspan="2" style="text-align: center;"></td>');
		var td11Content = $('<input id="engExpectedLongestCompletionTimeView' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedLongestCompletionTime" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">');
		td11.append(td11Content);
		td11Content.datebox();
		tr.append(td11);
		$(".addView").last().after(tr);
		
		//改变datebox控件的输入框的宽度
		td9Content.next().children('input').first().css('width',td9Content.next().width()-22);
		td10Content.next().children('input').first().css('width',td10Content.next().width()-22);
		td11Content.next().children('input').first().css('width',td11Content.next().width()-22);
	}
	
	//删除，从最后一行删除表格
	function delTable(){
		var tempRow = $(".add").length;
		if (tempRow>1){
			$("#firstTd").attr("rowspan",$("#firstTd").attr("rowspan")*1-1);
			$(".add").last().remove();
		}
	}
	
	/* //启用和禁用文件框
	function showHiddenFileBox(obj){
		if($(obj).val() == 'true'){
			$(".easyui-filebox").filebox('enable');
		}else{
			$(".easyui-filebox").filebox('disable');
			$(".easyui-filebox").filebox('clear');
		}
	} */
	
	
	//添加关联E6的文件
	function addFile(){
		$("#username").textbox('enableValidation');
		$("#password").textbox('enableValidation');
		$("#E6").textbox('enableValidation');
		if ($("#e6Form").form('validate')){//判断 验证是否通过
			var sn = $("#E6").val();
			var username = $("#username").val();
			var password = $("#password").val();
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/sales/reviewerCost/findDocInfo.action",//ajax请求的url
				data: {sn:sn,username:username,password:password},//传的参数
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						var rows = $('#dg2').datagrid('getRows');
						if (rows.length>0){
							var flag = true;
							for (var i=0;i<rows.length;i++){
								if (data.id == rows[i].docId){
									flag = false;
									break;
								}
							}
							if (flag){
								$('#dg2').datagrid('appendRow',{
									docId: data.id,
									filename: data.filename,
									extension: data.extension
								});
							}else{
								alert("不能添加相同的关联文件");
							}
						}else{
							$('#dg2').datagrid('appendRow',{
								docId: data.id,
								filename: data.filename,
								extension: data.extension
							});
						}
						$("#E6").textbox("clear");
						$("#username").textbox("disableValidation");
						$("#password").textbox("disableValidation");
						$("#E6").textbox("disableValidation");
					}else{
						alert(data.reason);
						$("#username").textbox("disableValidation");
						$("#password").textbox("disableValidation");
						$("#E6").textbox("disableValidation");
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){//请求失败后的回调函数。
					$("#username").textbox("disableValidation");
					$("#password").textbox("disableValidation");
					$("#E6").textbox("disableValidation");
				}
			});
		}
	}
	
	//删除E6关联的文件，需要点击保存
	function removeE6File(){
		var selected = $("#dg2").datagrid('getSelected');
		if (selected==null){
			showMessager("提示","请选择一条记录进行删除");
		}else{
			var index = $("#dg2").datagrid('getRowIndex',selected);
			$("#dg2").datagrid('deleteRow',index);
		}
	}
	
	//阅读E6关联的文件
	function readE6File(){
		var selected = $("#dg2").datagrid('getSelected');
		if (selected==null){
			showMessager("提示","请选择一条记录进行阅读");
		}else{
			//下面注释的部分，等E6开发好了阅读的接口，在开放，还有后台也要改，直接取传入的参数，不取配置文件中公共的用户了
			/* $("#username").textbox('enableValidation');
			$("#password").textbox('enableValidation');
			$("#E6").textbox("disableValidation"); */
			$("#username").textbox("disableValidation");
			$("#password").textbox("disableValidation");
			$("#E6").textbox("disableValidation");
			if ($("#e6Form").form('validate')){//判断 验证是否通过
				var url = '${pageContext.request.contextPath}/sales/reviewer/readE6File.action?docId=' + selected.docId;
				document.getElementById("e6Form").action=url;//设置表单的url，该表单的target设置为_blank,为新窗口打开
				$("#e6Form").submit();//提交表单
				$("#username").textbox("disableValidation");
				$("#password").textbox("disableValidation");
				$("#E6").textbox("disableValidation");
			}
		}
	}
	
	//下载E6关联的文件
	function downLoadE6File(){
		var selected = $("#dg2").datagrid('getSelected');
		if (selected==null){
			showMessager("提示","请选择一条记录进行下载");
		}else{
			$("#username").textbox('enableValidation');
			$("#password").textbox('enableValidation');
			$("#E6").textbox("disableValidation");
			if ($("#e6Form").form('validate')){//判断 验证是否通过
				var url = '${pageContext.request.contextPath}/sales/reviewerCost/downLoadE6File.action?docId=' + selected.docId;
				document.getElementById("e6Form").action=url;//设置表单的url，该表单的target设置为_blank,为新窗口打开
				$("#e6Form").submit();//提交表单
				$("#username").textbox("disableValidation");
				$("#password").textbox("disableValidation");
				$("#E6").textbox("disableValidation");
			}
		}
	}
	
	//阅读E6关联的文件
	function readE6FileForView(){
		var selected = $("#dg3").datagrid('getSelected');
		if (selected==null){
			showMessager("提示","请选择一条记录进行阅读");
		}else{
			//下面注释的部分，等E6开发好了阅读的接口，在开放，还有后台也要改，直接取传入的参数，不取配置文件中公共的用户了
			/* $("#username").textbox('enableValidation');
			$("#password").textbox('enableValidation');
			$("#E6").textbox("disableValidation"); */
			$("#usernameView").textbox("disableValidation");
			$("#passwordView").textbox("disableValidation");
			if ($("#e6FormView").form('validate')){//判断 验证是否通过
				var url = '${pageContext.request.contextPath}/sales/reviewerCost/readE6File.action?docId=' + selected.docId;
				document.getElementById("e6FormView").action=url;//设置表单的url，该表单的target设置为_blank,为新窗口打开
				$("#e6FormView").submit();//提交表单
				$("#usernameView").textbox("disableValidation");
				$("#passwordView").textbox("disableValidation");
			}
		}
	}
	
	//下载E6关联的文件
	function downLoadE6FileForView(){
		var selected = $("#dg3").datagrid('getSelected');
		if (selected==null){
			showMessager("提示","请选择一条记录进行下载");
		}else{
			$("#usernameView").textbox('enableValidation');
			$("#passwordView").textbox('enableValidation');
			if ($("#e6FormView").form('validate')){//判断 验证是否通过
				var url = '${pageContext.request.contextPath}/sales/reviewerCost/downLoadE6File.action?docId=' + selected.docId;
				document.getElementById("e6Form").action=url;//设置表单的url，该表单的target设置为_blank,为新窗口打开
				$("#e6FormView").submit();//提交表单
				$("#usernameView").textbox("disableValidation");
				$("#passwordView").textbox("disableValidation");
			}
		}
	}
	
	
	
	function queryAuditor(){
  		var selected = $("#dg").datagrid("getSelected");
  		if (selected != null){
			var id = "";
			var processInstanceId = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
					processInstanceId = selected.processInstanceId;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#dg').treegrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if(processInstanceId == "" || processInstanceIdInput.text() == "审核中"){
	  			$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/reviewerCost/queryAuditorById.action",//ajax请求的url
					data: {id:id},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							if (data.rows.length>0){//表示还有下一节点
								$("#auditUserDg").datagrid("clearSelections");
								$("#auditUserDg").datagrid('loadData',data.rows);
								//$("#processInstanceId").val(processInstanceId);
								$("#id").val(id);
								$("#auditUserDialog").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'请选择接收任务的人员'
								});
							}else{//表示最后一个节点
								$.messager.confirm('确认对话框', '您确定要审核吗？', function(b){
									if (b){//如何用户点击的是确认
										$.ajax({
											type:'POST',//post请求
											url: "${pageContext.request.contextPath}/sales/reviewerCost/auditReviewer.action",//ajax请求的url
											data: {id:id},//传的参数
											async: false,//同步请求
											cache: false,//不缓存此页面
											success: function(data){//请求成功后的回调函数。data：服务器返回数据。
												if (data.success){
													showMessager("提示","审核成功");
													$("#dg").treegrid('reload');//重新加载数据，保持在当前页
													
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
				var id = $("#id").val();
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/reviewerCost/auditReviewer.action",//ajax请求的url
					data: {assigneeId:assigneeId,id:id},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.success){
							showMessager("提示","审核成功");
							$("#auditUserDialog").dialog({//关闭这个dialog
								closed:true
							});
							$("#dg").treegrid('reload');//重新加载数据，保持在当前页
	
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
		  var selected = $("#dg").datagrid("getSelected");
		  if (selected != null){
			  var id = "";
			  var processInstanceId = "";
			  while (id == ""){
				  if (selected._parentId == undefined){//根节点
					  id = selected.id;
					  processInstanceId = selected.processInstanceId;
					  
				  }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					  selected = $('#dg').treegrid('getParent',selected.id);
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
								url: "${pageContext.request.contextPath}/sales/reviewerCost/revokeProcess.action",//ajax请求的url
								data: {id:id},//传的参数
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(data){//请求成功后的回调函数。data：服务器返回数据。
									if (data.success){
										showMessager("提示","撤销成功");
										$("#dg").treegrid('reload');//重新加载数据，保持在当前页
										
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
			var selected = $("#dg").treegrid('getSelected');//取得选中的行
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
						selected = $('#dg').treegrid('getParent',selected.id);
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
							url: "${pageContext.request.contextPath}/sales/reviewerCost/takeBackReviewer.action",//ajax请求的url
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
									$("#dg").treegrid('reload');
									
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
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
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
					selected = $('#dg').treegrid('getParent',selected.id);
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
						url: "${pageContext.request.contextPath}/sales/reviewerCost/rollBackReviewer.action",//ajax请求的url
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
								$("#dg").treegrid('reload');

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
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
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
					selected = $('#dg').treegrid('getParent',selected.id);
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
						url: "${pageContext.request.contextPath}/sales/reviewerCost/antiAuditReviewer.action",//ajax请求的url
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
								$("#dg").treegrid('reload');

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
  <body class="easyui-layout">
  	<div data-options="region:'center'" style="background:#eee;">
	  	<table id="dg"   
	  		
	  		data-options="onDblClickRow:function (row){
												    	<p:isPrivilege pid="df" mid="dfb">
												    		edit();//是子节点则开始编辑
											    		</p:isPrivilege>
											    }
											    <p:isPrivilege pid="df" mid="dfk">
												     ,onSelect:function(row){
										            	var url = '${pageContext.request.contextPath}/sales/reviewerCost/findCostBudgetListBySalReviewerId.action'; 
										            	var id = '';
										            	//判断是否是子节点
														if($('#dg').treegrid('isLeaf',row.id)){//是子节点
															id = row._parentId
														}else{//不是子节点
															id = row.id;
														}
										            	$('#costBudgetDg').datagrid('options').url = url;
										            	$('#costBudgetDg').datagrid('reload',{
										            		salReviewerId:id
										            	});
										            	$('#costBudgetDg').datagrid('unselectAll');
								           			}
							           			</p:isPrivilege>
							           			"
			
	  		
	  	></table>
	  	
	  	<div id="gridToolBar" style="padding:5px;height:auto;">
			<div style="display:inline-block;">
				<p:isPrivilege pid="df" mid="dfa">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="df" mid="dfb">
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
				</p:isPrivilege>
				<a class="easyui-linkbutton" iconCls="icon-mini-edit" plain="true" onClick="view();" style="float: left;">查看</a> <div class="btn-separator"></div>
				<p:isPrivilege pid="df" mid="dfa">
					<a class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copyData()" style="float: left;">复制</a> <div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="df" mid="dfc">
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
				</p:isPrivilege>
				<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
				<p:isPrivilege pid="df" mid="dfh">
					<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportWord();" style="float: left;">导出word</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="df" mid="dfi">
					<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="queryAuditor();" style="float: left;">审核</a><div class="btn-separator"></div>
					<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="revokeProcess();" style="float: left;">撤销流程</a><div class="btn-separator"></div>
					<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openTakeBackDialog();" style="float: left;">收回审核</a><div class="btn-separator"></div>
					<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openRollBackDialog();" style="float: left;">退回审核</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="df" mid="dfj">
					<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAntiAuditDialog();" style="float: left;">反审核</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="df" mid="dfk">
					<p:isPrivilege pid="df" mid="dfl">
						<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="generateCostBudget();" style="float: left;">生成成本核算表</a><div class="btn-separator"></div>
					</p:isPrivilege>
				</p:isPrivilege>
			</div>
			<div>
				<form id="queryForm">
					Q编号：<input id="quotationNo_query" type="text" class="easyui-textbox" name="quotationNo" style="width: 70px" >
					年份：<input id="quotationYear_query" type="text" class="easyui-textbox" name="quotationYear" style="width: 40px" >
					项目负责人：<input id="projectLeader_query" type="text" name="projectLeader" style="width: 80px" class="easyui-textbox">
					评审日期：<input id="startCreateTime_query" type="text" name="startCreateTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
					&nbsp;~&nbsp;<input id="endCreateTime_query" type="text" name="endCreateTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
					我的待办查询：<input id="assignee" name="assignee" class="easyui-switchbutton" data-options="onText:'开启',offText:'关闭',onChange:function(checked){query()}">
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
				</form>
			</div>
		</div>
		<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
			<p:isPrivilege pid="df" mid="dfa">
		    	<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
		    </p:isPrivilege>
		    <p:isPrivilege pid="df" mid="dfb">
	    		<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
	   		</p:isPrivilege>
	   		<div data-options="iconCls:'icon-mini-edit'" onclick="view();">查看</div>
	   		<p:isPrivilege pid="df" mid="dfa">
	   			<div data-options="iconCls:'icon-large-shapes'" onclick="copyData();">复制</div>
	   		</p:isPrivilege>
	   		<p:isPrivilege pid="df" mid="dfc">
	    		<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
	   		</p:isPrivilege>
		    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
		    <p:isPrivilege pid="df" mid="dfh">
		    	<div data-options="iconCls:'icon-redo'" onclick="exportWord();">导出word</div>
	    	</p:isPrivilege>
		   <p:isPrivilege pid="df" mid="dfi">
		    	<div data-options="iconCls:'icon-man'" onclick="queryAuditor();">审核</div>
			    <div data-options="iconCls:'icon-cancel'" onclick="revokeProcess();">撤销流程</div>
		   		<div data-options="iconCls:'icon-back'" onclick="openTakeBackDialog();">收回审核</div>
		   		<div data-options="iconCls:'icon-back'" onclick="openRollBackDialog();">退回审核</div>
	    	</p:isPrivilege>
	    	<p:isPrivilege pid="df" mid="dfj">
	   			<div data-options="iconCls:'icon-man'" onclick="openAntiAuditDialog();">反审核</div>
	   		</p:isPrivilege>
	   		<p:isPrivilege pid="df" mid="dfk">
				<p:isPrivilege pid="df" mid="dfl">
	   				<div data-options="iconCls:'icon-add'" onclick="generateCostBudget()">生成成本核算表</div>
	   			</p:isPrivilege>
	   		</p:isPrivilege>
		</div>
	</div>
	<p:isPrivilege pid="df" mid="dfk">
		<div data-options="region:'south',hideCollapsedContent:false,expandMode:'dock',title:'成本分析表',split:true" style="height:200px;margin-bottom: -3px">
			<jsp:include page="reviewerForCostBudget.jsp"></jsp:include>
		</div>
	</p:isPrivilege>
  	
  	
  	
  	<!-- 增&改的dialog -->
	<div id="dialog1" class="easyui-dialog" style="width: 1000px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb1'">
  		<div>
			<form id="form1" style="height: 100%" method="post">
		 			<input id="flag" type="hidden" value="">
		 			<input name="isCost" type="hidden" value="true"><!-- 标识当前的为成本核算 -->
		 			<input id="id" type="hidden" name="id" value="">
		 			<input id="processInstanceId" name="processInstanceId" type="hidden">
		 			<table cellspacing="0" align="center" width="960px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
		  			<tr style="height: 30px">
		  				<td colspan="18" style="text-align:center;">
		  					<div style="width: 40%;text-align: center;float: left;">
				  				报价单编号：<input id="quotationNo" type="text" name="quotationNo" class="easyui-textbox" style="width: 300px;height: 27px" data-options="required:true,missingMessage:'报价单编号不能为空',validType:'checkQuotationNoFormat'">
				  			</div>
				  			<div style="width: 30%;text-align: center;float: left;">
				  				信息记录次数：&nbsp;&nbsp;第&nbsp;&nbsp;<input id="infoRecordNumber" type="text" name="infoRecordNumber" style="width: 30px;height: 27px" class="easyui-numberbox" data-options="required:true,missingMessage:'信息记录不能为空'">&nbsp;&nbsp;次
			  				</div>
			  				<div style="width: 30%;text-align: center;float: left;">
				  				日期：<input id="createTime" type="text" name="createTime" class="easyui-datebox" style="height: 27px" value="<p:date/>" data-options="editable:false,readonly:true,required:true,missingMessage:'日期不能为空'">
			  				</div>
			  			</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="3" rowspan="2" style="text-align:center;width: 10%">
		  					客户需求<br>
		  					项目
		  				</td>
		  				<td colspan="5" style="text-align:center;width: 30%">
			  				<input type="checkbox" name="project" value="控制台" >控制台
			  			</td>
			  			<td colspan="5" style="text-align:center;width: 30%">
			  				<input type="checkbox" name="project" value="机柜">机柜
			  			</td>
			  			<td colspan="5" style="text-align:center;width: 30%">
			  				<input type="checkbox" name="project" value="电视墙">电视墙
			  			</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="15" style="width: 90%">
		  					其他：<input id="otherProject" type="text" style="width: 90%;height: 27px" name="otherProject" class="easyui-textbox">
		  				</td>
		  			</tr>
		  			<tr style="height: 100px;">
		  				<td colspan="1" style="width: 4%">
		  					项<br>目<br>内<br>容
		  				</td>
		  				<td colspan="17" style="text-align:center;width: 96%">
		  					<input id="projectContent" type="text" class="easyui-textbox" style="width: 100%;height: 99%" name="projectContent"  data-options="multiline:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="2" style="text-align:center;width: 5%">
		  					包装
		  				</td>
		  				<td colspan="16" style="text-align:left;width: 95%">
			  				<input type="checkbox" name="packaging" value="纸皮">纸皮
			  				<input type="checkbox" name="packaging" value="纸箱">纸箱
			  				<input type="checkbox" name="packaging" value="木箱">木箱
			  				<input type="checkbox" name="packaging" value="木栏">木栏
			  				&nbsp;&nbsp;其他：<input type="text" style="width: 68%;height: 27px" name="otherPackaging" class="easyui-textbox">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="2" style="text-align:center;width: 5%">
		  					送货
		  				</td>
		  				<td colspan="12" style="text-align:left;">
			  				<input type="checkbox" name="delivery" value="厂车" >厂车
			  				<input type="checkbox" name="delivery" value="请车">请车
			  				<input type="checkbox" name="delivery" value="速递">速递
			  				<input type="checkbox" name="delivery" value="空运">空运
			  				<input type="checkbox" name="delivery" value="托运">托运
			  				<input type="checkbox" name="delivery" value="铁路">铁路
			  				<input type="checkbox" name="delivery" value="自取">自取
			  				&nbsp;&nbsp;其他：<input id="otherDelivery" type="text" style="width: 37%;height: 27px" name="otherDelivery" class="easyui-textbox">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
		  					填表人：<input id="salPreparer" type="text" name="salPreparer" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true" value="${user.username}">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="5" style="text-align:center;width: 22%">
		  					送货地点：<input id="destination" type="text" name="destination" style="width: 70%;height: 27px" class="easyui-textbox">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
			  				是否安装：
			  				<input class="radio" type="checkbox" name="isInstall" value="true" checked="checked">是
			  				<input class="radio" type="checkbox" name="isInstall" value="false">否
		  				</td>
		  				<td colspan="5" style="text-align:center;width: 30%">
			  				期望交布局图日：<input id="expectedLayoutDate" type="text" name="expectedLayoutDate" class="easyui-datebox" style="height: 27px" data-options="editable:false">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
			  				项目负责人：<input id="projectLeader" type="text" name="projectLeader" style="width: 35%;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'项目负责人不能为空'">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="9" style="text-align:center;width: 46%">
		  					项目紧急和重要程度：<input id="importance" type="text" name="importance" style="width: 70%;height: 27px" class="easyui-textbox">
		  				</td>
		  				<td colspan="5" style="text-align:center;width: 30%">
			  				合同总交期：<input id="contractDeliveryDate" type="text" name="contractDeliveryDate" class="easyui-textbox" style="height: 27px">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
			  				审核人：<input id="salReviewer" type="text" name="salReviewer" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px;background-color: #969494;">
		  				<td colspan="10" style="text-align:center;width: 52%">
		  					<b><span style="font-size: 15px">需做成本核算项目：</span></b><input id="requiredCostOfProject" type="text" name="requiredCostOfProject" style="width: 70%;height: 27px" class="easyui-textbox">
		  				</td>
		  				<td colspan="8" style="text-align:center;width: 48%">
			  				<b><span style="font-size: 15px">要求完成日期：</span></b><input id="requiredCompletionDate" type="text" name="requiredCompletionDate" class="easyui-datebox" style="height: 27px" data-options="editable:false">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px;">
		  				<td colspan="18" style="text-align:center;">
		  					<div style="width: 10%;float: left;">
		  						抄送相关部门：
		 					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartment" value="工程部">工程部
		  					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartment" value="采购部">采购部
		 						</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartment" value="生产部">生产部
		  					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartment" value="品管部">品管部
		  					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartment" value="财务部">财务部
		 					</div>
		  				</td>
		  			</tr>
		  			
		  			
		  			
		  			
		  			<table cellspacing="0" align="center" width="960px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
			  			<tr style="height: 30px">
			  				<td id="firstTd" colspan="1" rowspan="7" style="text-align: center;width: 3%">
			  					工<br>程<br>部
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 4%">
			  					项目<br>序号
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 15%">
			  					<a href="#" class="easyui-linkbutton" plain="true" style="float: left;" data-options="iconCls:'icon-add'" onclick="addTable()"></a>
			  					货品名称
			  					<a href="#" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-remove'" onclick="delTable()"></a>
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 22%">
			  					产品型号
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 4%">
			  					数量
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 3%">
			  					单位
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 4%">
			  					类型
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 9%">
			  					负责人
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 6%">
			  					工程实际<br>需工时
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 10%">
			  					预计开工<br>日期
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 10%">
			  					预计完成<br>日期(最短)
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 10%">
			  					预计完成<br>日期(最长)
			  				</td>
			  			</tr>
			  			<tr class="add" style="height: 30px">
			  				<td colspan="1" style="text-align: center;width: 50px">
			  					<input id="id0" type="hidden" name="reviewerSubsidiaries[0].id" value="">
			  					<input id="sequence0" type="hidden" name="reviewerSubsidiaries[0].sequence" value="1">
			  					1
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="productName0" type="text" name="reviewerSubsidiaries[0].productName" style="width: 140px;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'货品名称不能为空'">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="productModel0" type="text" name="reviewerSubsidiaries[0].productModel" style="width: 205px;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'产品型号不能为空'">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="quantity0" type="text" name="reviewerSubsidiaries[0].quantity" style="width: 35px;height: 27px" class="easyui-numberbox" data-options="required:true,missingMessage:'数量不能为空'">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="unit0" type="text" name="reviewerSubsidiaries[0].unit" style="width: 26px;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'单位不能为空'">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="category0" type="text" name="reviewerSubsidiaries[0].category" style="width: 36px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="engLeader0" type="text" name="reviewerSubsidiaries[0].engLeader" style="width: 81px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engActualNeedTime0" type="text" name="reviewerSubsidiaries[0].engActualNeedTime" style="width: 54px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engExpectedStartTime0" type="text" name="reviewerSubsidiaries[0].engExpectedStartTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engExpectedShortestCompletionTime0" type="text" name="reviewerSubsidiaries[0].engExpectedShortestCompletionTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engExpectedLongestCompletionTime0" type="text" name="reviewerSubsidiaries[0].engExpectedLongestCompletionTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
			  			</tr>
			  			
			  			
			  			<tr style="height: 30px">
			  				<td colspan="17" style="text-align: center;">
			  					制定：<input id="develop" type="text" name="develop" style="width: 90%;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<!-- <td colspan="8" style="text-align: center;">
			  					编排：<input id="arrange" type="text" name="arrange" style="width: 100px" class="easyui-textbox" data-options="readonly:true">
			  					日期：<input id="arrangeDate" type="text" name="arrangeDate" class="easyui-datebox" data-options="editable:false,readonly:true" style="width: 92px">
			  				</td> -->
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="2" style="text-align: center;">
			  					特别物料:
			  				</td>
			  				<td colspan="15" style="text-align: center;">
			  					<input id="specialMaterial" type="text" name="specialMaterial" style="width: 94%;height: 27px" class="easyui-textbox"  data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="2" rowspan="3" style="text-align: center;">
			  					备注:
			  				</td>
			  				<td colspan="11" rowspan="3" style="text-align: center;">
			  					<input id="engRemark" type="text" class="easyui-textbox" name="engRemark" style="width: 100%;height: 87px" data-options="readonly:true,multiline:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					编排人：<input id="arrange" type="text" name="arrange" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  					<!-- 填写人：<input id="engPreparer" type="text" name="engPreparer" style="width: 100px" class="easyui-textbox" data-options="readonly:true"> -->
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核人：<input id="engReviewer" type="text" name="engReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核时间：<input id="engReviewerDate" type="text" name="engReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			
			  			<tr height="30px">
			  				<td colspan="1" style="text-align: center;">
			  					采购
			  				</td>
			  				<td colspan="3" style="text-align: center;">
			  					采购周期：<input id="purPeriod" type="text" name="purPeriod" style="width: 50px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天
			  				</td>
			  				<td colspan="5" style="text-align: center;">
			  					备注：<input id="purRemark" type="text" name="purRemark" style="width: 85%;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="5" style="text-align: center;">
			  					审核人：<input id="purReviewer" type="text" name="purReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					审核时间：<input id="purReviewerDate" type="text" name="purReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			
			  			
			  			<tr style="height: 30px">
			  				<td colspan="1" rowspan="5" style="text-align: center;">
			  					生<br>产<br>部
			  				</td>
			  				<td colspan="6" style="text-align: center;">
			  					最短时间：<input id="proExpectedShortestCompletionTime" type="text" name="proExpectedShortestCompletionTime" style="width: 40px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天&nbsp;&nbsp;
			  					最长时间：<input id="proExpectedLongestCompletionTime" type="text" name="proExpectedLongestCompletionTime" style="width: 40px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天
			  				</td>
			  				<td colspan="11" style="text-align: center;">
			  					预算安装人数和安装周期:                
			  					<input id="installPeopleNumber" type="text" name="installPeopleNumber" style="width: 50px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天/&nbsp;&nbsp;
			  					<input id="installPeriod" type="text" name="installPeriod" style="width: 35px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;人
			  					
			  					
			  				</td>
		  				</tr>
		  				<tr style="height: 30px">
			  				<td colspan="13">
			  					有无特别加工手段（如设备或模具等费用）：
			  					<input type="checkbox" name="isSpecialProcessing" value="false" checked="checked" onclick="return false">无&nbsp;&nbsp;
			  					<input type="checkbox" name="isSpecialProcessing" value="true" onclick="return false" onclick="return false">有&nbsp;&nbsp;
			  					<input id="specialProcessing" type="text" name="specialProcessing" style="width: 360px;height: 27px" class="easyui-textbox" data-options="readonly:true,disabled:true,required:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					预计开工时间：
			  					<input id="proExpectedStartTime" type="text" name="proExpectedStartTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
		  				</tr>
		  				<tr style="height: 30px">
			  				<td colspan="2" rowspan="3" style="text-align: center;">
			  					备注:
			  				</td>
			  				<td colspan="11" rowspan="3" style="text-align: center;">
			  					<input id="proRemark" type="text" name="proRemark" class="easyui-textbox" style="width: 100%;height: 87px;" data-options="readonly:true,multiline:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					填写人：<input id="proPreparer" type="text" name="proPreparer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核人：<input id="proReviewer" type="text" name="proReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核时间：<input id="proReviewerDate" type="text" name="proReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  		</table>
		 			</table>
		 		</form>
				</div>
				<div>
		 		<form id="e6Form" action="" method="post" target="_blank">
		  		<div style="text-align: left;padding-left: 5px">
		  			备注说明：此表的流程规定按“与客户有关的过程管理程序”执行<br>
					* 最短时间：正常实际最快能做到的时间（不含星期天及假日）；特殊急单可调整做到的时间，不做正常合同承诺时间。<br>
					* 最长时间：考虑其他调整因素，保证能完成的时间（包括星期天和假日），承诺客户的合理合同时间。<br>
					<input id="isAttached" type="hidden" name="isAttached">
					
						E6账号：<input id="username" type="text" class="easyui-textbox" name="username" style="width: 100px;" data-options="required:true,missingMessage:'请输入E6账号'">
						E6密码：<input id="password" type="password" class="easyui-textbox" name="password" style="width: 100px" data-options="required:true,missingMessage:'请输入E6密码'">
					<p:isPrivilege pid="de" mid="dee">
						E6文档编号：<input id="E6" type="text" style="width: 100px" class="easyui-textbox" data-options="required:true,missingMessage:'请输入E6文档编号'">
						<a href="#" class="easyui-linkbutton" onclick="addFile()">增加关联文件</a>
					</p:isPrivilege>
					<br>
					<table id="dg2" style="width: 960px;"
						<p:isPrivilege pid="de" mid="dee">
						data-options="onDblClickRow:function (row){
														    	readE6File();
														    }"
						</p:isPrivilege>
						
					>
					</table>
				</div>
			</form>
		</div>
	</div>
	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
	
	<!-- 关联E6上的工具栏 -->
	<div id="gridToolBar2" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<p:isPrivilege pid="df" mid="dfg">
				<a href="#" class="easyui-linkbutton" plain="true" onClick="removeE6File();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="df" mid="dfe">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="readE6File();" style="float: left;">阅读</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="df" mid="dff">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="downLoadE6File();" style="float: left;">下载</a><div class="btn-separator"></div>
			</p:isPrivilege>	
		</div>
	</div>
	
	<div id="menu2" class="easyui-menu" style="width: 80px; display: none;">
		<p:isPrivilege pid="df" mid="dfg">
	    	<div onclick="removeE6File();">删除</div>
	    </p:isPrivilege>
	    <p:isPrivilege pid="df" mid="dfe">
		    <div onclick="readE6File();">阅读</div>
		</p:isPrivilege>
		<p:isPrivilege pid="df" mid="dfg">
		    <div onclick="downLoadE6File();">下载</div>
		</p:isPrivilege>
	</div>
	
	
	<!-- 增&改的dialog -->
	<div id="viewDialog" class="easyui-dialog" style="width: 1000px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#viewBb'">
  		<div>
			<form id="formView1" style="height: 100%" enctype='multipart/form-data' method="post">
	  			<table cellspacing="0" align="center" width="960px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
		  			<tr style="height: 30px">
		  				<td colspan="18" style="text-align:center;">
		  					<div style="width: 40%;text-align: center;float: left;">
				  				报价单编号：<input id="quotationNoView" type="text" name="quotationNo" class="easyui-textbox" style="width: 300px;height: 27px" data-options="readonly:true,required:true,missingMessage:'报价单编号不能为空',validType:'checkQuotationNoFormat'">
				  			</div>
				  			<div style="width: 30%;text-align: center;float: left;">
				  				信息记录次数：&nbsp;&nbsp;第&nbsp;&nbsp;<input id="infoRecordNumberView" type="text" name="infoRecordNumber" style="width: 30px;height: 27px" class="easyui-numberbox" data-options="readonly:true,required:true,missingMessage:'信息记录不能为空'">&nbsp;&nbsp;次
			  				</div>
			  				<div style="width: 30%;text-align: center;float: left;">
				  				日期：<input id="createTime" type="text" name="createTimeView" class="easyui-datebox" style="height: 27px" value="<p:date/>" data-options="editable:false,readonly:true,required:true,missingMessage:'日期不能为空'">
			  				</div>
			  			</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="3" rowspan="2" style="text-align:center;width: 10%">
		  					客户需求<br>
		  					项目
		  				</td>
		  				<td colspan="5" style="text-align:center;width: 30%">
			  				<input type="checkbox" name="projectView" value="控制台" onclick="return false">控制台
			  			</td>
			  			<td colspan="5" style="text-align:center;width: 30%">
			  				<input type="checkbox" name="projectView" value="机柜" onclick="return false">机柜
			  			</td>
			  			<td colspan="5" style="text-align:center;width: 30%">
			  				<input type="checkbox" name="projectView" value="电视墙" onclick="return false">电视墙
			  			</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="15" style="width: 90%">
		  					其他：<input id="otherProjectView" type="text" style="width: 90%;height: 27px" name="otherProject" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 100px;">
		  				<td colspan="1" style="width: 4%">
		  					项<br>目<br>内<br>容
		  				</td>
		  				<td colspan="17" style="text-align:center;width: 96%">
		  					<input id="projectContentView" type="text" class="easyui-textbox" style="width: 100%;height: 99%" name="projectContent"  data-options="readonly:true,multiline:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="2" style="text-align:center;width: 5%">
		  					包装
		  				</td>
		  				<td colspan="16" style="text-align:left;width: 95%">
			  				<input type="checkbox" name="packagingView" value="纸皮" onclick="return false">纸皮
			  				<input type="checkbox" name="packagingView" value="纸箱" onclick="return false">纸箱
			  				<input type="checkbox" name="packagingView" value="木箱" onclick="return false">木箱
			  				<input type="checkbox" name="packagingView" value="木栏" onclick="return false">木栏
			  				&nbsp;&nbsp;其他：<input type="text" style="width: 68%;height: 27px" name="otherPackaging" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="2" style="text-align:center;width: 5%">
		  					送货
		  				</td>
		  				<td colspan="12" style="text-align:left;">
			  				<input type="checkbox" name="deliveryView" value="厂车" onclick="return false">厂车
			  				<input type="checkbox" name="deliveryView" value="请车" onclick="return false">请车
			  				<input type="checkbox" name="deliveryView" value="速递" onclick="return false">速递
			  				<input type="checkbox" name="deliveryView" value="空运" onclick="return false">空运
			  				<input type="checkbox" name="deliveryView" value="托运" onclick="return false">托运
			  				<input type="checkbox" name="deliveryView" value="铁路" onclick="return false">铁路
			  				<input type="checkbox" name="deliveryView" value="自取" onclick="return false">自取
			  				&nbsp;&nbsp;其他：<input id="otherDeliveryView" type="text" style="width: 37%;height: 27px" name="otherDelivery" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
		  					填表人：<input id="salPreparerView" type="text" name="salPreparer" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true" value="${user.username}">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="5" style="text-align:center;width: 22%">
		  					送货地点：<input id="destinationView" type="text" name="destination" style="width: 70%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
			  				是否安装：
			  				<input type="checkbox" name="isInstall" value="true" checked="checked" onclick="return false">是
			  				<input type="checkbox" name="isInstall" value="false" onclick="return false">否
		  				</td>
		  				<td colspan="5" style="text-align:center;width: 30%">
			  				期望交布局图日：<input id="expectedLayoutDateView" type="text" name="expectedLayoutDate" class="easyui-datebox" style="height: 27px" data-options="editable:false,readonly:true">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
			  				项目负责人：<input id="projectLeaderView" type="text" name="projectLeader" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px">
		  				<td colspan="9" style="text-align:center;width: 46%">
		  					项目紧急和重要程度：<input id="importanceView" type="text" name="importance" style="width: 70%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td colspan="5" style="text-align:center;width: 30%">
			  				合同总交期：<input id="contractDeliveryDateView" type="text" name="contractDeliveryDate" class="easyui-textbox" style="height: 27px" data-options="editable:false,readonly:true">
		  				</td>
		  				<td colspan="4" style="text-align:center;width: 24%">
			  				审核：<input id="salReviewerView" type="text" name="salReviewer" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px;background-color: #969494;">
		  				<td colspan="10" style="text-align:center;width: 52%">
		  					<b><span style="font-size: 15px">需做成本核算项目：</span></b><input id="requiredCostOfProjectView" type="text" name="requiredCostOfProject" style="width: 70%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td colspan="8" style="text-align:center;width: 48%">
			  				<b><span style="font-size: 15px">要求完成日期：</span></b><input id="requiredCompletionDateView" type="text" name="requiredCompletionDate" class="easyui-datebox" style="height: 27px" data-options="editable:false,readonly:true">
		  				</td>
		  			</tr>
		  			<tr style="height: 30px;">
		  				<td colspan="18" style="text-align:center;">
		  					<div style="width: 10%;float: left;">
		  						抄送相关部门：
	  						</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartmentView" value="工程部" onclick="return false">工程部
		  					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartmentView" value="采购部" onclick="return false">采购部
	  						</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartmentView" value="生产部" onclick="return false">生产部
		  					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartmentView" value="品管部" onclick="return false">品管部
		  					</div>
		  					<div style="width: 15%;float: left;">
		  						<input type="checkbox" name="aboutDepartmentView" value="财务部" onclick="return false">财务部
	  						</div>
		  				</td>
		  			</tr>
		  			
		  			
		  			
		  			
		  			<table cellspacing="0" align="center" width="960px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
			  			<tr style="height: 30px">
			  				<td id="firstTdView" colspan="1" rowspan="7" style="text-align: center;width: 3%">
			  					工<br>程<br>部
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 4%">
			  					项目<br>序号
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 15%">
			  					货品名称
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 22%">
			  					产品型号
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 4%">
			  					数量
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 3%">
			  					单位
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 4%">
			  					类型
			  				</td>
			  				<td colspan="1" style="text-align: center;width: 9%">
			  					负责人
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 6%">
			  					工程实际<br>需工时
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 10%">
			  					预计开工<br>日期
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 10%">
			  					预计完成<br>日期(最短)
			  				</td>
			  				<td colspan="2" style="text-align: center;width: 10%">
			  					预计完成<br>日期(最长)
			  				</td>
			  			</tr>
			  			<tr class="addView" style="height: 30px">
			  				<td colspan="1" style="text-align: center;width: 50px">
			  					<input id="idView0" type="hidden" name="reviewerSubsidiaries[0].id" value="">
			  					<input id="sequenceView0" type="hidden" name="reviewerSubsidiaries[0].sequence" value="1">
			  					1
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="productNameView0" type="text" name="reviewerSubsidiaries[0].productName" style="width: 140px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="productModelView0" type="text" name="reviewerSubsidiaries[0].productModel" style="width: 205px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="quantityView0" type="text" name="reviewerSubsidiaries[0].quantity" style="width: 35px;height: 27px" class="easyui-numberbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="unitView0" type="text" name="reviewerSubsidiaries[0].unit" style="width: 26px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="categoryView0" type="text" name="reviewerSubsidiaries[0].category" style="width: 36px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="1" style="text-align: center;">
			  					<input id="engLeaderView0" type="text" name="reviewerSubsidiaries[0].engLeader" style="width: 81px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engActualNeedTimeView0" type="text" name="reviewerSubsidiaries[0].engActualNeedTime" style="width: 54px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engExpectedStartTimeView0" type="text" name="reviewerSubsidiaries[0].engExpectedStartTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engExpectedShortestCompletionTimeView0" type="text" name="reviewerSubsidiaries[0].engExpectedShortestCompletionTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
			  				<td colspan="2" style="text-align: center;">
			  					<input id="engExpectedLongestCompletionTimeView0" type="text" name="reviewerSubsidiaries[0].engExpectedLongestCompletionTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
			  			</tr>
			  			
			  			
			  			<tr style="height: 30px">
			  				<td colspan="17" style="text-align: center;">
			  					制定：<input id="developView" type="text" name="develop" style="width: 90%;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<!-- <td colspan="8" style="text-align: center;">
			  					编排：<input id="arrange" type="text" name="arrange" style="width: 100px" class="easyui-textbox" data-options="readonly:true">
			  					日期：<input id="arrangeDate" type="text" name="arrangeDate" class="easyui-datebox" data-options="editable:false,readonly:true" style="width: 92px">
			  				</td> -->
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="2" style="text-align: center;">
			  					特别物料:
			  				</td>
			  				<td colspan="15" style="text-align: center;">
			  					<input id="specialMaterialView" type="text" name="specialMaterial" style="width: 94%;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="2" rowspan="3" style="text-align: center;">
			  					备注:
			  				</td>
			  				<td colspan="11" rowspan="3" style="text-align: center;">
			  					<input id="engRemarkView" type="text" class="easyui-textbox" name="engRemark" style="width: 100%;height: 87px" data-options="readonly:true,multiline:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					编排人：<input id="arrange" type="text" name="arrange" style="width: 100px" class="easyui-textbox" data-options="readonly:true">
			  					<!-- 填写人：<input id="engPreparer" type="text" name="engPreparer" style="width: 100px" class="easyui-textbox" data-options="readonly:true"> -->
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核人：<input id="engReviewerView" type="text" name="engReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核时间：<input id="engReviewerDateView" type="text" name="engReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			
			  			
			  			<tr height="30px">
			  				<td colspan="1" style="text-align: center;">
			  					采购
			  				</td>
			  				<td colspan="3" style="text-align: center;">
			  					采购周期：<input id="purPeriodView" type="text" name="purPeriod" style="width: 50px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天
			  				</td>
			  				<td colspan="5" style="text-align: center;">
			  					备注：<input id="purRemarkView" type="text" name="purRemark" style="width: 85%;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="5" style="text-align: center;">
			  					审核人：<input id="purReviewerView" type="text" name="purReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					审核时间：<input id="purReviewerDateView" type="text" name="purReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			
			  			
			  			<tr style="height: 30px">
			  				<td colspan="1" rowspan="5" style="text-align: center;">
			  					生<br>产<br>部
			  				</td>
			  				<td colspan="6" style="text-align: center;">
			  					最短时间：<input id="proExpectedShortestCompletionTimeView" type="text" name="proExpectedShortestCompletionTime" style="width: 40px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天&nbsp;&nbsp;
			  					最长时间：<input id="proExpectedLongestCompletionTimeView" type="text" name="proExpectedLongestCompletionTime" style="width: 40px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天
			  					<%-- <p:isPrivilege pid="df" mid="dfd">
			  						<a href="#" class="easyui-linkbutton" iconCls="icon-sum" onClick="openDialig2()" style="float: left;">项目评审工时计算</a>
		  						</p:isPrivilege> --%>
			  				</td>
			  				<td colspan="11" style="text-align: center;">
			  					预算安装人数和安装周期:                
			  					<input id="installPeopleNumberView" type="text" name="installPeopleNumber" style="width: 50px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天/&nbsp;&nbsp;
			  					<input id="installPeriodView" type="text" name="installPeriod" style="width: 35px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;人
			  					
			  					
			  				</td>
		  				</tr>
		  				<tr style="height: 30px">
			  				<td colspan="13">
			  					有无特别加工手段（如设备或模具等费用）：
			  					<input type="checkbox" name="isSpecialProcessing" value="false" checked="checked" onclick="return false">无&nbsp;&nbsp;
			  					<input type="checkbox" name="isSpecialProcessing" value="true" onclick="return false">有&nbsp;&nbsp;
			  					<input id="specialProcessingView" type="text" name="specialProcessing" style="width: 380px;height: 27px" class="easyui-textbox" data-options="readonly:true,disabled:true,required:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					预计开工时间：
			  					<input id="proExpectedStartTimeView" type="text" name="proExpectedStartTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
			  				</td>
		  				</tr>
		  				<tr style="height: 30px">
			  				<td colspan="2" rowspan="3" style="text-align: center;">
			  					备注:
			  				</td>
			  				<td colspan="11" rowspan="3" style="text-align: center;">
			  					<input id="proRemarkView" type="text" name="proRemark" class="easyui-textbox" style="width: 100%;height: 87px" data-options="readonly:true,multiline:true">
			  				</td>
			  				<td colspan="4" style="text-align: center;">
			  					填写人：<input id="proPreparerView" type="text" name="proPreparer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核人：<input id="proReviewerView" type="text" name="proReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  			<tr style="height: 30px">
			  				<td colspan="4" style="text-align: center;">
			  					审核时间：<input id="proReviewerDateView" type="text" name="proReviewerDate" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
			  				</td>
			  			</tr>
			  		</table>
	  			</table>
	  		</form>
		</div>
		<div>
			<form id="e6FormView" action="" method="post" target="_blank">
				<div style="text-align: left;padding-left: 5px">
		  			备注说明：此表的流程规定按“与客户有关的过程管理程序”执行<br>
					* 最短时间：正常实际最快能做到的时间（不含星期天及假日）；特殊急单可调整做到的时间，不做正常合同承诺时间。<br>
					* 最长时间：考虑其他调整因素，保证能完成的时间（包括星期天和假日），承诺客户的合理合同时间。<br>
					E6账号：<input id="usernameView" type="text" class="easyui-textbox" name="username" style="width: 100px;" data-options="required:true,missingMessage:'请输入E6账号'">
					E6密码：<input id="passwordView" type="password" class="easyui-textbox" name="password" style="width: 100px" data-options="required:true,missingMessage:'请输入E6密码'">
					<br>
					<table id="dg3" style="width: 960px;"
						<p:isPrivilege pid="df" mid="dfe">
						data-options="onDblClickRow:function (row){
														    	readE6FileForView();
														    }"
						</p:isPrivilege>
					>
					</table>
				</div>
			</form>
		</div>
	</div>
	<!-- dialog上面dialog的按钮 -->
  	<div id="viewBb" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('viewDialog')">关闭</a>
	</div>
	
	
	<!-- 关联E6上的工具栏 -->
	<div id="gridToolBar3" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<p:isPrivilege pid="df" mid="dfe">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="readE6FileForView();" style="float: left;">阅读</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="df" mid="dff">
				<a href="#" class="easyui-linkbutton" plain="true" onclick="downLoadE6FileForView();" style="float: left;">下载</a><div class="btn-separator"></div>
			</p:isPrivilege>	
		</div>
	</div>
	
	<div id="menu3" class="easyui-menu" style="width: 80px; display: none;">
	    <p:isPrivilege pid="df" mid="dfe">
		    <div onclick="readE6FileForView();">阅读</div>
		</p:isPrivilege>
		<p:isPrivilege pid="df" mid="dff">
		    <div onclick="downLoadE6FileForView();">下载</div>
		</p:isPrivilege>
	</div>
	
	
	
	
	
	
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

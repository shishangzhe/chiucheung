<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>基础数据</title>
	<jsp:include page="/common.jsp"></jsp:include>
  </head>
  <style>
  	/* .noselect{
  		-moz-user-select: none; 
		cursor: default; 
  	} */
  </style>
  <script type="text/javascript">
  	var expnode = new Array();
  //让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
		$("#dialog11").dialog({//加载一个dialog
			closed:$("#dialog11").dialog("options").closed,
			left:($(document.body).width()-$("#dialog11").width())/2,
			top:($(document.body).height()-74-$("#dialog11").height())/2,
		});
		$("#dialog12").dialog({//加载一个dialog
			closed:$("#dialog12").dialog("options").closed,
			left:($(document.body).width()-$("#dialog12").width())/2,
			top:($(document.body).height()-74-$("#dialog12").height())/2,
		});
		
		proProcessIdResize();
		proProcessId2Resize();
	}
  
  	function proProcessIdResize(){
  		$('#proProcessId').combogrid('grid').datagrid('resize',{
			maxHeight:$(document.body).height()-($(document.body).height()-74-$("#dialog11").height())/2-60
		});
  	}
  	function proProcessId2Resize(){
		$('#proProcessId2').combogrid('grid').datagrid('resize',{
			maxHeight:$(document.body).height()-($(document.body).height()-74-$("#dialog12").height())/2-60
		});
  	}

	$(function () {
		//加载datagrid表格
		$("#dg1").treegrid({
			title:"生产工序表",//表格的标题
			fit:true,//当设置为true的时候面板大小将自适应父容器
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			singleSelect:true,
			/* ctrlSelect:true, */
		    url:"${pageContext.request.contextPath}/production/standard/findAllProProcessTechnologyList.action?parentProcessNumber=0",//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    treeField:'processNumber', 
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    columns:[[
						{title:'工序',colspan:7},
						{title:'工序工艺',colspan:2},
						{title:'工序工艺描述及时间',colspan:2}
			    ],[
					{field:'processNumber',title:'序号',width:100,align:'center',sortable:true},
					{field:'parentProcessNumber',title:'父序号',width:55,align:'center',sortable:true},
			        {field:'processName',title:'工序',width:80,align:'left',sortable:true},    
			        {field:'processCategory',title:'类别',width:95,align:'left',sortable:true},
			        {field:'machineGroupNumber',title:'机&组数',width:80,align:'center',sortable:true},
			        {field:'perMachineGroupPeopleNumber',title:'人数/(机&组)',width:90,align:'center',sortable:true},
			        {field:'calculationFormula',title:'计算公式',width:150,align:'left'},
			        {field:'technology',title:'工艺',width:120,align:'left'},
			        {field:'technologyIdentification',title:'工艺标识',width:60,align:'left'},
			        {field:'technologyDescription',title:'工艺说明',width:180,align:'left'},
			        {field:'technologyTime',title:'工艺时间',width:60,align:'center'}
			    ]],//表格的各个字段
		    toolbar: "#gridToolBar1",
		    onContextMenu: function(e, row) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).treegrid('clearSelections');
                if (row!=null){
                	$(this).treegrid("select", row.id); //根据索引选中该行
				}
                $("#menu1").menu('show', {//显示右键菜单
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
            },onBeforeExpand : function(row){
		    	//动态设置展开查询的url 
		    	var url = '';
		    	if (row.calculationFormula == ""){
		    		url = '${pageContext.request.contextPath}/production/standard/findAllProProcessTechnologyList.action?parentProcessNumber=' + row.processNumber;
		    	}else{
		    		url = '${pageContext.request.contextPath}/production/standard/findAllProProcessTechnologySubsidiaryListByProcessIdOrTechnologyBasicDataId.action?proProcessId=' + row.id;
		    	}
		    	 
                $(this).treegrid("options").url = url;
                if (expnode.indexOf(row.id) == -1){
                	expnode.push(row.id);
                }
                
                return true; 
            },onBeforeCollapse : function(row){
            	var i=expnode.indexOf(row.id);
                if(i>=0){
                    expnode.splice(i,1);
                }
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/production/standard/findAllProProcessTechnologyList.action?parentProcessNumber=0'; 
                $(this).treegrid("options").url = url;
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/production/standard/findAllProProcessTechnologyList.action?parentProcessNumber=0'; 
                $(this).treegrid("options").url = url;
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/production/standard/findAllProProcessTechnologyList.action?parentProcessNumber=0'; 
                $(this).treegrid("options").url = url;
                
                for (var i=0;i<expnode.length;i++){
                	$(this).treegrid('expand',expnode[i]);
                }
            }
		});
		var cmenu;//右键菜单，可以隐藏和显示列信息
		function createColumnMenu(){
			cmenu = $('<div/>').appendTo('body');
			var fields = $("#dg1").treegrid('getColumnFields');
			var nonHiddenCount = 0;//用来记录隐藏的item数
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						if (nonHiddenCount<fields.length-1){
							$("#dg1").treegrid('hideColumn', item.name);
							nonHiddenCount++;
							cmenu.menu('setIcon', {
								target: item.target,
								iconCls: 'icon-empty'
							});
						}
					} else {
						$("#dg1").treegrid('showColumn', item.name);
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
				var col = $("#dg1").treegrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
		
		
		//加载下拉的表格
		$('#proProcessId').combogrid({    
		    panelWidth:530,//下拉选框的宽度    
		    panelHeight:'auto',
		    idField:'id',//下列表的标识id    
		    textField:'processCategory',//下拉框文本显示的字段
		    //rownumbers:true,//显示行号,如果显示行号，下拉框会选择的时候，会自动跳到第一个选择的
		    remoteSort:false,//不从服务器进行排序
		    editable:false,//下拉框文本不可以编辑
		    toolbar: '#gridToolBar11',
		    columns:[[
						{field:'ck',title:'',checkbox:true},
						{field:'processNumber',title:'序号',width:45,align:'center',sortable:true},
						{field:'parentProcessNumber',title:'父序号',width:55,align:'center',sortable:true},
				        {field:'processName',title:'工序',width:100,align:'center',sortable:true},    
				        {field:'processCategory',title:'类别',width:120,align:'center',sortable:true},
				        {field:'machineGroupNumber',title:'机&组数',width:80,align:'center',sortable:true},
				        {field:'perMachineGroupPeopleNumber',title:'人数/(机&组)',width:80,align:'center',sortable:true}
				    ]],
		    onShowPanel:function(){//显示combogrid下拉框事件
		    	 proProcessIdResize();
		    	 $(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/production/standard/findAllProProcessList.action';
		    	 
		    	 $("#query11_form").form('clear');
		  		 
		  		 $(this).combogrid('grid').datagrid('load',{});//重新加载数据，加载的数据不包含dg2-1里的数据
		    },
			onHidePanel:function(){//隐藏combogrid下拉框的事件
				var g = $(this).combogrid('grid');	// 获取数据表格对象
				var selected = g.datagrid('getSelected');	// 获取选择的行
				if (selected != null){
					$("#proProcessId").combobox('setText',selected.processName + "-" + selected.processCategory);
				}
			}
		});
		
		//加载下拉的表格
		$('#proProcessId2').combogrid({    
		    panelWidth:530,//下拉选框的宽度    
		    panelHeight:'auto',
		    idField:'id',//下列表的标识id    
		    textField:'processCategory',//下拉框文本显示的字段
		    //rownumbers:true,//显示行号,如果显示行号，下拉框会选择的时候，会自动跳到第一个选择的
		    remoteSort:false,//不从服务器进行排序
		    editable:false,//下拉框文本不可以编辑
		    toolbar: '#gridToolBar12',
		    columns:[[
						{field:'ck',title:'',checkbox:true},
						{field:'processNumber',title:'序号',width:45,align:'center',sortable:true},
						{field:'parentProcessNumber',title:'父序号',width:55,align:'center',sortable:true},
				        {field:'processName',title:'工序',width:100,align:'center',sortable:true},    
				        {field:'processCategory',title:'类别',width:120,align:'center',sortable:true},
				        {field:'machineGroupNumber',title:'机&组数',width:80,align:'center',sortable:true},
				        {field:'perMachineGroupPeopleNumber',title:'人数/(机&组)',width:80,align:'center',sortable:true}
				    ]],
		    onShowPanel:function(){//显示combogrid下拉框事件
		    	 proProcessId2Resize();
		    	 $(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/production/standard/findAllProProcessList.action';
		    	 
		    	 $("#query12_form").form('clear');
		  		 
		  		 $(this).combogrid('grid').datagrid('load',{});//重新加载数据，加载的数据不包含dg2-1里的数据
		    },
			onHidePanel:function(){//隐藏combogrid下拉框的事件
				var g = $(this).combogrid('grid');	// 获取数据表格对象
				var selected = g.datagrid('getSelected');	// 获取选择的行
				if (selected != null){
					$("#proProcessId2").combobox('setText',selected.processName + "-" + selected.processCategory);
				}
			},
			onChange:function(newValue, oldValue){
				$('#proTechnologyBasicDataId').combobox('clear');
				$('#proTechnologyBasicDataId').combobox('reload','${pageContext.request.contextPath}/production/standard/findTechnologyListByProProcessId.action?id=' + newValue);  // 使用新的URL重新载入列表数据

			}
		});
		
		$('#proTechnologyBasicDataId').combobox({    
		    valueField:'id',    
		    textField:'technology'   
		});  

		
		
		//shift/ctrl多选的时，禁止选择文本
		/* var KEY = { SHIFT:16, CTRL:17, ALT:18, DOWN:40, RIGHT:39, UP:38, LEFT:37};
		document.onkeydown = function (event){
			if (event.keyCode == KEY.SHIFT || event.keyCode == KEY.CTRL){
				$("#processNumber_query").textbox('textbox').focus();
				$("#processNumber_query").textbox('textbox').blur();
				$("body").addClass("noselect");
				document.onselectstart=function(){return false;};
			}
		};
		document.onkeyup = function (event){
			if (event.keyCode == KEY.SHIFT || event.keyCode == KEY.CTRL){
				$("body").removeClass("noselect");
				document.onselectstart=function(){return true;};
			}
		}; */
		//form表单的回车事件，回车提交
		$("#form1").keyup(function (event){
			if (event.keyCode == 13){
				saveOrUpdateProcess();
			}
		});
		//form表单的回车事件，回车提交
		$("#form11").keyup(function (event){
			if (event.keyCode == 13){
				saveOrUpdateTechnology();
			}
		});
		$("#form12").keyup(function (event){
			if (event.keyCode == 13){
				saveOrUpdateTechnologyWorkHours();
			}
		});
		
		//工序搜索的回车事件
		$("#query1_form").keyup(function (event){
			if (event.keyCode == 13){
				query1();
			}
		});
		
		$("#query11_form").keyup(function (event){
			if (event.keyCode == 13){
				query11();
			}
		});
		$("#query12_form").keyup(function (event){
			if (event.keyCode == 13){
				query12();
			}
		});
	});
	
	
	
	
	//打开新增生产工序的dialog
	function addProcess(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增生产工序'//该dialog的标题
				});
				$("#flag1").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
	}
	//编辑
	function editData(){
		var selected = $("#dg1").treegrid('getSelected');//取得所有check选中的行，采用勾选才能进行操作，所以不能用getSelections
		
		if (selected!=null){//如果没有选中一行
			var url = "",dialog = "",title = "",form = "";
			if (selected.proProcessId != "" && selected.proTechnologyBasicDataId == ""){//表示选中的工艺
				url = "${pageContext.request.contextPath}/production/standard/findTechnologyById.action";//根据ID从后台取数据的url
				dialog = "#dialog11";
	    		title = "修改工艺";
	    		form = "#form11";
	    		$("#flag11").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
	    	}else if (selected.proTechnologyBasicDataId != ""){//表示选中的工艺时间
	    		url = "${pageContext.request.contextPath}/production/standard/findTechnologyWorkHoursById.action";//根据ID从后台取数据的url
	    		dialog = "#dialog12";
	    		title = "修改工艺工时";
	    		form = "#form12";
	    		$("#flag12").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
	    	}else if (selected.proProcessId == "" && selected.proTechnologyBasicDataId == ""){//表示选中的工序
	    		url = "${pageContext.request.contextPath}/production/standard/findProProcessById.action";//根据ID从后台取数据的url
	    		dialog = "#dialog1";
	    		title = "修改生产工序";
	    		form = "#form1";
	    		$("#flag1").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
	    	}
			
			$.ajax({
				type:'post',
				url:url,
				data:{id:selected.id},
				async: false,//同步请求
				cache: false,//不缓存此页面
				success:function(data){
					if (data.success){
						$(dialog).dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:title//该dialog的标题
						});
						$(form).form('load',data.data);
						
						if (selected.proProcessId != "" && selected.proTechnologyBasicDataId == ""){//表示选中的工艺
							$("#proProcessId").combobox('setText',data.data.process);
				    	}else if (selected.proTechnologyBasicDataId != ""){//表示选中的工艺时间
				    		$("#proProcessId2").combobox('setText',data.data.process);
				    	}
					}else{
						showMessager("错误",data.message);
					}
				}
			});
		}else{//如果只选中了一行
			showMessager("提示","请选择一条记录进行修改");
		}
		
	}
	//删除生产工序
  	function deleteData(){
  		var select = $("#dg1").treegrid("getSelected");
  		if (select != null){
  			var url = "";
  	  		if (select.proProcessId != "" && select.proTechnologyBasicDataId == ""){//表示选中的工艺
  	  			url = "${pageContext.request.contextPath}/production/standard/deleteTechnologyById.action";
  	    	}else if (select.proTechnologyBasicDataId != ""){//表示选中的工艺时间
  	    		url = "${pageContext.request.contextPath}/production/standard/deleteTechnologyWorkHoursById.action";
  	    	}else if (select.proProcessId == "" && select.proTechnologyBasicDataId == ""){//表示选中的工序
  	    		url = "${pageContext.request.contextPath}/production/standard/deleteProProcessById.action";
  	    	}
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: url,
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data.success){
								showMessager("提示","删除成功");
								$("#dg1").treegrid('reload');//重新加载数据，保持在当前页
								$("#dg1").treegrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误","<div style='color:red;align:center;width:100%;'>删除失败</div>"+data.message);
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
		}
  	}
	//刷新数据，并且保持在当前页面
	function reloadData(){
		$("#dg1").treegrid('reload');
	}
	//保存生产工序数据
	function saveOrUpdateProcess(){
		if ($("#form1").form('validate')){//判断 验证是否通过
			var flag = $("#flag1").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/production/standard/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveProProcess.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateProProcess.action";
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
						$("#dg1").treegrid('reload');//重新加载数据，保持在当前页
					}else{
						showMessager("错误",data.message);
					}
				}
			});
		}
	}
	//工序的查询数据
	function query1(){
  		$("#dg1").treegrid('load',$("#query1_form").serializeObject());
  	}
	
	
	function query11(){
  		$("#proProcessId").combogrid('grid').datagrid('load',$("#query11_form").serializeObject());
  	}
	
	function query12(){
  		$("#proProcessId2").combogrid('grid').datagrid('load',$("#query12_form").serializeObject());
  	}
	
	
	//新增工艺
	function addTechnology(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form11").form('reset');//重置表单数据
				var select = $("#dg1").treegrid("getSelected");
				if (select != null){//表示有选中一行
					if (select.proProcessId != "" && select.proTechnologyBasicDataId == ""){//表示选中的工艺
						$("#proProcessId").combogrid('setValue',select.proProcessId);
						$("#proProcessId").combobox('setText',select.process);
		        	}else if (select.proTechnologyBasicDataId != ""){//表示选中的工艺时间
		        		$("#proProcessId").combogrid('setValue',select.proProcessId);
		        		$("#proProcessId").combobox('setText',select.process);
		        	}else if (select.proProcessId == "" && select.proTechnologyBasicDataId == ""){//表示选中的工序
		        		$("#proProcessId").combogrid('setValue',select.id);
						$("#proProcessId").combobox('setText',select.process);
		        	}
				}
				
				$("#dialog11").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增工艺'//该dialog的标题
				});
				$("#flag11").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
	
	
	//保存修改工艺
	function saveOrUpdateTechnology(){
  		if ($("#form11").form('validate')){//判断 验证是否通过
			var flag11 = $("#flag11").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/production/standard/";
			if (flag11 == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveTechnology.action";
			}else if (flag11 == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateTechnology.action";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: $("#form11").serialize(),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						showMessager("提示","保存成功");
						$("#dialog11").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg1").treegrid('reload');
					}else{
						showMessager("错误",data);
					}
				}
			});
		}
  	}
	
	//新增工艺工时
	function addTechnologyWorkHours(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form12").form('reset');//重置表单数据
				var select = $("#dg1").treegrid("getSelected");
				if (select != null){//表示有选中一行
					if (select.proProcessId != "" && select.proTechnologyBasicDataId == ""){//表示选中的工艺
						$("#proProcessId2").combogrid('setValue',select.proProcessId);
						$("#proProcessId2").combobox('setText',select.process);
						$("#proTechnologyBasicDataId").combobox('setValue',select.id);
		        	}else if (select.proTechnologyBasicDataId != ""){//表示选中的工艺时间
		        		$("#proProcessId2").combogrid('setValue',select.proProcessId);
		        		$("#proProcessId2").combobox('setText',select.process);
		        		$("#proTechnologyBasicDataId").combobox('setValue',select.proTechnologyBasicDataId);
		        	}else if (select.proProcessId == "" && select.proTechnologyBasicDataId == ""){//表示选中的工序
		        		$("#proProcessId2").combogrid('setValue',select.id);
						$("#proProcessId2").combobox('setText',select.process);
		        	}
				}
				
				$("#dialog12").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增工艺工时'//该dialog的标题
				});
				$("#flag12").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
	
	//保存修改工艺
	function saveOrUpdateTechnologyWorkHours(){
  		if ($("#form12").form('validate')){//判断 验证是否通过
			var flag12 = $("#flag12").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/production/standard/";
			if (flag12 == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveTechnologyWorkHours.action";
			}else if (flag12 == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateTechnologyWorkHours.action";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: $("#form12").serialize(),//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						showMessager("提示","保存成功");
						$("#dialog12").dialog({//关闭这个dialog
							closed:true
						});
						$("#dg1").treegrid('reload');
					}else{
						showMessager("错误",data);
					}
				}
			});
		}
  	}
	
	
  </script>
  <body>
  		<table id="dg1" 
  			<p:isPrivilege pid="ab" mid="abb">
  				data-options="onDblClickRow: function(index, row){editData();}"
  			</p:isPrivilege>
  		>
  		
  		</table>
  		
  		<!-- 上面表格的toolbar按钮 -->
		<div id="gridToolBar1" style="padding:5px;height:auto">
			<div style="display:inline-block;">
				<p:isPrivilege pid="ab" mid="aba">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addProcess();" style="float: left;">新增工序</a><div class="btn-separator"></div>
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addTechnology();" style="float: left;">新增工艺</a><div class="btn-separator"></div>
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addTechnologyWorkHours();" style="float: left;">新增工艺工时</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="ab" mid="abb"> 
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editData();" style="float: left;">修改</a> <div class="btn-separator"></div>
				</p:isPrivilege>
				<p:isPrivilege pid="ab" mid="abc">
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteData();" style="float: left;">删除</a><div class="btn-separator"></div>
				</p:isPrivilege>
				<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onClick="reloadData();" >刷新</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onClick="expandAllNode('dg1');" style="float: left;">展开所有节点</a><div class="btn-separator"></div>
				<a href="#" class="easyui-linkbutton" iconCls="icon-no" plain="true" onClick="collapseAllNode('dg1');" style="float: left;">折叠所有节点</a><div class="btn-separator"></div>
			</div>
			<div>
				<form  id="query1_form">
					序号：<input id="processNumber_query" type="text" class="easyui-numberbox" name="processNumber" style="width: 30px">
					父序号：<input id="parentProcessNumber_query" type="text" class="easyui-numberbox" name="parentProcessNumber" style="width: 30px">
					工序：<input id="processName_query" type="text" class="easyui-textbox" name="processName" style="width: 60px" >
					类别：<input id="processCategory_query" type="text" class="easyui-textbox" name="processCategory" style="width: 60px" >
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query1()">查询</a>
				</form>
			</div>
		</div>
	  	<!-- 上面表格的右键菜单 -->
	  	<div id="menu1" class="easyui-menu" style="width: 80px; display: none;">
		    <!--放置一个隐藏的菜单Div-->
		    <p:isPrivilege pid="ab" mid="aba">
		    	<div data-options="iconCls:'icon-add'" onclick="addProcess();">新增工序</div>
		    	<div data-options="iconCls:'icon-add'" onclick="addTechnology();">新增工艺</div>
		    	<div data-options="iconCls:'icon-add'" onclick="addTechnologyWorkHours();">新增工艺工时</div>
	    	</p:isPrivilege>
		    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
		    <p:isPrivilege pid="ab" mid="abb">
		    	<div data-options="iconCls:'icon-edit'" onclick="editData();">修改</div>
		    </p:isPrivilege>
		    <p:isPrivilege pid="ab" mid="abc">
		    	<div data-options="iconCls:'icon-remove'" onclick="deleteData();">删除</div>
	    	</p:isPrivilege>
		    <div data-options="iconCls:'icon-reload'" onclick="reloadData();">刷新</div>
		    <div data-options="iconCls:'icon-ok'" onclick="expandAllNode('dg1')">展开所有节点</div>
		    <div data-options="iconCls:'icon-no'" onclick="collapseAllNode('dg1')">折叠所有节点</div>
		</div>
		
	  	<!-- 增&改的dialog -->
	  	<div id="dialog1" class="easyui-dialog" style="width: 300px;height: 330px;text-align: center;"
	  	data-options="closed: true,draggable:true,modal:true,buttons:'#bb1'">
	  		<form id="form1">
	  			<input id="flag1" type="hidden" value="">
	  			<input type="hidden" name="id" value="">
	  			<table style="border-spacing:10px;border-bottom: 0.5px;">
	  				<tr>
	  					<td style="text-align: right;">
	  						序号：
	  					</td>
	  					<td>
	  						<input type="text" name="processNumber" class="easyui-numberbox" data-options="required:true,missingMessage:'序号不能为空'">
	  					</td>
	  				</tr>
	  				<tr>
	  					<td style="text-align: right;">
	  						父序号：
	  					</td>
	  					<td>
	  						<input type="text" name="parentProcessNumber" class="easyui-numberbox" data-options="required:true,missingMessage:'父序号不能为空'">
	  					</td>
	  				</tr>
	  				<tr>
	  					<td style="text-align: right;">
	  						工序：
	  					</td>
	  					<td>
	  						<input type="text" name="processName" class="easyui-textbox" data-options="required:true,missingMessage:'工序不能为空'">
	  					</td>
	  				</tr>
	  				<tr>
	  					<td style="text-align: right;">
	  						类别：
	  					</td>
	  					<td>
	  						<input type="text" name="processCategory" class="easyui-textbox" data-options="required:true,missingMessage:'类别不能为空'">
	  					</td>
	  				</tr>
	  				<tr>
	  					<td style="text-align: right;">
	  						机&组数：
	  					</td>
	  					<td>
	  						<input type="text" name="machineGroupNumber" class="easyui-numberbox" data-options="required:true,missingMessage:'机&组数不能为空'">
	  					</td>
	  				</tr>
	  				<tr>
	  					<td style="text-align: right;">
	  						人数/(机&组)：
	  					</td>
	  					<td>
	  						<input type="text" name="perMachineGroupPeopleNumber" class="easyui-numberbox" data-options="required:true,missingMessage:'人数/(机&组)不能为空'">
	  					</td>
	  				</tr>
	  				<tr>
		  				<td style="text-align: right;">
		  					计算公式：
		  				</td>
			  			<td>
			  				<input id="calculationFormula" type="text" name="calculationFormula" class="easyui-textbox">
			  			</td>
		  			</tr>
	  			</table>
	  		</form>
	  	</div>
	  	<!-- dialog上面dialog的按钮 -->
	  	<div id="bb1" style="text-align: center;">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdateProcess()">保存</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
		</div>
		<!-- 增&改工艺的dialog -->
	  	<div id="dialog11" class="easyui-dialog" style="width: 300px;height: 190px;text-align: center;"
	  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb11'">
	  		<form id="form11">
	  			<input id="flag11" type="hidden" value="">
	  			<input type="hidden" name="id" value="">
	  			<table style="border-spacing:10px;border-bottom: 0.5px;">
	  				<tr>
	  					<td style="text-align: right;">
	  						工序：
	  					</td>
		  				<td>
			  				<input id="proProcessId" type="text" name="proProcessId" style="width: 180px;" data-options="required:true,missingMessage:'工序不能为空'">
			  			</td>
		  			</tr>
		  			<tr>
		  				<td style="text-align: right;">
		  					工艺：
		  				</td>
			  			<td>
			  				<input id="technology" type="text" name="technology" class="easyui-textbox" style="width: 180px;" data-options="required:true,missingMessage:'工艺不能为空'">
			  			</td>
		  			</tr>
		  			<tr>
		  				<td style="text-align: right;">
		  					工艺标识：
		  				</td>
			  			<td>
			  				<input id="technologyIdentification" type="text" name="technologyIdentification" class="easyui-textbox" style="width: 180px;">
			  			</td>
		  			</tr>
	  			</table>
	  		</form>
	  	</div>
	  	<!-- dialog上面dialog的按钮 -->
	  	<div id="bb11" style="text-align: center;">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdateTechnology()">保存</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog11')">关闭</a>
		</div>
		<div id="gridToolBar11" style="padding:5px;height:auto;">
			<div>
				<form  id="query11_form">
					序号：<input id="processNumber_query11" type="text" class="easyui-numberbox" name="processNumber" style="width: 30px">
					父序号：<input id="parentProcessNumber_query11" type="text" class="easyui-numberbox" name="parentProcessNumber" style="width: 60px" >
					工序：<input id="processName_query11" type="text" class="easyui-textbox" name="processName" style="width: 60px" >
					类别：<input id="processCategory_query11" type="text" class="easyui-textbox" name="processCategory" style="width: 60px" >
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query11()">查询</a>
				</form>
			</div>
		</div>
	
	<!-- 增&改工艺的dialog -->
	  	<div id="dialog12" class="easyui-dialog" style="width: 320px;height: 230px;text-align: center;"
	  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb12'">
	  		<form id="form12">
	  			<input id="flag12" type="hidden" value="">
	  			<input type="hidden" name="id" value="">
	  			<table style="border-spacing:10px;border-bottom: 0.5px;">
	  				<tr>
	  					<td>
	  						工序：
	  					</td>
		  				<td>
			  				<input id="proProcessId2" type="text" name="proProcessId" style="width: 180px;" data-options="required:true,missingMessage:'工序不能为空'">
			  			</td>
		  			</tr>
		  			<tr>
		  				<td>
		  					工艺：
		  				</td>
			  			<td>
			  				<input id="proTechnologyBasicDataId" type="text" name="proTechnologyBasicDataId" style="width: 180px;" data-options="required:true,missingMessage:'工艺不能为空',editable:false">
			  			</td>
		  			</tr>
		  			<tr>
		  				<td>
		  					工艺说明：
		  				</td>
			  			<td>
			  				<input id="technologyDescription" type="text" name="technologyDescription" class="easyui-textbox" style="width: 180px;" data-options="required:true,missingMessage:'工艺说明不能为空'">
			  			</td>
		  			</tr>
		  			<tr>
		  				<td>
		  					工艺工时：
		  				</td>
			  			<td>
			  				<input id=technologyTime type="text" name="technologyTime" class="easyui-numberbox" style="width: 180px;" data-options="required:true,missingMessage:'工艺工时不能为空'">
			  			</td>
		  			</tr>
	  			</table>
	  		</form>
	  	</div>
	  	<!-- dialog上面dialog的按钮 -->
	  	<div id="bb12" style="text-align: center;">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdateTechnologyWorkHours()">保存</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog12')">关闭</a>
		</div>
		<div id="gridToolBar12" style="padding:5px;height:auto;">
			<div>
				<form  id="query12_form">
					序号：<input id="processNumber_query12" type="text" class="easyui-numberbox" name="processNumber" style="width: 30px">
					父序号：<input id="parentProcessNumber_query11" type="text" class="easyui-numberbox" name="parentProcessNumber" style="width: 60px" >
					工序：<input id="processName_query12" type="text" class="easyui-textbox" name="processName" style="width: 60px" >
					类别：<input id="processCategory_query12" type="text" class="easyui-textbox" name="processCategory" style="width: 60px" >
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query12()">查询</a>
				</form>
			</div>
		</div>
  </body>
  <style>
	/* 定义样式区分select和check： */
	/* 复选框选中行的颜色的颜色，设置为透明 */
	/* .datagrid-row-selected{
	background:transparent url('../../themes/default/images/ui-bg_glass_80_d7ebf9_1x400.png') repeat-x 50% 50%;
		color:#000;
	} */
	/* 鼠标点击行，选中行的颜色为蓝色 */
	/* .datagrid-row-click{
		background:#3baae3 url('../../themes/default/images/ui-bg_glass_50_3baae3_1x400.png') repeat-x 50% 50%;
		color:#fff;
	} */
	/* .datagrid-row-selected {
	  background: #3baae3 !important;;
	  color: #fff !important;;
	} */
  </style>
</html>

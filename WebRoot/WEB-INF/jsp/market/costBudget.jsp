<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>物料</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
  	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:0,
			top:0
		});
		if ($(document.body).width()<$("#dialog2").width()){
			if ($(document.body).height()<$("#dialog2").height()){
				$("#dialog2").dialog({
					closed:$("#dialog2").dialog("options").closed,
					width: $(document.body).width(),
					height:$(document.body).height(),
					left:($(document.body).width()-$("#dialog2").width())/2,
					top:0
				});
			}else{
				$("#dialog2").dialog({
					closed:$("#dialog2").dialog("options").closed,
					width: $(document.body).width(),
					height:600,
					left:($(document.body).width()-$("#dialog2").width())/2,
					top:($(document.body).height()-74-$("#dialog2").height())/2,
				});
			}
		}else{
			if ($(document.body).height()<$("#dialog2").height()){
				$("#dialog2").dialog({
					closed:$("#dialog2").dialog("options").closed,
					width: 800,
					height:$(document.body).height(),
					left:($(document.body).width()-$("#dialog2").width())/2,
					top:0
				});
			}else{
				$("#dialog2").dialog({
					closed:$("#dialog2").dialog("options").closed,
					width:800,
					height:600,
					left:($(document.body).width()-$("#dialog2").width())/2,
					top:($(document.body).height()-74-$("#dialog2").height())/2,
				});
			}
		}
		$("#dialog2").dialog({//加载一个dialog
			closed:$("#dialog2").dialog("options").closed,
			left:($(document.body).width()-$("#dialog2").width())/2,
			top:($(document.body).height()-74-$("#dialog2").height())/2,
		});
		$("#dialog3").dialog({//加载一个dialog
			closed:$("#dialog3").dialog("options").closed,
			left:($(document.body).width()-$("#dialog3").width())/2,
			top:($(document.body).height()-74-$("#dialog3").height())/2,
		});
	}
  
  	$(function(){
		//加载datagrid表格
		$("#dg").datagrid({
			title:'成本分析表',//表格的标题
			fit:true,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
			pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    url:'${pageContext.request.contextPath}/market/costBudget/findAllCostBudgetList.action',//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:[[
						{field:'theme',title:'主题',width:100,align:'center',sortable:true},
						{field:'customerName',title:'客户名称',width:100,align:'center',sortable:true},
						{field:'productName',title:'项目名称',width:100,align:'center',sortable:true},
						{field:'description',title:'描述',width:100,align:'center',sortable:true},
						{field:'peripheralSize',title:'外围尺寸',width:65,align:'center',sortable:true},
						{field:'calculate',title:'精算/估算',width:70,align:'center',sortable:true,formatter: function(value,row,index){
																								if (value != null){
																									if (value){
																										return '精算';
																									}else{
																										return '估算';
																									}
																								}
																							}
						},
						{field:'beginTime',title:'开始时间',width:50,align:'center',sortable:true},
						{field:'submitTime',title:'提交时间',width:50,align:'center',sortable:true},
						{field:'unitPrice',title:'单价',width:50,align:'center',sortable:true},
						{field:'totalNumber',title:'总套数',width:30,align:'center',sortable:true},
						{field:'totalPrice',title:'总价',width:50,align:'center',sortable:true},
						{field:'preparer',title:'制表人',width:50,align:'center',sortable:true},
						{field:'salReviewerId',title:'是否关联',width:50,align:'center',sortable:true,formatter: function(value,row,index){
							if (value != ""){
								return '<img alt="" src="${pageContext.request.contextPath }/jquery-easyui-1.4.5/themes/icons/ok.png">';
							}
						}},
				      ]],//表格的各个字段
		    toolbar: '#gridToolBar',
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
				var col = $("#dg").datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
		
		
		$("#dg2").datagrid({
			//fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
		   	idField:'id',//指明哪一个字段是标识字段。
		    rownumbers:true,//显示一个行号列。
		    showFooter:true,//显示行脚。
		    columns:[[	
						{field:'componentName',title:'配件/部件名称',width:180,align:'center',rowspan:2,editor:{
							type:'textbox',
							options:{
								required:true,
								missingMessage:'配件/部件名称不能为空'
							}
						}},
						{field:'materialType',title:'物料类型',width:70,align:'center',rowspan:2,sortable:true},
						{field:'materialName',title:'物料名称',width:100,align:'center',rowspan:2},
						{title:'每件原料尺寸规格',colspan:5},
						{title:'总用量',colspan:3},
						{title:'单价',colspan:2},
						
						{field:'purchasedComponentsSubtotal',title:'外购件小计<br>(￥)',width:90,align:'center',rowspan:2,editor:{
				        	type:'textbox',
				        	options:{
				        		editable:false
				        	}
				        }},
						{field:'materialSubtotal',title:'物料小计<br>(￥)',width:90,align:'center',rowspan:2,editor:{
				        	type:'textbox',
				        	options:{
				        		editable:false
				        	}
				        }},
						{field:'remark',title:'备注',width:150,align:'center',rowspan:2,editor:{
				        	type:'textbox',
				        }},
				    ],[
						{field:'model',title:'材种',width:100,align:'center'},
						{field:'thick',title:'厚(mm)',width:65,align:'center',sortable:true},
						{field:'length',title:'长(mm)',width:65,align:'center'},
						{field:'width',title:'宽(mm)',width:65,align:'center'},
						{field:'weight',title:'重量(KG)',width:70,align:'center'},
						
						{field:'quantity',title:'数量',width:70,align:'center',editor:{
				        	type:'textbox',
				        	options:{
				        		required:true,
				        		missingMessage:'数量不能为空',
				        		validType:'checkTimes'
				        	}
				        }},
						{field:'unit',title:'单位',width:50,align:'center'},
						{field:'totalWeight',title:'重量(KG)',width:70,align:'center',editor:{
				        	type:'textbox',
				        	options:{
				        		editable:false
				        	}
				        }},
						
						{field:'unitPrice',title:'(￥)',width:50,align:'center'},
						{field:'unit',title:'单位',width:50,align:'center'},
				      ]],//表格的各个字段
		    toolbar: '#gridToolBar2',
		    onSortColumn:function(sort, order){
		    	if (!$('#dg2').datagrid('options').remoteSort){//如果为false，表示从本地排序，表示开启了排序
			    	$('#dg2').datagrid('enableDnd');//排序后又会禁用拖放，所以需要在这里在此开启拖放
		    	}
		    }
		});
		
		$("#dg3").datagrid({
			//fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
		   	idField:'id',//指明哪一个字段是标识字段。
		   	showHeader:false,
		   	showFooter:true,//显示行脚。
		    columns:[[	
						{field:'rowindex',title:'rownumbers',width:30,align:'center'},
						{field:'DText',title:'配件/部件名称',width:180,align:'right',styler: function(value,row,index){
																								if (index == 6){
																									return 'background-color:#99ccff;';
																								}else if (index == 7){
																									return 'background-color:#ffcc99';
																								}
																							}
						},
						{field:'DValue',title:'物料类型',width:70,align:'center',styler: function(value,row,index){
																							if (index == 6){
																								return 'background-color:#99ccff;';
																							}else if (index == 7){
																								return 'background-color:#ffcc99';
																							}
																						}
						},
						{field:'materialType',title:'物料名称',width:100,align:'center'},
						{field:'model',title:'材种',width:100,align:'center'},
						{field:'CText',title:'宽(mm)',width:195,align:'right'},
						{field:'CValue',title:'重量(KG)',width:70,align:'center'},
						{field:'BText',title:'重量(KG)',width:190,align:'right'},
						{field:'BValue',title:'单位',width:100,align:'center'},
						{field:'AText',title:'外购件小计(￥)',width:90,align:'right'},
						{field:'AValue',title:'物料小计(￥)',width:90,align:'center'},
						{field:'remark',title:'备注',width:150,align:'center'},
				    ]]
		});
		
		$("#dg3").datagrid('loadData',[
		                               {DText:'<b>D</b> 营销费12.5%（x值）：',DValue:0,CText:'<b>C</b>皮费百分率(10%)：',CValue:0,BText:'<b>B1</b>生产工费(工时x工价)：',BValue:'',AText:'<b>A1</b> 物料小计：',AValue:0},
		                               {DText:'<b>E</b> 毛利 18%（x值）：',DValue:0,CText:'值(<b>A1</b>/)：',CValue:0,BText:'<b>B2</b>工费百分率(%)：',BValue:0,AText:'值(<b>A1</b>/)：',AValue:0},
		                               {DText:'<b>A+B+C+D+E=F</b>总和：',DValue:0,BText:'值(<b>A1</b>/)：',BValue:0,AText:'<b>A2</b> 包装材料：',AValue:0},
		                               {DText:'<b>G</b> 增值税17%（Fx17%）：',DValue:0,BText:'<b>B3</b>难度补偿：',BValue:0,AText:'<b>A3</b> 外购件小计：',AValue:0},
		                               {DText:'<b>H</b>标准件小计：',DValue:0,CText:'其他：',CValue:'',BText:'<b>B4</b>工程费百分率：',BValue:0,AText:'<b>A4</b> 外发总费：',AValue:0},
		                               {BText:'<b>B5</b>增量附加：',BValue:0},
		                               {DText:'<b>--1套底线价I：</b>',DValue:0,CText:'<b>C</b> 总费用：',CValue:0,BText:'<b>B</b> 总工费：',BValue:0,AText:'<b>A</b> 总费用：',AValue:0},
		                               ]);
		
		
		//加载下拉的表格
		$('#material').combogrid({
		    idField:'id',//下列表的标识id    
		    textField:'materialName',//下拉框文本显示的字段
		    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
		    multiple:true,//允许多选
		    editable:false,//下拉框文本不可以编辑
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    toolbar:'#gridToolBar3',
		    columns:[[	{field:'ck',checkbox:true},
						{field:'materialType',title:'物料类型',width:70,align:'center',sortable:true},
						{field:'materialCategory',title:'物料类别',width:70,align:'center',sortable:true},
						{field:'materialName',title:'物料名称',width:100,align:'center',sortable:true},
						{field:'specification',title:'规格',width:100,align:'center',sortable:true},
						{field:'model',title:'材种/型号',width:100,align:'center',sortable:true},
						{field:'area',title:'横切面积(mm²)',width:105,align:'center',sortable:true},
						{field:'thick',title:'厚(mm)',width:65,align:'center',sortable:true},
						{field:'length',title:'长(mm)',width:65,align:'center',sortable:true},
						{field:'width',title:'宽(mm)',width:65,align:'center',sortable:true},
						{field:'density',title:'比重',width:50,align:'center',sortable:true},
						{field:'weight',title:'重量(KG)',width:70,align:'center',sortable:true},
						{field:'kgPrice',title:'公斤单价(元)',width:90,align:'center',sortable:true},
						{field:'unitPrice',title:'单位单价(元)',width:90,align:'center',sortable:true},
				        {field:'unit',title:'单位',width:50,align:'center',sortable:true,editor:{type:'textbox'}},
				        {field:'supplier',title:'供应商',width:80,align:'center',sortable:true,editor:{type:'textbox'}},
				        {field:'usingRange',title:'使用范围',width:150,align:'center',sortable:true,editor:{type:'textbox'}},
						{field:'remark',title:'备注',width:150,align:'center',sortable:true,editor:{type:'textbox'}},
				    ]],//表格的各个字段
					fitColumns: true,
		    onShowPanel:function(){//显示combogrid下拉框事件
		    	$(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/market/costBudget/findAllPurMaterialList.action';
				$(this).combogrid('grid').datagrid('load');//重新加载数据，否则下面隐藏方法给表格添加表格含有相同数据的时候，无法开启表格的编辑
		    },
			onHidePanel:function(){//隐藏combogrid下拉框的事件
				var g = $('#material').combogrid('grid');	// 获取数据表格对象
				var check = g.datagrid('getSelections');	// 获取选择的行
				for (var i=0;i<check.length;i++){
					if (check[i].materialType == '原材料' && check[i].materialCategory != '油漆' && check[i].materialCategory != '粉'){
						var unitPrice = numberToFixed(check[i].unitPrice*1.05);
						check[i].unitPrice = unitPrice;
					}
					
					$("#dg2").datagrid('appendRow',check[i]);//追加数据到dg2-1的表格中
					var index = $("#dg2").datagrid('getRowIndex',check[i]);
					$("#dg2").datagrid('beginEdit',index);//该行开启编辑
					var ed = $('#dg2').datagrid('getEditors', index);//获取行的所有编辑器
					ed[1].target.textbox('textbox').bind('input propertychange', function() { 
						calculate(this); 
					});
				}
				$("#material").combogrid('setText');//清空选择的值
				g.datagrid('clearSelections');
			}
		});
		
		
		$("#reviewerCostDg").datagrid({
			//width:250,//表格的宽度
			fit:true,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			remoteSort:true,//不从服务器进行排序
			//pagination:true,
		    idField:'id',//指明哪一个字段是标识字段。
		    rownumbers:true,//显示一个行号列。
		    singleSelect:true,
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    toolbar: '#reviewerCostGridToolBar',
		    columns:[[	
		              	{field:'quotationNo',title:'Q编号',width:100,align:'center',sortable:true},
						{field:'createTime',title:'评审日期',width:80,align:'center',sortable:true},
				        {field:'projectLeader',title:'项目负责人',width:80,align:'center',sortable:true},
				        {field:'salPreparer',title:'制表人',width:70,align:'center',sortable:true},
				    ]]
		});
		
		
		$("#productName").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		$("#rawMaterial").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		$("#difficulty").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		$("#engCost").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		$("#additional").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		$("#packaging").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		$("#totalNumber").textbox('textbox').bind('input propertychange', function() { 
			calculate(); 
		});
		
		//form查询表单的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		//form查询表单的回车事件，回车提交
		$("#queryForm2").keyup(function (event){
			if (event.keyCode == 13){
				query2();
			}
		});
		//form查询表单的回车事件，回车提交
		$("#reviewerCostQueryForm").keyup(function (event){
			if (event.keyCode == 13){
				queryReviewerCost();
			}
		});

		
  	});
  	

  	//新增成本核算表
  	function add(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
		  		$("#salReviewerId").val("");//因为上面的清空表单数据无法清空这个hidden的input，但是id不需要清空是因为，后台会重新生成一个id
		  		$("#dg2").datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
		  		$("#dg3").datagrid('loadData',[
		  				                               {DText:'<b>D</b> 营销费12.5%（x值）：',DValue:0,CText:'<b>C</b>皮费百分率(10%)：',CValue:0,BText:'<b>B1</b>生产工费(工时x工价)：',BValue:'',AText:'<b>A1</b> 物料小计：',AValue:0},
		  				                               {DText:'<b>E</b> 毛利 18%（x值）：',DValue:0,CText:'值(<b>A1</b>/)：',CValue:0,BText:'<b>B2</b>工费百分率(%)：',BValue:0,AText:'值(<b>A1</b>/)：',AValue:0},
		  				                               {DText:'<b>A+B+C+D+E=F</b>总和：',DValue:0,BText:'值(<b>A1</b>/)：',BValue:0,AText:'<b>A2</b> 包装材料：',AValue:0},
		  				                               {DText:'<b>G</b> 增值税17%（Fx17%）：',DValue:0,BText:'<b>B3</b>难度补偿：',BValue:0,AText:'<b>A3</b> 外购件小计：',AValue:0},
		  				                               {DText:'<b>H</b>标准件小计：',DValue:0,CText:'其他：',CValue:'',BText:'<b>B4</b>工程费百分率：',BValue:0,AText:'<b>A4</b> 外发总费：',AValue:0},
		  				                               {BText:'<b>B5</b>增量附加：',BValue:0},
		  				                               {DText:'<b>--1套底线价I：</b>',DValue:0,CText:'<b>C</b> 总费用：',CValue:0,BText:'<b>B</b> 总工费：',BValue:0,AText:'<b>A</b> 总费用：',AValue:0},
		  				                               ]);
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增成本分析表'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	
  //打开编辑操作
  	function edit(){
  		$("#form1").form('reset');//重置表单数据
  		$("#dg2").datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var url = "${pageContext.request.contextPath}/market/costBudget/findCostBudgetByIdForEdit.action";//根据ID从后台取数据的url
			$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$("#form1").form('reset');//重置表单数据
			var data = "id=" + select.id;
			$.ajax({
				type:'post',
				url:url,
				data:data,
				async: false,//同步请求
				cache: false,//不缓存此页面
				success:function(data){
					if (data != null && data != ""){
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:"修改成本分析表"//该dialog的标题
						});
						$("#form1").form('load',data.costBudget);
						
						$("#dg2").datagrid('loadData',data.materials);
						for (var i=0;i<data.materials.length;i++){//将所有可编辑框打开,data.list.total获取数据的总记录数
							$("#dg2").datagrid('beginEdit',i);
							var ed = $('#dg2').datagrid('getEditors', i);//获取行的所有编辑器
							calculate(ed[1].target.textbox('textbox'));
							ed[1].target.textbox('textbox').bind('input propertychange', function() { 
								calculate(this); 
							});
						}
					}
				}
			});
  		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
  	}
  	
  	
  	function save(){
  		if ($("#form1").form('validate')){//判断 验证是否通过
  			var dg2Rows = $('#dg2').datagrid('getRows');//获取所有的行
  			if (dg2Rows!=null && dg2Rows.length>0){
				for (var i=0;i<dg2Rows.length;i++){//将所有可编辑框结束，否则无法传值
					$("#dg2").datagrid('endEdit',i);
					dg2Rows[i].number=i;
				}
				var dg2Rows = JSON.stringify(dg2Rows);//获取所有的行,并将选中的数据转换成json字符串
				var formData = $("#form1").serializeObject();
				var dg3Rows = $('#dg3').datagrid('getRows');//获取所有的行
				var unitPrice = dg3Rows[6].DValue;
				formData.unitPrice = unitPrice;
				var totalPrice = dg3Rows[7].DValue;
				formData.totalPrice = totalPrice;
				formData = JSON.stringify(formData);
				var datas = "{costBudget:"+formData+",materials:"+dg2Rows+""+"}";
				
				var flag = $("#flag").val();//获取标识符，
				var url = "${pageContext.request.contextPath}/market/costBudget/";
				if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
					url = url + "saveCostBudget.action";
				}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
					url = url + "updateCostBudget.action";
				}
				$.ajax({
					type:'POST',//post请求
					url: url,//ajax请求的url
					data: datas,//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					contentType: 'application/json;charset=utf-8',
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data == '保存成功'){
							showMessager("提示",data);
							$("#dialog1").dialog({//关闭这个dialog
								closed:true
							});
							$("#dg").datagrid('reload');//重新加载数据，保持在当前页
						}else{
							showMessager("错误",data);
							var dg2Rows = $('#dg2').datagrid('getRows');//获取所有的行
							for (var i=0;i<dg2Rows.length;i++){//将所有开启编辑
								$("#dg2").datagrid('beginEdit',i);
							}
						}
					}
				});
  			}else{
  				showMessager("提示","请至少添加一行物料数据");
  			}
		}
  	}
  	
  	function removeData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/market/costBudget/deleteCostBudgetById.action",//ajax请求的url
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
  	
  	//复制数据
  	function copyData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '需要更新物料数据吗？', function(b){//给用户一个删除几条信息的确认提示框
  				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/market/costBudget/findCostBudgetByIdForCopyData.action",//ajax请求的url
					data: {id:select.id,flag:b},//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							$("#form1").form('reset');//重置表单数据
					  		$("#salReviewerId").val("");//因为上面的清空表单数据无法清空这个hidden的input，但是id不需要清空是因为，后台会重新生成一个id
					  		$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
							$("#dialog1").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:"新增成本分析表"//该dialog的标题
							});
							delete data.costBudget.preparer
							$("#form1").form('load',data.costBudget);
							
							$("#dg2").datagrid('loadData',data.materials);
							for (var i=0;i<data.materials.length;i++){//将所有可编辑框打开,data.list.total获取数据的总记录数
								$("#dg2").datagrid('beginEdit',i);
								var ed = $('#dg2').datagrid('getEditors', i);//获取行的所有编辑器
								calculate(ed[1].target.textbox('textbox'));
								ed[1].target.textbox('textbox').bind('input propertychange', function() { 
									calculate(this); 
								});
							}
						}
					}
				});
  			});
  		}else{
  			showMessager("提示","请选择一条记录进行复制");
  		}
  	}
  	
  	//关联显示项目评审表的数据
  	function showCompleteReviewerCostCollect(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.ajax({
  				type:'POST',//post请求
  				url: "${pageContext.request.contextPath}/market/costBudget/findCostBudgetByIdForAssociated.action",//ajax请求的url
  				data: {id:select.id},//传的参数
  				async: false,//同步请求
  				cache: false,//不缓存此页面
  				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
  					if (data != null && data != ""){
  						if (data.salReviewerId == ""){
  							$("#costBudgetId").val(select.id);
  					  		var url = '${pageContext.request.contextPath}/market/costBudget/findCompleteReviewerCostCollect.action'; 
  				        	$('#reviewerCostDg').datagrid('options').url = url;
  				        	$('#reviewerCostDg').datagrid('reload');
  				        	$('#reviewerCostDg').datagrid('unselectAll');
  					  		$("#dialog2").dialog({//加载一个dialog
  								closed:false,//将该dialog的状态由不显示改成显示
  								title:'项目评审表（已评审完成）'//该dialog的标题
  							});
  						}else{
  							showMessager("提示","已经关联了项目评审表，请取消关联后再重新关联");
  						}
  					}
  				}
  			});
  		}else{
  			showMessager("提示","请选择一条记录进行关联");
  		}
  	}
  	
  	//关联
  	function associated(){
  		var select = $("#reviewerCostDg").datagrid("getSelected");
  		var id = $("#costBudgetId").val();
  		if (select != null){
  			$.ajax({
  				type:'POST',//post请求
  				url: "${pageContext.request.contextPath}/market/costBudget/associatedCostBudgetById.action",//ajax请求的url
  				data: {id:id,salReviewerId:select.id},//传的参数
  				async: false,//同步请求
  				cache: false,//不缓存此页面
  				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
  					if (data == '关联成功'){
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
  		}else{
  			showMessager("提示","请选择一条记录进行关联");
  		}
  	}
  	
  	//取消关联
  	function cancelAssociated(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要取消关联吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/market/costBudget/cancelAssociatedCostBudgetById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data == '取消关联成功'){
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
			showMessager("提示","请选择一条记录进行取消关联");
		}
  	}
  	
  	//选择导出的时间
  	function chooseDate(){
  		$("#exportingReportForm").form('reset');
  		$("#dialog3").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:'请选择导出的日期'//该dialog的标题
		});
  	}
  	
  	//导出excel报表
  	function exportingReport(){
  		$("#exportingReportForm").submit();
  		$("#dialog3").dialog({//加载一个dialog
			closed:true,//将该dialog的状态由不显示改成显示
		});
  	}
  	
  	//刷新数据
  	function reload(){
  		$("#dg").datagrid('reload');
  	}
  	//查询数据
  	function query(){
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());//重新加载数据
		$("#dg").datagrid('clearSelections');//清除所有选择的行
  	}
  	//查询数据
  	function query2(){
  		$("#material").combogrid('grid').datagrid('load',$("#queryForm2").serializeObject());//重新加载数据
		$("#material").combogrid('grid').datagrid('clearSelections');//清除所有选择的行
  	}
	
  	//查询数据
  	function queryReviewerCost(){
  		$("#reviewerCostDg").datagrid('load',$("#reviewerCostQueryForm").serializeObject());//重新加载数据
		$("#reviewerCostDg").datagrid('clearSelections');//清除所有选择的行
  	}
  	
  	//原材料的计算
  	function calculate(obj){
  		var rows = $("#dg2").datagrid("getRows");
  		
  		var AText2 = "值(<b>A1</b>/)：";
  		var BText2 = "<b>B2</b>工费百分率(%)：";
  		var BText3 = "值(<b>A1</b>/)：";
  		var BText4 = "<b>B3</b>难度补偿：";
  		var BText5 = "<b>B4</b>工程费百分率：";
  		var BText6 = "<b>B5</b>增量附加：";
  		var CText2 = "值(<b>A1</b>/)：";
  		var DText7 = "<b>--1套底线价I：</b>";
  		var DText8 = "";
  		
  		var productName = $("#productName").textbox('getText');
  		var rawMaterial = $("#rawMaterial").textbox('getText');
  		var difficulty = $("#difficulty").textbox('getText');
  		var engCost = $("#engCost").textbox('getText');
  		var additional = $("#additional").textbox('getText');
  		var packaging = $("#packaging").textbox('getText');
  		var totalNumber = $("#totalNumber").textbox('getText');
  		
  		var AValue1 = 0;
  		var AValue2 = 0;
  		var AValue3 = 0;
  		var AValue4 = 0;
  		var AValue5 = 0;
  		var AValue7 = 0;
  		
  		var BValue1 = 0;
  		var BValue2 = 0;
  		var BValue3 = 0;
  		var BValue4 = 0;
  		var BValue5 = 0;
  		var BValue6 = 0;
  		var BValue7 = 0;
  		
  		var CValue1 = 0;
  		var CValue2 = 0;
  		var CValue5 = 0;
  		var CValue7 = 0;
  		
  		var DValue1 = 0;
  		var DValue2 = 0;
  		var DValue3 = 0;
  		var DValue4 = 0;
  		var DValue5 = 0;
  		var DValue7 = 0;
  		var DValue8 = "";
  		
  		if (obj){//dg2表格的编辑数量改变
  			var td = $(obj).parent().parent().parent().parent().parent().parent().parent().parent();
  			var index = td.attr("datagrid-row-index");//获取到当前改变的index索引
  			var ed = $('#dg2').datagrid('getEditors', index);//获取行的所有编辑器
			if (ed[1].target.textbox('isValid')){//当前编辑的数量通过验证
	  			var materialType = rows[index].materialType;//获取当前改变行的类型
	  			var unitPrice = rows[index].unitPrice;//获取单位单价
	  			var quantity = $(obj).val();//获取单位数量
	  			var weight = rows[index].weight;//获取单位重量
	  			var subtotal = numberToFixed(quantity*unitPrice);//计算当前的行的总价
	  			var totalWeight = numberToFixed(quantity*weight);//计算当前的行的总重量
	  			var ed = $('#dg2').datagrid('getEditors', index);//获取行的所有编辑器
	  			if (materialType == '原材料'){//根据不同的物料类型，赋值到不同的类型小计里
	  	  			ed[2].target.textbox('setText',totalWeight);
	  	  			ed[4].target.textbox('setText',subtotal);
	  	  		}else{
	  	  			ed[3].target.textbox('setText',subtotal);
	  	  		}
			}else{//当前编辑的数量不通过验证
				ed[2].target.textbox('setText','');
  	  			ed[3].target.textbox('setText','');
  	  			ed[4].target.textbox('setText','');
			}
  		}
  		
  		//开始计算dg3的数据
	  	for (var i=0;i<rows.length;i++){
	  		var ed = $('#dg2').datagrid('getEditors', i);//获取行的所有编辑器
	  		if (ed.length > 0){
		  		AValue1 = numberToFixed( (ed[4].target.textbox("getText")==''?0:ed[4].target.textbox("getText"))*1 + AValue1*1 );
	  		}else{
	  			AValue1 = numberToFixed( (rows[i].materialSubtotal==''?0:rows[i].materialSubtotal)*1 + AValue1*1 );
	  		}
	  	}
	  	
  		if (productName != ''){
  			DText7 = "<b>" + productName + "--1套底线价H：</b>";
  		}
  		
	  	if ($('#rawMaterial').textbox('isValid')){//表示通过验证
	  		AText2 = "值(<b>A1</b>/" + rawMaterial + ")：";
	  		BText2 = "<b>B2</b>工费百分率(" + (55-rawMaterial) + "%)：";
	  		BText3 = "值(<b>A1</b>/" + rawMaterial + ")：";
  			CText2 = "值(<b>A1</b>/" + rawMaterial + ")：";
  			
	  		AValue2 = numberToFixed(AValue1/rawMaterial);
	  		BValue2 = numberToFixed(AValue2*(55-rawMaterial));
	  		BValue3 = numberToFixed(AValue1/rawMaterial);
	  		CValue2 = numberToFixed(AValue1/rawMaterial);
	  	}
	  	
	  	if ($('#packaging').textbox('isValid')){//表示通过验证
  			AValue3 = packaging;
	  	}
  		
  		for (var i=0;i<rows.length;i++){
  			var ed = $('#dg2').datagrid('getEditors', i);//获取行的所有编辑器
  			if (ed.length > 0){
	  			if (rows[i].materialType == '外购件'){
		 	  		AValue4 = numberToFixed(((ed[3].target.textbox("getText")==''?0:ed[3].target.textbox("getText"))*1.05 + AValue4));
	  			}else if (rows[i].materialType == '标准件'){
	  				DValue5 = numberToFixed((ed[3].target.textbox("getText")==''?0:ed[3].target.textbox("getText"))*1 + DValue5);
	  			}else if (rows[i].materialType == '外发'){
	  				AValue5 = numberToFixed((ed[3].target.textbox("getText")==''?0:ed[3].target.textbox("getText"))*1 + AValue5);
	  			}
  			}else {
  				if (rows[i].materialType == '外购件'){
		 	  		AValue4 = numberToFixed(( (rows[i].purchasedComponentsSubtotal==''?0:rows[i].purchasedComponentsSubtotal)*1.05 + AValue4 ));
	  			}else if (rows[i].materialType == '标准件'){
	  				DValue5 = numberToFixed( (rows[i].purchasedComponentsSubtotal==''?0:rows[i].purchasedComponentsSubtotal)*1 + DValue5 );
	  			}else if (rows[i].materialType == '外发'){
	  				AValue5 = numberToFixed( (rows[i].purchasedComponentsSubtotal==''?0:rows[i].purchasedComponentsSubtotal)*1 + AValue5 );
	  			}
  			}
  		}
  		AValue7 = numberToFixed(AValue1*1 + AValue3*1 + AValue4*1 + AValue5*1);
  		
  		if ($('#difficulty').textbox('isValid')){//表示通过验证
  			BText4 = "<b>B3</b>难度补偿(" + numberToFixed(difficulty*1) + ")：";
  			BValue4 = numberToFixed(BValue2*difficulty);
  		}
  		
  		if ($('#engCost').textbox('isValid')){//表示通过验证
	  		BText5 = "<b>B4</b>工程费百分率(" + engCost + ")：";
	  		BValue5 = numberToFixed(AValue2*engCost);
	  	}
  		
  		if ($('#additional').textbox('isValid')){//表示通过验证
  			BText6 = "<b>B5</b>增量附加(" + additional + ")：";
  			BValue6 = numberToFixed(BValue5*additional);
  		}
  		BValue7 = numberToFixed(BValue1*1 + BValue2*1 + BValue4*1 + BValue5*1 + BValue6*1);
  		
  		CValue1 = numberToFixed(AValue2*10);
  		CValue7 = numberToFixed(CValue1*1 + CValue5*1);
  		
  		
  		DValue1 = numberToFixed(AValue2*12.5);
  		DValue2 = numberToFixed(AValue2*18);
  		DValue3 = numberToFixed(AValue7*1 + BValue7*1 + CValue7*1 + DValue1*1 + DValue2*1);
  		DValue4 = numberToFixed(DValue3*0.17);
 	  	
 	  	DValue7 = numberToFixed(DValue3*1 + DValue4*1 + DValue5*1);
 	  	
 	  	if ($('#totalNumber').textbox('isValid')){//表示通过验证
 	  		DText8 =  totalNumber + "套底线价：";
 	  		DValue8 = numberToFixed(DValue7*totalNumber);
 	  	}
  		
  		
		var data = '';
		if ($('#totalNumber').textbox('isValid')){//表示通过验证
  			data = [
                   {DText:'<b>D</b> 营销费12.5%（x值）：',DValue:DValue1,CText:'<b>C</b>皮费百分率(10%)：',CValue:CValue1,BText:'<b>B1</b>生产工费(工时x工价)：',AText:'<b>A1</b> 物料小计：',AValue:AValue1},
                   {DText:'<b>E</b> 毛利 18%（x值）：',DValue:DValue2,CText:CText2,CValue:CValue2,BText:BText2,BValue:BValue2,AText:AText2,AValue:AValue2},
                   {DText:'<b>A+B+C+D+E=F</b>总和：',DValue:DValue3,BText:BText3,BValue:BValue3,AText:'<b>A2</b> 包装材料：',AValue:AValue3},
                   {DText:'<b>G</b> 增值税17%（Fx17%）：',DValue:DValue4,BText:BText4,BValue:BValue4,AText:'<b>A3</b> 外购件小计：',AValue:AValue4},
                   {DText:'<b>H</b>标准件小计：',DValue:DValue5,CText:'其他：',BText:BText5,BValue:BValue5,AText:'<b>A4</b> 外发总费：',AValue:AValue5},
                   {BText:BText6,BValue:BValue6},
                   {DText:DText7,DValue:DValue7,CText:'<b>C</b> 总费用：',CValue:CValue7,BText:'<b>B</b> 总工费：',BValue:BValue7,AText:'<b>A</b> 总费用：',AValue:AValue7},
                   {DText:DText8,DValue:DValue8}
                   ];
  		}else{
  			data = [
                    {DText:'<b>D</b> 营销费12.5%（x值）：',DValue:DValue1,CText:'<b>C</b>皮费百分率(10%)：',CValue:CValue1,BText:'<b>B1</b>生产工费(工时x工价)：',AText:'<b>A1</b> 物料小计：',AValue:AValue1},
                    {DText:'<b>E</b> 毛利 18%（x值）：',DValue:DValue2,CText:CText2,CValue:CValue2,BText:BText2,BValue:BValue2,AText:AText2,AValue:AValue2},
                    {DText:'<b>A+B+C+D+E=F</b>总和：',DValue:DValue3,BText:BText3,BValue:BValue3,AText:'<b>A2</b> 包装材料：',AValue:AValue3},
                    {DText:'<b>G</b> 增值税17%（Fx17%）：',DValue:DValue4,BText:BText4,BValue:BValue4,AText:'<b>A3</b> 外购件小计：',AValue:AValue4},
                    {DText:'<b>H</b>标准件小计：',DValue:DValue5,CText:'其他：',BText:BText5,BValue:BValue5,AText:'<b>A4</b> 外发总费：',AValue:AValue5},
                    {BText:BText6,BValue:BValue6},
                    {DText:DText7,DValue:DValue7,CText:'<b>C</b> 总费用：',CValue:CValue7,BText:'<b>B</b> 总工费：',BValue:BValue7,AText:'<b>A</b> 总费用：',AValue:AValue7},
                    ];
  		}
	  	$("#dg3").datagrid('loadData',data);
  	}
  	
  	function enableDnd(){
  		var rows = $('#dg2').datagrid('getRows');
  		var flag = true;//记录校验是否通过
  		for (var i=0;i<rows.length;i++){
  			flag = $("#dg2").datagrid('validateRow',$("#dg2").datagrid('getRowIndex',rows[i]));//获取行的校验是否通过
  			if (flag == false){
  				break;
  			}
  		}
  		if (flag){
	  		for (var i=0;i<rows.length;i++){
	  			$('#dg2').datagrid('endEdit',$('#dg2').datagrid('getRowIndex',rows[i]));
	  		}
	  		$('#dg2').datagrid('options').remoteSort = false;
	  		$('#dg2').datagrid('enableDnd');
  		}else{
  			for (var i=0;i<rows.length;i++){
	  			var ed = $('#dg2').datagrid('getEditors', $("#dg2").datagrid('getRowIndex',rows[i]));//获取行的所有编辑器
				for (var j=0;j<ed.length;j++){//遍历行的所有编辑器
					if (!ed[j].target.textbox('isValid')){//如果校验不通过
						ed[j].target.textbox('textbox').focus(); //该编辑器获取焦点，目的是为了提示用户，该编辑器校验不通过
						return;//跳出循环
					}
				}
  			}
  		}
  	}
  	
  	function disableDnd(){
  		var rows = $('#dg2').datagrid('getRows');
  		for (var i=0;i<rows.length;i++){
  			var index = $('#dg2').datagrid('getRowIndex',rows[i]);
  			$('#dg2').datagrid('beginEdit', index);
  			var ed = $('#dg2').datagrid('getEditors', index);//获取行的所有编辑器
			ed[1].target.textbox('textbox').bind('input propertychange', function() { 
				calculate(this); 
			});
  		}
  		$('#dg2').datagrid('disableDnd');
  		$('#dg2').datagrid('options').remoteSort = true;
  	}
  	
  	function removeRow(){
  		var selected = $('#dg2').datagrid('getSelected');
  		if (selected!=null){
  			$('#dg2').datagrid('deleteRow',$('#dg2').datagrid('getRowIndex',selected));
  			$('#dg1-1').datagrid('unselectAll');//取消选择
  			calculate();
  		}else{
			showMessager("提示","请选择一行删除");
		}
  	}
  	
  	function numberToFixed(obj){
		if (!(obj.toFixed(2) == obj)){//如果小数点后面不是两位，则截取两位小数点
			obj = obj.toFixed(2);
		}
		return obj;
	}

  </script>
<body>
	<table id="dg" 
		
		data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
	
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="fg" mid="fga">
				<a id="add1" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fg" mid="fgb">
				<a id="edit1" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit()" style="float: left;">修改</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fg" mid="fgc">
				<a id="removeData1" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData()" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fg" mid="fgd">
				<a id="copyData1" href="#" class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copyData()" style="float: left;">复制</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a id="reload1" href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload()" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="fg" mid="fge">
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onClick="showCompleteReviewerCostCollect()" style="float: left;">关联</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fg" mid="fgf">
				<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="cancelAssociated()" style="float: left;">取消关联</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="fg" mid="fgg">
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onClick="chooseDate()" style="float: left;">导出报表</a> <div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				主题：<input id="theme_query" type="text" class="easyui-textbox" name="theme" style="width: 70px" >
				客户名称：<input id="customerName_query" type="text" class="easyui-textbox" name="customerName" style="width: 70px" >
				项目名称：<input id="productName_query" type="text" class="easyui-textbox" name="productName" style="width: 70px" >
				描述：<input id="description_query" type="text" class="easyui-textbox" name="description" style="width: 70px" >
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="fg" mid="fga">
    		<div id="add2" data-options="iconCls:'icon-add'" onclick="add()">新增</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="fg" mid="fgb">
    		<div id="edit2" data-options="iconCls:'icon-edit'" onclick="edit()">修改</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="fg" mid="fgc">
    		<div id="removeData2" data-options="iconCls:'icon-remove'" onclick="removeData()">删除</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="fg" mid="fgd">
    		<div id="copyData2" data-options="iconCls:'icon-large-shapes'" onclick="copyData()">复制</div>
    	</p:isPrivilege>
	    <div id="reload2" data-options="iconCls:'icon-reload'" onclick="reload()">刷新</div>
	    <p:isPrivilege pid="fg" mid="fge">
	    	<div data-options="iconCls:'icon-ok'" onclick="showCompleteReviewerCostCollect()">关联</div>
	    </p:isPrivilege>
	    <p:isPrivilege pid="fg" mid="fgf">
	    	<div data-options="iconCls:'icon-cancel'" onclick="cancelAssociated()">取消关联</div>
	    </p:isPrivilege>
	    <p:isPrivilege pid="fg" mid="fgg">
	    	<div data-options="iconCls:'icon-redo'" onclick="chooseDate()">导出报表</div>
	    </p:isPrivilege>
	</div>
	
	
	
	
	
	
	<!-- 增&改的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 100%;height: 100%"
  	data-options="closed: true,draggable:false,modal:true,top:0,left:0,buttons:'#bb1'">
  		<form id="form1">
  			<table style="border-spacing:0px;border-bottom: 0px;width: 1490px">
  				<tr>
  					<td>
  						<input id="flag" type="hidden" value="">
			  			<input id="id" type="hidden" name="id" value="">
			  			<input id="salReviewerId" type="hidden" name="salReviewerId">
			  			
			  			<div style="height: 10px;"></div>
			  			主题：<input id="theme" type="text" name="theme" class="easyui-textbox" style="width: 150px">
				  			客户名称：<input id="customerName" type="text" name="customerName" class="easyui-textbox" style="width: 150px">
				  			货品名称：<input id="productName" type="text" name="productName" class="easyui-textbox" style="width: 150px" data-options="required:true,missingMessage:'该值不能为空'">
				  			外围尺寸：<input id="peripheralSize" type="text" name="peripheralSize" class="easyui-textbox" style="width: 150px" data-options="required:true,missingMessage:'该值不能为空'">
				  			<input id="calculate1" type="radio" name="calculate" value="true">精算
				  			<input id="calculate2" type="radio" name="calculate" value="false">估算
				  			&nbsp;&nbsp;
				  			开始日期：<input id="beginTime" type="text" name="beginTime" class="easyui-datebox" style="width: 92px" data-options="editable:false,required:true,missingMessage:'该值不能为空'">
				  			提交日期：<input id="submitTime" type="text" name="submitTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				  			<br><br>
				  			原材料百分率：<input id="rawMaterial" type="text" name="rawMaterial" class="easyui-textbox" style="width: 60px" data-options="required:true,missingMessage:'该值不能为空',validType:'positiveInteger'">
				  			加工难度补偿：<input id="difficulty" type="text" name="difficulty" class="easyui-textbox" style="width: 60px" data-options="required:true,missingMessage:'该值不能为空',validType:'positiveDecimal'">
				  			工程费百分率：<input id="engCost" type="text" name="engCost" class="easyui-textbox" style="width: 60px" data-options="required:true,missingMessage:'该值不能为空',validType:'positiveDecimal'">
				  			增量附加：<input id="additional" type="text" name="additional" class="easyui-textbox" style="width: 60px" data-options="required:true,missingMessage:'该值不能为空',validType:'positiveDecimal'">
				  			包装材料：<input id="packaging" type="text" name="packaging" class="easyui-textbox" style="width: 60px" data-options="required:true,missingMessage:'该值不能为空',validType:'positiveDecimal'">
				  			总套数：<input id="totalNumber" type="text" name="totalNumber" class="easyui-textbox" style="width: 60px" data-options="required:true,missingMessage:'该值不能为空',validType:'positiveInteger'">
				  			描述：<input id="description" type="text" name="description" class="easyui-textbox" style="width: 500px">
			  			<div style="height: 10px;"></div>
						
						<div style="height: 10px;"></div>
						
  					</td>
  				</tr>
  				<tr>
  					<td>
  						请添加物料：<select id="material" type="text" style="width: 90%"></select>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<table id="dg2"></table>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<div id="dg3"></div>
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<br>
  						<B>备注：</B><input id="remark" type="text" class="easyui-textbox" style="width: 96%;height: 100px" name="remark"  data-options="multiline:true">
  						<br>
  					</td>
  				</tr>
  				<tr>
  					<td style="text-align: center;">
  						<br>
  						制表人：<input id="preparer" type="text" name="preparer" style="width: 80px" class="easyui-textbox" data-options="readonly:true" value="${user.username}">
  						&nbsp;&nbsp;&nbsp;&nbsp;
  						审核人：<input id="reviewer" type="text" name="reviewer" style="width: 80px" class="easyui-textbox">
  					</td>
  				</tr>
			</table>
		</form>
	</div>
	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
	
	
	
	<div id="gridToolBar2" style="padding:5px;height:auto">
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeRow()">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onClick="enableDnd()">开启排序</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="disableDnd()">禁用排序</a>
		</div>
	</div>
	<div id="gridToolBar3" style="padding:5px;height:auto">
		<div>
			<form id="queryForm2">
				物料类型：<input id="materialType_query" type="text" class="easyui-textbox" name="materialType" style="width: 70px" >
				物料类别：<input id="materialCategory_query" type="text" class="easyui-textbox" name="materialCategory" style="width: 70px" >
				物料名称：<input id="materialName_query" type="text" class="easyui-textbox" name="materialName" style="width: 70px" >
				规格：<input id="specification_query" type="text" class="easyui-textbox" name="specification" style="width: 70px" >
				材种/型号：<input id="model_query" type="text" class="easyui-textbox" name="model" style="width: 70px" >
				供应商：<input id="supplier_query" type="text" class="easyui-textbox" name="supplier" style="width: 70px" >
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2()">查询</a>
			</form>
		</div>
	</div>
	
	
	
	
	<div id="dialog2" class="easyui-dialog" style="width: 800px;height: 600px"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb2'">
  		<input id="costBudgetId" type="hidden">
  		<table id="reviewerCostDg"></table>
  		
	  	<div id="reviewerCostGridToolBar" style="padding:5px;height:auto">
			<div>
				<form id="reviewerCostQueryForm">
					Q编号：<input id="quotationNo_query" type="text" class="easyui-textbox" name="quotationNo" style="width: 70px" >
					年份：<input id="username_query" type="text" class="easyui-textbox" name="quotationYear" style="width: 40px" >
					评审日期：<input id="startCreateTime_query" type="text" name="startCreateTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
					&nbsp;~&nbsp;<input id="endCreateTime_query" type="text" name="endCreateTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="queryReviewerCost()">查询</a>
				</form>
			</div>
		</div>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb2" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="associated()">关联</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
	</div>
	
	
	<div id="dialog3" class="easyui-dialog" style="width: 330px;height: 130px"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb3'">
  		<form id="exportingReportForm" action="${pageContext.request.contextPath }/market/costBudget/exportingReport.action">
  			<br>
	  		开始日期：<input id="beginTime" type="text" name="beginTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
			结束日期：<input id="endTime" type="text" name="submitTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb3" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="exportingReport()">导出</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog3')">关闭</a>
	</div>
</body>
</html>

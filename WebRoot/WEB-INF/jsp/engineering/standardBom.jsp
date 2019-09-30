<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>BOM</title>
	
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
	}
  	var editRow = null;
  	
	  $(function(){
		  $(".easyui-combobox").combobox({
				url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
				valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:true,//允许编辑
			    panelHeight:'auto',
				events:{
					keyup:fnComFixedChineseInput,
					keydown:function(event){
						if (event.keyCode == 13){
							editableComboboxAutoCompleteSelect(this);
							//由于form的keydown事件，无法捕捉到下面的combobox的keyCode，所以加到这里来
							query();
						}
					},
					/* focus:function(){
			    		$(this).parent().prev().combobox('showPanel')
			    	}, */
					change:function(){
						editableComboboxAutoCompleteSelect(this);
			    	}
				},
				onLoadSuccess:function(){
					var queryFormObject = $("#queryForm2 input[name='" + $(this).attr('textboxname') + "'],#combogridQueryForm input[name='" + $(this).attr('textboxname') + "']");//combobox加载完之后，name属性就是textboxname属性
					if (queryFormObject.length > 0){//代表queryFrom里有
						for (var i=0;i<queryFormObject.length;i++){
							$(queryFormObject.get(i)).combobox({
					    		valueField:'dictionarieCode',//相当于select的key
							    textField:'dictionarieName',//相当于select的value
							    editable:true,//允许编辑
							    panelHeight:'auto',
								events:{
									keyup:fnComFixedChineseInput,
									keydown:function(event){
										if (event.keyCode == 13){
											editableComboboxAutoCompleteSelect(this);
											if ($(this).parent().parent().parent().attr('id') == 'queryForm2'){
												query2();
											}else if ($(this).parent().parent().parent().attr('id') == 'combogridQueryForm'){
												combogridQuery();
											}
										}
									},
									/* focus:function(){
							    		$(this).parent().prev().combobox('showPanel')
							    	}, */
									change:function(){
										editableComboboxAutoCompleteSelect(this);
							    	}
								},
							    filter: function(q, row){
						        	var opts = $(this).combobox('options');
						        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
						        }
					    	});
							$(queryFormObject.get(i)).combobox('loadData',$(this).combobox('getData'));
						}
					}
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
		
		
		  $('#dg').treegrid({
			  	title:'标准BOM',
				fit:true,//当设置为true的时候面板大小将自适应父容器
				//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			    url:'${pageContext.request.contextPath}/engineering/standardBom/findAllStandardBomList.action',
			    idField:'id',    
			    treeField:'materialCode',
			    lines: true,
			    pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
			    toolbar: '#gridToolBar',
			    columns:[[
					{field:'materialCode',title:'K3代码',width:120,align:'left',sortable:true},
			        {field:'materialName',title:'物料名称',width:120,align:'center',sortable:true},
					{field:'materialType',title:'类型',width:60,align:'center',sortable:true},
					{field:'version',title:'版本',width:40,align:'center',sortable:true},
					{field:'bomDate',title:'修改日期',width:80,align:'center',sortable:true},
					{field:'preparer',title:'制表人',width:60,align:'center',sortable:true},
			        {field:'applicableProduct',title:'适用产品',width:100,align:'center',formatter: function(value,row,index){
        																					$('#applicableProduct').combobox('setValues',value);
        																					var value = $('#applicableProduct').combobox('getText');
        																					return value.substring(0,value.length);
																						}
					},
			        {field:'classification',title:'分类',width:60,align:'center',sortable:true},
			        {field:'materialProperties',title:'物料属性',width:80,align:'center',sortable:true},
			        {field:'specifications',title:'规格型号',width:80,align:'center',sortable:true},
			        {field:'length',title:'长度',width:80,align:'center',sortable:true},
			        {field:'height',title:'高度',width:80,align:'center',sortable:true},
			        {field:'width',title:'宽度',width:80,align:'center',sortable:true},
			        {field:'depth',title:'深度',width:80,align:'center',sortable:true},
			        {field:'color',title:'颜色',width:50,align:'center',sortable:true},
			        {field:'fileId',title:'附件',width:50,align:'center'},
			        {field:'drawingNumber',title:'图号',width:80,align:'center'},
			        {title:'单件<br>用量',field:'singletonConsumption',width:40,halign:'center',align:'center',formatter: function(value,row,index){
			        	if (value != undefined){
			        		if (value != 0){
			        			return value*1;
			        		}
			        	}
			        }},
			        {title:'单<br>位',field:'useUnit',width:30,halign:'center',align:'center'},
			        {title:'物料备注',field:'materialRemark',width:80,halign:'center',align:'left'},
			        {title:'Bom备注',field:'remark',width:80,halign:'center',align:'left'},
			        {title:'审核状态',field:'processInstanceId',width:80,halign:'center',align:'left',sortable:true},
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
	            },onBeforeExpand:function(row){
			    	var url = '${pageContext.request.contextPath}/engineering/standardBom/findAllStandardBomSubsidiaryListByEngStandardBomId.action';
	                $(this).treegrid("options").url = url;  
	                return true;      
	            },onExpand : function(row){
	            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
	            	var url = '${pageContext.request.contextPath}/engineering/standardBom/findAllStandardBomList.action'; 
	                $(this).treegrid("options").url = url;
	                //下面是为了全部展开，因为上面的加载子节点，已经加载了所有的子节点数据
	            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
	            	var url = '${pageContext.request.contextPath}/engineering/standardBom/findAllStandardBomList.action'; 
	                $(this).treegrid("options").url = url;  
	            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
	            	var url = '${pageContext.request.contextPath}/engineering/standardBom/findAllStandardBomList.action'; 
	                $(this).treegrid("options").url = url;
	            }
			});
		  
		  
		  
		  	$('#warMaterialId').combogrid({//查找未关联的标准bom的
		  		url:'${pageContext.request.contextPath}/engineering/standardBom/findAllWarMaterialList.action',
			    idField:'id',//下列表的标识id    
			    textField:'materialName',//下拉框文本显示的字段
			    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
			    required:true,
			    missingMessage:'请选择物料',
			    panelWidth:1024,
			    panelHeight:'auto',
			    editable:false,//下拉框文本不可以编辑
			    pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
			    toolbar:'#combogridToolBar',
			    queryParams: {
			    	relationStartandBomQuery: true,
			    	state:'isNull'
				},
			    columns:[[	
							{field:'materialCode',title:'代码',width:120,halign:'center',align:'left',sortable:true},
					        {field:'materialName',title:'名称',width:120,halign:'center',align:'left',sortable:true},
					        {field:'materialType',title:'类型',width:60,halign:'center',align:'left',sortable:true},
					        {field:'applicableProduct',title:'适用产品',width:100,halign:'center',align:'left',formatter: function(value,row,index){
		        																					$('#applicableProduct').combobox('setValues',value);
		        																					var value = $('#applicableProduct').combobox('getText');
		        																					return value.substring(0,value.length);
																								}
							},
					        {field:'classification',title:'分类',width:60,halign:'center',align:'left',sortable:true},
					        {field:'materialProperties',title:'物料属性',width:80,halign:'center',align:'left',sortable:true},
					        {field:'specifications',title:'规格型号',width:80,halign:'center',align:'left',sortable:true},
					        {field:'length',title:'长度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'height',title:'高度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'width',title:'宽度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'depth',title:'深度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'color',title:'颜色',width:50,halign:'center',align:'left',sortable:true},
					        {field:'useUnit',title:'使用单位',width:80,halign:'center',align:'left',sortable:true},
					        {field:'division',title:'分割数',width:80,halign:'center',align:'left',sortable:true},
					        {field:'productionWorkshop',title:'生产车间',width:80,halign:'center',align:'left',sortable:true},
					        {field:'drawingNumber',title:'图号',width:80,halign:'center',align:'left'},
					        {field:'fileId',title:'附件',width:50,halign:'center',align:'left'},
					        {field:'remark',title:'备注',width:200,halign:'center',align:'left',sortable:true}
					    ]],
			    onShowPanel:function(){
			    	$(this).combogrid('grid').datagrid('load');
			    },
			    onBeforeSelect:function(index,row){
			    	if (editRow != null){
				    	var ed = $('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'warMaterialId'});
				    	if ($(ed.target).textbox('getValue') == row.id){
				    		alert("下面已选该物料");
				    		return false;
				    	}
			    	}
			    	
			    	var dg1Data = $('#dg1').datagrid('getData');//获取所有的行
					for (var i=0;i<dg1Data.length;i++){
						if (row.id == checkRepeat(row.id,dg1Data[i])){
				    		alert("下面已选该物料");
				    		return false;
				    	}else{
				    		return true;
				    	}
					}
				}
			});
			
			
			$('#dg1').datagrid({
				height:667,
				singleSelect:true ,//单选
			    idField:'id',
			    toolbar: '#gridToolBar1',
			    columns:[[
			        {title:'编码',field:'materialCode',width:200,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		required:true,
			        		missingMessage:'物料编码不能为空',
			        		validType:'length[0,0]',
			        		invalidMessage:'请输入正确的物料代码'
			        	}
			        }},
			        {title:'名称',field:'materialName',width:170,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'规格',field:'specifications',width:130,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'图号',field:'drawingNumber',width:60,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'物料属性',field:'materialProperties',width:60,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'生产车间',field:'productionWorkshop',width:80,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'表面处理',field:'color',width:60,halign:'center',align:'left',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'单件<br>用量',field:'singletonConsumption',width:45,halign:'center',align:'center',editor:{
			        	type:'numberbox',
			        	options:{
			        		required:true,
			        		missingMessage:'单价用量不能为空',
			        		min:0,
			        		precision:3
			        	}
			        },formatter: function(value,row,index){
			        	if (value != undefined){
				        	return value*1;
			        	}
			        }},
			        {title:'单<br>位',field:'useUnit',width:30,halign:'center',align:'center',editor:{
			        	type:'textbox',
			        	options:{
			        		disabled:true
			        	}
			        }},
			        {title:'备注',field:'remark',width:80,halign:'center',align:'left',editor:{
			        	type:'textbox'
			        }},
			        {title:'warMaterialId',field:'warMaterialId',width:80,hidden:true,editor:'textbox'},
			        {title:'操作',field:'control',width:56,halign:'center',formatter: function(value,row,index){
			        	var a = '<a id="' + row.id + 'ok" class="easyui-linkbutton" data-options="iconCls:\'icon-ok\'" onclick="endEditRow(\'' + index + '\');"></a>';
			        	
			    		var b = '<a id="' + row.id + 'no" class="easyui-linkbutton" data-options="iconCls:\'icon-no\'" onclick="cancelEditRow(\'' + index + '\');"></a>';
			        	return a + b;
			        }}
			    ]],
			    onRowContextMenu: function(e, index, row) { //右键时触发事件
			    	if ($("#flag").val() != 'view'){
		                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
		                e.preventDefault(); //阻止浏览器捕获右键事件
		                $(this).datagrid('clearSelections');
		                if (row!=null){
		                	$(this).datagrid("selectRow", index); //根据索引选中该行
						}
		                $("#menu1").menu('show', {//显示右键菜单
		                    left: e.pageX,//在鼠标点击处显示菜单
		                    top: e.pageY
		                });
			    	}
	            },onDblClickRow: function(index, row){
	            	if ($("#flag").val() != 'view'){
	            		doubleClickRow(row);
	            	}
				},onBeforeSelect: function(index, row){//让下面的获取焦点，是为了可以使用del删除行
	            	$(this).datagrid('getPanel').panel('panel').focus();
	            }
			});
			
			
			//加载datagrid表格
			$("#dg2").datagrid({
				fit:true,//当设置为true的时候面板大小将自适应父容器
				striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
				singleSelect:true ,//单选
				pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
				url:'${pageContext.request.contextPath}/engineering/standardBom/findAllWarMaterialList.action',
			    idField:'id',//指明哪一个字段是标识字段。
			    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
			    rownumbers:true,//显示一个行号列。
			    toolbar: "#gridToolBar2",
			    queryParams: {
			    	state:'isNull'
				},
			    columns:[[
							{field:'materialCode',title:'代码',width:120,halign:'center',align:'left',sortable:true},
					        {field:'materialName',title:'名称',width:120,halign:'center',align:'left',sortable:true},
					        {field:'materialType',title:'类型',width:60,halign:'center',align:'left',sortable:true},
					        {field:'applicableProduct',title:'适用产品',width:100,halign:'center',align:'left',formatter: function(value,row,index){
		        																					$('#applicableProduct').combobox('setValues',value);
		        																					var value = $('#applicableProduct').combobox('getText');
		        																					return value.substring(0,value.length);
																								}
							},
					        {field:'classification',title:'分类',width:60,halign:'center',align:'left',sortable:true},
					        {field:'materialProperties',title:'物料属性',width:80,halign:'center',align:'left',sortable:true},
					        {field:'specifications',title:'规格型号',width:80,halign:'center',align:'left',sortable:true},
					        {field:'length',title:'长度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'height',title:'高度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'width',title:'宽度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'depth',title:'深度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'color',title:'颜色',width:50,halign:'center',align:'left',sortable:true},
					        {field:'useUnit',title:'使用单位',width:80,halign:'center',align:'left',sortable:true},
					        {field:'division',title:'分割数',width:80,halign:'center',align:'left',sortable:true},
					        {field:'productionWorkshop',title:'生产车间',width:80,halign:'center',align:'left',sortable:true},
					        {field:'drawingNumber',title:'图号',width:80,halign:'center',align:'left'},
					        {field:'fileId',title:'附件',width:50,halign:'center',align:'left'},
					        {field:'remark',title:'备注',width:200,halign:'center',align:'left',sortable:true}
					    ]],
			    onDblClickRow: function(index, row) { //双击时触发事件
			    	if (row.id == $('#warMaterialId').combogrid('getValue')){
			    		alert("不能添加，因为当前就是做这个物料的bom");
			    	}else{
				    	$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'}).target).textbox('disableValidation');
						
				    	$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'}).target).textbox('setValue',row.materialCode);
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'materialName'}).target).textbox('setValue',row.materialName);
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'specifications'}).target).textbox('setValue',row.specifications);
						
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'drawingNumber'}).target).textbox('setValue',row.drawingNumber);
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'materialProperties'}).target).textbox('setValue',row.materialProperties);
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'productionWorkshop'}).target).textbox('setValue',row.productionWorkshop);
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'color'}).target).textbox('setValue',row.color);
						$($('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'useUnit'}).target).textbox('setValue',row.useUnit);
						$($('#dg1').treegrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'warMaterialId'}).target).textbox('setValue',row.id);
						
						$("#dialog2").dialog({//加载一个dialog
							closed:true,//将该dialog的状态由不显示改成显示
						});
			    	}
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
			
			
			$("#dg1").datagrid('getPanel').panel('panel').attr('tabindex', 1).css('outline','none').bind('keydown', function (event) {//必须在datagrid的onBeforeSelect，添加获取焦点
				if (event.keyCode == 46){
					removeRow();
				}
			});
			
			$("#queryForm").keydown(function (event){
				if (event.keyCode == 13){
					query();
				}
			});
			
			$("#combogridQueryForm").keydown(function (event){
				if (event.keyCode == 13){
					combogridQuery();
				}
			});
			
			$("#queryForm2").keydown(function (event){
				if (event.keyCode == 13){
					query2();
				}
			});
	  });
	  
	  
	function checkRepeat(id,dg1Data){
		if (id == dg1Data.warMaterialId){
			return dg1Data.warMaterialId;
		}else if (dg1Data.children != undefined && dg1Data.children.length > 0){
			for (var i=0;i<dg1Data.length;i++){
				return checkRepeat(id,dg1Data[i]);
			}
		}
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
				$("#warMaterialId").combogrid('readonly',false);
				$("#version").textbox('readonly',false);
				$("#saveButton").linkbutton('enable');
				$("#gridToolBar1").show();
				$("#dg1").datagrid('clearSelections');
				$("#dg1").datagrid('loadData', {"total":0,"rows":[]});
				editRow = null;
		  		$("#id").val("");
		  		$("#processInstanceId").val("");
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:"新增标准BOM"//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
	
	//打开修改窗口
	function edit(){
		var selected = $("#dg").treegrid("getSelected");
  		if (selected != null){
  			var id = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#dg').treegrid('getParent',selected.id);
				}
			}
  			var url = "${pageContext.request.contextPath}/engineering/standardBom/findEngstandardBomByIdForEdit.action?id="+id;//根据ID从后台取数据的url
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						if (data.datas.isEdit){
							$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
							$("#form1").form('reset');//重置表单数据
							$("#dg1").datagrid('clearSelections');
							$("#dg1").datagrid('loadData', {"total":0,"rows":[]});
							editRow = null;
							
							$("#dialog1").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:"修改BOM"//该dialog的标题
							});
							delete data.datas.standardBom.bomDate;
							delete data.datas.standardBom.preparer;
							
							$("#form1").form('load',data.datas.standardBom);
							$("#dg1").datagrid('loadData',data.datas.standardBomSubsidiaries);
							$("#warMaterialId").combogrid('setText',data.datas.materialName);
							
							$("#warMaterialId").combogrid('readonly',true);
							$("#version").textbox('readonly',false);
							$("#saveButton").linkbutton('enable');
							$("#gridToolBar1").show();
							
							$('#dg1').datagrid('enableDnd');
						}else{
							alert(data.datas.doNotEditMessage);
							$("#flag").val('view');
							$("#form1").form('reset');//重置表单数据
							$("#dg1").datagrid('clearSelections');
							$("#dg1").datagrid('loadData', {"total":0,"rows":[]});
							editRow = null;
							
							$("#dialog1").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:"查看标准BOM"//该dialog的标题
							});
							$("#form1").form('load',data.datas.standardBom);
							$("#dg1").datagrid('loadData',data.datas.standardBomSubsidiaries);
							$("#warMaterialId").combogrid('setText',data.datas.materialName);
							
							$("#warMaterialId").combogrid('readonly',true);
							$("#version").textbox('readonly',true);
							$("#saveButton").linkbutton('disable');
							$("#gridToolBar1").hide();
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
	
	//打开查看窗口
	function view(){
		var selected = $("#dg").treegrid("getSelected");
  		if (selected != null){
  			var id = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#dg').treegrid('getParent',selected.id);
				}
			}
  			var url = "${pageContext.request.contextPath}/engineering/standardBom/findEngstandardBomByIdForView.action?id="+id;//根据ID从后台取数据的url
			$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data.success){
						$("#flag").val('view');
						
						$("#form1").form('reset');//重置表单数据
						$("#dg1").datagrid('clearSelections');
						$("#dg1").datagrid('loadData', {"total":0,"rows":[]});
						editRow = null;
						
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:"查看标准BOM"//该dialog的标题
						});
						$("#form1").form('load',data.datas.standardBom);
						$("#dg1").datagrid('loadData',data.datas.standardBomSubsidiaries);
						$("#warMaterialId").combogrid('setText',data.datas.materialName);
						
						$("#warMaterialId").combogrid('readonly',true);
						$("#version").textbox('readonly',true);
						$("#saveButton").linkbutton('disable');
						$("#gridToolBar1").hide();
						
					}else{
						showErrorMessager("查看失败", data.message);
					}
				}
			});
  		}else{
			showMessager("提示","请选择一条记录进行查看");
		}
	}
	
	//复制数据
	function copyData(){
		var selected = $("#dg").treegrid("getSelected");
  		if (selected != null){
  			var id = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#dg').treegrid('getParent',selected.id);
				}
			}
  			var url = "${pageContext.request.contextPath}/engineering/standardBom/findEngStandardBomByIdForCopy.action?id="+id;//根据ID从后台取数据的url
			$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#form1").form('reset');//重置表单数据
					$("#warMaterialId").combogrid('readonly',false);
					$("#dg1").datagrid('clearSelections');
					$("#dg1").datagrid('loadData', {"total":0,"rows":[]});
					
					if (data.success){
						$("#dialog1").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:"新增标准BOM"//该dialog的标题
						});
						
						$("#dg1").datagrid('loadData',data.datas.standardBomSubsidiaries);
						
					}else{
						showErrorMessager("复制失败", data.message);
					}
				}
			});
  		}else{
			showMessager("提示","请选择一条记录进行复制");
		}
	}
	
	//保存更新数据
  	function saveOrUpdate(){
  		if ($("#form1").form('validate') && $("#dg1Form").form('validate')){
  			if (editRow){
        		$('#dg1').datagrid('endEdit',$('#dg1').datagrid('getRowIndex',editRow));
        		editRow = null;
        	}
  			var dg1Data = $('#dg1').datagrid('getRows');//获取所有的行
  			if (dg1Data != null && dg1Data.length > 0){
  				for (var i=0;i<dg1Data.length;i++){
  					var needBeginEditRow = validateTreeGrid(dg1Data[i]);
  					if (needBeginEditRow != undefined){
  						doubleClickRow(needBeginEditRow);
  						break;
  					}
  				}
  				if ($("#dg1Form").form('validate')){
	  				dg1Data = JSON.stringify(dg1Data);//转换成json字符串
	  				var formData = $("#form1").serializeObject();
	  				formData = JSON.stringify(formData);//转换成json字符串
	  				var datas = "{standardBom:"+formData + ",standardBomSubsidiary:"+dg1Data+""+"}";
	  				
		  			var flag = $("#flag").val();//获取标识符，
					var url = "${pageContext.request.contextPath}/engineering/standardBom/";
					if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
						url = url + "saveEngStandardBom.action";
					}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
						url = url + "updateEngStandardBom.action";
					}
					$.ajax({
						type:'POST',//post请求
						url: url,//ajax请求的url
						data: datas,//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						contentType: 'application/json;charset=utf-8',
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
  			}else{
  				showMessager("提示","请至少添加一行物料数据");
  			}
  		}
  	}
	
	//删除数据
	function removeData(){
		var selected = $("#dg").treegrid("getSelected");
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
							url: "${pageContext.request.contextPath}/engineering/standardBom/deleteEngStandardBomById.action",//ajax请求的url
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
	
	
	//刷新数据
  	function reload(){
  		$("#dg").treegrid('reload');
  	}
	
	//展开所有
	function expandAll(){
		$("#dg").treegrid('expandAll');
	}

	
	//折叠所有
	function collapseAll(){
		$("#dg").treegrid('collapseAll');
	}
	
  	//查询数据
  	function query(){
  		$("#dg").treegrid('load',$("#queryForm").serializeObject());
  	}
  	
  	function combogridQuery(){
  		$("#warMaterialId").combogrid('grid').datagrid('load',$("#combogridQueryForm").serializeObject());
  	}
  	
  	function query2(){
  		$("#dg2").datagrid('load',$("#queryForm2").serializeObject());
  	}
  	
  	function addRow(){
  		var id = new Date().getTime();
  		$('#dg1').datagrid('appendRow',{
  				'id':id,
  				'accessoriesCode':'',
  				'isMaterial':'true'
  		});
  		$('#dg1').datagrid('enableDnd');
  	}
  	
  	function insertRow(){
  		var selected = $('#dg1').datagrid('getSelected');
  		var id = new Date().getTime();
  		if (selected != null){
  			$('#dg1').datagrid('insertRow',{
  				index: $('#dg1').datagrid('getRowIndex',selected), 
	  			row: {
	  				'id':id,
	  				'materialCode':'',
	  				'isMaterial':'true'
	  			}
	  		});
  			$('#dg1').datagrid('enableDnd');
  		}else{
  			showMessager("提示","请选择一条记录进行插入");
  		}
  	}

  	
  	function removeRow(){
  		var selected = $('#dg1').datagrid('getSelected');
  		if (selected != null){
  			$.messager.confirm('确认对话框', '子节点会一起被删除，您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$('#dg1').datagrid('remove',selected.id);
				}
  			});
  		}else{
  			showMessager("提示","请选择一条记录进行删除");
  		}
  	}
  	
  	
  	function findWarMaterialByMaterialCode(materialCode){
  		if (materialCode != null && materialCode != ''){
	  		$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/engineering/standardBom/findWarMaterialByMaterialCode.action",//ajax请求的url
				data: {materialCode:materialCode},//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if(data.success){
						//alert(data.standardAccessories);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'}).target).textbox('disableValidation');
						
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialName'}).target).textbox('setValue',data.standardBomSubsidiary.materialName);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'specifications'}).target).textbox('setValue',data.standardBomSubsidiary.specifications);
						
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'drawingNumber'}).target).textbox('setValue',data.standardBomSubsidiary.drawingNumber);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialProperties'}).target).textbox('setValue',data.standardBomSubsidiary.materialProperties);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'productionWorkshop'}).target).textbox('setValue',data.standardBomSubsidiary.productionWorkshop);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'color'}).target).textbox('setValue',data.standardBomSubsidiary.color);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'useUnit'}).target).textbox('setValue',data.standardBomSubsidiary.useUnit);
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'warMaterialId'}).target).textbox('setValue',data.standardBomSubsidiary.warMaterialId);
	
					}else{
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'}).target).textbox('enableValidation');
						
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialName'}).target).textbox('setValue','');
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'specifications'}).target).textbox('setValue','');
						
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'drawingNumber'}).target).textbox('setValue','');
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialProperties'}).target).textbox('setValue','');
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'productionWorkshop'}).target).textbox('setValue','');
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'color'}).target).textbox('setValue','');
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'useUnit'}).target).textbox('setValue','');
						$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'warMaterialId'}).target).textbox('setValue','');
						showMessager("错误",data.message);
					}
				}
			});
  		}else{
  			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'}).target).textbox('enableValidation');
			
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialName'}).target).textbox('setValue','');
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'specifications'}).target).textbox('setValue','');
			
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'drawingNumber'}).target).textbox('setValue','');
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'materialProperties'}).target).textbox('setValue','');
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'productionWorkshop'}).target).textbox('setValue','');
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'color'}).target).textbox('setValue','');
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'useUnit'}).target).textbox('setValue','');
			$($('#dg1').datagrid('getEditor', {index:$('#dg1').datagrid('getRowIndex',editRow),field:'warMaterialId'}).target).textbox('setValue','');
  		}
  	}
  	
  	function doubleClickRow(row){
  		var flag = false;//标记是否是验证不通过
    	if (editRow){
    		if ($("#dg1Form").form('validate')){
        		editorUnBind();
        		$('#dg1').datagrid('endEdit',$('#dg1').datagrid('getRowIndex',editRow));
        		flag = true;
    		}
    	}else{
    		flag = true;
    	}
    	if (flag){
			$('#dg1').datagrid('beginEdit', $('#dg1').datagrid('getRowIndex',row));
			editRow = row;
			$('#dg1').datagrid('disableDnd');
			$('a[id^="' + row.id + '"]').linkbutton();
			
			var keyState = true;//防止长按，一直执行的标识符
			var ed = $('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'});
			$(ed.target).textbox('textbox').bind('keydown', function(e){
				if (e.keyCode == 118){
					openDialogForQueryMaterialInfo();
				}
				if (e.keyCode == 13){
					if (keyState){
						findWarMaterialByMaterialCode($(this).val());
						keyState = false;
					}
				}
			});
			$(ed.target).textbox('textbox').bind('keyup', function(e){
				if (e.keyCode == 13){
					keyState = true;
				}
			});
			$(ed.target).textbox('textbox').bind('change', function(){
				if (keyState){//防止按下回车时，触发change事件
					findWarMaterialByMaterialCode($(this).val());
				}
			});
			//当双击点开，时候要进行查找，该方法里面进行了空的判断
			findWarMaterialByMaterialCode($(ed.target).textbox('getValue'));
    	}
  	}
  	
  	function endEditRow(index){
  		if ($("#dg1Form").form('validate')){
	  		editorUnBind();
	  		$('#dg1').datagrid('endEdit', index);
	  		editRow = null;
	  		$('#dg1').datagrid('enableDnd');
  		}else{
  			setTimeout(function(){
  				$("#dg1Form").form('validate');
  			}, 100);
  		}
  	}
  	
  	function cancelEditRow(index){
  		editorUnBind();
  		$('#dg1').datagrid('cancelEdit',index);
  		editRow = null;
  		$('#dg1').datagrid('enableDnd');
  	}
  	
	//在取消编辑或者结束编辑取消绑定
	function editorUnBind(){
		var ed = $('#dg1').datagrid('getEditor', {id:$('#dg1').datagrid('getRowIndex',editRow),field:'materialCode'});
		$(ed.target).unbind();//取消所有事件绑定
	}
  	
  	
  	function validateTreeGrid(row){
		if (row.warMaterialId != undefined && row.warMaterialId != '' && row.singletonConsumption != undefined && row.singletonConsumption != ''){
			if (row.children != undefined && row.children.length > 0){
				for (var i=0;i<row.children.length;i++){
					var needBeginEditRow = validateTreeGrid(row.children[i]);
					if (needBeginEditRow != undefined){
						return needBeginEditRow;
					}
				}
			}
		}else{
			return row;
		}
  	}
  	
  	
  	function openDialogForQueryMaterialInfo(){
  		$("#dialog2").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:'物料'
		});
  	}
  	
  	
  	function queryAuditor(){
  		var selected = $("#dg").treegrid("getSelected");
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
					url: "${pageContext.request.contextPath}/engineering/standardBom/queryAuditorById.action",//ajax请求的url
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
											url: "${pageContext.request.contextPath}/engineering/standardBom/auditEngStandardBom.action",//ajax请求的url
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
					url: "${pageContext.request.contextPath}/engineering/standardBom/auditEngStandardBom.action",//ajax请求的url
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
	  var selected = $("#dg").treegrid("getSelected");
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
							url: "${pageContext.request.contextPath}/engineering/standardBom/revokeProcess.action",//ajax请求的url
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
						url: "${pageContext.request.contextPath}/engineering/standardBom/takeBackEngStandardBom.action",//ajax请求的url
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
						url: "${pageContext.request.contextPath}/engineering/standardBom/rollBackEngStandardBom.action",//ajax请求的url
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
						url: "${pageContext.request.contextPath}/engineering/standardBom/antiAuditEngStandardBom.action",//ajax请求的url
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
<body>
	<div style="display: none;">
		<input id="applicableProduct" class="easyui-combobox" data-options="multiple:true,queryParams: {'keyword' : '适用产品'}">
	</div>
	<table id="dg" style="width: 715px;height: 675px;"
		<p:isPrivilege pid="cd" mid="cdb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="cf" mid="cfa">
				<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="cf" mid="cfb">
				<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a class="easyui-linkbutton" iconCls="icon-mini-edit" plain="true" onClick="view();" style="float: left;">查看</a> <div class="btn-separator"></div>
			<p:isPrivilege pid="cf" mid="cfa">
				<a class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copyData()" style="float: left;">复制</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="cf" mid="cfc">
				<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a class="easyui-linkbutton" iconCls="icon-ok" plain="true" onClick="expandAll();" style="float: left;">展开所有</a> <div class="btn-separator"></div>
			<a class="easyui-linkbutton" iconCls="icon-no" plain="true" onClick="collapseAll();" style="float: left;">折叠所有</a> <div class="btn-separator"></div>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="cf" mid="cfd">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="queryAuditor();" style="float: left;">审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="revokeProcess();" style="float: left;">撤销流程</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openTakeBackDialog();" style="float: left;">收回审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openRollBackDialog();" style="float: left;">退回审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="cf" mid="cfe">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAntiAuditDialog();" style="float: left;">反审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				K3代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 80px;">
				配件名称：<input id="materialNameQuery" class="easyui-textbox" name="materialName" style="width: 80px;">
				类型：<input id="materialTypeQuery" class="easyui-combobox" name="materialType" style="width: 80px;" data-options="queryParams: {'keyword' : '类型'}">
				适用产品：<input id="applicableProductQuery" class="easyui-combobox" name="applicableProduct" style="width: 80px;" data-options="queryParams: {'keyword' : '适用产品'}">
				分类：<input id="classificationQuery" class="easyui-combobox" name="classification" style="width: 80px;" data-options="queryParams: {'keyword' : '分类'}">
				物料属性：<input id="materialPropertiesQuery" class="easyui-combobox" name="materialProperties" style="width: 80px;" data-options="queryParams: {'keyword' : '物料属性'}">
				规格型号：<input id="specificationsQuery" class="easyui-combobox" name="specifications" style="width: 80px;" data-options="queryParams: {'keyword' : '规格型号'}">
				长度：<input id="lengthQuery" class="easyui-combobox" name="length" style="width: 80px;" data-options="queryParams: {'keyword' : '长度'}">
				高度：<input id="heightQuery" class="easyui-combobox" name="height" style="width: 80px;" data-options="queryParams: {'keyword' : '高度'}">
				宽度：<input id="widthQuery" class="easyui-combobox" name="width" style="width: 80px;" data-options="queryParams: {'keyword' : '宽度'}">
				深度：<input id="depthQuery" class="easyui-combobox" name="depth" style="width: 80px;" data-options="queryParams: {'keyword' : '深度'}">
				颜色：<input id="colorQuery" class="easyui-combobox" name="color" style="width: 80px;" data-options="queryParams: {'keyword' : '颜色'}">
				<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
  		<p:isPrivilege pid="cf" mid="cfa">
    		<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		</p:isPrivilege>
    	<p:isPrivilege pid="cf" mid="cfb">
    		<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
   		<div data-options="iconCls:'icon-mini-edit'" onclick="view();">查看</div>
   		<p:isPrivilege pid="cf" mid="cfa">
   			<div data-options="iconCls:'icon-large-shapes'" onclick="copyData();">复制</div>
   		</p:isPrivilege>
    	<p:isPrivilege pid="cf" mid="cfc">
    		<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
   		</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="cf" mid="cfd">
		    <div data-options="iconCls:'icon-man'" onclick="queryAuditor();">审核</div>
		    <div data-options="iconCls:'icon-cancel'" onclick="revokeProcess();">撤销流程</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openTakeBackDialog();">收回审核</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openRollBackDialog();">退回审核</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="cf" mid="cfe">
   			<div data-options="iconCls:'icon-man'" onclick="openAntiAuditDialog();">反审核</div>
   		</p:isPrivilege>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 1024px;height: 768px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" name="id" type="hidden">
  			<input id="processInstanceId" name="processInstanceId" type="hidden">
  			物料：<input id="warMaterialId" name="warMaterialId" style="width: 100px">
  			版本：<input id="version" name="version" class="easyui-textbox" style="width: 70px" data-options="required:true,missingMessage:'版本不能为空'">
  			日期：<input id="bomDate" name="bomDate" class="easyui-datebox" style="width: 120px" data-options="editable:false,readonly:true" value="<p:date/>">
  			填表人：<input id="preparer" name="preparer" class="easyui-textbox" style="width: 70px" data-options="readonly:true" value="${user.username}">
  		</form>
  		<form id="dg1Form">
			<table id="dg1"></table>
		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a id="saveButton" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdate()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
	<div id="gridToolBar1" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addRow()" style="float: left;">新增</a><div class="btn-separator"></div>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeRow();" style="float: left;">删除</a> <div class="btn-separator"></div>
		</div>
	</div>
	<div id="menu1" class="easyui-menu" style="width: 80px; display: none;">
   		<div data-options="iconCls:'icon-add'" onclick="addRow();">新增</div>
   		<div data-options="iconCls:'icon-undo'" onclick="insertRow();">插入</div>
   		<div data-options="iconCls:'icon-remove'" onclick="removeRow();">删除</div>
	</div>
	
	<div id="combogridToolBar" style="padding:5px;height:auto">
		<form id="combogridQueryForm">
			<div>
				K3代码：<input id="materialCodeCombogridQuery" class="easyui-textbox" name="materialCode" style="width: 80px;">
				配件名称：<input id="materialNameCombogridQuery" class="easyui-textbox" name="materialName" style="width: 80px;">
				类型：<input id="materialTypeCombogridQuery" name="materialType" style="width: 80px;">
				适用产品：<input id="applicableProductCombogridQuery" name="applicableProduct" style="width: 80px;">
				分类：<input id="classificationCombogridQuery" name="classification" style="width: 80px;">
				物料属性：<input id="materialPropertiesCombogridQuery" name="materialProperties" style="width: 80px;">
				规格型号：<input id="specificationsCombogridQuery" name="specifications" style="width: 80px;">
			</div>
			<div style="margin-top: 5px;">
				长度：<input id="lengthCombogridQuery" name="length" style="width: 80px;">
				高度：<input id="heightCombogridQuery" name="height" style="width: 80px;">
				宽度：<input id="widthCombogridQuery" name="width" style="width: 80px;">
				深度：<input id="depthCombogridQuery" name="depth" style="width: 80px;">
				颜色：<input id="colorCombogridQuery" name="color" style="width: 80px;">
				<input type="hidden" name="relationStartandBomQuery" value="true">
				<input type="hidden" name="state" value="isNull">
				<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="combogridQuery()">查询</a>
			</div>
		</form>
	</div>
	
	
	
	
	<div id="dialog2" class="easyui-dialog" style="width: 1024px;height: 768px;text-align: center;"
  		data-options="closed: true,draggable:true,resizable:true,modal:true">
  		<table id="dg2"></table>
	</div>
	<div id="gridToolBar2" style="padding:5px;height:auto">
		<form id="queryForm2">
			<div>
				K3代码：<input id="materialCodeQuery2" class="easyui-textbox" name="materialCode" style="width: 80px;">
				配件名称：<input id="materialNameQuery2" class="easyui-textbox" name="materialName" style="width: 80px;">
				类型：<input id="materialTypeQuery2" name="materialType" style="width: 80px;">
				适用产品：<input id="applicableProductQuery2" name="applicableProduct" style="width: 80px;">
				分类：<input id="classificationQuery2" name="classification" style="width: 80px;">
				物料属性：<input id="materialPropertiesQuery2" name="materialProperties" style="width: 80px;">
				规格型号：<input id="specificationsQuery2" name="specifications" style="width: 80px;">
			</div>
			<div style="margin-top: 5px;">
				长度：<input id="lengthQuery2" name="length" style="width: 80px;">
				高度：<input id="heightQuery2" name="height" style="width: 80px;">
				宽度：<input id="widthQuery2" name="width" style="width: 80px;">
				深度：<input id="depthQuery2" name="depth" style="width: 80px;">
				颜色：<input id="colorQuery2" name="color" style="width: 80px;">
				<input type="hidden" name="state" value="isNull">
				<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2()">查询</a>
			</div>
		</form>
	</div>
	
	
	<div id="dialog3" class="easyui-dialog" style="width: 930px;height: 600px;text-align: center;"
  		data-options="closed: true,draggable:true,resizable:true,modal:true">
  		<table id="dg3"></table>
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

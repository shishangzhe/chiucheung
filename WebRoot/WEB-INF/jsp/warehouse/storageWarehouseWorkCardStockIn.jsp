<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>标准配件入库单</title>
	
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
  
  
	  $(function(){
		  $('#dg').treegrid({
				title:'标准配件入库单',
				fit:true,//当设置为true的时候面板大小将自适应父容器
				//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			    url:'${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findAllWarStorageWarehouseWorkCardStockInList.action',    
			    idField:'id',    
			    remoteSort:true,//从服务器进行排序    
			    treeField:'stockInNo',  
			    toolbar: '#gridToolBar',
			    pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
			    //rownumbers:true,//显示一个行号列。
			    //lines:true,//定义是否显示treegrid行
			    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
			    frozenColumns:[[
								{field:'stockInNo',title:'入库单号',width:150,align:'center',sortable:true},
								{field:'preparer',title:'制表人',width:110,align:'center',sortable:true},
								{field:'createTime',title:'时间',width:110,align:'center',sortable:true},
		                      ]],
			    columns:[[	
							{field:'sequence',title:'序号',width:40,align:'center'},
							{field:'workCardNo',title:'工咭号',width:100,align:'center'},
							{field:'materialCode',title:'代码',width:100,align:'center'},
					        {field:'materialName',title:'名称',width:150,align:'center'},
					        {field:'unit',title:'单位',width:40,align:'center'},
							{field:'materialModel',title:'规格',width:180,align:'center'},
					        {field:'quantity',title:'数量',width:60,align:'center'},
					        {field:'warehouseInventory',title:'仓存',width:60,align:'center'},
					        {field:'warehousePositions',title:'仓位',width:110,align:'center'},
					        {field:'remark',title:'备注',width:110,align:'center'},
					        {field:'processInstanceId',title:'任务类型',width:70}
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
			    	var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findAllWarStorageWarehouseWorkCardStockInSubsidiaryListByWarStorageWarehouseWorkCardStockInId.action?warStorageWarehouseWorkCardStockInId=' + row.id; 
	                $(this).treegrid("options").url = url;  
	                return true; 
	            },onExpand : function(row){
	            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
	            	var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findAllWarStorageWarehouseWorkCardStockInList.action'; 
	                $(this).treegrid("options").url = url;  
	            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
	            	var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findAllWarStorageWarehouseWorkCardStockInList.action'; 
	                $(this).treegrid("options").url = url;  
	            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
	            	var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findAllWarStorageWarehouseWorkCardStockInList.action'; 
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
			
			
			
			$('#cc').combogrid({
			    idField:'id',//下列表的标识id    
			    textField:'accessoriesName',//下拉框文本显示的字段
			    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
			    multiple:true,//允许多选
			    ctrlSelect:true,
			    panelWidth:750,
			    panelHeight:'auto',
			    editable:false,//下拉框文本不可以编辑
			    pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
			    toolbar:'#gridToolBar2',
			    frozenColumns:[[
							{field:'workCardNo',title:'工咭号',width:70,align:'center',sortable:true},
							{field:'materialCode',title:'代码',width:120,align:'center',sortable:true},
							{field:'materialName',title:'名称',width:100,align:'center',sortable:true},
		                      ]],
			    columns:[[	
							{field:'materialModel',title:'规格',width:250,align:'center',sortable:true},
							{field:'quantity',title:'数量',width:50,align:'center',sortable:true},
							{field:'useUnit',title:'单位',width:50,align:'center',sortable:true},
							{field:'warehouseInventory',title:'仓存',width:50,align:'center',sortable:true},
							{field:'warehousePositions',title:'仓位',width:50,align:'center',sortable:true},
							{field:'remark',title:'备注',width:50,align:'center',sortable:true},
					    ]],//表格的各个字段
			    onShowPanel:function(){//显示combogrid下拉框事件
			    	/* $(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/warehouse/standardAccessoriesStockIn/findAllCompleteStorageWarehouseWorkCardSubsidiaryList.action';
			    	var tempRow = $(".add").length;
			    	//表示已经加载了数据，则不加载已经加载的数据
			    	if (tempRow > 0){
			    		var ids = "";
			    		for (var i=0;i<tempRow;i++){
			    			var id = $("#proStorageWarehouseWorkCardSubsidiaryId"+i).val();
			    			if (i == tempRow-1){
				    			ids = ids + id;
				    		}else{
				    			ids = ids + id + ",";
				    		}
			    		}
			    		$(this).combogrid('grid').datagrid('load',{notInId:ids});//重新加载数据，加载的数据不包含ids里的数据
			    	}else{
			    		$(this).combogrid('grid').datagrid('load',{});//重新加载数据，加载的数据不包含ids里的数据
			    	}
					$(this).combogrid('grid').datagrid('clearSelections');//清除所有选择的行 */
					
					
					var g = $(this).combogrid('grid');
					var queryParams = g.datagrid('options').queryParams;
					var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findAllCompleteStorageWarehouseWorkCardSubsidiaryList.action';
					var tempRow = $(".add").length;
			    	//表示已经加载了数据，则不加载已经加载的数据
			    	var flag = $("#flag").val();//获取标识符，
			    	if (tempRow > 0){
			    		var ids = "";
			    		for (var i=0;i<tempRow;i++){
			    			var id = $("#proStorageWarehouseWorkCardSubsidiaryId"+i).val();
			    			if (i == tempRow-1){
				    			ids = ids + id;
				    		}else{
				    			ids = ids + id + ",";
				    		}
			    		}
			    		url = url + "?notInId=" + ids;
			    		if (flag == "update"){
			    			url = url + "&warStorageWarehouseWorkCardStockInId=" + $("#id").val();
				    	}
			    	}else {
			    		if (flag == "update"){
			    			url = url + "?warStorageWarehouseWorkCardStockInId=" + $("#id").val();
				    	}
			    	}
			    	
			    	g.datagrid('options').url = url;
			    	g.datagrid('load',queryParams);//重新加载数据，加载的数据不包含ids里的数据
			    	$("#query2Form").form("load",queryParams);
			    },
				onHidePanel:function(){//隐藏combogrid下拉框的事件
					var g = $('#cc').combogrid('grid');	// 获取数据表格对象
					var check = g.datagrid('getSelections');	// 获取选择的行
					for (var i=0;i<check.length;i++){
						var tempRow = $(".add").length;
						addTable();
						$("#workCardNo" + tempRow).textbox('setValue',check[i].workCardNo);
						$("#materialCode" + tempRow).textbox('setValue',check[i].materialCode);
						$("#materialName" + tempRow).textbox('setValue',check[i].materialName);
						$("#materialModel" + tempRow).textbox('setValue',check[i].materialModel);
						$("#proStorageWarehouseWorkCardSubsidiaryId" + tempRow).val(check[i].id);
						$("#quantity" + tempRow).numberbox('setValue',check[i].quantity);
						$("#useUnit" + tempRow).textbox('setValue',check[i].useUnit);
						$("#warehouse" + tempRow).textbox('setValue',check[i].warehouse);
						$("#warehousePositions" + tempRow).textbox('setValue',check[i].warehousePositions);
					}
					$("#cc").combogrid('setText');//清空选择的值
					g.datagrid('clearSelections');
				}
			});
			
			//加载选择的按钮
			$('#cc').combogrid('grid').datagrid({
				onLoadSuccess:function(data){
					var tr = $("div[class='datagrid-pager pagination']").children("table").children("tbody").children("tr");
					if (tr.children("td").length == 13){
						tr.append('<td style="padding-left:30px;">' + '<a id="selectData" class="easyui-linkbutton" iconCls="icon-ok" onClick="selectData()" style="float: left;">选择</a>' + '</td>');
					}else if (tr.children("td").length > 13){
						tr.children("td").last().html('<a id="selectData" class="easyui-linkbutton" iconCls="icon-ok" onClick="selectData()" style="float: left;">选择</a>');
					}
					$("#selectData").linkbutton();
				}
			});
			
			/* //加载分类的combobox
			$('#classificationQuery2').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "分类"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:false//不允许编辑
			}); */
			
			$("#classificationQuery").combobox({
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
			
			//form查询表单的回车事件，回车提交
			$("#queryForm").keyup(function (event){
				if (event.keyCode == 13){
					query();
				}
			});
			
			//form查询表单的回车事件，回车提交
			$("#query2Form").keyup(function (event){
				if (event.keyCode == 13){
					query2();
				}
			});
	  });
	  
	  function selectData(){
		$("#cc").combogrid('hidePanel');
	  }
	  
	  
	  
	  function addTable(){
			var tempRow = $(".add").length;
			var tr = $('<tr class="add" style="height: 30px"></tr>');
			
			var td1 = $('<td style="width: 20px;"></td>');
			var td1Id = $('<input id="id' +tempRow + '" type="hidden" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].id" value="">');
			var td1Sequence = $('<input id="sequence' +tempRow + '" type="hidden" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
			var td1proStorageWarehouseWorkCardSubsidiaryId = $('<input id="proStorageWarehouseWorkCardSubsidiaryId' +tempRow+ '" type="hidden" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].proStorageWarehouseWorkCardSubsidiaryId" value="">');
			var td1Span = $('<span id="number' + tempRow + '">'+(tempRow+1)+'</span>');
			td1.append(td1Id);
			td1.append(td1Sequence);
			td1.append(td1proStorageWarehouseWorkCardSubsidiaryId);
			td1.append(td1Span);
			tr.append(td1);
			
			var td2 = $('<td></td>');
			var td2Content = $('<input id="workCardNo' + tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].workCardNo" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true,required:true,missingMessage:\'工咭号不能为空\'">');
			td2.append(td2Content);
			tr.append(td2);
			
			var td3 = $('<td></td>');
			var td3Content = $('<input id="materialCode' + tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].materialCode" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true,required:true,missingMessage:\'代码不能为空\'">');
			td3.append(td3Content);
			tr.append(td3);
			
			var td4 = $('<td></td>');
			var td4Content = $('<input id="materialName' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].materialName" style="width: 100%;height: 27px" data-options="readonly:true,required:true,missingMessage:\'名称不能为空\'">');
			td4.append(td4Content);
			tr.append(td4);
			
			var td5 = $('<td></td>');
			var td5Content = $('<input id="materialModel' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].materialModel" style="width: 100%;height: 27px" data-options="readonly:true">');
			td5.append(td5Content);
			tr.append(td5);
			
			var td6 = $('<td></td>');
			var td6Content = $('<input id="quantity' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].quantity" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'数量不能为空\',validType:\'positiveInteger\'">');
			td6.append(td6Content);
			tr.append(td6);
			
			var td7 = $('<td></td>');
			var td7Content = $('<input id="useUnit' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].useUnit" style="width: 100%;height: 27px" data-options="readonly:true">');
			td7.append(td7Content);
			tr.append(td7);
			
			var td8 = $('<td></td>');
			var td8Content = $('<input id="warehouse' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].warehouse" style="width: 100%;height: 27px" data-options="readonly:true">');
			td8.append(td8Content);
			tr.append(td8);
			
			var td9 = $('<td></td>');
			var td9Content = $('<input id="warehousePositions' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].warehousePositions" style="width: 100%;height: 27px" data-options="readonly:true">');
			td9.append(td9Content);
			tr.append(td9);
			
			var td10 = $('<td></td>');
			var td10Content = $('<input id="remark' +tempRow + '" name="storageWarehouseWorkCardStockInSubsidiaryCustoms[' + tempRow + '].remark" style="width: 92px;height: 27px">');
			td10.append(td10Content);
			tr.append(td10);
			
			var td11 = $('<td></td>');
			var td11Content = $('<a id="button' + tempRow + '" plain="true" data-options="iconCls:\'icon-clear\'" onclick="delTable(' + (tempRow+1) + ')"></a>');
			td11.append(td11Content);
			tr.append(td11);
			
			$("#table").append(tr);
			//$(".add").last().after(tr);
			td2Content.textbox();
			td3Content.textbox();
			td4Content.textbox();
			td5Content.textbox();
			td6Content.numberbox();
			td7Content.textbox();
			td8Content.textbox();
			td9Content.textbox();
			td10Content.textbox();
			td11Content.linkbutton();
		}
	  
	  
	  /**
		 *删除表格
		 *@param obj 点击的当前的按钮
		 *@param sequence 当前行的序号
		**/
		function delTable(sequence){
			var tempRow = $(".add").length;
			if (sequence < tempRow){
				//把后面的数据往上移，删除最后的行
				for (var i=sequence;i<tempRow;i++){
					$("#id"+(i-1)).val($("#id"+i).val());
					//$("#sequence"+(i-1)).val($("#sequence"+i).val());
					$("#proStorageWarehouseWorkCardSubsidiaryId"+(i-1)).val($("#proStorageWarehouseWorkCardSubsidiaryId"+i).val());
					//$("#number"+(i-1)).html(i);
					$("#workCardNo"+(i-1)).textbox('setValue',$("#workCardNo"+i).textbox('getValue'));
					$("#materialCode"+(i-1)).textbox('setValue', $("#materialCode"+i).textbox('getValue'));
					$("#materialName"+(i-1)).textbox('setValue', $("#materialName"+i).textbox('getValue'));
					$("#materialModel"+(i-1)).textbox('setValue',$("#materialModel"+i).textbox('getValue'));
					$("#quantity"+(i-1)).numberbox('setValue',$("#quantity"+i).numberbox('getValue'));
					$("#useUnit"+(i-1)).textbox('setValue',$("#useUnit"+i).textbox('getValue'));
					$("#warehouse"+(i-1)).textbox('setValue',$("#warehouse"+i).textbox('getValue'));
					$("#warehousePositions"+(i-1)).textbox('setValue',$("#warehousePositions"+i).textbox('getValue'));
					$("#remark"+(i-1)).textbox('setValue', $("#remark"+i).textbox('getValue'));
					$("#button"+(i-1)).attr("onclick","delTable(" + i + ")");
				}
			}
			$(".add")[tempRow-1].remove();
		}
	  
		function add(){
			$.ajax({
				type:'POST',//post请求
				url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#form1").form('reset');//重置表单数据
					$("#saveButton").linkbutton("enable");
					$("#stockInPeople").textbox('readonly',false);
					$("#cc").combogrid("enable");
					$(".add").remove();
					$("#query2Form").form('reset');
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:'新增仓存工咭入库单'//该dialog的标题
					});
					$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
					$("#id").val("");
					$("#processInstanceId").val("");
				}
			});
		}
		
		function view(){
			var selected = $('#dg').treegrid("getSelected");
			if (selected != null){
				$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				var id = "";
				//判断是否是子节点
				if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
					id = selected._parentId;//取到父节点的ID
				}else{//不是子节点
					id = selected.id;//当前就是父节点，直接取ID
				}
				var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findWarStorageWarehouseWorkCardStockInByIdForView.action';
				$.ajax({
					type:'post',
					url:url,
					data:{id:id},
					async: false,//同步请求
					cache: false,//不缓存此页面
					success:function(data){
						if (data != null && data != ""){
							if (data.success){
								$("#saveButton").linkbutton("disable");
								$("#cc").combogrid("disable");
								$("#stockInPeople").textbox('readonly',true);
								$(".add").remove();
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'查看存仓工咭入库单'//该dialog的标题
								});
								$("#form1").form('load',data.datas.storageWarehouseWorkCardStockIn);
								var storageWarehouseWorkCardStockInSubsidiaryCustoms = data.datas.storageWarehouseWorkCardStockInSubsidiaryCustoms;
								if (storageWarehouseWorkCardStockInSubsidiaryCustoms != undefined && storageWarehouseWorkCardStockInSubsidiaryCustoms.length >0){
									for (var i=0;i<storageWarehouseWorkCardStockInSubsidiaryCustoms.length;i++){
										addTable();
										$("#id" + i).val(storageWarehouseWorkCardStockInSubsidiaryCustoms[i].id);
										$("#workCardNo" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].workCardNo);
										$("#materialCode" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialCode);
										$("#materialName" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialName);
										$("#materialModel" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialModel);
										$("#proStorageWarehouseWorkCardSubsidiaryId" + i).val(storageWarehouseWorkCardStockInSubsidiaryCustoms[i].proStorageWarehouseWorkCardSubsidiaryId);
										$("#quantity" + i).numberbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].quantity);
										$("#quantity" + i).numberbox('readonly',true);//设为只读
										$("#useUnit" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].useUnit);
										$("#warehouse" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].warehouse);
										$("#warehousePositions" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].warehousePositions);
										$("#remark" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].remark);
										$("#remark" + i).textbox('readonly',true);//设为只读
										$("#button" + i).linkbutton("disable");
									}
								}
							}
						}else{
							showErrorMessager("查看失败",data.message);
						}
					}
				});
			}else{
				showMessager("提示","请选择一条记录进行修改");
			}
		}
		
		function edit(){
			var selected = $('#dg').treegrid("getSelected");
			if (selected != null){
				$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				var id = "";
				//判断是否是子节点
				if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
					id = selected._parentId;//取到父节点的ID
				}else{//不是子节点
					id = selected.id;//当前就是父节点，直接取ID
				}
				var url = '${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/findWarStorageWarehouseWorkCardStockInByIdForEdit.action';
				$.ajax({
					type:'post',
					url:url,
					data:{id:id},
					async: false,//同步请求
					cache: false,//不缓存此页面
					success:function(data){
						if (data != null && data != ""){
							if (data.success){
								if (data.datas.isEdit){
									$("#form1").form('reset');//重置表单数据
									$("#saveButton").linkbutton("enable");
									$("#cc").combogrid("enable");
									$("#stockInPeople").textbox('readonly',data.datas.stockInPeople);
									$(".add").remove();
									$("#dialog1").dialog({//加载一个dialog
										closed:false,//将该dialog的状态由不显示改成显示
										title:'修改存仓工咭入库单'//该dialog的标题
									});
									$("#form1").form('load',data.datas.storageWarehouseWorkCardStockIn);
									var storageWarehouseWorkCardStockInSubsidiaryCustoms = data.datas.storageWarehouseWorkCardStockInSubsidiaryCustoms;
									if (storageWarehouseWorkCardStockInSubsidiaryCustoms != undefined && storageWarehouseWorkCardStockInSubsidiaryCustoms.length >0){
										for (var i=0;i<storageWarehouseWorkCardStockInSubsidiaryCustoms.length;i++){
											addTable();
											$("#id" + i).val(storageWarehouseWorkCardStockInSubsidiaryCustoms[i].id);
											$("#workCardNo" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].workCardNo);
											$("#materialCode" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialCode);
											$("#materialName" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialName);
											$("#materialModel" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialModel);
											$("#proStorageWarehouseWorkCardSubsidiaryId" + i).val(storageWarehouseWorkCardStockInSubsidiaryCustoms[i].proStorageWarehouseWorkCardSubsidiaryId);
											$("#quantity" + i).numberbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].quantity);
											$("#useUnit" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].useUnit);
											$("#warehouse" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].warehouse);
											$("#warehousePositions" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].warehousePositions);
											$("#remark" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].remark);
										}
									}
								}else{
									alert(data.datas.doNotEditMessage);
									$("#saveButton").linkbutton("disable");
									$("#cc").combogrid("disable");
									$("#stockInPeople").textbox('readonly',true);
									$(".add").remove();
									$("#dialog1").dialog({//加载一个dialog
										closed:false,//将该dialog的状态由不显示改成显示
										title:'查看存仓工咭入库单'//该dialog的标题
									});
									$("#form1").form('load',data.datas.storageWarehouseWorkCardStockIn);
									var storageWarehouseWorkCardStockInSubsidiaryCustoms = data.datas.storageWarehouseWorkCardStockInSubsidiaryCustoms;
									if (storageWarehouseWorkCardStockInSubsidiaryCustoms != undefined && storageWarehouseWorkCardStockInSubsidiaryCustoms.length >0){
										for (var i=0;i<storageWarehouseWorkCardStockInSubsidiaryCustoms.length;i++){
											addTable();
											$("#id" + i).val(storageWarehouseWorkCardStockInSubsidiaryCustoms[i].id);
											$("#workCardNo" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].workCardNo);
											$("#materialCode" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialCode);
											$("#materialName" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialName);
											$("#materialModel" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].materialModel);
											$("#proStorageWarehouseWorkCardSubsidiaryId" + i).val(storageWarehouseWorkCardStockInSubsidiaryCustoms[i].proStorageWarehouseWorkCardSubsidiaryId);
											$("#quantity" + i).numberbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].quantity);
											$("#quantity" + i).numberbox('readonly',true);//设为只读
											$("#useUnit" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].useUnit);
											$("#warehouse" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].warehouse);
											$("#warehousePositions" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].warehousePositions);
											$("#remark" + i).textbox('setValue',storageWarehouseWorkCardStockInSubsidiaryCustoms[i].remark);
											$("#remark" + i).textbox('readonly',true);//设为只读
											$("#button" + i).linkbutton("disable");
										}
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
		
		
		//保存标准配件入库单
		function save(){
			if ($("#form1").form('validate')){//判断 验证是否通过
				if ($(".add").length > 0){
					var url = "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/";
					var flag = $("#flag").val();//获取标识符，
					if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
						url = url + "saveWarStorageWarehouseWorkCardStockIn.action";
					}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
						url = url + "updateWarStorageWarehouseWorkCardStockIn.action";
					}
					$.ajax({
						type:'POST',//post请求
						url: url,//ajax请求的url
						data: $( "#form1" ).serialize(),
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data != null && data != ""){
								if (data.success){
									showMessager("提示","保存成功");
									$("#dialog1").dialog({//关闭这个dialog
										closed:true
									});
									$("#dg").treegrid('reload');//重新加载数据，保持在当前页
								}else{
									showErrorMessager("保存失败",data.message);
								}
							}
						}
					});
				}else{
					showMessager("提示",'<font color="red">'+"请至少添加一个配件"+'<font/>');
				}
			}
		}
	  
		
		//删除入库单
		function removeData(){
			var selected = $("#dg").treegrid('getSelected');//取得选中的行
			if (selected==null){
				showMessager("提示","请选择一条记录进行删除");
			}else{
				$.messager.confirm('确认对话框', '是否删除？', function(b){
					if (b){//如何用户点击的是确认
						var id = "";
						//判断是否是子节点
						if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
							id = selected._parentId;//取到父节点的ID
						}else{//不是子节点
							id = selected.id;//当前就是父节点，直接取ID
						}
						$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/deleteWarStorageWarehouseWorkCardStockInById.action",//ajax请求的url
							data: {id:id},//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data != null && data != ""){
									if (data.success){
										showMessager("提示","删除成功");
										$("#dg").treegrid('reload');//重新加载数据，保持在当前页
										$("#dg").treegrid('clearSelections');//清除所有选择的行。
									}else{
										showErrorMessager("删除失败",data.message);
									}
								}
							}
						});
					}
				});
			}
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
						url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/queryAuditorById.action",//ajax请求的url
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
												url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/auditWarStorageWarehouseWorkCardStockIn.action",//ajax请求的url
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
			var selected = $("#auditUserDg").treegrid('getSelected');//取得选中的行
			if (selected==null){
				showMessager("提示","请先选择接收任务的人员");
			}else{
				var assigneeId = selected.id;
				if (assigneeId != undefined && assigneeId !=null && assigneeId != ''){
					//var processInstanceId = $("#processInstanceId").val();
					var id = $("#id").val();
					$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/auditWarStorageWarehouseWorkCardStockIn.action",//ajax请求的url
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
								url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/revokeProcess.action",//ajax请求的url
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
							url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/takeBackWarStorageWarehouseWorkCardStockIn.action",//ajax请求的url
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
							url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/rollBackWarStorageWarehouseWorkCardStockIn.action",//ajax请求的url
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
							url: "${pageContext.request.contextPath}/warehouse/storageWarehouseWorkCardStockIn/antiAuditWarStorageWarehouseWorkCardStockIn.action",//ajax请求的url
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
	  
	  
	  function reload(){
		  $("#dg").treegrid("reload");
	  }
	
	
  	function query(){
  		$("#dg").treegrid('load',$("#queryForm").serializeObject());
  	}
  	
  	function query2(){
		$("#cc").combogrid("grid").datagrid('load',$("#query2Form").serializeObject());
	}
  </script>
<body>   
	<table id="dg"
		data-options="onDblClickRow:function (row){
													    	if ($(this).treegrid('isLeaf',row.id)){//判断是否是子节点
														    	<p:isPrivilege pid="im" mid="imb">
														    		edit();//是子节点则开始编辑
													    		</p:isPrivilege>
													    	}else{
														    	<p:isPrivilege pid="ii" mid="im">
															    	$(this).treegrid(row.state == 'closed' ? 'expand' : 'collapse',row.id);//是父节点则展开或折叠
														    	</p:isPrivilege>
													    	}
													    }"
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="im" mid="ima">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="im" mid="imb">
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="view();" style="float: left;">查看</a> <div class="btn-separator"></div>
			<p:isPrivilege pid="im" mid="imc">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="im" mid="imd">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="queryAuditor();" style="float: left;">审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="revokeProcess();" style="float: left;">撤销流程</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openTakeBackDialog();" style="float: left;">收回审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openRollBackDialog();" style="float: left;">退回审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="im" mid="ime">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAntiAuditDialog();" style="float: left;">反审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				入库单号：<input id="stockInNoQuery" class="easyui-textbox" name="stockInNo" style="width: 100px;">
				制表人：<input id="preparerQuery" class="easyui-textbox" name="preparer" style="width: 100px;">
				日期：<input id="startCreateTime_query" type="text" name="startCreateTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endCreateTime_query" type="text" name="endCreateTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				物料代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 100px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
  		<p:isPrivilege pid="im" mid="ima">
   			<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="im" mid="imb">
   			<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
   		<div data-options="iconCls:'icon-edit'" onclick="view();">查看</div>
	    <p:isPrivilege pid="im" mid="imc">
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
	    </p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="im" mid="imd">
	    	<div data-options="iconCls:'icon-man'" onclick="queryAuditor();">审核</div>
		    <div data-options="iconCls:'icon-cancel'" onclick="revokeProcess();">撤销流程</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openTakeBackDialog();">收回审核</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openRollBackDialog();">退回审核</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="im" mid="ime">
    		<div data-options="iconCls:'icon-man'" onclick="openAntiAuditDialog();">反审核</div>
    	</p:isPrivilege>
	</div>
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 900px;height: 425px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<input id="processInstanceId" type="hidden" name="processInstanceId" value="">
  			<div style="width: 860px;height: 40px;">
  				<div style="width: 50%;text-align: center;float: left;">
	  				入库单号：<input id="stockInNo" class="easyui-textbox" name="stockInNo" readonly="readonly">
	  			</div>
	  			<div style="width: 50%;text-align: center;float: left;">
	  				日期：<input id="createTime" name="createTime" class="easyui-datebox" style="width: 90px" value="<p:date/>" data-options="editable:false,readonly:true,required:true,missingMessage:'日期不能为空'">
				</div>
			</div>
			请选择入库的标准配件：<input id="cc" style="width: 613px;"/>
			<div style="height: 240px;overflow: auto;">
				<table id="table" cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
			  			<tr style="height: 30px">
			  				<td style="width: 3%">
			  					序号
			  				</td>
			  				<td style="width: 10%">
			  					工咭号
			  				</td>
			  				<td style="width: 14%">
			  					代码
			  				</td>
			  				<td style="width: 18%">
			  					名称
			  				</td>
			  				<td style="width: 19%">
			  					规格
			  				</td>
			  				<td style="width: 5%">
			  					数量
			  				</td>
			  				<td style="width: 5%">
			  					单位
			  				</td>
			  				<td style="width: 6%">
			  					仓存
			  				</td>
			  				<td style="width: 6%">
			  					仓位
			  				</td>
			  				<td style="width: 11%">
			  					备注
			  				</td>
			  				<td style="width: 3%">
			  					
			  				</td>
			  			</tr>
		  			</table>
	  			</div>
	  			<div>
		  			制表人：<input id="preparer" class="easyui-textbox" name="preparer" style="width: 100px;" value="${user.username}" readonly="readonly">
		  			品管验收：<input id="qcAcceptance" class="easyui-textbox" name="qcAcceptance" style="width: 100px;" readonly="readonly">
		  			入库人：<input id="stockInPeople" class="easyui-textbox" name="stockInPeople" style="width: 100px;" required="required">
		  			审核人：<input id="reviewer" class="easyui-textbox" name="reviewer" style="width: 100px;" readonly="readonly">
		  			审核时间：<input id="auditTime" class="easyui-textbox" name="auditTime" style="width: 100px;" readonly="readonly">
	  			</div>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a id="saveButton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
	
	
	<div id="gridToolBar2" style="padding:5px;height:auto;">
		<form id="query2Form">
			工咭号：<input id="workCardNoQuery" class="easyui-textbox" name="workCardNo" style="width: 100px;">
			K3代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 100px;">
			名称：<input id="materialNameQuery" class="easyui-textbox" name="materialName" style="width: 100px;">
			分类：<input id="classificationQuery" name="classification" data-options="queryParams: {'keyword' : '分类'}" style="width: 130px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2()">查询</a>
		</form>
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

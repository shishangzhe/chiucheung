<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>项目信息评审-交期评审</title>
	<jsp:include page="/common.jsp"></jsp:include>
  </head>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	window.onload=window.onresize = function(){
		//当浏览器小于这个窗口时，将该窗口设置成浏览器大小
		if ($(document.body).width()<$("#dialog").width()){
			$("#dialog").dialog({
				closed:$("#dialog").dialog("options").closed,
				width: $(document.body).width()
			});
		}else{
			$("#dialog").dialog({
				closed:$("#dialog").dialog("options").closed,
				width: 900
			});
		}
		$("#dialog").dialog({//加载一个dialog
			closed:$("#dialog").dialog("options").closed,
			left:($(document.body).width()-$("#dialog").width()-14)/2,
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
		//checkbox单选
		$("input[type='checkbox'][class!='noRadio']").click(function(){
			var name = $(this).attr("name");
			var value = $(this).val();
			$("input[name='"+name+"']").each(function(index,domEle){
				if (value != $(domEle).val()){
					$(domEle).attr("checked",false);
				}
			});
		});
		
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
						//由于form的keydown事件，无法捕捉到下面的combobox的keyCode，所以加到这里来
						query2();
					}
				},
				change:function(){
					editableComboboxAutoCompleteSelect(this);
		    	}
			},
		    filter: function(q, row){
	        	var opts = $(this).combobox('options');
	        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
	        }
		});
		
		$('#lowestWarehousingQuantityQuery').combobox("clear");
		
		
		//B.批核程序
		$("input[name='approvalProcedures']").click(function(){
			if ($(this).val() == '样板批核才生产'){
				if ($(this).is(':checked')){
					$("#approvalProceduresContent").textbox('enable');
				}else{
					$("#approvalProceduresContent").textbox('disable');
					$("#approvalProceduresContent").textbox('clear');
				}
			}
		});
		
		//H.交货地点 
		$("input[name='deliveryPlace']").click(function(){
			if ($(this).val() == '转送外地' && $(this).is(':checked')){
				$("#deliveryPlaceContent").textbox('enable');
			}else{
				$("#deliveryPlaceContent").textbox('disable');
				$("#deliveryPlaceContent").textbox('clear');
			}
		});
		
		$('#dg').treegrid({
			title:'存仓工咭',
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
		    url:'${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findAllProStorageWarehouseWorkCardList.action',    
		    idField:'id',    
		    remoteSort:true,//从服务器进行排序    
		    treeField:'workCardNo',  
		    toolbar: '#gridToolBar',
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    //rownumbers:true,//显示一个行号列。
		    //lines:true,//定义是否显示treegrid行
		    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
		    frozenColumns:[[
							{field:'workCardNo',title:'工咭号',width:150,align:'center',sortable:true},
							{field:'preparer',title:'制表人',width:110,align:'center',sortable:true},
							{field:'workCardLeader',title:'工咭项目负责人',width:110,align:'center',sortable:true},
							{field:'workCardDate',title:'下工咭日期',width:80,align:'center',sortable:true},
	                      ]],
		    columns:[[	
						{field:'sequence',title:'序号',width:40,align:'center'},
						{field:'materialCode',title:'代码',width:100,align:'center'},
				        {field:'materialName',title:'名称',width:150,align:'center'},
						{field:'materialModel',title:'规格',width:180,align:'center'},
						{field:'quantity',title:'数量',width:60,align:'center'},
				        {field:'useUnit',title:'单位',width:60,align:'center'},
				        {field:'previousDays',title:'前置天数',width:60,align:'center'},
				        {field:'expectedDeliveryDate',title:'预交货期',width:110,align:'center'},
				        {field:'engReleaseDataDate',title:'工程下资料日期',width:110,align:'center'},
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
		    	var url = '${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId.action?proStorageWarehouseWorkCardQueryId=' + row.id; 
                $(this).treegrid("options").url = url;  
                return true; 
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findAllProStorageWarehouseWorkCardList.action'; 
                $(this).treegrid("options").url = url;  
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findAllProStorageWarehouseWorkCardList.action'; 
                $(this).treegrid("options").url = url;  
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findAllProStorageWarehouseWorkCardList.action'; 
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
		    textField:'materialCode',//下拉框文本显示的字段
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
						{field:'materialCode',title:'代码',width:120,align:'center',sortable:true},
						{field:'materialName',title:'名称',width:100,align:'center',sortable:true},
						{field:'existingQuantity',title:'现存数量',width:80,align:'center',sortable:true},
	                      ]],
		    columns:[[	
						{field:'specifications',title:'规格型号',width:80,align:'center',sortable:true},
						{field:'length',title:'长度',width:50,align:'center',sortable:true},
						{field:'width',title:'宽度',width:50,align:'center',sortable:true},
						{field:'height',title:'高度',width:50,align:'center',sortable:true},
						{field:'depth',title:'深度',width:50,align:'center',sortable:true},
						{field:'color',title:'颜色',width:50,align:'center',sortable:true},
						{field:'useUnit',title:'单位',width:50,align:'center',sortable:true},
						{field:'lowestWarehousingQuantity',title:'最低存仓量',width:80,align:'center',sortable:true},
						{field:'onceProduceQuantity',title:'一次生产量',width:80,align:'center',sortable:true}
				    ]],//表格的各个字段
		    onShowPanel:function(){//显示combogrid下拉框事件
		    	$(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findAllWarMaterialInventoryList.action';
		    	var tempRow = $(".add").length;
		    	var param = $("#query2Form").serializeObject();
		    	//表示已经加载了数据，则不加载已经加载的数据
		    	if (tempRow > 0){
		    		var ids = "";
		    		for (var i=0;i<tempRow;i++){
		    			var id = $("#warMaterialId"+i).val();
		    			if (i == tempRow-1){
			    			ids = ids + id;
			    		}else{
			    			ids = ids + id + ",";
			    		}
		    		}
		    		param.notInId = ids
		    	}
		    	$(this).combogrid('grid').datagrid('load',param);//重新加载数据，加载的数据不包含ids里的数据
		    	
				$(this).combogrid('grid').datagrid('clearSelections');//清除所有选择的行
		    },
			onHidePanel:function(){//隐藏combogrid下拉框的事件
				var g = $('#cc').combogrid('grid');	// 获取数据表格对象
				var check = g.datagrid('getSelections');	// 获取选择的行
				for (var i=0;i<check.length;i++){
					var tempRow = $(".add").length;
					addTable();
					$("#materialCode" + tempRow).textbox('setValue',check[i].materialCode);
					$("#materialName" + tempRow).textbox('setValue',check[i].materialName);
					$("#warMaterialId" + tempRow).val(check[i].id);
					$("#quantity" + tempRow).textbox('setValue',check[i].onceProduceQuantity);
					$("#useUnit" + tempRow).textbox('setValue',check[i].useUnit);
					var materialModel = "";
					if (check[i].specifications != ""){
						materialModel = materialModel + "," + check[i].specifications;
					}
					if (check[i].length != ""){
						materialModel = materialModel + "," + check[i].length;
					}
					if (check[i].width != ""){
						materialModel = materialModel + "," + check[i].width;
					}
					if (check[i].height != ""){
						materialModel = materialModel + "," + check[i].height;
					}
					if (check[i].depth != ""){
						materialModel = materialModel + "," + check[i].depth;
					}
					if (check[i].color != ""){
						materialModel = materialModel + "," + check[i].color;
					}
					$("#materialModel" + tempRow).textbox('setValue',materialModel.substring(1, materialModel.length));
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

		
		//表单提交的回车事件
		/* $("#workCardForm").keyup(function (event){
			if (event.keyCode == 13){
				save();
			}
		}); */
		//查询的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		
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
		var td1Id = $('<input id="id' +tempRow + '" type="hidden" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="sequence' +tempRow + '" type="hidden" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		var td1warMaterialId = $('<input id="warMaterialId' +tempRow+ '" type="hidden" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].warMaterialId" value="">');
		var td1Span = $('<span id="number' + tempRow + '">'+(tempRow+1)+'</span>');
		td1.append(td1Id);
		td1.append(td1Sequence);
		td1.append(td1warMaterialId);
		td1.append(td1Span);
		tr.append(td1);
		
		var td2 = $('<td></td>');
		var td2Content = $('<input id="materialCode' + tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].materialCode" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true,required:true,missingMessage:\'代码不能为空\'">');
		td2.append(td2Content);
		tr.append(td2);
		
		var td3 = $('<td></td>');
		var td3Content = $('<input id="materialName' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].materialName" style="width: 100%;height: 27px" data-options="readonly:true,required:true,missingMessage:\'名称不能为空\'">');
		td3.append(td3Content);
		tr.append(td3);
		
		var td4 = $('<td></td>');
		var td4Content = $('<input id="materialModel' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].materialModel" style="width: 100%;height: 27px" data-options="readonly:true">');
		td4.append(td4Content);
		tr.append(td4);
		
		var td5 = $('<td></td>');
		var td5Content = $('<input id="quantity' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].quantity" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'数量不能为空\',validType:\'positiveInteger\'">');
		td5.append(td5Content);
		tr.append(td5);
		
		var td6 = $('<td></td>');
		var td6Content = $('<input id="useUnit' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].useUnit" style="width: 100%;height: 27px" data-options="readonly:true">');
		td6.append(td6Content);
		tr.append(td6);
		
		var td7 = $('<td></td>');
		var td7Content = $('<input id="previousDays' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].previousDays" style="width: 100%;height: 27px">');
		td7.append(td7Content);
		tr.append(td7);
		
		var td8 = $('<td></td>');
		var td8Content = $('<input id="expectedDeliveryDate' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].expectedDeliveryDate" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'预交货期不能为空\',editable:false">');
		td8.append(td8Content);
		tr.append(td8);
		
		
		var td9 = $('<td></td>');
		var td9Content = $('<input id="engReleaseDataDate' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].engReleaseDataDate" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'工程下资料日期不能为空\',editable:false">');
		td9.append(td9Content);
		tr.append(td9);
		
		
		var td10 = $('<td></td>');
		var td10Content = $('<input id="remark' +tempRow + '" name="storageWarehouseWorkCardSubsidiaries[' + tempRow + '].remark" style="width: 100%;height: 27px">');
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
		td5Content.numberbox();
		td6Content.textbox();
		td7Content.numberbox();
		td8Content.datebox();
		td9Content.datebox();
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
				$("#warMaterialId"+(i-1)).val($("#warMaterialId"+i).val());
				//$("#number"+(i-1)).html(i);
				$("#materialCode"+(i-1)).textbox('setValue', $("#materialCode"+i).textbox('getValue'));
				$("#materialName"+(i-1)).textbox('setValue', $("#materialName"+i).textbox('getValue'));
				$("#materialModel"+(i-1)).textbox('setValue',$("#materialModel"+i).textbox('getValue'));
				$("#quantity"+(i-1)).numberbox('setValue',$("#quantity"+i).numberbox('getValue'));
				$("#previousDays"+(i-1)).numberbox('setValue',$("#previousDays"+i).numberbox('getValue'));
				$("#expectedDeliveryDate"+(i-1)).datebox('setValue',$("#expectedDeliveryDate"+i).datebox('getValue'));
				$("#engReleaseDataDate"+(i-1)).datebox('setValue',$("#engReleaseDataDate"+i).datebox('getValue'));
				$("#remark"+(i-1)).textbox('setValue', $("#remark"+i).textbox('getValue'));
				$("#button"+(i-1)).attr("onclick","delTable(" + i + ")");
			}
		}
		$(".add")[tempRow-1].remove();
	}
	
	function add(){
		$('#lowestWarehousingQuantityQuery').combobox("clear");
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
				$(".add").remove();
				
				$("#saveButton").linkbutton("enable");
				$("#cc").combogrid("enable");
				$("#viewAndEdit").find(".easyui-textbox").each(function(){//设置所有的textbox为只读
					$(this).textbox("readonly",false);
				});
				$("form[id='form1'] :checkbox").attr("disabled",false); 
				
				$("#approvalProceduresContent").textbox('disable');
				$("#deliveryPlaceContent").textbox('disable');
				
				$("#query2Form").form('reset');
				$("#dialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增存仓工咭'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
	}
	
	
	function view(){
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
		if (selected!=null){
			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			var data = "id=" + id;
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findProStorageWarehouseWorkCardByIdForView.action',
				data:data,
				success:function(data){
					if (data != null && data != ""){
						if (data.success){
							$("#form1").form('reset');//重置表单数据
							$(".add").remove();//将添加的表格重置
							$("#saveButton").linkbutton("disable");
							$("#cc").combogrid("disable");
							$("#viewAndEdit").find(".easyui-textbox").each(function(){//设置所有的textbox为只读
								$(this).textbox("readonly",true);
							});
							$("form[id='form1'] :checkbox").attr("disabled","disabled"); 
							$("#approvalProceduresContent").textbox('disable');
							$("#deliveryPlaceContent").textbox('disable');
							$("#dialog").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:'查看存仓工咭'//该dialog的标题
							});
							$("#form1").form('load',data.datas.storageWarehouseWorkCard);
							
							
							//加载特殊的数据
							//批核程序
							if (data.datas.storageWarehouseWorkCard.approvalProcedures.split(',').length > 1){
								for(var i=0;i<data.datas.storageWarehouseWorkCard.approvalProcedures.split(',').length;i++){
									$("input[name='approvalProcedures'][value=" +"'"+ data.datas.storageWarehouseWorkCard.approvalProcedures.split(',')[i] + "'" + "]")[0].checked = true;
								}
								
								if (data.datas.storageWarehouseWorkCard.approvalProcedures.split(',')[i] == "样板批核才生产"){
									$("#approvalProceduresContent").textbox('enable');
								}
							}
							
							//交货地点
							if (data.datas.storageWarehouseWorkCard.deliveryPlace == "转送外地"){
								$("#deliveryPlaceContent").textbox('enable');
							}
							
							//附件
							if (data.datas.storageWarehouseWorkCard.attachment.split(',').length > 1){
								for(var i=0;i<data.datas.storageWarehouseWorkCard.attachment.split(',').length;i++){
									$("input[name='attachment'][value=" +"'"+ data.datas.storageWarehouseWorkCard.attachment.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//抄送
							if (data.datas.storageWarehouseWorkCard.copyTo.split(',').length > 1){
								for(var i=0;i<data.datas.storageWarehouseWorkCard.copyTo.split(',').length;i++){
									$("input[name='copyTo'][value=" +"'"+ data.datas.storageWarehouseWorkCard.copyTo.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//加载配件的多项
							var subsidiaries = data.datas.storageWarehouseWorkCardSubsidiary;
							if (subsidiaries.length > 0){
								for (var i=0;i<subsidiaries.length;i++){
									addTable();
									$("#id"+i).val(subsidiaries[i].id);
									$("#sequence"+i).val(subsidiaries[i].sequence);
									$("#warMaterialId"+i).val(subsidiaries[i].warMaterialId);
									$("#materialCode"+i).textbox('setValue',subsidiaries[i].materialCode);
									$("#materialName"+i).textbox('setValue',subsidiaries[i].materialName);
									$("#materialModel"+i).textbox('setValue',subsidiaries[i].materialModel);
									$("#quantity"+i).numberbox('setValue',subsidiaries[i].quantity);
									$("#quantity"+i).numberbox('readonly',true);
									$("#previousDays"+i).numberbox('setValue',subsidiaries[i].previousDays);
									$("#previousDays"+i).numberbox('readonly',true);
									$("#expectedDeliveryDate"+i).datebox('setValue',subsidiaries[i].expectedDeliveryDate);
									$("#expectedDeliveryDate"+i).datebox('readonly',true);
									$("#engReleaseDataDate"+i).datebox('setValue',subsidiaries[i].engReleaseDataDate);
									$("#engReleaseDataDate"+i).datebox('readonly',true);
									$("#remark"+i).textbox('setValue',subsidiaries[i].remark);
									$("#remark"+i).textbox('readonly',true);
								}
							}
							
							//$("a[id^='button']").linkbutton("disable");
							$("a[id^='button']").remove();
						}else{
							showErrorMessager("查看失败",data.message);
						}
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行查看");
		}
	}
	
	
	function edit(){
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
		if (selected!=null){
			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			var data = "id=" + id;
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/production/storageWarehouseWorkCard/findProStorageWarehouseWorkCardByIdForEdit.action',
				data:data,
				success:function(data){
					if (data != null && data != ""){
						if (data.success){
							if (data.datas.isEdit){
								$("#form1").form('reset');//重置表单数据
								$(".add").remove();//将添加的表格重置
								$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
								
								$("#saveButton").linkbutton("enable");
								$("#cc").combogrid("enable");
								$("#viewAndEdit").find(".easyui-textbox").each(function(){//设置所有的textbox为只读
									$(this).textbox("readonly",false);
								});
								$("form[id='form1'] :checkbox").attr("disabled",false); 
								$("#approvalProceduresContent").textbox('disable');
								$("#deliveryPlaceContent").textbox('disable');
								$("#dialog").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'修改存仓工咭'//该dialog的标题
								});
								$("#form1").form('load',data.datas.storageWarehouseWorkCard);
								
								
								//加载特殊的数据
								//批核程序
								if (data.datas.storageWarehouseWorkCard.approvalProcedures.split(',').length > 1){
									for(var i=0;i<data.datas.storageWarehouseWorkCard.approvalProcedures.split(',').length;i++){
										$("input[name='approvalProcedures'][value=" +"'"+ data.datas.storageWarehouseWorkCard.approvalProcedures.split(',')[i] + "'" + "]")[0].checked = true;
										
										if (data.datas.storageWarehouseWorkCard.approvalProcedures.split(',')[i] == "样板批核才生产"){
											$("#approvalProceduresContent").textbox('enable');
										}
									}
								}
								
								//交货地点
								if (data.datas.storageWarehouseWorkCard.deliveryPlace == "转送外地"){
									$("#deliveryPlaceContent").textbox('enable');
								}
								
								//附件
								if (data.datas.storageWarehouseWorkCard.attachment.split(',').length > 1){
									for(var i=0;i<data.datas.storageWarehouseWorkCard.attachment.split(',').length;i++){
										$("input[name='attachment'][value=" +"'"+ data.datas.storageWarehouseWorkCard.attachment.split(',')[i] + "'" + "]")[0].checked = true;
									}
								}
								//抄送
								if (data.datas.storageWarehouseWorkCard.copyTo.split(',').length > 1){
									for(var i=0;i<data.datas.storageWarehouseWorkCard.copyTo.split(',').length;i++){
										$("input[name='copyTo'][value=" +"'"+ data.datas.storageWarehouseWorkCard.copyTo.split(',')[i] + "'" + "]")[0].checked = true;
									}
								}
								//加载配件的多项
								var subsidiaries = data.datas.storageWarehouseWorkCardSubsidiary;
								if (subsidiaries.length > 0){
									for (var i=0;i<subsidiaries.length;i++){
										addTable();
										$("#id"+i).val(subsidiaries[i].id);
										$("#sequence"+i).val(subsidiaries[i].sequence);
										$("#warMaterialId"+i).val(subsidiaries[i].warMaterialId);
										$("#materialCode"+i).textbox('setValue',subsidiaries[i].materialCode);
										$("#materialName"+i).textbox('setValue',subsidiaries[i].materialName);
										$("#materialModel"+i).textbox('setValue',subsidiaries[i].materialModel);
										$("#quantity"+i).numberbox('setValue',subsidiaries[i].quantity);
										$("#previousDays"+i).numberbox('setValue',subsidiaries[i].previousDays);
										$("#expectedDeliveryDate"+i).datebox('setValue',subsidiaries[i].expectedDeliveryDate);
										$("#engReleaseDataDate"+i).datebox('setValue',subsidiaries[i].engReleaseDataDate);
										$("#remark"+i).textbox('setValue',subsidiaries[i].remark);
									}
								}
							}else{
								//则是查看
								alert(data.datas.doNotEditMessage);
								$("#form1").form('reset');//重置表单数据
								$(".add").remove();//将添加的表格重置
								$("#saveButton").linkbutton("disable");
								$("#cc").combogrid("disable");
								$("#viewAndEdit").find(".easyui-textbox").each(function(){//设置所有的textbox为只读
									$(this).textbox("readonly",true);
								});
								$("form[id='form1'] :checkbox").attr("disabled","disabled"); 
								$("#approvalProceduresContent").textbox('disable');
								$("#deliveryPlaceContent").textbox('disable');
								$("#dialog").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:'查看存仓工咭'//该dialog的标题
								});
								$("#form1").form('load',data.datas.storageWarehouseWorkCard);
								
								
								//加载特殊的数据
								//批核程序
								if (data.datas.storageWarehouseWorkCard.approvalProcedures.split(',').length > 1){
									for(var i=0;i<data.datas.storageWarehouseWorkCard.approvalProcedures.split(',').length;i++){
										$("input[name='approvalProcedures'][value=" +"'"+ data.datas.storageWarehouseWorkCard.approvalProcedures.split(',')[i] + "'" + "]")[0].checked = true;
									}
									
									if (data.datas.storageWarehouseWorkCard.approvalProcedures.split(',')[i] == "样板批核才生产"){
										$("#approvalProceduresContent").textbox('enable');
									}
								}
								
								//交货地点
								if (data.datas.storageWarehouseWorkCard.deliveryPlace == "转送外地"){
									$("#deliveryPlaceContent").textbox('enable');
								}
								
								//附件
								if (data.datas.storageWarehouseWorkCard.attachment.split(',').length > 1){
									for(var i=0;i<data.datas.storageWarehouseWorkCard.attachment.split(',').length;i++){
										$("input[name='attachment'][value=" +"'"+ data.datas.storageWarehouseWorkCard.attachment.split(',')[i] + "'" + "]")[0].checked = true;
									}
								}
								//抄送
								if (data.datas.storageWarehouseWorkCard.copyTo.split(',').length > 1){
									for(var i=0;i<data.datas.storageWarehouseWorkCard.copyTo.split(',').length;i++){
										$("input[name='copyTo'][value=" +"'"+ data.datas.storageWarehouseWorkCard.copyTo.split(',')[i] + "'" + "]")[0].checked = true;
									}
								}
								//加载配件的多项
								var subsidiaries = data.datas.storageWarehouseWorkCardSubsidiary;
								if (subsidiaries.length > 0){
									for (var i=0;i<subsidiaries.length;i++){
										addTable();
										$("#id"+i).val(subsidiaries[i].id);
										$("#sequence"+i).val(subsidiaries[i].sequence);
										$("#warMaterialId"+i).val(subsidiaries[i].warMaterialId);
										$("#materialCode"+i).textbox('setValue',subsidiaries[i].materialCode);
										$("#materialName"+i).textbox('setValue',subsidiaries[i].materialName);
										$("#materialModel"+i).textbox('setValue',subsidiaries[i].materialModel);
										$("#quantity"+i).numberbox('setValue',subsidiaries[i].quantity);
										$("#quantity"+i).numberbox('readonly',true);
										$("#previousDays"+i).numberbox('setValue',subsidiaries[i].previousDays);
										$("#previousDays"+i).numberbox('readonly',true);
										$("#expectedDeliveryDate"+i).datebox('setValue',subsidiaries[i].expectedDeliveryDate);
										$("#expectedDeliveryDate"+i).datebox('readonly',true);
										$("#engReleaseDataDate"+i).datebox('setValue',subsidiaries[i].engReleaseDataDate);
										$("#engReleaseDataDate"+i).datebox('readonly',true);
										$("#remark"+i).textbox('setValue',subsidiaries[i].remark);
										$("#remark"+i).textbox('readonly',true);
									}
								}
								
								$("a[id^='button']").remove();
							}
						}else{
							showErrorMessager("修改失败",data.message);
						}
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	
	//保存存仓工咭
	function save(){
		if ($("#form1").form('validate')){//判断 验证是否通过
			if ($(".add").length > 0){
				var url = "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/";
				var flag = $("#flag").val();//获取标识符，
				if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
					url = url + "saveProStorageWarehouseWorkCard.action";
				}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
					url = url + "updateProStorageWarehouseWorkCard.action";
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
								$("#dialog").dialog({//关闭这个dialog
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
	
	
	//删除存仓工咭
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
						url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/deleteProStorageWarehouseWorkCardById.action",//ajax请求的url
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
					url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/queryAuditorById.action",//ajax请求的url
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
											url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/auditProStorageWarehouseWorkCard.action",//ajax请求的url
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
					url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/auditProStorageWarehouseWorkCard.action",//ajax请求的url
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
							url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/revokeProcess.action",//ajax请求的url
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
						url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/takeBackProStorageWarehouseWorkCard.action",//ajax请求的url
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
						url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/rollBackProStorageWarehouseWorkCard.action",//ajax请求的url
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
						url: "${pageContext.request.contextPath}/production/storageWarehouseWorkCard/antiAuditProStorageWarehouseWorkCard.action",//ajax请求的url
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
		$("#dg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	function query(){
		$("#dg").treegrid('load',$("#queryForm").serializeObject());//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	function query2(){
		var tempRow = $(".add").length;
    	var param = $("#query2Form").serializeObject();
    	//表示已经加载了数据，则不加载已经加载的数据
    	if (tempRow > 0){
    		var ids = "";
    		for (var i=0;i<tempRow;i++){
    			var id = $("#warMaterialId"+i).val();
    			if (i == tempRow-1){
	    			ids = ids + id;
	    		}else{
	    			ids = ids + id + ",";
	    		}
    		}
    		param.notInId = ids
    	}
		$("#cc").combogrid("grid").datagrid('load',param);
	}

  </script>
  <body>
  	<table id="dg"   
  		
  		data-options="onDblClickRow:function (row){
												    	<p:isPrivilege pid="aa" mid="afb">
												    		edit();//是子节点则开始编辑
											    		</p:isPrivilege>
													    	
													    }"
		
  		
  	></table>
  	
  	<div id="gridToolBar" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<p:isPrivilege pid="af" mid="afa">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="af" mid="afb">
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="aa" mid="af">
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="view();" style="float: left;">查看</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="af" mid="afc">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="af" mid="afd">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="queryAuditor();" style="float: left;">审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="revokeProcess();" style="float: left;">撤销流程</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openTakeBackDialog();" style="float: left;">收回审核</a><div class="btn-separator"></div>
				<a class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="openRollBackDialog();" style="float: left;">退回审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="af" mid="afe">
				<a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAntiAuditDialog();" style="float: left;">反审核</a><div class="btn-separator"></div>
			</p:isPrivilege>
			
		</div>
		<div>
			<form id="queryForm">
				工咭编号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				项目负责人：<input id="workCardLeader_query" type="text" name="workCardLeader" style="width: 80px" class="easyui-textbox">
				制表人：<input id="preparer_query" type="text" name="preparer" style="width: 80px" class="easyui-textbox">
				下工咭日期：<input id="startWorkCardDate_query" type="text" name="startWorkCardDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endWorkCardDate_query" type="text" name="endWorkCardDate" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
		<p:isPrivilege pid="af" mid="afa">
    		<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="af" mid="afb">
   			<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="aa" mid="af">
   			<div data-options="iconCls:'icon-edit'" onclick="view();">查看</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="af" mid="afc">
   			<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
   		</p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="af" mid="afd">
    		<div data-options="iconCls:'icon-man'" onclick="queryAuditor();">审核</div>
		    <div data-options="iconCls:'icon-cancel'" onclick="revokeProcess();">撤销流程</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openTakeBackDialog();">收回审核</div>
	   		<div data-options="iconCls:'icon-back'" onclick="openRollBackDialog();">退回审核</div>
    	</p:isPrivilege>
    	<p:isPrivilege pid="af" mid="afe">
    		<div data-options="iconCls:'icon-man'" onclick="openAntiAuditDialog();">反审核</div>
    	</p:isPrivilege>
	</div>
  	<div id="dialog" class="easyui-dialog" style="width: 900px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb'">
  		<div>
			<form id="form1" style="height: 100%" method="post" enctype="multipart/form-data">
	  			<input id="flag" type="hidden" value=""><!-- 用来记录是新增还是修改 -->
	  			<input id="id" type="hidden" name="id" value="">
	  			<input id="processInstanceId" type="hidden" name="processInstanceId">
	  			<input id="reAuditState" type="hidden" name="reAuditState" value="false"><!-- 重新审核的状态，只有重新审核才会设为true，重新审核后，在审核完成，又要设置成false -->
	  			<div id="viewAndEdit"><!-- 用于编辑和查看，需要禁用和启用的字段 -->
	  				<div style="width: 860px;height: 30px;">
		  				<div style="width: 50%;text-align: center;float: left;">
	  						合同号/订单号/报价单号：<input id="quotationNo" type="text" name="quotationNo" class="easyui-textbox" style="width: 200px">
	  					</div>
	  					<div style="width: 30%;text-align: center;float: left;">
	  						工咭号码：<input id="workCardNo" type="text" name="workCardNo" class="easyui-textbox" style="width: 120px" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkStorageWarehouseWorkCardFormat'">
	  					</div>
	  					<div style="width: 20%;text-align: center;float: left;">
	  						日期：<input id="workCardDate" type="text" name="workCardDate" class="easyui-datebox" style="width: 90px" value="<p:date/>" data-options="editable:false,readonly:true,required:true,missingMessage:'日期不能为空'">
	  					</div>
		  			</div>
		  			<br>
		  			<div  style="width: 860px;height: 30px;margin-left: 15px;">
		  				<b style="font-size: larger;">
				  			A 产品：<input id="standardProduct" type="checkbox" name="standardProduct" value="true">标准产品
				  				 <input id="standardProduct" type="checkbox" name="standardProduct" value="false">非标准产品
			  			</b>
			  			<input id="cc" style="width: 600px;"/>
		  			</div>
		  			<table id="table" cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
			  			<tr style="height: 30px">
			  				<td style="width: 3%">
			  					序号
			  				</td>
			  				<td style="width: 12%">
			  					代码
			  				</td>
			  				<td style="width: 18%">
			  					名称
			  				</td>
			  				<td style="width: 19%">
			  					规格
			  				</td>
			  				<td style="width: 6%">
			  					数量
			  				</td>
			  				<td style="width: 3%">
			  					单位
			  				</td>
			  				<td style="width: 4%">
			  					前置<br>天数
			  				</td>
			  				<td style="width: 11%">
			  					预交货期
			  				</td>
			  				<td style="width: 11%">
			  					工程<br>下资料日期
			  				</td>
			  				<td style="width: 10%">
			  					备注
			  				</td>
			  				<td style="width: 3%">
			  					
			  				</td>
			  			</tr>
		  			</table>
		  			<br>
		  				<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
			  				<b>
								B
								批核程序：
							</b>
							<input id="approvalProcedures" class="noRadio" type="checkbox" name="approvalProcedures" value="直接生产">直接生产
							&nbsp;&nbsp;&nbsp;
							<input id="approvalProcedures" class="noRadio" type="checkbox" name="approvalProcedures" value="图纸批核才生产">图纸批核才生产
							&nbsp;&nbsp;&nbsp;
							<input id="approvalProcedures" class="noRadio" type="checkbox" name="approvalProcedures" value="样板批核才生产">
							样板批核才生产（交
							<input id="approvalProceduresContent" class="easyui-textbox" name="approvalProceduresContent" style="width: 40px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
							套样板）
						</div>
						<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						C
		  						用料：
		  					</b>
	  						原材料：<input id="rawMaterials" class="easyui-textbox" name="rawMaterials" style="width: 210px;height: 27px;">
	  						厚度：<input id="thickness" class="easyui-textbox" name="thickness" style="width: 210px;height: 27px;">
	  						性能：<input class="easyui-textbox" name="performance" style="width: 210px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						D
		  						表面效果：
		  					</b>
	  						表面处理：<input class="easyui-textbox" name="surfaceTreatment" style="width: 682px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						E
		  						自检留意事项：
		  					</b>
		  					<input class="easyui-textbox" name="qcAttentionMatters" style="width: 729px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
		  					<b>
		  						F
		  						特做模具：
	  						</b>
	  						<input class="easyui-textbox" name="specialMold" style="width: 760px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						G
		  						外发加工：
		  					</b>
		  					<input class="easyui-textbox" name="outwardProcessing" style="width: 758px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						H
		  						交货地点 ：
	  						</b>
	  						<input type="checkbox" name="deliveryPlace" value="国内">国内&nbsp;
	  						<input type="checkbox" name="deliveryPlace" value="香港">香港
	  						<input type="checkbox" name="deliveryPlace" value="转送外地">转送外地：
	  						<input id="deliveryPlaceContent" class="easyui-textbox" name="deliveryPlaceContent" style="width: 540px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						I
		  						出货方式 ：
	  						</b>
	  						<input class="easyui-textbox" name="shipmentWay" style="width: 338px;height: 27px;">
	  						<b>
	  							安装要求：
	  						</b>
	  						<input class="easyui-textbox" name="installRequir" style="width: 338px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						J
		  						包装形式 ：
		  					</b>
	  						<input type="checkbox" name="packaging" value="纸箱">纸箱
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="packaging" value="木箱">木箱
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="packaging" value="木栏">木栏
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="packaging" value="瓦坑纸">瓦坑纸
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						K
		  						组装形式：
		  					</b>
	  						<input type="checkbox" name="assemblyWay" value="组装">组装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="assemblyWay" value="散装">散装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="assemblyWay" value="半组装">半组装
	  						&nbsp;&nbsp;&nbsp;
	  						最小通道尺寸：<input class="easyui-textbox" name="minChannelSize" style="width: 424px;height: 27px;">
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						L
		  						配件形式：
		  					</b>
	  						<input type="checkbox" name="accessoriesWay" value="独立包装">独立包装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="accessoriesWay" value="装在机柜上">装在机柜上
	  						&nbsp;&nbsp;&nbsp;
	  						其他：<input class="easyui-textbox" name="accessoriesWayContent" style="width: 500px;height: 27px;">
	  					</div>
		  				<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
		  					<b>
			  					M
			  					备注：
			  				</b>
		  					<input class="easyui-textbox" name="remark" style="width: 787px;height: 27px;">
		  				</div>
		  				<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
		  					<b>
			  					N
		  						附件：
		  					</b>
	  						1.<input class="noRadio" type="checkbox" name="attachment" value="批核图">批核图
	  						&nbsp;&nbsp;&nbsp;
	  						2.<input class="noRadio" type="checkbox" name="attachment" value="配件清单">配件清单
	  						&nbsp;&nbsp;&nbsp;
	  						3.<input class="noRadio" type="checkbox" name="attachment" value="文字资料">文字资料
	  						&nbsp;&nbsp;&nbsp;
	  						4.<input class="noRadio" type="checkbox" name="attachment" value="草图做注解">草图做注解
	  						&nbsp;&nbsp;&nbsp;
	  						5.<input class="noRadio" type="checkbox" name="attachment" value="客方原图">客方原图
	  					</div>
	  					<div style="width: 860px;height: 32px;margin-left: 20px;text-align: left;font-size: larger;">
	  						<b>
		  						O
		  						抄送：
		  					</b>
	  						<input class="noRadio" type="checkbox" name="copyTo" value="市场部">市场部
	  						&nbsp;&nbsp;&nbsp;
	  						<input class="noRadio" type="checkbox" name="copyTo" value="工程部">工程部
	  						&nbsp;&nbsp;&nbsp;
	  						<input class="noRadio" type="checkbox" name="copyTo" value="生产部">生产部
	  						&nbsp;&nbsp;&nbsp;
	  						<input class="noRadio" type="checkbox" name="copyTo" value="品管部">品管部
	  						&nbsp;&nbsp;&nbsp;
	  						<input class="noRadio" type="checkbox" name="copyTo" value="物流部">物流部
	  						&nbsp;&nbsp;&nbsp;
	  						<input class="noRadio" type="checkbox" name="copyTo" value="财务部">财务部
	  					</div>
  					</div>
  					<br><br>
  					<div style="width: 860px;height: 32px;margin-left: 20px;font-size: larger;">
  						制表人：<input class="easyui-textbox" name="preparer" style="width: 100px;height: 27px;" readonly="readonly">
  						生产责任人：<input class="easyui-textbox" name="proLeader" style="width: 100px;height: 27px;" readonly="readonly">
  						工咭负责人：<input class="easyui-textbox" name="workCardLeader" style="width: 100px;height: 27px;" readonly="readonly">
  						签批：<input class="easyui-textbox" name="signer" style="width: 100px;height: 27px;" readonly="readonly">
  					</div>
	  		</form>
  		</div>
  	</div>
  	
  	
  	<div id="gridToolBar2" style="padding:5px;height:auto;">
		<form id="query2Form">
			K3代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 100px;">
			库存量：<input id="lowestWarehousingQuantityQuery" class="easyui-combobox clearButton" name="lowestWarehousingQuantity" style="width:130px;" data-options="editable:false,valueField: 'label',
																																										textField: 'value',
																																										data: [{
																																											label: 'true',
																																											value: '低于最低库存量'
																																										},{
																																											label: 'false',
																																											value: '满足最低库存量'
																																										}]"/>
			分类：<input id="classificationQuery"  class="easyui-combobox" name="classification" data-options="queryParams: {'keyword' : '分类'}" style="width: 130px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2()">查询</a>
		</form>
	</div>
  	
  	
  	
  	
  	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb" style="text-align: center;">
  		<p:isPrivilege pid="di" mid="dia">
			<a href="#" id="saveButton" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
		</p:isPrivilege>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog')">关闭</a>
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

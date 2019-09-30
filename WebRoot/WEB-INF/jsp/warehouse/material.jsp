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
  	var isQuery = false;
  	window.onload=window.onresize = function(){
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
	}
  
	  $(function(){
			$(".easyui-combobox").combobox({
				url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
				valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    editable:true,//允许编辑
			    panelHeight:'auto',//面板高度根据内容变化
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
				onLoadSuccess:function(){
					var queryFormObject = $("#queryForm input[name='" + $(this).attr('textboxname') + "']");//combobox加载完之后，name属性就是textboxname属性
					if (queryFormObject.length == 1){//代表queryFrom里有
						queryFormObject.combobox({
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
						    filter: function(q, row){
					        	var opts = $(this).combobox('options');
					        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
					        }
				    	});
						queryFormObject.combobox('loadData',$(this).combobox('getData'));
					}
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			
			$('#dg').treegrid({
				title:'物料',
				fit:true,//当设置为true的时候面板大小将自适应父容器
				//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			    url:'${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action',    
			    idField:'id',    
			    remoteSort:true,//从服务器进行排序    
			    treeField:'materialCode',  
			    toolbar: '#gridToolBar',
			    lines:true,
			    pagination:true,
				pageSize:50,
				pageList:[50,100,200,500],
			    //rownumbers:true,//显示一个行号列。
			    //lines:true,//定义是否显示treegrid行
			    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
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
					        {field:'purchaseUnit',title:'采购单位',width:80,halign:'center',align:'left',sortable:true},
					        {field:'purchaseQuantityAccuracy',title:'采购数量精度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'useUnit',title:'使用单位',width:80,halign:'center',align:'left',sortable:true},
					        {field:'useQuantityAccuracy',title:'使用数量精度',width:80,halign:'center',align:'left',sortable:true},
					        {field:'unitConversionFormula',title:'单位换算公式',width:80,halign:'center',align:'left',sortable:true},
					        {field:'batch',title:'批量',width:80,halign:'center',align:'left',sortable:true},
					        {field:'procurementCycle',title:'采购周期',width:80,halign:'center',align:'left',sortable:true},
					        {field:'division',title:'分割数',width:80,halign:'center',align:'left',sortable:true},
					        {field:'productionWorkshop',title:'生产车间',width:80,halign:'center',align:'left',sortable:true},
					        {field:'lowestWarehousingQuantity',title:'最低存仓量',width:80,halign:'center',align:'left',sortable:true},
					        {field:'highestWarehousingQuantity',title:'最高存仓量',width:80,halign:'center',align:'left',sortable:true},
					        {field:'onceProduceQuantity',title:'<span style="font-size:8px;">一次生产/订购量</span>',width:80,halign:'center',align:'left',sortable:true},
					        {field:'minProduceQuantity',title:'<span style="font-size:8px;">最少生产/订购量</span>',width:80,halign:'center',align:'left',sortable:true},
					        {field:'drawingNumber',title:'图号',width:80,halign:'center',align:'left'},
					        {field:'inspectionStandard',title:'检验标准',width:80,halign:'center',align:'left'},
					        {field:'inspectionWay',title:'检验方式',width:80,halign:'center',align:'left'},
					        {field:'warehouse',title:'仓库',width:60,halign:'center',align:'left',sortable:true},
					        {field:'warehousePositions',title:'仓位',width:60,halign:'center',align:'left',sortable:true},
					        {field:'fileId',title:'附件',width:50,halign:'center',align:'left'},
					        {field:'remark',title:'备注',width:200,halign:'center',align:'left',sortable:true}
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
	            /* onBeforeSortColumn:function(sort, order){//返回false，禁止排序，但是也有问题需要解决，就是不允许排序，但是之前已是升序或者降序的排序，就有问题
	            	return isQuery;
	            }, */
			    onBeforeExpand:function(row){
			    	//动态设置展开查询的url 
			    	var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action?materialCodeForExpand=' + row.materialCode + "&level=" + $(this).treegrid('getLevel',row.id); 
	                $(this).treegrid("options").url = url;  
	                return true; 
	            },onExpand : function(row){
	            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
	            	var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action'; 
	                $(this).treegrid("options").url = url;  
	            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
	            	var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action'; 
	                $(this).treegrid("options").url = url;  
	            },onLoadSuccess : function(row,data){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
	            	var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action'; 
	                $(this).treegrid("options").url = url;
	                if(data.query != undefined && data.query.isQuery){//查询的时候则不以树形表格展示，则以表格的形式展示，isQuery则是标识当前展示的方式
		                $(".tree-icon,.tree-file").remove();
		                $(".tree-inden,.tree-join").remove();
		                $(".tree-inden,.tree-joinbottom").remove();
		                isQuery = data.query.isQuery;
	                }else{
	                	isQuery = false;
	                }
	            }
			});
			
			$("#state").switchbutton({
				onChange:function(checked){
					if (checked){
						$("#dialog1 table tr[class !='group']").hide();
						$('#attachment').filebox('clear');
					}else{
						$("#dialog1 table tr[class !='group']").show();
					}
				}
			});
			
			
			//form查询表单的回车事件，回车提交
			$("#queryForm").keydown(function (event){
				if (event.keyCode == 13){
					query();
				}
			});
	  });
	  
	  
	  function add(){
		  $.ajax({
				type:'POST',//post请求
				url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					$("#form1").form('reset');//重置表单数据
					//$("#state").switchbutton('readonly',false);
					$("#materialCode").textbox('readonly',false);
					$("#stateDiv").show();
					$("#attachmentDiv").show();
					$("#fileDiv").html("");
					$("#fileDiv").hide();
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:'新增物料'//该dialog的标题
					});
					$("#dialog1 table tr[class !='group']").show();
					var select = $("#dg").treegrid("getSelected");
					if (select != null){
						if ($('#dg').treegrid('getParent',select.id) == null){//只有当最子节点的时候，才能获取父节点，如果是子节点还有子节点，无法获取父节点
							$("#materialCode").textbox('setValue',select.materialCode + ".");
						}else{
							$("#materialCode").textbox('setValue',$('#dg').treegrid('getParent',select.id).materialCode + ".");
						}
					}
					$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				}
			});
	  }
	  
	  
	  function edit(){
		  var select = $("#dg").treegrid("getSelected");
	  		if (select != null){
	  			var url = "${pageContext.request.contextPath}/warehouse/material/findMaterialByIdForEdit.action?id="+select.id;//根据ID从后台取数据的url
				$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				$.ajax({
					type:'POST',//post请求
					url: url,//ajax请求的url
					//data: new FormData($( "#form1" )[0]),//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					contentType: false,  
			        processData: false, 
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							if (data.success){
								$("#form1").form('reset');//重置表单数据
								$("#stateDiv").hide();
								$("#materialCode").textbox('readonly',false);
								$("#attachmentDiv").show();
								$("#fileDiv").html("");
								$("#fileDiv").hide();
								$("#dialog1 table tr[class !='group']").show();
								
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:"修改物料"//该dialog的标题
								});
								$("#form1").form('load',data.material);//读取记录填充到表单中。
								
								if (data.material.state == 'closed'){
									$("#materialCode").textbox('readonly',true);
								}else{
									$("#materialCode").textbox('readonly',false);
								}
								if (data.materialFile){
									$("#attachmentDiv").hide();
									$("#fileDiv").show();
									$("#fileDiv").html("<a href='readFileById.action?id="+data.materialFile.id+"' target='target_'>"+data.materialFile.fileName+"</a><image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;'  onclick='deleteFile(\"" + data.materialFile.id +  "\")'>");
								}
							}else{
								showErrorMessager("修改失败", data.message);
							}
						}
					}
				});
	  		}else{
				showMessager("提示","请选择一条记录进行修改");
			}
	  }
	  
	  
	  function copyData(){
		  var select = $("#dg").treegrid("getSelected");
	  		if (select != null){
	  			var url = "${pageContext.request.contextPath}/warehouse/material/findMaterialByIdForCopy.action?id="+select.id;//根据ID从后台取数据的url
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				$.ajax({
					type:'POST',//post请求
					url: url,//ajax请求的url
					//data: new FormData($( "#form1" )[0]),//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					contentType: false,  
			        processData: false, 
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							if (data.success){
								$("#form1").form('reset');//重置表单数据
								$("#stateDiv").show();
								$("#materialCode").textbox('readonly',false);
								$("#attachmentDiv").show();
								$("#fileDiv").html("");
								$("#fileDiv").hide();
								$("#dialog1 table tr[class !='group']").show();
								
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:"新增物料"//该dialog的标题
								});
								$("#form1").form('load',data.material);//读取记录填充到表单中。
							}else{
								showErrorMessager("复制失败", data.message);
							}
						}
					}
				});
	  		}else{
				showMessager("提示","请选择一条记录进行复制");
			}
	  }
	  
	  
	  function saveOrUpdate(){
		  if ($("#form1").form('validate')){
				var flag = $("#flag").val();//获取标识符，
				var url = "${pageContext.request.contextPath}/warehouse/material/";
				if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
					url = url + "saveMaterial.action";
				}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
					url = url + "updateMaterial.action";
				}
				$.ajax({
					type:'POST',//post请求
					url: url,//ajax请求的url
					data: new FormData($( "#form1" )[0]),//传的参数,序列化表单
					async: false,//同步请求
					cache: false,//不缓存此页面
					contentType: false,  
			        processData: false, 
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							if (data.success){
								showMessager("提示","保存成功");
								$("#dialog1").dialog({//关闭这个dialog
									closed:true
								});
								if (isQuery){
									$("#dg").treegrid('reload');//重新加载数据，保持在当前页
								}else{
									//则刷新选择的父节点，也就是会刷新父节点展开的子节点
									if (flag == 'update' && $("#dg").treegrid("getSelected")._parentId != data.parentId){//后面的这个判断，是判断当前选择的是不是更新后的父节点，如果是的话，就不用刷新选择的父节点了，否则都同时刷新一个父节点两次，会出现重复加载数据的问题
										$("#dg").treegrid('reload',$("#dg").treegrid("getSelected")._parentId);
									}
									$("#dg").treegrid('reload',data.parentId);
								}
								/* $("#dg").treegrid('clearSelections');//清除所有选择的行 */
							}else{
								showErrorMessager("保存失败", data.message);
							}
						}
					}
				});
		  }
	  }
	  
	  function reload(){
		  $("#dg").treegrid("reload");
		  $("#dg").treegrid('clearSelections');//清除所有选择的行
	  }
	  
	  function deleteFile(id){
		  $.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/material/deleteWarMaterialFileById.action",//ajax请求的url
						data: {id:id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data != null && data != ""){
								if (data.success){
									showMessager("提示","文件删除成功");
									$("#attachmentDiv").show();
									$("#fileDiv").html("");
									$("#fileDiv").hide();
								}else{
									showErrorMessager("文件删除失败", data.message);
								}
							}
						}
					});
				}
		  });
	  }
	  
	//删除用户数据
  	function removeData(){
  		var select = $("#dg").treegrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/material/deleteWarMaterialById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data != null && data != ""){
								if (data.success){
									showMessager("提示","删除成功");
									$("#dg").treegrid('clearSelections');//清除所有选择的行
									if (isQuery){
										$("#dg").treegrid('reload');//重新加载数据，保持在当前页
									}else{
										$("#dg").treegrid('reload',select._parentId);
									}
								}else{
									showErrorMessager("删除失败", data.message);
								}
							}
						}
					});
				}
  			});
  		}else{
			showMessager("提示","请选择一条记录进行删除");
		}
  	}
	
	
  	function query(){
  		$("#dg").treegrid('load',$("#queryForm").serializeObject());
  	}
  </script>
<body>   
	<table id="dg"
		<p:isPrivilege pid="cd" mid="cdb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="eh" mid="eha">
				<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="eh" mid="ehb">
				<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copyData()" style="float: left;">复制</a> <div class="btn-separator"></div>
			<p:isPrivilege pid="eh" mid="ehc">
				<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			
		</div>
		<div>
			<form id="queryForm">
				代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 80px;">
				名称：<input id="materialNameQuery" class="easyui-textbox" name="materialName" style="width: 80px;">
				类型：<input id="materialTypeQuery" name="materialType" style="width: 80px;">
				适用产品：<input id="applicableProductQuery" name="applicableProduct" style="width: 80px;">
				分类：<input id="classificationQuery" name="classification" style="width: 80px;">
				物料属性：<input id="materialPropertiesQuery" name="materialProperties" style="width: 80px;">
				规格型号：<input id="specificationsQuery" name="specifications" style="width: 80px;">
				颜色：<input id="colorQuery" name="color" style="width: 80px;">
				长度：<input id="lengthQuery" name="length" style="width: 80px;">
				宽度：<input id="widthQuery" name="width" style="width: 80px;">
				高度：<input id="heightQuery" name="height" style="width: 80px;">
				深度：<input id="depthQuery" name="depth" style="width: 80px;">
				仓库：<input id="warehouseQuery" name="warehouse" style="width: 80px;">
				仓位：<input id="warehousePositionsQuery" name="warehousePositions" style="width: 80px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
  		<p:isPrivilege pid="ik" mid="ika">
   			<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
		</p:isPrivilege>
   		<p:isPrivilege pid="ik" mid="ikb">
   			<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
   		<div data-options="iconCls:'icon-large-shapes'" onclick="copyData();">复制</div>
   		<p:isPrivilege pid="ik" mid="ikc">
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
	    </p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 580px;height: 700px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<table style="border-spacing:5px;border-bottom: 0.5px;">
  				<tr class="group">
  					<td colspan="4">
  						<div id="stateDiv">
  							是否是上级分组：<input id="state" name="state" class="easyui-switchbutton" data-options="onText:'Yes',offText:'No',value:'closed'">
  						</div>
  					</td>
  				</tr>
  				<tr class="group">
  					<td style="text-align: right;width: 100px;">代码：</td>
  					<td style="text-align: left;"><input id="materialCode" class="easyui-textbox" name="materialCode" style="width: 150px;" data-options="required:true"></td>
  					<td style="text-align: right;width: 100px;">名称：</td>
  					<td style="text-align: left;"><input id="materialName" class="easyui-textbox" name="materialName" style="width: 150px;" data-options="required:true"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">类型：</td>
  					<td style="text-align: left;"><input id="materialType" class="easyui-combobox" name="materialType" style="width: 150px;" data-options="queryParams: {'keyword' : '类型'}"></td>
  					<td style="text-align: right;">适用产品：</td>
  					<td style="text-align: left;"><input id="applicableProduct" class="easyui-combobox" name="applicableProduct" style="width: 150px;" data-options="multiple:true,queryParams: {'keyword' : '适用产品'}"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">分类：</td>
  					<td style="text-align: left;"><input id="classification" class="easyui-combobox" name="classification" style="width: 150px;" data-options="queryParams: {'keyword' : '分类'}"></td>
  					<td style="text-align: right;">物料属性：</td>
  					<td style="text-align: left;"><input id="materialProperties" class="easyui-combobox" name="materialProperties" style="width: 150px;" data-options="queryParams: {'keyword' : '物料属性'}"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">规格型号：</td>
  					<td style="text-align: left;"><input id="specifications" class="easyui-combobox" name="specifications" style="width: 150px;" data-options="queryParams: {'keyword' : '规格型号'}"></td>
  					<td style="text-align: right;">颜色：</td>
  					<td style="text-align: left;"><input id="color" class="easyui-combobox" name="color" style="width: 150px;" data-options="queryParams: {'keyword' : '颜色'}"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">长度：</td>
  					<td style="text-align: left;"><input id="length" class="easyui-combobox" name="length" style="width: 150px;" data-options="queryParams: {'keyword' : '长度'}"></td>
  					<td style="text-align: right;">宽度：</td>
  					<td style="text-align: left;"><input id="width" class="easyui-combobox" name="width" style="width: 150px;" data-options="queryParams: {'keyword' : '宽度'}"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">高度：</td>
  					<td style="text-align: left;"><input id="height" class="easyui-combobox" name="height" style="width: 150px;" data-options="queryParams: {'keyword' : '高度'}"></td>
  					<td style="text-align: right;">深度：</td>
  					<td style="text-align: left;"><input id="depth" class="easyui-combobox" name="depth" style="width: 150px;" data-options="queryParams: {'keyword' : '深度'}"></td>
  					
  				</tr>
  				<tr>
  					<td style="text-align: right;">采购单位：</td>
  					<td style="text-align: left;"><input id="purchaseUnit" class="easyui-combobox" name="purchaseUnit" style="width: 150px;" data-options="queryParams: {'keyword' : '单位'}"></td>
  					<td style="text-align: right;">采购数量精度：</td>
  					<td style="text-align: left;"><input id="purchaseQuantityAccuracy" class="easyui-numberbox" name="purchaseQuantityAccuracy" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">使用单位：</td>
  					<td style="text-align: left;"><input id="useUnit" class="easyui-combobox" name="useUnit" style="width: 150px;" data-options="queryParams: {'keyword' : '单位'}"></td>
  					<td style="text-align: right;">使用数量精度：</td>
  					<td style="text-align: left;"><input id="useQuantityAccuracy" class="easyui-numberbox" name="useQuantityAccuracy" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">单位换算公式：</td>
  					<td style="text-align: left;"><input id="unitConversionFormula" class="easyui-combobox" name="unitConversionFormula" style="width: 150px;" data-options="queryParams: {'keyword' : '换算公式'}"></td>
  					<td style="text-align: right;">批量：</td>
  					<td style="text-align: left;"><input id="batch" class="easyui-numberbox" name="batch" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">采购周期：</td>
  					<td style="text-align: left;"><input id="procurementCycle" class="easyui-numberbox" name="procurementCycle" style="width: 150px;"></td>
  					<td style="text-align: right;">分割者：</td>
  					<td style="text-align: left;"><input id="division" class="easyui-numberbox" name="division" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">生产车间：</td>
  					<td style="text-align: left;"><input id="production_workshop" class="easyui-textbox" name="productionWorkshop" style="width: 150px;"></td>
  					<td style="text-align: right;">最低存仓量：</td>
  					<td style="text-align: left;"><input id="lowestWarehousingQuantity" type="text" name="lowestWarehousingQuantity" class="easyui-numberbox" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">最高存仓量：</td>
  					<td style="text-align: left;"><input id="highestWarehousingQuantity" type="text" name="highestWarehousingQuantity" class="easyui-numberbox" style="width: 150px;"></td>
  					<td style="text-align: right;">一次生产/订购量：</td>
  					<td style="text-align: left;"><input id="onceProduceQuantity" name="onceProduceQuantity" class="easyui-numberbox" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">最少生产/订购量：</td>
  					<td style="text-align: left;"><input id="minProduceQuantity" type="text" class="easyui-numberbox" name="minProduceQuantity" style="width: 150px;"></td>
  					<td style="text-align: right;">图号：</td>
  					<td style="text-align: left;"><input id="drawingNumber" name="drawingNumber" class="easyui-textbox" style="width: 150px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">检验标准：</td>
  					<td style="text-align: left;"><input id="inspectionStandard" type="text" class="easyui-combobox" name="inspectionStandard" style="width: 150px;" data-options="queryParams: {'keyword' : '检验标准'}"></td>
  					<td style="text-align: right;">检验方式：</td>
  					<td style="text-align: left;"><input id="inspectionWay" type="text" class="easyui-combobox" name="inspectionWay" style="width: 150px;" data-options="queryParams: {'keyword' : '检验方式'}"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">仓库：</td>
  					<td style="text-align: left;"><input id="warehouse" class="easyui-combobox" name="warehouse" style="width: 150px;" data-options="queryParams: {'keyword' : '仓库'}"></td>
  					<td style="text-align: right;">仓位：</td>
  					<td style="text-align: left;"><input id="warehousePositions" class="easyui-combobox" name="warehousePositions" style="width: 150px;" data-options="queryParams: {'keyword' : '仓位'}"></td>
  					
  				</tr>
  				<tr>
  					<td style="text-align: right;">备注：</td>
  					<td colspan="3" style="text-align: left;"><input id="remark" name="remark" class="easyui-textbox" style="width: 420px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">附件：</td>
  					<td colspan="3" style="text-align: left;">
  						<div id="attachmentDiv">
  							<input id="attachment" name="attachment" class="easyui-filebox" style="width: 360px;" data-options="buttonText:'浏览',buttonAlign:'left',validType:'checkPDF'">
  							<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#attachment').filebox('clear');">清空</a>
  						</div>
  						<div id="fileDiv"></div>
  					</td>
  				</tr>
  			</table>
  		</form>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdate()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
	
</body>    
</html>

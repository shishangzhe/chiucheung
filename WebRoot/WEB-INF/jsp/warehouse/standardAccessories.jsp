<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>生产工咭进度表</title>
	
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
			//加载类型的combobox
			$('#accessoriesType').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "类型"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#accessoriesTypeQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#accessoriesTypeQuery').combobox('loadData',$('#accessoriesType').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载单位的combobox
			$('#unit').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "单位"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载适用产品的combobox
			$('#product').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "适用产品"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    multiple:true,
			    onLoadSuccess:function(){
			    	$('#productQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#productQuery').combobox('loadData',$('#product').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载分类的combobox
			$('#classification').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "分类"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#classificationQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#classificationQuery').combobox('loadData',$('#classification').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载物料属性的combobox
			$('#materialProperties').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "物料属性"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#materialPropertiesQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#materialPropertiesQuery').combobox('loadData',$('#materialProperties').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        },
			    onChange:function(newValue,oldValue){
			    	if ($(this).combobox('getText') == '外购件'){
			    		$("#eachNumber").numberbox("setValue","");
			    		$("#eachNumber").numberbox("disable");
			    		$("#product").combobox("setValue","");
			    		$("#product").combobox("disable");
			    		$("#width").combobox("setValue","");
			    		$("#width").combobox("disable");
			    		$("#height").combobox("setValue","");
			    		$("#height").combobox("disable");
			    		$("#depth").combobox("setValue","");
			    		$("#depth").combobox("disable");
			    	}else{
			    		$("#eachNumber").numberbox("enable");
			    		$("#product").combobox("enable");
			    		$("#width").combobox("enable");
			    		$("#height").combobox("enable");
			    		$("#depth").combobox("enable");
			    	}
			    }
			});
			//加载规格型号的combobox
			$('#specifications').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "规格型号"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,//定义在失去焦点的时候是否恢复原始值。
			    onLoadSuccess:function(){
			    	$('#specificationsQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,//定义在失去焦点的时候是否恢复原始值。
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#specificationsQuery').combobox('loadData',$('#specifications').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			
			//加载高度的combobox
			$('#height').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "高度"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#heightQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#heightQuery').combobox('loadData',$('#height').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载宽度的combobox
			$('#width').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "宽度"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#widthQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#widthQuery').combobox('loadData',$('#width').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载深度的combobox
			$('#depth').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "深度"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#depthQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#depthQuery').combobox('loadData',$('#depth').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			//加载颜色的combobox
			$('#color').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "颜色"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#colorQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#colorQuery').combobox('loadData',$('#color').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			
			
			//加载仓存的combobox
			$('#warehouseInventory').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "仓存"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#warehouseInventoryQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#warehouseInventoryQuery').combobox('loadData',$('#warehouseInventory').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			
			
			//加载仓位的combobox
			$('#warehousePositions').combobox({    
			    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
			    queryParams: {//url的参数
					"keyword" : "仓位"
				},
			    valueField:'dictionarieCode',//相当于select的key
			    textField:'dictionarieName',//相当于select的value
			    events:{keyup:fnComFixedChineseInput},
			    editable:true,//不允许编辑
			    reversed:true,
			    onLoadSuccess:function(){
			    	$('#warehousePositionsQuery').combobox({    
					    valueField:'dictionarieCode',//相当于select的key
					    textField:'dictionarieName',//相当于select的value
					    events:{keyup:fnComFixedChineseInput},
					    editable:true,//不允许编辑
					    reversed:true,
					    filter: function(q, row){
				        	var opts = $(this).combobox('options');
				        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
				        }
					});
			    	$('#warehousePositionsQuery').combobox('loadData',$('#warehousePositions').combobox('getData'));
			    },
			    filter: function(q, row){
		        	var opts = $(this).combobox('options');
		        	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
		        }
			});
			
			
			
			var tableId = "dg";
			var title = "标准配件";
			var url = "${pageContext.request.contextPath}/warehouse/standardAccessories/findAllWarStandardAccessoriesList.action";
			var columns = [[
							{field:'accessoriesCode',title:'K3代码',width:120,align:'center',sortable:true},
							{field:'accessoriesType',title:'类型',width:60,align:'center',sortable:true},
					        {field:'accessoriesName',title:'配件名称',width:120,align:'center',sortable:true},
					        {field:'unit',title:'单位',width:50,align:'center',sortable:true},
					        {field:'product',title:'适用产品',width:100,align:'center',formatter: function(value,row,index){
		        																					$('#product').combobox('setValues',value);
		        																					var value = $('#product').combobox('getText');
		        																					return value.substring(0,value.length);
																								}
							},
					        {field:'classification',title:'分类',width:60,align:'center',sortable:true},
					        {field:'materialProperties',title:'物料属性',width:80,align:'center',sortable:true},
					        {field:'specifications',title:'规格型号',width:80,align:'center',sortable:true},
					        {field:'height',title:'高度',width:80,align:'center',sortable:true},
					        {field:'width',title:'宽度',width:80,align:'center',sortable:true},
					        {field:'depth',title:'深度',width:80,align:'center',sortable:true},
					        {field:'color',title:'颜色',width:50,align:'center',sortable:true},
					        {field:'lowestWarehousingQuantity',title:'最低存仓量',width:80,align:'center',sortable:true},
					        {field:'onceProduceQuantity',title:'<span style="font-size:8px;">一次生产/订购量</span>',width:80,align:'center',sortable:true},
					        {field:'minProduceQuantity',title:'<span style="font-size:8px;">最少生产/订购量</span>',width:80,align:'center',sortable:true},
					        {field:'eachNumber',title:'每套数量',width:70,align:'center',sortable:true},
					        {field:'warehouseInventory',title:'仓存',width:60,align:'center',sortable:true},
					        {field:'warehousePositions',title:'仓位',width:60,align:'center',sortable:true},
					        {field:'fileId',title:'附件',width:50,align:'center'},
					        {field:'drawingNumber',title:'图号',width:80,align:'center'},
					        {field:'remark',title:'备注',width:200,align:'center',sortable:true},
					    ]];
			var gridToolBarId = "#gridToolBar";
			var menuId = "menu";
			loadDataGrid(tableId,title,url,columns,gridToolBarId,menuId);
			
			
			
			//form查询表单的回车事件，回车提交
			$("#queryForm").keyup(function (event){
				if (event.keyCode == 13){
					query();
				}
			});
			
			//form表单的回车事件，回车提交
			$("#form1").keyup(function (event){
				if (event.keyCode == 13){
					saveOrUpdate();
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
					$("#attachmentDiv").show();
					$("#fileDiv").html("");
					$("#fileDiv").hide();
					$("#dialog1").dialog({//加载一个dialog
						closed:false,//将该dialog的状态由不显示改成显示
						title:'新增标准配件'//该dialog的标题
					});
					$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				}
			});
	  }
	  
	  
	  function edit(){
		  var select = $("#dg").datagrid("getSelected");
	  		if (select != null){
	  			var url = "${pageContext.request.contextPath}/warehouse/standardAccessories/findWarStandardAccessoriesByIdForEdit.action?id="+select.id;//根据ID从后台取数据的url
	  			$("#form1").form('reset');//重置表单数据
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
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:"修改标准配件"//该dialog的标题
								});
								$("#form1").form('load',data.standardAccessories);//读取记录填充到表单中。
								if (data.standardAccessoriesFile){
									$("#attachmentDiv").hide();
									$("#fileDiv").show();
									$("#fileDiv").html("<p></p><a href='readFileById.action?id="+data.standardAccessoriesFile.id+"' target='target_'>"+data.standardAccessoriesFile.fileName+"</a><image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;'  onclick='deleteFile(\"" + data.standardAccessoriesFile.id +  "\")'>");
								}
							}else{
								showMessager("错误",'<font color="red">' + data.message + '<font/>');
							}
						}
					}
				});
	  		}else{
				showMessager("提示","请选择一条记录进行修改");
			}
	  }
	  
	  
	  function saveOrUpdate(){
		  if ($("#form1").form('validate')){//判断 验证是否通过
				var flag = $("#flag").val();//获取标识符，
				var url = "${pageContext.request.contextPath}/warehouse/standardAccessories/";
				if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
					url = url + "saveWarStandardAccessories.action";
				}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
					url = url + "updateWarStandardAccessories.action";
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
								$("#dg").datagrid('reload');//重新加载数据，保持在当前页
							}else{
								showMessager("错误",'<font color="red">' + data.message + '<font/>');
							}
						}
					}
				});
			}
	  }
	  
	  function reload(){
		  $("#dg").datagrid("reload");
	  }
	  
	  function deleteFile(id){
		  $.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/standardAccessories/deleteWarStandardAccessoriesFileById.action",//ajax请求的url
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
									showMessager("错误",'<font color="red">' + data.message + '<font/>');
								}
							}
						}
					});
				}
		  });
	  }
	  
	//删除用户数据
  	function removeData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/standardAccessories/deleteWarStandardAccessoriesById.action",//ajax请求的url
						data: {id:select.id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data != null && data != ""){
								if (data.success){
									showMessager("提示","删除成功");
									$("#dg").datagrid('reload');//重新加载数据，保持在当前页
									$("#dg").datagrid('clearSelections');//清除所有选择的行
								}else{
									showMessager("错误",'<font color="red">' + data.message + '<font/>');
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
  		$("#dg").datagrid('load',$("#queryForm").serializeObject());
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
			<p:isPrivilege pid="ik" mid="ika">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ik" mid="ikb">
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ik" mid="ikc">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			
		</div>
		<div>
			<form id="queryForm">
				K3代码：<input id="accessoriesCodeQuery" class="easyui-textbox" name="accessoriesCode" style="width: 80px;">
				类型：<input id="accessoriesTypeQuery" class="clearButton" name="accessoriesType" style="width: 100px;">
				配件名称：<input id="accessoriesNameQuery" class="easyui-textbox" name="accessoriesName" style="width: 80px;">
				适用产品：<input id="productQuery" class="clearButton" name="product" style="width: 80px;">
				分类：<input id="classificationQuery" class="clearButton" name="classification" style="width: 80px;">
				物料属性：<input id="materialPropertiesQuery" class="clearButton" name="materialProperties" style="width: 80px;">
				规格型号：<input id="specificationsQuery" class="clearButton" name="specifications" style="width: 80px;">
				高度：<input id="heightQuery" name="height" class="clearButton" style="width: 80px;">
				宽度：<input id="widthQuery" name="width" class="clearButton" style="width: 80px;">
				深度：<input id="depthQuery" name="depth" class="clearButton" style="width: 80px;">
				颜色：<input id="colorQuery" name="color" class="clearButton" style="width: 80px;">
				仓存：<input id="warehouseInventoryQuery" class="clearButton" name="warehouseInventory" style="width: 80px;">
				仓位：<input id="warehousePositionsQuery" class="clearButton" name="warehousePositions" style="width: 80px;">
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
   		<p:isPrivilege pid="ik" mid="ikc">
	    	<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
	    </p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	</div>
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 520px;height: 505px;text-align: center;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;">
  				<tr>
  					<td style="text-align: right;">K3代码：</td>
  					<td style="text-align: left;"><input id="accessoriesCode" class="easyui-textbox" name="accessoriesCode" style="width: 100px;" data-options="required:true"></td>
  					<td style="text-align: right;">类型：</td>
  					<td style="text-align: left;"><input id="accessoriesType" name="accessoriesType" style="width: 100px;" data-options="required:true"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">名称：</td>
  					<td style="text-align: left;"><input id="accessoriesName" class="easyui-textbox" name="accessoriesName" style="width: 100px;" data-options="required:true"></td>
  					<td style="text-align: right;">单位：</td>
  					<td style="text-align: left;"><input id="unit" name="unit" style="width: 100px;" data-options="required:true"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">适用产品：</td>
  					<td style="text-align: left;"><input id="product" name="product" style="width: 100px;" data-options="required:true"></td>
  					<td style="text-align: right;">分类：</td>
  					<td style="text-align: left;"><input id="classification" name="classification" style="width: 100px;" data-options="required:true"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">物料属性：</td>
  					<td style="text-align: left;"><input id="materialProperties" name="materialProperties" style="width: 100px;" data-options="required:true"></td>
  					<td style="text-align: right;">规格型号：</td>
  					<td style="text-align: left;"><input id="specifications" class="clearButton" name="specifications" style="width: 100px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">高度：</td>
  					<td style="text-align: left;"><input id="height" class="clearButton" name="height" style="width: 100px;"></td>
  					<td style="text-align: right;">宽度：</td>
  					<td style="text-align: left;"><input id="width" class="clearButton" name="width" style="width: 100px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">深度：</td>
  					<td style="text-align: left;"><input id="depth" class="clearButton" name="depth" style="width: 100px;"></td>
  					<td style="text-align: right;">颜色：</td>
  					<td style="text-align: left;"><input id="color" name="color" style="width: 100px;" data-options="required:true"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">最低存仓量：</td>
  					<td style="text-align: left;"><input id="lowestWarehousingQuantity" type="text" name="lowestWarehousingQuantity" class="easyui-numberbox" style="width: 100px;" data-options="required:true,validType:'positiveInteger'"></td>
  					<td style="text-align: right;">一次生产/订购量：</td>
  					<td style="text-align: left;"><input id="onceProduceQuantity" name="onceProduceQuantity" class="easyui-numberbox" style="width: 100px;" data-options="required:true,validType:'positiveInteger'"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">最少生产/订购量：</td>
  					<td style="text-align: left;"><input id="minProduceQuantity" type="text" class="easyui-numberbox" name="minProduceQuantity" style="width: 100px;" data-options="required:true,validType:'positiveInteger'"></td>
  					<td style="text-align: right;">每套数量：</td>
  					<td style="text-align: left;"><input id="eachNumber" type="text" class="easyui-numberbox" name="eachNumber" style="width: 100px;" data-options="required:true,validType:'positiveInteger'"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">仓存：</td>
  					<td style="text-align: left;"><input id="warehouseInventory" name="warehouseInventory" style="width: 100px;" data-options="required:true"></td>
  					<td style="text-align: right;">仓位：</td>
  					<td style="text-align: left;"><input id="warehousePositions" name="warehousePositions" style="width: 100px;" data-options="required:true"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">图号：</td>
  					<td style="text-align: left;"><input id="drawingNumber" name="drawingNumber" class="easyui-textbox" style="width: 100px;"></td>
  					<td style="text-align: right;">备注：</td>
  					<td style="text-align: left;"><input id="remark" name="remark" class="easyui-textbox" style="width: 100px;"></td>
  				</tr>
  				<tr>
  					<td style="text-align: right;">附件：</td>
  					<td colspan="3" style="text-align: left;">
  						<div id="attachmentDiv">
  							<input id="attachment" name="attachment" class="easyui-filebox" style="width: 240px;" data-options="buttonText:'浏览',buttonAlign:'left',validType:'checkPDF'">
  							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#attachment').filebox('clear');">清空</a>
  						</div>
  						<div id="fileDiv"></div>
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

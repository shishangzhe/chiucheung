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
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
	}
  
  	$(function(){
		//加载datagrid表格
		$("#dg").datagrid({
			title:'物料',//表格的标题
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
			pagination:true,
			pageSize:20,
			pageList:[20,30,40,50,100],
		    url:'${pageContext.request.contextPath}/purchase/material/findAllPurMaterialList.action',//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    frozenColumns:[[
							{field:'materialType',title:'物料类型',width:70,align:'center',sortable:true},
							{field:'materialCategory',title:'物料类别',width:70,align:'center',sortable:true},
							{field:'materialName',title:'物料名称',width:100,align:'center',sortable:true},
							{field:'specification',title:'规格',width:100,align:'center',sortable:true},
							{field:'model',title:'材种/型号',width:100,align:'center',sortable:true}
		                  ]],
		    columns:[[	
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
		
		
		
		$('#materialType').combobox({    
		    url:'${pageContext.request.contextPath}/purchase/materialBaseData/findAllPurMaterialBaseDataByKeyword.action', 
		    queryParams: {//url的参数
				"keyword" : "物料类型"
			},
		    valueField:'dictionarieName',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false,//不允许编辑   
		    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
		    	$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/purchase/materialBaseData/findAllPurMaterialBaseDataByKeyword.action",//ajax请求的url
					data: {keyword:$('#materialType').combobox('getText')},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data.length>0){
							$('#materialCategory').combobox('enable');
							$('#materialName').combobox('clear');
							$('#materialCategory').combobox('loadData',data);
							disableTextbox("area");
							disableTextbox("length");
							disableTextbox("width");
							disableTextbox("thick");
							disableTextbox("density");
							disableTextbox("weight");
							disableTextbox("kgPrice");
							disableTextbox("specification");
							enableTextbox("unit");
							enableTextbox("supplier");
							enableTextbox("usingRange");
							enableTextbox("remark");
							readonlyTextbox("unitPrice", true);
							$("#materialName").combobox({editable:false});
							$('#model').textbox('enableValidation');
						}else{
							$('#materialCategory').combobox('disable');
							$('#materialCategory').combobox('clear');
							$('#materialName').combobox('clear');
							disableTextbox("area");
							disableTextbox("length");
							disableTextbox("width");
							disableTextbox("thick");
							disableTextbox("density");
							disableTextbox("weight");
							disableTextbox("kgPrice");
							disableTextbox("specification");
							enableTextbox("unit");
							enableTextbox("supplier");
							enableTextbox("usingRange");
							enableTextbox("remark");
							readonlyTextbox("unitPrice", false);
							$("#materialName").combobox({editable:true});
							$('#model').textbox('disableValidation');
						}
					}
				});
		    }
		}); 
		
		$('#materialCategory').combobox({    
		    valueField:'dictionarieName',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false,//不允许编辑   
		    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
		    	$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/purchase/materialBaseData/findAllPurMaterialBaseDataByKeyword.action",//ajax请求的url
					data: {keyword:$('#materialCategory').combobox('getText')},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						$('#materialName').combobox('loadData',data);
						$('#materialName').combobox('clear');
						if ($('#materialCategory').combobox('getText') == "张料" || $('#materialCategory').combobox('getText') == "卷料"){
							disableTextbox("area");
							enableTextbox("length");
							enableTextbox("width");
							enableTextbox("thick");
							enableTextbox("kgPrice");
							enableTextbox("specification");
							readonlyTextbox("unitPrice", true);
						}else if ($('#materialCategory').combobox('getText') == "油漆" || $('#materialCategory').combobox('getText') == "粉"){
							disableTextbox("area");
							disableTextbox("length");
							disableTextbox("width");
							disableTextbox("thick");
							disableTextbox("kgPrice");
							readonlyTextbox("unitPrice", false);
							disableTextbox("specification");
							$('#model').textbox('disableValidation');
						}else{
							enableTextbox("area");
							enableTextbox("length");
							disableTextbox("width");
							disableTextbox("thick");
							enableTextbox("kgPrice");
							enableTextbox("specification");
							readonlyTextbox("unitPrice", true);
						}
						enableTextbox("weight");
						enableTextbox("density");
						enableTextbox("unit");
						enableTextbox("supplier");
						enableTextbox("usingRange");
						enableTextbox("remark");
					}
				});
		    }
		});
		
		$('#materialName').combobox({    
		    valueField:'dictionarieName',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑   
		});
		
		$('#density').combobox({
			url:'${pageContext.request.contextPath}/purchase/materialBaseData/findAllPurMaterialBaseDataByKeywordForDensity.action',
			queryParams: {//url的参数
				"keyword" : "比重"
			},
			valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false,//不允许编辑   
		    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
		    	calculate();
		    }
		});
		
		//form查询表单的回车事件，回车提交
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		
		$('#form1 .easyui-textbox').each(function(i){
			if ((i>=2 && i<=5) || i==7){
				$(this).textbox('textbox').bind('input propertychange', function() {  
					calculate(); 
				}); 
			}
		});
  	});
  	
  	//新增一行
  	function add(){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#form1").form('reset');//重置表单数据
		  		$('#materialCategory').combobox('enable');
				$('#materialName').combobox('loadData',{});
				$('#materialCategory').combobox('loadData',{});
				disableTextbox("area");
				disableTextbox("length");
				disableTextbox("width");
				disableTextbox("thick");
				disableTextbox("density");
				disableTextbox("weight");
				disableTextbox("kgPrice");
				disableTextbox("specification");
				readonlyTextbox("unitPrice", true);
				$("#materialName").combobox({editable:false});
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增物料'//该dialog的标题
				});
				$("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			}
		});
  	}
  	
  	//打开编辑操作
  	function edit(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			var url = "${pageContext.request.contextPath}/purchase/material/findPurMaterialById.action?id="+select.id;//根据ID从后台取数据的url
			$("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
			$("#form1").form('reset');//重置表单数据
	  		$('#materialCategory').combobox('enable');
	  		$('#materialName').combobox('loadData',{});
			$('#materialCategory').combobox('loadData',{});
			disableTextbox("area");
			disableTextbox("length");
			disableTextbox("width");
			disableTextbox("thick");
			disableTextbox("density");
			disableTextbox("weight");
			disableTextbox("kgPrice");
			disableTextbox("specification");
			readonlyTextbox("unitPrice", true);
			$("#materialName").combobox({editable:false});
			$("#form1").form('load',url);//读取记录填充到表单中。
			$("#dialog1").dialog({//加载一个dialog
				closed:false,//将该dialog的状态由不显示改成显示
				title:"修改物料"//该dialog的标题
			});
  		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
  	}
  	
  	
  	function save(){
  		if ($("#form1").form('validate')){//判断 验证是否通过
  			if($("#materialName").combobox('getValue') == ""){
  				$('#materialName').combobox('setValue', $("#materialName").combobox('getText'));
  			}
			var flag = $("#flag").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/purchase/material/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "savePurMaterial.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updatePurMaterial.action";
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
  	
  	function removeData(){
  		var select = $("#dg").datagrid("getSelected");
  		if (select != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
		  			$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/purchase/material/deletePurMaterialById.action",//ajax请求的url
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
  	
  	
  	function enableTextbox(item){
  		$("#"+item).textbox('enable');
  		$("#"+item).textbox('clear');
  	}
  	function disableTextbox(item){
  		$("#"+item).textbox('disable');
  		$("#"+item).textbox('clear');
  	}
  	function readonlyTextbox(item,b){
  		$("#"+item).textbox('readonly',b);
  		$("#"+item).textbox('clear');
  	}
  	
  	
  	function calculate(){
  		var area = $("#area").textbox("textbox").val();
  		var thick = $("#thick").textbox("textbox").val();
  		var length = $("#length").textbox("textbox").val();
  		var width = $("#width").textbox("textbox").val();
  		//var density = $("#density").textbox("textbox").val();
  		var density = $("#density").combobox("getValue");
  		var weight = $("#weight").textbox("textbox").val();
  		var kgPrice = $("#kgPrice").textbox("textbox").val();
  		//横切面积、长度、比重不为空，并且通过验证，才进行这种重量的计算
  		if (area != "" && $("#area").textbox('isValid') && length != "" && $("#length").textbox('isValid') && density != "" && $("#density").textbox('isValid')){
  			weight = area*length*density/1000000;
  			if (!(weight.toFixed(2) == weight)){//如果小数点后面不是两位，则截取两位小数点
  				weight = weight.toFixed(2);
			}
  			$("#weight").textbox('setValue',weight);
  		}
  		//厚度、长度、宽度、比重不为空，并且通过验证，才进行这种重量的计算
  		if (thick != "" && $("#thick").textbox('isValid') && length != "" && $("#length").textbox('isValid') && width != "" && $("#width").textbox('isValid') && density != "" && $("#density").textbox('isValid')){
  			weight = thick*length*width*density/1000000;
  			if (!(weight.toFixed(2) == weight)){//如果小数点后面不是两位，则截取两位小数点
  				weight = weight.toFixed(2);
			}
  			$("#weight").textbox('setValue',weight);
  		}
  		if (kgPrice != "" && $("kgPrice").text('isValid')){
  			var unitPrice = kgPrice*weight;
  			if (!(unitPrice.toFixed(2) == unitPrice)){//如果小数点后面不是两位，则截取两位小数点
  				unitPrice = unitPrice.toFixed(2);
			}
  			$("#unitPrice").textbox('setValue',unitPrice);
  		}
  		if ($('#materialCategory').combobox('getText') == "油漆" || $('#materialCategory').combobox('getText') == "粉"){
  			$("#weight").textbox('setValue',density);
  		}
  	}
  </script>
<body>
	<table id="dg" 
		
		data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
	
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="ef" mid="efa">
				<a id="add1" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ef" mid="efb">
				<a id="edit1" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit()" style="float: left;">修改</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ef" mid="efc">
				<a id="removeData1" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData()" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a id="reload1" href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload()" style="float: left;">刷新</a><div class="btn-separator"></div>
		</div>
		<div>
			<form id="queryForm">
				物料类型：<input id="materialType_query" type="text" class="easyui-textbox" name="materialType" style="width: 70px" >
				物料类别：<input id="materialCategory_query" type="text" class="easyui-textbox" name="materialCategory" style="width: 70px" >
				物料名称：<input id="materialName_query" type="text" class="easyui-textbox" name="materialName" style="width: 70px" >
				规格：<input id="specification_query" type="text" class="easyui-textbox" name="specification" style="width: 70px" >
				材种/型号：<input id="model_query" type="text" class="easyui-textbox" name="model" style="width: 70px" >
				供应商：<input id="supplier_query" type="text" class="easyui-textbox" name="supplier" style="width: 70px" >
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
		</div>
	</div>
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="ef" mid="efa">
    		<div id="add2" data-options="iconCls:'icon-add'" onclick="add()">新增</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="ef" mid="efb">
    		<div id="edit2" data-options="iconCls:'icon-edit'" onclick="edit()">修改</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="ef" mid="efc">
    		<div id="removeData2" data-options="iconCls:'icon-remove'" onclick="removeData()">删除</div>
   		</p:isPrivilege>
	    <div id="reload2" data-options="iconCls:'icon-reload'" onclick="reload()">刷新</div>
	</div>
	
	
	
	
	
	
	<!-- 增&改用户的dialog -->
  	<div id="dialog1" class="easyui-dialog" style="width: 580px;height: 300px;"
  	data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
  		<form id="form1">
  			<input id="flag" type="hidden" value="">
  			<input id="id" type="hidden" name="id" value="">
  			<table style="border-spacing:10px;border-bottom: 0.5px;text-align: right;">
  				<tr>
  					<td>
  						物料类型：<input id="materialType" name="materialType" style="width: 80px" data-options="required:true,missingMessage:'请选择物料类型'">
  					</td>
  					<td>
  						物料类别：<input id="materialCategory" name="materialCategory" style="width: 80px" data-options="required:true,missingMessage:'请选择物料类别'">
  					</td>
  					<td>
  						物料名称：<input id="materialName" name="materialName" style="width: 100px" data-options="required:true,missingMessage:'物料名称不能为空'">
  					</td>
  				</tr>
  				<tr>
  					<td>
  						规格：<input id="specification" type="text" class="easyui-textbox" name="specification" style="width: 130px;" data-options="disabled:true,required:true,missingMessage:'规格不能为空'">
  					</td>
  					<td colspan="2">
  						材种/型号：<input id="model" type="text" class="easyui-textbox" name="model" style="width: 240px;" data-options="required:true,missingMessage:'材种/型号不能为空'">
  					</td>
  				</tr>
  				<tr>
  					<td>
  						横切面积(mm²)：<input id="area" type="text" class="easyui-textbox" name="area" style="width: 80px;" onChange="calculate()" data-options="disabled:true,required:true,missingMessage:'横切面积不能为空',validType:'checkTimes'" >
  					</td>
  					<td>
  						厚(mm)：<input id="thick" type="text" class="easyui-textbox" name="thick" style="width: 80px;" data-options="disabled:true,required:true,missingMessage:'厚度不能为空',validType:'checkTimes'" >
  					</td>
  					<td>
  						长(mm)：<input id="length" type="text" class="easyui-textbox" name="length" style="width: 80px;" data-options="disabled:true,required:true,missingMessage:'长不能为空',validType:'positiveInteger'" >
  					</td>
  				</tr>
  				<tr>
  					<td>
  						宽(mm)：<input id="width" type="text" class="easyui-textbox" name="width" style="width: 80px;" data-options="disabled:true,required:true,missingMessage:'宽不能为空',validType:'positiveInteger'"  >
  					</td>
  					<td>
  						材质：<input id="density" type="text" name="density" style="width: 80px;" data-options="disabled:true,required:true,missingMessage:'比重不能为空'" >
  					</td>
  					<td>
  						重量(KG)：<input id="weight" type="text" class="easyui-textbox" name="weight" style="width: 80px;" data-options="disabled:true,readonly:true,required:true,missingMessage:'重量不能为空',validType:'checkTimes'" >
  					</td>
  				</tr>
  				<tr>
  					<td>
  						公斤单价(元)：<input id="kgPrice" type="text" class="easyui-textbox" name="kgPrice" style="width: 80px;" data-options="disabled:true,required:true,missingMessage:'公斤单价不能为空',validType:'checkTimes'" >
  					</td>
  					<td>
  						单位单价(元)：<input id="unitPrice" type="text" class="easyui-textbox" name="unitPrice" style="width: 80px;" data-options="readonly:true,required:true,missingMessage:'单位单价不能为空',validType:'checkTimes'" >
  					</td>
  					<td>
  						单位：<input id="unit" type="text" class="easyui-textbox" name="unit" style="width: 80px;" data-options="required:true,missingMessage:'单位单价不能为空'">
  					</td>
  				</tr>
  				<tr>
  					<td>
  						供应商：<input id="supplier" type="text" class="easyui-textbox" name="supplier" style="width: 80px;" >
  					</td>
  					<td>
  						使用范围：<input id="usingRange" type="text" class="easyui-textbox" name="usingRange" style="width: 80px;" >
  					</td>
  					<td>
  						备注：<input id="remark" type="text" class="easyui-textbox" name="remark" style="width: 80px;" >
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
</body>
</html>

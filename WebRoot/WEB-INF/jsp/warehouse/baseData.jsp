<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>数据字典</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
  	$(function(){
		//加载datagrid表格
		$("#dg").datagrid({
			title:'基础数据',//表格的标题
			fit:true,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
		    url:'',//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:[[
				        {field:'keyword',title:'类型',width:100,align:'center'},    
				        {field:'dictionarieCode',title:'类型编号',width:100,align:'center'},
				        {field:'dictionarieName',title:'名称',width:100,align:'center',editor:{
				        	type:'textbox',
				        	options:{
				        		required:true,
				        		missingMessage:'名称不能为空'
				        	}
				        }}
				    ]],
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
		
		
		$('#cc').combobox({    
		    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllKeywordByDistinct.action",//加载数据的url    
		    valueField:'keyword',//相当于select的key
		    textField:'keyword',//相当于select的value
		    editable:false,//不允许编辑
		    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
		    	var url = "${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action";
		    	$("#dg").datagrid('options').url = url;
		    	$("#dg").datagrid('load',{
		    		keyword:$("#cc").combobox("getText")
		    	});
		    	showItemCustonm("add");
				showItemCustonm("edit");
				showItemCustonm("removeData");
				showItemCustonm("reload");
	  			hideItemCustonm("save");
	  			hideItemCustonm("cancelAdd");
	  			hideItemCustonm("cancelEdit");
		    	$("#flag").val("true");//改变true，标识当前没有在编辑行
		    	$("#index").val("");
		    }
		});
  	});
  	
  	//新增一行
  	function add(){
  		if ($("#cc").combobox("getText") != ""){//表示选择了一个类型
  			if ($("#flag").val() == "true"){//该标识为true，允许新增，为false已有编辑或新增的行未保存
  				hideItemCustonm("add");
  	  			hideItemCustonm("edit");
  	  			hideItemCustonm("removeData");
  	  			hideItemCustonm("reload");
  	  			showItemCustonm("save");
  	  			showItemCustonm("cancelAdd");
		  		var rows = $("#dg").datagrid('getRows');//获取所有行，为了在最后一行新增数据
		  		$("#dg").datagrid('appendRow',{//插入一行
		  			keyword:$("#cc").combobox("getText"),
		  			//rows[rows.length-1]存在，则获取最后一行的dictionarieCode，新增的一行在这上加1
		  			//rows[rows.length-1]不存在，表示没有，则直接赋值 1
		  			dictionarieCode:rows[rows.length-1] == undefined ? 1 : rows[rows.length-1].dictionarieCode*1+1,
		  			dictionarieName:''
		  		});
		  		$("#dg").datagrid('beginEdit',rows.length-1);//开始行的编辑
		  		$("#flag").val("false");//改变false，标识当前有在编辑行
		  		$("#index").val(rows.length-1);
  			}else{
  				showMessager("提示","不允许多行编辑，请先保存当前编辑的行");
  			}
  		}else{
  			showMessager("提示","请选择一个类型进行添加");
  		}
  	}
  	
  	//打开编辑操作
  	function edit(){
  		if ($("#flag").val() == "true"){//该标识为true，允许编辑，为false已有编辑或新增的行未保存
	  		var select = $("#dg").datagrid('getSelected');//获取选择的行
	  		if (select != undefined && select != null){//是否选择了行
	  			hideItemCustonm("add");
	  			hideItemCustonm("edit");
	  			hideItemCustonm("removeData");
	  			hideItemCustonm("reload");
	  			showItemCustonm("save");
	  			showItemCustonm("cancelEdit");
	  			var index = $("#dg").datagrid('getRowIndex',select);
	  			$("#dg").datagrid('beginEdit',index);//开始编辑选择的行
	  			$("#flag").val("false");//改变false，标识当前有在编辑行
	  			$("#index").val(index);
	  		}else{
	  			showMessager("提示","请选择一行进行修改");
	  		}
  		}else{
  			showMessager("提示","请先保存当前更改的数据");
  		}
  	}
  	
  	function removeData(){
  		var select = $("#dg").datagrid('getSelected');//获取选择的行
  		if (select != undefined && select != null){//是否选择了行
  			if (select.id != null && select.id != ""){//删除的是原有的行
  				if ($("#flag").val() == "true"){//该标识为true，允许删除，为false已有编辑或新增的行未保存，删除后重新加载数据，未保存的数据将丢失
		  			$.messager.confirm('确认对话框', '您确定要删除这条数据吗？', function(b){//给用户一个删除几条信息的确认提示框
						if (b){//如何用户点击的是确认
							$.ajax({
								type:'POST',//post请求
								url: "${pageContext.request.contextPath}/warehouse/baseData/deleteWarBaseDataById.action?id="+select.id,//ajax请求的url
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(data){//请求成功后的回调函数。data：服务器返回数据。
									if (data != null && data != ""){
										if (data == '删除成功'){
											showMessager("提示",data);
											$("#dg").datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
											$("#dg").datagrid('clearSelections');//清除所有选择的行
											$("#cc").combobox('reload');//重新加载
										}else{
											showMessager("错误",data);
										}
									}
								}
							});
						}
		  			});
  				}else{
  					showMessager("提示","请先保存当前更改的数据，在进行删除");
  				}
  			}else{//删除的是新增没有保存的行
  				$("#dg").datagrid("deleteRow",$("#dg").datagrid("getRowIndex",select));//后面的dictionarieCode变化问题
  				$("#flag").val("true");//改变true，标识当前没有在编辑行
  				$("#index").val("");
  			}
  		}else{
  			showMessager("提示","请选择一行进行删除");
  		}
  	}
  	
  	function save(){
  		$("#dg").datagrid('endEdit',$("#index").val());
  		var changes = $("#dg").datagrid('getChanges');//获取更改的行
  		if (changes.length > 0){
  			var flag = true;//记录校验是否通过
  			flag = $("#dg").datagrid('validateRow',$("#dg").datagrid('getRowIndex',changes[0]));//获取行的校验是否通过
  			if (flag == false){
				var ed = $('#dg').datagrid('getEditors', $("#dg").datagrid('getRowIndex',changes[0]));//获取行的所有编辑器
				for (var i=0;i<ed.length;i++){//遍历行的所有编辑器
					if (!ed[i].target.textbox('isValid')){//如果校验不通过
						ed[i].target.textbox('textbox').focus(); //该编辑器获取焦点，目的是为了提示用户，该编辑器校验不通过
						return;//跳出循环
					}
				}
				return;//跳出循环
			}else{
	  			if (changes[0].id == undefined){//表示新增，如果是修改，是能获取到id的
	  				$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/baseData/saveWarBaseData.action",//ajax请求的url
						data: changes[0],//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data == "保存成功"){
								showMessager("提示",data);
								showItemCustonm("add");
								showItemCustonm("edit");
								showItemCustonm("removeData");
								showItemCustonm("reload");
					  			hideItemCustonm("save");
					  			hideItemCustonm("cancelAdd");
								$("#dg").datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
								$("#flag").val("true");//改变true，标识当前没有在编辑行
								$("#index").val("");
						  		$("#cc").combobox('reload');//重新加载
						  		$("#cc").combobox('select',changes[0].keyword);//选择刚选择或新增的keyword
								//$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误",data);
								$("#dg").datagrid('beginEdit',$("#index").val());
							}
						}
					});
	  			}else {//表示修改
	  				$.ajax({
						type:'POST',//post请求
						url: "${pageContext.request.contextPath}/warehouse/baseData/updateWarBaseData.action",//ajax请求的url
						data: changes[0],//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data == "保存成功"){
								showMessager("提示",data);
								showItemCustonm("add");
								showItemCustonm("edit");
								showItemCustonm("removeData");
								showItemCustonm("reload");
					  			hideItemCustonm("save");
					  			hideItemCustonm("cancelEdit");
								$("#dg").datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
								$("#flag").val("true");//改变true，标识当前没有在编辑行
								$("#index").val("");
						  		$("#cc").combobox('reload');//重新加载
						  		$("#cc").combobox('select',changes[0].keyword);//选择刚选择或新增的keyword
								//$("#dg").datagrid('clearSelections');//清除所有选择的行
							}else{
								showMessager("错误",data);
								$("#dg").datagrid('beginEdit',$("#index").val());
							}
						}
					});
	  			}
			}
  		}else{
  			showMessager("提示","保存成功");
  			$("#dg").datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
  			showItemCustonm("add");
			showItemCustonm("edit");
			showItemCustonm("removeData");
  			showItemCustonm("reload");
  			hideItemCustonm("save");
  			hideItemCustonm("cancelAdd");
  			hideItemCustonm("cancelEdit");
  			$("#flag").val("true");//改变false，标识当前没有在编辑行(当点修改数据的时候，并没有更改内容，getchanges获取不到，但是点修改的时候将标识符设置为false，所以这里又要设置为true)
  			$("#index").val("");
  		}
 	}
  	
  	
  	
  	function addKeyword(){
  		if ($('#form1').form('validate')){//校验通过才进行下面操作（非空校验和类型是否存在校验）
  			$("#flag").val("true");//改变true，标识当前没有在编辑行
  			$("#index").val();
  	  		//$('#cc').combobox('unselect',$('#cc').combobox('getText'));//取消当前选择的值
  	  		$('#cc').combobox('select',$("#keyword").textbox('getText'));//将combobox的值直接设置成类型输入框里填的值
  	  		$("#keyword").textbox('setText','');//将类型输入框的值清空
  	  		$('#dg').datagrid('loadData',{"total":0,"rows":[]});//清空表格数据
  		}
  	}
  	
  	
  	//刷新数据
  	function reload(){
  		$("#dg").datagrid('reload');
  	}
  
  
  	
  	function cancelAdd(){
  		$("#dg").datagrid('deleteRow',$("#index").val());
  		showItemCustonm("add");
		showItemCustonm("edit");
		showItemCustonm("removeData");
		showItemCustonm("reload");
		hideItemCustonm("save");
		hideItemCustonm("cancelAdd");
  		$("#index").val("");
  		$("#flag").val("true");//改变true，标识当前没有在编辑行
  		//$("#dg").datagrid('reload');
  	}
  	function cancelEdit(){
  		$("#dg").datagrid('cancelEdit',$("#index").val());
  		showItemCustonm("add");
		showItemCustonm("edit");
		showItemCustonm("removeData");
		showItemCustonm("reload");
		hideItemCustonm("save");
		hideItemCustonm("cancelEdit");
  		$("#index").val("");
  		$("#flag").val("true");//改变true，标识当前没有在编辑行
  		$("#dg").datagrid('reload');
  	}
	
	
  	function showItemCustonm(item){
  		if ($("#"+item+"1").length>0 && $("#"+item+"2").length>0){
  			$("#"+item+"1").linkbutton('enable');
  			$("#menu").menu("showItem",$("#"+item+"2"));
  		}
  	}
  	function hideItemCustonm(item){
  		if ($("#"+item+"1").length>0 && $("#"+item+"2").length>0){
  			$("#"+item+"1").linkbutton('disable');
  			$("#menu").menu("hideItem",$("#"+item+"2"));
  		}
  	}
  </script>
<body>   
	<div style="padding-bottom: 20px;padding-top: 20px;text-align: center;">
		<input id="flag" type="hidden" value="true"><!-- 标记，如果为true，表示没有在编辑任何一行，允许新增一行或者修改一行，用于最多只能编辑一行 -->
		<input id="index" type="hidden" value=""><!-- 记录当前新增或修改的行索引 -->
		
			<form id="form1">
				请选择类型：<input id="cc" name="keyword" style="width: 120px">
				<p:isPrivilege pid="ij" mid="ija">
					<a href="#" class="easyui-linkbutton" onClick="addKeyword()">新增类型</a>
					<input id="keyword" class="easyui-textbox" name="keyword" data-options="required:true,missingMessage:'类型不能为空',validType:'keywordIsRepeat'">
				</p:isPrivilege>
			</form>
	</div>
	<table id="dg"
		<p:isPrivilege pid="bd" mid="bdb"> 
			data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
		</p:isPrivilege>
	></table>
	<!-- 上面表格的toolbar按钮 -->
	<div id="gridToolBar" style="padding:5px;height:auto">
		<div style="display:inline-block;">
			<p:isPrivilege pid="ij" mid="ija"> 
				<a id="add1" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ij" mid="ijb"> 
				<a id="edit1" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ij" mid="ijc"> 
				<a id="removeData1" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData();" style="float: left;">删除</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a id="reload1" href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload()" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="ij" mid="ija,ijb"> 
				<a id="save1" href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save();" style="float: left;" data-options="disabled:true">保存</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ij" mid="ija"> 
				<a id="cancelAdd1" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancelAdd()" style="float: left;" data-options="disabled:true">取消新增</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="ij" mid="ijb"> 
				<a id="cancelEdit1" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancelEdit()" style="float: left;" data-options="disabled:true">取消修改</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
	</div>
	
	<!-- 上面表格的右键菜单 -->
  	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
	    <!--放置一个隐藏的菜单Div-->
	    <p:isPrivilege pid="ij" mid="ija"> 
    		<div id="add2" data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="ij" mid="ijb"> 
    		<div id="edit2" data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="ij" mid="ijc"> 
    		<div id="removeData2" data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
    	</p:isPrivilege>
    	<div id="reload2" data-options="iconCls:'icon-reload'" onclick="reload()">刷新</div>
    	<p:isPrivilege pid="ij" mid="ija,ijb"> 
	   		<div id="save2" data-options="iconCls:'icon-save'" style="display: none;" onclick="save();">保存</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="ij" mid="ija">
	   		<div id="cancelAdd2" data-options="iconCls:'icon-cancel'" style="display: none;" onclick="cancelAdd()">取消新增</div>
		</p:isPrivilege>
		<p:isPrivilege pid="ij" mid="ijb"> 
		    <div id="cancelEdit2" data-options="iconCls:'icon-cancel'" style="display: none;" onclick="cancelEdit()">取消修改</div>
		</p:isPrivilege>
	</div>
</body>    
</html>

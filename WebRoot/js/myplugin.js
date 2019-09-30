	/**
	 * 提示信息
	 * @param title 提示信息的标题
	 * @param msg 提示信息的内容
	 */
	function showMessager(title,msg){
		if ($(window.top.document).find(".messageDiv").length>0){//有显示消息提示框，则要显示在消息提示框的左边
			$.messager.show({//提示消息
			       title:title,
			       msg:msg,
			       timeout:5000,
			       //showType:'slide',
			       style:{
					    left:$(document.body).width()-300-250, // 与左边界的距离
					    top:$(document.body).height()-100,
					}
				});
		}else{
			$.messager.show({//提示消息
		       title:title,
		       msg:msg,
		       timeout:5000,
		       //showType:'slide'
			});
		}
	};
	/**
	 * 提示错误信息
	 * @param title 提示信息的标题
	 * @param msgTitle
	 * @param msg 提示信息的内容
	 */
	function showErrorMessager(msgTitle,msg){
		if ($(window.top.document).find(".messageDiv").length>0){//有显示消息提示框，则要显示在消息提示框的左边
			$.messager.show({//提示消息
			       title:"错误",
			       msg:"<div style='text-align:center;'>" + msgTitle + "</br>" + "<font color='red'>" +msg + "<font/><div/>",
			       timeout:5000,
			       //showType:'slide',
			       style:{
					    left:$(document.body).width()-300-250, // 与左边界的距离
					    top:$(document.body).height()-100,
					}
				});
		}else{
			$.messager.show({//提示消息
		       title:'错误',
		       msg:"<div style='text-align:center;'>" + msgTitle + "</br>" + "<font color='red'>" +msg + "<font/><div/>",
		       timeout:5000,
		       //showType:'slide'
			});
		}
	};
	
	
	/**
	 * 删除复选框check的数据
	 * @param tableId 点击的表格Id
	 * @param url 删除的url，所有的删除就是根据id删除
	 *
	**/
	function deleteDataByCheck(tableId, url){
		var check = $("#"+tableId).datagrid('getChecked');//取得所有check选中的行，采用勾选才能进行操作，所以不能用getSelections
		if (check.length == 0){//如果没有选中一行
			showMessager("提示","至少选择一行进行删除");
		}else{//如果至少选中了一行
			$.messager.confirm('确认对话框', '您确定要删除这'+check.length+'条数据吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
					var ids = "";
					for (var i=0;i<check.length;i++){//拼接ID，每个ID用逗号隔开
						if (i==check.length-1){
							ids = ids+check[i].id;
						}else{
							ids = ids+check[i].id + ",";
						}
					}
					$.ajax({
						type:'POST',//post请求
						url: url,//ajax请求的url
						data: {id:ids},//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							showMessager("提示",data);
							$("#"+tableId).datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
							$("#"+tableId).datagrid('clearChecked');//清除所有勾选的行
						},
						error: function(XMLHttpRequest, textStatus, errorThrown){//请求失败后的回调函数。
							showMessager("提示",'<font color="red">'+textStatus+"  "+XMLHttpRequest.status+"("+errorThrown+")"+'<font/>');
						}
					});
				}
			});
		}
	}
	
	/**
	 * 删除复选框select的数据
	 * @param tableId 点击的表格Id
	 * @param url 删除的url，所有的删除就是根据id删除
	 *
	**/
	function deleteDataBySelect(tableId, url){
		var selections = $("#"+tableId).datagrid('getSelections');//取得所有select选中的行
		if (selections.length == 0){//如果没有选中一行
			showMessager("提示","至少选择一行进行删除");
		}else{//如果至少选中了一行
			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
				if (b){//如何用户点击的是确认
					var ids = "";
					for (var i=0;i<selections.length;i++){//拼接ID，每个ID用逗号隔开
						if (i==selections.length-1){
							ids = ids+selections[i].id;
						}else{
							ids = ids+selections[i].id + ",";
						}
					}
					$.ajax({
						type:'POST',//post请求
						url: url,//ajax请求的url
						data: {id:ids},//传的参数
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							showMessager("提示",data);
							$("#"+tableId).datagrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
							$("#"+tableId).datagrid('clearSelections');//清除所有选择的行
						},
						error: function(XMLHttpRequest, textStatus, errorThrown){//请求失败后的回调函数。
							showMessager("提示",'<font color="red">'+textStatus+"  "+XMLHttpRequest.status+"("+errorThrown+")"+'<font/>');
						}
					});
				}
			});
		}
	}
	
	
	
	
	
	
	/**
	 * 关闭dialog
	 * @param dialogId 要关闭的dialog的Id
	 *
	**/
	function closeDialog(dialogId){//关闭dialog的方法

		$("#" + dialogId).dialog({
			closed:true
		});
		if (dialogId == "dialog1") {
            $("#dg1-2").datagrid('endEdit', $("#dg1-2").datagrid("getRowIndex", $("#dg1-2").datagrid("getSelected")));
        }
	}
	
	
	
	
	
	/**
	 * 创建数据表格（该数据表格是点击行点选，点击check是多选，多选了的情况下点击行，会取消所有选择，单选点击的那行）带分页
	 * @param tableId 数据表格的id
	 * @param title 数据表格的标题
	 * @param url 数据表格加载数据的url
	 * @param id 标识字段。
	 * @param columns 表格的列属性
	 * @param toolbarId 显示的toolbar的id
	 * @param menuId 右键菜单的id
	 *
	**/
	//该表格的表头右键菜单，隐藏显示列，用于有check的复选框，其他同loadDataGrid2
	function loadDataGrid(tableId, title, url, columns, toolbarId, menuId){
		//加载datagrid表格
		$("#"+tableId).datagrid({
			title:title,//表格的标题
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			singleSelect:true ,//单选
			//ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
			pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    url:url,//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:columns,//表格的各个字段
		    toolbar: toolbarId,
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
                $("#" + menuId).menu('show', {//显示右键菜单
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
			var fields = $("#"+tableId).datagrid('getColumnFields');
			var nonHiddenCount = 0;//用来记录隐藏的item数
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						if (nonHiddenCount<fields.length-1){
							$("#"+tableId).datagrid('hideColumn', item.name);
							nonHiddenCount++;
							cmenu.menu('setIcon', {
								target: item.target,
								iconCls: 'icon-empty'
							});
						}
					} else {
						$("#"+tableId).datagrid('showColumn', item.name);
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
				var col = $("#"+tableId).datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
	}
	
	
	/**
	 * 创建数据表格（该数据表格是点击行点选，点击check是多选，多选了的情况下点击行，会取消所有选择，单选点击的那行）
	 * @param tableId 数据表格的id
	 * @param title 数据表格的标题
	 * @param url 数据表格加载数据的url
	 * @param id 标识字段。
	 * @param columns 表格的列属性
	 * @param toolbarId 显示的toolbar的id
	 * @param menuId 右键菜单的id
	 *
	**/
	//该表格的表头右键菜单，隐藏显示列，用于有check的复选框，其他同loadDataGrid2
	function loadDataGrid1(tableId, title, url, columns, toolbarId, menuId){
		//加载datagrid表格
		$("#"+tableId).datagrid({
			title:title,//表格的标题
			//width:250,//表格的宽度
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			//multiSort:true,//允许多行排序
			remoteSort:false,//不从服务器进行排序
			//pagination:true,
		    url:url,//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    //checkOnSelect、selectOnCheck、onClickRow、checkAll，这4个是用来解决点击行的时候是单选，但是点checkbox的时候可以多选
		    checkOnSelect:true,//当用户点击行的时候该复选框就会被选中或取消选中。
		    selectOnCheck:true,//如果为true，单击复选框将永远选择行。
		    onClickRow:function(rowIndex){//在用户点击一行的时候触发的事件，rowIndex：点击的行的索引值，该索引值从0开始
		    	$(this).datagrid('uncheckAll');//取消勾选当前页中的所有行。
		    	$(this).singleSelect = true;//只能选择一行
		    	$(this).datagrid('selectRow', rowIndex);//选择一行，行索引从0开始。
		    },
		    checkAll:function(){//勾选当前页中的所有行。
		    	$(this).singleSelect = false;//允许多选
		    },
		    columns:columns,//表格的各个字段
		    toolbar: toolbarId,
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
                $("#" + menuId).menu('show', {//显示右键菜单
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
			var fields = $("#"+tableId).datagrid('getColumnFields');
			var nonHiddenCount = 0;//用来记录隐藏的item数
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						if (nonHiddenCount<fields.length-1){
							$("#"+tableId).datagrid('hideColumn', item.name);
							nonHiddenCount++;
							cmenu.menu('setIcon', {
								target: item.target,
								iconCls: 'icon-empty'
							});
						}
					} else {
						$("#"+tableId).datagrid('showColumn', item.name);
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
				var col = $("#"+tableId).datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
	}
	
	
	
	/**
	 * 创建数据表格（该数据表格是点击行点选，点击check是多选，多选了的情况下点击行，会取消所有选择，单选点击的那行）
	 * @param tableId 数据表格的id
	 * @param title 数据表格的标题
	 * @param url 数据表格加载数据的url
	 * @param id 标识字段。
	 * @param columns 表格的列属性
	 * @param toolbarId 显示的toolbar的id
	 * @param menuId 右键菜单的id
	 *
	**/
	//该表格的表头右键菜单，隐藏显示列，用于没有check的复选框，其他同loadDataGrid1
	function loadDataGrid2(tableId, title, url, columns, toolbarId, menuId){
		//加载datagrid表格
		$("#"+tableId).datagrid({
			title:title,//表格的标题
			//width:250,//表格的宽度
			fit:true,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			multiSort:true,//允许多行排序
			remoteSort:false,//不从服务器进行排序
		    url:url,//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    //checkOnSelect、selectOnCheck、onClickRow、checkAll，这4个是用来解决点击行的时候是单选，但是点checkbox的时候可以多选
		    checkOnSelect:true,//当用户点击行的时候该复选框就会被选中或取消选中。
		    selectOnCheck:true,//如果为true，单击复选框将永远选择行。
		    onClickRow:function(rowIndex){//在用户点击一行的时候触发的事件，rowIndex：点击的行的索引值，该索引值从0开始
		    	$(this).datagrid('uncheckAll');//取消勾选当前页中的所有行。
		    	$(this).singleSelect = true;//只能选择一行
		    	$(this).datagrid('selectRow', rowIndex);//选择一行，行索引从0开始。
		    },
		    checkAll:function(){//勾选当前页中的所有行。
		    	$(this).singleSelect = false;//允许多选
		    },
		    columns:columns,//表格的各个字段
		    toolbar: toolbarId,
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex>=0){//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                	$(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
                $("#" + menuId).menu('show', {//显示右键菜单
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
			var fields = $("#"+tableId).datagrid('getColumnFields');
			var nonHiddenCount = 0;//用来记录隐藏的item数
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						if (nonHiddenCount<fields.length-2){
							$("#"+tableId).datagrid('hideColumn', item.name);
							nonHiddenCount++;
							cmenu.menu('setIcon', {
								target: item.target,
								iconCls: 'icon-empty'
							});
						}
					} else {
						$("#"+tableId).datagrid('showColumn', item.name);
						nonHiddenCount--;
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-ok'
						});
					}
				}
			});
			for(var i=1; i<fields.length; i++){
				var field = fields[i];
				var col = $("#"+tableId).datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
	}
	
	
	
	/**
	 * 创建数据表格 该数据表格复选框选择不变色，鼠标点击行变色,需要配合base.jsp里的style
	 * @param tableId 数据表格的id
	 * @param title 数据表格的标题
	 * @param url 数据表格加载数据的url
	 * @param id 标识字段。
	 * @param columns 表格的列属性
	 * @param toolbarId 显示的toolbar的id
	 * @param menuId 右键菜单的id
	 *
	**/
	function loadDataGrid3(tableId, title, url, columns, toolbarId, menuId){
		//加载datagrid表格
		$("#"+tableId).datagrid({
			title:title,//表格的标题
			//width:250,//表格的宽度
			fit:true,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			multiSort:true,//允许多行排序
		    url:url,//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    //checkOnSelect、selectOnCheck、onClickRow、checkAll，这4个是用来解决点击行的时候是单选，但是点checkbox的时候可以多选
		    checkOnSelect:false,//当用户点击行的时候该复选框就会被选中或取消选中。
		    selectOnCheck:true,//如果为true，单击复选框将永远选择行。
		    columns:columns,//表格的各个字段
		    toolbar: toolbarId,
		    onClickRow:function(index,data){
				var opt = $(this).datagrid("options");
				var rows1 = opt.finder.getTr(this,"","allbody",1);
				var rows2 = opt.finder.getTr(this,"","allbody",2);
				if(rows1.length > 0){
					$(rows1).each(function(){
						var tempIndex = parseInt($(this).attr("datagrid-row-index"));
						if(tempIndex == index){
							$(this).addClass("datagrid-row-click");
						}else{
							$(this).removeClass("datagrid-row-click");
						}
					});
				}
				if(rows2.length > 0){
					$(rows2).each(function(){
						var tempIndex = parseInt($(this).attr("datagrid-row-index"));
						if(tempIndex == index){
							$(this).addClass("datagrid-row-click");
						}else{
							$(this).removeClass("datagrid-row-click");
						}
					});
				}
			},
			onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                $(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                $("#" + menuId).menu('show', {//显示右键菜单
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
			var fields = $("#"+tableId).datagrid('getColumnFields');
			var nonHiddenCount = 0;//用来记录隐藏的item数
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						if (nonHiddenCount<fields.length-2){
							$("#"+tableId).datagrid('hideColumn', item.name);
							nonHiddenCount++;
							cmenu.menu('setIcon', {
								target: item.target,
								iconCls: 'icon-empty'
							});
						}
					} else {
						$("#"+tableId).datagrid('showColumn', item.name);
						nonHiddenCount--;
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-ok'
						});
					}
				}
			});
			for(var i=1; i<fields.length; i++){
				var field = fields[i];
				var col = $("#"+tableId).datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
	}
	
	
	/**
	 * 创建数据表格（用于form里面的表格高度问题，form里面的table高度只显示标题和工具栏的高度，表格数据内容会不显示） 
	 * @param tableId 数据表格的id
	 * @param title 数据表格的标题
	 * @param url 数据表格加载数据的url
	 * @param id 标识字段。
	 * @param columns 表格的列属性
	 * @param toolbarId 显示的toolbar的id
	 * @param menuId 右键菜单的id
	 *
	**/
	function loadDataGrid4(tableId, title, url, columns, toolbarId, menuId){
		//加载datagrid表格
		$("#"+tableId).datagrid({
			title:title,//表格的标题
			//width:400,//表格的宽度
			fit:false,//当设置为true的时候面板大小将自适应父容器
			fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
			striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
			singleSelect:true,//单选
		    url:url,//从后台加载json数据的url
		    idField:'id',//指明哪一个字段是标识字段。
		    loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
		    rownumbers:true,//显示一个行号列。
		    columns:columns,//表格的各个字段
		    toolbar: toolbarId,
		});
	}
	
	
	
	
	/**
	 * 展开treegrid的所有节点
	 * @param tableId 要展开的treegrid的id
	 */
	function expandAllNode(tableId){
		$("#"+tableId).treegrid('expandAll');
	}
	
	/**
	 * 折叠treegrid的所有节点
	 * @param tableId 要折叠的treegrid的id
	 */
	function collapseAllNode(tableId){
		$("#"+tableId).treegrid('collapseAll')
	}
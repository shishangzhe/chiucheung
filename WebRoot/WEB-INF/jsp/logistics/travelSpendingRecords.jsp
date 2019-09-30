<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>差旅支出记录表</title>
	<jsp:include page="/common.jsp"></jsp:include>
  </head>
  <script type="text/javascript">
  window.onload=window.onresize = function(){
		if ($(document.body).width()<$("#dialog1").width()){
			if ($(document.body).height()<$("#dialog1").height()){
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width: $(document.body).width(),
					height:$(document.body).height(),
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:0
				});
			}else{
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width: $(document.body).width(),
					height:600,
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:($(document.body).height()-74-$("#dialog1").height())/2,
				});
			}
		}else{
			if ($(document.body).height()<($("#dialog1").height()+74)){
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width: 800,
					height:$(document.body).height(),
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:0
				});
			}else{
				$("#dialog1").dialog({
					closed:$("#dialog1").dialog("options").closed,
					width:800,
					height:600,
					left:($(document.body).width()-$("#dialog1").width())/2,
					top:($(document.body).height()-74-$("#dialog1").height())/2,
				});
			}
		}
		$("#dialog1").dialog({//加载一个dialog
			closed:$("#dialog1").dialog("options").closed,
			left:($(document.body).width()-$("#dialog1").width())/2,
			top:($(document.body).height()-74-$("#dialog1").height())/2,
		});
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
	$(function () {
		$('#dg').treegrid({
			title:'差旅支出记录表',
			fit:true,//当设置为true的时候面板大小将自适应父容器
			//fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
		    url:'${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelSpendingRecords.action',    
		    idField:'id', 
		    treeField:'travelDate',  
		    toolbar: '#gridToolBar',
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    //rownumbers:true,//显示一个行号列。
		    //lines:true,//定义是否显示treegrid行
		    animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
		    frozenColumns:[[
						{field:'travelDate',title:'日期',width:120,align:'center',sortable:true},
						{field:'username',title:'姓名',width:60,align:'center',sortable:true},
						{field:'workCardNo',title:'工咭号',width:70,align:'center',sortable:true},
	                      ]],
		    columns:[[	
				        {field:'isAirpoint',title:'<div style="height:100%;float:left">机场<br>项目</div><div style="height:9px"></div>',width:40,align:'center',rowspan:2,sortable:true},
				        {field:'provinces',title:'省份',width:45,align:'center',rowspan:2,sortable:true},
				        {field:'city',title:'城市',width:45,align:'center',rowspan:2,sortable:true},
						{title:'住宿',colspan:2},
				        {title:'上午',colspan:3},
				        {title:'下午',colspan:3},
				        {title:'晚上',colspan:3},
				        {field:'startPoint',title:'起点',width:45,align:'center',rowspan:2},
				        {field:'endPoint',title:'终点',width:45,align:'center',rowspan:2},
				        {field:'trafficType',title:'交通类型',width:60,align:'center',rowspan:2},
				        {field:'invoiceType',title:'有无发票',width:60,align:'center',rowspan:2},
				        {field:'trafficPrice',title:'价格',width:45,align:'center',rowspan:2,formatter: function(value,row,index){
																											if (value != undefined && value != null && value != ""){
																												if ((value*1).toFixed(0) == value*1){//如果小数点是零，则直接取整数
																													value = (value*1).toFixed(0);
																												}
																											}
																											return value;
																										}
						},
				        {field:'description',title:'费用描述',width:100,align:'center',rowspan:2},
				        {field:'subsidiesType',title:'费用类型',width:60,align:'center',rowspan:2},
				        {field:'otherPrice',title:'价格',width:45,align:'center',rowspan:2,formatter: function(value,row,index){
																											if (value != undefined && value != null && value != ""){
																												if ((value*1).toFixed(0) == value*1){//如果小数点是零，则直接取整数
																													value = (value*1).toFixed(0);
																												}
																											}
																											return value;
																										}
				        },
				    ],[
						{field:'liveNumber',title:'房间数',width:55,align:'center',sortable:true},
						{field:'livePrice',title:'价格',width:50,align:'center',sortable:true},
						{field:'startTime1',title:'开始时间',width:70,align:'center',sortable:true},
				        {field:'endTime1',title:'结束时间',width:70,align:'center',sortable:true},
				        {field:'lunch',title:'午餐',width:50,align:'center',sortable:true},
				        {field:'startTime2',title:'开始时间',width:70,align:'center',sortable:true},
				        {field:'endTime2',title:'结束时间',width:70,align:'center',sortable:true},
				        {field:'dinner',title:'晚餐',width:50,align:'center',sortable:true},
				        {field:'startTime3',title:'开始时间',width:70,align:'center',sortable:true},
				        {field:'endTime3',title:'结束时间',width:70,align:'center',sortable:true},
				        {field:'midnightSnack',title:'夜宵',width:50,align:'center',sortable:true}
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
		    	var url = '${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelSpendingRecordsSubsidiaryListByLogTravelSpendingRecordsId.action'; 
                $(this).treegrid("options").url = url;  
                return true; 
            },onExpand : function(row){
            	//展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
            	var url = '${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelSpendingRecords.action'; 
                $(this).treegrid("options").url = url;
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
            	var url = '${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelSpendingRecords.action'; 
                $(this).treegrid("options").url = url;
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
            	var url = '${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelSpendingRecords.action'; 
                $(this).treegrid("options").url = url;
            }
		});
		
		$('#logTravelUserId').combogrid({
			url:'${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelUserList.action',
			panelWidth:420,    
		    idField:'id',//下列表的标识id    
		    textField:'username',//下拉框文本显示的字段
		    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
		    editable:false,//下拉框文本不可以编辑
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    toolbar:'#gridToolBar2',
		    columns:[[	
						{field:'workNo',title:'工号',width:70,align:'center'},
						{field:'username',title:'姓名',width:70,align:'center'},
						{field:'groupsId',title:'分组',width:70,align:'center'},
						{field:'isAllowedLogin',title:'是否允许登陆',width:70,align:'center'}
				    ]],//表格的各个字段
					fitColumns: true/* ,
			onShowPanel:function(){
				var g = $('#logTravelUserId').combogrid('grid');
				var queryParams = g.datagrid('options').queryParams;
				g.datagrid("load",queryParams);
				$("#queryForm2").form("load",queryParams);
			} */
			/* onChange:function(newValue, oldValue){
				var g = $('#username').combogrid('grid');	// 获取数据表格对象
				var selected = g.datagrid('getSelected');
				if (selected != null){
					var level = selected.level;
					$('#level').val(level);
					var other = document.getElementById("other");
					//获取子元素的数量
					var length = other.childElementCount;
					var b = true;
					for(var i=0;i<length-1;i++){
						if ($("#otherDescription"+i).combobox("getValue") == "办证费"){
							b = false;
							break;
						}
					}
					if (b){
						subsidies();
						
						if (document.getElementById("checkbox").checked){
							var subsidiesDiv = document.getElementById("subsidies");
							//获取子元素的数量
							var length = subsidies.childElementCount;
							
							var div = document.createElement("div");
							
							div.innerHTML = '<input id="subsidiesId'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].id">'
							+ '<input id="subsidiesSequence'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].sequence" value="'+length+'">'
							+ '<input id="subsidiesIsSubsidies'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].isSubsidies" value="true">'
							+ ' 费用描述：<input id="subsidiesDescription'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="住分公司补贴">'
							+ ' 价格：<input id="subsidiesPrice'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="10">'
							+ '<div style="height:5px"></div>';
							
							subsidiesDiv.appendChild(div);
							
							$('#subsidiesDescription'+(length-1)).textbox();
							$('#subsidiesPrice'+(length-1)).numberbox();
							
							$("#liveNumber").numberbox("clear");
							$("#livePrice").numberbox("clear");
							$("#liveNumber").numberbox("readonly",true);
							$("#livePrice").numberbox("readonly",true);
						}else{
							$("#liveNumber").numberbox("readonly",false);
							$("#livePrice").numberbox("readonly",false);
						}
					}
				}
			} */
		});
		
		$('#groupsId_query2,#groupsId_query3').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "销售部"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		$('#groupsId').combobox({    
		    url:"${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "销售部"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		});
		
		$("#applicant").combogrid({
			url:'${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelUserList.action',
			panelWidth:420,
		    idField:'username',//下列表的标识id    
		    textField:'username',//下拉框文本显示的字段
		    //rownumbers:true,//显示行号,combogrid中显示行号会有问题
		    editable:false,//下拉框文本不可以编辑
		    pagination:true,
			pageSize:50,
			pageList:[50,100,200,500],
		    toolbar:'#gridToolBar3',
		    columns:[[	
						{field:'workNo',title:'工号',width:70,align:'center'},
						{field:'username',title:'姓名',width:70,align:'center'},
						{field:'groupsId',title:'分组',width:70,align:'center'},
						{field:'isAllowedLogin',title:'是否允许登陆',width:70,align:'center'}
				    ]],//表格的各个字段
					fitColumns: true,
		    onShowPanel:function(){//显示combogrid下拉框事件
		    	$(this).combogrid('grid').datagrid('options').url = '${pageContext.request.contextPath}/logistics/travelSpendingRecords/findAllTravelUserList.action';
				$(this).combogrid('grid').datagrid('load');//重新加载数据，否则下面隐藏方法给表格添加表格含有相同数据的时候，无法开启表格的编辑
		    }
		});
		
		$('#provinces').combobox({    
		    url:'${pageContext.request.contextPath}/js/city.data.js',    
		    valueField:'text',    
		    textField:'text',
		    editable:false,
		    onChange:function(newValue,oldValue){
		    	var data  = $(this).combobox("getData");
		    	for (var i=0;i<data.length;i++){
		    		if (data[i].text == newValue){
		    			$('#city').combobox("loadData",data[i].children);
		    			$('#city').combobox("select",data[i].children[0].text);
		    			$('#city').combobox("clear");
		    			setMealFee();
		    		}
		    	}
		    }
		});
		$('#city').combobox({    
		    valueField:'text',    
		    textField:'text',
		    editable:false,
		    onChange:function(newValue,oldValue){
		    	setMealFee();
		    }
		});
		/* $('#travelDate').datebox({
		    onSelect: function(date){
		    	if (data.getDay != "0"){//不是周日
		    		var subsidies = document.getElementById("subsidies");
		    		var length = subsidies.childElementCount;
		    		for (var i=0;i<length;i++)
		    			if ($("#subsidiesDescription"+i).combobox("getValue").indexOf("周日") >= 0){
		    				 
		    			}else{
		    				
		    			}
		    		}
		    	}
		    }
		}); */


		
		$('#lunchType').combobox({
			onHidePanel:function(){
				var text = $('#lunchType').combobox('getText');
				var isAirpoint = $("#isAirpoint").combobox("getValue");
				if (text == "动车高铁(含早餐)"){
					$('#lunch').textbox('setValue','50');
				}else if (text == "动车高铁(不含早餐)"){
					$('#lunch').textbox('setValue','45');
				}else if (text == "普通列车(含早餐)"){
					$('#lunch').textbox('setValue','30');
				}else if (text == "普通列车(不含早餐)"){
					$('#lunch').textbox('setValue','25');
				}else if (text == "上班(含早餐)"){
					if (isAirpoint == "是"){//如果是机场，不管哪里都是一样
						$('#lunch').textbox('setValue','35');
					}else{//如果不是机场，则要判断是否是省会城市或直辖市
						if (isProvincesCity()){
							$('#lunch').textbox('setValue','35');
						}else{
							$('#lunch').textbox('setValue','30');
						}
					}
				}else if (text == "上班(不含早餐)"){
					if (isAirpoint == "是"){//如果是机场，不管哪里都是一样
						$('#lunch').textbox('setValue','30');
					}else{//如果不是机场，则要判断是否是省会城市或直辖市
						if (isProvincesCity()){
							$('#lunch').textbox('setValue','30');
						}else{
							$('#lunch').textbox('setValue','25');
						}
					}
				}else if (text == "早餐"){
					$('#lunch').textbox('setValue','5');
				}else if (text == "无"){
					$('#lunch').textbox('setValue','');
				}
			}
		});
		
		$('#dinnerType').combobox({
			onHidePanel:function(){
				var text = $('#dinnerType').combobox('getText');
				var isAirpoint = $("#isAirpoint").combobox("getValue");
				if (text == "动车高铁"){
					$('#dinner').textbox('setValue','45');
				}else if (text == "普通列车"){
					$('#dinner').textbox('setValue','25');
				}else if (text == "上班"){
					if (isAirpoint == "是"){//如果是机场，不管哪里都是一样
						$('#dinner').textbox('setValue','30');
					}else{//如果不是机场，则要判断是否是省会城市或直辖市
						if (isProvincesCity()){
							$('#dinner').textbox('setValue','30');
						}else{
							$('#dinner').textbox('setValue','25');
						}
					}
				}else if (text == "无"){
					$('#dinner').textbox('setValue','');
				}
			}
		});
		
		$("#isAirpoint").combobox({
			onChange: function(newValue,oldValue){
				setMealFee();
			}
		});	
		
		
		$("#startTime3,#endTime3").timespinner({
			onSpinUp:function(){
				setMidnightSnack();
			},
			onSpinDown:function(){
				setMidnightSnack();
			},
			onChange:function(){
				setMidnightSnack();
			}
		});
		$("#startTime3").timespinner("textbox").bind('input propertychange', function() { 
			setMidnightSnack();
		});
		$("#endTime3").timespinner("textbox").bind('input propertychange', function() { 
			setMidnightSnack();
		});

		/* $("#checkbox").change(function(){
			var subsidies = document.getElementById("subsidies");
			//获取子元素的数量
			var length = subsidies.childElementCount;
			if (this.checked){
				var div = document.createElement("div");
				
				div.innerHTML = '<input id="subsidiesId'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].id">'
				+ '<input id="subsidiesSequence'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].sequence" value="'+length+'">'
				+ '<input id="subsidiesIsSubsidies'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].isSubsidies" value="true">'
				+ ' 费用描述：<input id="subsidiesDescription'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="住分公司补贴">'
				+ ' 价格：<input id="subsidiesPrice'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="10">'
				+ '<div style="height:5px"></div>';
				
				subsidies.appendChild(div);
				
				$('#subsidiesDescription'+(length-1)).textbox();
				$('#subsidiesPrice'+(length-1)).numberbox();
				
				$("#liveNumber").numberbox("clear");
				$("#livePrice").numberbox("clear");
				$("#liveNumber").numberbox("readonly",true);
				$("#livePrice").numberbox("readonly",true);
			}else{
				subsidies.removeChild(subsidies.lastChild);
				$("#liveNumber").numberbox("readonly",false);
				$("#livePrice").numberbox("readonly",false);
			}
		}); */
		
		$("#queryForm").keyup(function (event){
			if (event.keyCode == 13){
				query();
			}
		});
		$("#queryForm2").keyup(function (event){
			if (event.keyCode == 13){
				query2();
			}
		});
		
		$("#queryForm3").keyup(function (event){
			if (event.keyCode == 13){
				query3();
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
				
				//要清空，否则前面有的会有问题
				$("#queryForm2").form('reset');
				query2();
				
				$("#isAirpoint").combobox("setValue","否");
				$("#liveNumber").numberbox("readonly",false);
				$("#livePrice").numberbox("readonly",false);
				$("#flag").val("add");
				$("#level").val("");
				$("#city").combobox("loadData","");//清空下拉选项
				//$('#provinces').combobox("setValue","请选择");
				//$('#city').combobox("setValue","请选择");
				//$('#nextProvinces').combobox("setValue","请选择");
				var traffic = document.getElementById("traffic");
				var trafficLength = traffic.childElementCount;
				for (var i=0;i<trafficLength-1;i++){
					traffic.removeChild(traffic.lastChild);
				}
				var other = document.getElementById("other");
				var otherLength = other.childElementCount;
				for (var i=0;i<otherLength-1;i++){
					other.removeChild(other.lastChild);
				}
				var subsidies = document.getElementById("subsidies");
				var subsidiesLength = subsidies.childElementCount;
				for (var i=0;i<subsidiesLength-1;i++){
					subsidies.removeChild(subsidies.lastChild);
				}
				$("#dialog1").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增出差记录'//该dialog的标题
				});
			}
		});
	}
	
	function edit(){
		var selected = $('#dg').treegrid("getSelected");
		if (selected != null){
			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			var url = '${pageContext.request.contextPath}/logistics/travelSpendingRecords/findTravelSpendingRecordsById.action';
			$.ajax({
				type:'post',
				url:url,
				data:{id:id},
				async: false,//同步请求
				cache: false,//不缓存此页面
				success:function(data){
					if (data != null && data != ""){
						if (data.success){
							$("#form1").form('reset');//重置表单数据
							$("#liveNumber").numberbox("readonly",false);
							$("#livePrice").numberbox("readonly",false);
							$("#flag").val('update');
							$("#level").val("");
							$("#city").combobox("loadData","");//清空下拉选项
							var traffic = document.getElementById("traffic");
							var trafficLength = traffic.childElementCount;
							for (var i=0;i<trafficLength-1;i++){
								traffic.removeChild(traffic.lastChild);
							}
							var other = document.getElementById("other");
							var otherLength = other.childElementCount;
							for (var i=0;i<otherLength-1;i++){
								other.removeChild(other.lastChild);
							}
							
							//要清空，否则前面有的会有问题
							$("#queryForm2").form('reset');
							
							var travelSpendingRecordsCustom = data.travelSpendingRecordsCustom;
							$("#username_query2").textbox("setValue",travelSpendingRecordsCustom.username);
							query2();
							
							$("#form1").form('load',travelSpendingRecordsCustom);
							$("#city").combobox("setValue",travelSpendingRecordsCustom.city);
							//先加载数据，在清空，因为后面会加载这条数据的这里的内容
							var subsidies = document.getElementById("subsidies");
							var subsidiesLength = subsidies.childElementCount;
							for (var i=0;i<subsidiesLength-1;i++){
								subsidies.removeChild(subsidies.lastChild);
							}
							
							if (data.success){
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:"修改出差记录"//该dialog的标题
								});
							}
							var traffics = travelSpendingRecordsCustom.traffics;
							if (traffics.length > 0){
								for (var i=0;i<traffics.length;i++){
									trafficAdd();
									document.getElementById("trafficId"+i).value = traffics[i].id;
									document.getElementById("trafficSequence"+i).value = traffics[i].sequence;
									$("#trafficStartPoint"+i).textbox("setValue",traffics[i].startPoint);
									$("#trafficEndPoint"+i).textbox("setValue",traffics[i].endPoint);
									$("#trafficTrafficType"+i).combobox("setValue",traffics[i].trafficType);
									$("#trafficInvoiceType"+i).combobox("setValue",traffics[i].invoiceType);
									$("#trafficPrice"+i).textbox("setValue",numberToFixed(traffics[i].price*1));
								}
							}
							var others = travelSpendingRecordsCustom.others;
							if (others.length > 0){
								for (var i=0;i<others.length;i++){
									otherAdd();
									document.getElementById("otherId"+i).value = others[i].id;
									document.getElementById("otherSequence"+i).value = others[i].sequence;
									document.getElementById("otherIsSubsidies"+i).value = others[i].isSubsidies;
									$("#otherDescription"+i).textbox("setValue",others[i].description);
									$("#otherPrice"+i).textbox("setValue",numberToFixed(others[i].price*1));
								}
							}
							var subsidies = travelSpendingRecordsCustom.subsidies;
							if (subsidies.length > 0){
								for (var i=0;i<subsidies.length;i++){
									subsidiesAdd();
									document.getElementById("subsidiesId"+i).value = subsidies[i].id;
									document.getElementById("subsidiesSequence"+i).value = subsidies[i].sequence;
									document.getElementById("subsidiesIsSubsidies"+i).value = subsidies[i].isSubsidies;
									$("#subsidiesDescription"+i).combobox("setValue",subsidies[i].description);
									$("#subsidiesPrice"+i).textbox("setValue",numberToFixed(subsidies[i].price*1));
									
									if (subsidies[i].description == "住宿补贴"){
										$("#liveNumber").numberbox("readonly",true);
										$("#livePrice").numberbox("readonly",true);
									}
								}
							}
						}else{
							showMessager("错误",'<font color="red">'+data.message+'<font/>');
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
			if ($("#liveNumber").numberbox("getValue") != "" && $("#livePrice").numberbox("getValue") == ""){
				alert("住宿的价格不能为空");
				return;
			}else if ($("#liveNumber").numberbox("getValue") == "" && $("#livePrice").numberbox("getValue") != ""){
				alert("住宿的房数不能为空");
				return;
			}
		
			if ($("#startTime1").spinner("getValue") != "" && $("#endTime1").spinner("getValue") == ""){
				alert("上午的结束时间不能为空");
				return;
			}else if ($("#startTime1").spinner("getValue") == "" && $("#endTime1").spinner("getValue") != ""){
				alert("上午的开始时间不能为空");
				return;
			}
			var startTimes1 = $("#startTime1").timespinner("getValue").split(":");
			var endTimes1 = $("#endTime1").timespinner("getValue").split(":");
			var startTime1 = Date.UTC(1970,0,1,startTimes1[0],startTimes1[1],startTimes1[2]);
			var endTime1 = Date.UTC(1970,0,1,endTimes1[0],endTimes1[1],endTimes1[2]);
			if (startTime1 >= endTime1 ){
				alert("上午的开始时间不能大于等于结束时间");
				return;
			}
			
			
			if ($("#startTime2").spinner("getValue") != "" && $("#endTime2").spinner("getValue") == ""){
				alert("下午的结束时间不能为空");
				return;
			}else if ($("#startTime2").spinner("getValue") == "" && $("#endTime2").spinner("getValue") != ""){
				alert("下午的开始时间不能为空");
				return;
			}
			var startTimes2 = $("#startTime2").timespinner("getValue").split(":");
			var endTimes2 = $("#endTime2").timespinner("getValue").split(":");
			var startTime2 = Date.UTC(1970,0,1,startTimes2[0],startTimes2[1],startTimes2[2]);
			var endTime2 = Date.UTC(1970,0,1,endTimes2[0],endTimes2[1],endTimes2[2]);
			if (startTime2 >= endTime2 ){
				alert("下午的开始时间不能大于等于结束时间");
				return;
			}
			
			if ($("#startTime3").spinner("getValue") != "" && $("#endTime3").spinner("getValue") == ""){
				alert("晚上的结束时间不能为空");
				return;
			}else if ($("#startTime3").spinner("getValue") == "" && $("#endTime3").spinner("getValue") != ""){
				alert("晚上的开始时间不能为空");
				return;
			}
			
			
			
			var dates = $("#travelDate").datebox('getValue').split("-");
			var date = new Date();
			date.setFullYear(dates[0],dates[1]*1-1,dates[2]);
			
			var subsidies = document.getElementById("subsidies");
    		var length = subsidies.childElementCount;
			if (date.getDay() != "0"){//非周日，周日可能是半天，是没有周日补贴的
				for (var i=0;i<length-1;i++){
	    			if ($("#subsidiesDescription"+i).combobox("getValue").indexOf("周日") >= 0){
	    				alert("当前日期不是周日，不能添加周日补贴");
	    				return;
	    			}
	    		}
			}
			
			var flag = $("#flag").val();//获取标识符，
			var url = "${pageContext.request.contextPath}/logistics/travelSpendingRecords/";
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveTravelSpendingRecords.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateTravelSpendingRecords.action";
			}
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: $( "#form1" ).serialize(),//传的参数,序列化表单
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
							showMessager("错误",'<font color="red">'+data.message+'<font/>');
						}
					}
				}
			});
		}
	}
	
	function removeData(){
		var selected = $("#dg").treegrid("getSelected");
  		if (selected != null){
  			$.messager.confirm('确认对话框', '您确定要删除吗？', function(b){//给用户一个删除几条信息的确认提示框
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
						url: "${pageContext.request.contextPath}/logistics/travelSpendingRecords/deleteTravelSpendingRecordsById.action",//ajax请求的url
						data: {id:id},//传的参数,序列化表单
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							if (data != null && data != ""){
								if (data.success){
									showMessager("提示","删除成功");
									$("#dg").treegrid('reload');//重新加载数据，保持在当前页
									$("#dg").treegrid('clearSelections');//清除所有选择的行
								}else{
									showMessager("错误",'<font color="red">'+data.message+'<font/>');
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
	
	//复制数据
  	function copyData(){
  		var select = $("#dg").treegrid("getSelected");
  		if (select != null){
  			var id = "";
			//判断是否是子节点
			if($("#dg").treegrid('isLeaf',select.id)){//是子节点
				id = select._parentId;//取到父节点的ID
			}else{//不是子节点
				id = select.id;//当前就是父节点，直接取ID
			}
 			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/logistics/travelSpendingRecords/findTravelSpendingRecordsByIdForCopyData.action",//ajax请求的url
				data: {id:id},//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success){
							$("#form1").form('reset');//重置表单数据
							$("#liveNumber").numberbox("readonly",false);
							$("#livePrice").numberbox("readonly",false);
							$("#flag").val("add");
							$("#level").val("");
							$("#city").combobox("loadData","");//清空下拉选项
							var traffic = document.getElementById("traffic");
							var trafficLength = traffic.childElementCount;
							for (var i=0;i<trafficLength-1;i++){
								traffic.removeChild(traffic.lastChild);
							}
							var other = document.getElementById("other");
							var otherLength = other.childElementCount;
							for (var i=0;i<otherLength-1;i++){
								other.removeChild(other.lastChild);
							}
							var subsidies = document.getElementById("subsidies");
							var subsidiesLength = subsidies.childElementCount;
							for (var i=0;i<subsidiesLength-1;i++){
								subsidies.removeChild(subsidies.lastChild);
							}
							
							//要清空，否则前面有的会有问题
							$("#queryForm2").form('reset');
							
							var travelSpendingRecordsCustom = data.travelSpendingRecordsCustom;
							$("#username_query2").textbox("setValue",travelSpendingRecordsCustom.username);
							query2();
							
							$("#form1").form('load',travelSpendingRecordsCustom);
							$("#city").combobox("setValue",travelSpendingRecordsCustom.city);
							if (data.success){
								$("#dialog1").dialog({//加载一个dialog
									closed:false,//将该dialog的状态由不显示改成显示
									title:"新增出差记录"//该dialog的标题
								});
							}
							var traffics = travelSpendingRecordsCustom.traffics;
							if (traffics.length > 0){
								for (var i=0;i<traffics.length;i++){
									trafficAdd();
									document.getElementById("trafficId"+i).value = traffics[i].id;
									document.getElementById("trafficSequence"+i).value = traffics[i].sequence;
									$("#trafficStartPoint"+i).textbox("setValue",traffics[i].startPoint);
									$("#trafficEndPoint"+i).textbox("setValue",traffics[i].endPoint);
									$("#trafficTrafficType"+i).combobox("setValue",traffics[i].trafficType);
									$("#trafficInvoiceType"+i).combobox("setValue",traffics[i].invoiceType);
									$("#trafficPrice"+i).textbox("setValue",numberToFixed(traffics[i].price*1));
								}
							}
							var others = travelSpendingRecordsCustom.others;
							if (others.length > 0){
								for (var i=0;i<others.length;i++){
									otherAdd();
									document.getElementById("otherId"+i).value = others[i].id;
									document.getElementById("otherSequence"+i).value = others[i].sequence;
									document.getElementById("otherIsSubsidies"+i).value = others[i].isSubsidies;
									$("#otherDescription"+i).textbox("setValue",others[i].description);
									$("#otherPrice"+i).textbox("setValue",numberToFixed(others[i].price*1));
								}
							}
							var subsidies = travelSpendingRecordsCustom.subsidies;
							if (subsidies.length > 0){
								for (var i=0;i<subsidies.length;i++){
									subsidiesAdd();
									document.getElementById("subsidiesId"+i).value = subsidies[i].id;
									document.getElementById("subsidiesSequence"+i).value = subsidies[i].sequence;
									document.getElementById("subsidiesIsSubsidies"+i).value = subsidies[i].isSubsidies;
									$("#subsidiesDescription"+i).combobox("setValue",subsidies[i].description);
									$("#subsidiesPrice"+i).textbox("setValue",numberToFixed(subsidies[i].price*1));
									
									if (subsidies[i].description == "住宿补贴"){
										$("#liveNumber").numberbox("readonly",true);
										$("#livePrice").numberbox("readonly",true);
									}
								}
							}
						}else{
							showMessager("错误",'<font color="red">'+data.message+'<font/>');
						}
					}
				}
			});
  		}else{
  			showMessager("提示","请选择一条记录进行复制");
  		}
  	}
	
	
	function reload(){
		$("#dg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	function query(){
		$("#dg").treegrid('load',$("#queryForm").serializeObject());//重载行。等同于'load'方法，但是它将保持在当前页。
	}
	
	//查询数据
  	function query2(){
  		$("#logTravelUserId").combogrid('grid').datagrid('load',$("#queryForm2").serializeObject());//重新加载数据
		$("#logTravelUserId").combogrid('grid').datagrid('clearSelections');//清除所有选择的行
  	}
	
  //查询数据
  	function query3(){
  		$("#applicant").combogrid('grid').datagrid('load',$("#queryForm3").serializeObject());//重新加载数据
		$("#applicant").combogrid('grid').datagrid('clearSelections');//清除所有选择的行
  	}
	
	
	//动态设置值
	//是否是省会城市或者直辖市
	function isProvincesCity(){
		var provinces = $("#provinces").combobox("getValue");
		var city = $("#city").combobox("getValue");
		var provinceses = "、北京市、上海市、天津市、重庆市、香港、澳门、国外";
		var provincesCity = "、石家庄市、太原市、呼和浩特市、沈阳市、长春市、哈尔滨市、南京市、杭州市、合肥市、福州市、南昌市、济南市、郑州市、武汉市、长沙市、广州市、深圳市、南宁市、海口市、成都市、贵阳市、昆明市、拉萨市、西安市、兰州市、西宁市、银川市、乌鲁木齐市、台北市";
		if (provinceses.indexOf(provinces) > 0){
			return true;
		}else if (provincesCity.indexOf(city) > 0){
			return true;
		}else{
			return false;
		}
	}
	
	
	function setMealFee(){
		var isAirpoint = $("#isAirpoint").combobox("getValue");
		var lunchType = $("#lunchType").combobox("getValue");
		var dinnerType = $("#dinnerType").combobox("getValue");
		if (lunchType == "上班(含早餐)"){
			if (isAirpoint == "是"){//如果是机场，不管哪里都是一样
				$("#lunch").textbox("setValue",35);
				//lunch.value = 35;
			}else{//如果不是机场，则要判断是否是省会城市或直辖市
				if (isProvincesCity()){
					$("#lunch").textbox("setValue",35);
				}else{
					$("#lunch").textbox("setValue",30);
				}
			}
		}else if (lunchType == "上班(不含早餐)"){
			if (isAirpoint == "是"){//如果是机场，不管哪里都是一样
				$("#lunch").textbox("setValue",30);
				//lunch.value = 35;
			}else{//如果不是机场，则要判断是否是省会城市或直辖市
				if (isProvincesCity()){
					$("#lunch").textbox("setValue",30);
				}else{
					$("#lunch").textbox("setValue",25);
				}
			}
		}
		if (dinnerType == "上班"){
			if (isAirpoint == "是"){//如果是机场，不管哪里都是一样
				$("#dinner").textbox("setValue",30);
				//dinner.value = 30;
			}else{//如果不是机场，则要判断是否是省会城市或直辖市
				if (isProvincesCity()){
					$("#dinner").textbox("setValue",30);
				}else{
					$("#dinner").textbox("setValue",25);
				}
			}
		}
	}
	
	
	function setMidnightSnack(){
		var startTime3 = $("#startTime3").timespinner("getValue");
		var endTime3 = $("#endTime3").timespinner("getValue");
		if (startTime3 != "" && endTime3 != ""){
			var startTimes = startTime3.split(":");
			var endTimes = endTime3.split(":");
			var startTime = Date.UTC(1970,0,1,startTimes[0],startTimes[1],startTimes[2]);
			var endTime = Date.UTC(1970,0,1,endTimes[0],endTimes[1],endTimes[2]);
			var midnightSnack = document.getElementById("midnightSnack");
			if (startTime < endTime ){//加班时间未超过12点
				if (startTime <= Date.UTC(1970,0,1,4,0,0)){//四点前才有，包括四点
					var hours = (endTime-startTime)/(3600*1000);
					if (hours >= 8){//加班超过8小时
						$("#midnightSnack").textbox('setValue','15');
						//midnightSnack.value = 15;
					}else{//加班未超过8小时
						$("#midnightSnack").textbox('setValue','8');
						//midnightSnack.value = 8;
					}
				}else{
					$("#midnightSnack").textbox('clear');
					midnightSnack.value = "";
				}
			}else{//加班时间超过12点
				var hours = 24-startTime/(3600*1000)+endTime/(3600*1000);
				if (hours >= 8){//加班超过8小时
					$("#midnightSnack").textbox('setValue','25');
				}else{//加班未超过8小时
					$("#midnightSnack").textbox('setValue','8');
				}
			}
		}
	}
	
	
	function trafficAdd(){
		var traffic = document.getElementById("traffic");
		//获取子元素的数量
		var length = traffic.childElementCount;
		var div = document.createElement("div");
		div.innerHTML = '<input id="trafficId'+(length-1)+'" type="hidden" name="traffics['+(length-1)+'].id">'
					+ '<input id="trafficSequence'+(length-1)+'" type="hidden" name="traffics['+(length-1)+'].sequence" value="'+length+'">'
					+ ' 起点：<input id="trafficStartPoint'+(length-1)+'" type="text" name="traffics['+(length-1)+'].startPoint" style="width: 18%;" data-options="required:true,missingMessage:\'起点不能为空\'">'
					+ ' 终点：<input id="trafficEndPoint'+(length-1)+'" type="text" name="traffics['+(length-1)+'].endPoint" style="width: 18%;" data-options="required:true,missingMessage:\'终点不能为空\'">'
					+ ' 交通类型：<input id="trafficTrafficType'+(length-1)+'" type="text" name="traffics['+(length-1)+'].trafficType" style="width: 11%;" data-options="editable:false,required:true,missingMessage:\'交通类型不能为空\'">'
					+ ' 有无发票：<input id="trafficInvoiceType'+(length-1)+'" type="text" name="traffics['+(length-1)+'].invoiceType" style="width: 11%;" data-options="editable:false,required:true,missingMessage:\'有无发票不能为空\'">'
					+ ' 价格：<input id="trafficPrice'+(length-1)+'" type="text" name="traffics['+(length-1)+'].price" style="width: 7%;" data-options="required:true,missingMessage:\'价格不能为空\',validType:\'positiveDecimalForOne\'">'
					+ '<div style="height:5px"></div>';
		traffic.appendChild(div);
		$("#trafficStartPoint"+(length-1)).textbox();
		$("#trafficEndPoint"+(length-1)).textbox();
		$("#trafficTrafficType"+(length-1)).combobox();
		$("#trafficTrafficType"+(length-1)).combobox("loadData",[{value:'公交车',text:'公交车'},{value:'大巴车',text:'大巴车'},{value:'的士',text:'的士'},{value:'火车',text:'火车'},{value:'三轮车',text:'三轮车'},{value:'摩托车',text:'摩托车'}]);
		$("#trafficInvoiceType"+(length-1)).combobox();
		$("#trafficInvoiceType"+(length-1)).combobox("loadData",[{value:'有发票',text:'有发票'},{value:'无发票',text:'无发票'}]);
		$("#trafficPrice"+(length-1)).textbox();
	}
	
	function trafficRemove(){
		var traffic = document.getElementById("traffic");
		var length = traffic.childElementCount;
		if (length > 1){
			traffic.removeChild(traffic.lastChild);
		}
	}
	
	function otherAdd(){
		var other = document.getElementById("other");
		//获取子元素的数量
		var length = other.childElementCount;
		var div = document.createElement("div");
		div.innerHTML = '<input id="otherId'+(length-1)+'" type="hidden" name="others['+(length-1)+'].id">'
					+ '<input id="otherSequence'+(length-1)+'" type="hidden" name="others['+(length-1)+'].sequence" value="'+length+'">'
					+ '<input id="otherIsSubsidies'+(length-1)+'" type="hidden" name="others['+(length-1)+'].isSubsidies" value="false">'
					+ ' 费用描述：<input id="otherDescription'+(length-1)+'" type="text" name="others['+(length-1)+'].description" style="width: 55%;" data-options="editable:false,required:true,missingMessage:\'费用描述不能为空\'">'
					+ ' 价格：<input id="otherPrice'+(length-1)+'" type="text" name="others['+(length-1)+'].price" style="width: 15%;" data-options="required:true,missingMessage:\'价格不能为空\',validType:\'positiveDecimalForOne\'">'
					+ '<div style="height:5px"></div>';
		other.appendChild(div);
		$("#otherDescription"+(length-1)).combobox();
		$("#otherDescription"+(length-1)).combobox("loadData",[{value:'搬运费',text:'搬运费'},{value:'购买工具费',text:'购买工具费'},{value:'取款手续费',text:'取款手续费'},{value:'电话费',text:'电话费'},{value:'快递费',text:'快递费'},{value:'日常用品',text:'日常用品'},{value:'垃圾清理费',text:'垃圾清理费'},{value:'高(低)温补贴',text:'高(低)温补贴'},{value:'办证费',text:'办证费'},{value:'自定义',text:'自定义'}]);
		$("#otherDescription"+(length-1)).combobox({onChange:function(newValue,oldValue){
			var b = true;//用于判断是否存在相同费用描述的标识，
			for (var i=0;i<document.getElementById("other").childElementCount-1;i++){
				if($(this).attr("id") != "otherDescription"+i){//不是自己
					if ($("#otherDescription"+i).combobox("getValue") == newValue){
						b = false;
						break;
					}
				}
			}
			if (!b){
				alert("已存在该项费用");
				$(this).combobox("setValue",oldValue);
			}
			if (newValue == "自定义"){
				var values = prompt("请输入自定的费用描述", "");
				$("#otherDescription"+(length-1)).combobox("setValue",values);
			}
		}});
		$("#otherPrice"+(length-1)).textbox();
	}
	
	function otherRemove(){
		var other = document.getElementById("other");
		var length = other.childElementCount;
		if (length > 1){
			other.removeChild(other.lastChild);
		}
	}
	
	
	function subsidiesAdd(){
		var subsidies = document.getElementById("subsidies");
		//获取子元素的数量
		var length = subsidies.childElementCount;
		var div = document.createElement("div");
		div.innerHTML = '<input id="subsidiesId'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].id">'
				+ '<input id="subsidiesSequence'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].sequence" value="'+length+'">'
				+ '<input id="subsidiesIsSubsidies'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].isSubsidies" value="true">'
				+ ' 费用描述：<input id="subsidiesDescription'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].description" class="mui-input-clear mui-input" style="width: 55%;" data-options="editable:false,required:true,missingMessage:\'费用描述不能为空\'">'
				+ ' 价格：<input id="subsidiesPrice'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly">'
				+ '<div style="height:5px"></div>';
		subsidies.appendChild(div);
		$('#subsidiesDescription'+(length-1)).combobox();
		
		$("#subsidiesDescription"+(length-1)).combobox("loadData",[{value:'带队人每日津贴',text:'带队人每日津贴'},{value:'班组长周日补贴',text:'班组长周日补贴'},{value:'跟单员周日补贴',text:'跟单员周日补贴'},{value:'带队人/构制员周日补贴',text:'带队人/构制员周日补贴'},{value:'住宿补贴',text:'住宿补贴'}]);
		
		$("#subsidiesPrice"+(length-1)).textbox();
		
		$("#subsidiesDescription"+(length-1)).combobox({onChange:function(newValue,oldValue){
			var b = true;//用于判断是否存在相同费用描述的标识，
			var k = 0;
			for (var i=0;i<document.getElementById("subsidies").childElementCount-1;i++){
				if($(this).attr("id") != "subsidiesDescription"+i){//不是自己
					if ($("#subsidiesDescription"+i).combobox("getValue") == newValue){
						b = false;
						break;
					}
				}
				 if ($("#subsidiesDescription"+i).combobox("getValue").indexOf("周日") >= 0){
					k++;
				 }
			}
			if (b){
				if (k<=1){
					if (oldValue == "住宿补贴"){
						$("#liveNumber").numberbox("readonly",false);
						$("#livePrice").numberbox("readonly",false);
					}
					
					if (newValue == "带队人每日津贴"){
						$("#subsidiesPrice"+(length-1)).textbox("setValue","10");
					}else if (newValue == "班组长周日补贴"){
						$("#subsidiesPrice"+(length-1)).textbox("setValue","20");
					}else if (newValue == "跟单员周日补贴"){
						$("#subsidiesPrice"+(length-1)).textbox("setValue","15");
					}else if (newValue == "带队人/构制员周日补贴"){
						$("#subsidiesPrice"+(length-1)).textbox("setValue","10");
					}else if (newValue == "住宿补贴"){
						$("#subsidiesPrice"+(length-1)).textbox("setValue","10");
						$("#liveNumber").numberbox("clear");
						$("#livePrice").numberbox("clear");
						$("#liveNumber").numberbox("readonly",true);
						$("#livePrice").numberbox("readonly",true);
					}
				}else{
					alert("周日补贴只能添加一条");
					$(this).combobox("setValue",oldValue);
				}
			}else{
				alert("已存在该项费用");
				$(this).combobox("setValue",oldValue);
			}
		}});
	}
	
	
	function subsidiesRemove(){
		var subsidies = document.getElementById("subsidies");
		var length = subsidies.childElementCount;
		if (length > 1){
			if ($("#subsidiesDescription"+(length-2)).combobox("getValue") == "住宿补贴"){
				$("#liveNumber").numberbox("readonly",false);
				$("#livePrice").numberbox("readonly",false);
			}
			subsidies.removeChild(subsidies.lastChild);
		}
	}
	
/* 	function subsidies(){
		var level = $('#level').val();
		if (level != ""){
			var dates = $("#travelDate").datebox('getValue').split("-");
			var date = new Date();
			date.setFullYear(dates[0],dates[1]*1-1,dates[2]);
			
			var subsidies = document.getElementById("subsidies");
			//获取子元素的数量
			var length = subsidies.childElementCount;
			for (var i=0;i<length-1;i++){
				subsidies.removeChild(subsidies.lastChild);
			}
			length = subsidies.childElementCount;
			var div = document.createElement("div");
			if (level == "班组长"){//20
				div.innerHTML = '<input id="subsidiesId'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].id">'
						+ '<input id="subsidiesSequence'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].sequence" value="'+length+'">'
						+ '<input id="subsidiesIsSubsidies'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="班组长每日津贴">'
						+ ' 价格：<input id="subsidiesPrice'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="20">'
						+ '<div style="height:5px"></div>';
			}else if (level == "跟单员/技术员"){//15
				div.innerHTML = '<input id="subsidiesId'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].id">'
						+ '<input id="subsidiesSequence'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].sequence" value="'+length+'">'
						+ '<input id="subsidiesIsSubsidies'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="跟单员/技术员每日津贴">'
						+ ' 价格：<input id="subsidiesPrice'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="15">'
						+ '<div style="height:5px"></div>';
			}else if (level == "带队人/技术员"){//10
				div.innerHTML = '<input id="subsidiesId'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].id">'
						+ '<input id="subsidiesSequence'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].sequence" value="'+length+'">'
						+ '<input id="subsidiesIsSubsidies'+(length-1)+'" type="hidden" name="subsidies['+(length-1)+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="带队人/技术员每日津贴">'
						+ ' 价格：<input id="subsidiesPrice'+(length-1)+'" type="text" name="subsidies['+(length-1)+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="10">'
						+ '<div style="height:5px"></div>';
			}else{//无
				
			}
			subsidies.appendChild(div);
			$('#subsidiesDescription'+(length-1)).textbox();
			$('#subsidiesPrice'+(length-1)).numberbox();
			if (date.getDay() == "0"){//周末补贴
				var div1 = document.createElement("div");
				if (level == "班组长"){//20
					div1.innerHTML = '<input id="subsidiesId'+length+'" type="hidden" name="subsidies['+length+'].id">'
						+ '<input id="subsidiesSequence'+length+'" type="hidden" name="subsidies['+length+'].sequence" value="'+(length+1)+'">'
						+ '<input id="subsidiesIsSubsidies'+length+'" type="hidden" name="subsidies['+length+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+length+'" type="text" name="subsidies['+length+'].description" style="width: 55%;" readonly="readonly" value="班组长周日补贴">'
						+ ' 价格：<input id="subsidiesPrice'+length+'" type="text" name="subsidies['+length+'].price" style="width: 15%;" readonly="readonly" value="20">'
						+ '<div style="height:5px"></div>';
				}else if (level == "跟单员/技术员"){//15
					div1.innerHTML = '<input id="subsidiesId'+length+'" type="hidden" name="subsidies['+length+'].id">'
						+ '<input id="subsidiesSequence'+length+'" type="hidden" name="subsidies['+length+'].sequence" value="'+(length+1)+'">'
						+ '<input id="subsidiesIsSubsidies'+length+'" type="hidden" name="subsidies['+length+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+length+'" type="text" name="subsidies['+length+'].description" style="width: 55%;" readonly="readonly" value="跟单员/技术员周日补贴">'
						+ ' 价格：<input id="subsidiesPrice'+length+'" type="text" name="subsidies['+length+'].price" style="width: 15%;" readonly="readonly" value="15">'
						+ '<div style="height:5px"></div>';
				}else if (level == "带队人/技术员"){
					div1.innerHTML = '<input id="subsidiesId'+length+'" type="hidden" name="subsidies['+length+'].id">'
						+ '<input id="subsidiesSequence'+length+'" type="hidden" name="subsidies['+length+'].sequence" value="'+(length+1)+'">'
						+ '<input id="subsidiesIsSubsidies'+length+'" type="hidden" name="subsidies['+length+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+length+'" type="text" name="subsidies['+length+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="带队人/技术员周日补贴">'
						+ ' 价格：<input id="subsidiesPrice'+length+'" type="text" name="subsidies['+length+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="10">'
						+ '<div style="height:5px"></div>';
				}else{//其他人都是10元
					div1.innerHTML = '<input id="subsidiesId'+length+'" type="hidden" name="subsidies['+length+'].id">'
						+ '<input id="subsidiesSequence'+length+'" type="hidden" name="subsidies['+length+'].sequence" value="'+(length+1)+'">'
						+ '<input id="subsidiesIsSubsidies'+length+'" type="hidden" name="subsidies['+length+'].isSubsidies" value="true">'
						+ ' 费用描述：<input id="subsidiesDescription'+length+'" type="text" name="subsidies['+length+'].description" class="mui-input-clear mui-input" style="width: 55%;" readonly="readonly" value="构制员周日补贴">'
						+ ' 价格：<input id="subsidiesPrice'+length+'" type="text" name="subsidies['+length+'].price" class="mui-input-clear mui-input" style="width: 15%;" readonly="readonly" value="10">'
						+ '<div style="height:5px"></div>';
				}
				subsidies.appendChild(div1);
				$('#subsidiesDescription'+length).textbox();
				$('#subsidiesPrice'+length).numberbox();
			}
		}
	} */
	
	
	function numberToFixed(obj){
		if (obj.toFixed(0) == obj){//如果小数点是0，则取整数
			obj = obj.toFixed(0);
		}
		return obj;
	}
	
	
	
	
	function generateCheckSheet(){
		$.messager.confirm('确认对话框', '您确认将当前筛选出来的数据生成报账单吗？', function(b){//给用户一个删除几条信息的确认提示框
			if (b){//如何用户点击的是确认
				$("#applicant").combogrid("clear");
				$("#dialog2").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'生成报账单'//该dialog的标题
				});
			}
		});
	}
	
	function generate(){
		if ($("#form3").form('validate')){//判断 验证是否通过
			var json = $("#dg").treegrid('options').queryParams;
			json.applicant = $("#applicant").combogrid("getValue");
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/logistics/travelSpendingRecords/generateCheckSheet.action",//ajax请求的url
				data: $("#dg").treegrid('options').queryParams,//传的参数,序列化表单
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success){
							showMessager("提示","报账单<font color='red'>"+data.checkSheetNo+"<font/>已经生成");
							$("#dg").treegrid('reload');//重新加载数据，保持在当前页
							$("#dg").treegrid('clearSelections');//清除所有选择的行
							$("#dialog2").dialog({//关闭这个dialog
								closed:true
							});
						}else{
							showMessager("错误",'<font color="red">'+data.message+'<font/>');
						}
					}
				}
			});
		}
	}
	
	
	function exportWorkHour(){
		$("#dialog3").dialog({//加载一个dialog
			closed:false,//将该dialog的状态由不显示改成显示
			title:'导出工时'//该dialog的标题
		});
	}
	function exportExcelForWorkHour(){
  		$("#form4").attr("action","${pageContext.request.contextPath }/logistics/travelSpendingRecords/exportExcelForWorkHour.action");
  		$("#form4").submit();//提交表单
  		
		//window.open("${pageContext.request.contextPath }/logistics/travelSpendingRecords/exportExcel.action");
	}
	function exportExcelForMealsNumber(){
		$("#form4").attr("action","${pageContext.request.contextPath }/logistics/travelSpendingRecords/exportExcelForMealsNumber.action");
  		$("#form4").submit();//提交表单
  		
		//window.open("${pageContext.request.contextPath }/logistics/travelSpendingRecords/exportExcel.action");
	}
  </script>
  <body>
  
  	<table id="dg"   
  		
  		data-options="onDblClickRow:function (row){
													    	if ($(this).treegrid('isLeaf',row.id)){//判断是否是子节点
														    	<p:isPrivilege pid="hj" mid="hjb">
														    		edit();//是子节点则开始编辑
													    		</p:isPrivilege>
													    	}else{
													    		<p:isPrivilege pid="hh" mid="hj">
														    		$(this).treegrid(row.state == 'closed' ? 'expand' : 'collapse',row.id);//是父节点则展开或折叠
														    	</p:isPrivilege>
													    	}
													    }"
  		
  	></table>
  	
  	<div id="gridToolBar" style="padding:5px;height:auto;">
		<div style="display:inline-block;">
			<p:isPrivilege pid="hj" mid="hja">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add();" style="float: left;">新增</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="hj" mid="hjb">
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a> <div class="btn-separator"></div>
			</p:isPrivilege>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a><div class="btn-separator"></div>
			<p:isPrivilege pid="hj" mid="hjc">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeData();" style="float: left;">删除</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<a id="copyData1" href="#" class="easyui-linkbutton" iconCls="icon-large-shapes" plain="true" onClick="copyData()" style="float: left;">复制</a> <div class="btn-separator"></div>
			<p:isPrivilege pid="hj" mid="hjd">
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="generateCheckSheet();" style="float: left;">生成报账单</a><div class="btn-separator"></div>
			</p:isPrivilege>
			<p:isPrivilege pid="hj" mid="hje">
				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="exportWorkHour();" style="float: left;">导出工时/餐次</a><div class="btn-separator"></div>
			</p:isPrivilege>
		</div>
		<div>
			<form id="queryForm">
				姓名：<input id="username_query" type="text" class="easyui-textbox" name="username" style="width: 70px" >
				工咭号：<input id="workCardNo_query" type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				省份：<input id="provinces_query" type="text" class="easyui-textbox" name="provinces" style="width: 70px" >
				城市：<input id="city_query" type="text" class="easyui-textbox" name="city" style="width: 70px" >
				
				日期：<input id="startTime_query" type="text" name="startTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input id="endTime_query" type="text" name="endTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
			</form>
			<form id="generateForm" action="" style="display: none;" method="post">
				姓名：<input type="text" class="easyui-textbox" name="username" style="width: 70px" >
				工咭号：<input type="text" class="easyui-textbox" name="workCardNo" style="width: 70px" >
				省份：<input type="text" class="easyui-textbox" name="provinces" style="width: 70px" >
				城市：<input type="text" class="easyui-textbox" name="city" style="width: 70px" >
				
				日期：<input type="text" name="startTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
				&nbsp;~&nbsp;<input type="text" name="endTime" class="easyui-datebox" style="width: 92px" data-options="editable:false">
			</form>
		</div>
	</div>
	<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
		<p:isPrivilege pid="hj" mid="hja">
    		<div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
   		</p:isPrivilege>
   		<p:isPrivilege pid="hj" mid="hjb">
	    	<div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
	    </p:isPrivilege>
	    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
	    <p:isPrivilege pid="hj" mid="hjc">
	   		<div data-options="iconCls:'icon-remove'" onclick="removeData();">删除</div>
	   	</p:isPrivilege>
	   	<div id="copyData2" data-options="iconCls:'icon-large-shapes'" onclick="copyData()">复制</div>
	</div>
  	
  	
  	
  	<!-- 增&改的dialog -->
	<div id="dialog1" class="easyui-dialog" style="width: 800px;height: 450px;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb1'">
  		<div>
			<form id="form1" style="height: 100%" enctype='multipart/form-data' method="post">
				<input id="id" type="hidden" name="id">
				<input id="flag" type="hidden">
				<input id="level" type="hidden">
				<table cellspacing="0" align="center" width="720px" cellpadding="1" style="table-layout: fixed;margin-top: 10px;">
		  			<tr style="height: 32px;">
		  				<td style="width: 60px;text-align: right;">
		  					员工姓名：
		  				</td>
						<td style="width: 100px;text-align: left;">
							<input id="logTravelUserId" type="text" name="logTravelUserId" style="width: 92px" data-options="required:true,missingMessage:'员工姓名不能为空'">
						</td>  				
		  				<td style="width: 60px;text-align: right;">
		  					工咭号：
		  				</td>
						<td style="width: 100px;text-align: left;">
							<input type="text" name="workCardNo" class="easyui-textbox" style="width: 92px" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkWorkCardNoFormatAndQN'">
						</td>
		  				<td style="width: 60px;text-align: right;">
		  					出差地点：
		  				</td>
						<td style="width: 120px;text-align: left;">
							省份：<select id="provinces" name="provinces" style="width: 80px;" data-options="required:true,missingMessage:'省份不能为空'"></select>
						</td>
						<td style="width: 120px;text-align: left;">
							城市：<select id="city" name="city" style="width: 80px;" data-options="required:true,missingMessage:'城市不能为空'"></select>
						</td>		  				
		  			</tr>
					<tr style="height: 32px;">
		  				<td style="text-align: right;">
		  					日期：
		  				</td>
						<td style="text-align: left;">
							<input id="travelDate" name="travelDate" class="easyui-datebox noClearButton" style="width: 92px" value="<p:date/>" data-options="editable:false">
						</td>		  				
		  				<td style="text-align: right;">
		  					机场项目：
		  				</td>
						<td style="text-align: left;">
								<!-- <input name="isAirpoint" type="checkbox" value="是">是
								<input name="isAirpoint" type="checkbox" value="否" checked="checked">否 -->
							<select id="isAirpoint" class="easyui-combobox" name="isAirpoint" style="width:92px;" data-options="editable:false">   
							    <option>是</option>
							    <option>否</option>
							</select>
						</td>
						<td style="width: 80px;text-align: right;">
		  					住宿：
		  				</td>
						<td style="text-align: left;">
							房数：<input id="liveNumber" name="liveNumber" class="easyui-numberbox" style="width: 80px" data-options="validType:'checkNumber'">
						</td>
						<td style="text-align: left;">
							价格：<input id="livePrice" name="livePrice" class="easyui-numberbox" style="width: 80px" data-options="validType:'checkNumber'">
						</td>		  		
		  			</tr>
				</table>
				<table cellspacing="0" align="center" width="720px" cellpadding="1" style="table-layout: fixed;margin-top: 10px;">
					<tr style="height: 32px;">
						<td style="width: 60px;text-align: right;">
							上午：
						</td>
						<td>
							开始时间：<input id="startTime1" name="startTime1" class="easyui-timespinner" style="width: 80px;" data-options="showSeconds:true">
						</td>
						<td>
							结束时间：<input id="endTime1" name="endTime1" class="easyui-timespinner" style="width: 80px;" data-options="showSeconds:true">
						</td>
						<td style="width: 120px;">
							午餐：<input id="lunch" name="lunch" class="easyui-textbox" style="width: 50px;" readonly="readonly">
						</td>
						<td>
							<select id="lunchType" class="easyui-combobox" name="lunchType" style="width:130px;" data-options="editable:false">   
							    <option>无</option>
							    <option>早餐</option>
							    <option>上班(含早餐)</option>   
							    <option>上班(不含早餐)</option>   
							    <option>普通列车(含早餐)</option> 
							    <option>普通列车(不含早餐)</option>  
							    <option>动车高铁(含早餐)</option>  
							    <option>动车高铁(不含早餐)</option> 
							</select>
						</td>
					</tr>
					<tr style="height: 32px;">
						<td style="width: 60px;text-align: right;">
							下午：
						</td>
						<td>
							开始时间：<input id="startTime2" name="startTime2" class="easyui-timespinner" style="width: 80px;" data-options="showSeconds:true">
						</td>
						<td>
							结束时间：<input id="endTime2" name="endTime2" class="easyui-timespinner" style="width: 80px;" data-options="showSeconds:true">
						</td>
						<td>
							晚餐：<input id="dinner" name="dinner" class="easyui-textbox" style="width: 50px;" readonly="readonly">
						</td>
						<td>
							<select id="dinnerType" class="easyui-combobox" name="dinnerType" style="width:130px;" data-options="editable:false">   
								    <option>无</option>   
								    <option>上班</option>   
								    <option>普通列车</option>   
								    <option>动车高铁</option>   
							</select>
						</td>
					</tr>
					<tr style="height: 32px;">
						<td style="width: 60px;text-align: right;">
							晚上：
						</td>
						<td>
							开始时间：<input id="startTime3" name="startTime3" class="easyui-timespinner" style="width: 80px;" data-options="showSeconds:true">
						</td>
						<td>
							结束时间：<input id="endTime3" name="endTime3" class="easyui-timespinner" style="width: 80px;" data-options="showSeconds:true">
						</td>
						<td>
							夜宵：<input id="midnightSnack" name="midnightSnack" class="easyui-numberbox" style="width: 50px" readonly="readonly">
						</td>
					</tr>
				</table>
				<table cellspacing="0" align="center" width="720px" cellpadding="1" style="table-layout: fixed;margin-top: 10px;">
					<tr>
						<td valign="top" colspan="2">
							<div id="traffic" style="text-align: left;width: 720px;float: left;">
								<div style="width: 100%;height: 30px;text-align: center;">
									<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="trafficAdd();"></a>
									<label>交通费用</label>
									<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="trafficRemove();"></a>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<div id="other" style="text-align: left;width: 360px;float: left;">
								<div style="width: 100%;height: 30px;text-align: center;">
									<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="otherAdd();"></a>
									<label>其他费用</label>
									<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="otherRemove();"></a>
								</div>
							</div>
						</td>
						<td valign="top">
							<div id="subsidies" style="text-align: left;width: 360px;float: left;">
								<div style="width: 100%;height: 30px;text-align: center;">
									<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="subsidiesAdd();"></a>
									<label>津贴补贴</label>
									<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="subsidiesRemove();"></a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="gridToolBar2" style="padding:5px;height:auto;">
		<form id="queryForm2">
			工号：<input id="workNo_query2" type="text" class="easyui-textbox" name="workNo" style="width: 50px" >
			姓名：<input id="username_query2" type="text" class="easyui-textbox" name="username" style="width: 50px" >
			分组：<input id="groupsId_query2" class="easyui-combobox clearButton" name="groupsId" style="width: 100px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2();">查询</a>
		</form>
	</div>
	<!-- dialog上面dialog的按钮 -->
  	<div id="bb1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="save()">保存</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
	</div>
	
	
	
	<div id="dialog2" class="easyui-dialog" style="width: 300px;height: 150px;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb2'">
  		<div style="line-height: 70px;">
  			<form id="form3" method="post">
  				申请人：<input id="applicant" type="text" name="applicant" style="width: 92px" data-options="required:true,missingMessage:'申请人不能为空'">
  			</form>
  		</div>
  	</div>
  	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb2" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="generate()">生成</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
	</div>
	
	<div id="gridToolBar3" style="padding:5px;height:auto;">
		<form id="queryForm3">
			工号：<input id="workNo_query3" type="text" class="easyui-textbox" name="workNo" style="width: 50px" >
			姓名：<input id="username_query3" type="text" class="easyui-textbox" name="username" style="width: 50px" >
			分组：<input id="groupsId_query3" class="easyui-combobox clearButton" name="groupsId" style="width: 100px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query3();">查询</a>
		</form>
	</div>
	
	
	<div id="dialog3" class="easyui-dialog" style="width: 300px;height: 200px;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#bb3'">
  		<div style="padding-top: 10px;">
  			<form id="form4" method="post" action="" target="_BLANK">
  				开始时间：<input type="text" name="startTime" style="width: 92px" class="easyui-datebox" data-options="editable:false">
  				<br/>
  				<br/>
  				结束时间：<input type="text" name="endTime" style="width: 92px" class="easyui-datebox" data-options="editable:false">
  				<br/>
  				<br/>
  				按 分 组：<input id="groupsId" name="groupsId" style="width: 92px" class="easyui-combobox clearButton">
  			</form>
  		</div>
  	</div>
  	<!-- dialog上面dialog的按钮 -->
  	<div id="bb3" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="exportExcelForWorkHour()">导出工时</a>
		&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="exportExcelForMealsNumber()">导出餐次</a>
		&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog3')">关闭</a>
	</div>
  </body>
</html>

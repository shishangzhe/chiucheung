/**
 * 检测时间，例如按上下键选择
 * 绑定事件的方法：$("#dg1").datagrid({}).datagrid("keyCtr");
 */
$.extend($.fn.datagrid.methods, {
    keyCtr : function (jq) {
        return jq.each(function () {
            var grid = $(this);
            grid.datagrid('getPanel').panel('panel').attr('tabindex', 1).bind('keydown', function (e) {
                switch (e.keyCode) {
                case 38: // up
                    var selected = grid.datagrid('getSelected');//获取选择的列
               	 	var rows = grid.datagrid('getRows');
                    if (selected) {//如何有选择
                        var index = grid.datagrid('getRowIndex', selected);//获取当前选择行的索引号
                        if (index>0){
                        	grid.datagrid('selectRow', index - 1);
                        }else{
                        	grid.datagrid('selectRow', rows.length - 1);
                        }
                    } else {//如果当前选择的是最后一个，则选择最后一行
                        grid.datagrid('selectRow', rows.length - 1);
                    }
                    break;
                case 40: // down
                    var selected = grid.datagrid('getSelected');//获取选择的列
                	var rows = grid.datagrid('getRows');//获取总行数
                    if (selected) {//如何有选择
                        var index = grid.datagrid('getRowIndex', selected);//获取当前选择行的索引号
                        if (index<rows.length-1){//如果当前选择的不是最后一个
                        	grid.datagrid('selectRow', index + 1);
                        }else {//如果当前选择的是最后一个，则选择第一行
                            grid.datagrid('selectRow', 0);
                        }
                    } else {//如果当前选择的是最后一个，则选择第一行
                        grid.datagrid('selectRow', 0);
                    }
                    break;
                /*case 16:  //shift
                	var selections = grid.datagrid('getSelections');
                	grid.datagrid('options').singleSelect = false;
                	
                	if (selections.length>1){
                		var first = grid.datagrid('getRowIndex', selections[0]);
                		var last = grid.datagrid('getRowIndex', selections[selections.length-1]);
                		if (first > last){
                			var temp = first;
                			first = last;
                			last = temp;
                		}
                		for (var i=first;i<=last;i++){
                			grid.datagrid('selectRow', i);
                		}
                		var minIndex = 0;
                		var maxIndex = 0;
                		for(var i=0;i<selections.length;i++){
                			if (minIndex >grid.datagrid('getRowIndex', selections[i])){
                				minIndex = grid.datagrid('getRowIndex', selections[i]);
                			}
                		}
                		for(var i=0;i<selections.length;i++){
                			if (maxIndex <grid.datagrid('getRowIndex', selections[i])){
                				maxIndex = grid.datagrid('getRowIndex', selections[i]);
                			}
                		}
                		for (var i = minIndex;i<=maxIndex;i++){
                			grid.datagrid('selectRow', i);
                		}
                	}
            		break;*/
            	case 17: //ctrl
            		grid.datagrid('options').singleSelect = false;			
            		break;
                }
            });
            grid.datagrid('getPanel').panel('panel').attr('tabindex', 1).bind('keyup', function (e) {
            	switch (e.keyCode) {
            	/*case 16:  //shift
                	grid.datagrid('options').singleSelect = true;	
            		break;*/
            	case 17: //ctrl
            		grid.datagrid('options').singleSelect = true;			
            		break;
            	}
            });
        });
    }
});



//将表单序列化成json字符串
$.fn.serializeObject = function()    {    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
};



//为datebox添加清空按钮，并实现按钮的事件
/**
 需要在页面加入：
 $(function (){
		$('.easyui-datebox').datebox({
			buttons: buttons
		});
  });
 */
var buttons = $.extend([], $.fn.datebox.defaults.buttons);
buttons.splice(1, 0, {
	text: '清空',
	handler: function(target){
		$(target).datebox('clear');
		$(target).datebox('hidePanel');
	}
});
//为combobox添加清空按钮，并实现按钮事件
/**
需要在页面加入：(.clearButton添加了这个class样式的)
*/
var icons = $.extend([{

    iconCls:'icon-clear',
    handler:function(e){
        //alert($(e.handleObj.data.target).combobox('getValue'));
        $(e.handleObj.data.target).combobox('clear');
    }
}], $.fn.combobox.defaults.icons);

//扩展datagrid:动态添加删除editor
//使用方法
/**
 * 去除一个$('#datagrid').datagrid('removeEditor','id');
 * 去除多个$('#datagrid').datagrid('removeEditor',['id','name']);
 * 添加一个$('#datagrid').datagrid('addEditor',{
							field:'id',
							editor:{
								type:'validatebox',
								options:{
									required:true
									}	
							} 
						});
	添加多个$('#datagrid').datagrid('addEditor',[{
							field:'id',
							editor:{
								type:'validatebox',
								options:{
									required:true
									}	
							} 
						},{
							field:'name',
							editor:{
								type:'validatebox',
								options:{
									required:true
									}	
							} 
						}]);


 */
$.extend($.fn.datagrid.methods, {
	addEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item.field);
				e.editor = item.editor;
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param.field);
			e.editor = param.editor;
		}
	},
	removeEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item);
				e.editor = {};
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param);
			e.editor = {};
		}
	}
});

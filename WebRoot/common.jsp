<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.5/themes/ui-cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.5/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.5/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script> --%>


<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/ui-cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script> --%>


<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/ui-cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script> --%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/customIcons/icon.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.4.5/themes/ui-cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-dnd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/treegrid-dnd.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/extendsEasyUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myplugin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myValidate.js"></script>

<style>
	.panel-title{
		text-align: center;
		font-size: 14px;
	}
	div .btn-separator {  
		float: left;  
		height: 24px;  
		border-left: 1px solid LightGrey;  
		border-right: 0px solid LightGrey;  
		margin: 1px 1px;
	}
	/* combobox添加清空按钮的样式 */
	.icon-clear {
		width :16px !important;
		line-height: 23px;
	}
	/* 日期控件右边的按钮图标变小 */
  	.combo-arrow{
  		width: 20px !important;
  		height: 20px !important;
  		padding-top: 4px;
  	}
</style>
<script type="text/javascript">
//用于ajax的拦截未登录
	$.ajaxSetup({   
		contentType:"application/x-www-form-urlencoded;charset=utf-8",   
		complete:function(XMLHttpRequest,textStatus){ 
			var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
			if(sessionstatus=="timeout"){ 
				//如果超时就处理 ，指定要跳转的页面  
				window.location.replace("${pageContext.request.contextPath}/logintimeout.jsp");   
			}   
     	}
	});
	
	//屏蔽浏览器的回退
	history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });
    
    //屏蔽浏览器的F7功能
    document.addEventListener("keypress", function(event){
  	    if(event.keyCode == 118){
  	        event.preventDefault();
  	    }
  	}, true);
	
	$(function (){
		$(document).ajaxError(
			function(event, XMLHttpRequest, ajaxOptions, thrownError){
				if (thrownError == 'abort'){//上传取消
					return;
				}
				if(XMLHttpRequest.status == 'undefined'){
					return;
				}
				switch(XMLHttpRequest.status){
					case 403:
						// 未授权异常
						showMessager("错误",'<font color="red">您没有权限访问！<font/>');
						break;
						
					case 404:
						// 未找到资源
						showMessager("错误",'<font color="red">您访问的资源不存在！<font/>');
						break;
						
					case 408:
						// 请求超时
						showMessager("错误",'<font color="red">请求超时！<font/>');
						break;
						
					case 500:
						// 服务器内部错误
						showMessager("错误",'<font color="red">服务器内部错误！<font/>');
						break;
						
					case 0:
						// 服务器内部错误
						showMessager("错误",'<font color="red">无法连接服务器！<font/>');
						break;
						
					default:
						// 服务器内部错误
						showMessager("错误",'<font color="red">' + XMLHttpRequest.status + '错误！<font/>');
						break;
				}
			}
		);
	});
  
  
  $(function (){
		//为所有的datebox添加清空按钮
		$('.easyui-datebox').not('.noClearButton').datebox({
			buttons: buttons
		});
		//为所有的datebox的文本框宽度扩大，否者1.5.5.4版本右边的按钮，占用太多，同时配合上面的css（.combo-arrow）
		$(".easyui-datebox").each(function(){
			$(this).next().children('input').first().css('width',$(this).next().width()-22);
		});
  });
  //为所有clearButton样式的combobox添加清空按钮
  $(function (){
		$('.clearButton').combobox({
			icons: icons,
			onBeforeLoad: function(){
				$(this).next().children('input').first().css('width',$(this).next().width()-42);//新版本的easyui，需要这样设置，还有上面的css -> .icon-clear
			}
		});
  });
  
//针对Ease UI 火狐浏览器 输入中文取不到值的问题修复
  function fnComFixedChineseInput(event) {
      $(event.target || event.srcElement).keydown();
  }
  
  //combobox允许输入，并且开启filter，根据下拉选项自动完成选择
  function editableComboboxAutoCompleteSelect(obj){
	  var thisCombobox = $(obj).parent().prev();
		var _options = thisCombobox.combobox('options');
		var _data = thisCombobox.combobox('getData');/* 下拉框所有选项 */
		var _value = $(obj).val();
		var _b = false;/* 标识是否在下拉列表中找到了用户输入的字符 */
		if(_options.multiple){//多选
			var _values = _value.split(',');
			var values = "";
			var texts = "";
			for (var i = 0; i < _data.length; i++) {
				for (var j = 0; j < _values.length; j++){
					if (_data[i][_options.textField] == _values[j]) {
		            	values = values + "," + _data[i][_options.valueField];
		            	texts = texts + "," + _data[i][_options.textField];
						break;
		        	}
				}
			}
			if (values != ""){
				_b = true;
				thisCombobox.combobox('setText', "");
				thisCombobox.combobox('setValues', values.substring(1,values.length).split(","));
			}
		}else{
  			for (var i = 0; i < _data.length; i++) {
	        	if (_data[i][_options.textField] == _value) {
	            	_b=true;
	            	thisCombobox.combobox('setValue', _data[i][_options.valueField]);
					break;
	        	}
			}
		}
		if(!_b){
			$(obj).val("");
			thisCombobox.combobox('setValue', '');
			thisCombobox.combobox('validate');//清空值之后，需要手动调用一次校验，开启校验的时候需要这一步
		}
  }
  
  
//弹出加载层
  function load(msg) {  
      $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: $(window).height() }).appendTo("body");  
      $("<div class=\"datagrid-mask-msg\"></div>").html(msg).appendTo("body").css({ display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2 });  
  }
  //取消加载层  
  function disLoad() {  
      $(".datagrid-mask").remove();  
      $(".datagrid-mask-msg").remove();  
  }

//关闭面板(弹出框)的通用方法
function closeDialog(id){
    $("#"+id).dialog({closed:true});
};

//jQuery序列化form表单方法
$.prototype.serializeObject = function() {
    var a, o, h, i, e; a = this.serializeArray(); o = {};
    h = o.hasOwnProperty;
    for (i = 0; i < a.length; i++) {
        e = a[i];
        if (!h.call(o, e.name)) {
            o[e.name] = e.value;
        }
    }
    return o;
};
</script>
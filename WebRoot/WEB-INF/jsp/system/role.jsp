<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>角色权限管理</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
	$(function (){
		$('#cc').combobox({    
		    url:"${pageContext.request.contextPath}/system/role/findAllRole.action",//加载数据的url    
		    valueField:'id',//相当于select的key
		    textField:'roleName',//相当于select的value
		    editable:false,//不允许编辑
		    onChange:function (newValue,oldValue){//选择一行时，根据选择的行给下面的表格加载数据
		    	$("#roleId").val(newValue);//把当前选中的id赋给隐藏的input，用于保存角色权限的时候，带上角色的id
		    	$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/system/role/findSysRoleMenujztreeCustomByRoleId.action",//ajax请求的url
					data: {roleId:newValue},//传的参数
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				    	$("#save").css("display","");//显示保存按钮
						$("input[type='checkbox']").attr("checked",false);//先将所有的checkbox取消选中
						for(var i=0;i<data.length;i++){
							//利用js，jquery不行
							if ($("#"+data[i].selectoper).length > 0){
								$("#"+data[i].selectoper)[0].checked = true;//然后取出来的数据选中该选中的
							}
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){//请求失败后的回调函数。
						$('#cc').combobox("unselect",newValue);//取消选中的值
						$("#save").css("display","none");//显示保存按钮
						$("input[type='checkbox']").attr("checked",false);//先将所有的checkbox取消选中
					}
				});
		    }
		});
	});
	
	//新增一个角色
	function addRole(){
		if ($('#form1').form('validate')){//校验通过才进行下面操作（非空校验和类型是否存在校验）
			$.ajax({
				type:'POST',//post请求
				url: "${pageContext.request.contextPath}/system/role/saveSysRole.action",//ajax请求的url
				data: $("#form1").serialize(),//传的参数
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data == '保存成功'){
						showMessager("提示",data);
						$("#cc").combobox('reload');//重新加载
						$("#roleName").textbox('setText','');
					}else{
						showMessager("错误",data);
					}
				}
			});
		}
	}
	
	//保存角色和对应的权限
	function saveRoleMenujztree(){
		$.ajax({
			type:'POST',//post请求
			url: "${pageContext.request.contextPath}/system/role/saveSysRoleMenujztree.action",//ajax请求的url
			data: $("#form2").serialize(),//传的参数
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data == '保存成功'){
					showMessager("提示",data);
				}else{
					showMessager("错误",data);
				}
			}
		});
	}
	
	//选中复选框，触发事件
	function goSelect(id){
		//按照_符号分隔
		var array = id.split("_");
		if(array[0] == 0){//此时说明操作的菜单的（父）节点
			//选中父
			if($("#"+id)[0].checked){
				//子都选中
				//$("input[type='checkbox'][name='selectoper'][id^='"+array[1]+"']").attr("checked",true);
				$("input[type='checkbox'][name='selectoper'][id^='"+array[1]+"']").each(function(index,domEle){
					domEle.checked = true;
				});
			}
			//取消父
			else{
				//子都取消
				//$("input[type='checkbox'][name='selectoper'][id^='"+array[1]+"']").attr("checked",false);
				$("input[type='checkbox'][name='selectoper'][id^='"+array[1]+"']").each(function(index,domEle){
					domEle.checked = false;
				});
			}
		}
		else{//说明此时操作的子设置中的一个(子)
			//当选中子设置中的一个，则父一定被选中
			if($("#"+id)[0].checked){
				//$("input[type='checkbox'][name='selectoper'][id^='"+0+"'][id$='"+array[0]+"']").attr("checked",true);
				$("input[type='checkbox'][name='selectoper'][id^='"+0+"'][id$='"+array[0]+"']")[0].checked = true;
			}
			//当取消子设置中的一个
			else{
				//先查找子设置的对象
				var $check = $("input[type='checkbox'][name='selectoper'][id^='"+array[0]+"']:not([id$='"+array[0]+"'])");
				//遍历子设置的对象
				/**
				 * flag:用于判断当前子设置的对象是否有被选中
				 *   * flag=false，子对象都没有被选中，此时父要被取消
				 *   * flag=true，子对象中至少有一个被选中，此时不做任何操作
				 */
				var flag = false;
				$check.each(function(index,domEle){
					if(domEle.checked){
						flag = true;
						return false;
					}
				})
				if(!flag){
					//$("input[type='checkbox'][name='selectoper'][id^='"+0+"'][id$='"+array[0]+"']").attr("checked",false);
					$("input[type='checkbox'][name='selectoper'][id^='"+0+"'][id$='"+array[0]+"']")[0].checked = false;
				}
			}
		}
	}
	
	//功能权限分配的行全选和取消全选
	function checkAll(obj){
		//获得父节点的下一个节点的下一个节点的子节点的 type:checkbox name:selectoper的input子节点
		$(obj).parent().next().next().children().children("input[type='checkbox'][name='selectoper']").each(function(index,domEle){
			domEle.checked = $(obj)[0].checked;
		});
	}
  </script>
<body>   
	<div style="text-align: center;">
		<form id="form1">
			<div style="padding-top: 10px">
	 			 角色类型：<input id="cc" style="width: 120px">
	 			<p:isPrivilege pid="be" mid="bea">
					<a href="#" class="easyui-linkbutton" onClick="addRole()">新增角色</a>
					<input id="roleName" class="easyui-textbox" name="roleName" data-options="required:true,missingMessage:'角色不能为空',validType:'roleIsRepeat'">
				</p:isPrivilege>
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</form>
		
	</div> 
	<form id="form2">
		<fieldset style="width:98%; border : 1px solid #73C8F9;text-align:left;COLOR:#023726;FONT-SIZE: 12px;"><legend align="left">菜单权限分配</legend>
			 <table cellspacing="0" align="center" width="90%" cellpadding="1" rules="all" bordercolor="gray" border="1">
			 	<th style="line-height: 25px;text-align: center;width: 20%">主菜单</th>
			 	<th style="line-height: 25px;text-align: center;">子菜单</th>
				<c:forEach items="${rootMenus}" var="rootMenu">
					<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
						<td>
							<div style="float:left;text-align:left;line-height:25px;">
								<input type="checkbox"  name="selectoper" id="${rootMenu.pid}_${rootMenu.mid}" value="${rootMenu.pid}_${rootMenu.mid}" onClick='goSelect(this.id)' >
								${rootMenu.name}
							</div>
						</td>
						<td>
							<c:forEach items="${rootMenu.menujztreeCustoms}" var="childrenMenu" >
								<div style="float:left;width:24%;text-align:left;line-height:25px;">
									<input type="checkbox"  name="selectoper" id="${childrenMenu.pid}_${childrenMenu.mid}" value="${childrenMenu.pid}_${childrenMenu.mid}" onClick='goSelect(this.id)' >
									${childrenMenu.name}
								</div>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		<br>
		<fieldset style="width:98%; border : 1px solid #73C8F9;text-align:left;COLOR:#023726;FONT-SIZE: 12px;"><legend align="left">功能权限分配</legend>
			 <table cellspacing="0" align="center" width="90%" cellpadding="1" rules="all" bordercolor="gray" border="1">
			 	<th style="line-height: 25px;text-align: center;width: 2%"> </th>
			 	<th style="line-height: 25px;text-align: center;width: 18%">子菜单</th>
			 	<th style="line-height: 25px;text-align: center;">功能权限</th>
				<c:forEach items="${bottonMenus}" var="childrenMenu">
					<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
						<td style="text-align: center;">
							<input type="checkbox" onclick="checkAll(this)">
						</td>
						<td>
							<div style="float:left;text-align:left;line-height:25px;">
								${childrenMenu.name}
							</div>
						</td>
						<td>
							<c:forEach items="${childrenMenu.menujztreeCustoms}" var="buttonMenu" >
								<div style="float:left;width:24%;text-align:left;line-height:25px;">
									<input type="checkbox"  name="selectoper" id="${buttonMenu.pid}_${buttonMenu.mid}" value="${buttonMenu.pid}_${buttonMenu.mid}" >
									${buttonMenu.name}
								</div>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		<input id="roleId" type="hidden" name="roleId" >
		<div style="text-align: center;padding-top: 10px">
			<p:isPrivilege pid="be" mid="beb">
				<a href="#" id="save" class="easyui-linkbutton" style="width: 80px;display: none;" onClick="saveRoleMenujztree()">保    存</a>
			</p:isPrivilege>
		</div>
	</form>
</body>
</html>

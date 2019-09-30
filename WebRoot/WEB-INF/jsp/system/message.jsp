<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    <title>即时消息</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  
  <script type="text/javascript">
  
  	$(function(){
  		if ($("#goPage").length >0){
	  		$("#goPage").textbox('textbox').bind('keydown', function(e){
	  			if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
	  				gotopage('showAllMessage.action','go');
	  			}
	  		});
  		}
  		
  		$("#keyword").textbox('textbox').bind('keydown', function(e){
  			if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
  				gotopage3('showAllMessage.action',1);
  			}
  		});
  	});
  
	//分页的js
  	function gotopage(action, flag){
		var pageNO;
		if (flag == 'start'){
			pageNO = "1";
		}
		
		if (flag == 'prev'){
			pageNO = $("#prevpageNO").val();
		}
		
		if (flag == 'next'){
			pageNO = $("#nextpageNO").val();
		}
		
		if (flag == 'end'){
			pageNO = $("#sumPage").val();
		}
		
		if (flag == 'go'){
			pageNO = $("#goPage").textbox('getValue');
			if (pageNO.replace(/(^\s*)|(\s*$)/g,'') == "") {
				alert("请输入页数"); 
			    return;
			}
			if (!(/^\d*$/.test(pageNO))){
				alert("请输入正确页数(数字)");
				return;
			}
			if (pageNO.indexOf(".") != -1){
				alert("请输入整数");
				return;
			}
			if (pageNO<=0 || pageNO>($("#sumPage").val()*1)){
				alert("请输入正确的页数");
				return;
			}
		}
		//action+"?pageNO="+pageNO是为了加了第几页的参数，
		var keyword = $("#keyword_hidden").val();
		window.location.href = action+"?pageNo="+pageNO+"&keyword="+keyword;
		/* $.post(action+"?pageNo="+pageNO,{keyword:keyword},function(data){
			 //$("#Form2 div").remove();
			 $("#Form2").html(data);
		}); */
	}
	
  	function gotopage2(action, pageNo){//点击页数用的
  		var keyword = $("#keyword_hidden").val();
		window.location.href = action+"?pageNo="+pageNo+"&keyword="+keyword;
  	}
  	
  	function gotopage3(action, pageNo){//点击搜索用的
  		var keyword = $("#keyword").val();
		//window.location.href = action+"?pageNo="+pageNo+"&keyword="+keyword;
		$("#subForm").submit();
  	}
	
	
	function mousemove(obj){
		//$(obj).css("background-color","#34b4e3");
		$(obj).css("border-color","#3388ff");
	}
	
	function mouseout(obj){
		//$(obj).css("background-color","#e1e1e1");
		$(obj).css("border-color","#e1e2e3");
	}
  </script>
<body>   
	<div style="height: 30px"></div>
	<form id="subForm" action="showAllMessage.action?pageNo=1" method="post">
	搜索：<input id="keyword" name="keyword" type="text" class="easyui-textbox" value="${keyword}">
	<input id="keyword_hidden" name="keyword_hidden" type="hidden" value="${keyword}">
	<a href="#" class="easyui-linkbutton" iconCls="icon-search"  onClick="gotopage3('showAllMessage.action',1)">搜索</a>
	</form>
	
	<div style="height: 30px"></div>
	<c:if test="${list!=null && fn:length(list)>0}">
		<c:forEach items="${list}" var="message">
			<!-- 当前用户是接受者 -->
			<c:if test="${fn:contains(message.receiver, user.loginName)}">
				<div style="background-color: #d7ebf9;width: 360px;height: 93px;float: left;">
					<div style="padding: 5px 5px 5px 5px">来自：${message.sender} - <fmt:formatDate value="${message.sendTime}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
					<br>
					<div style="padding: 5px 5px 5px 5px">${message.message}</div>
				</div>
				<div style="height: 105px"></div>
			</c:if>
			<!-- 当前用户是发送者 -->
			<c:if test="${fn:contains(message.sender, user.loginName)}">
				<div  class="right" style="background-color: #e1effc;width: 360px;height: 93px;float: right;">
					<div style="padding: 5px 5px 5px 5px">发给：${message.receiver} - <fmt:formatDate value="${message.sendTime}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
					<br>
					<div style="padding: 5px 5px 5px 5px">${message.message}</div>
				</div>
				<div style="height: 105px"></div>
			</c:if>
			
		</c:forEach>
	</c:if>
	
	
	
	
	
	<div style="height: 50px"></div>
	<div style="float: left;width: 50px;height: 30px;"></div>
	<div>
       <c:if test="${page!=null}">
	       <c:if test="${page.sumPage > 1}"><!-- 总页数大于1才显示，只有一页时，无需显示分页 -->
		       	<c:if test="${page.firstPage}">
		       		<div style="float: left;border: 1px solid #e1e2e3;"><input type='button' value='首页' disabled="disabled" style='border-width:0px;height:30px;'></div>
		       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px;"><input type='button' value='上一页' disabled="disabled" style='border-width:0px;height:30px;'></div>
		       	</c:if>
		       	<c:if test="${!page.firstPage}">
		       		<div style="float: left;border: 1px solid #e1e2e3;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='首页' onclick="gotopage('showAllMessage.action','start')" style='border-width:0px;height:30px;color: #1683e2'></div>
		       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='上一页' onclick="gotopage('showAllMessage.action','prev')" style='border-width:0px;height:30px;color: #1683e2'></div>
		       	</c:if>
		       	<c:forEach begin="1" end="${page.sumPage}" var="index">
		       		<c:if test="${page.sumPage <= 10}"><!-- 当前的页数小于等于10页时，无论当前第几页，都是显示1-10页 -->
			       		<c:if test="${index == page.pageNo}">
			       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;"><input type='button' value='${index}' disabled="disabled" style='border-width:0px;height:30px;'></div>
			       		</c:if>
			       		<c:if test="${!(index == page.pageNo)}">
			       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='${index}' onclick="gotopage2('showAllMessage.action',${index})" style='border-width:0px;height:30px;color: #1683e2'></div>
			       		</c:if>
		       		</c:if>
		       		<c:if test="${page.sumPage > 10}"><!-- 当前的页数大于于10页时 -->
		       			<c:if test="${page.pageNo > 5}"><!-- 当前页码大于5页时 -->
		       				<c:if test="${(page.pageNo+5) <= page.sumPage}"><!-- 表示当前页码+5后，仍然小于等于总页数，可以按照页码前面显示5个，后面显示4个来显示 -->
			       				<c:if test="${(index > (page.pageNo-5)) && (index <= (page.pageNo+5))}">
			       					<c:if test="${index == page.pageNo}">
						       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;"><input type='button' value='${index}' disabled="disabled" style='border-width:0px;height:30px;'></div>
						       		</c:if>
						       		<c:if test="${!(index == page.pageNo)}">
						       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='${index}' onclick="gotopage2('showAllMessage.action',${index})" style='border-width:0px;height:30px;color: #1683e2'></div>
						       		</c:if>
			       				</c:if>
		       				</c:if>
		       				<c:if test="${(page.pageNo+5) > page.sumPage}"><!-- 表示当前页码+5后，大于总页数，不可以按照页码前面显示5个，后面显示4个来显示 ，则从最大页面减9开始显示-->
		       					<c:if test="${index > (page.sumPage-10)}">
		       						<c:if test="${index == page.pageNo}">
						       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;"><input type='button' value='${index}' disabled="disabled" style='border-width:0px;height:30px;'></div>
						       		</c:if>
						       		<c:if test="${!(index == page.pageNo)}">
						       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='${index}' onclick="gotopage2('showAllMessage.action',${index})" style='border-width:0px;height:30px;color: #1683e2'></div>
						       		</c:if>
		       					</c:if>
		       				</c:if>
		       			</c:if>
		       			<c:if test="${page.pageNo <= 5}"><!-- 当前的页码小于等于5页-->
		       				<c:if test="${index <= 10}"><!-- 值显示1-10页 -->
			       				<c:if test="${index == page.pageNo}">
					       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;"><input type='button' value='${index}' disabled="disabled" style='border-width:0px;height:30px;'></div>
					       		</c:if>
					       		<c:if test="${!(index == page.pageNo)}">
					       			<div style="width: 30px;float: left;border: 1px solid #e1e2e3;margin-left: 5px;text-align: center;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='${index}' onclick="gotopage2('showAllMessage.action',${index})" style='border-width:0px;height:30px;color: #1683e2'></div>
					       		</c:if>
				       		</c:if>
		       			</c:if>
		       		</c:if>
		       	</c:forEach>
		       	<c:if test="${page.lastPage}">
		       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px;"><input type='button' value='下一页' disabled="disabled" style='border-width:0px;height:30px;'></div>
		       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px;"><input type='button' value='末页' disabled="disabled" style='border-width:0px;height:30px;'></div>
		       	</c:if>
		       	<c:if test="${!page.lastPage}">
		       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='下一页' onclick="gotopage('showAllMessage.action','next')" style='border-width:0px;height:30px;color: #1683e2'></div>
		       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='末页' onclick="gotopage('showAllMessage.action','end')" style='border-width:0px;height:30px;color: #1683e2'></div>
		       	</c:if>
	       	
		       	<div style="color: gray;">
		       		<div style="line-height: 30px;font-size: 12px;float: left;">
			   			<%-- 总记录数：<c:out value="${page.totalResult}"/>条 --%>
				       	共<c:out value="${page.sumPage}"/>页
				       	至第<input size="1" type="text" class="easyui-textbox" id="goPage" name="goPage">页
			       	</div>
			       	<div style="float: left;margin-top: 5px;">
			       		<div style="float: left;border: 1px solid #e1e2e3;margin-left: 5px; text-align: center;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' ><input type='button' value='确定' onclick="gotopage('showAllMessage.action','go')" style='border-width:0px;font-size: 12px;height: 20px'></div>
			     	</div>
		       	</div>
	       </c:if>
       </c:if>
     </div>
     <div style="height: 50px"></div>
     <div style="height: 50px"></div>
       	
       	
       	<input type="hidden" id="pageNO" name="pageNO" value="${page.pageNo }" >
	    <input type="hidden" id="prevpageNO" name="prevpageNO" value="${page.pageNo-1 }">
	    <input type="hidden" id="nextpageNO" name="nextpageNO" value="${page.pageNo+1 }">
	    <input type="hidden" id="sumPage" name="sumPage" value="${page.sumPage }" >
</body>    
</html>

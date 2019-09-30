<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    <title>mapInfo.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/viewer/js/viewer.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/viewer/css/viewer.css">
	<style type="text/css">
		.projectInfoCustom{
			font-size: 14px;
			margin-left: 10px;
			margin-top:10px;
			margin-bottom: 5px;
			position:relative;
		}
		.projectInfoCustom span{
			font-size: 10px;
			margin-left: 10px;
			color: rgb(100,100,100)
		}
		#projectInfoContent ul{
	    	margin:0;
	    	padding:0;
	    	margin-left:9px;
	    }
	    #projectInfoContent li {
	    	list-style:none;
	    	/* float: left; */
	    	display:inline;
			/* width: 24%; */
			/* margin: 0 -1px -1px 0; */
			margin-left: 3px;
			border: 1px solid transparent;
			overflow: hidden;
		}
		#projectInfoContent img {
	    	height:80px;
	    	cursor: pointer;
	    	/* margin-bottom: -5px; */ /* 如何设置了，图片两行时，会有一点点重叠 */
		}
		.imgButton {
			height: 16px !important;
			position:absolute;
			margin-left: 10px;
		}
		
		/*关闭图标*/
		.close {
		    position: absolute;
		    right: 0px;
		    top: 0px;
		    width: 40px;
		    height: 30px;
		}
		
		.close:hover {
		    background: red;
		}
		
		.close:before {
		    position: absolute;
		    content: '';
		    width: 18px;
		    height: 1px;
		    background: rgb(155,155,155);
		    transform: rotate(45deg);
		    top: 15px;
		    left: 12px;
		}
		.close:after {
		    content: '';
		    position: absolute;
		    width: 18px;
		    height: 1px;
		    background: rgb(155,155,155);
		    transform: rotate(-45deg);
		    top: 15px;
		    left: 12px;
		}
		.close:hover:before {
		    position: absolute;
		    content: '';
		    width: 18px;
		    height: 1px;
		    background: white;
		    transform: rotate(45deg);
		    top: 15px;
		    left: 12px;
		}
		.close:hover:after {
		    content: '';
		    position: absolute;
		    width: 18px;
		    height: 1px;
		    background: white;
		    transform: rotate(-45deg);
		    top: 15px;
		    left: 12px;
		}
		/* 行业分类 */
		.industry{
			margin-left: 5%;
			width: 14%;
			float: left;
			font-family: "Microsoft YaHei","Helvetica Neue",Helvetica,STHeiTi,arial,sans-serif;;
			font-size: 14px;
			text-align: center;
			line-height: 30px;
			cursor: pointer;
		}
		.link{
			border: 1px solid rgba(200,200,200,0.8);
			color: black;
		}
		.hover{
			border: 1px solid #122d3f;
			background-color: #122d3f;
			color: white;
		}
		
		
		/* 分页 */
		.pageNumber {
			float: left;
			width: 25px;
			line-height: 25px;
			border: 1px solid #e1e2e3;
			background-color: #ffffff;
			text-align: center;
			font-size: 10px;
			cursor: pointer;
		}
		.pageNumberDisabled {
			float: left;
			width: 25px;
			line-height: 25px;
			border: 1px solid #122d3f;
			background-color: #122d3f;
			color: white;
			text-align: center;
			font-size: 10px;
		}
		.pagePre,.pageNext{
			float: left;
			width: 50px;
			line-height: 25px;
			border: 1px solid #e1e2e3;
			color: black;
			font-size: 10px;
			text-align: center;
			cursor: pointer;
		}
		.pagePreDisabled,.pageNextDisabled{
			float: left;
			width: 50px;
			line-height: 25px;
			border: 1px solid #e1e2e3;
			color: gray;
			font-size: 10px;
			text-align: center;
		}
		.pageStart,.pageEnd{
			float: left;
			width: 40px;
			line-height: 25px;
			border: 1px solid #e1e2e3;
			color: black;
			font-size: 12px; 
			text-align: center;
			cursor: pointer;
			
		}
		.pageStart{
			margin-left: 10px;
		}
		.pageStartDisabled,.pageEndDisabled{
			float: left;
			width: 40px;
			line-height: 25px;
			border: 1px solid #e1e2e3;
			color: gray;
			font-size: 10px;
			text-align: center;
		}
		.pageStartDisabled{
			margin-left: 10px;
		}
		
		/*搜索*/
		.input-search{
			width: 140px;
			height: 30px;
			border: 0px;
			float: left;
			display: none;
			position: absolute;
			left: 0px;
			border-top: 1px solid;
			border-left: 1px solid;
			border-bottom: 1px solid;
			border-color: rgba(120,120,120,0.8);
		}
		.ex-search {
		    position: absolute;
		    width: 28px;
		    height: 28px;
		    margin-left: 0px;
		    background-color: white;
		    border-top: 1px solid;
			border-right: 1px solid;
			border-bottom: 1px solid;
			border-color: rgba(120,120,120,0.8);
		}
		.ex-search:before {
		    content: ' ';
		    position: absolute;
		    width: 16px;
		    height: 16px;
		    margin-top: 3px;
		    margin-left: 3px;
		    border: 1px solid #666;
		    border-radius: 15px;
		    box-shadow: inset 1px 1px 10px rgba(0,0,0,.3);
		}
		.ex-search::after {
		    content: ' ';
		    position: absolute;
		    width: 10px;
		    height: 3px;
		    background: #666;
		    border-radius: 5px 0 0 5px;
		    -webkit-transform: rotate(225deg);
		    -moz-transform: rotate(225deg);
		    -ms-transform: rotate(225deg);
		    -o-transform: rotate(225deg);
		    transform: rotate(225deg);
		}
		.ex-search:before {
		    top: 0;
		    left: 0;
		}
		.ex-search:after {
		    left: 17px;
		    bottom: 4px;
		}
	</style>
  </head>

  <body onload="pic()">
  	<div id="div" style="width: 100%;height: 100%">
	  	<div style='background-color: white;width: 30%;height: 70%;left: 35%;top:15%;position:absolute;'>
			<div style='width: 100%;height: 30px;line-height: 30px;text-align: center;background: #aa2d3e;'>
				<c:if test="${exception == null}">
					<input id="customSearch" name="custom" class="input-search" type="search" placeholder="search..." value="${projectInfoQueryVo.custom}">
					<div id="search" class="ex-search"></div>
					<span id='projectInfoTitle' style="color: white;">${title}</span>
				</c:if>
				<c:if test="${exception != null}">
					<span id='projectInfoTitle'>错误</span>
				</c:if>
				<div class='close' onclick='closeThis();'></div>
			</div>
			<div id='projectInfoContent' style='overflow:auto;'>
				<div style="min-width: 690px;">
					<c:if test="${exception != null}">
						${exception}
						<br>
						<br>
						<a href="javascript:closeThis();">页面发生错误，点我关闭</a>
					</c:if>
					<c:if test="${exception == null}">
						 <c:if test="${page!=null}">
							<div style="margin: auto;height: 85px; margin-top: 10px;">
								<div style="width: 100%;height: 38px;padding-top: 4px;">
									<c:if test="${projectInfoQueryVo.industry == '广电'}">
										<div class="industry hover">广电(<span style="font-size: 12px;">${industryCounts['广电'] == null ? 0 : industryCounts['广电']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '广电'}">
										<div class="industry link">广电(<span style="font-size: 12px;">${industryCounts['广电'] == null ? 0 : industryCounts['广电']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '机场'}">
										<div class="industry hover">机场(<span style="font-size: 12px;">${industryCounts['机场'] == null ? 0 : industryCounts['机场']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '机场'}">
										<div class="industry link">机场(<span style="font-size: 12px;">${industryCounts['机场'] == null ? 0 : industryCounts['机场']}</span>)</div>
									</c:if>
									
									<c:if test="${projectInfoQueryVo.industry == '安防'}">
										<div class="industry hover">安防(<span style="font-size: 12px;">${industryCounts['安防'] == null ? 0 : industryCounts['安防']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '安防'}">
										<div class="industry link">安防(<span style="font-size: 12px;">${industryCounts['安防'] == null ? 0 : industryCounts['安防']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '交通'}">
										<div class="industry hover">交通(<span style="font-size: 12px;">${industryCounts['交通'] == null ? 0 : industryCounts['交通']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '交通'}">
										<div class="industry link">交通(<span style="font-size: 12px;">${industryCounts['交通'] == null ? 0 : industryCounts['交通']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '赌场监控'}">
										<div class="industry hover">赌场监控(<span style="font-size: 12px;">${industryCounts['赌场监控'] == null ? 0 : industryCounts['赌场监控']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '赌场监控'}">
										<div class="industry link">赌场监控(<span style="font-size: 12px;">${industryCounts['赌场监控'] == null ? 0 : industryCounts['赌场监控']}</span>)</div>
									</c:if>
								</div>
								<div style="width: 100%;height: 38px;padding-top: 4px;">
									<c:if test="${projectInfoQueryVo.industry == '能源'}">
										<div class="industry hover">能源(<span style="font-size: 12px;">${industryCounts['能源'] == null ? 0 : industryCounts['能源']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '能源'}">
										<div class="industry link">能源(<span style="font-size: 12px;">${industryCounts['能源'] == null ? 0 : industryCounts['能源']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '部队'}">
										<div class="industry hover">部队(<span style="font-size: 12px;">${industryCounts['部队'] == null ? 0 : industryCounts['部队']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '部队'}">
										<div class="industry link">部队(<span style="font-size: 12px;">${industryCounts['部队'] == null ? 0 : industryCounts['部队']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '金融'}">
										<div class="industry hover">金融(<span style="font-size: 12px;">${industryCounts['金融'] == null ? 0 : industryCounts['金融']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '金融'}">
										<div class="industry link">金融(<span style="font-size: 12px;">${industryCounts['金融'] == null ? 0 : industryCounts['金融']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '电信'}">
										<div class="industry hover">电信(<span style="font-size: 12px;">${industryCounts['电信'] == null ? 0 : industryCounts['电信']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '电信'}">
										<div class="industry link">电信(<span style="font-size: 12px;">${industryCounts['电信'] == null ? 0 : industryCounts['电信']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry == '其他'}">
										<div class="industry hover">其他(<span style="font-size: 12px;">${industryCounts['其他'] == null ? 0 : industryCounts['其他']}</span>)</div>
									</c:if>
									<c:if test="${projectInfoQueryVo.industry != '其他'}">
										<div class="industry link">其他(<span style="font-size: 12px;">${industryCounts['其他'] == null ? 0 : industryCounts['其他']}</span>)</div>
									</c:if>
								</div>
							</div>
						</c:if>
						<c:if test="${list != null && fn:length(list) > 0}">
					  		<c:forEach items="${list}" var="projectInfo" varStatus="status">
							    <div class="projectInfoCustom">
							    	${projectInfo.custom}
							    	<span>${projectInfo.year}</span>
							    	<c:if test="${projectInfo.picIds != null && fn:length(projectInfo.picIds) > 0}">
							    	<%-- <button onclick="$('#picFirst${status.index}').click();">查看</button> --%>
						    		<img src="${pageContext.request.contextPath}/image/view.png" class="imgButton" onclick="$('#picFirst${status.index}').click();">
								    <ul id="pic${status.index}">
									    <c:forEach items="${projectInfo.picIds}" var="picId">
									    	<li style="display: none;">
									    		<img id="picFirst${status.index}"
										    		src="${pageContext.request.contextPath}/market/map/getPicIoById.action?id=${picId}&thumbnails=true" 
										    		data-original="${pageContext.request.contextPath}/market/map/getPicIoById.action?id=${picId}&thumbnails=false"
										    		alt="${projectInfo.custom}"
									    		>
									    	</li>
									   	</c:forEach>
								    </ul>
								</c:if>
							    </div>
						    </c:forEach>
						 </c:if>
					 
						 <div style="margin: auto;height: 50px; margin-top: 20px;">
					       <c:if test="${page!=null}">
						       <c:if test="${page.sumPage > 1}"><!-- 总页数大于1才显示，只有一页时，无需显示分页 -->
							       	<c:if test="${page.firstPage}">
							       		<div class="pageStartDisabled">首页</div>
							       		<div class="pagePreDisabled">上一页</div>
							       	</c:if>
							       	<c:if test="${!page.firstPage}">
							       		<div class="pageStart" onclick="gotopage('','start')">首页</div>
							       		<div class="pagePre" onclick="gotopage('','prev')">上一页</div>
							       	</c:if>
							       	<c:forEach begin="1" end="${page.sumPage}" var="index">
							       		<c:if test="${page.sumPage <= 10}"><!-- 当前的页数小于等于10页时，无论当前第几页，都是显示1-10页 -->
								       		<c:if test="${index == page.pageNo}">
								       			<div class="pageNumberDisabled">${index}</div>
								       		</c:if>
								       		<c:if test="${!(index == page.pageNo)}">
								       			<div class="pageNumber">${index}</div>
								       		</c:if>
							       		</c:if>
							       		<c:if test="${page.sumPage > 10}"><!-- 当前的页数大于于10页时 -->
							       			<c:if test="${page.pageNo > 5}"><!-- 当前页码大于5页时 -->
							       				<c:if test="${(page.pageNo+5) <= page.sumPage}"><!-- 表示当前页码+5后，仍然小于等于总页数，可以按照页码前面显示5个，后面显示4个来显示 -->
								       				<c:if test="${(index > (page.pageNo-5)) && (index <= (page.pageNo+5))}">
								       					<c:if test="${index == page.pageNo}">
											       			<div class="pageNumberDisabled">${index}</div>
											       		</c:if>
											       		<c:if test="${!(index == page.pageNo)}">
											       			<div class="pageNumber">${index}</div>
											       		</c:if>
								       				</c:if>
							       				</c:if>
							       				<c:if test="${(page.pageNo+5) > page.sumPage}"><!-- 表示当前页码+5后，大于总页数，不可以按照页码前面显示5个，后面显示4个来显示 ，则从最大页面减9开始显示-->
							       					<c:if test="${index > (page.sumPage-10)}">
							       						<c:if test="${index == page.pageNo}">
											       			<div class="pageNumberDisabled">${index}</div>
											       		</c:if>
											       		<c:if test="${!(index == page.pageNo)}">
											       			<div class="pageNumber">${index}</div>
											       		</c:if>
							       					</c:if>
							       				</c:if>
							       			</c:if>
							       			<c:if test="${page.pageNo <= 5}"><!-- 当前的页码小于等于5页-->
							       				<c:if test="${index <= 10}"><!-- 值显示1-10页 -->
								       				<c:if test="${index == page.pageNo}">
										       			<div class="pageNumberDisabled">${index}</div>
										       		</c:if>
										       		<c:if test="${!(index == page.pageNo)}">
										       			<div class="pageNumber">${index}</div>
										       		</c:if>
									       		</c:if>
							       			</c:if>
							       		</c:if>
							       	</c:forEach>
							       	<c:if test="${page.lastPage}">
							       		<div class="pageNextDisabled" >下一页</div>
							       		<div class="pageEndDisabled">末页</div>
							       	</c:if>
							       	<c:if test="${!page.lastPage}">
							       		<div class="pageNext" onclick="gotopage('','next')">下一页</div>
							       		<div class="pageEnd" onclick="gotopage('','end')">末页</div>
							       	</c:if>
						       	
							       	<div style="color: gray;float: left;">
							       		<div style="line-height: 30px;font-size: 12px;float: left;margin-left: 5px;">
								   			<%-- 总记录数：<c:out value="${page.totalResult}"/>条 --%>
									       	共&nbsp;<c:out value="${page.sumPage}"/>&nbsp;页，&nbsp;
									       	至第&nbsp;<input type="text" id="goPage" name="goPage" style="border: 1px solid #e1e2e3;border-radius:3px;width: 30px;height: 18px;">&nbsp;页
								       	</div>
								       	<div style="float: left;margin-top: 4px;margin-left: 5px;">
								       		<div class="enter" style="float: left;border: 1px solid #e1e2e3;text-align: center;font-size: 12px;width: 40px;line-height: 20px;color: black;cursor: pointer;" onmousemove='mousemove(this)' onmouseout='mouseout(this)' onclick="gotopage('','go')">确定</div>
								     	</div>
							       	</div>
						       </c:if>
					       </c:if>
					   	
						</div>
					   	<form id="pageForm" name="pageForm" action="" method="post">
					   		<input type="hidden" id="pageNo" name="page">
					   		<input type="hidden" id="rows" name="rows" value="50">
					   		<input type="hidden" id="country" name="country" value="${projectInfoQueryVo.country}">
					    	<input type="hidden" id="province" name="province" value="${projectInfoQueryVo.province}">
					    	<input type="hidden" id="city" name="city" value="${projectInfoQueryVo.city}">
					    	<input type="hidden" id="industry" name="industry" value="${projectInfoQueryVo.industry}">
					    	<input type="hidden" id="custom" name="custom" value="${projectInfoQueryVo.custom}">
					   	</form>
					   	<input type="hidden" id="pageNO" name="pageNO" value="${page.pageNo }" >
					    <input type="hidden" id="prevpageNO" name="prevpageNO" value="${page.pageNo-1 }">
					    <input type="hidden" id="nextpageNO" name="nextpageNO" value="${page.pageNo+1 }">
					    <input type="hidden" id="sumPage" name="sumPage" value="${page.sumPage }" >
					 </c:if>
				 </div>
			</div>
		</div>
	</div>
  </body>
  <script type="text/javascript">
	  $.ajaxSetup({   
			contentType:"application/x-www-form-urlencoded;charset=utf-8",   
			complete:function(XMLHttpRequest,textStatus){ 
				var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
				if(sessionstatus=="timeout"){ 
					//如果超时就处理 ，跳出登陆的页面
					//window.location.replace("${pageContext.request.contextPath}/logintimeout.jsp");
					/* $("#login").attr("src","${pageContext.request.contextPath}/market/map/loginIndex.action");
					$("#login").show(); */
					window.parent.showLoginDialog();
					
					//直接摧毁重新加载
					$('ul[id^="pic"]').viewer('destroy').viewer({
						url: 'data-original',
					    view: function (e) {
					    	$.ajax({
								type:'POST',//post请求
								url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
									
								}
							});
					    },
					});
				}   
	   	}
	});
  	function pic(){
  		$("#projectInfoContent").css("max-height",$("#container",window.parent.document).height()*0.7-30+"px");
		$('ul[id^="pic"]').viewer({
			url: 'data-original',
		    view: function (e) {
		    	$.ajax({
					type:'POST',//post请求
					url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
						
					}
				});
		    },
		});
		
	}
  	
  	function closeThis(){
  		$("#iframe",window.parent.document).hide();
  		$("#iframe",window.parent.document).removeAttr("src");
  	}
  	
  	/*窗口自适应，关键代码*/
  	$(window).resize(function(){
  		$("#projectInfoContent").css("max-height",$("#container",window.parent.document).height()*0.7-30+"px");
  		$("#projectInfoContent").css("max-width",$("#container",window.parent.document).width()*0.3+"px");
  	});
  	
  	
  	$(function(){
  		$("#search").click(function(){
  			$("#customSearch").animate({width:'toggle'},350);
  			if ($("#search").css("margin-left") == "140px"){
  				$("#search").animate({marginLeft:'-=140px'},350);
  			}else{
  				$("#search").animate({marginLeft:'+=140px'},350);
  			}
  		});
  		
  		if ($("#customSearch").val() != ""){
  			$("#customSearch").animate({width:'toggle'},1);
  			$("#search").animate({marginLeft:'+=140px'},1);
  			var str = $("#customSearch").val();
  			$("#customSearch").val("").focus().val(str);
  		}
  		
  		$("#customSearch").bind('keydown', function(e){
  			if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
  				$.ajax({
  					type:'POST',//post请求
  					url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
  					async: false,//同步请求
  					cache: false,//不缓存此页面
  					success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
  						if (datas != "" && datas != null && datas != undefined){
  							$("#pageNo").val(1);
  							$("#industry").val("");
  							$("#custom").val($("#customSearch").val());
  							document.pageForm.submit();
  						}
  					}
  				});
  			}
  		});
  		
  		if ($("#goPage").length >0){
	  		$("#goPage").bind('keydown', function(e){
	  			if (e.keyCode == 13){	// 当按下回车键时接受输入的值。
	  				gotopage('','go');
	  			}
	  		});
  		}
  		
  		$(".industry.link").bind('mousemove', function(){
  			$(this).removeClass("link");
  			$(this).addClass("hover");
  		});
  		
		$(".industry.link").bind('mouseout', function(){
			$(this).removeClass("hover");
  			$(this).addClass("link");
  		});
		
		$(".industry").bind('click', function(){
			var industry = $(this).text().split("(")[0];
			$.ajax({
				type:'POST',//post请求
				url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
					if (datas != "" && datas != null && datas != undefined){
						$("#pageNo").val(1);
						$("#industry").val(industry);
						document.pageForm.submit();
					}
				}
			});
  		});

		$(".pageNumber,.pageStart,.pagePre,.pageNext,.pageEnd,.enter").bind('mousemove', function(){
			$(this).css("border-color","#122d3f");
			$(this).css("color","#122d3f");
		});
		
		$(".pageNumber,.pageStart,.pagePre,.pageNext,.pageEnd,.enter").bind('mouseout', function(){
			$(this).css("border-color","#e1e2e3");
			$(this).css("color","#000000");
		});
		$("#goPage").bind('focus', function(){
			$(this).css("border-color","#122d3f");
			$(this).css("color","#122d3f");
		});
		
		$("#goPage").bind('blur', function(){
			$(this).css("border-color","#e1e2e3");
			$(this).css("color","gray");
		});
		$(".pageNumber").bind('click', function(){
			var pageNo = $(this).html();
			$.ajax({
				type:'POST',//post请求
				url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
					if (datas != "" && datas != null && datas != undefined){
						$("#pageNo").val(pageNo);
						document.pageForm.submit();
					}
				}
			});
		});
  	});
  
	//分页的js
  	function gotopage(action, flag){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
				if (datas != "" && datas != null && datas != undefined){
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
						pageNO = $("#goPage").val();
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
					//window.location.href = action+"?pageNo="+pageNO;
					$("#pageNo").val(pageNO);
					
					document.pageForm.submit();
				}
			}
		});
	}
  	
  </script>
</html>
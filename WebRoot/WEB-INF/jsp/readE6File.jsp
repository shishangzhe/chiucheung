<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="cn.chiucheung.utils.HttpUtil"%>
<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>${reviewerFile.filename }</title>
    <jsp:include page="/common.jsp"></jsp:include>
  </head>
  <script type="text/javascript">
	
  </script>
  <body>
  	<c:if test="${reviewerFile.extension == 'dwg'}">
	  	<!-- AutoVue -->
	  	<%-- <object id="AutoVueX" classid="clsid:B6FCC215-D303-11D1-BC6C-0000C078797F" type="application/x-oleobject" align="baseline" border="0" WIDTH="100%" height="100%">
		    <div id="noCadViewerTips" style="text-align: center; padding-top: 40px;">
		      <h1>查看设计图：${reviewerFile.filename }</h1>
		      <br/>
		      <b>提示：</b>本功能只支持 IE 浏览器，请先安装AutoVue 19及以上版本</b></a>，安装后刷新本页面
		    </div>
		    <param name="src" value="${url }" />
		    <param name="ShowMainToolBar" value="1" />
		    <param name="ShowAuxiToolBar" value="1" />
		    <param name="ShowStatusBar" value="0" />
		    <param name="ShowScrollBars" value="1" />
		    <param name="EnablePopupMenu" value="1" />
		</object> --%>
		<!-- eDrawings -->
		<object id="EModelViewControl"  classid="CLSID:22945A69-1191-4DCF-9E6F-409BDE94D101"
	        codebase="http://www.solidworks.com/plugins/edrawings/" width="100%" height="99%" style="position: fixed;top: -1px;left: -1px;">
	  
		  <div id="noCadViewerTips" style="text-align: center; padding-top: 40px;">
		    <h1>查看设计图：${reviewerFile.filename }</h1>
		    <br/>
		    <b>提示：</b>本功能只支持 IE 浏览器，请先<a href="http://192.168.0.247:90/static/ev.zip"><b>点这里下载插件eDrawings Viewer</b></a>，安装插件后刷新本页面
		  </div>
		  <param name="FullUI" value="1" />
		  <param name="EnableFeatures" value="88" />
		  <param name="Filename" value="${url }"></param>
		</object>
	</c:if>
	<c:if test="${reviewerFile.extension == 'doc' || reviewerFile.extension == 'xls'}">
		office文档暂不支持预览
	</c:if>
	<c:if test="${reviewerFile.extension != 'dwg' && reviewerFile.extension != 'doc' && reviewerFile.extension != 'xls'}">
		<c:redirect url="${url}"></c:redirect>
	</c:if>
  </body>
  <script type="text/javascript">
	$(document).ready(function () {
	   $('#EModelViewControl').height($(window).height());
	});
	/* $(document).ready(function () {
	   $('#AutoVueX').height($(window).height()-20);
	}); */
	  
  </script>
</html>

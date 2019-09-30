<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>工具</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
	<jsp:include page="/common.jsp"></jsp:include>
	
  </head>
  <script type="text/javascript">
	function upload(){
		if ($("#form1").form('validate')){
			$("#form1").submit();
		}
	}
  </script>
<body>   
  		<form id="form1" enctype="multipart/form-data" action="${pageContext.request.contextPath}/utils/markImage.action" method="post" target="_blank">
  			<table style="border-spacing:5px;border-bottom: 0.5px;">
  				<tr>
  					<td style="text-align: right;">
  						要添加水印的图片：
  					</td>
  					<td style="text-align: left;">
  						<input id="images" name="images" class="easyui-filebox" style="width: 200px;" data-options="required:true,buttonText:'浏览',multiple:true,buttonAlign:'left',validType:'checkPic'">
  						<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="upload()">上传</a>
  					</td>
  				</tr>
  			</table>
  		</form>
</body>    
</html>

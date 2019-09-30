<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>任务视图</title>
  </head>
<body>
	<!-- 流程图 -->
	<img style="position: absolute; top: 0px; left: 0px;"
		src="${pageContext.request.contextPath}/system/flow/queryProcessDefinitionResource.action?processDefinitionId=${processDefinitionId}&resourceType=png">


	<!-- 流程图中当前活动框 -->
	<c:forEach items="${list}" var="obj">
		<div title="${obj.assignee}" style="position: absolute;border:3px solid red;border-radius:13px;width: ${obj.activity_width-3 }px;height:${obj.activity_height-3 }px;top:${obj.activity_y-1 }px;left: ${obj.activity_x-1 }px;">
			
		</div>
		<img src="${pageContext.request.contextPath}/image/jiantou.png" width="30px" height="20px" style="position: absolute;top:${obj.activity_y+obj.activity_height/3+2 }px;left: ${obj.activity_x+obj.activity_width+2}px;">
		<div title="${obj.assignee}" style="position: absolute;top:${obj.activity_y+obj.activity_height/3 }px;left: ${obj.activity_x+obj.activity_width+30 }px;">
			${obj.assignee}
		</div>
	</c:forEach>
		

</body>

</html>


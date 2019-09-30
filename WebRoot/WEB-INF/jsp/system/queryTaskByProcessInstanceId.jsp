<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <title>任务列表</title>
	<jsp:include page="/common.jsp"></jsp:include>
  </head>
<body>

		<%-- <input type="hidden" id="page_index" name="page_index" value="1"/>
		<input type="hidden" id="page_size" name="page_size" value="15"> 
		<table class="easyui-datagrid" >
			<thead>
				<tr>
					<td>任务id</td>
					<td>任务名称</td>
					<td>负责人</td>
					<td>任务标识</td>
					<td>开始时间</td>
					<td>结束时间</td>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="task">
					<tr>
						<td class=category>${task.taskId}</td>
						<td class=category>${task.taskName }</td>
						<td class=category>${task.assignee}</td>
						<td class=category>${task.taskDefinitionKey}</td>
						<td class=category><fmt:formatDate value="${task.task_startTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td class=category><fmt:formatDate value="${task.task_endTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table> --%>
		<table class="easyui-datagrid" width=680px  data-options="singleSelect:true">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'taskId',width:50,align:'center'">任务id</th>   
		            <th data-options="field:'taskName',width:100,align:'center'">任务名称</th>   
		            <th data-options="field:'assignee',width:100,align:'center'">负责人</th> 
		            <th data-options="field:'taskDefinitionKey',width:120,align:'center'">任务标识</th> 
		            <th data-options="field:'task_startTime',width:150,align:'center'">开始时间</th> 
		            <th data-options="field:'task_endTime',width:150,align:'center'">结束时间</th>   
		        </tr>   
		    </thead>   
		    <tbody>   
		        <c:forEach items="${list}" var="task">
		        	<tr>
		        		<td>${task.taskId}</td>
						<td>${task.taskName }</td>
						<td>${task.assignee}</td>
						<td>${task.taskDefinitionKey}</td>
						<td><fmt:formatDate value="${task.task_startTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${task.task_endTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
		        	</tr>
		        </c:forEach>
		    </tbody>   
		</table>  


</body>
</html>
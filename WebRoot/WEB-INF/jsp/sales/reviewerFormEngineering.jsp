<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<div>
	<form id="form1" style="height: 100%" enctype='multipart/form-data' method="post">
		<input id="flag" type="hidden" value="">
 			<input name="isCost" type="hidden" value="false"><!-- 标识当前的为交期评审 -->
 			<input id="id" type="hidden" name="id" value="">
 			<input id="processInstanceId" type="hidden" name="processInstanceId">
 			<table cellspacing="0" align="center" width="960px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
  			<tr style="height: 30px">
  				<td colspan="18" style="text-align:center;">
  					<div style="width: 40%;text-align: center;float: left;">
		  				报价单编号：<input id="quotationNo" type="text" name="quotationNo" class="easyui-textbox" style="width: 300px;height: 27px" data-options="readonly:true,required:true,missingMessage:'报价单编号不能为空',validType:'checkQuotationNoFormat'">
		  			</div>
		  			<div style="width: 30%;text-align: center;float: left;">
		  				信息记录次数：&nbsp;&nbsp;第&nbsp;&nbsp;<input id="infoRecordNumber" type="text" name="infoRecordNumber" style="width: 30px;height: 27px" class="easyui-numberbox" data-options="readonly:true,required:true,missingMessage:'信息记录不能为空'">&nbsp;&nbsp;次
	  				</div>
	  				<div style="width: 30%;text-align: center;float: left;">
		  				日期：<input id="createTime" type="text" name="createTime" class="easyui-datebox" style="height: 27px" value="<p:date/>" data-options="editable:false,readonly:true,required:true,missingMessage:'日期不能为空'">
	  				</div>
	  			</td>
  			</tr>
  			<tr style="height: 30px">
  				<td colspan="3" rowspan="2" style="text-align:center;width: 10%">
  					客户需求<br>
  					项目
  				</td>
  				<td colspan="5" style="text-align:center;width: 30%">
	  				<input type="checkbox" name="project" value="控制台" onclick="return false">控制台
	  			</td>
	  			<td colspan="5" style="text-align:center;width: 30%">
	  				<input type="checkbox" name="project" value="机柜" onclick="return false">机柜
	  			</td>
	  			<td colspan="5" style="text-align:center;width: 30%">
	  				<input type="checkbox" name="project" value="电视墙" onclick="return false">电视墙
	  			</td>
  			</tr>
  			<tr style="height: 30px">
  				<td colspan="15" style="width: 90%">
  					其他：<input id="otherProject" type="text" style="width: 90%;height: 27px" name="otherProject" class="easyui-textbox" data-options="readonly:true">
  				</td>
  			</tr>
  			<tr style="height: 100px;">
  				<td colspan="1" style="width: 4%">
  					项<br>目<br>内<br>容
  				</td>
  				<td colspan="17" style="text-align:center;width: 96%">
  					<input id="projectContent" type="text" class="easyui-textbox" style="width: 96%;height: 99%" name="projectContent"  data-options="readonly:true,multiline:true">
  				</td>
  			</tr>
  			<tr style="height: 30px">
  				<td colspan="2" style="text-align:center;width: 5%">
  					包装
  				</td>
  				<td colspan="16" style="text-align:left;width: 95%">
	  				<input type="checkbox" name="packaging" value="纸皮" onclick="return false">纸皮
	  				<input type="checkbox" name="packaging" value="纸箱" onclick="return false">纸箱
	  				<input type="checkbox" name="packaging" value="木箱" onclick="return false">木箱
	  				<input type="checkbox" name="packaging" value="木栏" onclick="return false">木栏
	  				&nbsp;&nbsp;其他：<input type="text" style="width: 68%;height: 27px" name="otherPackaging" class="easyui-textbox" data-options="readonly:true">
  				</td>
  			</tr>
  			<tr style="height: 30px">
  				<td colspan="2" style="text-align:center;width: 5%">
  					送货
  				</td>
  				<td colspan="12" style="text-align:left;">
	  				<input type="checkbox" name="delivery" value="厂车" onclick="return false">厂车
	  				<input type="checkbox" name="delivery" value="请车" onclick="return false">请车
	  				<input type="checkbox" name="delivery" value="速递" onclick="return false">速递
	  				<input type="checkbox" name="delivery" value="空运" onclick="return false">空运
	  				<input type="checkbox" name="delivery" value="托运" onclick="return false">托运
	  				<input type="checkbox" name="delivery" value="铁路" onclick="return false">铁路
	  				<input type="checkbox" name="delivery" value="自取" onclick="return false">自取
	  				&nbsp;&nbsp;其他：<input id="otherDelivery" type="text" style="width: 37%;height: 27px" name="otherDelivery" class="easyui-textbox" data-options="readonly:true">
  				</td>
  				<td colspan="4" style="text-align:center;width: 24%">
  					填表人：<input id="salPreparer" type="text" name="salPreparer" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true" value="${user.username}">
  				</td>
  			</tr>
  			<tr style="height: 30px">
  				<td colspan="5" style="text-align:center;width: 22%">
  					送货地点：<input id="destination" type="text" name="destination" style="width: 70%;height: 27px" class="easyui-textbox" data-options="readonly:true">
  				</td>
  				<td colspan="4" style="text-align:center;width: 24%">
	  				是否安装：
	  				<input type="checkbox" name="isInstall" value="true" checked="checked" onclick="return false">是
	  				<input type="checkbox" name="isInstall" value="false" onclick="return false">否
  				</td>
  				<td colspan="5" style="text-align:center;width: 30%">
	  				期望交布局图日：<input id="expectedLayoutDate" type="text" name="expectedLayoutDate" class="easyui-datebox" data-options="editable:false,readonly:true">
  				</td>
  				<td colspan="4" style="text-align:center;width: 24%">
	  				项目负责人：<input id="projectLeader" type="text" name="projectLeader" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true">
  				</td>
  			</tr>
  			<tr style="height: 30px">
  				<td colspan="9" style="text-align:center;width: 46%">
  					项目紧急和重要程度：<input id="importance" type="text" name="importance" style="width: 70%;height: 27px" class="easyui-textbox" data-options="readonly:true">
  				</td>
  				<td colspan="5" style="text-align:center;width: 30%">
	  				合同总交期：<input id="contractDeliveryDate" type="text" name="contractDeliveryDate" class="easyui-textbox" style="height: 27px" data-options="editable:false,readonly:true">
  				</td>
  				<td colspan="4" style="text-align:center;width: 24%">
	  				审核人：<input id="salReviewer" type="text" name="salReviewer" style="width: 35%;height: 27px" class="easyui-textbox" data-options="readonly:true">
  				</td>
  			</tr>
  			<tr style="height: 30px;background-color: #969494;">
  				<td colspan="10" style="text-align:center;width: 52%">
  					<b><span style="font-size: 15px">需做成本核算项目：</span></b><input id="requiredCostOfProject" type="text" name="requiredCostOfProject" style="width: 70%;height: 27px" class="easyui-textbox" data-options="readonly:true">
  				</td>
  				<td colspan="8" style="text-align:center;width: 48%">
	  				<b><span style="font-size: 15px">要求完成日期：</span></b><input id="requiredCompletionDate" type="text" name="requiredCompletionDate" class="easyui-datebox" style="height: 27px" data-options="editable:false,readonly:true">
  				</td>
  			</tr>
  			<tr style="height: 30px;">
  				<td colspan="18" style="text-align:center;">
  					<div style="width: 10%;float: left;">
  						抄送相关部门：
 					</div>
  					<div style="width: 15%;float: left;">
  						<input type="checkbox" name="aboutDepartment" value="工程部" onclick="return false">工程部
  					</div>
  					<div style="width: 15%;float: left;">
  						<input type="checkbox" name="aboutDepartment" value="采购部" onclick="return false">采购部
 						</div>
  					<div style="width: 15%;float: left;">
  						<input type="checkbox" name="aboutDepartment" value="生产部" onclick="return false">生产部
  					</div>
  					<div style="width: 15%;float: left;">
  						<input type="checkbox" name="aboutDepartment" value="品管部" onclick="return false">品管部
  					</div>
  					<div style="width: 15%;float: left;">
  						<input type="checkbox" name="aboutDepartment" value="财务部" onclick="return false">财务部
 					</div>
  				</td>
  			</tr>
  			
  			
  			
  			
  			<table cellspacing="0" align="center" width="960px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
	  			<tr style="height: 30px">
	  				<td id="firstTd" colspan="1" rowspan="7" style="text-align: center;width: 3%">
	  					工<br>程<br>部
	  				</td>
	  				<td colspan="1" style="text-align: center;width: 4%">
	  					项目<br>序号
	  				</td>
	  				<td colspan="2" style="text-align: center;width: 15%">
	  					货品名称
	  				</td>
	  				<td colspan="2" style="text-align: center;width: 22%">
	  					产品型号
	  				</td>
	  				<td colspan="1" style="text-align: center;width: 4%">
	  					数量
	  				</td>
	  				<td colspan="1" style="text-align: center;width: 3%">
	  					单位
	  				</td>
	  				<td colspan="1" style="text-align: center;width: 4%">
	  					类型
	  				</td>
	  				<td colspan="1" style="text-align: center;width: 9%">
	  					负责人
	  				</td>
	  				<td colspan="2" style="text-align: center;width: 6%">
	  					工程实际<br>需工时
	  				</td>
	  				<td colspan="2" style="text-align: center;width: 10%">
	  					预计开工<br>日期
	  				</td>
	  				<td colspan="2" style="text-align: center;width: 10%">
	  					预计完成<br>日期(最短)
	  				</td>
	  				<td colspan="2" style="text-align: center;width: 10%">
	  					预计完成<br>日期(最长)
	  				</td>
	  			</tr>
	  			<tr class="add" style="height: 30px">
	  				<td colspan="1" style="text-align: center;width: 50px">
	  					<input id="id0" type="hidden" name="reviewerSubsidiaries[0].id" value="">
	  					<input id="sequence0" type="hidden" name="reviewerSubsidiaries[0].sequence" value="1">
	  					1
	  				</td>
	  				<td colspan="2" style="text-align: center;">
	  					<input id="projectName0" type="text" name="reviewerSubsidiaries[0].projectName" style="width: 140px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  				<td colspan="2" style="text-align: center;">
	  					<input id="productModel0" type="text" name="reviewerSubsidiaries[0].productModel" style="width: 205px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  				<td colspan="1" style="text-align: center;">
	  					<input id="quantity0" type="text" name="reviewerSubsidiaries[0].quantity" style="width: 35px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  				<td colspan="1" style="text-align: center;">
	  					<input id="unit0" type="text" name="reviewerSubsidiaries[0].unit" style="width: 26px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  				<td colspan="1" style="text-align: center;">
	  					<input id="category0" type="text" name="reviewerSubsidiaries[0].category" style="width: 36px;height: 27px" class="easyui-textbox">
	  				</td>
	  				<td colspan="1" style="text-align: center;">
	  					<input id="engLeader0" type="text" name="reviewerSubsidiaries[0].engLeader" style="width: 81px;height: 27px" class="easyui-textbox" data-options="validType:'usernameIsRepeat'">
	  				</td>
	  				<td colspan="2" style="text-align: center;">
	  					<input id="engActualNeedTime0" type="text" name="reviewerSubsidiaries[0].engActualNeedTime" style="width: 54px;height: 27px" class="easyui-textbox">
	  				</td>
	  				<td colspan="2" style="text-align: center;">
	  					<input id="engExpectedStartTime0" type="text" name="reviewerSubsidiaries[0].engExpectedStartTime" class="easyui-datebox" data-options="editable:false" style="width: 92px;height: 27px">
	  				</td>
	  				<td colspan="2" style="text-align: center;">
	  					<input id="engExpectedShortestCompletionTime0" type="text" name="reviewerSubsidiaries[0].engExpectedShortestCompletionTime" class="easyui-datebox" data-options="editable:false" style="width: 92px;height: 27px">
	  				</td>
	  				<td colspan="2" style="text-align: center;">
	  					<input id="engExpectedLongestCompletionTime0" type="text" name="reviewerSubsidiaries[0].engExpectedLongestCompletionTime" class="easyui-datebox" data-options="editable:false" style="width: 92px;height: 27px">
	  				</td>
	  			</tr>
	  			
	  			
	  			<tr style="height: 30px">
	  				<td colspan="17" style="text-align: center;">
	  					制定：<input id="develop" type="text" name="develop" style="width: 90%;height: 27px" class="easyui-textbox">
	  				</td>
	  				<!-- <td colspan="8" style="text-align: center;">
	  					编排：<input id="arrange" type="text" name="arrange" style="width: 100px" class="easyui-textbox" data-options="readonly:true">
	  					日期：<input id="arrangeDate" type="text" name="arrangeDate" class="easyui-textbox" data-options="editable:false,readonly:true" style="width: 92px">
	  				</td> -->
	  			</tr>
	  			<tr style="height: 30px">
	  				<td colspan="2" style="text-align: center;">
	  					特别物料:
	  				</td>
	  				<td colspan="15" style="text-align: center;">
	  					<input id="specialMaterial" type="text" name="specialMaterial" style="width: 94%;height: 27px" class="easyui-textbox">
	  				</td>
	  			</tr>
	  			<tr style="height: 30px">
	  				<td colspan="2" rowspan="3" style="text-align: center;">
	  					备注:
	  				</td>
	  				<td colspan="11" rowspan="3" style="text-align: center;">
	  					<input id="engRemark" type="text" class="easyui-textbox" name="engRemark" style="width: 100%;height: 87px" data-options="multiline:true">
	  				</td>
	  				<td colspan="4" style="text-align: center;">
	  					编排人：<input id="arrange" type="text" name="arrange" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  					<!-- 填写人：<input id="engPreparer" type="text" name="engPreparer" style="width: 100px" class="easyui-textbox"> -->
	  				</td>
	  			</tr>
	  			<tr style="height: 30px">
	  				<td colspan="4" style="text-align: center;">
	  					审核人：<input id="engReviewer" type="text" name="engReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  			</tr>
	  			<tr style="height: 30px">
	  				<td colspan="4" style="text-align: center;">
	  					审核时间：<input id="engReviewerDate" type="text" name="engReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
	  				</td>
	  			</tr>
	  			
	  			<tr height="30px">
	  				<td colspan="1" style="text-align: center;">
	  					采购
	  				</td>
	  				<td colspan="3" style="text-align: center;">
	  					采购周期：<input id="purPeriod" type="text" name="purPeriod" style="width: 50px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天
	  				</td>
	  				<td colspan="5" style="text-align: center;">
	  					备注：<input id="purRemark" type="text" name="purRemark" style="width: 85%;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  				<td colspan="5" style="text-align: center;">
	  					审核人：<input id="purReviewer" type="text" name="purReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  				<td colspan="4" style="text-align: center;">
	  					审核时间：<input id="purReviewerDate" type="text" name="purReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
	  				</td>
	  			</tr>
	  			
	  			
	  			<tr style="height: 30px">
	  				<td colspan="1" rowspan="5" style="text-align: center;">
	  					生<br>产<br>部
	  				</td>
	  				<td colspan="6" style="text-align: center;">
	  					最短时间：<input id="proExpectedShortestCompletionTime" type="text" name="proExpectedShortestCompletionTime" style="width: 40px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天&nbsp;&nbsp;
	  					最长时间：<input id="proExpectedLongestCompletionTime" type="text" name="proExpectedLongestCompletionTime" style="width: 40px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天
	  				</td>
	  				<td colspan="11" style="text-align: center;">
	  					预算安装人数和安装周期:                
	  					<input id="installPeopleNumber" type="text" name="installPeopleNumber" style="width: 50px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;天/&nbsp;&nbsp;
	  					<input id="installPeriod" type="text" name="installPeriod" style="width: 35px;height: 27px" class="easyui-textbox" data-options="readonly:true">&nbsp;&nbsp;人
	  					
	  					
	  				</td>
  				</tr>
  				<tr style="height: 30px">
	  				<td colspan="13">
	  					有无特别加工手段（如设备或模具等费用）：
	  					<input type="checkbox" name="isSpecialProcessing" value="false" checked="checked" onclick="return false">无&nbsp;&nbsp;
	  					<input type="checkbox" name="isSpecialProcessing" value="true" onclick="return false">有&nbsp;&nbsp;
	  					<input id="specialProcessing" type="text" name="specialProcessing" style="width: 380px;height: 27px" class="easyui-textbox" data-options="readonly:true,disabled:true,required:true">
	  				</td>
	  				<td colspan="4" style="text-align: center;">
	  					预计开工时间：
	  					<input id="proExpectedStartTime" type="text" name="proExpectedStartTime" class="easyui-datebox" data-options="readonly:true,editable:false" style="width: 92px;height: 27px">
	  				</td>
  				</tr>
  				<tr style="height: 30px">
	  				<td colspan="2" rowspan="3" style="text-align: center;">
	  					备注:
	  				</td>
	  				<td colspan="11" rowspan="3" style="text-align: center;">
	  					<input id="proRemark" type="text" name="proRemark" class="easyui-textbox" style="width: 100%;height: 87px" data-options="readonly:true,multiline:true">
	  				</td>
	  				<td colspan="4" style="text-align: center;">
	  					填写人：<input id="proPreparer" type="text" name="proPreparer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  			</tr>
	  			<tr style="height: 30px">
	  				<td colspan="4" style="text-align: center;">
	  					审核人：<input id="proReviewer" type="text" name="proReviewer" style="width: 100px;height: 27px" class="easyui-textbox" data-options="readonly:true">
	  				</td>
	  			</tr>
	  			<tr style="height: 30px">
	  				<td colspan="4" style="text-align: center;">
	  					审核时间：<input id="proReviewerDate" type="text" name="proReviewerDate" style="width: 100px;height: 27px" class="easyui-datebox" data-options="readonly:true">
	  				</td>
	  			</tr>
	  		</table>
 			</table>
 		</form>
</div>
<div>
	<form id="e6Form" action="" method="post" target="_blank">
		<div style="text-align: left;padding-left: 5px">
  			备注说明：此表的流程规定按“与客户有关的过程管理程序”执行<br>
			* 最短时间：正常实际最快能做到的时间（不含星期天及假日）；特殊急单可调整做到的时间，不做正常合同承诺时间。<br>
			* 最长时间：考虑其他调整因素，保证能完成的时间（包括星期天和假日），承诺客户的合理合同时间。<br>
			<input id="isAttached" type="hidden" name="isAttached">
			E6账号：<input id="username" type="text" class="easyui-textbox" name="username" style="width: 100px;" data-options="required:true,missingMessage:'请输入E6账号'">
			E6密码：<input id="password" type="password" class="easyui-textbox" name="password" style="width: 100px" data-options="required:true,missingMessage:'请输入E6密码'">
			<table id="dg2" style="width: 960px"
				<p:isPrivilege pid="de" mid="dee">
				data-options="onDblClickRow:function (row){
												    	readE6File();
												    }"
				</p:isPrivilege>
			>
			</table>
		</div>
	</form>
</div>
<script type="text/javascript">
	//添加一行表格
	function addTable(){
		var tempRow = $(".add").length;
		$("#firstTd").attr("rowspan",$("#firstTd").attr("rowspan")*1+1);
		var tr = $('<tr class="add" style="height: 30px"></tr>');
		
		var td1 = $('<td colspan="1" style="text-align: center;width: 50px"></td>');
		var td1Id = $('<input id="id' +tempRow + '" type="hidden" name="reviewerSubsidiaries[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="sequence' +tempRow + '" type="hidden" name="reviewerSubsidiaries[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		td1.append(td1Id);
		td1.append(td1Sequence);
		td1.append(tempRow+1);
		tr.append(td1);
		
		var td2 = $('<td colspan="2" style="text-align: center;"></td>');
		var td2Content = $('<input id="productName' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].productName" style="width: 140px;height: 27px" data-options="readonly:true">');
		td2.append(td2Content);
		td2Content.textbox();
		tr.append(td2);
		
		var td3 = $('<td colspan="2" style="text-align: center;"></td>');
		var td3Content = $('<input id="productModel' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].productModel" style="width: 205px;height: 27px" data-options="readonly:true">');
		td3.append(td3Content);
		td3Content.textbox();
		tr.append(td3);
		
		var td4 = $('<td colspan="1" style="text-align: center;"></td>');
		var td4Content = $('<input id="quantity' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].quantity" style="width: 35px;height: 27px" data-options="readonly:true">');
		td4.append(td4Content);
		td4Content.numberbox();
		tr.append(td4);
		
		var td5 = $('<td colspan="1" style="text-align: center;"></td>');
		var td5Content = $('<input id="unit' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].unit" style="width: 26px;height: 27px" data-options="readonly:true">');
		td5.append(td5Content);
		td5Content.textbox();
		tr.append(td5);
		
		var td6 = $('<td colspan="1" style="text-align: center;"></td>');
		var td6Content = $('<input id="category' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].category" style="width: 36px;height: 27px">');
		td6.append(td6Content);
		td6Content.textbox();
		tr.append(td6);
		
		var td7 = $('<td colspan="1" style="text-align: center;"></td>');
		var td7Content = $('<input id="engLeader' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engLeader" style="width: 81px;height: 27px" data-options="validType:\'usernameIsRepeat\'">');
		td7.append(td7Content);
		td7Content.textbox();
		tr.append(td7);
		
		
		var td8 = $('<td colspan="2" style="text-align: center;"></td>');
		var td8Content = $('<input id="engActualNeedTime' +tempRow + '" name="reviewerSubsidiaries[' + tempRow + '].engActualNeedTime" type="text" style="width: 54px;height: 27px">');
		td8.append(td8Content);
		td8Content.textbox();
		tr.append(td8);
		
		var td9 = $('<td colspan="2" style="text-align: center;"></td>');
		var td9Content = $('<input id="engExpectedStartTime' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedStartTime" data-options="editable:false" style="width: 92px;height: 27px">');
		td9.append(td9Content);
		td9Content.datebox();
		tr.append(td9);
		
		var td10 = $('<td colspan="2" style="text-align: center;"></td>');
		var td10Content = $('<input id="engExpectedShortestCompletionTime' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedShortestCompletionTime" data-options="editable:false" style="width: 92px;height: 27px">');
		td10.append(td10Content);
		td10Content.datebox();
		tr.append(td10);
		
		var td11 = $('<td colspan="2" style="text-align: center;"></td>');
		var td11Content = $('<input id="engExpectedLongestCompletionTime' +tempRow + '" type="text" name="reviewerSubsidiaries[' + tempRow + '].engExpectedLongestCompletionTime" data-options="editable:false" style="width: 92px;height: 27px">');
		td11.append(td11Content);
		td11Content.datebox();
		tr.append(td11);
		$(".add").last().after(tr);
		
		//改变datebox控件的输入框的宽度
		td9Content.next().children('input').first().css('width',td9Content.next().width()-22);
		td10Content.next().children('input').first().css('width',td10Content.next().width()-22);
		td11Content.next().children('input').first().css('width',td11Content.next().width()-22);
	}
</script>
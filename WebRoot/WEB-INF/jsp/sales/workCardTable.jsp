<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
  <script type="text/javascript">
	$(function () {
		//checkbox单选
		$("#workCardForm input[type='checkbox'][class!='noRadio']").click(function(){
			var name = $(this).attr("name");
			var value = $(this).val();
			$("input[name='"+name+"']").each(function(index,domEle){
				if (value != $(domEle).val()){
					$(domEle).prop("checked",false);
				}
			});
		});
		
		
		//1.批核程序
		$("input[name='approvalProcedures']").click(function(){
			if($(this).val() == '其他'){
				if ($(this).is(':checked')){
					$("#approvalProceduresContent2").textbox('enable');
					$("#approvalProceduresContent3").textbox('enable');
				}else{
					$("#approvalProceduresContent2").textbox('disable');
					$("#approvalProceduresContent3").textbox('disable');
					$("#approvalProceduresContent2").textbox('clear');
					$("#approvalProceduresContent3").textbox('clear');
				}
			}else if ($(this).val() == '样板批核才生产'){
				if ($(this).is(':checked')){
					$("#approvalProceduresContent1").textbox('enable');
				}else{
					$("#approvalProceduresContent1").textbox('disable');
					$("#approvalProceduresContent1").textbox('clear');
				}
			}
		});
		
		
		//5.交货地点 
		$("input[name='deliveryPlace']").click(function(){
			if($(this).val() == '国内' && $(this).is(':checked')){
				$("#deliveryPlaceContent1").textbox('enable');
				$("#deliveryPlaceContent2").textbox('disable');
				$("#deliveryPlaceContent2").textbox('clear');
			}else if ($(this).val() == '转送外地' && $(this).is(':checked')){
				$("#deliveryPlaceContent1").textbox('disable');
				$("#deliveryPlaceContent2").textbox('enable');
				$("#deliveryPlaceContent1").textbox('clear');
			}else{
				$("#deliveryPlaceContent1").textbox('disable');
				$("#deliveryPlaceContent2").textbox('disable');
				$("#deliveryPlaceContent1").textbox('clear');
				$("#deliveryPlaceContent2").textbox('clear');
			}
		});
		
		//11.是否分点送货
		$("input[name='equinoctialDelivery']").click(function(){
			if($(this).val() == 'true' && $(this).is(':checked')){
				$("#equinoctialDeliveryInstructions").textbox('enable');
			}else {
				$("#equinoctialDeliveryInstructions").textbox('disable');
				$("#equinoctialDeliveryInstructions").textbox('clear');
			}
		});
		
		//15.组装形式
		$("input[name='assemblyWay']").click(function(){
			if($(this).val() == '半组装' && $(this).is(':checked')){
				$("#assemblyWayContent1").textbox('enable');
				$("#assemblyWayContent2").textbox('disable');
				$("#assemblyWayContent3").textbox('disable');
				$("#assemblyWayContent2").textbox('clear');
				$("#assemblyWayContent3").textbox('clear');
			}else if($(this).val() == '其他' && $(this).is(':checked')){
				$("#assemblyWayContent1").textbox('disable');
				$("#assemblyWayContent2").textbox('enable');
				$("#assemblyWayContent3").textbox('enable');
				$("#assemblyWayContent1").textbox('clear');
			}else {
				$("#assemblyWayContent1").textbox('disable');
				$("#assemblyWayContent2").textbox('disable');
				$("#assemblyWayContent3").textbox('disable');
				$("#assemblyWayContent1").textbox('clear');
				$("#assemblyWayContent2").textbox('clear');
				$("#assemblyWayContent3").textbox('clear');
			}
		});
		
		//16.配件形式
		$("input[name='partsWay']").click(function(){
			if($(this).val() == '其他' && $(this).is(':checked')){
				$("#partsWayContent1").textbox('enable');
				$("#partsWayContent2").textbox('enable');
			}else {
				$("#partsWayContent1").textbox('disable');
				$("#partsWayContent2").textbox('disable');
				$("#partsWayContent1").textbox('clear');
				$("#partsWayContent2").textbox('clear');
			}
		});
		
		//18.附件
		$("input[name='attachment']").click(function(){
			if ($(this).val() == '批核图'){
				if ($(this).is(':checked')){
					$("#attachmentCad").combobox('enable');
				}else{
					$("#attachmentCad").combobox('disable');
					$("#attachmentCad").combobox('clear');
				}
			}
		});
		
		//更改模板
		$("#confirmation").combobox({
			onChange:function(){
				var confirmation = $("#confirmation").combobox('getValue');
				if(confirmation != ""){
					$.ajax({
						type:'POST',//post请求
						url: '${pageContext.request.contextPath}/sales/workCard/' + confirmation + '.action',//ajax请求的url
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							$("#confirmationDiv").html(data);
							//var sequence = $("#confirmationSequence").val();
							var salWorkCardSubsidiaryId = $("#salWorkCardSubsidiaryId").val();
							
							$.ajax({
								type:'POST',//post请求
								url: '${pageContext.request.contextPath}/sales/workCard/findSalWorkCardSubsidiaryById.action',//ajax请求的url
								data: {id:salWorkCardSubsidiaryId},
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(data){//请求成功后的回调函数。data：服务器返回数据。
									data.quantity = data.quantity + data.unit;
									$("#confirmationForm").form('load',data);
								}
							});
							/* $("#confirmationForm").form('load',{
								workCardNo:$("#workCardNo").val(),
								sequence:$("#workCardSubsidiarySequence"+sequence).val(),
								productName:$("#workCardSubsidiaryProductName"+sequence).val(),
								productModel:$("#workCardSubsidiaryProductModel"+sequence).val(),
								quantity:$("#workCardSubsidiaryQuantity"+sequence).val().substring(0,$("#workCardSubsidiaryQuantity"+sequence).val().length-1)
							}); */
						}
					});
				}
			}
		});
		
		$('#confirmation').combobox('clear');
	});
	
	
	//添加一行表格
	function addWorkCardTable(){
		var tempRow = $(".workCardAdd").length;
		var tr = $('<tr class="workCardAdd" style="height: 30px"></tr>');
		
		var td1 = $('<td style="width: 20px;"></td>');
		var td1Id = $('<input id="workCardSubsidiaryId' +tempRow + '" type="hidden" name="workCardSubsidiaries[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="workCardSubsidiarySequence' +tempRow + '" type="hidden" name="workCardSubsidiaries[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		var td1SalReviewerSubsidiaryId = $('<input id="reviewerSubsidiaryId' +tempRow + '" type="hidden" name="workCardSubsidiaries[' + tempRow + '].salReviewerSubsidiaryId" value="">');
		td1.append(td1Id);
		td1.append(td1Sequence);
		td1.append(td1SalReviewerSubsidiaryId);
		td1.append(tempRow+1);
		tr.append(td1);
		
		
		var td2 = $('<td></td>');
		var td2Content = $('<input id="workCardSubsidiaryProductCode' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productCode" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'代码不能为空\'">');
		td2.append(td2Content);
		tr.append(td2);
		
		var td3 = $('<td></td>');
		var td3Content = $('<input id="workCardSubsidiaryProductName' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productName" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'名称不能为空\'">');
		td3.append(td3Content);
		tr.append(td3);
		
		var td4 = $('<td></td>');
		var td4Content = $('<input id="workCardSubsidiaryProductModel' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productModel" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'规格不能为空\'">');
		td4.append(td4Content);
		tr.append(td4);
		
		var td5 = $('<td></td>');
		var td5Content = $('<input id="workCardSubsidiaryQuantity' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].quantity" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'数量不能为空\'">');
		td5.append(td5Content);
		tr.append(td5);
		
		var td6 = $('<td></td>');
		var td6Content = $('<input id="workCardSubsidiaryUnit' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].unit" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'单位不能为空\'">');
		td6.append(td6Content);
		tr.append(td6);
		
		var td7 = $('<td></td>');
		var td7Content = $('<input id="workCardSubsidiaryExpectedDeliveryDate' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].expectedDeliveryDate" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'预交货期不能为空\',editable:false">');
		td7.append(td7Content);
		tr.append(td7);
		
		
		var td8 = $('<td></td>');
		var td8Content = $('<input id="workCardSubsidiaryEngReleaseDataDate' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].engReleaseDataDate" type="text" style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'工程下资料日期不能为空\',editable:false">');
		td8.append(td8Content);
		tr.append(td8);
		
		var td9 = $('<td></td>');
		var td9Content = $('<input id="workCardSubsidiaryProPeriod' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].proPeriod"  style="width: 100%;height: 27px" data-options="required:true,missingMessage:\'生产做货周期不能为空\'">');
		td9.append(td9Content);
		tr.append(td9);
		
		var td10 = $('<td></td>');
		var td10Content = $('<a id="subsidiaryConfirmationA' +tempRow + '" href="#" style="cursor: pointer;" onclick="addConfirmation(' + tempRow + ')">新增</a>');
		td10.append(td10Content);
		tr.append(td10);
		
		
		$(".workCardAdd").last().after(tr);
		td2Content.textbox();
		td3Content.textbox();
		td4Content.textbox();
		td5Content.numberbox();
		td6Content.textbox();
		td7Content.datebox();
		td8Content.datebox();
		td9Content.textbox();
	}
	
	//删除，从最后一行删除表格
	function delWorkCardTable(){
		var tempRow = $(".workCardAdd").length;
		if (tempRow>1){
			$(".workCardAdd").last().remove();
		}
	}
	
	
	
	//打开新增工咭的dialog
	function addWorkCard(){
		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				$("#workCardForm").form('reset');//重置表单数据
				$("#reAuditState").val("");
				$("#workCardSubsidiaryId0").val("");
				$("#reviewerSubsidiaryId0").val("");
				//将第一行的做货确认单的按钮恢复默认
				$("#subsidiaryConfirmationA0").parent().html('<a id="subsidiaryConfirmationA0" href="#" style="cursor: pointer;" onclick="addConfirmation(0)">新增</a>');
				
				$("#showAttachmentDiv").html("");
				
				$("#workCardQuotationNo").textbox('readonly',false);
				$("#workCardLeader").textbox('readonly',false);
				$("#approvalProceduresContent1").textbox('disable');
				$("#approvalProceduresContent2").textbox('disable');
				$("#approvalProceduresContent3").textbox('disable');
				$("#deliveryPlaceContent1").textbox('enable');
				$("#deliveryPlaceContent2").textbox('disable');
				$("#equinoctialDeliveryInstructions").textbox('disable');
				$("#assemblyWayContent1").textbox('disable');
				$("#assemblyWayContent2").textbox('disable');
				$("#assemblyWayContent3").textbox('disable');
				$("#partsWayContent1").textbox('disable');
				$("#partsWayContent2").textbox('disable');
				$("#attachmentCad").combobox('disable');
				$("#attachmentCad").combobox('clear');
				$("#salReviewerId").val("");//将选中 的项目评审表的id
				
				$(".workCardAdd").each(function (index, domEle){
					if (index>0){
						$(this).remove();
					}
				});
				$("#workCardDialog").dialog({//加载一个dialog
					closed:false,//将该dialog的状态由不显示改成显示
					title:'新增工咭'//该dialog的标题
				});
				$("#workCardFlag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
				$("#refreshFlag").val('add');
			}
		});
	}
	
	//项目评审表生成工咭
	function generateWorkCard(){
		var selected = $("#dg").treegrid('getSelected');//取得选中的行
		if (selected!=null){
			var id = "";
			var processInstanceId = "";
			while (id == ""){
				if (selected._parentId == undefined){//根节点
					id = selected.id;
					processInstanceId = selected.processInstanceId;
				}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
					selected = $('#dg').treegrid('getParent',selected.id);
				}
			}
			var processInstanceIdInput = $(processInstanceId);
			if (processInstanceIdInput.text() == "审核完成"){
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/sales/reviewer/findSalReviewerByIdForGenerateWorkCard.action',
					data: {id:id},
					success:function(data){
						if (data.success){
							$("#workCardForm").form('reset');//重置表单数据
							$("#workCardSubsidiaryId0").val("");
							$("#reviewerSubsidiaryId0").val("");
							//将第一行的做货确认单的按钮恢复默认
							$("#subsidiaryConfirmationA0").parent().html('<a id="subsidiaryConfirmationA0" href="#" style="cursor: pointer;" onclick="addConfirmation(0)">新增</a>');
							
							$("#showAttachmentDiv").html("");
							
							$("#workCardQuotationNo").textbox('readonly',true);
							$("#workCardLeader").textbox('readonly',true);
							$("#approvalProceduresContent1").textbox('disable');
							$("#approvalProceduresContent2").textbox('disable');
							$("#approvalProceduresContent3").textbox('disable');
							$("#deliveryPlaceContent1").textbox('enable');
							$("#deliveryPlaceContent2").textbox('disable');
							$("#equinoctialDeliveryInstructions").textbox('disable');
							$("#assemblyWayContent1").textbox('disable');
							$("#assemblyWayContent2").textbox('disable');
							$("#partsWayContent1").textbox('disable');
							$("#partsWayContent2").textbox('disable');
							$("#attachmentCad").combobox('disable');
							$("#attachmentCad").combobox('clear');
							
							$(".workCardAdd").each(function (index, domEle){
								if (index>0){
									$(this).remove();
								}
							});
							$("#workCardDialog").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:'新增工咭'//该dialog的标题
							});
							$("#salReviewerId").val(id);//将选中 的项目评审表的id
							$("#workCardFlag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
							$("#refreshFlag").val('generate');
							
							$("#workCardQuotationNo").textbox('setValue',data.datas.reviewer.quotationNo);
							$("#workCardLeader").textbox('setValue',data.datas.reviewer.projectLeader);
							
							var j = 0;//用来记录新增的配件数量,每个项次都会有一个自选配件
							for(var i=0;i<data.datas.reviewerSubsidiaries.length;i++){
								if (i>0 || j>0){
									addWorkCardTable();
								}
								var k = i+j;
								$("#reviewerSubsidiaryId"+k).val(data.datas.reviewerSubsidiaries[i].id);
								$("#workCardSubsidiaryProductName"+k).textbox('setValue',data.datas.reviewerSubsidiaries[i].productName);
								$("#workCardSubsidiaryProductModel"+k).textbox('setValue',data.datas.reviewerSubsidiaries[i].productModel);
								$("#workCardSubsidiaryQuantity"+k).textbox('setValue',data.datas.reviewerSubsidiaries[i].quantity);
								$("#workCardSubsidiaryUnit"+k).textbox('setValue',data.datas.reviewerSubsidiaries[i].unit);
								$("#workCardSubsidiaryEngReleaseDataDate"+k).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedLongestCompletionTime);
								$("#workCardSubsidiaryProPeriod"+k).textbox('setValue', data.datas.reviewer.proExpectedLongestCompletionTime + "天");
								var quantity = data.datas.reviewerSubsidiaries[i].quantity;
								if (quantity > 1){
									j++;
									k++;
									addWorkCardTable();
									$("#reviewerSubsidiaryId"+k).val(data.datas.reviewerSubsidiaries[i].id);
									$("#workCardSubsidiaryProductName"+k).textbox('setValue',data.datas.reviewerSubsidiaries[i].productName+"自选配件");
									$("#workCardSubsidiaryProductModel"+k).textbox('setValue','见附件清单');
									$("#workCardSubsidiaryQuantity"+k).textbox('setValue','1');
									$("#workCardSubsidiaryUnit"+k).textbox('setValue','批');
									$("#workCardSubsidiaryEngReleaseDataDate"+k).datebox('setValue', data.datas.reviewerSubsidiaries[i].engExpectedLongestCompletionTime);
									$("#workCardSubsidiaryProPeriod"+k).textbox('setValue', data.datas.reviewer.proExpectedLongestCompletionTime + "天");
								}
							}
						}else{
							showErrorMessager("生成失败", data.message);
						}
					}
				});
			}else{
				showErrorMessager("生成失败", "未开启审核或审核未完成");
			}
		}else{
			showMessager("提示","请选择一条记录生成工咭");
		}
	}
	
	
	function addConfirmation(rowIndex){
		var id = $("#workCardSubsidiaryId"+rowIndex).val();
		if (id != ""){
			$("#confirmation").combobox('enable');
			$("#confirmationDiv").html("");
			$("#confirmationDialog").dialog({//加载一个dialog
				closed:false,//将该dialog的状态由不显示改成显示
				title:'新增做货确认单'//该dialog的标题
			});
			$("#confirmationForm").form('reset');
			$("#confirmationFlag").val('add');
			$("#confirmation").combobox('clear');
			$("#salWorkCardSubsidiaryId").val(id);
			$("#confirmationSequence").val(rowIndex);
		}else{
			showMessager("提示",'请先保存工咭');
		}
	}
	
	
	//打开修改工咭的dialog
	function editWorkCard(){
		
		$("#workCardFlag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
		var selected = $("#workCardDg").treegrid('getSelected');//取得选中的行
		if (selected!=null){
			var id = "";
			//判断是否是子节点
			if($("#workCardDg").treegrid('isLeaf',selected.id)){//是子节点
				id = selected._parentId;//取到父节点的ID
			}else{//不是子节点
				id = selected.id;//当前就是父节点，直接取ID
			}
			var data = "id=" + id;
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/sales/workCard/findSalWorkCardByIdForEdit.action',
				data:data,
				success:function(data){
					if (data.success){
						if (data.datas.isEdit){
							$("#workCardForm").form('reset');//重置表单数据
							//将第一行的做货确认单的按钮恢复默认
							$("#subsidiaryConfirmationA0").parent().html('<a id="subsidiaryConfirmationA0" href="#" style="cursor: pointer;" onclick="addConfirmation(0)">新增</a>');
							
							$("#showAttachmentDiv").html("");
							
							$("#workCardQuotationNo").textbox('readonly',true);
							$("#approvalProceduresContent1").textbox('disable');
							$("#approvalProceduresContent2").textbox('disable');
							$("#approvalProceduresContent3").textbox('disable');
							$("#deliveryPlaceContent1").textbox('enable');
							$("#deliveryPlaceContent2").textbox('disable');
							$("#equinoctialDeliveryInstructions").textbox('disable');
							$("#assemblyWayContent1").textbox('disable');
							$("#assemblyWayContent2").textbox('disable');
							$("#partsWayContent1").textbox('disable');
							$("#partsWayContent2").textbox('disable');
							$("#attachmentCad").combobox('disable');
							$("#attachmentCad").combobox('clear');
							
							$(".workCardAdd").each(function (index, domEle){
								if (index>0){
									$(this).remove();
								}
							});
							
							$("#workCardDialog").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:'修改工咭'//该dialog的标题
							});
							$("#workCardForm").form('load',data.datas.workCard);
							
							if (data.datas.workCard.salReviewerId != ""){
								$("#workCardQuotationNo").textbox('readonly',true);
							}else{
								$("#workCardQuotationNo").textbox('readonly',false);
							}
							
							//1.批核程序
							if (data.datas.workCard.approvalProcedures.split(',').length > 1){
								for(var i=0;i<data.datas.workCard.approvalProcedures.split(',').length;i++){
									$("input[name='approvalProcedures'][value=" +"'"+ data.datas.workCard.approvalProcedures.split(',')[i] + "'" + "]")[0].checked = true;
									
									if(data.datas.workCard.approvalProcedures.split(',')[i] == '其他'){
										$("#approvalProceduresContent2").textbox('enable');
										$("#approvalProceduresContent3").textbox('enable');
									}else if (data.datas.workCard.approvalProcedures.split(',')[i] == '样板批核才生产'){
										$("#approvalProceduresContent1").textbox('enable');
									}
								}
							}else if (data.datas.workCard.approvalProcedures != ""){//因为是approvalProceduresView，所以load的时候不会加载
								if(data.datas.workCard.approvalProcedures == '其他'){
									$("#approvalProceduresContent2").textbox('enable');
									$("#approvalProceduresContent3").textbox('enable');
								}else if (data.datas.workCard.approvalProcedures == '样板批核才生产'){
									$("#approvalProceduresContent1").textbox('enable');
								}
							}
							
							//5.交货地点
							if(data.datas.workCard.deliveryPlace == '国内'){
								$("#deliveryPlaceContent1").textbox('enable');
								$("#deliveryPlaceContent2").textbox('disable');
								$("#deliveryPlaceContent2").textbox('clear');
							}else if (data.datas.workCard.deliveryPlace == '转送外地'){
								$("#deliveryPlaceContent1").textbox('disable');
								$("#deliveryPlaceContent2").textbox('enable');
								$("#deliveryPlaceContent1").textbox('clear');
							}else if (data.datas.workCard.deliveryPlace == '香港'){
								$("#deliveryPlaceContent1").textbox('disable');
								$("#deliveryPlaceContent2").textbox('disable');
								$("#deliveryPlaceContent1").textbox('clear');
								$("#deliveryPlaceContent2").textbox('clear');
							}
							
							
							//11.是否分点送货
							if(data.datas.workCard.equinoctialDelivery){
								$("#equinoctialDeliveryInstructions").textbox('enable');
							}else {
								$("#equinoctialDeliveryInstructions").textbox('disable');
								$("#equinoctialDeliveryInstructions").textbox('clear');
							}
							
							
							//15.组装形式
							if(data.datas.workCard.assemblyWay == '半组装'){
								$("#assemblyWayContent1").textbox('enable');
								$("#assemblyWayContent2").textbox('disable');
								$("#assemblyWayContent3").textbox('disable');
								$("#assemblyWayContent2").textbox('clear');
								$("#assemblyWayContent3").textbox('clear');
							}else if(data.datas.workCard.assemblyWay == '其他'){
								$("#assemblyWayContent1").textbox('disable');
								$("#assemblyWayContent2").textbox('enable');
								$("#assemblyWayContent3").textbox('enable');
								$("#assemblyWayContent1").textbox('clear');
							}else{
								$("#assemblyWayContent1").textbox('disable');
								$("#assemblyWayContent2").textbox('disable');
								$("#assemblyWayContent3").textbox('disable');
								$("#assemblyWayContent1").textbox('clear');
								$("#assemblyWayContent2").textbox('clear');
								$("#assemblyWayContent3").textbox('clear');
							}
							
							//16.配件形式
							if(data.datas.workCard.partsWay == '其他'){
								$("#partsWayContent1").textbox('enable');
								$("#partsWayContent2").textbox('enable');
							}else {
								$("#partsWayContent1").textbox('disable');
								$("#partsWayContent2").textbox('disable');
								$("#partsWayContent1").textbox('clear');
								$("#partsWayContent2").textbox('clear');
							}
							
							//18.附件
							if (data.datas.workCard.attachment.split(',').length > 1){
								for(var i=0;i<data.datas.workCard.attachment.split(',').length;i++){
									$("input[name='attachment'][value=" +"'"+ data.datas.workCard.attachment.split(',')[i] + "'" + "]")[0].checked = true;
									
									if (data.datas.workCard.attachment.split(',')[i] == '批核图'){
										$("#attachmentCad").combobox('enable');
									}
								}
							}else{
								if (data.datas.workCard.attachment != "" && data.datas.workCard.attachment == '批核图'){
									$("#attachmentCad").combobox('enable');
								}
							}
							
							
							for(var i=0;i<data.datas.workCardSubsidiaries.length;i++){
								if (i > 0){
									addWorkCardTable();
								}
								
								$("#workCardSubsidiaryId"+i).val(data.datas.workCardSubsidiaries[i].id);
								$("#workCardSubsidiarySequence"+i).val(data.datas.workCardSubsidiaries[i].sequence);
								$("#reviewerSubsidiaryId"+i).val(data.datas.workCardSubsidiaries[i].salReviewerSubsidiaryId);
								$("#workCardSubsidiaryProductCode"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].productCode);
								$("#workCardSubsidiaryProductName"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].productName);
								$("#workCardSubsidiaryProductModel"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].productModel);
								$("#workCardSubsidiaryQuantity"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].quantity);
								$("#workCardSubsidiaryUnit"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].unit);
								$("#workCardSubsidiaryExpectedDeliveryDate"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].expectedDeliveryDate);
								$("#workCardSubsidiaryEngReleaseDataDate"+i).datebox('setValue', data.datas.workCardSubsidiaries[i].engReleaseDataDate);
								$("#workCardSubsidiaryProPeriod"+i).textbox('setValue', data.datas.workCardSubsidiaries[i].proPeriod);
								
								if (data.datas.workCardSubsidiaries[i].confirmation != ""){
									$("#subsidiaryConfirmationA" + i).html("修改");
									$("#subsidiaryConfirmationA" + i).attr('onclick','editConfirmation("' + data.datas.workCardSubsidiaries[i].id + '","' + data.datas.workCardSubsidiaries[i].confirmation + '","' + data.datas.workCardSubsidiaries[i].sequence + '")');
									$("#subsidiaryConfirmationA" + i).parent().append("<image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;' onclick='deleteConfirmation(\""+data.datas.workCardSubsidiaries[i].id + "\",\"" + data.datas.workCardSubsidiaries[i].confirmation +  "\",\"" + data.datas.workCardSubsidiaries[i].sequence +"\")'>");
								}
							}
							
							for (var i=0;i<data.datas.workCardFiles.length;i++){
								$("#showAttachmentDiv").append("<div id='"+data.datas.workCardFiles[i].id+"' style='width:25%;float:left;'><a href='${pageContext.request.contextPath}/sales/workCard/readFileById.action?id="+data.datas.workCardFiles[i].id+"' target='_blank'>"+data.datas.workCardFiles[i].fileName+"</a><image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;' onclick='deleteFile(\""+data.datas.workCardFiles[i].id+"\")'></div>");
							}
						}else{
							//则是查看
							alert(data.datas.doNotEditMessage);
							$("#workCardFormView").form('reset');//重置表单数据
							//将第一行的做货确认单的按钮恢复默认
							$("#subsidiaryConfirmationAView0").html("");
							$("#subsidiaryConfirmationAView0").attr("onclick","");
							
							$("#showAttachmentDivView").html("");
							
							$("#approvalProceduresContentView1").textbox('disable');
							$("#approvalProceduresContentView2").textbox('disable');
							$("#approvalProceduresContentView3").textbox('disable');
							$("#deliveryPlaceContentView1").textbox('enable');
							$("#deliveryPlaceContentView2").textbox('disable');
							$("#equinoctialDeliveryInstructionsView").textbox('disable');
							$("#assemblyWayContentView1").textbox('disable');
							$("#assemblyWayContentView2").textbox('disable');
							$("#partsWayContentView1").textbox('disable');
							$("#partsWayContentView2").textbox('disable');
							$("#attachmentCadView").combobox('disable');
							$("#attachmentCadView").combobox('clear');
							
							$(".workCardAddView").each(function (index, domEle){
								if (index>0){
									$(this).remove();
								}
							});
							
							$("#workCardViewDialog").dialog({//加载一个dialog
								closed:false,//将该dialog的状态由不显示改成显示
								title:'查看工咭'//该dialog的标题
							});
							$("#workCardFormView").form('load',data.datas.workCard);
							
							
							//1.批核程序
							if (data.datas.workCard.approvalProcedures.split(',').length > 1){
								for(var i=0;i<data.datas.workCard.approvalProcedures.split(',').length;i++){
									$("input[name='approvalProceduresView'][value=" +"'"+ data.datas.workCard.approvalProcedures.split(',')[i] + "'" + "]")[0].checked = true;
									
									if(data.datas.workCard.approvalProcedures.split(',')[i] == '其他'){
										$("#approvalProceduresContentView2").textbox('enable');
										$("#approvalProceduresContentView3").textbox('enable');
									}else if (data.datas.workCard.approvalProcedures.split(',')[i] == '样板批核才生产'){
										$("#approvalProceduresContentView1").textbox('enable');
									}
								}
							}else if (data.datas.workCard.approvalProcedures != ""){//因为是approvalProceduresView，所以load的时候不会加载
								$("input[name='approvalProceduresView'][value=" +"'"+ data.datas.workCard.approvalProcedures + "'" + "]")[0].checked = true;
								
								if(data.datas.workCard.approvalProcedures == '其他'){
									$("#approvalProceduresContentView2").textbox('enable');
									$("#approvalProceduresContentView3").textbox('enable');
								}else if (data.datas.workCard.approvalProcedures == '样板批核才生产'){
									$("#approvalProceduresContentView1").textbox('enable');
								}
							}
							
							//5.交货地点
							if(data.datas.workCard.deliveryPlace == '国内'){
								$("#deliveryPlaceContentView1").textbox('enable');
								$("#deliveryPlaceContentView2").textbox('disable');
								$("#deliveryPlaceContentView2").textbox('clear');
							}else if (data.datas.workCard.deliveryPlace == '转送外地'){
								$("#deliveryPlaceContentView1").textbox('disable');
								$("#deliveryPlaceContentView2").textbox('enable');
								$("#deliveryPlaceContentView1").textbox('clear');
							}else if (data.datas.workCard.deliveryPlace == '香港'){
								$("#deliveryPlaceContentView1").textbox('disable');
								$("#deliveryPlaceContentView2").textbox('disable');
								$("#deliveryPlaceContentView1").textbox('clear');
								$("#deliveryPlaceContentView2").textbox('clear');
							}
							
							
							//11.是否分点送货
							if(data.datas.workCard.equinoctialDelivery){
								$("#equinoctialDeliveryInstructionsView").textbox('enable');
							}else {
								$("#equinoctialDeliveryInstructionsView").textbox('disable');
								$("#equinoctialDeliveryInstructionsView").textbox('clear');
							}
							
							
							//15.组装形式
							if(data.datas.workCard.assemblyWay == '半组装'){
								$("#assemblyWayContentView1").textbox('enable');
								$("#assemblyWayContentView2").textbox('disable');
								$("#assemblyWayContentView3").textbox('disable');
								$("#assemblyWayContentView2").textbox('clear');
								$("#assemblyWayContentView3").textbox('clear');
							}else if(data.datas.workCard.assemblyWay == '其他'){
								$("#assemblyWayContentView1").textbox('disable');
								$("#assemblyWayContentView2").textbox('enable');
								$("#assemblyWayContentView3").textbox('enable');
								$("#assemblyWayContentView1").textbox('clear');
							}else{
								$("#assemblyWayContentView1").textbox('disable');
								$("#assemblyWayContentView2").textbox('disable');
								$("#assemblyWayContentView3").textbox('disable');
								$("#assemblyWayContentView1").textbox('clear');
								$("#assemblyWayContentView2").textbox('clear');
								$("#assemblyWayContentView3").textbox('clear');
							}
							
							//16.配件形式
							if(data.datas.workCard.partsWay == '其他'){
								$("#partsWayContentView1").textbox('enable');
								$("#partsWayContentView2").textbox('enable');
							}else {
								$("#partsWayContentView1").textbox('disable');
								$("#partsWayContentView2").textbox('disable');
								$("#partsWayContentView1").textbox('clear');
								$("#partsWayContentView2").textbox('clear');
							}
							
							//18.附件
							if (data.datas.workCard.attachment.split(',').length > 1){
								for(var i=0;i<data.datas.workCard.attachment.split(',').length;i++){
									$("input[name='attachmentView'][value=" +"'"+ data.datas.workCard.attachment.split(',')[i] + "'" + "]")[0].checked = true;
									
									if (data.datas.workCard.attachment.split(',')[i] == '批核图'){
										$("#attachmentCadView").combobox('enable');
									}
								}
							}else{
								if (data.datas.workCard.attachment != ""){
									$("input[name='attachmentView'][value=" +"'"+ data.datas.workCard.attachment + "'" + "]")[0].checked = true;
									if (data.datas.workCard.attachment == '批核图'){
										$("#attachmentCadView").combobox('enable');
									}
								}
							}
							
							
							for(var i=0;i<data.datas.workCardSubsidiaries.length;i++){
								if (i > 0){
									addWorkCardTableForView();
								}
								
								$("#workCardSubsidiaryIdView"+i).val(data.datas.workCardSubsidiaries[i].id);
								$("#workCardSubsidiarySequenceView"+i).val(data.datas.workCardSubsidiaries[i].sequence);
								$("#reviewerSubsidiaryIdView"+i).val(data.datas.workCardSubsidiaries[i].salReviewerSubsidiaryId);
								$("#workCardSubsidiaryProductCodeView"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].productCode);
								$("#workCardSubsidiaryProductNameView"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].productName);
								$("#workCardSubsidiaryProductModelView"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].productModel);
								$("#workCardSubsidiaryQuantityView"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].quantity);
								$("#workCardSubsidiaryUnitView"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].unit);
								$("#workCardSubsidiaryExpectedDeliveryDateView"+i).textbox('setValue',data.datas.workCardSubsidiaries[i].expectedDeliveryDate);
								$("#workCardSubsidiaryEngReleaseDataDateView"+i).datebox('setValue', data.datas.workCardSubsidiaries[i].engReleaseDataDate);
								$("#workCardSubsidiaryProPeriodView"+i).textbox('setValue', data.datas.workCardSubsidiaries[i].proPeriod);
								
								if (data.datas.workCardSubsidiaries[i].confirmation != ""){
									$("#subsidiaryConfirmationAView" + i).html("查看");
									$("#subsidiaryConfirmationAView" + i).attr('onclick','viewConfirmation("' + data.datas.workCardSubsidiaries[i].id + '","' + data.datas.workCardSubsidiaries[i].confirmation + '","' + data.datas.workCardSubsidiaries[i].sequence + '")');
								}
							}
							
							for (var i=0;i<data.datas.workCardFiles.length;i++){
								$("#showAttachmentDivView").append("<div style='width:25%;float:left;'><a href='${pageContext.request.contextPath}/sales/workCard/readFileById.action?id="+data.datas.workCardFiles[i].id+"' target='_blank'>"+data.datas.workCardFiles[i].fileName+"</a></div>");
							}
						}
					}else{
						showErrorMessager("修改失败", data.message);
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	//保存工咭
	function saveWorkCard(){
		if ($("#workCardForm").form('validate')){//判断 验证是否通过
			var url = "${pageContext.request.contextPath}/sales/workCard/";
			var flag = $("#workCardFlag").val();//获取标识符，
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "saveWorkCard.action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "updateWorkCard.action";
			}
			
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: new FormData($( "#workCardForm" )[0]),
				async: false,//同步请求
				cache: false,//不缓存此页面
				contentType: false,  
		        processData: false,  
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success){
							$("#workCardFlag").val('update');
							$("#workCardId").val(data.row.id);
							$("#processInstanceId").val(data.row.processInstanceId);
							for(var i=0;i<data.row.workCardSubsidiaries.length;i++){
								$("#workCardSubsidiaryId"+(data.row.workCardSubsidiaries[i].sequence-1)).val(data.row.workCardSubsidiaries[i].id);
								//$("#workCardSubsidiaryId"+i).val(data.row.workCardSubsidiaries[i].id);
							}
							
							$('#filebox').filebox('clear');
							for (var i=0;i<data.row.workCardFiles.length;i++){
								$("#showAttachmentDiv").append("<div id='"+data.row.workCardFiles[i].id+"' style='width:25%;float:left;'><a href='${pageContext.request.contextPath}/sales/workCard/readFileById.action?id="+data.row.workCardFiles[i].id+"' target='_blank'>"+data.row.workCardFiles[i].fileName+"</a><image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;' onclick='deleteFile(\""+data.row.workCardFiles[i].id+"\")'></div>");
							}
							
							showMessager("提示","保存成功");
							$("#workCardDialog").dialog({//关闭这个dialog
								title:"修改工咭"
							});
							var refreshFlag = $("#refreshFlag").val();
							if (refreshFlag == 'generate'){
								$("#dg").treegrid('reload');//重新加载数据，保持在当前页
							}else if (refreshFlag == 'add'){
								$("#workCardDg").treegrid('reload');//重新加载数据，保持在当前页
							}
						}else{
							showErrorMessager("保存失败", data.message);
						}
					}
				}
			});
		}
	}
	
	function deleteFile(id){
		$.messager.confirm('确认对话框', '您确定要删除该文件吗？', function(b){
			if (b){
				$.ajax({
					type:'POST',//post请求
					url: "${pageContext.request.contextPath}/sales/workCard/deleteFileById.action",//ajax请求的url
					data: {id:id},
					async: false,//同步请求
					cache: false,//不缓存此页面
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						if (data != null && data != ""){
							if (data.success){
								showMessager("提示","文件删除成功");
								$("#fileBoxDiv").show();
								$("#filebox").filebox('clear');
								//$("#showAttachmentDiv").html("");
								$("#"+id).remove();
							}else{
								showErrorMessager("删除失败", data.message);
							}
						}
					}
				});
			}
		});
	}
	
	//删除工咭
	function deleteWorkCard(){
		var selected = $("#workCardDg").treegrid('getSelected');//取得选中的行
		if (selected==null){
			showMessager("提示","请选择一条记录进行删除");
		}else{
			$.messager.confirm('确认对话框', '是否删除该条工咭信息？', function(b){
				if (b){//如何用户点击的是确认
					var id = "";
					var processInstanceId = "";
					while (id == ""){
						if (selected._parentId == undefined){//根节点
							id = selected.id;
							processInstanceId = selected.processInstanceId;
						}else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
							selected = $('#workCardDg').treegrid('getParent',selected.id);
						}
					}
					var processInstanceIdInput = $(processInstanceId);
					if(processInstanceId == ""){
						$.ajax({
							type:'POST',//post请求
							url: "${pageContext.request.contextPath}/sales/workCard/deleteSalWorkCardById.action",//ajax请求的url
							data: {id:id},//传的参数
							async: false,//同步请求
							cache: false,//不缓存此页面
							success: function(data){//请求成功后的回调函数。data：服务器返回数据。
								if (data != null && data != ""){
									if (data.success){
										showMessager("提示","删除成功");
										$("#workCardDg").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
										$("#workCardDg").treegrid('clearSelections');//清除所有选择的行
									}else{
										showErrorMessager("删除失败", data.message);
									}
								}
							}
						});
					}else if(processInstanceIdInput.text() == "审核中" || processInstanceIdInput.text() == "审核完成"){
						showErrorMessager("删除失败", '已开启审核，不能删除');
					}
				}
			});
		}
	}
	
	//保存做货确认单
	function saveConfirmation(){
		if ($("#confirmationForm").form('validate')){//判断 验证是否通过
			var url = "${pageContext.request.contextPath}/sales/workCard/";
			var confirmation = $("#confirmation").combobox('getValue');
			confirmation = confirmation.substring(0,1).toUpperCase() + confirmation.substring(1,confirmation.length);
			var flag = $("#confirmationFlag").val();//获取标识符，
			if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
				url = url + "save" + confirmation + ".action";
			}else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
				url = url + "update" + confirmation + ".action";
			}
			
			$.ajax({
				type:'POST',//post请求
				url: url,//ajax请求的url
				data: $( "#confirmationForm" ).serialize(),
				async: false,//同步请求
				cache: false,//不缓存此页面
				success: function(data){//请求成功后的回调函数。data：服务器返回数据。
					if (data != null && data != ""){
						if (data.success){
							if (flag == 'add'){
								$("#confirmationFlag").val('update');
								$("#confirmation").combobox('disable');
								$("#confirmationId").val(data.row.id);
								var sequence = $("#confirmationSequence").val();
								$("#subsidiaryConfirmationA" + sequence).html("修改");
								$("#subsidiaryConfirmationA" + sequence).attr('onclick','editConfirmation("' + data.row.salWorkCardSubsidiaryId + '","' + data.row.confirmation + '","' + sequence + '")');
								$("#subsidiaryConfirmationA" + sequence).parent().append("<image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;' onclick='deleteConfirmation(\""+data.row.salWorkCardSubsidiaryId + "\",\"" + data.row.confirmation +  "\",\"" + sequence +"\")'>");
								$("#confirmationDialog").dialog({//加载一个dialog
									title:'修改做货确认单'//该dialog的标题
								});
							}
							showMessager("提示","保存成功");
						}else{
							showErrorMessager("保存失败", data.message);
						}
					}
				}
			});
		}
	}
	
	
	
	//修改做货确认单
	/**
	 * @param workCardSubsidiaryId 做货确认单的关联的工咭项次的id
	 * @param confirmation 做货确认单的类型
	 * @param sequence项次
	 */
	function editConfirmation(workCardSubsidiaryId,confirmation,sequence){
		$("#salWorkCardSubsidiaryId").val(workCardSubsidiaryId);//是为了combobox在更改模板时通过这个值去获取信息
		var confirmation2 = confirmation.substring(0,1).toUpperCase() + confirmation.substring(1,confirmation.length);
		var url = "${pageContext.request.contextPath}/sales/workCard/find"+confirmation2+"ByWorkCardSubsidiaryId.action";
		$.ajax({
			type:'POST',//post请求
			url: url,//ajax请求的url
			data: {workCardSubsidiaryId:workCardSubsidiaryId},
			async: true,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data != null && data != ""){
					if (data.success){
						$("#confirmationDiv").html("");
						$("#confirmationForm").form('reset');
						$("#confirmationFlag").val('update');
						$("#confirmation").combobox('clear');
						$("#confirmationSequence").val(sequence);
						$("#confirmationDialog").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:'修改做货确认单'//该dialog的标题
						});
						$("#confirmation").combobox('select',confirmation);
						$("#confirmation").combobox('disable');
						data.row.confirmation = confirmation;
						$("#confirmationForm").form('load',data.row);
						if (confirmation == 'workCardKzt'){//控制台
							if (data.row.bedplateMaterial == '其他'){
								$("#otherBedplateMaterial").textbox('enable');
							}else if (data.row.bedplateMaterial == '高密度中纤板+胡桃木皮'){
								$("input[name='bedplateMaterialColor']").removeAttr("disabled");
							}
							if (data.row.internalPartsColor == '其它色'){
								$("#internalPartsColorContent").textbox('enable');
							}
							//电源条颜色
							if (data.row.powerShellColor.split(',').length > 1){
								for(var i=0;i<data.row.powerShellColor.split(',').length;i++){
									$("input[name='powerShellColor'][value=" +"'"+ data.row.powerShellColor.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							if (data.row.powerWiring == '现场接线'){
								$("#powerWiringLength").textbox('enable');
							}
						}
						if (confirmation == 'workCardDsq'){//电视墙
							//底后门
							if (data.row.bottomBackDoor.split(',').length > 1){
								for(var i=0;i<data.row.bottomBackDoor.split(',').length;i++){
									$("input[name='bottomBackDoor'][value=" +"'"+ data.row.bottomBackDoor.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//后上盖板、后上门
							if (data.row.afterThe.split(',').length > 1){
								for(var i=0;i<data.row.afterThe.split(',').length;i++){
									$("input[name='afterThe'][value=" +"'"+ data.row.afterThe.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//电源条颜色
							if (data.row.powerShellColor.split(',').length > 1){
								for(var i=0;i<data.row.powerShellColor.split(',').length;i++){
									$("input[name='powerShellColor'][value=" +"'"+ data.row.powerShellColor.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							if (data.row.powerWiring == '现场接线'){
								$("#powerWiringLength").textbox('enable');
							}
						}
						if (confirmation == 'workCardJg3' || confirmation == 'workCardJg5'){//RKIII&RKV机柜
							if (data.row.color == '需特别处理'){
								$("#otherColor").textbox('enable');
							}
							//一、2.扎线槽
							if (data.row.wireSlot.split(',').length > 1){
								for(var i=0;i<data.row.wireSlot.split(',').length;i++){
									$("input[name='wireSlot'][value=" +"'"+ data.row.wireSlot.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							if (data.row.backDoor == '特做'){
								$("#backDoorSpeciallyMade").textbox('enable');
							}
							if (data.row.frontDoor == '特做'){
								$("#frontDoorSpeciallyMade").textbox('enable');
							}
							if (data.row.copper == '特别规格'){
								$("#specialCopper").textbox('enable');
							}
						}
						if (confirmation == 'workCardJg6'){//RKVI机柜
							if (data.row.mainColor == '其他处理'){
								$("#otherMainColor").textbox('enable');
							}
							if (data.row.frontDoorColor == '其他处理'){
								$("#otherFrontDoorColor").textbox('enable');
							}
							if(data.row.mainSuite == '特制'){
								$("#mainSuiteSpecialMade").textbox('enable');
							}
							if (data.row.backDoor == '特做'){
								$("#backDoorSpeciallyMade").textbox('enable');
							}
							if (data.row.copper == '特别规格'){
								$("#specialCopper").textbox('enable');
							}
						}
						if (confirmation == 'workCardEia'){//配件
							if (data.row.mainColor == '需特别处理'){
								$("#otherMainColor").textbox('enable');
							}
							//托码
							if (data.row.joeCode.split(',').length > 1){
								for(var i=0;i<data.row.joeCode.split(',').length;i++){
									$("input[name='joeCode'][value=" +"'"+ data.row.joeCode.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							//电源条颜色
							if (data.row.powerShellColor.split(',').length > 1){
								for(var i=0;i<data.row.powerShellColor.split(',').length;i++){
									$("input[name='powerShellColor'][value=" +"'"+ data.row.powerShellColor.split(',')[i] + "'" + "]")[0].checked = true;
								}
							}
							
							if (data.row.powerWiring == '现场接线'){
								$("#powerWiringLength").textbox('enable');
							}
						}
						if (data.row.workCardConfirmationOthers != undefined){
							for (var i=0;i<data.row.workCardConfirmationOthers.length;i++){
								$("#otherAdd").click();
								$("#otherId"+i).val(data.row.workCardConfirmationOthers[i].id);
								$("#otherSequence"+i).val(data.row.workCardConfirmationOthers[i].sequence);
								$("#otherContent"+i).textbox('setValue',data.row.workCardConfirmationOthers[i].otherContent);
								$("#otherContentQuantity"+i).textbox('setValue',data.row.workCardConfirmationOthers[i].otherContentQuantity);
								$("#otherContentRemark"+i).textbox('setValue',data.row.workCardConfirmationOthers[i].otherContentRemark);
							}
						}
					}else{
						showErrorMessager("修改失败", data.message);
					}
				}
			}
		});
	}
	
	/**
	 * 删除做货确认
	 * @param workCardSubsidiaryId 做货确认单的关联的工咭项次的id
	 * @param confirmation 做货确认单的类型
	 * @param sequence项次
	 */
	function deleteConfirmation(workCardSubsidiaryId,confirmation,sequence){
		var confirmation2 = confirmation.substring(0,1).toUpperCase() + confirmation.substring(1,confirmation.length);
		var url = "${pageContext.request.contextPath}/sales/workCard/delete"+confirmation2+"ByWorkCardSubsidiaryId.action";
		$.ajax({
			type:'POST',//post请求
			url: url,//ajax请求的url
			data: {workCardSubsidiaryId:workCardSubsidiaryId},
			async: true,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data != null && data != ""){
					if (data.success){
						showMessager("提示","删除成功");
						$("#subsidiaryConfirmationA" + sequence).parent().html('<a id="subsidiaryConfirmationA' + sequence + '" href="#" style="cursor: pointer;" onclick="addConfirmation(' + sequence + ')">新增</a>');
					}
				}
				else{
					showErrorMessager("删除失败", data.message);
				}
			}
		});
	}
  </script>
  	<!-- 增&改的dialog -->
	<div id="workCardDialog" class="easyui-dialog" style="width: 900px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#workCardBB1'">
  		<div>
			<form id="workCardForm" style="height: 100%" method="post" enctype="multipart/form-data">
	  			<input id="workCardFlag" type="hidden" value=""><!-- 用来记录是新增还是修改 -->
	  			<input id="refreshFlag" type="hidden" value=""><!-- 用来记录是新增工咭，还是生成工咭，因为是刷新不同的表 -->
	  			<input id="workCardId" type="hidden" name="id" value="">
	  			<input id="salReviewerId" type="hidden" name="salReviewerId" value="">
	  			<input id="processInstanceId" type="hidden" name="processInstanceId">
	  			<div style="width: 860px;">
	  				<div style="width: 50%;text-align: center;float: left;">
  						合同号/订单号/报价单号：<input id="workCardQuotationNo" type="text" name="quotationNo" class="easyui-textbox" style="width: 200px" data-options="required:true,missingMessage:'合同号/订单号/报价单号不能为空',validType:'checkQuotationNoFormat'">
  					</div>
  					<div style="width: 30%;text-align: center;float: left;">
  						工咭号码：<input id="workCardNo" type="text" name="workCardNo" class="easyui-textbox" style="width: 120px" data-options="required:true,missingMessage:'工咭号不能为空',validType:'checkWorkCardNoFormat'">
  					</div>
  					<div style="width: 20%;text-align: center;float: left;">
  						日期：<input id="workCardDate" type="text" name="workCardDate" class="easyui-datebox" style="width: 90px" value="<p:date/>" data-options="editable:false,readonly:true,required:true,missingMessage:'日期不能为空'">
  					</div>
	  			</div>
	  			<table cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
		  			<tr style="height: 30px">
		  				<td style="width: 4%">
		  					项次
		  				</td>
		  				<td style="width: 15%">
		  					<a class="easyui-linkbutton" plain="true" style="float: left;" data-options="iconCls:'icon-add'" onclick="addWorkCardTable()"></a>
		  					代码
		  					<a class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-remove'" onclick="delWorkCardTable()"></a>
		  				</td>
		  				<td style="width: 18%">
		  					名称
		  				</td>
		  				<td style="width: 12%">
		  					规格（外尺寸）
		  				</td>
		  				<td style="width: 4%">
		  					数量
		  				</td>
		  				<td style="width: 3%">
		  					单位
		  				</td>
		  				<td style="width: 11%">
		  					预交货期
		  				</td>
		  				<td style="width: 11%">
		  					工程<br>下资料日期
		  				</td>
		  				<td style="width: 7%">
		  					生产<br>做货周期
		  				</td>
		  				<td style="width: 6%">
		  					做货<br>确认单
		  				</td>
		  			</tr>
		  			<tr class="workCardAdd" style="height: 30px">
		  				<td style="width: 20px;">
		  					<input id="workCardSubsidiaryId0" type="hidden" name="workCardSubsidiaries[0].id" value="">
		  					<input id="workCardSubsidiarySequence0" type="hidden" name="workCardSubsidiaries[0].sequence" value="1">
		  					<input id="reviewerSubsidiaryId0" type="hidden" name="workCardSubsidiaries[0].salReviewerSubsidiaryId" value="">
		  					1
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProductCode0" name="workCardSubsidiaries[0].productCode" style="width: 100%;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'代码不能为空'">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProductName0" name="workCardSubsidiaries[0].productName" style="width: 100%;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'名称不能为空'">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProductModel0" name="workCardSubsidiaries[0].productModel" style="width: 100%;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'规格不能为空'">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryQuantity0" name="workCardSubsidiaries[0].quantity" style="width: 100%;height: 27px" class="easyui-numberbox" data-options="required:true,missingMessage:'数量不能为空'">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryUnit0" name="workCardSubsidiaries[0].unit" style="width: 100%;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'单位不能为空'">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryExpectedDeliveryDate0" name="workCardSubsidiaries[0].expectedDeliveryDate" style="width: 100%;height: 27px" class="easyui-datebox" data-options="required:true,missingMessage:'预交货期不能为空',editable:false">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryEngReleaseDataDate0" name="workCardSubsidiaries[0].engReleaseDataDate" style="width: 100%;height: 27px" class="easyui-datebox" data-options="required:true,missingMessage:'工程下资料日期不能为空',editable:false">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProPeriod0" name="workCardSubsidiaries[0].proPeriod" style="width: 100%;height: 27px" class="easyui-textbox" data-options="required:true,missingMessage:'生产做货周期不能为空'">
		  				</td>
		  				<td>
		  					<a id="subsidiaryConfirmationA0" href="#" style="cursor: pointer;" onclick="addConfirmation(0)">新增</a>
		  				</td>
		  			</tr>
	  			</table>
	  			<div style="margin-left: 20px;margin-top: 10px;margin-bottom: 10px;">
	  				<div id="fileBoxDiv">
	  					批核图：<input id="filebox" class="easyui-filebox" name="drawings" style="width:150px" data-options="accept:'application/pdf',buttonText:'选择',buttonAlign:'left',validType:'checkPDF'">
	  					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#filebox').filebox('clear');">清空</a>
	  				</div>
	  				<div id="showAttachmentDiv" style="padding-bottom: 5px;">
	  					
	  				</div>
	  			</div>
	  			
	  			
	  			<br>
	  			<table cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
	  				<tr style="height: 30px;">
	  					<td style="width: 30px;" rowspan="2">
	  						1
	  					</td>
	  					<td rowspan="2" style="width: 100px;">
	  						批核程序：
	  					</td>
	  					<td colspan="8">
	  						<input class="noRadio" type="checkbox" name="approvalProcedures" value="直接生产">直接生产
	  					</td>
	  					<td colspan="8">
	  						<input class="noRadio" type="checkbox" name="approvalProcedures" value="图纸批核才生产">图纸批核才生产
	  					</td>
	  					<td colspan="8">
	  						<input class="noRadio" type="checkbox" name="approvalProcedures" value="样板批核才生产">
	  						样板批核才生产（交
	  						<input id="approvalProceduresContent1" class="easyui-textbox" name="approvalProceduresContent1" style="width: 40px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
	  						套样板）
	  					</td>
	  				</tr>
	  				<tr style="height: 30px">
	  					<td colspan="24">
	  						<input class="noRadio" type="checkbox" name="approvalProcedures" value="其他">项&nbsp;
	  						<input id="approvalProceduresContent2" class="easyui-textbox"  name="approvalProceduresContent2" style="width: 100px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
	  						&nbsp;直接生产;项&nbsp;
	  						<input id="approvalProceduresContent3" class="easyui-textbox"  name="approvalProceduresContent3" style="width: 100px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
	  						&nbsp;图纸批核才生产
  						</td>
	  				</tr>
	  				<tr style="height: 30px">
		  				<td>
	  						2
	  					</td>
	  					<td>
	  						质检留意事项：
	  					</td>
	  					<td colspan="24">
	  						<input class="easyui-textbox" name="qcAttentionMatters" style="width: 100%;height: 27px;">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						3
	  					</td>
	  					<td>
	  						外发加工 ： 
	  					</td>
	  					<td colspan="14">
	  						<input class="easyui-textbox" name="outwardProcessing" style="width: 100%;height: 27px;">
	  					</td>
	  					<td>
	  						4
	  					</td>
	  					<td colspan="9">
	  						厂内构制后特殊检查 
	  						<input type="checkbox" name="specialInspection" checked="checked" value="true">是    
	  						<input type="checkbox" name="specialInspection" value="false">否
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						5
	  					</td>
	  					<td>
	  						交货地点 ：
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="deliveryPlace" checked="checked" value="国内">国内/&nbsp;
	  						<input id="deliveryPlaceContent1" class="easyui-textbox" name="deliveryPlaceContent1" style="width: 90px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空'">
	  					</td>
	  					<td colspan="3">
	  						<input type="checkbox" name="deliveryPlace" value="香港">香港
	  					</td>
	  					<td colspan="15">
	  						<input type="checkbox" name="deliveryPlace" value="转送外地">转送外地：
	  						<input id="deliveryPlaceContent2" class="easyui-textbox" name="deliveryPlaceContent2" style="width: 70%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						6
	  					</td>
	  					<td>
	  						出货方式 ：
	  					</td>
	  					<td colspan="10">
	  						<input type="checkbox" name="shipmentWay" value="托运" checked="checked">托运
	  						&nbsp;
	  						<input type="checkbox" name="shipmentWay" value="厂车">厂车
	  						&nbsp;
	  						<input type="checkbox" name="shipmentWay" value="快递">快递
	  						&nbsp;
	  						<input type="checkbox" name="shipmentWay" value="专线">专线
	  					</td>
	  					<td colspan="1">
	  						7
	  					</td>
	  					<td colspan="13">
	  						合同金额 ：
	  						&nbsp;
	  						<input type="checkbox" name="contractAmount" value="大于等于50万" checked="checked">≥50万   
	  						&nbsp;
	  						<input type="checkbox" name="contractAmount" value="大于等于100万 ">≥100万   
	  						&nbsp;
	  						<input type="checkbox" name="contractAmount" value="小于50万">＜50万
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						8
	  					</td>
	  					<td>
	  						是否需派人<br>现场安装：
	  					</td>
	  					<td colspan="3">
	  						<input type="checkbox" name="sceneInstallation" value="true" checked="checked">是
	  						<div style="height: 20px;"></div>
	  						<input type="checkbox" name="sceneInstallation" value="false">否
	  					</td>
	  					<td>
	  						9
	  					</td>
	  					<td colspan="3">
	  						客户现场产品<br>组装后检查
	  					</td>
	  					<td colspan="17" style="text-align: left;">
	  						<input type="checkbox" name="assemblyAfterCheck" value="1" checked="checked">广东省内项目，请品管部派人到现场检查
							<input type="checkbox" name="assemblyAfterCheck" value="2">广东省外项目，请品管部派人到现场检查
							<div style="height: 6px;"></div>
							<input type="checkbox" name="assemblyAfterCheck" value="3">广东省外项目，请区域经理到现场检查
							<input type="checkbox" name="assemblyAfterCheck" value="4">大项目，请公司高层和区域经理到现场检查
							<div style="height: 6px;"></div>
							<input type="checkbox" name="assemblyAfterCheck" value="5">否
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						10
	  					</td>
	  					<td>
	  						包装形式 ：
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="纸箱" checked="checked">纸箱
	  					</td >
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="木箱">木箱
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="木栏">木栏
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="瓦坑纸">瓦坑纸
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						11
	  					</td>
	  					<td>
	  						是否分点送货：
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="equinoctialDelivery" value="false" checked="checked">否
	  						<input type="checkbox" name="equinoctialDelivery" value="true">是
	  					</td>
	  					<td>
	  						12
	  					</td>
	  					<td colspan="8">
	  						现场通电时间：
	  						<input class="easyui-textbox" name="sceneElectricityTime" style="width: 50%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空'">
	  					</td>
	  					<td>
	  						13
	  					</td>
	  					<td colspan="8">
	  						地板装修完毕时间：
	  						<input class="easyui-textbox" name="floorCompleteTime" style="width: 50%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空'">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						14
	  					</td>
	  					<td>
	  						<span style="font-size: 10px;">分点送货包装说明：</span>
	  					</td>
	  					<td colspan="24">
	  						<input id="equinoctialDeliveryInstructions" class="easyui-textbox" name="equinoctialDeliveryInstructions" style="height: 27px;width: 100%" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						15
	  					</td>
	  					<td>
	  						组装形式：
	  					</td>
	  					<td colspan="24" style="text-align: left;padding-left: 30px;">
	  						<input type="checkbox" name="assemblyWay" value="组装" checked="checked">组装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="assemblyWay" value="散装">散装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="assemblyWay" value="半组装">半组装
	  						<input id="assemblyWayContent1" class="easyui-textbox" name="assemblyWayContent1" style="width: 70%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">&nbsp;
	  						<br>
	  						<input type="checkbox" name="assemblyWay" value="其他">
	  						项&nbsp;
	  						<input id="assemblyWayContent2" class="easyui-textbox" name="assemblyWayContent2" style="width: 30%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">&nbsp;组装;
	  						项&nbsp;
	  						<input id="assemblyWayContent3" class="easyui-textbox" name="assemblyWayContent3" style="width: 30%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">&nbsp;散装
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						16
	  					</td>
	  					<td>
	  						配件形式：
	  					</td>
	  					<td colspan="24" style="text-align: left;padding-left: 30px;">
	  						<input type="checkbox" name="partsWay" value="独立包装" checked="checked">独立包装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="partsWay" value="装在机柜上">装在机柜上
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="partsWay" value="其他">
	  						项&nbsp;
	  						<input id="partsWayContent1" class="easyui-textbox" name="partsWayContent1" style="width: 100px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">&nbsp;独立包装;
	  						项&nbsp;
	  						<input id="partsWayContent2" class="easyui-textbox" name="partsWayContent2" style="width: 100px;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">&nbsp;装在机柜上
	  					</td>
  					</tr>
  					<tr style="height: 60px">
		  				<td>
	  						17
	  					</td>
	  					<td>
	  						备注：
	  					</td>
	  					<td colspan="24">
	  						<input class="easyui-textbox" name="remark" style="height: 100%;width: 100%" data-options="multiline:true">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						18
	  					</td>
	  					<td>
	  						附件：
	  					</td>
	  					<td colspan="9">
	  						<input class="noRadio" type="checkbox" name="attachment" value="批核图">批核图
	  						<select id="attachmentCad" class="easyui-combobox" name="attachmentCad" data-options="required:true,missingMessage:'该项不能为空',disabled:true,editable:false">   
							    <option value="已提供">已提供</option>
							    <option value="未提供">未提供</option>
							</select>
	  						CAD档
	  					</td>
	  					<td colspan="5">
	  						<input class="noRadio" type="checkbox" name="attachment" value="配件清单">配件清单
	  					</td>
	  					<td colspan="5">
	  						<input class="noRadio" type="checkbox" name="attachment" value="文字资料">文字资料
	  					</td>
	  					<td colspan="5">
	  						<input class="noRadio" type="checkbox" name="attachment" value="客方原图">客方原图
	  					</td>
  					</tr>
  					<tr style="height: 30px">
		  				<td>
	  						19
	  					</td>
	  					<td>
	  						销售尚欠资料：
	  					</td>
	  					<td colspan="24">
	  						<input class="easyui-textbox" name="saleOweData" style="width: 100%;height: 27px;">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
	  					<td colspan="5">
	  						工程项目负责人：
	  					</td>
	  					<td colspan="7">
	  						<input class="easyui-textbox" name="engLeader" style="height: 27px;;width: 100%">
	  					</td>
	  					<td colspan="7">
	  						生产做货负责人：
	  					</td>
	  					<td colspan="7">
	  						<input class="easyui-textbox" name="proLeader" style="height: 27px;width: 100%">
	  					</td>
	  				</tr>
	  				<tr style="height: 30px">
	  					<td colspan="5">
	  						工咭负责人姓名：
	  					</td>
	  					<td colspan="7">
	  						<input id="workCardLeader" class="easyui-textbox" name="workCardLeader" style="height: 27px;width: 100%" data-options="required:true,missingMessage:'该项不能为空'">
	  					</td>
	  					<td colspan="7">
	  						签    批：
	  					</td>
	  					<td colspan="7">
	  						<input class="easyui-textbox" name="signer" style="height: 27px;width: 100%" data-options="readonly:true">
	  					</td>
	  				</tr>
	  			</table>
	  		</form>
  		</div>
	</div>
	<!-- dialog上面dialog的按钮 -->
  	<div id="workCardBB1" style="text-align: center;">
  		<p:isPrivilege pid="di" mid="dia">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveWorkCard()">保存</a>
		</p:isPrivilege>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('workCardDialog')">关闭</a>
	</div>
	
	
	
	<div id="confirmationDialog" class="easyui-dialog" style="width: 900px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#confirmationBB1'">
  		<form id="confirmationForm">
  			<!-- 做货确认单那关联项的id -->
  			<input id="salWorkCardSubsidiaryId" type="hidden" name="salWorkCardSubsidiaryId" value="">
  			<input id="confirmationFlag" type="hidden" value=""><!-- 是新增还是修改 -->
  			<input id="confirmationSequence" type="hidden" value=""><!-- 在选择模板后，根据项次，获取信息，填充到模板中吗，用户保存后，将该项次的做货确认单的新增按钮更改成修改按钮 -->
  			<!-- 做货确认单的id -->
  			<input id="confirmationId" type="hidden" name="id" value="">
			做货确认单-
			<select id="confirmation" class="easyui-combobox" name="confirmation" style="width:100px;" data-options="editable:false">
	 			<option value="workCardKzt">控制台</option>
			    <option value="workCardDsq">电视墙</option>
			    <option value="workCardJg3">RKIII机柜</option>
			    <option value="workCardJg5">RKV IT机柜</option>
			    <option value="workCardJg6">RKVI机柜</option>
			    <option value="workCardEia">EIA19配件</option>
			</select>
			<div id="confirmationDiv">
				
			</div>
		</form>
  	</div>
  	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="confirmationBB1" style="text-align: center;">
  		<p:isPrivilege pid="di" mid="dia">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveConfirmation()">保存</a>
		</p:isPrivilege>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('confirmationDialog')">关闭</a>
	</div>
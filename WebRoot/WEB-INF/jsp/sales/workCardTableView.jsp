<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script type="text/javascript">
	$(function () {
		
		/* //1.批核程序
		$("input[name='approvalProcedures']").change(function(){
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
		$("input[name='deliveryPlace']").change(function(){
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
		$("input[name='equinoctialDelivery']").change(function(){
			if($(this).val() == 'true' && $(this).is(':checked')){
				$("#equinoctialDeliveryInstructions").textbox('enable');
			}else {
				$("#equinoctialDeliveryInstructions").textbox('disable');
				$("#equinoctialDeliveryInstructions").textbox('clear');
			}
		});
		
		//15.组装形式
		$("input[name='assemblyWay']").change(function(){
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
		$("input[name='partsWay']").change(function(){
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
		$("input[name='attachment']").change(function(){
			if ($(this).val() == '批核图'){
				if ($(this).is(':checked')){
					$("#attachmentCad").combobox('enable');
				}else{
					$("#attachmentCad").combobox('disable');
					$("#attachmentCad").combobox('clear');
				}
			}
		}); */
		
		//更改模板
		$("#confirmationView").combobox({
			onChange:function(){
				var confirmation = $("#confirmationView").combobox('getValue');
				if(confirmation != ""){
					$.ajax({
						type:'POST',//post请求
						url: '${pageContext.request.contextPath}/sales/workCard/' + confirmation + '.action',//ajax请求的url
						async: false,//同步请求
						cache: false,//不缓存此页面
						success: function(data){//请求成功后的回调函数。data：服务器返回数据。
							$("#confirmationDivView").html(data);
							//var sequence = $("#confirmationSequence").val();
							var salWorkCardSubsidiaryId = $("#salWorkCardSubsidiaryIdView").val();
							
							$.ajax({
								type:'POST',//post请求
								url: '${pageContext.request.contextPath}/sales/workCard/findSalWorkCardSubsidiaryById.action',//ajax请求的url
								data: {id:salWorkCardSubsidiaryId},
								async: false,//同步请求
								cache: false,//不缓存此页面
								success: function(data){//请求成功后的回调函数。data：服务器返回数据。
									data.quantity = data.quantity + data.unit;
									$("#confirmationFormView").form('load',data);
								}
							});
							/* $("#confirmationForm").form('load',{
								workCardNo:$("#workCardNo").val(),
								sequence:$("#workCardSubsidiarySequence"+sequence).val(),
								projectName:$("#workCardSubsidiaryProjectName"+sequence).val(),
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
	function addWorkCardTableForView(){
		var tempRow = $(".workCardAddView").length;
		var tr = $('<tr class="workCardAddView" style="height: 30px"></tr>');
		
		var td1 = $('<td style="width: 20px;"></td>');
		var td1Id = $('<input id="workCardSubsidiaryIdView' +tempRow + '" type="hidden" name="workCardSubsidiaries[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="workCardSubsidiarySequenceView' +tempRow + '" type="hidden" name="workCardSubsidiaries[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		var td1SalReviewerSubsidiaryId = $('<input id="reviewerSubsidiaryIdView' +tempRow + '" type="hidden" name="workCardSubsidiaries[' + tempRow + '].salReviewerSubsidiaryId" value="">');
		td1.append(td1Id);
		td1.append(td1Sequence);
		td1.append(td1SalReviewerSubsidiaryId);
		td1.append(tempRow+1);
		tr.append(td1);
		
		
		var td2 = $('<td></td>');
		var td2Content = $('<input id="workCardSubsidiaryProductCodeView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productCode" style="width: 100%;height: 27px" data-options="readonly:true">');
		td2.append(td2Content);
		tr.append(td2);
		
		var td3 = $('<td></td>');
		var td3Content = $('<input id="workCardSubsidiaryProductNameView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productName" style="width: 100%;height: 27px" data-options="readonly:true">');
		td3.append(td3Content);
		tr.append(td3);
		
		var td4 = $('<td></td>');
		var td4Content = $('<input id="workCardSubsidiaryProductModelView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productModel" style="width: 100%;height: 27px" data-options="readonly:true">');
		td4.append(td4Content);
		tr.append(td4);
		
		var td5 = $('<td></td>');
		var td5Content = $('<input id="workCardSubsidiaryQuantityView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].quantity" style="width: 100%;height: 27px" data-options="readonly:true">');
		td5.append(td5Content);
		tr.append(td5);
		
		var td6 = $('<td></td>');
		var td6Content = $('<input id="workCardSubsidiaryUnitView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].unit" style="width: 100%;height: 27px" data-options="readonly:true">');
		td6.append(td6Content);
		tr.append(td6);
		
		var td7 = $('<td></td>');
		var td7Content = $('<input id="workCardSubsidiaryExpectedDeliveryDateView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].expectedDeliveryDate" style="width: 100%;height: 27px" data-options="readonly:true,editable:false">');
		td7.append(td7Content);
		tr.append(td7);
		
		
		var td8 = $('<td></td>');
		var td8Content = $('<input id="workCardSubsidiaryEngReleaseDataDateView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].engReleaseDataDate" type="text" style="width: 100%;height: 27px" data-options="readonly:true,editable:false">');
		td8.append(td8Content);
		tr.append(td8);
		
		var td9 = $('<td></td>');
		var td9Content = $('<input id="workCardSubsidiaryProPeriodView' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].proPeriod"  style="width: 100%;height: 27px" data-options="readonly:true">');
		td9.append(td9Content);
		tr.append(td9);
		
		var td10 = $('<td></td>');
		var td10Content = $('<a id="subsidiaryConfirmationAView' +tempRow + '" href="#" style="cursor: pointer;" onclick=""></a>');
		td10.append(td10Content);
		tr.append(td10);
		
		$(".workCardAddView").last().after(tr);
		td2Content.textbox();
		td3Content.textbox();
		td4Content.textbox();
		td5Content.numberbox();
		td6Content.textbox();
		td7Content.datebox();
		td8Content.datebox();
		td9Content.textbox();
	}
	
	
	//添加一行表格
	/* function addWorkCardTable(){
		var tempRow = $(".workCardAdd").length;
		$("#firstTd").attr("rowspan",$("#firstTd").attr("rowspan")*1+1);
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
		var td2Content = $('<input id="workCardSubsidiaryProductCode' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productCode" style="width: 100%;height: 27px" data-options="readonly:true">');
		td2.append(td2Content);
		tr.append(td2);
		
		var td3 = $('<td></td>');
		var td3Content = $('<input id="workCardSubsidiaryProjectName' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].projectName" style="width: 100%;height: 27px" data-options="readonly:true">');
		td3.append(td3Content);
		tr.append(td3);
		
		var td4 = $('<td></td>');
		var td4Content = $('<input id="workCardSubsidiaryProductModel' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].productModel" style="width: 100%;height: 27px" data-options="readonly:true">');
		td4.append(td4Content);
		tr.append(td4);
		
		var td5 = $('<td></td>');
		var td5Content = $('<input id="workCardSubsidiaryQuantity' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].quantity" style="width: 100%;height: 27px" data-options="readonly:true">');
		td5.append(td5Content);
		tr.append(td5);
		
		var td6 = $('<td></td>');
		var td6Content = $('<input id="workCardSubsidiaryExpectedDeliveryDate' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].expectedDeliveryDate" style="width: 100%;height: 27px" data-options="readonly:true,editable:false">');
		td6.append(td6Content);
		tr.append(td6);
		
		
		var td7 = $('<td></td>');
		var td7Content = $('<input id="workCardSubsidiaryEngReleaseDataDate' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].engReleaseDataDate" type="text" style="width: 100%;height: 27px" data-options="readonly:true,editable:false">');
		td7.append(td7Content);
		tr.append(td7);
		
		var td8 = $('<td></td>');
		var td8Content = $('<input id="workCardSubsidiaryProPeriod' +tempRow + '" name="workCardSubsidiaries[' + tempRow + '].proPeriod"  style="width: 100%;height: 27px" data-options="readonly:true">');
		td8.append(td8Content);
		tr.append(td8);
		
		var td9 = $('<td></td>');
		var td9Content = $('<a id="subsidiaryConfirmationA' +tempRow + '" href="#" style="cursor: pointer;" onclick=""></a>');
		td9.append(td9Content);
		tr.append(td9);
		
		
		$(".workCardAdd").last().after(tr);
		td2Content.textbox();
		td3Content.textbox();
		td4Content.textbox();
		td5Content.textbox();
		td6Content.datebox();
		td7Content.datebox();
		td8Content.textbox();
	} */
	
	
	
	
	//打开查看工咭的dialog
	function viewWorkCard(){
		
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
				url:'${pageContext.request.contextPath}/sales/workCard/findSalWorkCardByIdForView.action',
				data:data,
				success:function(data){
					if (data != null && data != ""){
						if (data.success){
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
						}else{
							showErrorMessager("查看失败", data.message);
						}
					}
				}
			});
		}else{
			showMessager("提示","请选择一条记录进行修改");
		}
	}
	
	
	
	
	
	
	
	
	//查看做货确认单
	/**
	 * @param workCardSubsidiaryId 做货确认单的关联的工咭项次的id
	 * @param confirmation 做货确认单的类型
	 */
	function viewConfirmation(workCardSubsidiaryId,confirmation,sequence){
		$("#salWorkCardSubsidiaryIdView").val(workCardSubsidiaryId);//是为了combobox在更改模板时通过这个值去获取信息
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
						$("#confirmationDivView").html("");
						$("#confirmationFormView").form('reset');
						$("#confirmationView").combobox('clear');
						$("#confirmationSequenceView").val(sequence);
						$("#confirmationViewDialog").dialog({//加载一个dialog
							closed:false,//将该dialog的状态由不显示改成显示
							title:'查看做货确认单'//该dialog的标题
						});
						$("#confirmationView").combobox('select',confirmation + "View");
						$("#confirmationView").combobox('disable');
						data.row.confirmation = confirmation + "View";
						$("#confirmationFormView").form('load',data.row);
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
						showMessager("错误",'<font color="red">' + data.message + '<font/>');
					}
				}
			}
		});
	}
  </script>
  	<!-- 增&改的dialog -->
	<div id="workCardViewDialog" class="easyui-dialog" style="width: 900px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#workCardBBView1'">
  		<div>
			<form id="workCardFormView" style="height: 100%" method="post" enctype="multipart/form-data">
	  			<!-- <input id="workCardFlag" type="hidden" value="">用来记录是新增还是修改
	  			<input id="refreshFlag" type="hidden" value="">用来记录是新增工咭，还是生成工咭，因为是刷新不同的表
	  			<input id="workCardId" type="hidden" name="id" value="">
	  			<input id="salReviewerId" type="hidden" name="salReviewerId" value="">
	  			<input id="processInstanceId" type="hidden" name="processInstanceId"> -->
	  			<div style="width: 860px;height: 30px;line-height: 30px">
	  				<div style="width: 50%;text-align: center;float: left;">
  						合同号/订单号/报价单号：<input id="workCardQuotationNoView" type="text" name="quotationNo" class="easyui-textbox" style="width: 200px" data-options="readonly:true">
  					</div>
  					<div style="width: 30%;text-align: center;float: left;">
  						工咭号码：<input id="workCardNoView" type="text" name="workCardNo" class="easyui-textbox" style="width: 120px" data-options="readonly:true">
  					</div>
  					<div style="width: 20%;text-align: center;float: left;">
  						日期：<input id="workCardDateView" type="text" name="workCardDate" class="easyui-datebox" style="width: 90px" value="<p:date/>" data-options="editable:false,readonly:true">
  					</div>
	  			</div>
	  			<table cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
		  			<tr style="height: 30px">
		  				<td style="width: 4%">
		  					项次
		  				</td>
		  				<td style="width: 15%">
		  					代码
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
		  			<tr class="workCardAddView" style="height: 30px">
		  				<td style="width: 20px;">
		  					<input id="workCardSubsidiaryIdView0" type="hidden" name="workCardSubsidiaries[0].id" value="">
		  					<input id="workCardSubsidiarySequenceView0" type="hidden" name="workCardSubsidiaries[0].sequence" value="1">
		  					<input id="reviewerSubsidiaryIdView0" type="hidden" name="workCardSubsidiaries[0].salReviewerSubsidiaryId" value="">
		  					1
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProductCodeView0" name="workCardSubsidiaries[0].productCode" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProductNameView0" name="workCardSubsidiaries[0].productName" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProductModelView0" name="workCardSubsidiaries[0].productModel" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryQuantityView0" name="workCardSubsidiaries[0].quantity" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryUnitView0" name="workCardSubsidiaries[0].unit" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryExpectedDeliveryDateView0" name="workCardSubsidiaries[0].expectedDeliveryDate" style="width: 100%;height: 27px" class="easyui-datebox" data-options="readonly:true,editable:false">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryEngReleaseDataDateView0" name="workCardSubsidiaries[0].engReleaseDataDate" style="width: 100%;height: 27px" class="easyui-datebox" data-options="readonly:true,editable:false">
		  				</td>
		  				<td>
		  					<input id="workCardSubsidiaryProPeriodView0" name="workCardSubsidiaries[0].proPeriod" style="width: 100%;height: 27px" class="easyui-textbox" data-options="readonly:true">
		  				</td>
		  				<td>
		  					<a id="subsidiaryConfirmationAView0" href="#" style="cursor: pointer;" onclick=""></a>
		  				</td>
		  			</tr>
	  			</table>
	  			<div style="margin-left: 20px;margin-top: 10px;margin-bottom: 10px;">
	  				<div id="fileBoxDivView" style="float: left;">
	  					批核图：
	  				</div>
	  				<div id="showAttachmentDivView" style="padding-bottom: 5px;">
	  					
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
	  						<input class="noRadio" type="checkbox" name="approvalProceduresView" value="直接生产" onclick="return false">直接生产
	  					</td>
	  					<td colspan="8">
	  						<input class="noRadio" type="checkbox" name="approvalProceduresView" value="图纸批核才生产" onclick="return false">图纸批核才生产
	  					</td>
	  					<td colspan="8">
	  						<input class="noRadio" type="checkbox" name="approvalProceduresView" value="样板批核才生产" onclick="return false">
	  						样板批核才生产（交
	  						<input id="approvalProceduresContentView1" class="easyui-textbox" name="approvalProceduresContent1" style="width: 40px;height: 27px;" data-options="readonly:true,disabled:true">
	  						套样板）
	  					</td>
	  				</tr>
	  				<tr style="height: 30px">
	  					<td colspan="24">
	  						<input class="noRadio" type="checkbox" name="approvalProceduresView" value="其他" onclick="return false">项&nbsp;
	  						<input id="approvalProceduresContentView2" class="easyui-textbox"  name="approvalProceduresContent2" style="width: 100px;height: 27px;" data-options="readonly:true,disabled:true">
	  						&nbsp;直接生产;项&nbsp;
	  						<input id="approvalProceduresContentView3" class="easyui-textbox"  name="approvalProceduresContent3" style="width: 100px;height: 27px;" data-options="readonly:true,disabled:true">
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
	  						<input class="easyui-textbox" name="qcAttentionMatters" style="width: 100%;height: 27px;" data-options="readonly:true">
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
	  						<input class="easyui-textbox" name="outwardProcessing" style="width: 100%;height: 27px;" data-options="readonly:true">
	  					</td>
	  					<td>
	  						4
	  					</td>
	  					<td colspan="9">
	  						厂内构制后特殊检查 
	  						<input type="checkbox" name="specialInspection" checked="checked" value="true" onclick="return false">是    
	  						<input type="checkbox" name="specialInspection" value="false" onclick="return false">否
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
	  						<input type="checkbox" name="deliveryPlace" checked="checked" value="国内" onclick="return false">国内/&nbsp;
	  						<input id="deliveryPlaceContentView1" class="easyui-textbox" name="deliveryPlaceContent1" style="width: 90px;height: 27px;" data-options="readonly:true">
	  					</td>
	  					<td colspan="3">
	  						<input type="checkbox" name="deliveryPlace" value="香港" onclick="return false">香港
	  					</td>
	  					<td colspan="15">
	  						<input type="checkbox" name="deliveryPlace" value="转送外地" onclick="return false">转送外地：
	  						<input id="deliveryPlaceContentView2" class="easyui-textbox" name="deliveryPlaceContent2" style="width: 70%;height: 27px;" data-options="readonly:true,disabled:true">
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
	  						<input type="checkbox" name="shipmentWay" value="托运" checked="checked" onclick="return false">托运
	  						&nbsp;
	  						<input type="checkbox" name="shipmentWay" value="厂车" onclick="return false">厂车
	  						&nbsp;
	  						<input type="checkbox" name="shipmentWay" value="快递" onclick="return false">快递
	  						&nbsp;
	  						<input type="checkbox" name="shipmentWay" value="专线" onclick="return false">专线
	  					</td>
	  					<td colspan="1">
	  						7
	  					</td>
	  					<td colspan="13">
	  						合同金额 ：
	  						&nbsp;
	  						<input type="checkbox" name="contractAmount" value="大于等于50万" checked="checked" onclick="return false">≥50万   
	  						&nbsp;
	  						<input type="checkbox" name="contractAmount" value="大于等于100万 " onclick="return false">≥100万   
	  						&nbsp;
	  						<input type="checkbox" name="contractAmount" value="小于50万" onclick="return false">＜50万
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
	  						<input type="checkbox" name="sceneInstallation" value="true" checked="checked" onclick="return false">是
	  						<div style="height: 20px;"></div>
	  						<input type="checkbox" name="sceneInstallation" value="false" onclick="return false">否
	  					</td>
	  					<td>
	  						9
	  					</td>
	  					<td colspan="3">
	  						客户现场产品<br>组装后检查
	  					</td>
	  					<td colspan="17" style="text-align: left;">
	  						<input type="checkbox" name="assemblyAfterCheck" value="1" checked="checked" onclick="return false">广东省内项目，请品管部派人到现场检查
							<input type="checkbox" name="assemblyAfterCheck" value="2" onclick="return false">广东省外项目，请品管部派人到现场检查
							<div style="height: 6px;"></div>
							<input type="checkbox" name="assemblyAfterCheck" value="3" onclick="return false">广东省外项目，请区域经理到现场检查
							<input type="checkbox" name="assemblyAfterCheck" value="4" onclick="return false">大项目，请公司高层和区域经理到现场检查
							<div style="height: 6px;"></div>
							<input type="checkbox" name="assemblyAfterCheck" value="5" onclick="return false">否
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
	  						<input type="checkbox" name="packaging" value="纸箱" checked="checked" onclick="return false">纸箱
	  					</td >
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="木箱" onclick="return false">木箱
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="木栏" onclick="return false">木栏
	  					</td>
	  					<td colspan="6">
	  						<input type="checkbox" name="packaging" value="瓦坑纸" onclick="return false">瓦坑纸
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
	  						<input type="checkbox" name="equinoctialDelivery" value="false" checked="checked" onclick="return false">否
	  						<input type="checkbox" name="equinoctialDelivery" value="true" onclick="return false">是
	  					</td>
	  					<td>
	  						12
	  					</td>
	  					<td colspan="8">
	  						现场通电时间：
	  						<input class="easyui-textbox" name="sceneElectricityTime" style="width: 50%;height: 27px;" data-options="readonly:true">
	  					</td>
	  					<td>
	  						13
	  					</td>
	  					<td colspan="8">
	  						地板装修完毕时间：
	  						<input class="easyui-textbox" name="floorCompleteTime" style="width: 50%;height: 27px;" data-options="readonly:true">
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
	  						<input id="equinoctialDeliveryInstructionsView" class="easyui-textbox" name="equinoctialDeliveryInstructions" style="height: 27px;width: 100%" data-options="readonly:true,disabled:true">
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
	  						<input type="checkbox" name="assemblyWay" value="组装" checked="checked" onclick="return false">组装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="assemblyWay" value="散装" onclick="return false">散装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="assemblyWay" value="半组装" onclick="return false">半组装
	  						<input id="assemblyWayContentView1" class="easyui-textbox" name="assemblyWayContent1" style="width: 70%;height: 27px;" data-options="readonly:true,disabled:true">&nbsp;
	  						<br>
	  						<input type="checkbox" name="assemblyWay" value="其他" onclick="return false">
	  						项&nbsp;
	  						<input id="assemblyWayContentView2" class="easyui-textbox" name="assemblyWayContent2" style="width: 30%;height: 27px;" data-options="readonly:true,disabled:true">&nbsp;组装;
	  						项&nbsp;
	  						<input id="assemblyWayContentView3" class="easyui-textbox" name="assemblyWayContent3" style="width: 30%;height: 27px;" data-options="readonly:true,disabled:true">&nbsp;散装
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
	  						<input type="checkbox" name="partsWay" value="独立包装" checked="checked" onclick="return false">独立包装
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="partsWay" value="装在机柜上" onclick="return false">装在机柜上
	  						&nbsp;&nbsp;&nbsp;
	  						<input type="checkbox" name="partsWay" value="其他" onclick="return false">
	  						项&nbsp;
	  						<input id="partsWayContentView1" class="easyui-textbox" name="partsWayContent1" style="width: 100px;height: 27px;" data-options="readonly:true,disabled:true">&nbsp;独立包装;
	  						项&nbsp;
	  						<input id="partsWayContentView2" class="easyui-textbox" name="partsWayContent2" style="width: 100px;height: 27px;" data-options="readonly:true,disabled:true">&nbsp;装在机柜上
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
	  						<input class="easyui-textbox" name="remark" style="height: 100%;width: 100%" data-options="multiline:true,readonly:true">
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
	  						<input class="noRadio" type="checkbox" name="attachmentView" value="批核图" onclick="return false">批核图
	  						<select id="attachmentCadView" class="easyui-combobox" name="attachmentCad" data-options="readonly:true">   
							    <option value="已提供">已提供</option>
							    <option value="未提供">未提供</option>
							</select>
	  						CAD档
	  					</td>
	  					<td colspan="5">
	  						<input class="noRadio" type="checkbox" name="attachmentView" value="配件清单" onclick="return false">配件清单
	  					</td>
	  					<td colspan="5">
	  						<input class="noRadio" type="checkbox" name="attachmentView" value="文字资料" onclick="return false">文字资料
	  					</td>
	  					<td colspan="5">
	  						<input class="noRadio" type="checkbox" name="attachmentView" value="客方原图" onclick="return false">客方原图
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
	  						<input class="easyui-textbox" name="saleOweData" style="width: 100%;height: 27px;" data-options="readonly:true">
	  					</td>
  					</tr>
  					<tr style="height: 30px">
	  					<td colspan="5">
	  						工程项目负责人：
	  					</td>
	  					<td colspan="7">
	  						<input class="easyui-textbox" name="engLeader" style="height: 27px;;width: 100%" data-options="readonly:true">
	  					</td>
	  					<td colspan="7">
	  						生产做货负责人：
	  					</td>
	  					<td colspan="7">
	  						<input class="easyui-textbox" name="proLeader" style="height: 27px;width: 100%" data-options="readonly:true">
	  					</td>
	  				</tr>
	  				<tr style="height: 30px">
	  					<td colspan="5">
	  						工咭负责人姓名：
	  					</td>
	  					<td colspan="7">
	  						<input id="workCardLeader" class="easyui-textbox" name="workCardLeader" style="height: 27px;width: 100%" data-options="readonly:true">
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
  	<div id="workCardBBView1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('workCardViewDialog')">关闭</a>
	</div>
	
	
	
	<div id="confirmationViewDialog" class="easyui-dialog" style="width: 900px;height: 100%;text-align: center;"
  	data-options="closed:true,draggable:true,top:0,modal:true,buttons:'#confirmationBBView1'">
  		<form id="confirmationFormView">
  			<!-- 做货确认单那关联项的id -->
  			<input id="salWorkCardSubsidiaryIdView" type="hidden" name="salWorkCardSubsidiaryId" value="">
  			<input id="confirmationSequenceView" type="hidden" value=""><!-- 在选择模板后，根据项次，获取信息，填充到模板中吗，用户保存后，将该项次的做货确认单的新增按钮更改成修改按钮 -->
  			<!-- 做货确认单的id -->
  			<input id="confirmationIdView" type="hidden" name="id" value="">
			做货确认单-
			<select id="confirmationView" class="easyui-combobox" name="confirmation" style="width:100px;" data-options="editable:false">
	 			<option value="workCardKztView">控制台</option>
			    <option value="workCardDsqView">电视墙</option>
			    <option value="workCardJg3View">RKIII机柜</option>
			    <option value="workCardJg5View">RKV IT机柜</option>
			    <option value="workCardJg6View">RKVI机柜</option>
			    <option value="workCardEiaView">EIA19配件</option>
			</select>
			<div id="confirmationDivView">
				
			</div>
		</form>
  	</div>
  	
  	<!-- dialog上面dialog的按钮 -->
  	<div id="confirmationBBView1" style="text-align: center;">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('confirmationViewDialog')">关闭</a>
	</div>
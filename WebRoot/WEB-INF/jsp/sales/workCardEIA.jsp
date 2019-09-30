<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	$(function () {
		$(".easyui-textbox").textbox();
		$(".easyui-linkbutton").linkbutton();
		
		//checkbox单选
		$("input[type='checkbox'][class!='noRadio']").click(function(){
			var name = $(this).attr("name");
			var value = $(this).val();
			$("input[name='"+name+"']").each(function(index,domEle){
				if (value != $(domEle).val()){
					$(domEle).attr("checked",false);
				}
			});
		});
		
		//自选配件
		$("input[name='mainColor']").click(function(){
			if($(this).val() == '需特别处理' && $(this).is(':checked')){
				$("#otherMainColor").textbox('enable');
			}else{
				$("#otherMainColor").textbox('disable');
				$("#otherMainColor").textbox('clear');
			}
		});
		//电器类
		$("input[name='powerWiring']").click(function(){
			if($(this).val() == '现场接线' && $(this).is(':checked')){
				$("#powerWiringLength").textbox('enable');
			}else{
				$("#powerWiringLength").textbox('disable');
				$("#powerWiringLength").textbox('clear');
			}
		});
	});
	
	
	//控制台做货确认单添加其他的表格
	function addEIATable(obj){
		var trs = $(obj).parent().parent().parent().children("tr");
		var tempRow = $(".eiaAdd").length;
		var tr = $('<tr class="eiaAdd" style="height: 30px;"></tr>');
		
		var td1 = $('<td colspan="3"></td>');
		var td1Id = $('<input id="otherId' +tempRow + '" type="hidden" name="workCardConfirmationOthers[' + tempRow + '].id" value="">');
		var td1Sequence = $('<input id="otherSequence' +tempRow + '" type="hidden" name="workCardConfirmationOthers[' + tempRow + '].sequence" value="' + (tempRow+1) + '">');
		td1.append(td1Id);
		td1.append(td1Sequence);
		tr.append(td1);
		
		var td2 = $('<td colspan="3"></td>');
		tr.append(td2);
		
		var td3 = $('<td colspan="54"></td>');
		var td3Content = $('<input id="otherContent' + tempRow + '" class="easyui-textbox" name="workCardConfirmationOthers[' + tempRow + '].otherContent" style="width: 100%;height: 100%" data-options="required:true,missingMessage:\'该项不能为空\'">');
		td3.append(td3Content);
		tr.append(td3);
		
		var td4 = $('<td colspan="13"></td>');
		var td4Content = $('<input id="otherContentQuantity' + tempRow + '" class="easyui-textbox" name="workCardConfirmationOthers[' + tempRow + '].otherContentQuantity" style="width: 60px;" data-options="required:true,missingMessage:\'该项不能为空\'">');
		td4.append(td4Content);
		tr.append(td4);
		
		var td5 = $('<td colspan="13"></td>');
		var td5Content = $('<input id="otherContentRemark' + tempRow + '" class="easyui-textbox" name="workCardConfirmationOthers[' + tempRow + '].otherContentRemark" style="width: 100%;height: 100%">');
		td5.append(td5Content);
		tr.append(td5);
		
		trs.last().after(tr);
		td3Content.textbox();
		td4Content.textbox();
		td5Content.textbox();
	}
	
	function delEIATable(obj){
		var tempRow = $(".eiaAdd").length;
		if (tempRow > 0){
			$(".eiaAdd").last().remove();
		}
	}
  </script>
	
	<!-- 增&改的dialog -->
	<table cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
		<tr style="height: 30px;">
			<td colspan="86">
				<div style="width:60%;text-align: left;float: left;font-size: 14px;font-weight: bold;">
					工咭號碼﹕<input id="confirmationWorkCardNo" class="easyui-textbox" name="workCardNo" style="height: 27px;width: 100px;" data-options="readonly:true">
				</div>
				<div style="width:40%;text-align: left;float: left;font-size: 14px;font-weight: bold;">
					第<input id="confirmationSequence" class="easyui-textbox" name="sequence" style="height: 27px;width: 50px;" data-options="readonly:true">项
				</div>
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;font-weight: bold;text-align: left;">
				自选配件（工咭总数量）：   
			</td>
			<td colspan="13">
				 備註
			</td>
		</tr>
  		<tr style="height: 30px;">
  			<td colspan="86" style="font-size: 14px;text-align: left;">
				<input type="checkbox" name="mainColor" value="标准（EL343Z浅灰粉）">标准（EL343Z浅灰粉）
				<input type="checkbox" name="mainColor" value="标准（TM-0320黑色粉）">标准（TM-0320黑色粉）
  				<br>
				<input type="checkbox" name="mainColor" value="需特别处理"> 需特别处理：<input id="otherMainColor" class="easyui-textbox" name="otherMainColor" style="height: 27px;width: 85%" data-options="disabled:true,required:true,missingMessage:'该项不能为空'">
			</td>
  		</tr>
  		<tr style="height: 30px;">
  			<td colspan="86" style="font-size: 14px;text-align: left;font-weight: bold;">
  				前封板
  			</td>
  		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
				
			</td>
			<td colspan="3" style="font-size: 14px">
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<input id="sealPlate1" class="easyui-textbox" name="sealPlate1" style="height: 27px;width: 50px;">U封板（
				<input type="checkbox" name="sealPlate1Content" value="空白有唛头">空白有唛头/  
				<input type="checkbox" name="sealPlate1Content" value="空白无唛头">空白无唛头/  
				<input type="checkbox" name="sealPlate1Content" value="带散风孔">带散风孔 
				）*封板标准为带唛头
			</td>
			<td colspan="13">
				<input id="sp1Quantity" class="easyui-textbox" name="sp1Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="sp1Remark" class="easyui-textbox" name="sp1Remark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<input id="sealPlate2" class="easyui-textbox" name="sealPlate2" style="height: 27px;width: 50px;">U封板（
				<input type="checkbox" name="sealPlate2Content" value="空白有唛头">空白有唛头/  
				<input type="checkbox" name="sealPlate2Content" value="空白无唛头">空白无唛头/  
				<input type="checkbox" name="sealPlate2Content" value="带散风孔">带散风孔 
				）*封板标准为带唛头
			</td>
			<td colspan="13">
				<input id="sp2Quantity" class="easyui-textbox" name="sp2Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="sp2Remark" class="easyui-textbox" name="sp2Remark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<input id="sealPlate3" class="easyui-textbox" name="sealPlate3" style="height: 27px;width: 50px;">U封板（
				<input type="checkbox" name="sealPlate3Content" value="空白有唛头">空白有唛头/  
				<input type="checkbox" name="sealPlate3Content" value="空白无唛头">空白无唛头/  
				<input type="checkbox" name="sealPlate3Content" value="带散风孔">带散风孔 
				）*封板标准为带唛头
			</td>
			<td colspan="13">
				<input id="sp3Quantity" class="easyui-textbox" name="sp3Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="sp3Remark" class="easyui-textbox" name="sp3Remark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
					
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				2U帶燈面板 - 包灯管，连 1.5米线及(
				<input type="checkbox" name="tubePlug" value="13 Amp"> 13 Amp / 
				<input type="checkbox" name="tubePlug" value="10A三扁脚"> 10A三扁脚
				)* 插头  
			</td>
			<td colspan="13">
				<input id="tpQuantity" class="easyui-textbox" name="tpQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="tpRemark" class="easyui-textbox" name="tpRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				5)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				1U卡扣封板（快捷无螺丝装拆 ）*卡扣上带唛头（无散气）
			</td>
			<td colspan="13"><!--Card buckle -->
				<input id="cbQuantity" class="easyui-textbox" name="cbQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="cbRemark" class="easyui-textbox" name="cbRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
 		<tr style="height: 30px;">
  			<td colspan="86" style="font-size: 14px;text-align: left;font-weight: bold;">
  				托板
  			</td>
  		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				托码（
				<input class="noRadio" type="checkbox" name="joeCode" value="330D">330D
				<input class="noRadio" type="checkbox" name="joeCode" value="450D">450D
				<input class="noRadio" type="checkbox" name="joeCode" value="620D">620D
				）*
			</td>
			<td colspan="13">
				<input id="jcQuantity" class="easyui-textbox" name="jcQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">对
			</td>
			<td colspan="13">
				<input id="jcRemark" class="easyui-textbox" name="jcRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				450D层板(  
				<input type="checkbox" name="layerBoard450" value="RK3用">RK3用  /   
				<input type="checkbox" name="layerBoard450" value="RK5用">RK5用  /  
				<input type="checkbox" name="layerBoard450" value="RK6用">RK6用）
			</td>
			<td colspan="13">
				<input id="lb450Quantity" class="easyui-textbox" name="lb450Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="lb450Remark" class="easyui-textbox" name="lb450Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				620D层板(  
				<input type="checkbox" name="layerBoard620" value="RK3用">RK3用  /   
				<input type="checkbox" name="layerBoard620" value="RK5用">RK5用  /  
				<input type="checkbox" name="layerBoard620" value="RK6用">RK6用）
			</td>
			<td colspan="13">
				<input id="lb620Quantity" class="easyui-textbox" name="lb620Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="lb620Remark" class="easyui-textbox" name="lb620Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				18"D托盆<input id="tray1" class="easyui-textbox" name="tray1" style="height: 27px;width: 50px;">U肶
			</td>
			<td colspan="13">
				<input id="t1Quantity" class="easyui-textbox" name="t1Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="t1Remark" class="easyui-textbox" name="t1Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				18"D托盆<input id="tray2" class="easyui-textbox" name="tray2" style="height: 27px;width: 50px;">U肶
			</td>
			<td colspan="13">
				<input id="t2Quantity" class="easyui-textbox" name="t2Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="t2Remark" class="easyui-textbox" name="t2Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				5)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				18"D活动盆 - 配18"路轨
			</td>
			<td colspan="13"><!-- activity basin -->
				<input id="ab1Quantity" class="easyui-textbox" name="ab1Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="ab1Remark" class="easyui-textbox" name="ab1Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				21"D活动盆 - 配26"路轨
			</td>
			<td colspan="13"><!-- activity basin -->
				<input id="ab2Quantity" class="easyui-textbox" name="ab2Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="ab2Remark" class="easyui-textbox" name="ab2Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
  		<tr style="height: 30px;">
			<td colspan="3">
 			
 			</td>
 			<td colspan="3" style="font-size: 14px">
 				6)
 			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
 				VTR活动盆(
				<input type="checkbox" name="vtrActivityBasin1" value="6U">6U  / 
				<input type="checkbox" name="vtrActivityBasin1" value="5U">5U 
				) - (
				<input type="checkbox" name="vtrActivityBasin2" value="无抽桶">无抽桶   或    
				<input type="checkbox" name="vtrActivityBasin2" value="有抽桶">有抽桶
				)*
 			</td>
 			<td colspan="13" >
 				<input id="vabQuantity" class="easyui-textbox" name="vabQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
 			</td>
 			<td colspan="13">
 				<input id="vabRemark" class="easyui-textbox" name="vabRemark" style="height: 27px;width: 100%;">
 			</td>
 		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				7)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				LCD活动盆－2U（
				<input type="checkbox" name="lcdActivityBasin" value="配键盘">配键盘　　
				<input type="checkbox" name="lcdActivityBasin" value="不配键盘">不配键盘
				）
			</td>
			<td colspan="13">
				<input id="labQuantity" class="easyui-textbox" name="labQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="labRemark" class="easyui-textbox" name="labRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				8)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				键盘盆<配滑鼠板> -（ 
				<input type="checkbox" name="keyboardBasin" value="1U">1U /  
				<input type="checkbox" name="keyboardBasin" value="2U">2U ）*
			</td>
			<td colspan="13">
				<input id="kbQuantity" class="easyui-textbox" name="kbQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="kbRemark" class="easyui-textbox" name="kbRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				9)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				封闭式抽桶 - （ 
				<input type="checkbox" name="closePumpBarrel" value="2U">2U  /  
				<input type="checkbox" name="closePumpBarrel" value="3U">3U  /  
				<input type="checkbox" name="closePumpBarrel" value="4U">4U
				）*
			</td>
			<td colspan="13">
				<input id="cpbQuantity" class="easyui-textbox" name="cpbQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="cpbRemark" class="easyui-textbox" name="cpbRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				10)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				开放式抽桶 - （ 
				<input type="checkbox" name="openPumpBarrel" value="2U">2U  /  
				<input type="checkbox" name="openPumpBarrel" value="3U">3U  /  
				<input type="checkbox" name="openPumpBarrel" value="4U">4U
				）*
			</td>
			<td colspan="13">
				<input id="opbQuantity" class="easyui-textbox" name="opbQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="opbRemark" class="easyui-textbox" name="opbRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
 		<tr style="height: 30px;">
  			<td colspan="86" style="font-size: 14px;text-align: left;font-weight: bold;">
  					布线设备
  			</td>
  		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				伸缩扎线条<span style="color: red;">（需注明收在哪里）</span>
			</td>
			<td colspan="13"><!-- Tie Line -->
				<input id="tlQuantity" class="easyui-textbox" name="tlQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="tlRemark" class="easyui-textbox" name="tlRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				半U扎线杆
			</td>
			<td colspan="13" ><!-- Tie Rod -->
				<input id="trQuantity" class="easyui-textbox" name="trQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="trRemark" class="easyui-textbox" name="trRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				1U扎线面板
			</td>
			<td colspan="13" ><!-- tie Line Panel -->
				<input id="tlpQuantity" class="easyui-textbox" name="tlpQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="tlpRemark" class="easyui-textbox" name="tlpRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				1U线槽面板（双面塑胶线槽）
			</td>
			<td colspan="13" ><!-- wire slot panel -->
				<input id="wspQuantity" class="easyui-textbox" name="wspQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="wspRemark" class="easyui-textbox" name="wspRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
 			<td colspan="86" style="font-size: 14px;text-align: left;font-weight: bold;">
 				电器类
 			</td>
 		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
				
			</td>
			<td colspan="3" style="font-size: 14px">
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<input type="checkbox" name="powerBrand" value="克莱沃">克莱沃
				<input type="checkbox" name="powerBrand" value="胜威南方">胜威南方<br>
				电源条-位数：
				<input type="checkbox" name="powerDigits" value="6位">6位/ 
				<input type="checkbox" name="powerDigits" value="12位">12位/ 
				<input type="checkbox" name="powerDigits" value="18位">18位（内部可最大承载电流：6位≤16A，12位、18位≤32A）
				*壳体颜色：
				<input class="noRadio" type="checkbox" name="powerShellColor" value="黑色">黑色 / 
				<input class="noRadio" type="checkbox" name="powerShellColor" value="白色">白色<br>
				插座形式：
				<input type="checkbox" name="powerSocketWay" value="10A万能孔插座">10A万能孔插座 / 
				<input type="checkbox" name="powerSocketWay" value="10A三扁脚插座">10A三扁脚插座<br>
				电源线：(
				<input type="checkbox" name="powerCord" value="10A">10A / 
				<input type="checkbox" name="powerCord" value="16A">16A / 
				<input type="checkbox" name="powerCord" value="25A">25A / 
				<input type="checkbox" name="powerCord" value="32A">32A
				)*(
				<input type="checkbox" name="powerWiring" value="不配线">不配线/
				<input type="checkbox" name="powerWiring" value="连2米线">连2米线 / 
				<input type="checkbox" name="powerWiring" value="现场接线">现场接线，需线缆总数
				<input id="powerWiringLength" class="easyui-textbox" name="powerWiringLength" style="width: 50px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">米
				)；<br>
				插　头：
				<input type="checkbox" name="powerPlug" value="10A三扁脚插头">配10A三扁脚插头 / 
				<input type="checkbox" name="powerPlug" value="16A三扁脚插头">16A三扁脚插头 /
				<input type="checkbox" name="powerPlug" value="不配插头">不配插头。<br>
			</td>
			<td colspan="13">
				<input id="pQuantity" class="easyui-textbox" name="pQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="pRemark" class="easyui-textbox" name="pRemark" style="height: 100%;width: 100%;" data-options="multiline:true">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				特别定制电源条（附规格确认资料），代码：<input id="otherPower" class="easyui-textbox" name="otherPower" style="width: 250px;height: 27px;">
			</td>
			<td colspan="13">
				<input id="opQuantity" class="easyui-textbox" name="opQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="opRemark" class="easyui-textbox" name="opRemark" style="height: 27px;width: 100%;" data-options="multiline:true">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
				
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				6位13A皇冠电源拖排-  （ 
			<input type="checkbox" name="powerDrag" value="竖放横支条上">竖放横支条上  /  
			<input type="checkbox" name="powerDrag" value='19"横放'>19"横放
			）*
			</td>
			<td colspan="13">
				<input id="pdQuantity" class="easyui-textbox" name="pdQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="pdRemark" class="easyui-textbox" name="pdRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				电源分配箱（MDU，10位IEC插座 ) -  （ 或 /
				<input class="noRadio" type="checkbox" name="powerBox" value="特做美式">特做美式）
			</td>
			<td colspan="13">
				<input id="pbQuantity" class="easyui-textbox" name="pbQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="pbRemark" class="easyui-textbox" name="pbRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				5)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				1U 风扇盒 - （
				<input type="checkbox" name="fanBox" value="2孔">2孔 / 
				<input type="checkbox" name="fanBox" value="4孔">4孔 / 
				<input type="checkbox" name="fanBox" value="6孔">6孔
				）*， 配（
				<input type="checkbox" name="fanBrand" value="SZJZ牌滚珠"> SZJZ牌滚珠/
				<input type="checkbox" name="fanBrand" value="德国产4586Z滚珠">  德国产4586Z滚珠
				 ）风扇，连 1.5米线及(
				<input type="checkbox" name="fanPlug" value="13 Amp"> 13 Amp / 
				<input type="checkbox" name="fanPlug" value="10A三扁脚"> 10A三扁脚
				)* 插头  
			</td>
			<td colspan="13">
				<input id="fQuantity" class="easyui-textbox" name="fQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="fRemark" class="easyui-textbox" name="fRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				6)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				其他
 				<a id="otherDel" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-remove'" onclick="delEIATable(this)"></a>
				<a id="otherAdd" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-add'" onclick="addEIATable(this)"></a>
			</td>
			<td colspan="13" style="font-size: 14px">
				
			</td>
			<td colspan="13" style="width: 130px;">
			
			</td>
		</tr>
  	</table>

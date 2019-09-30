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
		
		//二、5)电源条
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
	function addDSQTable(obj){
		var trs = $(obj).parent().parent().parent().children("tr");
		var tempRow = $(".dsqAdd").length;
		var tr = $('<tr class="dsqAdd" style="height: 30px;"></tr>');
		
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
	
	function delDSQTable(obj){
		var tempRow = $(".dsqAdd").length;
		if (tempRow > 0){
			$(".dsqAdd").last().remove();
		}
	}
  </script>
	
	<!-- 增&改的dialog -->
	<table cellspacing="0" align="center" width="860px" cellpadding="1" rules="all" bordercolor="gray" border="1" style="table-layout: fixed;">
		<tr style="height: 30px;">
			<td colspan="86">
				<div style="width:60%;text-align: left;float: left;font-size: 14px;font-weight: bold;">
					工咭號碼﹕<input id="confirmationWorkCardNo" class="easyui-textbox" name="workCardNo" style="height: 27px;width: 80px;" data-options="readonly:true">
				</div>
				<div style="width:40%;text-align: left;float: left;font-size: 14px;font-weight: bold;">
					第<input id="confirmationSequence" class="easyui-textbox" name="sequence" style="height: 27px;width: 50px;" data-options="readonly:true">项
				</div>
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="60" style="font-size: 14px;font-weight: bold;">
				一、货品名称：<input id="confirmationProductName" class="easyui-textbox" name="productName" style="height: 27px;width: 300px;" data-options="readonly:true">
				 型号及规格： <input id="confirmationProductModel" class="easyui-textbox" name="productModel" style="height: 27px;width: 80px;" data-options="readonly:true">
			</td>
			<td colspan="13" style="font-size: 14px;font-weight: bold;width: 130px;">
				（<input id="confirmationQuantity" class="easyui-textbox" name="quantity" style="height: 27px;width: 50px;" data-options="readonly:true">
			</td>
			<td colspan="13" style="width: 130px;">
			
			</td>
		</tr>
		<tr style="height: 60px;">
			<td colspan="3">
			
			</td>
			<td colspan="70" style="font-size: 14px;font-weight: bold;text-align: left;">
				颜色搭配：<input id="bedplateColor" class="easyui-textbox" name="bedplateColor" style="height: 100%;width: 89%;" data-options="multiline:true,required:true,missingMessage:'该项不能为空'">
			</td>
			<td colspan="13">
				<input id="bcRemark" class="easyui-textbox" name="bcRemark" style="height: 100%;width: 100%;" data-options="multiline:true">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;text-align: left;">
				二、自选配件（工咭总数量）：
			</td>
			<td colspan="13" style="font-size: 14px">
				 備註
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				底后门
				（
				<input class="noRadio" type="checkbox" name="bottomBackDoor" value='19"标准'>19"标准   
				<input class="noRadio" type="checkbox" name="bottomBackDoor" value="特制（230深）">特制
				）
			</td>
			<td colspan="13">
				<input id="bbdQuantity" class="easyui-textbox" name="bbdQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="bbdRemark" class="easyui-textbox" name="bbdRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<input class="noRadio" type="checkbox" name="afterThe" value="后上盖板">后上盖板
				<input class="noRadio" type="checkbox" name="afterThe" value="后上门">后上门
			</td>
			<td colspan="13" >
				<input id="atQuantity" class="easyui-textbox" name="atQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="atRemark" class="easyui-textbox" name="atRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				底柜层板
				<input id="bottomArkLayerBoard" class="easyui-textbox" name="bottomArkLayerBoard" style="width: 88%;height: 27px;">
			</td>
			<td colspan="13">
				<input id="balbQuantity" class="easyui-textbox" name="balbQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="balbRemark" class="easyui-textbox" name="balbRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				底19"架（含标准角/扎线槽）
			</td>
			<td colspan="13"><!-- Chassis -->
				<input id="cQuantity" class="easyui-textbox" name="cQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="cRemark" class="easyui-textbox" name="cRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				5)
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
				6)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				特别定制电源条，代码：<input id="otherPower" class="easyui-textbox" name="otherPower" style="width: 360px;height: 27px;">
			</td>
			<td colspan="13">
				<input id="opQuantity" class="easyui-textbox" name="opQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="opRemark" class="easyui-textbox" name="opRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				7)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				名称牌 - 130x30
			</td>
			<td colspan="13"><!-- Name Card -->
				<input id="ncQuantity" class="easyui-textbox" name="ncQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="ncRemark" class="easyui-textbox" name="ncRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				8)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				隔磁板
			</td>
			<td colspan="13"><!-- magnet Vane -->
				<input id="mvQuantity" class="easyui-textbox" name="mvQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="mvRemark" class="easyui-textbox" name="mvRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				9)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				其他
				<a id="otherDel" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-remove'" onclick="delDSQTable(this)"></a>
				<a id="otherAdd" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-add'" onclick="addDSQTable(this)"></a>
			</td>
			<td colspan="13" style="font-size: 14px">
				
			</td>
			<td colspan="13" style="width: 130px;">
			
			</td>
		</tr>
	</table>

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
		
		//一、台板材料：
		$("input[name='bedplateMaterial']").click(function(){
			if($(this).val() == '高密度中纤板+胡桃木皮' && $(this).is(':checked')){
				$("input[name='bedplateMaterialColor']").removeAttr("disabled");
				$("#otherBedplateMaterial").textbox('disable');
				$("#otherBedplateMaterial").textbox('clear');
			}else if($(this).val() == '其他' && $(this).is(':checked')){
				$("input[name='bedplateMaterialColor']").attr("checked",false);//取消所有选中
				$("input[name='bedplateMaterialColor']").attr("disabled","disabled");
				$("#otherBedplateMaterial").textbox('enable');
			}else{
				$("input[name='bedplateMaterialColor']").attr("checked",false);//取消所有选中
				$("input[name='bedplateMaterialColor']").attr("disabled","disabled");
				$("#otherBedplateMaterial").textbox('disable');
				$("#otherBedplateMaterial").textbox('clear');
			}
		});
		//内配件颜色
		$("input[name='internalPartsColor']").click(function(){
			if($(this).val() == '其它色' && $(this).is(':checked')){
				$("#internalPartsColorContent").textbox('enable');
			}else{
				$("#internalPartsColorContent").textbox('disable');
				$("#internalPartsColorContent").textbox('clear');
			}
		});
		//三、5)
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
	function addKZTTable(obj){
		var trs = $(obj).parent().parent().parent().children("tr");
		var tempRow = $(".kztAdd").length;
		var tr = $('<tr class="kztAdd" style="height: 30px;"></tr>');
		
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
	
	function delKZTTable(obj){
		var tempRow = $(".kztAdd").length;
		if (tempRow > 0){
			$(".kztAdd").last().remove();
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
				（<input id="confirmationQuantity" class="easyui-textbox" name="quantity" style="height: 27px;width: 50px;" data-options="readonly:true">）
			</td>
			<td colspan="13" style="width: 130px;">
			
			</td>
		</tr>
		<tr style="">
			<td rowspan="6" colspan="3" style="width: 30px;">
				
			</td>
			<td colspan="70">
				<table align="center" width="100%">
					<tr style="height: 30px;">
						<td rowspan="2" style="font-size: 14px;font-weight: bold;text-align: left;">
							台板材料：
						</td>
						<td style="text-align: left;font-size: 14px;">
							<input type="checkbox" name="bedplateMaterial" value="抗培特板">抗培特板
							<input type="checkbox" name="bedplateMaterial" value="高密度中纤板+胡桃木皮">高密度中纤板+胡桃木皮
							（
							<input type="checkbox" name="bedplateMaterialColor" disabled="disabled" value="深色">深色
							<input type="checkbox" name="bedplateMaterialColor" disabled="disabled" value="浅色">浅色
							）
						</td>
					</tr>
					<tr style="height: 30px;">
						<td style="text-align: left;font-size: 14px;">
							<input type="checkbox" name="bedplateMaterial" value="高密度中纤板+防火胶板">高密度中纤板+防火胶板
							<input type="checkbox" name="bedplateMaterial" value="其他">其他：
							<input id="otherBedplateMaterial" class="easyui-textbox" name="otherBedplateMaterial" style="height: 27px;width: 370px;" data-options="disabled:true,required:true,missingMessage:'该项不能为空'">
						</td>
					</tr>
				</table>
			</td>
			<td rowspan="6" colspan="13">
				<input id="allOneRemark" class="easyui-textbox" name="allOneRemark" style="height: 100%;width: 100%;" data-options="multiline:true">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="70" style="font-size: 14px;font-weight: bold;text-align: left;">
				台板颜色：<input id="bedplateColor" class="easyui-textbox" name="bedplateColor" style="height: 27px;width: 89%;" data-options="required:true,missingMessage:'该项不能为空'">
			</td>
		</tr>
		<tr style="height: 60px;">
			<td colspan="70" style="font-size: 14px;font-weight: bold;text-align: left;">
				侧板颜色：<input id="sidePanelColor" class="easyui-textbox" name="sidePanelColor" style="height: 57px;width: 89%;" data-options="multiline:true,required:true,missingMessage:'该项不能为空'">
			</td>
		</tr>
		<tr style="height: 60px;">
			<td colspan="70" style="font-size: 14px;font-weight: bold;text-align: left;">
				其它铁器颜色：<input id="otherIronColor" class="easyui-textbox" name="otherIronColor" style="height: 57px;width: 85%;" data-options="multiline:true,required:true,missingMessage:'该项不能为空'">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="70" style="text-align: left;font-size: 14px;">
				<span style="font-weight: bold;">内配件颜色：</span>
					
				<input type="checkbox" name="internalPartsColor" checked="true" value="按我司标准颜色（EL343Z浅灰）">按我司标准颜色（EL343Z浅灰）
				<input type="checkbox" name="internalPartsColor" value="其它色">其它色：
				<input id="internalPartsColorContent" class="easyui-textbox" name="internalPartsColorContent" style="height: 27px;width: 42%;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
			</td>
		</tr>
		<tr>
			<td colspan="70">
				<table align="center" width="100%">
					<tr style="height: 30px;">
						<td rowspan="2" style="font-size: 14px;font-weight: bold;text-align: left;">
							台下键盘：
						</td>
						<td style="text-align: right;font-size: 14px;width: 40px;">
							铁器-
						</td>
						<td style="text-align: left;font-size: 14px;">
							<input type="checkbox" name="keybordIron" value="按我司标准为MZ05-134银白色">按我司标准为MZ05-134银白色
						</td>
						<td style="text-align: left;font-size: 14px;">
							<input type="checkbox" name="keybordIron" value="跟控制台主体铁器一致">跟控制台主体铁器一致
						</td>
					</tr>
					<tr style="height: 30px;">
						<td style="text-align: right;font-size: 14px;width: 40px;">
							枕手-
						</td>
						<td style="text-align: left;font-size: 14px;">
							<input type="checkbox" name="keybordZs" value="按我司标准为黑色">按我司标准为黑色
						</td>
						<td style="text-align: left;font-size: 14px;">
							<input type="checkbox" name="keybordZs" value="跟前台手枕颜色一致">跟前台手枕颜色一致
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;text-align: left;">
					二、每套配置：
			</td>
			<td colspan="13" style="width: 130px;font-size: 14px;">
				 備註
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px;">
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				底柜底板
			</td>
			<td colspan="13">
				(<input id="bottomArkBottomBoard" class="easyui-textbox" name="bottomArkBottomBoard" style="width: 50px;" data-options="required:true,missingMessage:'该项不能为空'">）件
			</td>
			<td colspan="13">
				<input id="babbRemark" class="easyui-textbox" name="babbRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px;">
				2)
			</td>
			<td colspan="80" style="font-size: 14px;text-align: left;">
				其它<input id="otherEachConfig" class="easyui-textbox" name="otherEachConfig" style="height: 57px;width: 750px;" data-options="multiline:true">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;text-align: left;">
					三、自选配件（工咭总数量）：
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
				底柜层板
				（
				<input type="checkbox" name="bottomArkLayerBoard" value='19"标准'>19"标准   
				<input type="checkbox" name="bottomArkLayerBoard" value="特制">特制
				）
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
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				活动盆（配伸缩条）
			</td>
			<td colspan="13" ><!-- activity Basin -->
				<input id="abQuantity" class="easyui-textbox" name="abQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="abRemark" class="easyui-textbox" name="abRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				键盘盆
				(
				<input type="checkbox" name="keyboardBasin" value="463键盘盆">463键盘盆
				<input type="checkbox" name="keyboardBasin" value="600键盘盆">600键盘盆
				)
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
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				托码（
				<input type="checkbox" name="joeCode" value="450D">450D
				<input type="checkbox" name="joeCode" value="330D">330D
				<input type="checkbox" name="joeCode" value="特制">特制
				）
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
				M6x20冬菇头螺丝+丝母盒+透明胶介子
			</td>
			<td colspan="13"><!-- screw -->
				<input id="sQuantity" class="easyui-textbox" name="sQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="sRemark" class="easyui-textbox" name="sRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				8)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<table align="center" width="100%">
					<tr style="height: 30px;">
						<td rowspan="2" style="font-size: 14px;text-align: left;">
							LCD支架： 
						</td>
						<td style="text-align: left;font-size: 14px;">
							 规格：
						</td>
						<td style="text-align: left;font-size: 14px;">
							<input id="lcdStents" class="easyui-textbox" name="lcdStents" style="width: 390px;height: 27px;">
						</td>
					</tr>
					<tr style="height: 30px;">
						<td style="text-align: left;font-size: 14px;">
							 颜色：
						</td>
						<td style="text-align: left;font-size: 14px;">
							（
					<input type="checkbox" name="lcdStentsColor" value="黑色">黑色 /  
					<input type="checkbox" name="lcdStentsColor" value="银色">银色
					）
						</td>
					</tr>
				</table>
			</td>
			<td colspan="13">
				<input id="lsQuantity" class="easyui-textbox" name="lsQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="lsRemark" class="easyui-textbox" name="lsRemark" style="height: 100%;width: 100%;" data-options="multiline:true">
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
				<a id="otherDel" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-remove'" onclick="delKZTTable(this)"></a>
				<a id="otherAdd" class="easyui-linkbutton" plain="true" style="float: right;" data-options="iconCls:'icon-add'" onclick="addKZTTable(this)"></a>
			</td>
			<td colspan="13" style="font-size: 14px">
				
			</td>
			<td colspan="13" style="width: 130px;">
			
			</td>
		</tr>
	</table>

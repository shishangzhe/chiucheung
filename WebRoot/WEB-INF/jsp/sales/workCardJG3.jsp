<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script type="text/javascript">
	//让dialog随着窗口大小的改变而居中
	$(function () {
		$(".easyui-textbox").textbox();
		
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
		
		$("input[name='color']").click(function(){
			if($(this).val() == '需特别处理' && $(this).is(':checked')){
				$("#otherColor").textbox('enable');
			}else{
				$("#otherColor").textbox('disable');
				$("#otherColor").textbox('clear');
			}
		});
		//一、4)后门
		$("input[name='backDoor']").click(function(){
			if($(this).val() == '特做' && $(this).is(':checked')){
				$("#backDoorSpeciallyMade").textbox('enable');
			}else{
				$("#backDoorSpeciallyMade").textbox('disable');
				$("#backDoorSpeciallyMade").textbox('clear');
			}
		});
		//二、2)前门
		$("input[name='frontDoor']").click(function(){
			if($(this).val() == '特做' && $(this).is(':checked')){
				$("#frontDoorSpeciallyMade").textbox('enable');
			}else{
				$("#frontDoorSpeciallyMade").textbox('disable');
				$("#frontDoorSpeciallyMade").textbox('clear');
			}
		});
		//二、3)接地黄铜
		$("input[name='copper']").click(function(){
			if($(this).val() == '特别规格' && $(this).is(':checked')){
				$("#specialCopper").textbox('enable');
			}else{
				$("#specialCopper").textbox('disable');
				$("#specialCopper").textbox('clear');
			}
		});
	});
	
	
	
	//控制台做货确认单添加其他的表格
	function addJG3Table(obj){
		var trs = $(obj).parent().parent().parent().children("tr");
		var tempRow = $(".jg3Add").length;
		var tr = $('<tr class="jg3Add" style="height: 30px;"></tr>');
		
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
	
	function delJG3Table(obj){
		var tempRow = $(".jg3Add").length;
		if (tempRow > 0){
			$(".jg3Add").last().remove();
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
			<td colspan="86" style="font-size: 14px;font-weight: bold;">
				<div style="width: 5%;float: left;">
					RKIII﹕
				</div> 
				<div style="width: 19%;float: left;">
					高度﹕ <input id="height" class="easyui-textbox" name="height" style="height: 27px;width: 50px;" data-options="required:true,missingMessage:'该项不能为空'">U
				</div>
				<div style="width: 19%;float: left;">
					深度﹕<input id="depth" class="easyui-textbox" name="depth" style="height: 27px;width: 50px;" data-options="required:true,missingMessage:'该项不能为空'">mm  
				</div>
				<div style="width: 19%;float: left;">
					宽度﹕ <input id="width" class="easyui-textbox" name="width" style="height: 27px;width: 50px;" data-options="required:true,missingMessage:'该项不能为空'">mm 
				</div>
				<div style="width: 19%;float: left;">
					(
					<input type="checkbox" name="model" value="19">19" 
					/
					<input type="checkbox" name="model" value="21">21"
					)*
				</div>
				<div style="width: 19%;float: left;">
					数量﹕<input id="confirmationQuantity" class="easyui-textbox" name="quantity" style="height: 27px;width: 50px;" data-options="readonly:true">
				</div>
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="86" style="font-size: 14px;text-align: left;">
				<input type="checkbox" name="color" value="标准深浅灰粉（EL342Z深+343Z浅）">标准深浅灰粉（EL342Z深+343Z浅）
				<input type="checkbox" name="color" value="需特别处理"> 需特别处理：<input id="otherColor" class="easyui-textbox" name="otherColor" style="height: 27px;width: 55%" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;text-align: left;font-weight: bold;">
					一	机柜主体内置配件（每套数量）：	
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
				主体框架
			</td>
			<td colspan="13"><!-- Main Frame -->
				<input id="mfQuantity" class="easyui-textbox" name="mfQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="mfRemark" class="easyui-textbox" name="mfRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				扎线槽（
				<input class="noRadio" type="checkbox" name="wireSlot" value="2">2"  
				或<input class="noRadio" type="checkbox" name="wireSlot" value="4">4" 
				或<input class="noRadio" type="checkbox" name="wireSlot" value="6">6" 
				或<input class="noRadio" type="checkbox" name="wireSlot" value="8">8"
				)*
			</td>
			<td colspan="13">
				<input id="wsQuantity" class="easyui-textbox" name="wsQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="wsRemark" class="easyui-textbox" name="wsRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				标准角 -（
				<input id="frontStandardAngle" class="easyui-textbox" name="frontStandardAngle" style="height: 27px;width: 60px;">
				）U（
				<input type="checkbox" name="frontStandardAngleContent" value="内空19">内空19"或
				<input type="checkbox" name="frontStandardAngleContent" value="内空21">内空21"
				）*
			</td>
			<td colspan="13">
				<input id="fsaQuantity" class="easyui-textbox" name="fsaQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">对
			</td>
			<td colspan="13">
				<input id="fsaRemark" class="easyui-textbox" name="fsaRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				后门(配3U出线口)---(
				<input type="checkbox" name="backDoor" value="标准">按标准 或 
				<input type="checkbox" name="backDoor" value="特做">特做：
				<input id="backDoorSpeciallyMade" class="easyui-textbox" name="backDoorSpeciallyMade" style="height: 27px;width: 40%;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
				)
			</td>
			<td colspan="13">
				<input id="bdQuantity" class="easyui-textbox" name="bdQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="bdRemark" class="easyui-textbox" name="bdRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				5)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				顶组合封板  -  
			</td>
			<td colspan="13">
				
			</td>
			<td colspan="13">
				
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				空白封板  
			</td>
			<td colspan="13"><!-- blank Plate 1 -->
				<input id="bp1Quantity" class="easyui-textbox" name="bp1Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="bp1Remark" class="easyui-textbox" name="bp1Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				带风扇孔(2孔) -  配2 把（
				<input type="checkbox" name="fanBrand" value="SZJZ牌滚珠"> SZJZ牌滚珠/
				<input type="checkbox" name="fanBrand" value="德国产4586Z滚珠">  德国产4586Z滚珠
				  ）风扇*连 1.5米线及(
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
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				带布线孔
			</td>
			<td colspan="13"><!-- wiring Hole 1 -->
				<input id="wh1Quantity" class="easyui-textbox" name="wh1Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="wh1Remark" class="easyui-textbox" name="wh1Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				带散气孔
			</td>
			<td colspan="13"><!-- degassing 1 -->
				<input id="d1Quantity" class="easyui-textbox" name="d1Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="d1Remark" class="easyui-textbox" name="d1Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				带灯 - 配光管连1.5米线及(
				<input type="checkbox" name="lampPlug" value="13 Amp"> 13 Amp / 
				<input type="checkbox" name="lampPlug" value="10A三扁脚"> 10A三扁脚
				)* 插头
			</td>
			<td colspan="13">
				<input id="lpQuantity" class="easyui-textbox" name="lpQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="lpRemark" class="easyui-textbox" name="lpRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				6)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				M6x20螺丝+丝母盒+透明胶介
			</td>
			<td colspan="13"><!-- Screw -->
				<input id="sQuantity" class="easyui-textbox" name="sQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="sRemark" class="easyui-textbox" name="sRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;text-align: left;font-weight: bold;">
					二	主选配件（每套数量）：		
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
				底组合封板  -  
			</td>
			<td colspan="13">
				
			</td>
			<td colspan="13">
				
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				空白封板  
			</td>
			<td colspan="13"><!-- blank Plate 2 -->
				<input id="bp2Quantity" class="easyui-textbox" name="bp2Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="bp2Remark" class="easyui-textbox" name="bp2Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				带布线孔
			</td>
			<td colspan="13"><!-- wiring Hole2 -->
				<input id="wh2Quantity" class="easyui-textbox" name="wh2Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="wh2Remark" class="easyui-textbox" name="wh2Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				带散气孔
			</td>
			<td colspan="13"><!-- degassing 2 -->
				<input id="d2Quantity" class="easyui-textbox" name="d2Quantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="d2Remark" class="easyui-textbox" name="d2Remark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				前门（
				<input type="checkbox" name="frontDoor" value="玻璃">玻璃  或 
				<input type="checkbox" name="frontDoor" value="特做">特做：
				<input id="frontDoorSpeciallyMade" class="easyui-textbox" name="frontDoorSpeciallyMade" style="width: 60%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
				 ）*
			</td>
			<td colspan="13" >
				<input id="fdQuantity" class="easyui-textbox" name="fdQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="fdRemark" class="easyui-textbox" name="fdRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				接地铜条- <span style="color: red">黄铜</span> (
				<input type="checkbox" name="copper" value="标准规格">标准规格/ 
				<input type="checkbox" name="copper" value="特别规格">特别规格：
				<input id="specialCopper" class="easyui-textbox" name="specialCopper" style="height: 27px;width: 40%;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
				)
			</td>
			<td colspan="13">
				<input id="cQuantity" class="easyui-textbox" name="cQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="cRemark" class="easyui-textbox" name="cRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				2"丝头尼龙轮（4/套）
			</td>
			<td colspan="13"><!-- nylon Wheel -->
				<input id="nwQuantity" class="easyui-textbox" name="nwQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="nwRemark" class="easyui-textbox" name="nwRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				5)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				调节器（2/套）
			</td>
			<td colspan="13"><!-- regulator -->
				<input id="rQuantity" class="easyui-textbox" name="rQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="rRemark" class="easyui-textbox" name="rRemark" style="height: 100%;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				6)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				地架  高度: H=
				<input id="groundPlaneHeight" class="easyui-textbox" name="groundPlaneHeight" style="height: 27px;width: 50px;">
		mm
			</td>
			<td colspan="13">
				<input id="gpQuantity" class="easyui-textbox" name="gpQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="gpRemark" class="easyui-textbox" name="gpRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="73" style="font-size: 14px;text-align: left;font-weight: bold;">
					三	主选配件（工咭总数量）：		
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
				侧板 
			</td>
			<td colspan="13"><!-- side Panel -->
				<input id="spQuantity" class="easyui-textbox" name="spQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">件
			</td>
			<td colspan="13">
				<input id="spRemark" class="easyui-textbox" name="spRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				并柜连接器
			</td>
			<td colspan="13"><!-- ark Connector -->
				<input id="acQuantity" class="easyui-textbox" name="acQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="acRemark" class="easyui-textbox" name="acRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
	</table>

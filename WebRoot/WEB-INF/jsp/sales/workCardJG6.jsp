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
		
		$("input[name='mainColor']").click(function(){
			if($(this).val() == '其他处理' && $(this).is(':checked')){
				$("#otherMainColor").textbox('enable');
			}else{
				$("#otherMainColor").textbox('disable');
				$("#otherMainColor").textbox('clear');
			}
		});
		
		$("input[name='frontDoorColor']").click(function(){
			if($(this).val() == '其他处理' && $(this).is(':checked')){
				$("#otherFrontDoorColor").textbox('enable');
			}else{
				$("#otherFrontDoorColor").textbox('disable');
				$("#otherFrontDoorColor").textbox('clear');
			}
		});
		//一、1)主体套件
		$("input[name='mainSuite']").click(function(){
			if($(this).val() == '特制' && $(this).is(':checked')){
				$("#mainSuiteSpecialMade").textbox('enable');
			}else{
				$("#mainSuiteSpecialMade").textbox('disable');
				$("#mainSuiteSpecialMade").textbox('clear');
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
		//二、5)接地黄铜
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
	function addJG6Table(obj){
		var trs = $(obj).parent().parent().parent().children("tr");
		var tempRow = $(".jg6Add").length;
		var tr = $('<tr class="jg6Add" style="height: 30px;"></tr>');
		
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
	
	function delJG6Table(obj){
		var tempRow = $(".jg6Add").length;
		if (tempRow > 0){
			$(".jg6Add").last().remove();
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
			<td colspan="86" style="font-size: 14px;font-weight: bold;">
				<div style="width: 5%;float: left;">
					RKVI﹕
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
				主体颜色：   
				<input type="checkbox" name="mainColor" value="标准黑色粉（TM-0320）">标准黑色粉（TM-0320）
				<input type="checkbox" name="mainColor" value="其他处理"> 其它处理：<input id="otherMainColor" class="easyui-textbox" name="otherMainColor" style="height: 27px;width: 50%" data-options="disabled:true,required:true,missingMessage:'该项不能为空'">
				<br>
				前门拉铝条：
				<input type="checkbox" name="frontDoorColor" value="标准银色漆（8500E/15719）">标准银色漆（8500E/15719）
				<input type="checkbox" name="frontDoorColor" value="其他处理"> 其它处理：<input id="otherFrontDoorColor" class="easyui-textbox" name="otherFrontDoorColor" style="height: 27px;width: 50%" data-options="disabled:true,required:true,missingMessage:'该项不能为空'">
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
				
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				■有导电要求
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
				1)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				<table align="center" width="100%">
					<tr>
						<td rowspan="3">
							主体套件
						</td>
						<td>
							（
							<input type="checkbox" name="mainSuite" value="600W标准">600W标准：含前、中、后标准角各1对及4"扎线槽1条
						</td>
					</tr>
					<tr>
						<td style="padding-left: 19px;">
	            			<input type="checkbox" name="mainSuite" value="800W标准">800W标准：前标准角2对、前扣线环及4"扎线槽1条
						</td>
					</tr>
					<tr>
						<td style="padding-left: 19px;">
							<input type="checkbox" name="mainSuite" value="特制">特制：
							<input id="mainSuiteSpecialMade" class="easyui-textbox" name="mainSuiteSpecialMade" style="width: 80%;height: 27px;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
							）
						</td>
					</tr>
					<tr>
						<td rowspan="2">
							备注：
						</td>
						<td style="padding-left: 19px;">
							600W机柜，600D以下的配4条标准角；
						</td>
	         		</tr>
	         		<tr>
					<td style="padding-left: 19px;">
		          		800W机柜，都配4条标准角，配6条时特殊提出。
		          	</td>
	         	</tr>
	          </table>
			</td>
			<td colspan="13">
				<input id="msQuantity" class="easyui-textbox" name="msQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="msRemark" class="easyui-textbox" name="msRemark" style="height: 100%;width: 100%;" data-options="multiline:true">
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
				<input type="checkbox" name="wireSlot" value="2">2"  
				或<input type="checkbox" name="wireSlot" value="4">4"
				)*--<span style="font-weight: bold;">增加时才配！</span>
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
				风扇盖 -  配（4 / 6）*把（
				<input type="checkbox" name="fanBrand" value="SZJZ牌滚珠"> SZJZ牌滚珠/
				<input type="checkbox" name="fanBrand" value="德国产4586Z滚珠">  德国产4586Z滚珠
				  ）风扇*连 1.5米线及(
				 <input type="checkbox" name="fanPlug" value="13 Amp"> 13 Amp / 
				 <input type="checkbox" name="fanPlug" value="10A三扁脚"> 10A三扁脚
				  )* 插头  
			</td>
			<td colspan="13">
				<input id="fQuantity" class="easyui-textbox" name="fQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="fRemark" class="easyui-textbox" name="fRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				后门-(
				<input type="checkbox" name="backDoor" value="窄拉铝散气平门">窄拉铝散气平门/
				<input type="checkbox" name="backDoor" value="全散气对开门 ">全散气对开门 /
				<input type="checkbox" name="backDoor" value="特做">特做：
				<input id="backDoorSpeciallyMade" class="easyui-textbox" name="backDoorSpeciallyMade" style="height: 27px;width: 30%;" data-options="required:true,missingMessage:'该项不能为空',disabled:true">
				)
			</td>
			<td colspan="13">
				<input id="bdQuantity" class="easyui-textbox" name="bdQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
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
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				6)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				黑色塑胶名称牌 （前后门上已含，<span style="font-weight: bold;">无前门时加配</span>在顶盖上！)
			</td>
			<td colspan="13"><!-- black Plastic Name Card -->
				<input id="bpncQuantity" class="easyui-textbox" name="bpncQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="bpncRemark" class="easyui-textbox" name="bpncRemark" style="height: 27px;width: 100%;">
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
				前门 -
				<input type="checkbox" name="frontDoor" value="窄拉铝散气平门">窄拉铝散气平门/
				<input type="checkbox" name="frontDoor" value="全散气弧形门">全散气弧形门/
				<input type="checkbox" name="frontDoor" value="拉铝弧形门">拉铝弧形门/
				<input type="checkbox" name="frontDoor" value="拉铝玻璃门">拉铝玻璃门
			</td>
			<td colspan="13" >
				<input id="fdQuantity" class="easyui-textbox" name="fdQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="fdRemark" class="easyui-textbox" name="fdRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				2)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				底盖板
			</td>
			<td colspan="13"><!-- bottom Plate -->
				<input id="bpQuantity" class="easyui-textbox" name="bpQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="bpRemark" class="easyui-textbox" name="bpRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				2"平板无掣万向轮（4/套）
			</td>
			<td colspan="13"><!-- Nylon Wheel -->
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
				4)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				调节器（4/套）
			</td>
			<td colspan="13"><!-- Regulator -->
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
				5)
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
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				7)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				扣线环盖板（800W机柜选配，左右各一件）
			</td>
			<td colspan="13" ><!-- Buckle line ring plate -->
				<input id="blrpQuantity" class="easyui-textbox" name="blrpQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="blrpRemark" class="easyui-textbox" name="blrpRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				8)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				扣线环（800W机柜后面也安装时才增加）
			</td>
			<td colspan="13" ><!-- buckle Line -->
				<input id="blQuantity" class="easyui-textbox" name="blQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">个
			</td>
			<td colspan="13">
				<input id="blRemark" class="easyui-textbox" name="blRemark" style="height: 27px;width: 100%;">
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
				拉铝装饰条
			</td>
			<td colspan="13"><!-- Tensile aluminum decorative article -->
				<input id="tadaQuantity" class="easyui-textbox" name="tadaQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">条
			</td>
			<td colspan="13">
				<input id="tadaRemark" class="easyui-textbox" name="tadaRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
		<tr style="height: 30px;">
			<td colspan="3">
			
			</td>
			<td colspan="3" style="font-size: 14px">
				3)
			</td>
			<td colspan="54" style="font-size: 14px;text-align: left;">
				连接器（4/套）
			</td>
			<td colspan="13"><!-- connector -->
				<input id="connectorQuantity" class="easyui-textbox" name="connectorQuantity" style="width: 40px;" data-options="required:true,missingMessage:'该项不能为空'">套
			</td>
			<td colspan="13">
				<input id="connectorRemark" class="easyui-textbox" name="connectorRemark" style="height: 27px;width: 100%;">
			</td>
		</tr>
	</table>

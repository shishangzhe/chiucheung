package cn.chiucheung.controller.market;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;
import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;
import cn.chiucheung.po.market.devicenameserialnumber.MarDeviceNameSerialNumber;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoForUpdateCustom;
import cn.chiucheung.pojo.finance.workcardinfo.FinWorkCardInfoQueryVo;
import cn.chiucheung.pojo.market.conductpropagandafile.MarConductPropagandaFileQueryVo;
import cn.chiucheung.pojo.market.devicenameserialnumber.MarDeviceNameSerialNumberQueryVo;
import cn.chiucheung.service.market.DeviceNameSerialNumberService;

@Controller
@RequestMapping("/market/deviceNameSerialNumber")
public class MarDeviceNameSerialNumberAction {
	
	@Autowired
	private DeviceNameSerialNumberService deviceNameSerialNumberService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(pid="ff",mid="fi")
	public String index(){
		return "market/deviceNameSerialNumber";
	}
	
	/**
	 * 查询所有的设备
	 * @param conductPropagandaFile
	 * @return
	 */
	@RequestMapping(value="findAllDeviceNameSerialNumber")
	@ResponseBody
	@AnnotationLimit(pid="ff",mid="fi")
	public Map<String, Object> findAllDeviceNameSerialNumber(MarDeviceNameSerialNumberQueryVo deviceNameSerialNumberQueryVo){
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MarDeviceNameSerialNumber> list = deviceNameSerialNumberService.findAllDeviceNameSerialNumber(deviceNameSerialNumberQueryVo);
			String total = deviceNameSerialNumberService.findAllDeviceNameSerialNumberTotal(deviceNameSerialNumberQueryVo);
			
			map.put("rows", list);
			map.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 新增设备
	 * @param deviceNameSerialNumber
	 * @return
	 */
	@RequestMapping("saveDeviceNameSerialNumber")
	@ResponseBody
	@AnnotationLimit(mid="fia",pid="fi")
	public JSONObject saveDeviceNameSerialNumber(MarDeviceNameSerialNumber deviceNameSerialNumber){
		JSONObject jsonObject = new JSONObject();
		try{
			deviceNameSerialNumberService.saveDeviceNameSerialNumber(deviceNameSerialNumber);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据id查找设备，用于页面的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findDeviceNameSerialNumberById")
	@ResponseBody
	@AnnotationLimit(mid="fib",pid="fi")
	public MarDeviceNameSerialNumber findDeviceNameSerialNumberById(String id){
		return deviceNameSerialNumberService.findDeviceNameSerialNumberById(id);
	}
	
	/**
	 * 根据id查找设备，用于页面的复制
	 * @param id
	 * @return
	 */
	@RequestMapping("copyDeviceNameSerialNumberById")
	@ResponseBody
	@AnnotationLimit(mid="fia",pid="fi")
	public MarDeviceNameSerialNumber copyDeviceNameSerialNumberById(String id){
		return deviceNameSerialNumberService.findDeviceNameSerialNumberById(id);
	}
	
	/**
	 * 更新设备
	 * @param workCardInfoCustom
	 * @return
	 */
	@RequestMapping("updateDeviceNameSerialNumber")
	@ResponseBody
	@AnnotationLimit(mid="fib",pid="fi")
	public JSONObject updateDeviceNameSerialNumber(MarDeviceNameSerialNumber deviceNameSerialNumber){
		JSONObject jsonObject = new JSONObject();
		try{
			deviceNameSerialNumberService.updateDeviceNameSerialNumber(deviceNameSerialNumber);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除设备
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteDeviceNameSerialNumberById")
	@ResponseBody
	@AnnotationLimit(mid="fic",pid="fi")
	public JSONObject deleteDeviceNameSerialNumberById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			deviceNameSerialNumberService.deleteDeviceNameSerialNumberById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
}

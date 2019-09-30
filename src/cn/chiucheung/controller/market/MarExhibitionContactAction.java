package cn.chiucheung.controller.market;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.market.exhibitioncontact.MarExhibitionContact;
import cn.chiucheung.pojo.market.exhibitioncontact.MarExhibitionContactQueryVo;
import cn.chiucheung.service.market.ExhibitionContactService;
import cn.chiucheung.utils.JxlExcelUtils;

@Controller
@RequestMapping("/market/exhibitionContact")
public class MarExhibitionContactAction {
	
	@Autowired ExhibitionContactService exhibitionContactService;
	
	@RequestMapping("signUpIndex")
	public String signUpIndex(HttpServletRequest request){
		System.out.println(request.getParameter("FromUserName"));
		return "market/signUpIndex";
	}
	
	@RequestMapping("signUp")
	public String signUp(){
		return "market/signUp";
	}
	
	@RequestMapping("index")
	@AnnotationLimit(pid="ff",mid="fj")
	public String index(){
		return "market/exhibitionContact";
	}
	
	@RequestMapping("signUpAdd")
	@ResponseBody
	public JSONObject signUpAdd(MarExhibitionContact exhibitionContact){
		JSONObject jsonObject = new JSONObject();
		try{
			exhibitionContactService.saveExhibitionContact(exhibitionContact);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	@RequestMapping("findAllExhibitionContact")
	@ResponseBody
	@AnnotationLimit(pid="ff",mid="fj")
	public Map<String, Object> findAllExhibitionContact(MarExhibitionContactQueryVo exhibitionContactQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<MarExhibitionContact> list =  exhibitionContactService.findAllExhibitionContactList(exhibitionContactQueryVo);
		String total = exhibitionContactService.findAllExhibitionContactTotal(exhibitionContactQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	@RequestMapping("exportExcel")
	@AnnotationLimit(pid="fj",mid="fja")
	public String exportExcel(MarExhibitionContactQueryVo exhibitionContactQueryVo, HttpServletRequest request, HttpServletResponse response){
		String filename = "";
		List<Map<String, List<Object>>> objData = new ArrayList<Map<String,List<Object>>>();
		List<String> columns = new ArrayList<String>();
		List<Integer> columnsWidth = new ArrayList<Integer>();
		
		List<MarExhibitionContact> list =  exhibitionContactService.findAllExhibitionContactList(exhibitionContactQueryVo);
		int i=0;
		for (MarExhibitionContact exhibitionContact : list) {
			List<Object> list2 = new ArrayList<Object>();
			list2.add(exhibitionContact.getUserName());
			list2.add(exhibitionContact.getPhoneNumber());
			list2.add(exhibitionContact.getEmail());
			list2.add(exhibitionContact.getCompany());
			list2.add(exhibitionContact.getProperty());
			list2.add(exhibitionContact.getSite());
			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
			map.put(i+"", list2);
			objData.add(map);
			i++;
		}
		columns.add("姓名");
		columns.add("电话");
		columns.add("邮箱");
		columns.add("公司");
		columns.add("性质");
		columns.add("站点");
		
		
		columnsWidth.add(15);
		columnsWidth.add(20);
		columnsWidth.add(30);
		columnsWidth.add(30);
		columnsWidth.add(30);
		columnsWidth.add(15);
		
		//提供下载
		filename = "展会报名表_" + new Date().toLocaleString()+".xls";
		
		JxlExcelUtils.exportexcle(response, filename, objData, "Sheet1", columns, columnsWidth);
		return null;
	}
	
}

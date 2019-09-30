package cn.chiucheung.controller.warehouse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.warehouse.StandardAccessoriesInventoryService;
import cn.chiucheung.service.warehouse.StandardAccessoriesService;

@Controller
@RequestMapping("/warehouse/standardAccessoriesInventory")
public class WarStandardAccessoriesInventoryAction {
	
	@Autowired
	private StandardAccessoriesInventoryService standardAccessoriesInventoryService;
	
	@Autowired
	private StandardAccessoriesService standardAccessoriesService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="il",pid="ii")
	public String index(){
		return "warehouse/standardAccessoriesInventory";
	}
	
	/**
	 * 查找所有的物料库存
	 * @param standardAccessoriesQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllWarStandardAccessoriesInventoryList")
	@ResponseBody
	@AnnotationLimit(mid="il",pid="ii")
	public Map<String, Object> findAllWarStandardAccessoriesInventoryList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarStandardAccessoriesInventoryCustom> list = standardAccessoriesInventoryService.findAllWarStandardAccessoriesInventoryList(standardAccessoriesQueryVo);
		String total = standardAccessoriesInventoryService.findAllWarStandardAccessoriesInventoryTotal(standardAccessoriesQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 根据standardAccessoriesFile的id查询附件
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("readFileById")
	@ResponseBody
	@AnnotationLimit(mid="il",pid="ii")
	public String readFileById(String id, HttpServletRequest request, HttpServletResponse response){
		WarStandardAccessoriesFile standardAccessoriesFile = standardAccessoriesService.findfindWarStandardAccessoriesFileById(id);
		File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),standardAccessoriesFile.getFilePath());
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (FileNotFoundException e) {
			try {
				response.getWriter().write("file not found");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
		return null;
	}
}

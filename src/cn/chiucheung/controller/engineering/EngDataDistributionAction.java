package cn.chiucheung.controller.engineering;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.pojo.engineering.datadistribution.WorkCardNoCustom;
import cn.chiucheung.pojo.engineering.datadistribution.WorkCardSubsidiaryCustom;
import cn.chiucheung.service.engineering.DataDistributionService;


@Controller
@RequestMapping("/engineering/dataDistribution")
public class EngDataDistributionAction {
	
	@Autowired
	private DataDistributionService dataDistributionService;
	
	@RequestMapping("index")
	public String index(){
		return "engineering/dataDistribution";
	}
	
	@RequestMapping("findAllWorkCardNo")
	@ResponseBody
	public List<WorkCardNoCustom> findAllWorkCardNo(WorkCardNoCustom workCardNoCustom){
		return dataDistributionService.findAllWorkCardNo(workCardNoCustom);
	}
	
	@RequestMapping("findAllWorkCardSubsidiary")
	@ResponseBody
	public List<WorkCardSubsidiaryCustom> findAllWorkCardSubsidiary(String workCardNo){
		return dataDistributionService.findAllWorkCardSubsidiary(workCardNo);
	}
}

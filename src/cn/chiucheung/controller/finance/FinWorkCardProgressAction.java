package cn.chiucheung.controller.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/finance/workCardProgress")
public class FinWorkCardProgressAction {
	
	@RequestMapping("index")
	public String index(){
		return "finance/workCardProgress";
	}
}

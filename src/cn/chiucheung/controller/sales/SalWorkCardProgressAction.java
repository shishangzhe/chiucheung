package cn.chiucheung.controller.sales;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sales/workCardProgress")
public class SalWorkCardProgressAction {
	
	@RequestMapping("index")
	public String index(){
		return "sales/workCardProgress";
	}
}

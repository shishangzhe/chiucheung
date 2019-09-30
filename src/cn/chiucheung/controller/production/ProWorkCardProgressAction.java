package cn.chiucheung.controller.production;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/production/workCardProgress")
public class ProWorkCardProgressAction {
	
	@RequestMapping("index")
	public String index(){
		return "production/workCardProgress";
	}
}

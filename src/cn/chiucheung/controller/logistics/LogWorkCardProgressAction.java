package cn.chiucheung.controller.logistics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/logistics/workCardProgress")
public class LogWorkCardProgressAction {
	
	@RequestMapping("index")
	public String index(){
		return "logistics/workCardProgress";
	}
}

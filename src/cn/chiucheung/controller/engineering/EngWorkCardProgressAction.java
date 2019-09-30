package cn.chiucheung.controller.engineering;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/engineering/workCardProgress")
public class EngWorkCardProgressAction {
	
	@RequestMapping("index")
	public String index(){
		return "engineering/workCardProgress";
	}
}

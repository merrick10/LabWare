package merrick.ctrl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class FrontPage {
	
//	private static Logger log = Logger.getLogger(FrontPage.class);		
	@RequestMapping(path="/")
	public String firstpage(Model mdl,HttpServletRequest rq){
//		log.info("Controll:/");		
		//return new ModelAndView("index");		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("homepage");		
//		List<Map<String,Object>> lst = jtpi.getpubinfolist();
//		
//		mdl.addAttribute("lst", lst);
	
		System.out.println("firstpage");		
		return "test1";		
	}
	
	
	@RequestMapping(path="/msg1")
	public String f1(Model mdl,HttpServletRequest rq){

		mdl.addAttribute("msg", String.valueOf("Hi there, it's a long time since I've seen you last time."));
		
		System.out.println("f1");		
		return "templates/msg1.html";		
	}
	
	
	
	
	
	
	

}

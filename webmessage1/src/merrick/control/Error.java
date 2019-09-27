package merrick.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path="/err")
public class Error {
	
	private static Logger log =  LogManager.getLogger(Error.class);	
	
	@RequestMapping(value="/{errnum}" ,method=RequestMethod.GET)
	public String errorpage(@PathVariable(value = "errnum") String num, Model mdl,HttpServletRequest req){
		
		log.info(num);
		
		mdl.addAttribute("err",  "Something error! "+ num);
		
		
		
		return "err";
	}

}

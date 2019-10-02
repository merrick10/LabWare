package merrick.control;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import merrick.entity.MessageEntity1;


@Controller
public class FirstCtrl {
	
	
	private static Logger log =  LogManager.getLogger(FirstCtrl.class);	

	@RequestMapping(path="/",method=RequestMethod.GET)
	public String f1(Model mdl,HttpServletRequest req){
		
		log.info("Vistor!");
		
		mdl.addAttribute("msg",  "Ê±¼ä£¬"+ LocalDateTime.now().toString());		
		
		return "first";
	}
	
	@RequestMapping(path="/a1",method=RequestMethod.GET)
	public String f2(Model mdl,HttpServletRequest req){
		
		log.info("Vistor!");
		
		mdl.addAttribute("msg",  "Time£¬"+ LocalDateTime.now().toString());		
		
		return "second";
	}

}

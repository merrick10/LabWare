package merrick.control;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private BroadTemplateMsgServiceImpl tmpmsg;
	

	@RequestMapping(path="/",method=RequestMethod.GET)
	public String f1(Model mdl,HttpServletRequest req){
		
		log.info("Vistor!");
		
		mdl.addAttribute("msg",  "时间，"+ LocalDateTime.now().toString());		
		
		return "first";
	}
	
	@RequestMapping(path="/subscriber1",method=RequestMethod.GET)
	public String f2(Model mdl,HttpServletRequest req){
		
		log.info("Subscriber1!");
		
		mdl.addAttribute("msg",  "Time，"+ LocalDateTime.now().toString());		
		
		return "second";
	}
	
	@RequestMapping(path="/subscriber2",method=RequestMethod.GET)
	public String f4(Model mdl,HttpServletRequest req){
		
		log.info("Subscriber2!");
		
		mdl.addAttribute("msg",  "Time，"+ LocalDateTime.now().toString());		
		
		return "fourth";
	}
	
	@RequestMapping(path="/broadcast",method=RequestMethod.GET)
	public String f3(Model mdl,HttpServletRequest req){
		
		log.info("Sender!");
		
		mdl.addAttribute("msg",  "Time，"+ LocalDateTime.now().toString());		
		
		return "third";
	}
	
	@RequestMapping(path="/templatemgsg",method=RequestMethod.POST)
	public String f6(Model mdl,HttpServletRequest req){		//消息构建，发送
		log.info("Sender Template function!");		
		MessageEntity1 obj = new MessageEntity1();
		obj.setProp1( LocalDateTime.now().toString()  +",This is Template messaging... ");
		tmpmsg.broadcastTemplateMsg(obj);  //发送消息，为特定topic
		return "normal";
	}
	
	@RequestMapping(path="/normal",method=RequestMethod.GET)
	public String f8(Model mdl,HttpServletRequest req){		//普通测试页
		log.info("Normal page vistor!");		
		
		return "normal";
	}
	
	@RequestMapping(path="/tp1",method=RequestMethod.GET)
	public String f67(Model mdl,HttpServletRequest req){	//订阅者页面，测试模板消息	
		log.info("Subscriber page,template!");		
		return "fifth";
	}
	

}

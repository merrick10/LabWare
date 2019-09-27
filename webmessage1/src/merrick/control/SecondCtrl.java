package merrick.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SecondCtrl {
	
	private static Logger log =  LogManager.getLogger(SecondCtrl.class);		
	
	@MessageMapping(value="")
	public void f1() {
		
		
	}
	

}

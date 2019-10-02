package merrick.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import merrick.entity.MessageEntity1;

@Controller
//@MessageMapping(value="/app")
public class SecondCtrl {
	
	private static Logger log =  LogManager.getLogger(SecondCtrl.class);		
	
	@MessageMapping(value="/msg1")
	@SendTo("/topic/msg1")
	public MessageEntity1 handlMsg(MessageEntity1 obj) {// "/app/msg1"
		log.info("Received msg,p1:" + obj.getProp1());
		log.info("Received msg,p2:" + obj.getProp2());
		
		MessageEntity1 r = new MessageEntity1();
		r.setProp1("AA");
		r.setProp2("BB");
		return r;
	}
	
/*	@SubscribeMapping({"/msg1"})
	public MessageEntity1 handlSubscription(MessageEntity1 obj) {// "/app/msg1" subscribe handle
		log.info("Received msg,p1:" + obj.getProp1() +","+obj.getProp2());
		
		MessageEntity1 out = new MessageEntity1();
		out.setProp1("XX");
		out.setProp2("YY");
		return out;
	}
	*/

}

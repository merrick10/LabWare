package merrick.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import merrick.entity.MessageEntity1;

@Controller
public class SecondCtrl {
	
	private static Logger log =  LogManager.getLogger(SecondCtrl.class);	
	
	@Autowired
	private SimpMessageSendingOperations simpMessageSendingOperations;
	
	
	@MessageMapping(value="/msg1")
	@SendTo("/topic/msg1")//返回值不会经过broker
	public MessageEntity1 handlMsg(MessageEntity1 obj) {// "/app/msg1"
		log.info("Received msg,p1:" + obj.getProp1());		
		MessageEntity1 r = new MessageEntity1();
		r.setProp1("AA");
		
		return r;//返回值，相当于给客户端的响应
	}
	
	@SubscribeMapping({"/msg2"})// "/app/msg2"
	@SendTo("/topic/msg2")//返回值不会经过broker
	public MessageEntity1 handlSubscription(MessageEntity1 obj) {// "/app/msg1" subscribe handle
		log.info("Received msg,p1:" + obj.getProp1() );
		
		simpMessageSendingOperations.convertAndSend("/topic/msg1",obj);//发送会经过broker//不会发给发送者
		MessageEntity1 out = new MessageEntity1();
		out.setProp1("XX");
		
		return out;//返回值，相当于给客户端的响应
	}
	
	
	@MessageMapping("/broadcast")// "/app/broadcast"
	public void broadcast(MessageEntity1 obj) {
		log.info("Received msg,p1:" + obj.getProp1());		
		simpMessageSendingOperations.convertAndSend("/topic/msg1",obj);//发送会经过broker//不会发给发送者
	}
	
	

}

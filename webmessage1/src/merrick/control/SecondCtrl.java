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
	@SendTo("/topic/msg1")//����ֵ���ᾭ��broker
	public MessageEntity1 handlMsg(MessageEntity1 obj) {// "/app/msg1"
		log.info("Received msg,p1:" + obj.getProp1());		
		MessageEntity1 r = new MessageEntity1();
		r.setProp1("AA");
		
		return r;//����ֵ���൱�ڸ��ͻ��˵���Ӧ
	}
	
	@SubscribeMapping({"/msg2"})// "/app/msg2"
	@SendTo("/topic/msg2")//����ֵ���ᾭ��broker
	public MessageEntity1 handlSubscription(MessageEntity1 obj) {// "/app/msg1" subscribe handle
		log.info("Received msg,p1:" + obj.getProp1() );
		
		simpMessageSendingOperations.convertAndSend("/topic/msg1",obj);//���ͻᾭ��broker//���ᷢ��������
		MessageEntity1 out = new MessageEntity1();
		out.setProp1("XX");
		
		return out;//����ֵ���൱�ڸ��ͻ��˵���Ӧ
	}
	
	
	@MessageMapping("/broadcast")// "/app/broadcast"
	public void broadcast(MessageEntity1 obj) {
		log.info("Received msg,p1:" + obj.getProp1());		
		simpMessageSendingOperations.convertAndSend("/topic/msg1",obj);//���ͻᾭ��broker//���ᷢ��������
	}
	
	

}

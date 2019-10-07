package merrick.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import merrick.entity.MessageEntity1;

/**
 * @author liumiao
 * 特定topic，消息发送
 *
 */
@Service
public class BroadTemplateMsgServiceImpl {
	
	private SimpMessageSendingOperations messaging;
	
	@Autowired
	public BroadTemplateMsgServiceImpl(SimpMessageSendingOperations messaging) {
		this.messaging = messaging;		
	}
	
	public void broadcastTemplateMsg(MessageEntity1 obj) {
		messaging.convertAndSend("/topic/template1", obj);
	}
	
	

}

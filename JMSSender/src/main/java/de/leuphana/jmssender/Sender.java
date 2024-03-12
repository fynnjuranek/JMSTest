package de.leuphana.jmssender;

import de.leuphana.jmsreceiver.Email;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TemporaryQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "senderMailbox")
    public void sendMessage() {
        System.out.println("Sending an email message.");
        Email email = jmsTemplate.execute(session -> {
            TemporaryQueue temporaryQueue = session.createTemporaryQueue();
//            MessageCreator messageCreator = new MessageCreator() {
//                @Override
//                public Message createMessage(Session session) throws JMSException {
//                    Message message = session.createObjectMessage(new Email("info@example.com", "Hello"));
//                    message.setJMSReplyTo(temporaryQueue);
//                    return message;
//                }
//            };
            MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws JMSException {
                    message.setJMSReplyTo(temporaryQueue);
                    return message;
                }
            };

            jmsTemplate.convertAndSend("receiverMailbox", new Email("info@example.com", "Hello"),
                messagePostProcessor);
            return (Email) jmsTemplate.receiveAndConvert(temporaryQueue);
        });
        if (email != null) {
            System.out.println("Response from: " + email.getTo()  + " Body: " + email.getBody());
        }

    }

}

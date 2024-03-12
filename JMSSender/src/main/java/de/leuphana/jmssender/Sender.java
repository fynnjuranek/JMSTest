package de.leuphana.jmssender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "senderMailbox")
    public void sendMessage() {

//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        Connection connection = connectionFactory.createConnection();
//        Session session =

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
//        Destination destination =
//        MessageProducer producer = session.createProducer("receiverMailbox");
//        ObjectMessage objectMessage = session.createObjectMessage(new Email("info@example.com", "Hello"));
//        jmsTemplate.sendAndReceive(new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(new Email("info@example.com", "Hello"));
//            }
//        });
//        jmsTemplate.convertAndSend("receiverMailbox", new Email("info@example.com", "Hello")
//                );
        jmsTemplate.
    }
}

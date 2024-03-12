package de.leuphana.jmsreceiver;

import de.leuphana.jmsreceiver.database.TestMongoDB;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    TestMongoDB testMongoDB;
    // If the method is annotated there is no need for @EnableJMS
    @JmsListener(destination = "receiverMailbox")
    public String receiveMessage(Email email, Message message) throws JMSException {

        Email sendMail = testMongoDB.save(email);

        System.out.println("Received <" + email + ">");
//        message.setJMSReplyTo(message.getJMSReplyTo());
//        message.setJMSReplyTo(message.getJMSDestination());
        return "sendMail";
    }
}

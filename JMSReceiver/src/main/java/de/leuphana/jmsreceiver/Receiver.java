package de.leuphana.jmsreceiver;

import de.leuphana.jmsreceiver.database.TestMongoDB;
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
    public Email receiveMessage(Email emailMessage) {
        System.out.println("Received email: " + emailMessage.getBody());
        Email sendMail = testMongoDB.save(emailMessage);
        return new Email("info@response.com", "Response mail!");
    }
}

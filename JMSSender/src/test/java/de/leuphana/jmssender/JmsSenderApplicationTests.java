package de.leuphana.jmssender;

import de.leuphana.jmsreceiver.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

@SpringBootTest
class JmsSenderApplicationTests {

    @Autowired
    JmsTemplate  jmsTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void canMessageBeSent() {
        Email email = new Email();
        email.setBody("Hello this is a new test mail");
        email.setTo("info@test.com");
        jmsTemplate.convertAndSend("receiverMailbox",email);
    }

}

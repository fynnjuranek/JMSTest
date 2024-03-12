package de.leuphana.jmssender;


import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

//@Configuration
public class ArtemisConfig  {
//    @Value("${spring.artemis.broker-url}")
//    private String brokerUrl;
//
//    @Bean
//    public Queue queue() {
//        return new ActiveMQQueue("receiverMailbox");
//    }
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() throws JMSException {
//
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//        factory.setBrokerURL(brokerUrl);
//        return factory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() throws JMSException {
//        return  new JmsTemplate(activeMQConnectionFactory());
//    }
}

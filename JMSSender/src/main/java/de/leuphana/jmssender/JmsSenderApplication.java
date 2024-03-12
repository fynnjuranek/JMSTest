package de.leuphana.jmssender;

import de.leuphana.jmsreceiver.Email;
import jakarta.jms.*;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQDestination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.io.Serializable;

import static org.apache.activemq.artemis.jms.client.ActiveMQMessage.createMessage;


@SpringBootApplication

@EnableJms
public class JmsSenderApplication {

    public static void main(String[] args) throws JMSException {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(JmsSenderApplication.class, args);


    }


//    @Bean
//    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        // This provides all auto-configured defaults to this factory, including the message converter
//        configurer.configure(factory, connectionFactory);
//        // You could still override some settings if necessary.
//        return factory;
//    }


    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}

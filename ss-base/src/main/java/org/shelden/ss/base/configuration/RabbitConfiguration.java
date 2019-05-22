package org.shelden.ss.base.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class RabbitConfiguration implements RabbitListenerConfigurer {

    public static final String QUEUE_AUTH_LOGS = "auth-logs-queue";
    public static final String QUEUE_DEAD_AUTH_LOGS = "auth-logs-dead-queue";
    public static final String EXCHANGE_AUTH_LOGS = "auth-logs-exchange";

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    Queue crudLogsQueue() {
        return QueueBuilder.durable(QUEUE_AUTH_LOGS)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", QUEUE_DEAD_AUTH_LOGS)
                .withArgument("x-message-ttl", 30_000)
                .build();
    }

    @Bean
    Queue crudLogsDeadQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_AUTH_LOGS)
                .build();
    }

    @Bean
    TopicExchange crudLogsExchange() {
        return (TopicExchange) ExchangeBuilder.topicExchange(EXCHANGE_AUTH_LOGS)
                .build();
    }

    @Bean
    Binding crudLogsBinding(Queue crudLogsQueue, TopicExchange crudLogsExchange) {
        return BindingBuilder.bind(crudLogsQueue)
                .to(crudLogsExchange)
                .with(QUEUE_AUTH_LOGS);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        final RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(producerJackson2MessageConverter());
        return template;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

    @Bean
    MessageHandlerMethodFactory messageHandlerMethodFactory() {
        final DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}

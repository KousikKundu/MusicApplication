package com.stackroute.muzixmanager.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

  private String exchangeName = "user_exchange";
  private String trackQueue = "user_track_queue";


  @Bean
  DirectExchange directExchange(){
    return new DirectExchange(exchangeName);
  }


  @Bean
  Queue queueUserTrack() {
    return new Queue(trackQueue,false);
  }


  @Bean
  Binding bindingUserTrack(Queue queueUserTrack , DirectExchange exchange){

    return BindingBuilder.bind(queueUserTrack).to(exchange).with("user_track_routing");
  }

  @Bean
  public Jackson2JsonMessageConverter produceJackson2JsonMessageConverter(){
    return  new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(produceJackson2JsonMessageConverter());
    return rabbitTemplate;
  }
}

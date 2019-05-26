package com.stackroute.muzixrecommendersystem.config;

import com.stackroute.rabbitmq.domain.UserDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "user_track_queue")
    public void getUserDtofromRabbitMq(UserDTO userDTO){

        System.out.println("USER DTO" + userDTO.toString());

        System.out.println("USER TrackList" + userDTO.getTrackList().get(0).toString());

    }
}

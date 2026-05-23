package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Activity;
import com.fitness.aiservice.model.Recommendations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityMessageListener {


    private final ActivityAiService activityAiService;

    @RabbitListener(queues = "activity.queue")
    public void processActivity(Activity activity){
        System.out.println(">>> Received activity for processing: " + activity.getId());
        log.info("Received activity for processing : {}", activity.getId());
        
        Recommendations recommendation = activityAiService.generateRecommendation(activity);
        System.out.println(">>> Generated Recommendation:\n" + recommendation);
        log.info("Generated Recommendation: {}", recommendation);
    }
}

package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    ResponseEntity getTopic(){
        List<Topic> topic= topicService.getAllTopic();
       return new ResponseEntity(topic, HttpStatus.OK);

    }

    @GetMapping("/topics/{id}")
    ResponseEntity getTopicById(@PathVariable String id){
        System.out.println("--reached here---");
        Topic topic =null;
        try {
             topic = topicService.getTopicById(id);
        }catch (NotFoundException ex){
            System.out.println("NFE received at controller");
        }
        return new ResponseEntity(topic,HttpStatus.OK);

    }

    @PostMapping("/topics")
    ResponseEntity addTopic(@RequestBody  Topic topic){
        topicService.addTopic(topic);
        return new ResponseEntity(topic,HttpStatus.OK);
    }

    @PutMapping("/topics/{id}")
    ResponseEntity updateTopic(@RequestBody Topic topic ,@PathVariable String id){

        topicService.updateTopic(id,topic);
        return new ResponseEntity(topic,HttpStatus.OK);
    }

    @DeleteMapping("/topics/{id}")
    ResponseEntity deleteTopic(@RequestBody Topic topic ,@PathVariable String id)
    {
        topicService.deleteTopic(id);
        return new ResponseEntity(topic,HttpStatus.OK);
    }


}

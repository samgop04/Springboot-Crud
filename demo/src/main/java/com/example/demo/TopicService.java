package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static com.example.demo.TopicRepository.*;

@Service
public class TopicService {

   /* private List<Topic> topics=new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring Framework","Spring Framework description"),
            new Topic("SpringBoot","Spring Framework","Spring Framework description"),
            new Topic("SpringMethod","Spring Framework","Spring Framework description")
    ));*/
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopic(){
        //return topics;
        List<Topic>topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(String id)
    {
        return topicRepository.findById(id).orElse(null);
    }
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
        //topics.add(topic);
    }
    public void updateTopic (String id, Topic topic)
    {
        topicRepository.save(topic);
    }
    public void deleteTopic(String id)
    {
        topicRepository.deleteById(id);
    }


}

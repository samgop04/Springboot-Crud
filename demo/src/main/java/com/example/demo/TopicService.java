package com.example.demo;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopic(){
        return topicRepository.findAll();
    }

    public Topic getTopicById(String id) throws NotFoundException {
        Optional<Topic> topicFound = topicRepository.findById(id);
        if(!topicFound.isPresent()){
            throw new NotFoundException("Topic not found");
        }
        return topicFound.get();
    }
    public void addTopic(Topic topic) {
       Topic mTopic = topicRepository.getByName(topic.getName());
       if(mTopic!=null){
           throw new NullPointerException();
       }
        topicRepository.save(topic);
    }
    public void updateTopic (String id, Topic topic)
    {
        topic.setId(id);
        topicRepository.save(topic);

    }
    public void deleteTopic(String id)
    {
        topicRepository.deleteById(id);
    }


}

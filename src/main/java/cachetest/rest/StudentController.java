package cachetest.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cachetest.model.Thing;

@RestController
@RequestMapping(path="/student", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentController {

    private final static Logger log = LoggerFactory.getLogger(StudentController.class);
    
    @GetMapping(path="/get/{studentId}")
    @Cacheable(value = "studentNode", key="#studentId")
    public String getWord(@PathVariable long studentId) {

        log.info("getting student for {}", studentId); 
        
        return "{\"studentId\": \"" + studentId + "\"}";
    }
        
        
    @GetMapping(path="list")
    @Cacheable(value = "studentNode")
    public List<Thing> getTestList() {
        log.info("get the list");
        List<Thing> answer = new ArrayList<>();
        Thing one = new Thing();
        one.setOne("one");
        one.setTwo(2);
        answer.add(one);
        Thing two = new Thing();
        two.setOne("ein");
        two.setTwo(11);
        answer.add(two);
        return answer;
    }
    
}

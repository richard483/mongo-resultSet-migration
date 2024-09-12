package com.example.demo;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  @Value("${spring.data.mongodb.collection}")
  private String collectionName;

  @Autowired
  MongoTemplate mongoTemplate;

  @Transactional
  @PostMapping("/save")
  public Book save(@RequestBody Book book) {
    return mongoTemplate.save(book, collectionName);
  }

  @Transactional
  @PostMapping("/delete")
  public DeleteResult delete(@RequestBody String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(id));
    return mongoTemplate.remove(query, collectionName);
  }


}

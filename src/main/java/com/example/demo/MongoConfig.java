package com.example.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Value("${spring.data.mongodb.host}")
  private String host;

  @Value("${spring.data.mongodb.port}")
  private String port;

  @Value("${spring.data.mongodb.database}")
  private String database;

  @Value("${spring.data.mongodb.authentication-database}")
  private String authDatabase;

  @Value("${spring.data.mongodb.username}")
  private String username;

  @Value("${spring.data.mongodb.password}")
  private String password;

  @Override
  protected String getDatabaseName() {
    return database;
  }

  @Bean
  MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
    return new MongoTransactionManager(dbFactory);
  }

  @Override
  public MongoClient mongoClient() {
    return MongoClients.create("mongodb://" + username + ":" + password + "@" + host + ":"
        + port + "/" + database + "?authSource=" + authDatabase
        + "&minPoolSize=2&maxPoolSize=5&connectTimeoutMS=30000&socketTimeoutMS=30000");

  }

}
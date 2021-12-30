package com.shaan.graphqlsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class GraphqlSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlSampleApplication.class, args);
  }

}

package com.shaan.graphqlsample.client;

import com.shaan.graphqlsample.model.AuthorModel;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authorClient", url = "http://localhost:9081")
public interface AuthorFeignClient {

  @GetMapping(value = "/authors")
  List<AuthorModel> authors();

}

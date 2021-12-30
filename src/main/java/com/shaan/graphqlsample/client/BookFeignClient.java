package com.shaan.graphqlsample.client;

import com.shaan.graphqlsample.model.BookModel;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "bookClient", url = "http://localhost:9081")
public interface BookFeignClient {

  @GetMapping(value = "/books")
  List<BookModel> books();

}

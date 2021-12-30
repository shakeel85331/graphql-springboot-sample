package com.shaan.graphqlsample.service;

import com.shaan.graphqlsample.client.AuthorFeignClient;
import com.shaan.graphqlsample.model.AuthorModel;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorServiceExternal {

  private final AuthorFeignClient authorFeignClient;

  public List<AuthorModel> getAllAuthors() {
    return authorFeignClient.authors();
  }
}

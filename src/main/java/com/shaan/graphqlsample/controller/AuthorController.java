package com.shaan.graphqlsample.controller;

import com.shaan.graphqlsample.model.AuthorModel;
import com.shaan.graphqlsample.service.AuthorServiceExternal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class AuthorController {

  private final AuthorServiceExternal authorServiceExternal;

  @QueryMapping
  public List<AuthorModel> authors(){
    return authorServiceExternal.getAllAuthors();
  }

}

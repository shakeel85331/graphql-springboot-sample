package com.shaan.graphqlsample.service;

import com.shaan.graphqlsample.client.AuthorFeignClient;
import com.shaan.graphqlsample.client.BookFeignClient;
import com.shaan.graphqlsample.model.AuthorModel;
import com.shaan.graphqlsample.model.BookModel;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookServiceExternal {

  private final BookFeignClient bookClient;
  private final AuthorFeignClient authorFeignClient;

  public List<BookModel> getAllBooks() {
    return bookClient.books();
  }

  public AuthorModel getAuthorDetails(BookModel book) {
    List<AuthorModel> authors = authorFeignClient.authors();
    Optional<AuthorModel> authorObj = authors.stream().filter(author -> author.getId() == book.getAuthorId()).findAny();
    return Optional.ofNullable(authorObj).get().orElse(null);
  }


}

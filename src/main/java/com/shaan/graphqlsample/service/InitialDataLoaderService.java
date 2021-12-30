package com.shaan.graphqlsample.service;

import com.shaan.graphqlsample.entity.Book;
import com.shaan.graphqlsample.repository.BookRepository;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class InitialDataLoaderService {

  private final BookRepository bookRepository;

  @PostConstruct
  public void init() {
    log.info("Adding initial data to books db");
    bookRepository.save(Book.builder().authorId(1).publication("Some").title("SpaceX").build());
    bookRepository.save(Book.builder().authorId(7).publication("OReally").title("Java questions").build());
    bookRepository.save(Book.builder().authorId(12).publication("Janus").title("Web development").build());
    bookRepository.save(Book.builder().authorId(4).publication("Fantom").title("GHO").build());
  }

}

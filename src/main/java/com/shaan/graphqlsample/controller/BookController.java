package com.shaan.graphqlsample.controller;

import com.shaan.graphqlsample.entity.Book;
import com.shaan.graphqlsample.model.AuthorModel;
import com.shaan.graphqlsample.model.BookModel;
import com.shaan.graphqlsample.service.BookService;
import com.shaan.graphqlsample.service.BookServiceExternal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class BookController {

  private final BookService bookService;
  private final BookServiceExternal bookServiceExternal;

  // Using DB Data

  @QueryMapping
  public List<Book> books() {
    return bookService.getAllBooks();
  }

  @QueryMapping
  public Book book(@Argument int id) {
    return bookService.getBook(id);
  }

  @MutationMapping
  public Book updateBookTitle(@Argument int id, @Argument String title) {
    return bookService.updateBookTitle(id, title);
  }

  @MutationMapping
  public List<Book> books(@Argument Book book) {
    return bookService.addBook(book);
  }

  @MutationMapping
  public Book updateBookPublication(@Argument Book book) {
    return bookService.updateBookPublication(book);
  }


  // Using external service data

  @QueryMapping
  public List<BookModel> getBooks() {
    return bookServiceExternal.getAllBooks();
  }

  @SchemaMapping(typeName="Book", field="author")
  public AuthorModel author(BookModel book) {
    return bookServiceExternal.getAuthorDetails(book);
  }

}

package com.shaan.graphqlsample.service;

import com.shaan.graphqlsample.entity.Book;
import com.shaan.graphqlsample.model.AuthorModel;
import com.shaan.graphqlsample.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

  private final BookRepository bookRepository;

  public List<Book> getAllBooks(){
    return bookRepository.findAll();
  }

  public Book getBook(int bookId){
    return Optional.ofNullable(bookRepository.findById(bookId)).get().orElse(null);
  }

  public Book updateBookTitle(int id, String title) {
    Book book = getBook(id);
    book.setTitle(title);
    bookRepository.save(book);
    return book;
  }

  public List<Book> addBook(Book book) {
    bookRepository.save(book);
    return getAllBooks();
  }

  public Book updateBookPublication(Book book) {
    Book bookToBeUpdated = getBook(book.getId());
    bookToBeUpdated.setPublication(book.getPublication());
    bookRepository.save(bookToBeUpdated);
    return bookToBeUpdated;
  }

}

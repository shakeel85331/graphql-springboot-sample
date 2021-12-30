package com.shaan.graphqlsample.repository;

import com.shaan.graphqlsample.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface BookRepository extends JpaRepository<Book, Integer>, QuerydslPredicateExecutor<Book> {

}

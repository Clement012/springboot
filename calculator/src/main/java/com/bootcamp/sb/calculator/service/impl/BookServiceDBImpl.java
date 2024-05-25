package com.bootcamp.sb.calculator.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.bootcamp.sb.calculator.controller.BookOperation;
import com.bootcamp.sb.calculator.model.Book;
import com.bootcamp.sb.calculator.service.BookService;
import jakarta.annotation.PostConstruct;

@Service // bean
public class BookServiceDBImpl implements BookService{
  
  private final Map<Long,Book> bookMap = new HashMap<>();

  @Override
  public Map<Long,Book> getBookMap(){
    return this.bookMap;
  }
  
  @PostConstruct // Right after creating bookController bean and before server start completed
  public void init(){
    Book book1 = new Book("Jenny", LocalDate.of(2000, 10, 01));
    Book book2 = new Book("Vincent", LocalDate.of(2010, 10, 01));
    Book book3 = new Book("Elsa", LocalDate.of(2020, 10, 01));
    bookMap.put(book1.getId(), book1);
    bookMap.put(book2.getId(), book2);
    bookMap.put(book3.getId(), book3);
  }
//  @Autowired
//  private BookOperation bookOperation;
  
  @Override
  public Book getBook(String author){
    // login database
    // select , not found?
    // return new Book("SallyChan", LocalDate.of(2020, 01, 01));

    // stream ->
    if (author == null)
      return null;
    return this.bookMap.values().stream() //
    .filter(e -> e.getAuthor().equals(author)) //
    .findFirst() // return book object
    .orElse(null);
  }
}

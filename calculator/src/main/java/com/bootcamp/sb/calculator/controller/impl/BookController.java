package com.bootcamp.sb.calculator.controller.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.calculator.controller.BookOperation;
import com.bootcamp.sb.calculator.model.Book;
import com.bootcamp.sb.calculator.service.BookService;
import jakarta.annotation.PostConstruct;

@RestController // @Controller + ResponseBody -> toJSON
public class BookController implements BookOperation{
  
  // Controller layer should not contain business logic
  // for example, the way to "find a book by author" is a business logic

  // Controller -> Call service layer

  @Autowired
  @Qualifier(value = "bookServiceDBImpl")
  private BookService bookServiceFromDB;

  @Autowired
  @Qualifier(value = "bookServiceMemoryImpl")
  private BookService bookServiceFromMemory;
  
  @Override
  public Book getBook(String author){
   // return new BookServiceImpl().getBook(author);
   return bookServiceFromDB.getBook(author);
  }
   //Mock  
 /*Book book = bookService.getBook(author);
   book.setAuthor("Peter");  
   return book;  */

   @Override
   public LocalDate getBookPublishDate(String author){
    Book book;
    int x = 3;
    if (x > 5)
      book = bookServiceFromDB.getBook(author);
    else 
      book = bookServiceFromMemory.getBook(author);
    return book.getPublishDate();
   }
  }


package com.bootcamp.sb.calculator.service;

import java.util.Map;
import com.bootcamp.sb.calculator.model.Book;

public interface BookService {

  Book getBook(String author);

  Map<Long, Book> getBookMap();
} 

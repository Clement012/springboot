package com.bootcamp.sb.calculator.controller;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sb.calculator.model.Book;

public interface BookOperation {
  
  @GetMapping(value = "/books/author")
  Book getBook(@RequestParam String author);

  @GetMapping(value = "/books/publishDate")
  LocalDate getBookPublishDate(@RequestParam String author);

}

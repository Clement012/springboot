package com.bootcamp.sb.calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.sb.calculator.model.Student;

public interface StudentOperation {
  
  @GetMapping(value = "/students")
  public List<Student> getAll();

  @GetMapping(value = "/student/add")
  public List<Student> add(@RequestParam String name,
  @RequestParam(value = "id") int studentId);

  @GetMapping(value = "/students/ids")
  public int[] getAllIds();

  @GetMapping(value = "/student/remove")
  public List<Student> remove (@RequestParam String name);
}

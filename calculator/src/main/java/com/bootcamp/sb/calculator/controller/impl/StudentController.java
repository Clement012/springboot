package com.bootcamp.sb.calculator.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.controller.StudentOperation;
import com.bootcamp.sb.calculator.model.Student;

@Controller
@ResponseBody

public class StudentController implements StudentOperation {
  
  @Override
  public List<Student> getAll(){
    return Student.studentDB;
  }

  @Override
  public List<Student> add(@RequestParam String name,
  @RequestParam(value = "id") int studentId){
    Student.studentDB.add(new Student(studentId, name));
    return Student.studentDB;
  }

  @Override
  public int[] getAllIds(){
    return Student.studentDB.stream()
    .mapToInt(e -> e.getIdNumber())
    .toArray();
  }

  @Override
  public List<Student> remove (@RequestParam String name){
    if (name == null)
     return null;
    List<Student> studentsToBeRemoved = new ArrayList<>();
    for (Student s : Student.studentDB){
      if (name.equals(s.getName()))
       studentsToBeRemoved.add(s);
    }
    return Student.studentDB.removeAll(studentsToBeRemoved)
    ? studentsToBeRemoved
    : null;
    // if you want to return List<Integer>
    // .map(e -> e.getIdNumber()) //
    // .collect(Collectors.toList());

  // API: add student (URL -> id name)
  // API: get student list
  // API: remove student by student name
  // API: get all student id -> int[]

  // API: get Student by Student name
  }
}

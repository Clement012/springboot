package com.example.sb.exercise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.exercise.controller.ExerciseController;
import com.example.sb.exercise.dto.Calculation;
import com.example.sb.exercise.model.Operation;
import com.example.sb.exercise.service.ExerciseService;


@WebMvcTest(ExerciseController.class)
public class ExerciseControllerTest { 

  //Test
  //void test

  //Autowired
  //private MockMvc mockMvc;

  //MockBean
  //private ExerciseService exerciseService;

  /*Test
  void testMvc(){
  mockMvc.perform(MockMvcRequestBuilders.get("/get"))
      .andExpect()
  }*/
  }   
  
/*   
  

  // MockBean 

  @Test
  void insertXYSuccess() throws NumberFormatException{  //asserttrue
     String x = "123";
     String y = ""; 
     String z = "ABC";
     double xx = Double.parseDouble(x);
     double yy = Double.parseDouble(y);
     double zz = Double.parseDouble(z);
     assertTrue(null); // lambda?
    }
   @Test
   void insertOperationSuccess(){
    assertTrue(Operation.ADD != null);
    assertEquals("ADD", Operation.ADD);

   }
    
  

  @Test
  void calculateSuccess(){ // Mockito.when after check type
    String x;
    String y;
    double xx = Double.parseDouble(x);
    double yy = Double.parseDouble(y);
    double result = new Calculation(xx, yy, null, null)
    assertEquals(23, )
  }
  @Test 
  void mockMvcSuccess(){

  } */


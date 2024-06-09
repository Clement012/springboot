package com.example.sb.bc_forum;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.sb.bc_forum.controller.impl.BcForumController;
import com.example.sb.bc_forum.model.User;
import com.example.sb.bc_forum.service.BcForumService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BcForumController.class)
public class BcForumControllerTest {
  
  //MockBean 
  //private BcForumService bcForumService;
  //

  @Autowired
  private MockMvc mockMvc;

  @Test
  void mvcTest() throws Exception{
    
    String json = mockMvc.perform(get("/users")).andReturn()
        .getResponse().getContentAsString();

    User[] users = new ObjectMapper().readValue(json, User[].class);

    List<User> userList = Arrays.asList(users);

    // assertions/count in userList

    //mockMvc.perform(MockMvcRequestBuilders.get("/"))
  }
}

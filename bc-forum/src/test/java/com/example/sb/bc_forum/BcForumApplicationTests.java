package com.example.sb.bc_forum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.sb.bc_forum.config.AppConfig;
import com.example.sb.bc_forum.controller.impl.BcForumController;

@SpringBootTest
class BcForumApplicationTests {

	@Autowired
	private AppConfig appConfig;

	@Autowired
	private BcForumController BcForumController;
	
	@Test
	void contextLoads() {
		
	}

}

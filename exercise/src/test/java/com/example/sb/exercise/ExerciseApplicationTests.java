package com.example.sb.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.sb.exercise.service.ExerciseService;

@SpringBootTest
class ExerciseApplicationTests {  //  if Have Autowired?

	@Autowired
	private ExerciseService exerciseService; //Test Autowired Success

	@Test
	void contextLoads() {
	}

}

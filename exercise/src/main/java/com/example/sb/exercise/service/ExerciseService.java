package com.example.sb.exercise.service;

import com.example.sb.exercise.dto.Calculation;
import com.example.sb.exercise.model.Operation;

public interface ExerciseService {

  Calculation calculate(String x,String y,String operation);
}

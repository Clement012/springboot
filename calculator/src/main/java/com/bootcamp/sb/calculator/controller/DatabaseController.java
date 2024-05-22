package com.bootcamp.sb.calculator.controller;

import java.util.Arrays;
import java.util.Comparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DatabaseController {
  // belong to Class
    private static int[] arr = new int[] {10,-3,9};  

    // Design an Api, get the value from array by index.
    // index value checking
    // index range: if/ try&catch
    @GetMapping(value ="/database/value/{index}")
    public String get(@PathVariable String index){
      try{
        int idx = Integer.parseInt(index);
        return String.valueOf(arr[idx]);
      } catch (NumberFormatException e){
        return "the index should be an integer value";
      } catch (ArrayIndexOutOfBoundsException e){
        return "the index is out of array size";
      }
    }

    // API : sorting
    // stream
    @GetMapping(value ="/database/sorting")
    public void sort(){
      Comparator<Integer> descending = (i1,i2) -> i1.compareTo(i2) > 0 ? -1 : 1;
      
      // 0(nlogn)
      int[] newArr = Arrays.stream(arr)
          .boxed()
          .sorted(descending)
          .mapToInt(e -> e.intValue()) // Integer::intvalue
          .toArray();

      // 0(n)
      for(int i = 0; i < arr.length;i++){
        arr[i] = newArr[i];
      }
      // API : Return the array
      // API : create hashMap

      
    }
}

package demo.sb.restful.infra.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.sb.restful.dto.respdto.UserDTO;
import demo.sb.restful.infra.ApiResp;

public class ApiRespTest {
  public static void main(String[] args) {
    // JAVA 9
    List<String> strings = List.of("abc","def");
    // better performeance
    // Imutable:
   /*  strings.set(0, "hello");  UnsupportedOperationException
    strings.add("hello");
    strings.remove(0);
    */

    // JAVA 8
    Arrays.asList("abc","de");
    List<String> strings2 = Arrays.asList(new String[]{"abc","def"});

    strings2.set(0, "hello"); //OK, implies sorting
   // strings.add("hello");
   // strings.remove(0);

    new ArrayList<String>();
    new LinkedList<String>();

    ApiResp<UserDTO> response = ApiResp.<UserDTO>builder()
       .ok()
       .data(List.of(new UserDTO()))
       .build();

    // Test RestTemplate.getForObject()
    // 1. call Web API , return JSON
    // 2. using ObjectMapper for deserialization
    // Object -> JSON(Serialization)
    // Use wrapper class!
    ObjectMapper objectMapper = new ObjectMapper();
    String json = "";
    try{
    json = objectMapper.writeValueAsString(response);
    } catch (JsonProcessingException e){

    }
    System.out.println(json);
    
  //  TypeReference
  //  ApiResp<List<UserDTO>> response2 = objectMapper.readValue(null, null)
    
  }
}

package demo.sb.restful.infra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.sb.restful.dto.UserDTO;

public class ApiResp<T> {

  private int code;
  private String message;
  private List<T> data;

  public int getCode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }

  public List<T> getData(){
    return this.data;
  }

  public ApiResp(ApiRespBuilder<T> builder){
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static<T> ApiResp<T> builder(){
    return 
  }

  public static class ApiRespBuilder<T>{
    private int code;
    private String message;
    private List<T> data;

    public ApiRespBuilder<T> code(int code){  //Setter
      this.code = code;
      return this;
    }

    public ApiRespBuilder<T> message(String message){
      this.message = message;
      return this;
    }

    public ApiRespBuilder<T> ok(){
      this.code = 0;
      this.message = "OK";
      return this;
    }

 /*    public ApiRespBuilder<T> bad(){
      this.code = 99;
      this.message = "BAD";
      return this;
    }
*/
    public ApiRespBuilder<T> data(List<T> data){
      this.data = data;
      return this;
    }

    public ApiResp<T> build(){
      return new ApiResp<>(this);
    }
  }

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

    // Object -> JSON(Serialization)
    ObjectMapper objectMapper = new ObjectMapper();
    String json = "";
    try{
    json = objectMapper.writeValueAsString(response);
    } catch (JsonProcessingException e){

    }
    System.out.println(json);
  }
}

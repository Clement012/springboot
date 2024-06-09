package com.example.sb.bc_forum.infra;

import java.util.List;
import lombok.ToString;

@ToString
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

  public static<U> ApiRespBuilder<U> builder(){
    return new ApiRespBuilder<>();
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

  
}

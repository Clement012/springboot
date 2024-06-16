package com.example.sb.bc_forum.infra;

import java.util.List;

public class ApiResp<T> {

  private int code;
  private String message;
  private List<T> data;

  public ApiResp(ApiRespBuilder<T> builder){
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public int getCode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }

  public List<T> getData(){
    return this.data;
  }

  public String toString() {
    return "ApiResp(" //
        + "code=" + this.getCode() //
        + ", message=" + this.getMessage() //
        + ", data=" + String.valueOf(this.getData()) //
        + ")";
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

    public ApiRespBuilder<T> message(String message) {
      if (message == null)
        throw new NullPointerException("message cannot be null.");
      this.message = message;
      return this;
    }

    public ApiRespBuilder<T> error(ErrorCode errorCode) {
      if (errorCode == null)
        throw new NullPointerException("errorCode cannot be null.");
      this.code = errorCode.getCode();
      this.message = errorCode.getDesc();
      return this;
    }

    public ApiRespBuilder<T> sysCodeError(SysCode sysCode) {
      if (sysCode == null)
        throw new NullPointerException("errorCode cannot be null.");
      this.code = sysCode.getCode();
      this.message = sysCode.getDesc();
      return this;
    }


    public ApiRespBuilder<T> ok(){
      this.code = 00000;
      this.message = "Success";
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

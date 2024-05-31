package demo.sb.restful.infra;

import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.Getter;

// @RestControllerAdvice // @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(NumberFormatException.class) // catch
  public ErrorResponse numberFormatExceptionHandler(NumberFormatException e) {
    return ErrorResponse.of(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  }

  @ExceptionHandler(NullPointerException.class) // catch
  public ErrorResponse nullPointerExceptionHandler(NullPointerException e) {
    return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  }

  @ExceptionHandler(ArithmeticException.class) // catch
  public ErrorResponse arithmeticExceptionHandler(ArithmeticException e) {
    return ErrorResponse.of(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
  }

  // Alternative
  // @ExceptionHandler({NumberFormatException.class, NullPointerException.class,
  //     ArithmeticException.class})
  // public ErrorResponse exceptionHandler(RuntimeException e) {
  //   if (e instanceof NumberFormatException) {
  //     return ErrorResponse.of(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  //   } else if (e instanceof NullPointerException) {
  //     return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  //   } else if (e instanceof ArithmeticException) {
  //     return ErrorResponse.of(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
  //   }
  //   return ErrorResponse.of(99999, "Unhandled Exception.");
  // }

  @Getter
  private enum ErrorCode {
    NPE(99, "Null Pointer Exception."), //
    NFE(99, "Number Format Exception."), //
    AE(99, "Arithmetic Exception."), //
    ;

    private int code;
    private String desc;

    private ErrorCode(int code, String desc) {
      this.code = code;
      this.desc = desc;
    }
  }

}

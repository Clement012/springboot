package demo.sb.restful.infra;

public class NotFoundException extends BusinessRuntimeException {
  
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }

  // public NotFoundException(SysCode sysCode) {
  //   super(sysCode);
  // }

}

package cn.buk.api.vaas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 基础DTO类，返回接口错误代码和错误信息
 * @author yfdai
 */
public class BaseResponse {

  /**
   * 接口格式的版本号
   */
  private String version = "1.0";

  private int errorCode;

  @JsonInclude(Include.NON_NULL)
  private String errorMsg;

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }


  public String getVersion() {
    return version;
  }
}

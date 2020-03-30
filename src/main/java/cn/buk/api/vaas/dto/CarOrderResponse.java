package cn.buk.api.vaas.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 租车订单
 * @author yfdai
 */
public class CarOrderResponse {

  /**
   * 格式版本号
   */
  private String version;

  /**
   * 错误代码
   * 0-调用成功
   */
  private int errorCode;

  private String errorMsg;

  @JSONField(name = "data")
  private CarOrderDto carOrderDto;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

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

  public CarOrderDto getCarOrderDto() {
    return carOrderDto;
  }

  public void setCarOrderDto(CarOrderDto carOrderDto) {
    this.carOrderDto = carOrderDto;
  }
}

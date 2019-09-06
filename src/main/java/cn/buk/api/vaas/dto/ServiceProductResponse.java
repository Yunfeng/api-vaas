package cn.buk.api.vaas.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务产品API DTO
 * @author yfdai
 */
public class ServiceProductResponse extends BaseResponse {

  private List<ServiceProductDto> datas;

  public List<ServiceProductDto> getDatas() {
    if (datas == null) {
      datas = new ArrayList<>();
    }
    return datas;
  }

  public void setDatas(List<ServiceProductDto> datas) {
    this.datas = datas;
  }
}

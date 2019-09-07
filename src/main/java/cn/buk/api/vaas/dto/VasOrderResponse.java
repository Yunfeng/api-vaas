package cn.buk.api.vaas.dto;

/**
 * 服务订单详情反馈
 * @author yfdai
 */
public class VasOrderResponse extends BaseResponse {

  private VasOrderDto data;


  public VasOrderDto getData() {
    return data;
  }

  public void setData(VasOrderDto data) {
    this.data = data;
  }
}

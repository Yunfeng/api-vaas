package cn.buk.api.vaas.dto;

/**
 * 创建服务订单返回结果
 * @author yfdai
 */
public class VasOrderCreateResponse extends BaseResponse {

  /**
   * 生成的订单号，多个会用逗号隔开
   */
  private String orderNos;

  public void setOrderNos(String orderNos) {
    this.orderNos = orderNos;
  }

  public String getOrderNos() {
    return orderNos;
  }
}

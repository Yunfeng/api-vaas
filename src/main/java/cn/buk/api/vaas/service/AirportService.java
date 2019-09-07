package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.BaseResponse;
import cn.buk.api.vaas.dto.ServiceProductResponse;
import cn.buk.api.vaas.dto.VasOrderCreateResponse;
import cn.buk.api.vaas.dto.VasOrderDto;
import cn.buk.api.vaas.dto.VasOrderResponse;

/**
 * 机场服务接口
 * @author yfdai
 */
public interface AirportService {

  /**
   * 获取服务列表
   * @return ServiceProductResponse 服务产品列表对象
   */
  ServiceProductResponse getServiceProducts();

  /**
   * 获取账户的余额
   * @return
   */
  String getAccountBalance();

  /**
   * 创建服务订单
   * @return
   */
  VasOrderCreateResponse createServiceOrder(VasOrderDto dto);

  /**
   * 获取服务订单详情
   * @param orderNo
   * @return
   */
  VasOrderResponse getServiceOrder(String orderNo);

  /**
   * 取消服务订单
   * @param orderNo 订单号
   * @param reason 取消理由
   * @return
   */
  BaseResponse cancelServiceOrder(String orderNo, String reason);
}

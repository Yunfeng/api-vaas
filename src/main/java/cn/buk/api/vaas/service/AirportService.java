package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.ServiceProductDto;
import cn.buk.api.vaas.dto.ServiceProductResponse;

/**
 * 机场服务接口
 * @author yfdai
 */
public interface AirportService {

  /**
   * 获取服务列表
   */
  ServiceProductResponse getServiceProducts();
}

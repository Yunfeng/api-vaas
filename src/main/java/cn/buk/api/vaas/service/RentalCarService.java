package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.CarOrderResponse;

import java.util.Date;

/**
 * 租车服务接口
 * @author yfdai
 */
public interface RentalCarService {



  /**
   * 查询租车价格
   */
  CarOrderResponse searchRentalPrice(int useType, int cityId, String airportCode,
                                     String terminalNo, String flightNo, String departure, String arrival, Date useDateTime);

}

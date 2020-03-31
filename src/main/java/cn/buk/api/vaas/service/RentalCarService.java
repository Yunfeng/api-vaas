package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.CarOrderResponse;
import cn.buk.api.vaas.dto.CityDto;

import java.util.Date;
import java.util.List;

/**
 * 租车服务接口
 * @author yfdai
 */
public interface RentalCarService {

  /**
   * 查找提供租车服务的城市
   * @return
   */
  List<CityDto> searchRentalCities();


  /**
   * 查询租车价格
   */
  CarOrderResponse searchRentalPrice(int useType, int cityId, String airportCode,
                                     String terminalNo, String flightNo, String departure, String arrival, Date useDateTime);

}

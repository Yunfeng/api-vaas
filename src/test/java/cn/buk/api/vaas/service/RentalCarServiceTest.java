package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.*;
import cn.buk.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class RentalCarServiceTest {

  private RentalCarService service;

  @BeforeEach
  void setUp() {
    service = new RentalCarServiceImpl("http://40.73.77.84/vaas-api", "shangyou", "a0a2eb10f5794e34539091c5c00af1ff");
  }


  @Test
  void searchRentalPrice() {

    Date useDateTime = DateUtil.createDate(2020, 4, 10);
    useDateTime = DateUtil.setTimeOnDate(useDateTime, 10, 30, 0);

    CarOrderResponse info = service.searchRentalPrice(1, 2, "PVG", "T2", "MU888",
            "", "常德路1号", useDateTime);

    assertNotNull(info);

    assertEquals("1.0", info.getVersion());
    assertEquals(0, info.getErrorCode());

    CarOrderDto dto = info.getCarOrderDto();
    assertNotNull(dto);

    assertEquals(1, dto.getUseType());
    assertEquals(0, dto.getStatus());
    assertEquals(2, dto.getCityId());
    assertEquals("上海", dto.getCityName());
    assertEquals("PVG", dto.getAirportCode());
    assertEquals("MU888", dto.getFlightNo());
    assertEquals("上海市浦东机场T2航站楼", dto.getDepartureAddress());
    assertEquals("常德路1号", dto.getArrivalAddress());
    assertEquals("2020-04-10 10:30", DateUtil.formatDate(dto.getUseTime(), "yyyy-MM-dd HH:mm"));

    assertNotNull(dto.getPrices());
    assertEquals(1, dto.getPrices().size());
    assertEquals(4, dto.getPrices().get(0).getVehicleTypeId());
    assertEquals("商务型", dto.getPrices().get(0).getVehicleTypeName());
    assertEquals(334, dto.getPrices().get(0).getPrice());
  }

}
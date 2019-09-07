package cn.buk.api.vaas.service;

import static org.junit.jupiter.api.Assertions.*;

import cn.buk.api.vaas.dto.BaseResponse;
import cn.buk.api.vaas.dto.ServiceProductDto;
import cn.buk.api.vaas.dto.ServiceProductResponse;
import cn.buk.api.vaas.dto.VasOrderCreateResponse;
import cn.buk.api.vaas.dto.VasOrderDto;
import cn.buk.api.vaas.dto.VasOrderFlightDto;
import cn.buk.api.vaas.dto.VasOrderPassengerDto;
import cn.buk.api.vaas.dto.VasOrderResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirportServiceTest {

  private AirportService service;

  @BeforeEach
  void setUp() {
    service = new AirportServiceImpl("http://40.73.77.84/vaas-api", "shangyou", "a0a2eb10f5794e34539091c5c00af1ff");
  }


  @Test
  void getServiceProducts() {

    ServiceProductResponse rs = service.getServiceProducts();

    assertNotNull(rs);
    assertEquals(0, rs.getErrorCode());
    assertEquals(5, rs.getDatas().size());

    for(ServiceProductDto dto: rs.getDatas()) {
      System.out.println(dto.getProductCode() + ": " + dto.getProductName() + ", " + dto.getProductType());
    }
  }

  @Test
  void getAccountBalance() {
    String jsonStr = service.getAccountBalance();
    System.out.println(jsonStr);
  }

  @Test
  void test_createServiceOrder() {
    VasOrderDto dto = new VasOrderDto();
    dto.setProductCode("40");
    dto.setProductName("国内登机牌办理");

    VasOrderFlightDto flightDto = new VasOrderFlightDto();
    flightDto.getFlight().setFlightNo("MU9999");
    flightDto.getFlight().setDepartureDate("2019-12-01");
    dto.getFlights().add(flightDto);

    VasOrderPassengerDto passengerDto = new VasOrderPassengerDto();
    passengerDto.setName("麻子");

    dto.getPassengers().add(passengerDto);

    dto.setExternalOrderNo("1234");


    VasOrderCreateResponse response = service.createServiceOrder(dto);

    assertNotNull(response);
    assertEquals(0, response.getErrorCode());
  }

  @Test
  void test_getServiceOrder() {
    VasOrderResponse response = service.getServiceOrder("20190907DD00005");

    assertNotNull(response);
    assertEquals(0, response.getErrorCode());

    assertEquals("1234", response.getData().getExternalOrderNo());
    assertEquals("20190907DD00005", response.getData().getOrderNo());
    assertEquals(0, response.getData().getStatus());
  }

  @Test
  void test_cancelServiceOrder() {
    BaseResponse response = service.cancelServiceOrder("20190907DD00005", "取消测试");

    assertNotNull(response);
    assertEquals(-10020, response.getErrorCode());

  }
}
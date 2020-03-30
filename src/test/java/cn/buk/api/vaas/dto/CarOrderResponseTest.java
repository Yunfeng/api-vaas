package cn.buk.api.vaas.dto;

import cn.buk.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarOrderResponseTest {
  private String getTemplateContent(final String fileName) throws Exception{
    InputStream inputStream = getClass().getResourceAsStream(fileName);
    assertNotNull(inputStream, "Test file missing." + fileName);

    int length = inputStream.available();
    byte bytes[] = new byte[length];
    inputStream.read(bytes);
    inputStream.close();
    String str =new String(bytes, StandardCharsets.UTF_8);
//    return EncryptUtil.decodeUnicode(str);
    return str;
  }

  @Test
  public void convertCarOrderResponse() throws Exception {
    final String jsonStr = getTemplateContent("/car_order_response_1.json");

    CarOrderResponse info = JSON.parseObject(jsonStr, CarOrderResponse.class);

    assertNotNull(info);

    assertEquals("1.0", info.getVersion());
    assertEquals(0, info.getErrorCode());

    CarOrderDto dto = info.getCarOrderDto();
    assertNotNull(dto);
    assertEquals("20200330CJ00002", dto.getOrderNo());
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
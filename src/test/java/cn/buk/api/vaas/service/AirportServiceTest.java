package cn.buk.api.vaas.service;

import static org.junit.jupiter.api.Assertions.*;

import cn.buk.api.vaas.dto.ServiceProductResponse;
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
  }
}
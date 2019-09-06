package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.ServiceProductResponse;
import cn.buk.api.vaas.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author yfdai
 */
public class AirportServiceImpl implements AirportService {

  private final String apiBaseUrl;

  private final String username;

  private final String secretKey;

  AirportServiceImpl(String apiBaseUrl, String username, String secretKey) {
    this.apiBaseUrl = apiBaseUrl;
    this.username = username;
    this.secretKey = secretKey;
  }

  @Override
  public ServiceProductResponse getServiceProducts() {
    final String apiUrl = apiBaseUrl + "/services?";

    System.out.println(apiUrl);

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));

    String jsonStr = HttpUtil.getUrl(apiUrl, params);

    return JSON.parseObject(jsonStr, ServiceProductResponse.class);
  }
}

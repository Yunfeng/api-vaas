package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.BaseResponse;
import cn.buk.api.vaas.dto.ServiceProductResponse;
import cn.buk.api.vaas.dto.VasOrderCreateResponse;
import cn.buk.api.vaas.dto.VasOrderDto;
import cn.buk.api.vaas.dto.VasOrderResponse;
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

  private AirportServiceImpl() {
    this.apiBaseUrl = null;
    this.username = null;
    this.secretKey = null;
  }

  public AirportServiceImpl(String apiBaseUrl, String username, String secretKey) {
    this.apiBaseUrl = apiBaseUrl;
    this.username = username;
    this.secretKey = secretKey;
  }

  @Override
  public ServiceProductResponse getServiceProducts() {
    final String apiUrl = apiBaseUrl + "/services?";

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));

    String jsonStr = HttpUtil.getUrl(apiUrl, params);

    return JSON.parseObject(jsonStr, ServiceProductResponse.class);
  }

  @Override
  public String getAccountBalance() {
    final String apiUrl = apiBaseUrl + "/account/balance?";

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));

    String jsonStr = HttpUtil.getUrl(apiUrl, params);

    return jsonStr;

//    return JSON.parseObject(jsonStr, ServiceProductResponse.class);
  }

  @Override
  public VasOrderCreateResponse createServiceOrder(VasOrderDto dto) {
    final String apiUrl = apiBaseUrl + "/services/order?"
        + "username=" + username
        + "&secretKey=" + secretKey;

    String jsonPost = JSON.toJSONString(dto);

    System.out.println(jsonPost);

    String jsonStr = HttpUtil.postUrl(apiUrl, jsonPost);

    System.out.println(jsonStr);

    return JSON.parseObject(jsonStr, VasOrderCreateResponse.class);
  }

  @Override
  public VasOrderResponse getServiceOrder(String orderNo) {
    final String apiUrl = apiBaseUrl + "/services/order?";

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));
    params.add(new BasicNameValuePair("orderNo", orderNo));


    String jsonStr = HttpUtil.getUrl(apiUrl, params);

    return JSON.parseObject(jsonStr, VasOrderResponse.class);
  }

  @Override
  public BaseResponse cancelServiceOrder(String orderNo, String reason) {
    final String apiUrl = apiBaseUrl + "/services/order/canceled";

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));
    params.add(new BasicNameValuePair("orderNo", orderNo));
    params.add(new BasicNameValuePair("remark", reason));


    String jsonStr = HttpUtil.postUrl(apiUrl, params);

    System.out.println(jsonStr);

    return JSON.parseObject(jsonStr, VasOrderResponse.class);
  }
}

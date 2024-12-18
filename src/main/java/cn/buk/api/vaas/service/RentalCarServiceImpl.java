package cn.buk.api.vaas.service;

import cn.buk.api.vaas.dto.*;
import cn.buk.api.vaas.util.HttpUtil;
import cn.buk.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yfdai
 */
public class RentalCarServiceImpl extends AbstractBaseService implements RentalCarService {

  private RentalCarServiceImpl() {
    super();
  }

  public RentalCarServiceImpl(String apiBaseUrl, String username, String secretKey) {
    super(apiBaseUrl, username, secretKey);
  }

  @Override
  public List<CityDto> searchRentalCities() {
    final String apiUrl = apiBaseUrl + "/data/cities";

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));
    String jsonStr = HttpUtil.postUrl(apiUrl, params);

    System.out.println(apiUrl);
    System.out.println(jsonStr);

    return JSON.parseArray(jsonStr, CityDto.class);
  }

  @Override
  public CarOrderResponse searchRentalPrice(int useType, int cityId, String airportCode,
                                String terminalNo, String flightNo, String departure, String arrival, Date useDateTime) {
    final String apiUrl = apiBaseUrl + "/car/price";

    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("secretKey", secretKey));
    params.add(new BasicNameValuePair("useType", useType + ""));
    params.add(new BasicNameValuePair("cityId", cityId + ""));
    params.add(new BasicNameValuePair("airportCode", airportCode));
    params.add(new BasicNameValuePair("terminalNo", terminalNo));
    params.add(new BasicNameValuePair("flightNo", flightNo));
    params.add(new BasicNameValuePair("departure", departure));
    params.add(new BasicNameValuePair("arrival", arrival));
    params.add(new BasicNameValuePair("useDate", DateUtil.formatDate(useDateTime, "yyyy-MM-dd")));
    params.add(new BasicNameValuePair("useTime", DateUtil.formatDate(useDateTime, "HH:mm")));

    String jsonStr = HttpUtil.postUrl(apiUrl, params);

    System.out.println(apiUrl);
    System.out.println(jsonStr);

    return JSON.parseObject(jsonStr, CarOrderResponse.class);
  }

}

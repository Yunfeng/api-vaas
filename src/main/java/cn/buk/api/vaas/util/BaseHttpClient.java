package cn.buk.api.vaas.util;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;

/**
 * @author yfdai
 * @date 2017-03-30
 */
public class BaseHttpClient {

  /**
   * HTTP connection timeout
   */
  protected static int CONNECTION_TIMEOUT = 60000;

  /**
   * HTTP socket connection timeout
   */
  protected static int SO_TIMEOUT = 60000;

  protected static PoolingHttpClientConnectionManager cm = null;

  protected static CloseableHttpClient createHttpClient() {
    return createHttpClient(null, null);
  }

  protected static CloseableHttpClient createHttpClient(String proxyHost, String proxyPort) {
    if (cm == null) {
      cm = new PoolingHttpClientConnectionManager();
      cm.setMaxTotal(100);
    }

    int port = 0;
    try {
      if (proxyPort != null) {
        port = Integer.parseInt(proxyPort);
      }
    } catch (Exception ex) {
    }

    CloseableHttpClient httpClient;
    if (proxyHost == null || proxyHost.trim().length() == 0 || port <= 0) {

      httpClient = HttpClients.custom().setConnectionManager(cm).build();
    } else {
      HttpHost proxy = new HttpHost(proxyHost, port);
      DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
      httpClient = HttpClients.custom()
          .setConnectionManager(cm)
          .setRoutePlanner(routePlanner)
          .build();
    }

    return httpClient;
  }
}

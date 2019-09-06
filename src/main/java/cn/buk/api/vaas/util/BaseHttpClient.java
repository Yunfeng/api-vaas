package cn.buk.api.vaas.util;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

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

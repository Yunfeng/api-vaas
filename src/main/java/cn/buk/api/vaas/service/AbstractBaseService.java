package cn.buk.api.vaas.service;

/**
 * @author yfdai
 */
public abstract class AbstractBaseService {

  protected final String apiBaseUrl;

  protected final String username;

  protected final String secretKey;

  protected AbstractBaseService() {
    this.apiBaseUrl = null;
    this.username = null;
    this.secretKey = null;
  }

  protected AbstractBaseService(String apiBaseUrl, String username, String secretKey) {
    this.apiBaseUrl = apiBaseUrl;
    this.username = username;
    this.secretKey = secretKey;
  }
}

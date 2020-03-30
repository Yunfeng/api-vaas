package cn.buk.api.vaas.dto;

/**
 * 位置：经纬度坐标
 *
 * @author yfdai
 */
public class LocationDto {

  private String longitude;

  private String latitude;

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
}

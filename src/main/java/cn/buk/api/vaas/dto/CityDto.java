package cn.buk.api.vaas.dto;

/**
 * 城市信息DTO
 *
 * @author yfdai
 */
public class CityDto {

  private int id;

  private String name;

  private String cityCode;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

}

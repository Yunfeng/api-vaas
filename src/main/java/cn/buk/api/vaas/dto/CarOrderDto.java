package cn.buk.api.vaas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;
import java.util.List;

/**
 * 租车订单
 * @author yfdai
 */
public class CarOrderDto {

  private String orderNo;

  /**
   * 用车类型
   * 1-接飞机，2-送飞机，3-接火车，4-送火车
   */
  private int useType;

  /**
   * 用车城市
   */
  private int cityId;

  /**
   * 城市名
   */
  @JsonInclude(Include.NON_NULL)
  private String cityName;

  /**
   * 接送的机场代码
   */
  private String airportCode;

  /**
   * 航班号
   */
  private String flightNo;

  /**
   * 出发地址
   */
  private String departureAddress;

  /**
   * 到达地址
   */
  private String arrivalAddress;

  /**
   * 出发位置
   */
  private LocationDto departureLocation = new LocationDto();

  /**
   * 到达位置
   */
  private LocationDto arrivalLocation = new LocationDto();

  /**
   * 用车时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
  private Date useTime;

  /**
   * 订单状态
   */
  private int status;

  /**
   * 询价时用来返回价格
   */
  @JsonInclude(Include.NON_NULL)
  private List<VehiclePriceDto> prices;


  public int getUseType() {
    return useType;
  }

  public void setUseType(int useType) {
    this.useType = useType;
  }

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  public String getAirportCode() {
    return airportCode;
  }

  public void setAirportCode(String airportCode) {
    this.airportCode = airportCode;
  }

  public String getDepartureAddress() {
    return departureAddress;
  }

  public void setDepartureAddress(String departureAddress) {
    this.departureAddress = departureAddress;
  }

  public String getArrivalAddress() {
    return arrivalAddress;
  }

  public void setArrivalAddress(String arrivalAddress) {
    this.arrivalAddress = arrivalAddress;
  }

  public Date getUseTime() {
    return useTime;
  }

  public void setUseTime(Date useTime) {
    this.useTime = useTime;
  }

  public LocationDto getDepartureLocation() {
    return departureLocation;
  }

  public void setDepartureLocation(LocationDto departureLocation) {
    this.departureLocation = departureLocation;
  }

  public LocationDto getArrivalLocation() {
    return arrivalLocation;
  }

  public void setArrivalLocation(LocationDto arrivalLocation) {
    this.arrivalLocation = arrivalLocation;
  }

  public List<VehiclePriceDto> getPrices() {
    return prices;
  }

  public void setPrices(List<VehiclePriceDto> prices) {
    this.prices = prices;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getFlightNo() {
    return flightNo;
  }

  public void setFlightNo(String flightNo) {
    this.flightNo = flightNo;
  }

}

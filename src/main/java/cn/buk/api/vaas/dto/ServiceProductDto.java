package cn.buk.api.vaas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

/**
 * @author yfdai
 */
public class ServiceProductDto {

  private int id;

  /**
   * 10开头表示保险
   */
  @JsonInclude(Include.NON_NULL)
  private String productCode; //商品代码：

  /**
   * 0 - 保险
   */
  private int productType; //商品类型： 保险，门票等

  @JsonInclude(Include.NON_NULL)
  private String productName; //商品名称：航意险，延误险等

  @JsonInclude(Include.NON_NULL)
  private String productDesc; // 产品描述

  private int price; //价格

  /**
   * 适用机场
   */
  @JsonInclude(Include.NON_NULL)
  private String applicableAirports;

  /**
   * 排除机场
   */
  @JsonInclude(Include.NON_NULL)
  private String excludedAirports;

  /**
   * 适用航空公司
   */
  @JsonInclude(Include.NON_NULL)
  private String applicableAirlines;

  /**
   * 排除航空公司
   */
  @JsonInclude(Include.NON_NULL)
  private String excludedAirlines;


  @JsonInclude(Include.NON_NULL)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
  private Date createTime;

  @JsonInclude(Include.NON_NULL)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
  private Date lastUpdate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public int getProductType() {
    return productType;
  }

  public void setProductType(int productType) {
    this.productType = productType;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getApplicableAirports() {
    return applicableAirports;
  }

  public void setApplicableAirports(String applicableAirports) {
    this.applicableAirports = applicableAirports;
  }

  public String getExcludedAirports() {
    return excludedAirports;
  }

  public void setExcludedAirports(String excludedAirports) {
    this.excludedAirports = excludedAirports;
  }

  public String getApplicableAirlines() {
    return applicableAirlines;
  }

  public void setApplicableAirlines(String applicableAirlines) {
    this.applicableAirlines = applicableAirlines;
  }

  public String getExcludedAirlines() {
    return excludedAirlines;
  }

  public void setExcludedAirlines(String excludedAirlines) {
    this.excludedAirlines = excludedAirlines;
  }
}

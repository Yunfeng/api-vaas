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
   * 商品代码
   */
  private String productCode;

  /**
   * 商品类型： 保险，门票等
   */
  private int productType;

  /**
   * 商品名称：航意险，延误险等
   */
  private String productName;

  /**
   * 产品描述
   */
  private String productDesc;

  /**
   * 价格
   */
  private int price;

  /**
   * 适用机场
   */
  private String applicableAirports;

  /**
   * 排除机场
   */
  private String excludedAirports;

  /**
   * 适用航空公司
   */
  private String applicableAirlines;

  /**
   * 排除航空公司
   */
  private String excludedAirlines;


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

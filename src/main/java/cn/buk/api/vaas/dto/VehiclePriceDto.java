package cn.buk.api.vaas.dto;

/**
 * 车型报价
 * @author yfdai
 */
public class VehiclePriceDto {

  /**
   * 车型ID
   */
  private int vehicleTypeId;

  /**
   * 车型名称
   */
  private String vehicleTypeName;

  /**
   * 价格
   */
  private double price;

  /**
   * 优惠金额
   * 实收金额 = price - discount
   */
  private double discount;



  public int getVehicleTypeId() {
    return vehicleTypeId;
  }

  public void setVehicleTypeId(int vehicleTypeId) {
    this.vehicleTypeId = vehicleTypeId;
  }

  public String getVehicleTypeName() {
    return vehicleTypeName;
  }

  public void setVehicleTypeName(String vehicleTypeName) {
    this.vehicleTypeName = vehicleTypeName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }
}

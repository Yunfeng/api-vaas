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

  private double price;



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
}

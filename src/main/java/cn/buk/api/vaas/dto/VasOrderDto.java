package cn.buk.api.vaas.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 增值服务订单 DTO 类
 *
 * @author yfdai
 */
public class VasOrderDto {

    private String productCode;

    private String productName;

    /**
     * 数量
     */
    private int count;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 联系电话
     */
    private String linkPhone;

    private String remark;

    private List<VasOrderPassengerDto> passengers;

    private List<VasOrderFlightDto> flights;


    /**
     * 外部订单号
     */
    private String externalOrderNo;

    private String orderNo;

    private int status;




    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProductCode() {
        return productCode == null ? "" : productCode.trim();
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName == null ? "" : productName.trim();
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setPassengers(List<VasOrderPassengerDto> passengers) {
        this.passengers = passengers;
    }

    public List<VasOrderFlightDto> getFlights() {
        if (flights == null) {
          flights = new ArrayList<>();
        }
        return flights;
    }

    public void setFlights(List<VasOrderFlightDto> flights) {
        this.flights = flights;
    }


    public List<VasOrderPassengerDto> getPassengers() {
        if (passengers == null) {
            passengers = new ArrayList<>();
        }
        return passengers;
    }


    public void setExternalOrderNo(String externalOrderNo) {
        this.externalOrderNo = externalOrderNo;
    }

    public String getExternalOrderNo() {
        return externalOrderNo;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkPhone() {
        return linkPhone;
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
}

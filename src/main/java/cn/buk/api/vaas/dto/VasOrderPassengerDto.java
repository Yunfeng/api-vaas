package cn.buk.api.vaas.dto;

/**
 * @author yfdai
 */
public class VasOrderPassengerDto {

	private String name;

	private int idType;

	private String idNo;

	private String ffpNo;

	private String mobile;

	private String seatNo;

	private String remark;

	public String getName() {
		return name == null ? "" : name.trim();
	}

	public void setName(String name) {
        if (name != null) {
          name = name.trim().toUpperCase();
        }
		this.name = name;
	}


	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getFfpNo() {
		return ffpNo;
	}

	public void setFfpNo(String ffpNo) {
		this.ffpNo = ffpNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
}

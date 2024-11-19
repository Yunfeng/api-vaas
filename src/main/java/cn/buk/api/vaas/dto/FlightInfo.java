package cn.buk.api.vaas.dto;


/**
 * 航班信息
 * @author yfdai
 *
 */
public class FlightInfo implements Cloneable {


	/**
	 * departure airport
	 */
	private String departureAirport;

	private String departureAirportName;

	/**
	 * arrival airport
	 */
	private String arrivalAirport;

	private String arrivalAirportName;

	/**
	 * 航班号
	 */
	private String flightNo;
	
	private String departureDate;
	
	private String departureTime;
	
	private String arrivalDate;
	
	private String arrivalTime;

	private String departureTerminal;

	private String arrivalTerminal;

	private String subclass;

	private String craftType;
	
	private int price;
	
	private int tax;
	

	
	/**
	 * @return the departureAirport
	 */
	public String getDepartureAirport() {
		return departureAirport == null ? "" : departureAirport.trim().toUpperCase();
	}

	/**
	 * @param departureAirport the departureAirport to set
	 */
	public void setDepartureAirport(String departureAirport) {
		if (departureAirport != null) {
			departureAirport = departureAirport.trim().toUpperCase();
		}
		this.departureAirport = departureAirport;
	}

	/**
	 * @return the arrivalAirport
	 */
	public String getArrivalAirport() {
		return arrivalAirport == null ? "" : arrivalAirport.trim().toUpperCase();
	}

	/**
	 * @param arrivalAirport the arrivalAirport to set
	 */
	public void setArrivalAirport(String arrivalAirport) {
		if (arrivalAirport != null) {
			arrivalAirport = arrivalAirport.trim().toUpperCase();
		}
		this.arrivalAirport = arrivalAirport;
	}

	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo == null ? "" : flightNo.trim().toUpperCase();
	}

	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		if (flightNo != null) {
			flightNo = flightNo.trim().toUpperCase();
		}
		this.flightNo = flightNo;
	}

	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate == null ? "" : departureDate.trim();
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime == null ? "": departureTime.trim();
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime == null ? "": arrivalTime.trim();
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the departureTerminal
	 */
	public String getDepartureTerminal() {
		return departureTerminal == null ? "": departureTerminal.trim();
	}

	/**
	 * @param departureTerminal the departureTerminal to set
	 */
	public void setDepartureTerminal(String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}

	/**
	 * @return the arrivalTerminal
	 */
	public String getArrivalTerminal() {
		return arrivalTerminal == null ? "": arrivalTerminal.trim().toUpperCase();
	}

	/**
	 * @param arrivalTerminal the arrivalTerminal to set
	 */
	public void setArrivalTerminal(String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}

	/**
	 * @return the subclass
	 */
	public String getSubclass() {
		return subclass == null ? "": subclass.trim();
	}

	/**
	 * @param subclass the subclass to set
	 */
	public void setSubclass(String subclass) {
		if (subclass != null) {
			subclass = subclass.trim().toUpperCase();
		}
		this.subclass = subclass;
	}

	/**
	 * @return the craftType
	 */
	public String getCraftType() {
		return craftType == null ? "": craftType.trim().toUpperCase();
	}

	/**
	 * @param craftType the craftType to set
	 */
	public void setCraftType(String craftType) {
		this.craftType = craftType;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the tax
	 */
	public int getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}


}

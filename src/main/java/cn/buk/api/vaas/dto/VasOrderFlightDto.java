package cn.buk.api.vaas.dto;

import cn.buk.util.FlightUtil;

/**
 * @author yfdai
 */
public class VasOrderFlightDto {

	/**
	 * 航段序号
	 */
	private int segOrder;

	private FlightInfo flight = new FlightInfo();


	public String getDepartureDate() {
		return getFlight().getDepartureDate();
	}

	public String getShowDepTime() {
		return FlightUtil.formatShowTime(this.flight.getDepartureTime());
	}

	public String getShowArrTime() {
		return FlightUtil.formatShowTime(this.flight.getArrivalTime());
	}

	public int getSegOrder() {
		return segOrder;
	}

	public void setSegOrder(int segOrder) {
		this.segOrder = segOrder;
	}

	public FlightInfo getFlight() {
		return flight;
	}

	public void setFlight(FlightInfo flight) {
		this.flight = flight;
	}


}

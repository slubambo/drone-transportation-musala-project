package drone.payloads.drones;

public class BattteryStatusResponse {

	private Integer batteryCapacity;
	private String message;

	public BattteryStatusResponse(Integer batteryCapacity, String message) {
		super();
		this.batteryCapacity = batteryCapacity;
		this.message = message;
	}

	public Integer getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(Integer batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

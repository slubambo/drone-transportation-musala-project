package drone.payloads.drones;

public class DroneBatteryLevelAuditResponsePayload {

	private Long id;

	private String serialNumber;

	private Integer batteryLevel;

	private String dateTime;

	public DroneBatteryLevelAuditResponsePayload(Long id, String serialNumber, Integer batteryLevel, String dateTime) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.batteryLevel = batteryLevel;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(Integer batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}

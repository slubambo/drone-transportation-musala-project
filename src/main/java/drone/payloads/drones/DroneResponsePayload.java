package drone.payloads.drones;

import drone.enums.DroneModel;
import drone.enums.DroneState;

public class DroneResponsePayload {

	private Long id;

	private String serialNumber;

	private DroneModel model;

	private Integer weightLimit;

	private Integer batteryCapacity;

	private DroneState state;

	public DroneResponsePayload() {
		super();
	}

	public DroneResponsePayload(Long id, String serialNumber, DroneModel model, Integer weightLimit,
			Integer batteryCapacity, DroneState state) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
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

	public DroneModel getModel() {
		return model;
	}

	public void setModel(DroneModel model) {
		this.model = model;
	}

	public Integer getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(Integer weightLimit) {
		this.weightLimit = weightLimit;
	}

	public Integer getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(Integer batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public DroneState getState() {
		return state;
	}

	public void setState(DroneState state) {
		this.state = state;
	}

}

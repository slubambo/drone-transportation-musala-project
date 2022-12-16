package drone.payloads.dispatch;

import java.util.ArrayList;

import drone.enums.DroneState;
import drone.payloads.medications.MedicationResponsePayload;

public class DroneMedicationLoadResponse {

	private Long droneId;

	private String serialNumber;

	private DroneState state;

	private Long loadedWeight;

	private String message;

	private ArrayList<MedicationResponsePayload> loadedMedications;

	public DroneMedicationLoadResponse() {
		super();
	}

	public DroneMedicationLoadResponse(Long droneId, String serialNumber, DroneState state,
			ArrayList<MedicationResponsePayload> loadedMedications) {
		super();
		this.droneId = droneId;
		this.serialNumber = serialNumber;
		this.state = state;
		this.loadedMedications = loadedMedications;
	}

	public Long getDroneId() {
		return droneId;
	}

	public void setDroneId(Long droneId) {
		this.droneId = droneId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public DroneState getState() {
		return state;
	}

	public void setState(DroneState state) {
		this.state = state;
	}

	public ArrayList<MedicationResponsePayload> getLoadedMedications() {
		return loadedMedications;
	}

	public void setLoadedMedications(ArrayList<MedicationResponsePayload> loadedMedications) {
		this.loadedMedications = loadedMedications;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getLoadedWeight() {
		return loadedWeight;
	}

	public void setLoadedWeight(Long loadedWeight) {
		this.loadedWeight = loadedWeight;
	}

}

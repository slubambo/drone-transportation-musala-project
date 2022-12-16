package drone.payloads.dispatch;

import drone.enums.LoadStatus;
import jakarta.validation.constraints.NotNull;

public class DispatchRequestPayload {

	private Long id;

	@NotNull
	private Long droneId;

	@NotNull
	private Long medicationId;

	private Long count;

	private LoadStatus loadStatus;

	public DispatchRequestPayload() {
		super();
	}

	public Long getDroneId() {
		return droneId;
	}

	public void setDroneId(Long droneId) {
		this.droneId = droneId;
	}

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public LoadStatus getLoadStatus() {
		return loadStatus;
	}

	public void setLoadStatus(LoadStatus loadStatus) {
		this.loadStatus = loadStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

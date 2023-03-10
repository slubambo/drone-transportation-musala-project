package drone.model.businessModels;

import java.util.Set;

import drone.enums.DroneModel;
import drone.enums.DroneState;
import drone.model.audit.DroneBatteryLevelAudit;
import drone.model.audit.UserDateAudit;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "drones", uniqueConstraints = { @UniqueConstraint(columnNames = { "serialNumber" }) })
public class Drone extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String serialNumber;

	private DroneModel model;

	@Max(value = 500) // Quotion on max 500gr
	private Integer weightLimit;

	@Max(value = 100)
	private Integer batteryCapacity;

	private DroneState state;

	@OneToMany(mappedBy = "drone", fetch = FetchType.LAZY)
	private Set<DroneMedicationDelivery> droneDeliveries;

	@OneToMany(mappedBy = "drone", fetch = FetchType.LAZY)
	private Set<DroneBatteryLevelAudit> batteryLevelAudits;

	public Drone() {
	}

	public Drone(@NotBlank @Size(max = 100) String serialNumber, DroneModel model, @Max(500) Integer weightLimit,
			@Max(100) Integer batteryCapacity, DroneState state) {
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

	public Set<DroneMedicationDelivery> getDroneDeliveries() {
		return droneDeliveries;
	}

	public void setDroneDeliveries(Set<DroneMedicationDelivery> droneDeliveries) {
		this.droneDeliveries = droneDeliveries;
	}

	public Set<DroneBatteryLevelAudit> getBatteryLevelAudits() {
		return batteryLevelAudits;
	}

	public void setBatteryLevelAudits(Set<DroneBatteryLevelAudit> batteryLevelAudits) {
		this.batteryLevelAudits = batteryLevelAudits;
	}

}

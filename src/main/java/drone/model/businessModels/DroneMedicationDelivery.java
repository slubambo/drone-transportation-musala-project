package drone.model.businessModels;

import java.util.Date;

import drone.enums.LoadStatus;
import drone.model.audit.UserDateAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "drone_medication_deliveries")
public class DroneMedicationDelivery extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "drone_id", nullable = false)
	private Drone drone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medication_id", nullable = false)
	private Medication medication;

	private Long count;

	private LoadStatus loadStatus;

	private Date deliveryDateTime;

	public DroneMedicationDelivery() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
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

	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}

	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}

}

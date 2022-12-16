package drone.model.businessModels;

import java.util.Set;

import drone.model.audit.UserDateAudit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "medications", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Medication extends UserDateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$") // Missing "-" and "_", (allowed only letters, numbers, ‘-‘, ‘_’)
	private String name;

	private Long weight;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$") // (allowed only upper case letters, underscore and numbers)
	private String code;

	@Lob
	@Column(length = 2000)
	private byte[] image;

	@OneToMany(mappedBy = "medication", fetch = FetchType.LAZY)
	private Set<DroneMedicationDelivery> medicationDeliveries;

	public Medication() {
	}

	public Medication(@NotBlank @Pattern(regexp = "^[A-Za-z0-9]+$") String name, Long weight,
			@NotBlank @Pattern(regexp = "^[A-Za-z0-9]+$") String code, byte[] image) {
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<DroneMedicationDelivery> getMedicationDeliveries() {
		return medicationDeliveries;
	}

	public void setMedicationDeliveries(Set<DroneMedicationDelivery> medicationDeliveries) {
		this.medicationDeliveries = medicationDeliveries;
	}
	
}

package drone.payloads.medications;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MedicationRequestPayload {

	private Long id;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String name;

	private Long weight;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String code;

	private String imagePath;

	public MedicationRequestPayload() {
		super();
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}

package drone.payloads.medications;

public class MedicationResponsePayload {

	private Long id;

	private String name;

	private Long weight;

	private String code;

	private String imagePath;

	public MedicationResponsePayload(Long id, String name, Long weight, String code, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.code = code;
		this.imagePath = imagePath;
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

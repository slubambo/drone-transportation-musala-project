package drone.payloads.drones;

import drone.enums.DroneModel;
import drone.enums.DroneState;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DroneRequestPayload {

  private Long id;

  @NotBlank
  @Size(max = 100)
  private String serialNumber;

  private DroneModel model;

  @Max(value = 500)
  private Integer weightLimit;

  @Max(value = 100)
  private Integer batteryCapacity;

  private DroneState state;

  public DroneRequestPayload() {}

  public DroneRequestPayload(
    @NotBlank @Size(max = 100) String serialNumber,
    DroneModel model,
    @Max(500) Integer weightLimit,
    @Max(100) Integer batteryCapacity,
    DroneState state
  ) {
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

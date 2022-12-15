package drone.enums;

import java.util.HashMap;
import java.util.Map;

public enum DroneModel {
  LIGHT_WEIGHT(0),
  MIDDLE_WEIGHT(1),
  CRUISER_WEIGHT(2),
  HEAVY_WEIGHT(3),
  EXITED(4);

  private int value;
  private static Map<Integer, DroneModel> map = new HashMap<>();

  private DroneModel(int value) {
    this.value = value;
  }

  static {
    for (DroneModel droneModel : DroneModel.values()) {
      map.put(droneModel.value, droneModel);
    }
  }

  public static DroneModel valueOf(int droneModel) {
    return (DroneModel) map.get(droneModel);
  }

  public int getValue() {
    return value;
  }
}

package drone.enums;

import java.util.HashMap;
import java.util.Map;

public enum DroneState {
  IDLE(0),
  LOADING(1),
  LOADED(2),
  DELIVERING(3),
  DELIVERED(4),
  RETURNING(4);

  private int value;
  private static Map<Integer, DroneState> map = new HashMap<>();

  private DroneState(int value) {
    this.value = value;
  }

  static {
    for (DroneState droneState : DroneState.values()) {
      map.put(droneState.value, droneState);
    }
  }

  public static DroneState valueOf(int droneState) {
    return (DroneState) map.get(droneState);
  }

  public int getValue() {
    return value;
  }
}

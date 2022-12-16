package drone.enums;

import java.util.HashMap;
import java.util.Map;

public enum LoadStatus {

	LOADING(0), TRANSIT(1), DELIVERED(2);

	private int value;
	private static Map<Integer, LoadStatus> map = new HashMap<>();

	private LoadStatus(int value) {
		this.value = value;
	}

	static {
		for (LoadStatus loadStatus : LoadStatus.values()) {
			map.put(loadStatus.value, loadStatus);
		}
	}

	public static LoadStatus valueOf(int loadStatus) {
		return (LoadStatus) map.get(loadStatus);
	}

	public int getValue() {
		return value;
	}

}

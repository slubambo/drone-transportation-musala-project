package drone.controller;

import drone.enums.DroneModel;
import drone.enums.DroneState;
import drone.payloads.ApiResponse;
import drone.payloads.dispatch.DispatchRequestPayload;
import drone.payloads.dispatch.DroneMedicationLoadResponse;
import drone.payloads.drones.BattteryStatusResponse;
import drone.payloads.drones.DroneBatteryLevelAuditResponsePayload;
import drone.payloads.drones.DroneRequestPayload;
import drone.payloads.drones.DroneResponsePayload;
import drone.payloads.medications.MedicationRequestPayload;
import drone.payloads.medications.MedicationResponsePayload;
import drone.security.CurrentUser;
import drone.security.UserPrincipal;
import drone.services.DispatchService;
import jakarta.validation.Valid;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {

	@Autowired
	private DispatchService dispatchService;

	/*
	 *
	 * Enum Value end points
	 */

	@GetMapping("/get-drone-models")
	public List<DroneModel> getDroneModels() {
		return Arrays.asList(DroneModel.values());
	}

	@GetMapping("/get-drone-states")
	public List<DroneState> getDroneStates() {
		return Arrays.asList(DroneState.values());
	}

	/*
	 *
	 * Drones Management
	 */

	// Registering a drone
	@PostMapping("/register-drone")
	public ResponseEntity<ApiResponse> registerDrone(@CurrentUser UserPrincipal currentUser,
			@Valid @RequestBody DroneRequestPayload payLoad) {
		return dispatchService.registerDrone(payLoad);
	}

	/* check drone battery level for a given drone */
	@GetMapping("/get-drone-battery-perecentage")
	public BattteryStatusResponse getDroneBatteryPercentage(@CurrentUser UserPrincipal currentUser,
			@RequestBody DroneResponsePayload payLoad) {
		return dispatchService.getDroneBatteryPercentage(payLoad);
	}

	/* checking available drones for loading */
	@GetMapping("/get-available-drones")
	public List<DroneResponsePayload> getAvailableDrones() {
		return dispatchService.getAvailableDrones();
	}

	/* checking drone battery level audit trail */
	@GetMapping("/get-drone-levels_trail")
	public List<DroneBatteryLevelAuditResponsePayload> getDroneLevelsTrail(@RequestBody DroneResponsePayload payLoad) {
		return dispatchService.getDroneLevelsTrail(payLoad);
	}

	/*
	 *
	 * Dispatching Medications
	 */

	// get medications for loading
	@GetMapping("/get-medications")
	public List<MedicationResponsePayload> getMedications() {
		return dispatchService.getMedications();
	}

	/* Registering a Medication */
	@PostMapping("/register-medication")
	public ResponseEntity<ApiResponse> registerMedication(@CurrentUser UserPrincipal currentUser,
			@Valid @RequestBody MedicationRequestPayload payLoad) {
		return dispatchService.registerMedication(payLoad);
	}

	/*
	 *
	 * Dispatching Medications
	 */

	// loading a drone with medication items
	@PostMapping("/load-drone-with-medication")
	public ResponseEntity<ApiResponse> loadDrone(@CurrentUser UserPrincipal currentUser,
			@Valid @RequestBody DispatchRequestPayload payLoad) {
		return dispatchService.loadDrone(payLoad);
	}

	// checking loaded medication items for a given drone
	@GetMapping("/check-drone-medication-load")
	public DroneMedicationLoadResponse checkDroneMedicationLoad(@RequestBody DroneResponsePayload payLoad) {
		return dispatchService.checkDroneMedicationLoad(payLoad);
	}

}

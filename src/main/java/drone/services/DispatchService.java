package drone.services;

import drone.enums.DroneState;
import drone.model.businessModels.Drone;
import drone.payloads.ApiResponse;
import drone.payloads.drones.BattteryStatusResponse;
import drone.payloads.drones.DroneRequestPayload;
import drone.payloads.drones.DroneResponsePayload;
import drone.repository.BusinessRepositories.DroneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DispatchService {

//	@Autowired
//	private GeneralService generalService;

	@Autowired
	private DroneRepository droneRepository;

	/*
	 *
	 * Drones Management
	 */

	/* Registering a drone */
	public ResponseEntity<ApiResponse> registerDrone(DroneRequestPayload payLoad) {
		Optional<Drone> drone = payLoad.getId() != null ? droneRepository.findById(payLoad.getId()) : Optional.empty();

		// pay-load checks
		if (payLoad.getSerialNumber() != null && payLoad.getModel() != null) {
			Drone transportationDrone = drone.isPresent() ? drone.get() : new Drone();

			// Check if Drone name already exists
			Optional<Drone> existingDrone = droneRepository.findBySerialNumber(payLoad.getSerialNumber());

			if (existingDrone.isPresent() && !drone.isPresent()) {
				return new ResponseEntity<>(new ApiResponse(false, "Drone already exists with the same Serial Number"),
						HttpStatus.EXPECTATION_FAILED);
			}

			transportationDrone.setSerialNumber(payLoad.getSerialNumber());
			transportationDrone.setModel(payLoad.getModel());
			transportationDrone.setWeightLimit(payLoad.getWeightLimit() != null ? payLoad.getWeightLimit() : 500);
			transportationDrone
					.setBatteryCapacity(payLoad.getBatteryCapacity() != null ? payLoad.getBatteryCapacity() : 100);
			transportationDrone.setState(payLoad.getState() != null ? payLoad.getState() : DroneState.IDLE);

			if (droneRepository.save(transportationDrone) != null) {
				return new ResponseEntity<>(new ApiResponse(true, "Drone registered successfully"), HttpStatus.OK);
			}
		}

		return new ResponseEntity<>(new ApiResponse(false, "Drone not Registered, Try Again"),
				HttpStatus.EXPECTATION_FAILED);
	}

	/* check drone battery level for a given drone */
	public BattteryStatusResponse getDroneBatteryPercentage(DroneResponsePayload payLoad) {

		Optional<Drone> drone = payLoad.getId() != null ? droneRepository.findById(payLoad.getId()) : Optional.empty();

		if (drone.isPresent()) {

			return drone.get().getBatteryCapacity() != null
					? new BattteryStatusResponse(drone.get().getBatteryCapacity(),
							"Battery status returned successfully")
					: new BattteryStatusResponse(null, "Drone with Serial Number " + drone.get().getSerialNumber()
							+ " has no battery status saved");

		} else {
			return new BattteryStatusResponse(null, "Drone selected not found, try again");
		}

	}

	/* checking available drones for loading */
	public List<DroneResponsePayload> getAvailableDrones() {

		List<DroneResponsePayload> availableDrones = new ArrayList<>();

		List<Drone> drones = droneRepository.findByState(DroneState.IDLE);

		// transform to drone response pay-load list
		availableDrones = drones.stream().map(d -> new DroneResponsePayload(d.getId(), d.getSerialNumber(),
				d.getModel(), d.getWeightLimit(), d.getBatteryCapacity(), d.getState())).collect(Collectors.toList());

		return availableDrones;

	}
}

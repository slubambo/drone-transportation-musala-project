package drone.services;

import drone.enums.DroneState;
import drone.model.businessModels.Drone;
import drone.payloads.ApiResponse;
import drone.payloads.drones.DroneRequestPayload;
import drone.repository.BusinessRepository.DroneRepository;
import java.util.Optional;
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

			transportationDrone.setSerialNumber(payLoad.getSerialNumber());
			transportationDrone.setModel(payLoad.getModel());
			transportationDrone.setWeightLimit(payLoad.getWeightLimit() != null ? payLoad.getWeightLimit() : 500);
			transportationDrone
					.setBatteryCapacity(payLoad.getBatteryCapacity() != null ? payLoad.getBatteryCapacity() : 100);
			transportationDrone.setState(payLoad.getState() != null ? payLoad.getState() : DroneState.IDLE);

			if (droneRepository.save(transportationDrone) != null) {
				return new ResponseEntity<>(new ApiResponse(false, "Drone not Registered, Try Again"), HttpStatus.OK);
			}
		}

		return new ResponseEntity<>(new ApiResponse(false, "Drone not Registered, Try Again"), HttpStatus.OK);
	}
}

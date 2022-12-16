package drone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import drone.model.audit.DroneBatteryLevelAudit;
import drone.model.businessModels.Drone;
import drone.repository.audit.DroneBatteryLevelAuditRepository;
import drone.repository.businessRepositories.DroneRepository;

@Service
public class CronJobsService {

	@Autowired
	private DroneRepository droneRepository;

	@Autowired
	private DroneBatteryLevelAuditRepository droneBatteryLevelAuditRepository;

	/*
	 * Periodic task to check drones battery levels
	 */
	@Scheduled(fixedRate = 300000) // runs every 5 minutes
	public void fixedRateSch() {

		for (Drone drone : droneRepository.findAll()) {

			DroneBatteryLevelAudit audit = new DroneBatteryLevelAudit();

			audit.setDrone(drone);
			audit.setBatteryLevel(drone.getBatteryCapacity());

			droneBatteryLevelAuditRepository.save(audit);

		}
	}

}

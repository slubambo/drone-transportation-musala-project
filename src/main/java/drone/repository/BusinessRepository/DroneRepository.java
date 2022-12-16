package drone.repository.BusinessRepository;

import drone.model.businessModels.Drone;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
	
	Optional<Drone> findBySerialNumber(String serialNumber);
}

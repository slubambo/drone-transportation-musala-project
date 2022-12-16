package drone.repository.BusinessRepositories;

import drone.enums.DroneState;
import drone.model.businessModels.Drone;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {

	Optional<Drone> findBySerialNumber(String serialNumber);

	List<Drone> findByState(DroneState state);
}

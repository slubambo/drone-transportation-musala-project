package drone.repository.BusinessRepository;

import drone.model.businessModels.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
}

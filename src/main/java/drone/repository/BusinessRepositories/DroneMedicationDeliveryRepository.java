package drone.repository.BusinessRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import drone.model.businessModels.DroneMedicationDelivery;

public interface DroneMedicationDeliveryRepository extends JpaRepository<DroneMedicationDelivery, Long> {

}

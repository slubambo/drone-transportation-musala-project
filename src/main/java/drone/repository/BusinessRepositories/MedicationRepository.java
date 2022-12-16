package drone.repository.BusinessRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import drone.model.businessModels.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}

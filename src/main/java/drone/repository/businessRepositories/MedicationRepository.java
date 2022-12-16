package drone.repository.businessRepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import drone.model.businessModels.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
	
	Optional<Medication> findByName(String name);

}

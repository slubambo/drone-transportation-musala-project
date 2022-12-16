package drone.repository.BusinessRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import drone.model.businessModels.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    
}

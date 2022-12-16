package drone.repository.audit;

import org.springframework.data.jpa.repository.JpaRepository;

import drone.model.audit.DroneBatteryLevelAudit;

public interface DroneBatteryLevelAuditRepository extends JpaRepository<DroneBatteryLevelAudit, Long> {

}

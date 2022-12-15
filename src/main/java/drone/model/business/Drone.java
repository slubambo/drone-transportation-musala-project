package drone.model.business;

import drone.enums.DroneModel;
import drone.model.audit.UserDateAudit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(
  name = "users",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) }
)
public class Drone extends UserDateAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 100)
  private String serialNumber;

  private DroneModel model;


}

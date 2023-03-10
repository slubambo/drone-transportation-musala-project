package drone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableScheduling;

import jakarta.annotation.PostConstruct;

import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
	DroneApplication.class,
	Jsr310JpaConverters.class
})
@EnableScheduling
public class DroneApplication {

  @PostConstruct
  void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }

  public static void main(String[] args) {
    SpringApplication.run(DroneApplication.class, args);
  }
}

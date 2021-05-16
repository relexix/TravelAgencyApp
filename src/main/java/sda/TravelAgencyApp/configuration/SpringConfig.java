package sda.TravelAgencyApp.configuration;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("sda.TravelAgencyApp")
@EntityScan("sda.TravelAgencyApp.entities")
@EnableJpaRepositories("sda.TravelAgencyApp.repositories")
public class SpringConfig {
}

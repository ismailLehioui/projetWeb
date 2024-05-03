package tn.enicarthage.plateforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"tn.enicarthage.plateforme"})
public class PlateformeSuiviVerificationNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlateformeSuiviVerificationNotesApplication.class, args);
	}

}

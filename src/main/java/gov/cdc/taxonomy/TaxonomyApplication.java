package gov.cdc.taxonomy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TaxonomyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxonomyApplication.class, args);
	}
}

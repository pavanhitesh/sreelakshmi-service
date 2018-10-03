package com.hitesh.sreelakshmi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.hitesh.sreelakshmi.db.ComplaintData;
import com.hitesh.sreelakshmi.repository.ComplaintDataRepository;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages= {"com.hitesh.sreelakshmi.*"})
public class SreelakshmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SreelakshmiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ComplaintDataRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new ComplaintData("Jack", "Bauer"));
			repository.save(new ComplaintData("Chloe", "O'Brian"));
			repository.save(new ComplaintData("Kim", "Bauer"));
			repository.save(new ComplaintData("David", "Palmer"));
			repository.save(new ComplaintData("Michelle", "Dessler"));
		};
	}

}

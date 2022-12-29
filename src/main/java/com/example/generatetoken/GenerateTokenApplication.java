package com.example.generatetoken;

import com.example.generatetoken.dao.Userdata;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GenerateTokenApplication {

private final Userdata userdata;

	public GenerateTokenApplication(Userdata userdata) {
		this.userdata = userdata;
	}

	public static void main(String[] args) {
		SpringApplication.run(GenerateTokenApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {


		};
	}


}

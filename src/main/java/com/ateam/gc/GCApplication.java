package com.ateam.gc;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class GCApplication {

	public static void main(String[] args) {
		SpringApplication.run(GCApplication.class, args);
	}

}

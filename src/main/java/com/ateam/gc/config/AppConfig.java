package com.ateam.gc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories(value = "com.ateam.gc.repo")
@EntityScan(basePackages = {"com.ateam.gc.entity"})
public class AppConfig {
}

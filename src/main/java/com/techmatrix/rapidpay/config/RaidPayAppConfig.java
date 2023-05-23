package com.techmatrix.rapidpay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.techmatrix.rapidpay.database")
public class RaidPayAppConfig {
}

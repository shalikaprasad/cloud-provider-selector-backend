package com.msprasad.cloudproviderselector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EntityScan(basePackages = {"com.msprasad.cloudproviderselector.models.response"})
@SpringBootApplication
@EnableCaching
public class CloudProviderSelectorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderSelectorBackendApplication.class, args);
	}


}

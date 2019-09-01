package com.todo1.hulkstore.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.todo1.hulkstore.domain")
@EnableJpaRepositories(basePackages = "com.todo1.hulkstore.domain.dao")
public class PersistenceJPAConfig {

}

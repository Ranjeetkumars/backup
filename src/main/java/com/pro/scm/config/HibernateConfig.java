/**
 * Database connection Is opening Here with the help of c3P0
 */
package com.pro.scm.config;

import java.beans.PropertyVetoException;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author VENKAT_PRO 15-05-2019
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class HibernateConfig {
	
	@Value("${db.driver}")
	private String DB_DRIVER;

	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;

	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	@Value("${hibernate.format_sql}")
	private String HIBERNATE_FORMAT_SQL;

	// C3P0 Configaration
	@Value("${spring.jpa.properties.hibernate.c3p0.max_size}")
	private String CONN_POOL_MAX_SIZE;

	@Value("${spring.jpa.properties.hibernate.c3p0.min_size}")
	private String CONN_POOL_MIN_SIZE;

	@Value("${spring.jpa.properties.hibernate.c3p0.idle_test_period}")
	private String CONN_POOL_IDLE_PERIOD;

	@Bean
	public LocalSessionFactoryBean productonSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(productionDataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		hibernateProperties.put("hibernate.format_sql", HIBERNATE_FORMAT_SQL);
		sessionFactory.setHibernateProperties(hibernateProperties);
		log.info("::::::::Hibernate Session factory is created::::::" + sessionFactory);
		return sessionFactory;
	}

	@Bean
	public ComboPooledDataSource productionDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource("venkat");

		try {
			dataSource.setDriverClass(DB_DRIVER);
		} catch (PropertyVetoException pve) {
			return null;
		}
		dataSource.setJdbcUrl(DB_URL);
		dataSource.setUser(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setMinPoolSize(Integer.parseInt(CONN_POOL_MIN_SIZE));
		dataSource.setMaxPoolSize(Integer.parseInt(CONN_POOL_MAX_SIZE));
		dataSource.setMaxIdleTime(Integer.parseInt(CONN_POOL_IDLE_PERIOD));
		log.info("::::::::ComboPooledDataSource::::" + DB_URL + "::: is created::::::" + dataSource);
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(productonSessionFactory().getObject());
		return txManager;
	}
}

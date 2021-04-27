package com.initconfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com","com.daomodel","com.service"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
public class HibernateInitClass {
	@Autowired
	private Environment env;
	
	private Properties getProperties() {
		Properties prop=new Properties();
		prop.put("hibernate.connection.username", env.getRequiredProperty("spring.datasource.username"));
		prop.put("hibernate.connection.password", env.getRequiredProperty("spring.datasource.password"));
		prop.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		prop.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
		prop.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		return prop;
	}
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		datasource.setPassword(env.getRequiredProperty("spring.datasource.password"));
		datasource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		datasource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean lsf=new LocalSessionFactoryBean();
		lsf.setHibernateProperties(getProperties());
		lsf.setPackagesToScan(new String[] {"com.model","com.service"});
		lsf.setDataSource(getDataSource());
		return lsf;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager txManager=new HibernateTransactionManager();
		txManager.setSessionFactory(factory);
		return txManager;
	}
}

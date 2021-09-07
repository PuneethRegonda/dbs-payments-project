package com.dbs.spring;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * 
 * @author Administrator
 *	hit the url localhost:8080/init
 *	for database initialization which inserts banks and customers.
 *  
 *  HIT ONLY ONCE  
 */


@SpringBootApplication
public class PaymentsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}
	
    @Bean
    public DataSource dataSource()
    {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setUrl("jdbc:mariadb://localhost:3306/payments");
    	ds.setUsername("root");
    	ds.setDriverClassName("org.mariadb.jdbc.Driver");
    	ds.setPassword("root");
    	System.out.println("ds created "+ds);
    	return ds;
    }
    
//    @Bean
//    public JdbcTemplate template()
//    {   JdbcTemplate s = new JdbcTemplate();
//    	 s.setDataSource(dataSource());
//    	 return s;
//    }
    

}

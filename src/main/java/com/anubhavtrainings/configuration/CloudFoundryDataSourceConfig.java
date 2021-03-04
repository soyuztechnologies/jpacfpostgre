//package com.anubhavtrainings.configuration;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.cloud.config.java.AbstractCloudConfig;
//import org.springframework.context.ApplicationContextException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//
//
//@Configuration
////@Profile({"cf"})
//@Profile("cloud")
//public class CloudFoundryDataSourceConfig extends AbstractCloudConfig {
//	
//	
//
//	Logger cloudFoundryDataSourceConfigLogger = LoggerFactory.getLogger(this.getClass());
//	
//	@Value("${vcap.services.postgresql-db.credentials.username}")
//	private String username;
//
//	@Value("${vcap.services.postgresql-db.credentials.password}")
//	private String password;
//	
//	@Value("${vcap.services.postgresql-db.credentials.hostname}")
//	private String hostname;
//	
//	@Value("${vcap.services.postgresql-db.credentials.port}")
//	private String port;
//	
//	@Value("${vcap.services.postgresql-db.credentials.dbname}")
//	private String dbname;	
//	
//	private String dbInstanceUrl;
//
//	/**
//	 * Creates DataSource.
//	 */
//	
//    @Value("${spring.datasource.hikari.maximumPoolSize}") 
//    private int maxPoolSize;
//    
//    
//   
//	//null
//	@Bean
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//	public DataSource dataSource(DataSourceProperties dataSourceProperties){
//		HikariDataSource hikariDataSource = null;
//        if (dataSourceProperties.getUrl() == null) {
//            throw new ApplicationContextException("Database connection pool is not configured correctly");
//        }else {
//        	cloudFoundryDataSourceConfigLogger.info("HikariCP instantiated successfully");
//        }
//        dbInstanceUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbname;
//		try {
//			System.out.println(dbInstanceUrl);
//		 hikariDataSource =  (HikariDataSource) DataSourceBuilder
//				.create()
//				.type(HikariDataSource.class)
//				.url(dbInstanceUrl)
//				.username(username)
//				.password(password)
//				.build();
//        hikariDataSource.setMaximumPoolSize(maxPoolSize);
//        cloudFoundryDataSourceConfigLogger.info("Maximum connection pool size: " + hikariDataSource.getMaximumPoolSize());
//		
//		}catch(Exception e) {
//			throw new InternalError("Database Connection Error --------------->>>>>>>>>>>>>>");
//		}
//		return hikariDataSource;
//	}
//
//}
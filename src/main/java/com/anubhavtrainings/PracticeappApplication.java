package com.anubhavtrainings;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.anubhavtrainings.annotation.processor.MyODataServiceFactory;
import com.anubhavtrainings.entities.AddressODataAgent;
import com.anubhavtrainings.entities.VendorODataAgent;
import com.anubhavtrainings.util.SpringUtils;

@SpringBootApplication(scanBasePackages = "com.anubhavtrainings")
@EnableJpaRepositories(basePackages = "com.anubhavtrainings")
@EntityScan(basePackages = "com.anubhavtrainings") 
@ServletComponentScan(basePackages = "com.anubhavtrainings")
@EnableAsync
public class PracticeappApplication extends ODataServlet{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PracticeappApplication.class, args);
		//context.getEnvironment().setActiveProfiles("cloud");
	}
	
	@Bean(name="com.anubhavtrainings.processor.MyODataServiceFactory")
	public ODataServiceFactory getServiceFactory(){
		return new MyODataServiceFactory("com.anubhavtrainings");
	}
	

	@Bean(name="com.anubhavtrainings.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent(){
		//log.info("return VendorODataAgent object");
		return new VendorODataAgent();
	}
	
	@Bean(name="com.anubhavtrainings.entities.addressODataAgent")
	public AddressODataAgent addressODataAgent(){
		//log.info("return VendorODataAgent object");
		return new AddressODataAgent();
	}


}

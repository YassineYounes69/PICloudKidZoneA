package com.example.kidszonea4arctic3;


import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class KidsZoneA4arctic3Application {

    public static void main(String[] args) {
    	System.out.print("Test amal");
    	System.out.println("Using:- ");
    	System.out.println("- MYSQL_DB_HOST = " + System.getenv("MYSQL_DB_HOST"));
    	System.out.println("- MYSQL_DB_PORT = " + System.getenv("MYSQL_DB_PORT"));
    	System.out.println("- MYSQL_DB_NAME = " + System.getenv("MYSQL_DB_NAME"));
    	System.out.println("- MYSQL_DB_USER = " + System.getenv("MYSQL_DB_USER"));
    	System.out.println("- MYSQL_DB_PASS = " + System.getenv("MYSQL_DB_PASS"));
        SpringApplication.run(KidsZoneA4arctic3Application.class, args);
    }
    

    @Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
	FacesServlet servlet = new FacesServlet();
	return new ServletRegistrationBean<FacesServlet>(servlet, "*.jsf"); }
	@Bean
	public FilterRegistrationBean<RewriteFilter> rewriteFilter() {
	FilterRegistrationBean<RewriteFilter> rwFilter = new FilterRegistrationBean<RewriteFilter>(new RewriteFilter());
	rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
	DispatcherType.ASYNC, DispatcherType.ERROR));
	rwFilter.addUrlPatterns("/*");
	return rwFilter;
	}

}

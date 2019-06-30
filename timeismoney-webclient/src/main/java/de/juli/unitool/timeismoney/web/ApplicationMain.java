package de.juli.unitool.timeismoney.web;

import javax.faces.webapp.FacesServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
<<<<<<< Upstream, based on origin/master
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import de.juli.unitool.failities.logger.PrettyLog;

@Configuration
@ComponentScan(basePackages = { "de.juli.unitool.timeismoney.web" }) 	
@EnableAutoConfiguration
public class ApplicationMain extends ServletInitializer {
=======
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import de.juli.unitool.failities.logger.PrettyLog;

@Configuration
@ComponentScan	
@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationMain extends SpringBootServletInitializer {
>>>>>>> 32fbff9 autoreload web 2
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationMain.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
	
	public static void main(String[] args) {
		LOG_PRETTY.info("Startig Application");
		SpringApplication.run(ApplicationMain.class, args);
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		LOG_PRETTY.info("servletRegistrationBean : register FacesServlet");
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<FacesServlet>(servlet, "*.xhtml");
		return servletRegistrationBean;
	}
}
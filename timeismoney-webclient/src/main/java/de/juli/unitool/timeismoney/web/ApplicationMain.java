package de.juli.unitool.timeismoney.web;

import javax.faces.webapp.FacesServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import de.juli.unitool.timoresrc.log.PrettyLog;

/**
 * Startet die Applikation
 * 
 * @author ukloodt
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationMain extends SpringBootServletInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationMain.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);

	/**
	 * App Start
	 * 
	 * @param args Array von {@link String}
	 */
	public static void main(String[] args) {
		LOG_PRETTY.info("Startig Application");
		SpringApplication.run(ApplicationMain.class, args);
	}

	/**
	 * regestriert das Sartservlet anlaog zu web.xml 
	 * <servlet> <servlet-name>Faces Servlet</servlet-name>
	 * <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
	 *  ...
	 * </servlet>
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		LOG_PRETTY.info("servletRegistrationBean : register FacesServlet");
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<FacesServlet>(servlet, "*.xhtml");
		return servletRegistrationBean;
	}
}
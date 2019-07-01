package de.juli.unitool.timeismoney.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import de.juli.unitool.timoresrc.log.PrettyLog;

/**
 * Uebernimmt configuraton der web.xml
 * @author ukloodt
 *
 */
@Configuration
public class ServletInitializer implements ServletContextInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(ServletInitializer.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		LOG_PRETTY.info("onStartup : setting javax.faces properties");
		sc.setInitParameter("facelets.DEVELOPMENT", "false");
		sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		sc.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		sc.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
		sc.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "-1");
	}
}

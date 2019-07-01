package de.juli.unitool.timeismoney.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import de.juli.unitool.timoresrc.log.PrettyLog;


/**
 * Das sollte eigentlich dafur sorgen, dass die default maessig die index.xhtml im 
 * root verzeichnis ausgeliefert wird. Analog zu <welcome-file> in der web.xml
 * @author ukloodt
 *
 */
@Configuration
public class DefaultViewConfig implements WebMvcConfigurer {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultViewConfig.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	LOG_PRETTY.info("addViewControllers");
        registry.addViewController("/").setViewName("index.xhtml?faces-redirect=true");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}

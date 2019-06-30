package de.juli.unitool.timeismoney.web.web;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.juli.unitool.failities.logger.PrettyLog;
import de.juli.unitool.timeismoney.web.container.UserSession;

@Scope(value = "request")
@Component
public class Index {
	private static final Logger LOG = LoggerFactory.getLogger(Index.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
	

	@Autowired
	UserSession session;
	
	 public void init(ComponentSystemEvent event){
		 if(!session.getLogin()) {
			 try {
				 FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
			 } catch (IOException e) {
				 LOG_PRETTY.error(e.getMessage(), e);
			 }
		 } 		 
	 }
	
	@PostConstruct
	public void setUp() {
	}
}

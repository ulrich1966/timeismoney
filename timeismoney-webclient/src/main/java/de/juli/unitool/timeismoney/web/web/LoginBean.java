package de.juli.unitool.timeismoney.web.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.juli.unitool.timeismoney.web.container.UserSession;
import de.juli.unitool.timeismoney.web.viewmodel.CurrentUser;

@Component("login")
@Scope("request")
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Boolean loggedin;
	
	@Autowired
	UserSession session;
	
	
	@PostConstruct
	public void setUp() {
		if(session.getLogin()) {
			this.username = session.getCurrentUser().getName(); 
			this.loggedin = session.getLogin(); 
		} else {
			this.username = "Gast";
			this.loggedin = false;
		}		
	}

	public String login() {
		CurrentUser currentUser = new CurrentUser(this.username, this.password);
		this.session.setCurrentUser(currentUser);
		this.session.setLogin(true);
		return "app/index.xhtml?faces-redirect=true";
	}

	public String forgotPassword() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
		FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
		FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
		return "index.xhtml?faces-redirect=true";
	}

	public String logout() {
		this.session.setCurrentUser(null);
		this.session.setLogin(false);
		return "/index.xhtml?faces-redirect=true";
	}
	
	// Getter / Setter
	
	public void setUsername(String name) {
		this.username = name;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedin() {
		return loggedin;
	}

	public void setLoggedin(Boolean loggedin) {
		this.loggedin = loggedin;
	}
}

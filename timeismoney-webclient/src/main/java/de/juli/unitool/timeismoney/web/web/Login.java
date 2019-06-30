package de.juli.unitool.timeismoney.web.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username = "Gast";
	private String password;

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

	public String login() {
		return "index.xhtml?faces-redirect=true";
	}

	public String forgotPassword() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
		FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
		FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
		return "index.xhtml?faces-redirect=true";
	}

	public String logout() {
		return "/index.xhtml?faces-redirect=true";
	}

}

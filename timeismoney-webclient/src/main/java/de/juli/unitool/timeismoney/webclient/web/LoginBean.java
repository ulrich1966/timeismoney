package de.juli.unitool.timeismoney.webclient.web;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
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

	public String logout() {
		return "/index.xhtml?faces-redirect=true";
	}
}

package de.juli.unitool.timeismoney.web.container;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.juli.unitool.timeismoney.web.viewmodel.CurrentUser;

@Scope(value = "session")
@Component
public class UserSession {
	private Boolean login = false;	
	private CurrentUser currentUser;

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public void setCurrentUser(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	public CurrentUser getCurrentUser() {
		return currentUser;
	}
}

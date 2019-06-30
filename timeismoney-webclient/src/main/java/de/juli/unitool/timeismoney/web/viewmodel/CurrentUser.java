package de.juli.unitool.timeismoney.web.viewmodel;

public class CurrentUser {
	private String name;
	private String pass;
	
	public CurrentUser() {
		super();
	}

	public CurrentUser(String name, String pass) {
		this();
		this.name = name;
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", pass=" + pass + "]";
	}
}

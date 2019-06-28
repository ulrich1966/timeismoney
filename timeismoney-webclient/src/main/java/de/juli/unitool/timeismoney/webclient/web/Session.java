package de.juli.unitool.timeismoney.webclient.web;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.sun.jna.platform.win32.Advapi32Util.Account;

public class Session implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String ACCOUT = "account"; 
	private Map<String, Object> sessionContent = new HashMap<>() ;
	private boolean login;
	private URI rootUri;
	private Path root;
	private String dbUser;
	private String dataBase;
	
	public Session(){
	}
	
	@PostConstruct
	public void init(){
		try {
			rootUri = Session.class.getResource("/").toURI();
			root = Paths.get(rootUri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("rootUri: %s \nroot: %s", rootUri, root));
	}

	public void logOut() {
		login = false;
		sessionContent.remove(ACCOUT);
	}
	
	public void addContent(String key, Object value) {
		sessionContent.put(key, value);
	}

	public Object getContent(String key) {
		return sessionContent.get(key);
	}
	
	public String getContentAsString(String key) {
		return getContent(key).toString();
	}

	public Integer getContentAsInt(String key) {
		try {
			return (Integer) getContent(key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public Boolean getContentAsBool(String key) {
		try {
			return (Boolean) getContent(key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public void removContent(String key) {
		sessionContent.remove(key);
	}

	public Map<String, Object> getSessionContent() {
		return sessionContent;
	}

	public void setAccount(Account account) {
		sessionContent.put(ACCOUT, account);
	}
	
	public Account getAccount() {
		return (Account) sessionContent.get(ACCOUT);
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public URI getRootUri() {
		return rootUri;
	}

	public Path getRoot() {
		return root;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDataBase() {
		return dataBase;
	}
	
	
}

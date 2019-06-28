package de.juli.unitool.timeismoney.webclient.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "request")
@Component(value = "home")
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name = "Hein Mück";
	
	public IndexBean() {
	}
	
	@PostConstruct
	public void init() {
	}
	
	public String getName() {
		return name;
	}
}

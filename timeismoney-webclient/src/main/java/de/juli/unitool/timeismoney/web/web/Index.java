package de.juli.unitool.timeismoney.web.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "request")
@Component
public class Index {
	private String welcomeMessage = "Populated by spring created bean";

    public Index() {
		super();
	}

    public String getWelcomeMessage() {
        return welcomeMessage;
    }
}

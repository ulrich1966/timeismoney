package de.juli.unitool.timeismoney.webclient.test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import de.juli.unitool.failities.logger.PrettyLog;

@AutoConfigureMockMvc
public class HelloControllerTest extends ApplicaionTest {
	private static final Logger LOG = LoggerFactory.getLogger(HelloControllerTest.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
	public static final String RESULT = "Moin! meine erste Spring Boot App!";

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
    	LOG_PRETTY.info("test running");
    	
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo(RESULT)));
        
        LOG_PRETTY.info("result", result.andReturn().getResponse().getContentAsString());

        LOG_PRETTY.info("DONE!");
    }
    
    @Test
	public void getHello2() throws Exception {
    	String serverRootUrl = super.getBase().toString();
    	LOG_PRETTY.info("serverRootUrl:", serverRootUrl);
		ResponseEntity<String> response = super.getTemplate().getForEntity(serverRootUrl, String.class);
		assertThat(response.getBody(), equalTo(RESULT));
		LOG_PRETTY.info("DONE!");
	}
    
}

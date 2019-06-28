package de.juli.unitool.timeismoney.webclient.test;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.juli.unitool.failities.logger.PrettyLog;
import de.juli.unitool.timeismoney.webclient.web.IndexBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = IndexBean.class)
@ContextConfiguration({ "classpath:spring-config.xml" })
public class ApplicaionTest {
	private static final Logger LOG = LoggerFactory.getLogger(ApplicaionTest.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
	
	
	@LocalServerPort
	private int port;
	private URL base;
	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}
	
	@Test
    public void test() {
		LOG_PRETTY.info("url: ", this.base);
		LOG_PRETTY.info("DONE!");
    }
	public int getPort() {
		return port;
	}

	public URL getBase() {
		return base;
	}

	public TestRestTemplate getTemplate() {
		return template;
	}
}
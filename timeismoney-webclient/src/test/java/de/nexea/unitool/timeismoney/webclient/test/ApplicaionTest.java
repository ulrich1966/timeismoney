package de.nexea.unitool.timeismoney.webclient.test;

import java.net.URL;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.nexea.unitool.timeismoney.webclient.web.HelloController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HelloController.class)
@ContextConfiguration({ "classpath:spring-config.xml" })
public class ApplicaionTest {
	
	@LocalServerPort
	private int port;
	private URL base;
	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
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
package de.juli.unitool.timeismoney.web.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class) 
@ComponentScan("de.juli.unitool.timeismoney.web")
@Configuration
abstract class IntegrationTest {
	
	/**
	 * injekton eines von Spring generierten Ports 
	 */
    @LocalServerPort
    private int serverPort;

    // Getter - Setter 
    
    public Integer getServerPort() {
		return serverPort;
	}

}

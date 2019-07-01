package de.juli.unitool.timeismoney.web.test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;

import de.juli.unitool.timoresrc.log.PrettyLog;

@EnableAutoConfiguration
public class RunTest extends IntegrationTest {
	private static final Logger LOG = LoggerFactory.getLogger(RunTest.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);

	@Autowired
	private ApplicationContext appContext;
//	@Autowired
//	private LoginBean login;
//	
	 @Before
	public void setUp() {
		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		LOG_PRETTY.debug(Arrays.asList(beans));
	}

	@Test
	public void test() {
		LOG_PRETTY.info(super.getServerPort());
		// Assert.assertNotNull("login is null", login);
		LOG_PRETTY.info("DONE!");
		LOG_PRETTY.debug("DONE!");
	}

}

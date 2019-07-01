package de.juli.unitool.timeismoney.web.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import de.juli.unitool.timeismoney.web.web.LoginBean;
import de.juli.unitool.timoresrc.log.PrettyLog;

@EnableAutoConfiguration
public class RunTest extends IntegrationTest {
	private static final Logger LOG = LoggerFactory.getLogger(RunTest.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);

	@Autowired
	private LoginBean login;
		
	@Test
	public void test() {
		LOG_PRETTY.info(super.getServerPort());
		Assert.assertNotNull("login is null", login);
		LOG_PRETTY.info("DONE!");
	}

}

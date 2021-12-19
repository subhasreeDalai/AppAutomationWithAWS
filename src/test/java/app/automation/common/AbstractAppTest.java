package app.automation.common;

import app.automation.Application;
import app.automation.config.ConfigProperties;
import app.automation.config.PropertiesInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = Application.class, initializers = PropertiesInitializer.class)
public abstract class AbstractAppTest extends AbstractTestNGSpringContextTests {
  @Autowired
  protected ConfigProperties configProperties;
}


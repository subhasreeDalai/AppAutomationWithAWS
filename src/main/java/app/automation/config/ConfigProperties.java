package app.automation.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigProperties {
  @Value("${server}")
  private String server;

  @Value("${browserStackUserName}")
  private String browserStackUserName;
}

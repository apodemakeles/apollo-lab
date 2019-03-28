package apodemas.apollolab.springlab.config;

import apodemas.apollolab.springlab.config.properties.CommonProperties;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author caozheng
 * @time 2019-03-28 11:15
 **/
@Configuration
@EnableApolloConfig
@EnableConfigurationProperties({CommonProperties.class})
public class AppConfig {
}

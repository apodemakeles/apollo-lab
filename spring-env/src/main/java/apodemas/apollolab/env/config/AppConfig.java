package apodemas.apollolab.env.config;

import apodemas.apollolab.env.config.properties.CommonProperties;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author caozheng
 * @time 2019-03-28 19:59
 **/
@Configuration
@EnableApolloConfig
@EnableConfigurationProperties({CommonProperties.class})
public class AppConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

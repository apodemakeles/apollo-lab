package apodemas.apollolab.eureka.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author caozheng
 * @time 2019-03-29 11:08
 **/
@Configuration
@EnableApolloConfig
public class AppConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private RefreshScope refreshScope;

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        System.out.println("=============change keys :" + changeEvent.changedKeys() + "===============");
        boolean eurekaConfigChanged = false;
        for(String key : changeEvent.changedKeys()){
            if(key.startsWith("eureka.") && eurekaConfigChanged != true){
                eurekaConfigChanged = true;
            }
        }

        if(eurekaConfigChanged){
            applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
            refreshScope.refreshAll();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}

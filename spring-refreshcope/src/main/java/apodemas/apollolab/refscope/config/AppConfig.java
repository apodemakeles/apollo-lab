package apodemas.apollolab.refscope.config;

import apodemas.apollolab.refscope.config.properties.CommonProperties;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author caozheng
 * @time 2019-03-28 16:22
 **/
@Configuration
@EnableApolloConfig
public class AppConfig {

    @Autowired
    private CommonProperties commonProperties;

    @Autowired
    private RefreshScope refreshScope;

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {
        refreshScope.refresh("commonProperties");
    }

}

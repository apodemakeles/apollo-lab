package apodemas.apollolab.common;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

import java.util.concurrent.CountDownLatch;

/**
 * @author caozheng
 * @time 2019-03-28 10:53
 **/
public class ConfigChangedApplication {

    /**
     * 监听配置时间变化。
     * @param args
     */
    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
        Config config = ConfigService.getAppConfig();
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                System.out.println("Changes for namespace " + changeEvent.getNamespace());
                for (String key : changeEvent.changedKeys()) {
                    ConfigChange change = changeEvent.getChange(key);
                    System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
                }
            }
        });

        latch.await();
    }
}

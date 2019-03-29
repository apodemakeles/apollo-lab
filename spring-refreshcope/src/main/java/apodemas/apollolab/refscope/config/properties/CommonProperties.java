package apodemas.apollolab.refscope.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author caozheng
 * @time 2019-03-28 16:23
 **/
@ConfigurationProperties(prefix = "com")
@Component("commonProperties")
@RefreshScope
public class CommonProperties {
    private String name;
    private String address;

    public CommonProperties(){
        System.out.println("====================refresh======================");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

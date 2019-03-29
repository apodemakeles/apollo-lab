package apodemas.apollolab.apoconfig.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author caozheng
 * @time 2019-03-29 13:52
 **/
@Component
public class CommonConfig {
    @Value("${com.name:1}")
    private String name;

    @Value("${com.address:hello}")
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

package apodemas.apollolab.springlab.config.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author caozheng
 * @time 2019-03-28 15:31
 **/
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

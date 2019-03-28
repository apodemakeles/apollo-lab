package apodemas.apollolab.springlab.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author caozheng
 * @time 2019-03-28 11:09
 **/
@ConfigurationProperties(prefix = "com")
public class CommonProperties {
    private String name;
    private String address;


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

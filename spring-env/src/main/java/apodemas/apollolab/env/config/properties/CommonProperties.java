package apodemas.apollolab.env.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author caozheng
 * @time 2019-03-29 09:12
 **/
@ConfigurationProperties(prefix = "com")
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

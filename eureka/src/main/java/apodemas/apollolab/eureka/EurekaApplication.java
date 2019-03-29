package apodemas.apollolab.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author caozheng
 * @time 2019-03-29 10:15
 **/
@SpringBootApplication
@EnableEurekaClient
public class EurekaApplication {
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(EurekaApplication.class, args);
    }
}

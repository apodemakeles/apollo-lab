package apodemas.apollolab.apoconfig;

import apodemas.apollolab.apoconfig.config.properties.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author caozheng
 * @time 2019-03-29 13:48
 **/
@SpringBootApplication
public class CommonApplication {
    /**
     * 实际上不需要ApolloConfig，有apollo.bootstrap.enabled=true就可以起作用
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(CommonApplication.class, args);
        CommonConfig config = ctx.getBean(CommonConfig.class);
        while(true) {
            System.out.println("config's name:" + config.getName());
            System.out.println("config's address:" + config.getAddress());
            Thread.sleep(5000);
        }
    }
}


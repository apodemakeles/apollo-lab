package apodemas.apollolab.refscope;

import apodemas.apollolab.refscope.config.properties.CommonProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author caozheng
 * @time 2019-03-28 16:21
 **/
@SpringBootApplication
public class SpringBootRefscopeApplication {
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootRefscopeApplication.class, args);
        CommonProperties commonProperties = ctx.getBean(CommonProperties.class);
        while(true) {
            System.out.println("properties's name:" + commonProperties.getName());
            System.out.println("properties's address:" + commonProperties.getAddress());

            Thread.sleep(5000);
        }
    }
}

package apodemas.apollolab.env;

import apodemas.apollolab.env.config.properties.CommonProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author caozheng
 * @time 2019-03-28 19:59
 **/
@SpringBootApplication
public class SpringBootEnvApplication {

    /**
     * 通过application context的publishEvent方法触发@ConfigurationProperties的re-bind。
     * 引用：
     *  EnvironmentChangeEvent is observed it will have a list of key values that have
     *  changed, and the application will use those to:
     *      Re-bind any @ConfigurationProperties beans in the context
     *      Set the logger levels for any properties in logging.level.*
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootEnvApplication.class, args);
        CommonProperties commonProperties = ctx.getBean(CommonProperties.class);
        while(true) {
            System.out.println("properties's name:" + commonProperties.getName());
            System.out.println("properties's address:" + commonProperties.getAddress());

            Thread.sleep(5000);
        }
    }
}

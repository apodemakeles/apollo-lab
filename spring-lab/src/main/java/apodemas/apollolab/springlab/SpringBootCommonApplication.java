package apodemas.apollolab.springlab;

import apodemas.apollolab.springlab.config.properties.CommonProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author caozheng
 * @time 2019-03-28 10:44
 **/


@SpringBootApplication
public class SpringBootCommonApplication {

    /**
     * 无法实现动态更新。
     * 云上的配置会覆盖本地配置。
     * 云上没有的配置会使用本地。
     * 当设置env为Local时，会有"==== Apollo is in local mode!..."的提示，但之前本地缓存如果有的话还会起作用。
     * @param args
     */
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootCommonApplication.class, args);

        while(true) {
            CommonProperties properties = ctx.getBean(CommonProperties.class);
            System.out.println("name:" + properties.getName());
            System.out.println("address:" + properties.getAddress());
            Thread.sleep(5000);
        }
    }
}

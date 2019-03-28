package apodemas.apollolab.springlab;

import apodemas.apollolab.springlab.config.properties.CommonConfig;
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
     * '@Value' 注解可以动态刷新，@ConfigurationProperties则不行。
     * 依赖于@Value的Bean的Bean，并没有刷新，但可以获取到变更值，说明被动态代理的Bean内部会有一个复杂的类似atomic reference。
     * @param args
     */
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootCommonApplication.class, args);
        CommonConfig config = ctx.getBean(CommonConfig.class);
        MockBean mockBean = ctx.getBean(MockBean.class);
        while(true) {
            CommonProperties properties = ctx.getBean(CommonProperties.class);
            System.out.println("properties's name:" + properties.getName());
            System.out.println("properties's address:" + properties.getAddress());
            System.out.println("config's name:" + config.getName());
            System.out.println("config's address:" + config.getAddress());
            System.out.println("mock bean's name:" + mockBean.getName());
            System.out.println("mock bean's address:" + mockBean.getAddress());
            Thread.sleep(5000);
        }
    }
}

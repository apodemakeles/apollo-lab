package apodemas.apollolab.springlab;

import apodemas.apollolab.springlab.config.properties.CommonConfig;

/**
 * @author caozheng
 * @time 2019-03-28 15:42
 **/
public class MockBean {
    private final CommonConfig commonConfig;

    public MockBean(CommonConfig commonConfig) {
        System.out.println("===============MockBean Build==============");

        this.commonConfig = commonConfig;
    }

    public String getName(){
        return this.commonConfig.getName();
    }

    public String getAddress(){
        return this.commonConfig.getAddress();
    }
}

package apodemas.apollolab.common;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * @author caozheng
 * @time 2019-03-28 09:35
 **/
public class CommonApplication {

    /**
     * 不依赖于spring，如果未配置meta server则会返回默认值。
     * 运行期间可以获取portal进行的配置修改。
     * @param args
     */
    public static void main(String[] args) throws Exception{
//        System.setProperty("app.id", "common");
//        System.setProperty("apollo.meta", "http://127.0.0.1:9001/");
        Config config = ConfigService.getAppConfig();
        while(true) {
            String a = config.getProperty("a", null);
            System.out.println(a);
            Thread.sleep(5000);
        }
    }
}

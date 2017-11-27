package user.zc;

import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

/**
 * @description：启动程序
 * @author：zhouchuang
 * @date：2017-11-15:06
 */
public class MainSetup  implements Setup {
    @Override
    public void init(NutConfig nc) {
        System.out.println("init...");
    }
    @Override
    public void destroy(NutConfig nc) {
        System.out.println("destroy...");
    }
}

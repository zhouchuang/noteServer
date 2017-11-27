package user.zc;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * @description：Hello测试
 * @author：zhouchuang
 * @date：2017-11-10:01
 */
@SetupBy(value=MainSetup.class)
@IocBy(type=ComboIocProvider.class, args={  "*anno", "user.zc"})
@Modules
public class MainModule {
    @At("/hello")
    @Ok("jsp:jsp.hello")
    public String doHello() {
        return "Hello Nutz";
    }
}


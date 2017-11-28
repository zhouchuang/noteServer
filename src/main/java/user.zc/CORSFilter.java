package user.zc;

/**
 * @description：跨域访问
 * @author：zhouchuang
 * @date：2017-11-11:47
 */

import org.nutz.ioc.loader.annotation.IocBean;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//拦截器添加跨域支持（如果是web.xml配置拦截器，请将@component删除）
@IocBean
public class CORSFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
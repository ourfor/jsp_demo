package filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        filterName="logFilter",
        urlPatterns={
        "/*"
        })
public class getUserInfo implements Filter {
    private FilterConfig config;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ServletContext context = servletRequest.getServletContext();

        long start = System.currentTimeMillis();

        System.out.println("远程访问用户的ip:"+request.getRemoteHost());
        System.out.println("远程用户请求的链接为:"+request.getRequestURL());
        System.out.println("发起请求的类型为:"+request.getMethod());

        context.log("ContextLog: 用户的ip地址为:"+request.getRemoteHost());
        context.log("ContextLog: 用户请求的资源为:"+request.getRequestURI());

        long end = System.currentTimeMillis();

        System.out.println("总耗时: "+(end - start));

        filterChain.doFilter(request,servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void destroy() {
        this.config = null;
    }
}

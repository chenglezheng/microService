package com.clz.xp.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(urlPatterns = "/*",filterName ="hystrixFilter")
@Configuration
public class HystrixFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context=HystrixRequestContext.initializeContext();
        try{
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            context.close();
        }
    }

    public void destroy() {

    }
}

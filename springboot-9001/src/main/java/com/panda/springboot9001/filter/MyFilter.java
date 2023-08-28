package com.panda.springboot9001.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
// 1. 使用 @WebFilter 需要在启动类上使用@ServletComponentScan注解
// 2. 直接使用 @Component
@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("=====================MyFilter.doFilter==================================");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("=====================MyFilter.init==================================");
    }
}

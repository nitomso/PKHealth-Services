package com.prokarma.health.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nitin Somani
 */
@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityFilter implements Filter {

    private static final boolean CONDITION = true;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("doFilter");
    	
    	chain.doFilter(request, response);
    	HttpServletResponse response1 = (HttpServletResponse) response;
        response1.setHeader("X-Clacks-Overhead", "GNU Terry Pratchett");
       /* if(CONDITION==true)
            chain.doFilter(request,response);
        else{
            ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }*/

    }

    @Override
    public void destroy() {

    }
}

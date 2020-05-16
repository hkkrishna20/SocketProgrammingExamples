package com.views.filterinterceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component

//@WebFilter("/student/**")
public class DawsonApiFilter extends GenericFilterBean {
	public static final String X_CLACKS_OVERHEAD = "X-Clacks-Overhead";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        
    	System.out.println("doFilter() method is invoked");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		System.out.println("Context path is  " + httpServletRequest.getContextPath());
		chain.doFilter(httpServletRequest, httpServletResponse);
		System.out.println("doFilter() method is ended");
		System.out.println("Remote Host:" + request.getRemoteHost());
		System.out.println("Remote Address:" + request.getRemoteAddr());
		HttpServletResponse res = (HttpServletResponse) response;
		((HttpServletResponse) res).setHeader(X_CLACKS_OVERHEAD, "GNU Terry Pratchett");
		chain.doFilter(request, response);
        if (req.getHeader("x-dawson-nonce") == null || req.getHeader("x-dawson-signature") == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setContentType("application/json");
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Required headers not specified in the request");
            return;
        }
        chain.doFilter(request, response);
    }
}
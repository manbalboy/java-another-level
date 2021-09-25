package com.manbalboy.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 전처리
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper(
                (HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper(
                (HttpServletResponse) servletResponse);


        String url = httpServletRequest.getRequestURI();


        filterChain.doFilter(httpServletRequest, httpServletResponse);

        // 후처리

        // ContentCachingRequestWrapper tofilter 후에 찍어야한다. getContentAsByteArray
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);
        String resContent = new String(httpServletResponse.getContentAsByteArray());

        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);

    }
}

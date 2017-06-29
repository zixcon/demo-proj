package com.learning.demo.web.global.filter;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * 增加追踪日志标示
 * Created by topaz on 2017/6/29.
 */
@Slf4j
public class TrackLogFilter implements Filter {

    private static final String TRACK_ID = "trackid";
    private static final String LOCAL_HOST_NAME = "hostname";
    private static String HOST_NAME = "UNKNOWN";

    public TrackLogFilter() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            HOST_NAME = inetAddress.getHostAddress() + inetAddress.getHostName();
        } catch (UnknownHostException e) {
            log.error("can't get localhost address {}",e.getMessage(),e);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String trackId ;
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            trackId = httpServletRequest.getHeader(TRACK_ID);
            if (Strings.isNullOrEmpty(trackId)) {
                trackId = UUID.randomUUID().toString();
            }
        } else {
            trackId = UUID.randomUUID().toString();
        }

        // NDC和MDC是log4j用于存储应用程序的上下文信息（context infomation），从而便于在log中使用这些上下文信息。
        // NDC采用了一个类似栈的机制来push存储上下文信息，每一个线程都独立地储存上下文信息。相应的PatternLayout中使用”%x”来输出存储的上下文信息
        // MDC内部使用了类似map的机制来存储信息,相应的PatternLayout中%x{key}来输出对应的value
        try {
            MDC.put(TRACK_ID, trackId);
            MDC.put(LOCAL_HOST_NAME, HOST_NAME);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {

    }
}

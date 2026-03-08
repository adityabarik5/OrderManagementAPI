package com.practice.orderapp.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter implements Filter {

    private static final String CORRELATION_ID = "CID";
    private static final String HEADER_NAME = "X-Correlation-ID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {

            HttpServletRequest httpRequest = (HttpServletRequest) request;

            String cid = httpRequest.getHeader(HEADER_NAME);

            if (cid == null || cid.isEmpty()) {
                cid = UUID.randomUUID().toString();
            }

            MDC.put(CORRELATION_ID, cid);

            chain.doFilter(request, response);

        } finally {

            MDC.remove(CORRELATION_ID); //This is extremely important because Spring Boot uses thread pools. Without clean up you get MDC memory leaks

        }
    }
}

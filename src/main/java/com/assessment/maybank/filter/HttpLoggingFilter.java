package com.assessment.maybank.filter;

import com.assessment.maybank.filter.model.RequestReponseAudit;
import com.assessment.maybank.filter.repository.RequestResponseAuditRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.Date;

@Component
public class HttpLoggingFilter extends OncePerRequestFilter {
    @Autowired
    RequestResponseAuditRepository requestResponseAuditRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(contentCachingRequestWrapper,contentCachingResponseWrapper);

        long apiTakenTime = System.currentTimeMillis() - startTime;

        String requestBody = getStringValue(contentCachingRequestWrapper.getContentAsByteArray(), request.getCharacterEncoding());
        String responseBody = getStringValue(contentCachingResponseWrapper.getContentAsByteArray(), response.getCharacterEncoding());

        try{
            requestResponseAuditRepository.save(new RequestReponseAudit(null,request.getRequestURI(),requestBody ,responseBody, apiTakenTime, new Date()));
        }catch (Exception e){
            logger.error("failed save requestResponseAudit");
        }

        contentCachingResponseWrapper.copyBodyToResponse();
    }

    private String getStringValue(byte[] contentArray, String characterEncoding){
        try{
            return new String(contentArray,0, contentArray.length, characterEncoding);
        }catch (Exception e){
            logger.error(e,e);
        }
        return "";
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
            throws ServletException {
        String path = request.getRequestURI();

        return path.contains("swagger") || path.contains("v3");
    }
}

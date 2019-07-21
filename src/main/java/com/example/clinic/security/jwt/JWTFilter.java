package com.example.clinic.security.jwt;


import com.example.clinic.common.BaseResponse;
import com.example.clinic.untility.ObjectMapperUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filters incoming requests and installs a Spring Security principal if a header corresponding to a valid user is
 * found.
 */
public class JWTFilter extends OncePerRequestFilter {


    private TokenProvider tokenProvider;

    public JWTFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            String jwt = resolveToken(httpServletRequest);
            String path = httpServletRequest.getServletPath();
            if (StringUtils.hasText(jwt)) {
                if (this.tokenProvider.validateToken(jwt, path)) {
                    Authentication authentication = this.tokenProvider.getAuthentication(jwt);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception eje) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            BaseResponse result = new BaseResponse();
            result.fail("9000","Authen Fail");
            String resultJson = ObjectMapperUtils.convertObjectToJSON(result);
            httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(resultJson);
        }
    }

    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(JWTConfigurer.AUTHORIZATION_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
}

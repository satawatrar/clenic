package com.example.clinic.config;



import com.example.clinic.security.AuthoritiesConstants;
import com.example.clinic.security.Http401UnauthorizedEntryPoint;
import com.example.clinic.security.Http403AccessDeniedHandler;
import com.example.clinic.security.jwt.JWTConfigurer;
import com.example.clinic.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Http401UnauthorizedEntryPoint authenticationEntryPoint;
    private final Http403AccessDeniedHandler http403AccessDeniedHandler;
    private final TokenProvider tokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(http403AccessDeniedHandler)
                .and()
                .csrf()
                .disable()
                .antMatcher("/clinic/signup")
                .antMatcher("/clinic/login")
                .antMatcher("/clinic/fill-up-detail")
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/health").permitAll()
                .antMatchers("/info").permitAll()
                .antMatchers("/api/version").permitAll()
                .antMatchers("/caches").permitAll()
                .antMatchers("/metrics").permitAll()
                .antMatchers("/actuator/metrics").permitAll()
               //Internal use by cron to active sync utiba
                .antMatchers("/**").hasAuthority(AuthoritiesConstants.TMX)
                .and()
                .apply(new JWTConfigurer(tokenProvider));

    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}
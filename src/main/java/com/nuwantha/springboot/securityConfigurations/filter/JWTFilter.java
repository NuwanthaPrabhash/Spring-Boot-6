package com.nuwantha.springboot.securityConfigurations.filter;

import com.nuwantha.springboot.securityConfigurations.service.JWTService;
import com.nuwantha.springboot.securityConfigurations.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * in filter chain we want to execute only once for every request. that is why we use "OncePerRequestFilter".
 */
@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final ApplicationContext applicationContext; // to get the object from Spring. we did in the very beginning of the project


    public JWTFilter(JWTService jwtService, ApplicationContext applicationContext) {
        this.jwtService = jwtService;
        this.applicationContext = applicationContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = this.jwtService.extractUsername(token);
        }

        /**
         * check username is not null and it is not already authenticated by checking Authentication() == null.
         * if it is not null that means this is already authenticated.
         */
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = applicationContext.getBean(MyUserDetailsService.class)
                    .loadUserByUsername(username); // get the user details from our database

            if (this.jwtService.validateToken(token, userDetails)) {
                /**
                 * after validating the token we have to call username password authentication filter but we have to pass
                 * token to it. to here we are getting the token.
                 */
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                /**
                 * authToken need to know about request object also. so we have to pass it too
                 */
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                /**
                 * now we have to set the authentication in context. It was not there. that is why we get null when we call the
                 * if condition in above when check SecurityContextHolder.getContext().getAuthentication()
                 */
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("token expired");
            }
        }

        /**
         * telling that this filter part is ok, go to the next filter
         */
        filterChain.doFilter(request, response);

    }
}

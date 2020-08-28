//package com.example.demo.filter;
//
//import com.example.demo.model.TblUsers;
//import com.example.demo.service.impl.TokenAuthenticationService;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collections;
//
//public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
//    public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
//        super(new AntPathRequestMatcher(url));
//        setAuthenticationManager(authenticationManager);
//    }
//
//    public JWTLoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
//        super(requiresAuthenticationRequestMatcher);
//    }
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        TokenAuthenticationService.addAuthentication(response, authResult.getName());
//    }
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
//        TblUsers credentials = new TblUsers(httpServletRequest.getParameter("username"), httpServletRequest.getParameter("password"));
//        return getAuthenticationManager().authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        credentials.getUserName(),
//                        credentials.getPassword(),
//                        Collections.emptyList()
//                )
//        );
//    }
//}

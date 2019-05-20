package com.stackroute.zuulservice.filter;

import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    final HttpServletRequest request = (HttpServletRequest) servletRequest;
    final HttpServletResponse response = (HttpServletResponse) servletResponse;

    final String authHeader = request.getHeader("authorization");

    if("OPTIONS".equals(request.getMethod())){
      response.setStatus(HttpServletResponse.SC_OK);
      filterChain.doFilter(request,response);
    }else {

      System.out.println(" Option not eqal to get " + authHeader);

      if(authHeader ==null || !authHeader.startsWith("Bearer")) {
        System.out.println(" authheader is null " );
        throw new ServletException("Missing or Invalid Authorization token");
      }

      final String token = authHeader.substring(7);
      final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
      request.setAttribute("claims", claims);

      filterChain.doFilter(request,response);
      System.out.println(" Fileter is done " );
    }
  }
}

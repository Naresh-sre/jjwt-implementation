package com.juniorro.jjwtimplementation.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain finterChain)
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", SecurityConstants.CLIENT_DOMAIN_URL);
		
		response.addHeader("Access-Control-Allow-Headers", 
				"Origin, Accept, X-Requested-With, "
				+ "Content-Type, Access-Control-Request-Method, "
				+ "Access-Control-Request-Headers, Authorization");
		
		response.addHeader("Access-Control-Expose-Headers", 
				"Access-Control-Allow-Origin, "
				+ "Access-Control-Allow-Creentials, "
				+ "Authorization");
		
		if ((request.getMethod().equalsIgnoreCase("OPTIONS"))) {
			try {
				response.setStatus(HttpServletResponse.SC_OK);
			} catch (Exception e) {
				e.printStackTrace();
				}
			} else {
				String jwtToken = request.getHeader(SecurityConstants.HEADER_TYPE);
				if(jwtToken == null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
					finterChain.doFilter(request, response);
					return;
				}	
				Claims claims = Jwts.parser()
						.setSigningKey(SecurityConstants.SECRET)
						.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, ""))
						.getBody();
				String username = claims.getSubject();
				ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				roles.forEach(role->
					authorities.add(new SimpleGrantedAuthority(role.get("authority"))));
				UsernamePasswordAuthenticationToken authenticatedUser = new UsernamePasswordAuthenticationToken(
						username, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
				finterChain.doFilter(request, response);
			}		
	}
}

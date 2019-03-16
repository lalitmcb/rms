package com.rms.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticaionFilter extends UsernamePasswordAuthenticationFilter {
	
	AuthenticationManager authenticationManager;

	public JWTAuthenticaionFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			LoginVO loginVO = new ObjectMapper().readValue(req.getInputStream(), LoginVO.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVO.getEmail(),
					loginVO.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new BadCredentialsException("Bad credentials",e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String token = Jwts.builder().setSubject(((User) auth.getPrincipal()).getUsername())
				                     .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				                     .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
				                     .compact();
               	String tokenData = "{\""  + SecurityConstants.HEADER_STRING + "\":\"" + SecurityConstants.TOKEN_PREFIX + token + "\"}";
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(tokenData);
		response.getWriter().flush();
		response.getWriter().close();
		//response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	}

}

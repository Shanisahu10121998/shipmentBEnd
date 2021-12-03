package com.shipmenttracking.shipmenttracking.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.shipmenttracking.shipmenttracking.service.impl.UserDetailServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Autowired
	private JwtUtils jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("inside @class JwtAuthenticationFilter @method doFilterInternal");

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);

			try {

				username = this.jwtUtil.extractUsername(jwtToken);

			} catch (ExpiredJwtException e) {
				e.printStackTrace();
            log.info("jwt token has expired "+e.getMessage());
			
			} catch (Exception e) {
				e.printStackTrace();

				log.info("user not found of this token");
			}
		} else {
			log.info("Invalid token, not started with bearer string");

		}
		//validated
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			final UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

			if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
				// token is valid

				UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		} else {
			log.info("Invalid token");
		}

		filterChain.doFilter(request, response);
	}

}

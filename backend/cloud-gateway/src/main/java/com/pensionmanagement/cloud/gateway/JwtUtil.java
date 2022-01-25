package com.pensionmanagement.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

	private String jwtSecret="secret";

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public void validateToken(final String token) throws Exception {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		} catch (SignatureException ex) {
			
		}
	}

}

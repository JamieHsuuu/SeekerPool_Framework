package com.jamie.core.util;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

//	private static final long EXPIRATION_TIME = 1 * 60 * 1000;
	
	private static final String SECRET_KEY = "HARU IS KAWAII";
	
	public static String generateToken(String comMemAccount) {
        return Jwts.builder()
            .setSubject(comMemAccount)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 設定1天後到期
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }

    public static String validateToken(String token) {
        return Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
    
}

package com.example.api.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "minha-chave-secreta-para-jwt-que-tem-mais-de-32-caracteres";

    private static final Key SECRET = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("api")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
                .signWith(SECRET, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims validateToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

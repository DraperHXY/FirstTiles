package com.draper.service.security.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private Map<String, Object> header, claims;
    private SignatureAlgorithm signatureAlgorithm;

    public JWTUtil(Map<String, Object> claims, SignatureAlgorithm signatureAlgorithm) {
        this.claims = claims;
        this.signatureAlgorithm = signatureAlgorithm;
    }

    private Key key;

    public String buildJwts() {
        key = Keys.secretKeyFor(signatureAlgorithm);
        String jwts = Jwts.builder()
                .setClaims(claims)
                //在这里其实可以覆写 key 和重新选择算法
                .signWith(key,signatureAlgorithm)
                .compact();
        return jwts;
    }

    public boolean verifyJwts(String jwts) {

        return false;
    }

    public static void main(String[] args) {
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("admin", "Draper");

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("sub", "Draper");
        String jwts = new JWTUtil(claims, SignatureAlgorithm.HS512).buildJwts();
        System.out.println(jwts);

    }
}

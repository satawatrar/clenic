package com.example.clinic.security.jwt;


import com.example.clinic.security.AuthoritiesConstants;
import com.example.clinic.security.UserInfo;
import com.example.clinic.untility.ObjectMapperUtils;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class TokenProviderV3 extends TokenProvider {


    public Authentication getAuthentication(String token) throws IOException {
        UserInfo principal;
        Collection<SimpleGrantedAuthority> authorities;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            String json = ObjectMapperUtils.convertObjectToJSON(claims);
            principal = ObjectMapperUtils.convertJSONToObject(json, UserInfo.class);

            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.TMX));
        } catch (Exception ex) {
            throw ex;
        }
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public boolean validateToken(String authToken, String path) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
            Jws jws = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(authToken);

            boolean isOtpRequired = (boolean) jws.getHeader().get(OTP_REQUIRED);
            boolean isOtpStatus = (boolean) jws.getHeader().get(OTP_STATUS);

            if (!isBypassApi(path)) {
                if (isOtpRequired && !isOtpStatus) {
                    return false;
                }
            }
            return true;
        } catch (SignatureException | MalformedJwtException | NullPointerException e) {
            return false;
        } catch (ClaimJwtException e) {
            throw e;
        }
    }
}

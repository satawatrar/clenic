package com.example.clinic.security.jwt;



import com.example.clinic.security.AuthoritiesConstants;
import com.example.clinic.security.UserInfo;
import com.example.clinic.untility.ObjectMapperUtils;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Service
public class TokenProvider {


    static final String OTP_REQUIRED = "otp_required";
    static final String OTP_STATUS = "otp_status";
    static final String CHANNEL = "channel";


    String SECRET_KEY = "5a4c7688d52330ea7c2e31984a853fe91492fb58";


    public Authentication getAuthentication(String token) throws IOException {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        String json = ObjectMapperUtils.convertObjectToJSON(claims);
        UserInfo principal = ObjectMapperUtils.convertJSONToObject(json, UserInfo.class);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(AuthoritiesConstants.TMX));
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }


    public boolean validateToken(String authToken)  {
        return validateToken(authToken,"");
    }

    public boolean validateToken(String authToken,String path) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
            Jws jws = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(authToken);

            return true;
        } catch (SignatureException e) {

            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (NullPointerException e){
            return false;
        }
    }

    public boolean isBypassApi(String path){
        //TODO refactor com.tmx.framework.config
        return "/api/v1/otp-success".contains(path);
    }

    public String builderJWT(UserInfo user, String channel, boolean otpRequired, long validityInSeconds) throws IOException {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setHeaderParam(OTP_REQUIRED, otpRequired)
                .setHeaderParam(OTP_STATUS, false)
                .setHeaderParam(CHANNEL,channel)
                .setClaims(ObjectMapperUtils.convertObjectToMap(user))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setExpiration(getValidity(validityInSeconds))
                .compact();
    }

    public String reNewJWT(String token,long validityInSeconds) throws IOException {
        if (StringUtils.hasText(token)) {
            if (validateToken(token)) {
                Jws jws = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token);
                Claims claims = (Claims) jws.getBody();
                return Jwts.builder()
                        .setSubject(claims.getSubject())
                        .setHeader((Map<String, Object>) jws.getHeader())
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                        .setExpiration(getValidity(validityInSeconds))
                        .compact();
            }
        }
        return "";
    }

    public String setJwtSuccessOtp(String token,long validityInSeconds) throws IOException {
        if (StringUtils.hasText(token)) {
            if (validateToken(token)) {

                Jws jws = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token);
                Claims claims = (Claims) jws.getBody();
                return Jwts.builder()
                        .setSubject(claims.getSubject())
                        .setHeader((Map<String, Object>) jws.getHeader())
                        .setHeaderParam(OTP_STATUS, true)
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                        .setExpiration(getValidity(validityInSeconds))
                        .compact();
            }
        }
        return "";
    }

    public String getChannel(String token){
        return (String) Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getHeader().get(CHANNEL);
    }

    private Date getValidity(long validityInSeconds) {
        long now = (new Date()).getTime();
        return new Date(now + (1000 * validityInSeconds));
    }
}

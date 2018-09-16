package jp.nmemoto.todo.constant;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConstants {
    public static final Key SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/users/signup";
    public static final String SIGN_IN_URL = "/api/v1/users/signin";

}

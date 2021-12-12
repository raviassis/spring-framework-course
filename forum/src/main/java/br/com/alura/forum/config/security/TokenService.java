package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        var loggedUser = (Usuario) authentication.getPrincipal();
        var hoje = new Date();
        var dateExpiration = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                    .setIssuer("API do fórum da Alura")
                    .setSubject(loggedUser.getId().toString())
                    .setIssuedAt(hoje)
                    .setExpiration(dateExpiration)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
    }
}

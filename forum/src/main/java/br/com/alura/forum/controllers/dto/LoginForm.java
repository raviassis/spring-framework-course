package br.com.alura.forum.controllers.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Data
public class LoginForm {
    private String email;
    private String senha;

    public Authentication converter() {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}

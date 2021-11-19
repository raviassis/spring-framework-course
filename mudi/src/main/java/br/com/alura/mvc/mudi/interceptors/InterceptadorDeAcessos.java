package br.com.alura.mvc.mudi.interceptors;

import lombok.Data;
import lombok.Getter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InterceptadorDeAcessos extends HandlerInterceptorAdapter {
    @Getter
    private static List<Acesso> acessos = new ArrayList<>();
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        var acesso = (Acesso) request.getAttribute("acesso");
        acesso.setDuracao(Duration.between(acesso.getData(), LocalDateTime.now()));
        this.acessos.add(acesso);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var acesso = new Acesso();
        acesso.setPath(request.getRequestURI());
        acesso.setData(LocalDateTime.now());
        request.setAttribute("acesso", acesso);
        return true;
    }

    @Data
    public static class Acesso {
        private String path;
        private LocalDateTime data;
        private Duration duracao;
    }
}

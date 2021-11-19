package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.interceptors.InterceptadorDeAcessos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alura.mvc.mudi.interceptors.InterceptadorDeAcessos.Acesso;
import java.util.List;

@RestController
@RequestMapping("acessos")
public class AcessosRest {
    @GetMapping
    public List<Acesso> getAcessos() {
        return InterceptadorDeAcessos.getAcessos();
    }
}

package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {
    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        var topico = new Topico(
                "Dúvida",
                "Dúvida com Spring",
                new Curso(
                        "Spring",
                        "Programação"
                )
        );
        return TopicoDto.converter(Arrays.asList(
                topico,
                topico,
                topico
        ));
    }
}

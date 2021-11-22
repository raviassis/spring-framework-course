package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(String nomeCurso) {
        System.out.println(nomeCurso);
        List<Topico> topicos;
        if (nomeCurso != null) {
            topicos = topicoRepository.findByCursoNome(nomeCurso);
        } else {
            topicos = topicoRepository.findAll();
        }
        return TopicoDto.converter(topicos);
    }
}

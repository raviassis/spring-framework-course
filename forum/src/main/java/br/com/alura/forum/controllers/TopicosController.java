package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dto.TopicoDto;
import br.com.alura.forum.controllers.dto.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
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

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(
        @RequestBody @Valid TopicoForm form,
        UriComponentsBuilder uribuilder
    ) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uribuilder.path("/topicos/{id}").build(topico.getId());
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}
